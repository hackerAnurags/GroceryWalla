package com.hackeranushi.grocerywalla.ProfileActivity.EditProfileActivity;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.hackeranushi.grocerywalla.R;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class EditProfile extends AppCompatActivity {
    ImageView pickImage;
    CircleImageView profileImage;
    RadioGroup radioGroup;
    RadioButton radio_btn1 , radio_btn2, rb;
    EditText edit_name,edit_email,edit_mob,edit_dob;
    Button saved_profile;
    Uri imageUri;
    byte[] bitmapbytes;
    FirebaseAuth auth;
    String fname,femail,fmob,fimage;
    Context ctx;
    FirebaseUser user;
    String uid;
    StorageReference storageReference;
    String value;
    FirebaseStorage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        pickImage = findViewById(R.id.pick_image);
        profileImage = findViewById(R.id.profile_image);
        radio_btn1=findViewById(R.id.btn1_sex);
        radio_btn2=findViewById(R.id.btn2_sex);
        radioGroup=findViewById(R.id.radio_group);
        edit_name=findViewById(R.id.fragName);
        edit_email=findViewById(R.id.frag_email);
        edit_mob=findViewById(R.id.frag_mob);
        edit_dob=findViewById(R.id.frag_dob);
        saved_profile=findViewById(R.id.saved_profile);

        storage =  FirebaseStorage.getInstance();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Edit Profile");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ActivityResultLauncher <String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                profileImage.setImageURI(result);
            }
        });

        pickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGetContent.launch("image/*");
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb = (RadioButton)findViewById(checkedId);
                value = rb.getText().toString();
            }
        });

        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();

        FirebaseFirestore.getInstance().collection("users").document(uid).get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (!documentSnapshot.exists())
                        {
                            Log.d("No Exist","List is empty");
                            return;
                        }
                        else
                        {
                            fname = documentSnapshot.get("user_name").toString();
                            femail = documentSnapshot.get("user_email").toString();
                            fmob = documentSnapshot.get("user_mob").toString();
                            fimage = documentSnapshot.get("user_img").toString();

                            edit_name.setText(fname);
                            edit_email.setText(femail);
                            edit_mob.setText(fmob);
                            setImage();
                        }
                    }
                });

        saved_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DocumentReference _ref = FirebaseFirestore.getInstance().collection("users").document(uid);

                String dob = edit_dob.getText().toString().trim();
                Map<String,Object> edited=new HashMap<>();
                edited.put("user_dob",dob);
                edited.put("user_gender",value);

                Toast.makeText(getApplicationContext(), "Profile update", Toast.LENGTH_SHORT).show();
                if(dob!=null && value!=null) {
                    _ref.update(edited).isSuccessful();
                }

            }
        });
    }

    private void setImage() {
        Glide.with(getApplicationContext()).load(fimage).optionalFitCenter().circleCrop().into(profileImage);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1000 && data.getData() != null){
            if (resultCode== Activity.RESULT_OK){
                imageUri = data.getData();
                profileImage.setImageURI(imageUri);
                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),imageUri);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
                bitmapbytes = byteArrayOutputStream.toByteArray();
                uploadImageToFirebase();
            }
        }

    }

    private void uploadImageToFirebase()  {
        String filePath = "customer_images/"+"account_image_"+uid;
        storageReference = FirebaseStorage.getInstance().getReference().child(filePath);
        storageReference.putBytes(bitmapbytes).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                while(!uriTask.isSuccessful());
                Uri downloadUri = uriTask.getResult();
                if(uriTask.isSuccessful())
                {
                    DocumentReference _ref = FirebaseFirestore.getInstance().collection("users").document(uid);
                    _ref.update("user_img", downloadUri.toString()).isSuccessful();
                    Glide.with(getApplicationContext()).load(downloadUri.toString()).optionalFitCenter().circleCrop().into(profileImage);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}