package com.hackeranushi.grocerywalla.Activities.OtpVerification;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.hackeranushi.grocerywalla.Activities.Authentication;
import com.hackeranushi.grocerywalla.Helper.GroceryConst;
import com.hackeranushi.grocerywalla.Helper.SharedPrefManager;
import com.hackeranushi.grocerywalla.MainActivity;
import com.hackeranushi.grocerywalla.R;
import com.skydoves.elasticviews.ElasticButton;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.UUID;

import de.hdodenhof.circleimageview.CircleImageView;

public class OtpLogDetails extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    CircleImageView profile_image;
    ImageView pick_image;
    TextInputEditText user_name, user_email, userPinCode;
    RadioGroup radioGroup;
    RadioButton radio_btn1, radio_btn2, rb;
    TextView fromDate;
    DatePickerDialog fromDatePicker;
    Calendar calendar;
    int day;
    int month;
    int year;
    String gender,userName,userEmail,pinCode,dateOfBirth;
    ElasticButton submit;
    FirebaseStorage storage;
    Uri imageUri;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private static String uid;
    private String MobileNo;


    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_log_details);

        GroceryConst.sharedPreferences = getSharedPreferences(GroceryConst.sp_name, MODE_PRIVATE);
        GroceryConst.editor = GroceryConst.sharedPreferences.edit();

        fromDate = findViewById(R.id.fromDate);
        radio_btn1=findViewById(R.id.btn1_sex);
        radio_btn2=findViewById(R.id.btn2_sex);
        radioGroup=findViewById(R.id.radio_group);
        submit = findViewById(R.id.submit);
        user_name = findViewById(R.id.userName);
        user_email = findViewById(R.id.userEmail);
        userPinCode = findViewById(R.id.userPinCode);
        pick_image = findViewById(R.id.pick_image);
        profile_image = findViewById(R.id.profile_image);

        MobileNo= getIntent().getStringExtra("phoneNo");

        user = FirebaseAuth.getInstance().getCurrentUser();
        assert user != null;
        uid = user.getUid();

        storage = FirebaseStorage.getInstance();
        mAuth = FirebaseAuth.getInstance();

        fromDate.setOnClickListener(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb = (RadioButton)findViewById(checkedId);
                gender = rb.getText().toString();
            }
        });

        ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                if (result!=null)
                {
                    profile_image.setImageURI(result);
                    imageUri = result;
                }
            }
        });

        pick_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGetContent.launch("image/*");
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImageFirebase();
                uploadDataToFirebase();
                saveDataOnLocalStorage();
            }
        });

        calendar = Calendar.getInstance(TimeZone.getDefault());

        fromDatePicker = new DatePickerDialog(OtpLogDetails.this, this,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));

        LocalDate localDate = LocalDate.now();
        String fd = "" + localDate.withDayOfMonth(1); // 2021-07-01
        String y = fd.substring(0, 4);
        String m = fd.substring(5, 7);
        String d = fd.substring(8, 10);
        Log.d("date", y + m + d);
        fromDate.setText(d + "/" + m + "/" + y);



    }

    private void saveDataOnLocalStorage() {

        FirebaseFirestore.getInstance().collection("users").document("Login").collection("OtpLogin").document(uid).get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (!documentSnapshot.exists())
                        {
                            Log.d("NotExist","List is empty");
                            Toast.makeText(OtpLogDetails.this, "List is not exits", Toast.LENGTH_SHORT).show();
                            return;
                        }else
                        {
                            String name = documentSnapshot.get("user_name").toString();
                            String email = documentSnapshot.get("user_email").toString();
                            String phone = documentSnapshot.get("user_mobile").toString();
                            String dob = documentSnapshot.get("user_dob").toString();
                            String gender = documentSnapshot.get("user_gender").toString();
                            String pin = documentSnapshot.get("user_pin").toString();
                            String img = documentSnapshot.get("user_img").toString();

                            Log.d("checkData......",  "User Name: "+name+"\n email: "+email
                                    +"\n phone: "+phone+"\n dob: "+dob+"\n gender: "+gender+"\n pin: "+pin
                                    +"\n img: "+img);
                            GroceryConst.editor.putString(GroceryConst.OtpKeys.UID, uid);
                            GroceryConst.editor.putString(GroceryConst.OtpKeys.USER_NAME, name);
                            GroceryConst.editor.putString(GroceryConst.OtpKeys.USER_EMAIL, email);
                            GroceryConst.editor.putString(GroceryConst.OtpKeys.USER_MOBILE, phone);
                            GroceryConst.editor.putString(GroceryConst.OtpKeys.USER_DOB, dob);
                            GroceryConst.editor.putString(GroceryConst.OtpKeys.USER_GENDER, gender);
                            GroceryConst.editor.putString(GroceryConst.OtpKeys.PIN_CODE, pin);
                            GroceryConst.editor.putString(GroceryConst.OtpKeys.USER_IMG, img);
                            GroceryConst.editor.commit();

                            Log.d("constData....",  " Name: "+name+"\n email: "+email
                                    +"\n phone: "+phone+"\n dob: "+dob+"\n gender: "+gender+"\n pin: "+pin
                                    +"\n uid: "+uid+"\n img: "+img);
                        }

                    }
                });



    }

    private void uploadDataToFirebase() {

        userName = user_name.getText().toString();
        userEmail = user_email.getText().toString();
        pinCode = userPinCode.getText().toString();
        dateOfBirth = fromDate.getText().toString();
        gender = rb.getText().toString();

        FirebaseUser user = mAuth.getCurrentUser();
        assert user != null;
        final String uid=user.getUid();

        DocumentReference _ref = FirebaseFirestore.getInstance().collection("users").document("Login").collection("OtpLogin").document(uid);
        Map<String, Object> user_data = new HashMap<>();
        user_data.put("uid",user.getUid());
        user_data.put("user_name",userName);
        user_data.put("user_email",userEmail);
        user_data.put("user_mobile",MobileNo);
        user_data.put("user_dob",dateOfBirth);
        user_data.put("user_gender",gender);
        user_data.put("user_pin",pinCode);
        user_data.put("user_img","");
        _ref.set(user_data).isSuccessful();

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);


    }

    private void uploadImageFirebase() {
        if (imageUri!=null)
        {
            String filePath = "customer_images/"+"OtpLogin/"+uid;
            StorageReference reference = FirebaseStorage.getInstance().getReference().child(filePath);
            reference.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                    while(!uriTask.isSuccessful());
                    Uri downloadUri = uriTask.getResult();
                    if(uriTask.isSuccessful()) {
                        DocumentReference _ref = FirebaseFirestore.getInstance().collection("users").document("Login").collection("OtpLogin").document(uid);
                        _ref.update("user_img", downloadUri.toString()).isSuccessful();

                    }
                }
            });
        }

    }

    @SuppressLint("SetTextI18n")
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        this.day = day;
        this.month = month;
        this.year = year;
            if (day < 10 && (month + 1) < 10) {
                fromDate.setText("0" + day + "/0" + (month + 1) + "/" + year);
            } else if (day < 10) {
                fromDate.setText("0" + day + "/" + (month + 1) + "/" + year);
            } else if (month + 1 < 10) {
                fromDate.setText(day + "/0" + (month + 1) + "/" + year);
            } else {
                fromDate.setText(day + "/" + (month + 1) + "/" + year);
            }
        }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.fromDate) {
            fromDatePicker.show();
        }
    }

}