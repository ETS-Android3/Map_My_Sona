package com.example.map_my_sona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginpage extends AppCompatActivity {

    private TextInputEditText LogEmail;
    private TextInputEditText LogPassword;
    private TextView ForgetPass;
    private  TextView Changepass;
    private Button btnLogin;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);


        LogEmail=findViewById(R.id.loginemailInput);
        LogPassword=findViewById(R.id.loginpasswordInput);
        btnLogin=findViewById(R.id.loginbutton);
        ForgetPass=findViewById(R.id.forgetpassword);
        Changepass=findViewById(R.id.changepassword);

        mAuth=FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(view -> {
            LoginUser();
        });

        ForgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginpage.this,forgetpassword.class));
            }
        });

        Changepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginpage.this,changepassword.class));
            }
        });

    }

    private void LoginUser() {
        String email = LogEmail.getText().toString();
        String password =LogPassword.getText().toString();

        if(TextUtils.isEmpty(email)){
            LogEmail.setError("Email or username Cannot be empty");
            LogEmail.requestFocus();
        }else if(TextUtils.isEmpty(password)){
            LogPassword.setError("Password Cannot be empty");
            LogPassword.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(loginpage.this, "User Logged in successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(loginpage.this, dashboard.class));
                    }else{
                        Toast.makeText(loginpage.this, "Login Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}