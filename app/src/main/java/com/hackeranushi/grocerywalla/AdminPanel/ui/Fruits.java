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
import com.skydoves.elasticviews.ElasticButton;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Fruits extends Fragment {
    Uri imageUri;
    EditText pName,pPrice,pRating,pIndex;
    ElasticButton pickImage,saveData;
    ImageView image;
    private FirebaseFirestore database;
    private static String pId;
    String img;
    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_fruits, container, false);

        pickImage = view.findViewById(R.id.pickImage);
        pName = view.findViewById(R.id.p_name);
        pPrice = view.findViewById(R.id.p_price);
        pRating = view.findViewById(R.id.p_rating);
        pIndex = view.findViewById(R.id.p_index);
        saveData = view.findViewById(R.id.saveData);
        image = view.findViewById(R.id.p_image);
        database = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();

        pId = UUID.randomUUID().toString();
        Log.d("docID",pId);

        saveData.setOnClickListener(new View.OnClickListener() {
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
                    image.setImageURI(result);
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
            String productName = pName.getText().toString();
            String productIndex = pIndex.getText().toString();
            String productPrice = pPrice.getText().toString();
            String productRating = pRating.getText().toString();

            String filePath = "home_products/" + "fruits_images/" + UUID.randomUUID();
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
                        user_data.put("p_index", productIndex);
                        user_data.put("p_name", productName);
                        user_data.put("p_price", productPrice);
                        user_data.put("p_rating", productRating);
                        user_data.put("p_img", downloadUri.toString());

                        FirebaseFirestore.getInstance().collection("HomeProducts").document("ProductList").collection("Fruits & Vegetables").add(user_data)
                                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                    @Override
                                    public void onComplete(@NonNull Task<DocumentReference> task) {
                                        if (task.isSuccessful())
                                        {
                                            GroceryProgress.stop();
                                            pName.setText("");
                                            pPrice.setText("");
                                            pRating.setText("");
                                            pIndex.setText("");
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