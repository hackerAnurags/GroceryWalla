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
import com.hackeranushi.grocerywalla.MainActivity;
import com.hackeranushi.grocerywalla.R;
import com.skydoves.elasticviews.ElasticButton;

import java.util.HashMap;
import java.util.Map;

public class AdminHome extends AppCompatActivity {

    Uri imageUri;
    ImageView pickImage, profile;
    EditText catName;
    ElasticButton load;
    FirebaseFirestore database;
    private static String pId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        pickImage = findViewById(R.id.pickImage);
        catName = findViewById(R.id.catName);
        load = findViewById(R.id.load);
        profile = findViewById(R.id.profile);
        database = FirebaseFirestore.getInstance();

        pId = database.collection("CATEGORIES").document().getId();
        Log.d("firstId",pId);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("New Products");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadDataFirebase();
                uploadImageFirebase();

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

    private void uploadDataFirebase() {
        String name = catName.getText().toString();

        Map<String, Object> user_data = new HashMap<>();
        user_data.put("user_name",name);
        user_data.put("user_img","");



        database.collection("CATEGORIES").add(user_data)
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful())
                        {
                            Log.d("secondId",pId);
                            catName.setText("");
                        }
                    }
                });

    }

    private void uploadImageFirebase() {
        if (imageUri!=null)
        {
            String filePath = "CATEGORIES/"+"PRODUCTS/"+pId;
            Log.d("thirdId",pId);
            StorageReference reference = FirebaseStorage.getInstance().getReference().child(filePath);
            reference.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                    while(!uriTask.isSuccessful());
                    Uri downloadUri = uriTask.getResult();
                    Log.d("imageFinalUri",uriTask.getResult().toString());
                    if(uriTask.isSuccessful()) {
                        DocumentReference _ref = database.collection("CATEGORIES").document(pId);
//                        Log.d("specificPath",String.valueOf(FirebaseFirestore.getInstance().collection("").document(pId)));
                        Log.d("fourthId",pId);
                        _ref.update("user_img", downloadUri.toString()).isSuccessful();
                        Log.d("specificImage",String.valueOf(_ref.update("user_img", downloadUri.toString()).isSuccessful()));

                    }
                }
            });
        }

    }
}