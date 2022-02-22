package com.hackeranushi.grocerywalla.AdminPanel;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.hackeranushi.grocerywalla.Helper.GroceryProgress;
import com.hackeranushi.grocerywalla.MainActivity;
import com.hackeranushi.grocerywalla.R;
import com.skydoves.elasticviews.ElasticButton;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AdminHome extends AppCompatActivity {

    Uri imageUri;
    ImageView pickImage, profile;
    EditText catName;
    ElasticButton load;
    FirebaseFirestore database;
    private static String pId;
    String img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        pickImage = findViewById(R.id.pickImage);
        catName = findViewById(R.id.catName);
        load = findViewById(R.id.load);
        profile = findViewById(R.id.profile);
        database = FirebaseFirestore.getInstance();



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("New Products");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        pId = UUID.randomUUID().toString();
        Log.d("docID",pId);

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadData();
            }
        });

        ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                if (result!=null)
                {
                    profile.setImageURI(result);
                    imageUri = result;
                }
            }
        });

        pickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGetContent.launch("image/*");
            }
        });
    }

//    private void uploadDataFirebase() {
//        String name = catName.getText().toString();
//
//        Map<String, Object> user_data = new HashMap<>();
//        user_data.put("user_name",name);
//        user_data.put("user_img",img);
//        user_data.put("doc_Id","");
//
//
//
//        database.collection("CATEGORIES").add(user_data)
//                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
//                    @Override
//                    public void onComplete(@NonNull Task<DocumentReference> task) {
//                        if (task.isSuccessful())
//                        {
//                            Log.d("docId",pId);
//                            catName.setText("");
//                        }
//                    }
//                });
//
//    }

    private void uploadData() {
        GroceryProgress.progressDialog(AdminHome.this).setMessage("Please wait...");

        if (imageUri!=null) {
            String name = catName.getText().toString();

            String filePath = "cat_product/" + "cat_image/" + UUID.randomUUID();
            Log.d("docID",UUID.randomUUID().toString());
            StorageReference storageReference = FirebaseStorage.getInstance().getReference().child(filePath);
            storageReference.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                    if (!uriTask.isSuccessful()) {
                        while (!uriTask.isSuccessful()) ;
                    }
                    Uri downloadUri = uriTask.getResult();
                    if (uriTask.isSuccessful())
                    {
                        Map<String, Object> user_data = new HashMap<>();
                        user_data.put("cat_name", name);
                        user_data.put("cat_img", downloadUri.toString());

                        FirebaseFirestore.getInstance().collection("CATEGORIES").add(user_data)
                                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                    @Override
                                    public void onComplete(@NonNull Task<DocumentReference> task) {
                                        if (task.isSuccessful())
                                        {
                                            GroceryProgress.stop();
                                            catName.setText("");
                                        }
                                    }
                                });
                    }
                }
            });
        }
    }
}