package com.hackeranushi.grocerywalla.AdminPanel.ui;

import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


public class BabyCare extends Fragment {

    Uri imageUri;
    ElasticButton pickImage,saveData;
    ImageView image;
    private FirebaseFirestore database;
    private static String pId;
    private FirebaseAuth mAuth;
    CardView cardView;
    EditText proName,proPrice,proCutPrice,proOffer,proUnit,proDesc,proKey,proIngredients,proNutrition,
            proShelfLife, proManufacture,proMarkedUp,proDisclaimer,proCountry,proCustomerCare,proSeller,
            proIndex,proRating;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_baby_care, container, false);
        cardView = view.findViewById(R.id.footerCard);
        proName = view.findViewById(R.id.p_name);
        proPrice = view.findViewById(R.id.p_price);
        proCutPrice = view.findViewById(R.id.cutted_price);
        proOffer = view.findViewById(R.id.p_offer);
        proUnit = view.findViewById(R.id.p_unit);
        proDesc = view.findViewById(R.id.p_description);
        proKey = view.findViewById(R.id.key_features);
        proIngredients = view.findViewById(R.id.p_ingredients);
        proNutrition = view.findViewById(R.id.p_nutrition);
        proShelfLife = view.findViewById(R.id.p_life);
        proManufacture = view.findViewById(R.id.p_manufacture);
        proMarkedUp = view.findViewById(R.id.p_markedUp);
        proDisclaimer = view.findViewById(R.id.p_disclaimer);
        proCountry = view.findViewById(R.id.p_country);
        proCustomerCare = view.findViewById(R.id.p_customer_care);
        proSeller = view.findViewById(R.id.p_seller);
        proIndex = view.findViewById(R.id.p_index);
        proRating = view.findViewById(R.id.p_rating);
        pickImage = view.findViewById(R.id.pickImage);
        saveData = view.findViewById(R.id.saveData);
        image = view.findViewById(R.id.p_image);



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

            String pName = proName.getText().toString();
            String pPrice = proPrice.getText().toString();
            String pCutPrice = proCutPrice.getText().toString();
            String pOffer = proOffer.getText().toString();
            String pUnit = proUnit.getText().toString();
            String pDesc = proDesc.getText().toString();
            String pKey = proKey.getText().toString();
            String pIngredients = proIngredients.getText().toString();
            String pNutrition = proNutrition.getText().toString();
            String pShelfLife = proShelfLife.getText().toString();
            String pManufacture = proManufacture.getText().toString();
            String pMarked = proMarkedUp.getText().toString();
            String pDisclaimer = proDisclaimer.getText().toString();
            String pCountry = proCountry.getText().toString();
            String pCustomer = proCustomerCare.getText().toString();
            String pSeller = proSeller.getText().toString();
            String pIndex = proIndex.getText().toString();
            String pRating = proRating.getText().toString();

            String filePath = "home_products/" + "baby_care/" + UUID.randomUUID();
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

                        user_data.put("p_name", pName);
                        user_data.put("p_price", pPrice);
                        user_data.put("p_index", pIndex);
                        user_data.put("p_cut_price", pCutPrice);
                        user_data.put("p_rating", pRating);
                        user_data.put("p_offer", pOffer);
                        user_data.put("p_unit", pUnit);
                        user_data.put("p_desc", pDesc);
                        user_data.put("p_key", pKey);
                        user_data.put("p_ingredients", pIngredients);
                        user_data.put("p_nutrition", pNutrition);
                        user_data.put("p_shelf_life", pShelfLife);
                        user_data.put("p_manufacture", pManufacture);
                        user_data.put("p_marked_by", pMarked);
                        user_data.put("p_disclaimer", pDisclaimer);
                        user_data.put("p_customer_care", pCustomer);
                        user_data.put("p_seller", pSeller);
                        user_data.put("p_country", pCountry);
                        user_data.put("p_img", downloadUri.toString());

                        FirebaseFirestore.getInstance().collection("HomeProducts").document("ProductList").collection("BabyCare").add(user_data)
                                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                    @Override
                                    public void onComplete(@NonNull Task<DocumentReference> task) {
                                        if (task.isSuccessful())
                                        {
                                            GroceryProgress.stop();
                                            proName.setText("");
                                            proPrice.setText("");
                                            proCutPrice.setText("");
                                            proOffer.setText("");
                                            proUnit.setText("");
                                            proDesc.setText("");
                                            proKey.setText("");
                                            proIngredients.setText("");
                                            proNutrition.setText("");
                                            proShelfLife.setText("");
                                            proManufacture.setText("");
                                            proMarkedUp.setText("");
                                            proDisclaimer.setText("");
                                            proCountry.setText("");
                                            proCustomerCare.setText("");
                                            proSeller.setText("");
                                            proIndex.setText("");
                                            proRating.setText("");
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