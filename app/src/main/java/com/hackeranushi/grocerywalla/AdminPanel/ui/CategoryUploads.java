package com.hackeranushi.grocerywalla.AdminPanel.ui;

import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.hackeranushi.grocerywalla.Helper.GroceryProgress;
import com.hackeranushi.grocerywalla.R;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CategoryUploads extends Fragment {

    Uri imageUri;
    ImageView profile;
    EditText catName,index;
    TextView pickImage, load;
    FirebaseFirestore database;
    private static String pId;
    String img;
    Button logOut;
    FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_category_uploads, container, false);
        pickImage = view.findViewById(R.id.pickImage);
        catName = view.findViewById(R.id.catName);
        logOut = view.findViewById(R.id.logout);
        load = view.findViewById(R.id.load);
        profile = view.findViewById(R.id.profile);
        index = view.findViewById(R.id.index);
        database = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

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


        return view;
    }

    private void uploadData() {

        GroceryProgress.progressDialog(getActivity()).setMessage("Please wait...");

        if (imageUri!=null) {
            String name = catName.getText().toString();
            String p_index = index.getText().toString();

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
                        user_data.put("index", p_index);
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
                                            index.setText("");
                                            Toast.makeText(getContext(),
                                                    "Item is successfully uploaded ",
                                                    Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                }
            });
        }

    }
}