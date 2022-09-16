package com.example.cafehouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CreateAccount extends AppCompatActivity {
    EditText userName,phoneNum,mEmail,pass;
    Button getStarted;
    TextView facebook,google,already;
    FirebaseAuth fAuth;
    AlertDialog.Builder alertDialog;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        userName = findViewById(R.id.ed_userName);
        phoneNum = findViewById(R.id.ed_Phone);
        mEmail = findViewById(R.id.ed_email);
        pass = findViewById(R.id.ed_pass);
        getStarted = findViewById(R.id.btn_start);
        facebook = findViewById(R.id.tv_facebook);
        google = findViewById(R.id.tv_google);
        already = findViewById(R.id.tv_register);
        progressBar = findViewById(R.id.probar);
        fAuth = FirebaseAuth.getInstance();

        if (fAuth.getCurrentUser() != null) {
            Intent intent = new Intent(CreateAccount.this, MainActivity2.class);
        }

        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString().trim();
                String password = pass.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Email is Required");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    pass.setError("Password is Required");
                    return;
                }
                if (password.length() < 8) {
                    pass.setError("Password Must be at least 8 characters");
                    return;
                }
                progressBar.setVisibility(view.VISIBLE);
                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(CreateAccount.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity2.class));
                        } else {
                            alertDialog = new AlertDialog.Builder(CreateAccount.this);
                            alertDialog.setTitle("Sorry");
                            alertDialog.setCancelable(false);
                            alertDialog.setMessage("Check your information");
                            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    progressBar.setVisibility(view.GONE);
                                }
                            });
                            alertDialog.show();
                        }
                    }
                });

            }
        });
        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CreateAccount.this,Sign_In.class);
                startActivity(intent);
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateAccount.this, MainActivity2.class);
                startActivity(intent);
            }

        });
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateAccount.this, MainActivity2.class);
                startActivity(intent);
            }

        });
    }
}