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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.hackeranushi.grocerywalla.Helper.GroceryConst;
import com.hackeranushi.grocerywalla.MainActivity;
import com.hackeranushi.grocerywalla.R;
import com.skydoves.elasticviews.ElasticButton;

import java.util.HashMap;
import java.util.Map;

public class VerifyOtp extends AppCompatActivity {

    TextView receiveMobile,resendOtp;
    ElasticButton verifyOtp;
    EditText otpFirst,otpSecond,otpThird,otpFourth,otpFifth,otpSixth;
    String checkOtp;
    FirebaseAuth mAuth;
    ProgressDialog progressDialog;
    private String mobileNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);

        receiveMobile = findViewById(R.id.receive_no);
        resendOtp = findViewById(R.id.resend_otp);
        verifyOtp = findViewById(R.id.verify_otp);
        otpFirst = findViewById(R.id.otp_first);
        otpSecond = findViewById(R.id.otp_second);
        otpThird = findViewById(R.id.otp_third);
        otpFourth = findViewById(R.id.otp_fourth);
        otpFifth = findViewById(R.id.otp_fifth);
        otpSixth = findViewById(R.id.otp_sixth);
        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("VerifyOtp");
        progressDialog.setMessage("Loading...");

        mobileNo = (String.format("+91-%s", getIntent()
                .getStringExtra("mobileNo")));

        receiveMobile.setText(mobileNo);

        checkOtp = getIntent().getStringExtra("generatedOtp");

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

                    if (checkOtp!=null)
                    {
                        progressDialog.show();
                        PhoneAuthCredential authCredential = PhoneAuthProvider.getCredential(checkOtp,finalOtp);

                        FirebaseAuth.getInstance().signInWithCredential(authCredential)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful())
                                        {
                                            progressDialog.dismiss();
                                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                                startActivity(intent);
                                            }
                                            Intent intent = new Intent(getApplicationContext(),OtpLogDetails.class);
                                            intent.putExtra("phoneNo",mobileNo);
                                            startActivity(intent);
                                            Toast.makeText(VerifyOtp.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                }
                else
                {
                    Toast.makeText(VerifyOtp.this, "Please fill all the field to pass authentication part", Toast.LENGTH_SHORT).show();
                }
            }
        });

        numberMoveToNext();
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
                otpFirst.requestFocus();
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
                otpSecond.requestFocus();
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
                otpThird.requestFocus();
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
                otpFourth.requestFocus();
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

        otpSixth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                otpFifth.requestFocus();
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