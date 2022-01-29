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

    TextInputEditText mobileNo;
    EditText otpFirst,otpSecond,otpThird,otpFourth,otpFifth,otpSixth;
    ElasticButton getOtp,verifyOtp;
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    TextView receiveMobile,resendOtp;
    private String checkOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_otp);

        mobileNo = findViewById(R.id.mobile_number);
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

        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            progressDialog.dismiss();
            Toast.makeText(GenerateOtp.this, "Please check your Internet connection", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            progressDialog.dismiss();
            checkOtp = s;
            Intent intent = new Intent(getApplicationContext(),OtpLogDetails.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.putExtra("generatedOtp",checkOtp);
            intent.putExtra("mobileNo",mobileNo.getText().toString().trim());
            startActivity(intent);
            PhoneAuthProvider.ForceResendingToken mResendToken = forceResendingToken;

        }
    };
}