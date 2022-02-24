package com.hackeranushi.grocerywalla.AdminPanel.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.hackeranushi.grocerywalla.Helper.GroceryProgress;
import com.hackeranushi.grocerywalla.R;
import com.skydoves.elasticviews.ElasticButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class BannerUploads extends Fragment {
    ViewPager viewPager;
    ElasticButton load,pickImage;
    private ArrayList<Uri> ImageList = new ArrayList<Uri>();
    private FirebaseFirestore database;
    TextView status,statusImg;
    private int uploads = 0;

    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        assert intent != null;
                        if (intent.getClipData() != null) {
                            int count = intent.getClipData().getItemCount();

                            int CurrentImageSelect = 0;

                            while (CurrentImageSelect < count) {
                                Uri imageuri = intent.getClipData().getItemAt(CurrentImageSelect).getUri();
                                ImageList.add(imageuri);
                                CurrentImageSelect = CurrentImageSelect + 1;
                            }
                            status.setText("You Have Selected "+ ImageList.size() +" Pictures" );
                        }
                    }
                    // Handle the Intent
                }
            });


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_banner_uploads, container, false);

        pickImage = view.findViewById(R.id.pickImage);
        load = view.findViewById(R.id.load);
        status= view.findViewById(R.id.status);
        statusImg= view.findViewById(R.id.statusUri);

        database = FirebaseFirestore.getInstance();

        pickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                mStartForResult.launch(intent);
            }

        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadData();
            }
        });

        return view;
    }

    private void uploadData() {
        GroceryProgress.progressDialog(getActivity()).setMessage("Please wait...");
        String filePath = "customer_images/" + "account_image_" + UUID.randomUUID();
        Log.d("docID", UUID.randomUUID().toString());
        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child(filePath);
        for (uploads = 0; uploads < ImageList.size(); uploads++) {
            Uri Image = ImageList.get(uploads);
            final StorageReference imagename = storageReference.child("image/" + Image.getLastPathSegment());

            imagename.putFile(ImageList.get(uploads)).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    imagename.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {

                            String url = String.valueOf(uri);
                            SendLink(url);
                        }
                    });

                }
            });
        }
    }

    private void SendLink(String url) {
        HashMap<String, String> user_data = new HashMap<>();
        user_data.put("link", url);

        FirebaseFirestore.getInstance().collection("Array_Images").add(user_data)
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        if (task.isSuccessful())
                        {
                            GroceryProgress.stop();
                            statusImg.setText("Success");
                        }
                    }
                });
    }
}