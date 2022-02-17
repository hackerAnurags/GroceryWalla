package com.hackeranushi.grocerywalla.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.hackeranushi.grocerywalla.Activities.OtpVerification.GenerateOtp;
import com.hackeranushi.grocerywalla.Helper.GroceryConst;
import com.hackeranushi.grocerywalla.Helper.SharedPrefManager;
import com.hackeranushi.grocerywalla.MainActivity;
import com.hackeranushi.grocerywalla.R;
import com.skydoves.elasticviews.ElasticButton;

import java.util.HashMap;
import java.util.Map;

public class Authentication extends AppCompatActivity {

    ElasticButton loginBtn,signUpBtn;
    TextView textLogin,textSignup,cancel,skip,forgetPass;
    LinearLayout line1,line2,photoPicker;
    ImageView facebook,google,phoneLogin;
    ProgressDialog progressDialog;
    private FirebaseAuth mAuth;
    FirebaseFirestore db;
    String current_user;
    TextInputEditText lEmail,lPass,rName,rEmail,rMobile,rPass;

    boolean isLogin = false;
    private static String finalPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        GroceryConst.sharedPreferences = getSharedPreferences(GroceryConst.sp_name, MODE_PRIVATE);
        GroceryConst.editor = GroceryConst.sharedPreferences.edit();

        loginBtn=findViewById(R.id.login_btn);
        signUpBtn=findViewById(R.id.sign_btn);
        textLogin=findViewById(R.id.txt_signup);
        textSignup=findViewById(R.id.txt_signin);
        cancel=findViewById(R.id.cancel);
        skip=findViewById(R.id.skip);
        line1=findViewById(R.id.line1);
        line2=findViewById(R.id.line2);
        google = findViewById(R.id.google);
        facebook = findViewById(R.id.facebook);
        phoneLogin = findViewById(R.id.phoneLogin);
        photoPicker = findViewById(R.id.photoPicker);
        lEmail = findViewById(R.id.login_email);
        lPass = findViewById(R.id.login_pass);
        rName = findViewById(R.id.register_name);
        rEmail = findViewById(R.id.register_email);
        rMobile = findViewById(R.id.register_mobile);
        rPass = findViewById(R.id.register_pass);
        forgetPass = findViewById(R.id.forget_pass);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Authentication");
        progressDialog.setMessage("login");

        phoneLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GenerateOtp.class);
                startActivity(intent);
            }
        });


        textLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                line1.setVisibility(View.GONE);
                line2.setVisibility(View.VISIBLE);
                google.setVisibility(View.GONE);
                phoneLogin.setVisibility(View.GONE);
                facebook.setVisibility(View.GONE);

            }
        });

        textSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                line1.setVisibility(View.VISIBLE);
                line2.setVisibility(View.GONE);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Authentication.this)
                    .setTitle("Message")
                    .setMessage("Do you want to exist")
                    .setNegativeButton("No", null)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finishAffinity();
                            System.exit(0);
                        }
                    }).create().show();
            }
        });

        forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(),ForgetPass.class);
//                startActivity(intent);
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userEmail = lEmail.getText().toString().trim();
                String userPass = lPass.getText().toString().trim();

                if (TextUtils.isEmpty(userEmail))
                {
                    Toast.makeText(Authentication.this, "Please enter your registered email id", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(userPass))
                {
                    Toast.makeText(Authentication.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                }
                progressDialog.show();

                firebaseLogin(userEmail,userPass);

            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isLogin=true;

                String userName= rName.getText().toString().trim();
                String userEmail= rEmail.getText().toString().trim();
                String userMob= rMobile.getText().toString().trim();
                String userPass= rPass.getText().toString().trim();

                if (TextUtils.isEmpty(userName))
                {
                    Toast.makeText(Authentication.this, "Please Enter Your Full Name", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(userEmail))
                {
                    Toast.makeText(Authentication.this, "Please Enter Your Email id", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(userMob))
                {
                    Toast.makeText(Authentication.this, "Please Enter Your Mobile Number", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(userPass))
                {
                    Toast.makeText(Authentication.this, "Please Enter Your Password ", Toast.LENGTH_SHORT).show();

                }

                progressDialog.show();

                firebaseRegister(userName,userEmail,userMob,userPass);
            }
        });
    }

    private void firebaseRegister(String userName, String userEmail, String userMob, String userPass) {

        mAuth.createUserWithEmailAndPassword(userEmail,userPass).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (task.isSuccessful())
                {
                    FirebaseUser user = mAuth.getCurrentUser();
                    final String uid=user.getUid();
                    DocumentReference _ref = FirebaseFirestore.getInstance().collection("users").document(uid);
                    Map<String, Object> user_data = new HashMap<>();
                    user_data.put("uid",user.getUid());
                    user_data.put("user_name",userName);
                    user_data.put("user_email",userEmail);
                    user_data.put("user_mob",userMob);
                    user_data.put("user_pass",userPass);
                    user_data.put("user_dob","");
                    user_data.put("user_gender","");
                    user_data.put("user_img","");
                    _ref.set(user_data).isSuccessful();

                    isLogin = false;

                    Intent i = new Intent(getApplicationContext(), Authentication.class);
                    i.putExtra("user_email", userEmail);     //????????????????
                    startActivity(i);
                }
                else {
                    Log.w("not successful", "createUserWithEmail:failure", task.getException());
                    Toast.makeText(Authentication.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void firebaseLogin(final String userEmail, String userPass) {

        mAuth.signInWithEmailAndPassword(userEmail,userPass).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (!task.isSuccessful())
                {
                    Toast.makeText(Authentication.this, "Put Correct Email and Password", Toast.LENGTH_SHORT).show();
                }
                else
                    {
                       current_user = mAuth.getUid();
                        Log.d("UID", current_user);

                       FirebaseFirestore.getInstance().collection("users").document(current_user).get()
                               .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                   @Override
                                   public void onSuccess(DocumentSnapshot documentSnapshot) {
                                       if (!documentSnapshot.exists())
                                       {
                                           Log.d("Not Exist","List is empty");
                                           Toast.makeText(Authentication.this, "List is not exits", Toast.LENGTH_SHORT).show();
                                           return;
                                       }
                                       else
                                           {
                                               String name = documentSnapshot.get("user_name").toString();
                                               String email = documentSnapshot.get("user_email").toString();
                                               String phone = documentSnapshot.get("user_mob").toString();
                                               String password = documentSnapshot.get("user_pass").toString();
                                               GroceryConst.editor.putString(GroceryConst.EmailKeys.UID, current_user);
                                               GroceryConst.editor.putString(GroceryConst.EmailKeys.USER_NAME, name);
                                               GroceryConst.editor.putString(GroceryConst.EmailKeys.USER_EMAIL, email);
                                               GroceryConst.editor.putString(GroceryConst.EmailKeys.USER_MOBILE, phone);
                                               GroceryConst.editor.commit();

                                               Log.d("constData....",  " Name: "+name+"\n email: "+email
                                                       +"\n phone: "+phone
                                                       +"\n uid: "+current_user);

                                               Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                               startActivity(intent);
                                               finish();
                                           }
                                   }
                               });
                    }
            }
        });
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                    .setTitle("Message")
                    .setMessage("Do you want to exist")
                    .setNegativeButton("No", null)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finishAffinity();
                            Authentication.super.onBackPressed();
                        }
                    }).create().show();

    }
}