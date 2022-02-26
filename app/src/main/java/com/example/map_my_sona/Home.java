package com.example.map_my_sona;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        MaterialButton a=findViewById(R.id.admin);
        MaterialButton b=findViewById(R.id.user);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(Home.this, AdminLoginPage.class);
                startActivity(a);

                Toast.makeText(Home.this,"This is admin login page", Toast.LENGTH_SHORT).show();
            }
        });




        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b=new Intent(Home.this, loginpage.class);
                startActivity(b);

                Toast.makeText(Home.this,"This is user login page",Toast.LENGTH_SHORT).show();
            }
        });

    }
}