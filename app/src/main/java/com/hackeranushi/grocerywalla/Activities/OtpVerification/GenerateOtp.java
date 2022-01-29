package com.hackeranushi.grocerywalla.Activities.OtpVerification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.hackeranushi.grocerywalla.MainActivity;
import com.hackeranushi.grocerywalla.R;
import com.skydoves.elasticviews.ElasticButton;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class GenerateOtp extends AppCompatActivity {

    TextInputEditText mobileNo, emailId, userName;
    EditText otpFirst,otpSecond,otpThird,otpFourth,otpFifth,otpSixth;
    ElasticButton getOtp,verifyOtp;
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    TextView receiveMobile,resendOtp;
    private String checkOtp;
    RelativeLayout line1,line2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_otp);

        mobileNo = findViewById(R.id.mobile_number);
        userName = findViewById(R.id.user_Name);
        emailId = findViewById(R.id.email_id);
        getOtp = findViewById(R.id.get_otp);
        receiveMobile = findViewById(R.id.receive_no);
        resendOtp = findViewById(R.id.resend_otp);
        verifyOtp = findViewById(R.id.verify_otp);
        otpFirst = findViewById(R.id.otp_first);
        otpSecond = findViewById(R.id.otp_second);
        otpThird = findViewById(R.id.otp_third);
        otpFourth = findViewById(R.id.otp_fourth);
        otpFifth = findViewById(R.id.otp_fifth);
        otpSixth = findViewById(R.id.otp_sixth);
        line1 = findViewById(R.id.line1);
        line2 = findViewById(R.id.line2);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Otp is sending");
        progressDialog.setMessage("Loading");

        getOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.show();
                if (mobileNo.getText().toString().length()==10)
                {
                    String mobileNumber = "+91" + mobileNo.getText().toString().trim();
                    sendingOtp(mobileNumber);
                }
                else
                    Toast.makeText(GenerateOtp.this, "Please fill all details", Toast.LENGTH_SHORT).show();
            }
        });

        verifyOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!otpFirst.getText().toString().isEmpty()&&!otpSecond.getText().toString().isEmpty()
                        &&!otpThird.getText().toString().isEmpty() &&!otpFourth.getText().toString().isEmpty()
                        &&!otpFifth.getText().toString().isEmpty()&&!otpSixth.getText().toString().isEmpty())
                {
                    String finalOtp = otpFirst.getText().toString().trim() +
                            otpSecond.getText().toString().trim() +
                            otpThird.getText().toString().trim() +
                            otpFourth.getText().toString().trim() +
                            otpFifth.getText().toString().trim() +
                            otpSixth.getText().toString().trim();

                    otpVerification(finalOtp);
                }
                else
                {
                    Toast.makeText(GenerateOtp.this, "Please fill all the field to pass authentication part", Toast.LENGTH_SHORT).show();
                }
            }
        });

        numberMoveToNext();
    }



    private void sendingOtp(String mobileNumber) {
        mAuth = FirebaseAuth.getInstance();
        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(mAuth)
                .setPhoneNumber(mobileNumber)
                .setTimeout(60L, TimeUnit.SECONDS)
                .setActivity(this)
                .setCallbacks(mCallBack)
                .build();

        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks

            mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            progressDialog.dismiss();
            line1.setVisibility(View.GONE);
            line2.setVisibility(View.VISIBLE);


        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            progressDialog.dismiss();
            line1.setVisibility(View.VISIBLE);
            line2.setVisibility(View.GONE);
            Toast.makeText(GenerateOtp.this, "Please check your Internet connection", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            progressDialog.dismiss();
            line1.setVisibility(View.GONE);
            line2.setVisibility(View.VISIBLE);
            checkOtp = s;
            PhoneAuthProvider.ForceResendingToken mResendToken = forceResendingToken;
        }
    };

    private void otpVerification(String finalOtp) {
        progressDialog.show();
        String fullName = userName.getText().toString();
        String email = emailId.getText().toString();
        String number = mobileNo.getText().toString();
        PhoneAuthCredential authCredential = PhoneAuthProvider.getCredential(checkOtp,finalOtp);

        FirebaseAuth.getInstance().signInWithCredential(authCredential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            progressDialog.dismiss();
                            FirebaseUser user = mAuth.getCurrentUser();
                            final String uid=user.getUid();

                            DocumentReference _ref = FirebaseFirestore.getInstance().collection("users").document(uid);
                            Map<String, Object> user_data = new HashMap<>();
                            user_data.put("uid",user.getUid());
                            user_data.put("user_name",fullName);
                            user_data.put("user_email",email);
                            user_data.put("user_mob",number);
                            user_data.put("user_dob","");
                            user_data.put("user_gender","");
                            user_data.put("user_img","");
                            _ref.set(user_data).isSuccessful();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(GenerateOtp.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void numberMoveToNext() {

        otpFirst.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty())
                {
                    otpSecond.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        otpSecond.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty())
                {
                    otpThird.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        otpThird.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty())
                {
                    otpFourth.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        otpFourth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty())
                {
                    otpFifth.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        otpFifth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty())
                {
                    otpSixth.requestFocus();
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}