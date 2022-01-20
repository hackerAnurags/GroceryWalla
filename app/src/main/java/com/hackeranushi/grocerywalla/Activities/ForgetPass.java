package com.hackeranushi.grocerywalla.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.hackeranushi.grocerywalla.R;
import com.skydoves.elasticviews.ElasticButton;

public class ForgetPass extends AppCompatActivity {

    EditText fEmail,fPass,fNewPass;
    ElasticButton resetPassword;
    TextView back;
    String  uid, email, currentPassword, newPassword;
    FirebaseAuth auth;
    FirebaseUser user1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);

        fEmail = findViewById(R.id.regist_email);
        fPass = findViewById(R.id.currPass);
        fNewPass = findViewById(R.id.new_password);
        resetPassword = findViewById(R.id.reset_password);
        back = findViewById(R.id.back);

        auth= FirebaseAuth.getInstance();
        user1 = auth.getCurrentUser();
        uid = user1.getUid();

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email=fEmail.getText().toString().trim();
                currentPassword=fPass.getText().toString().trim();
                newPassword=fNewPass.getText().toString().trim();

                if (TextUtils.isEmpty(email))
                {

                    Toast.makeText(ForgetPass.this, "Enter your registered Email Id", Toast.LENGTH_SHORT).show();
                    return;
                }

                AuthCredential credential = EmailAuthProvider
                        .getCredential(email, currentPassword);

                user1.reauthenticate(credential)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    user1.updatePassword(newPassword).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                DocumentReference _ref = FirebaseFirestore.getInstance().collection("users").document(uid);
                                                _ref.update("user_pass",newPassword).isSuccessful();
                                                Toast.makeText(ForgetPass.this, "We have to sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();

                                                Log.d("password update", "Password updated");
                                            } else {
                                                Log.d("passwrod error", "Error password not updated");
                                            }
                                        }
                                    });
                                } else {
                                    Log.d("Errort Failed", "Error auth failed");
                                }
                            }
                        });

            }
        });
    }
}