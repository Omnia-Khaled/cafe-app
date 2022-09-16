package com.example.cafehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SkipMainActivity5 extends AppCompatActivity {
    Button log;
    TextView cold;
    TextView others;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip_main5);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        log=findViewById(R.id.btn_login);
        cold=findViewById(R.id.id_cold);
        others=findViewById(R.id.id_other);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(SkipMainActivity5.this, Sign_In.class);
                Toast.makeText(SkipMainActivity5.this, "Login has been clicked", Toast.LENGTH_SHORT).show();
                startActivity(intent2);
            }
        });

        cold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(SkipMainActivity5.this,SkipMainActivity6.class);
                startActivity(i);
            }
        });
        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 =new Intent(SkipMainActivity5.this,SkipMainActivity7.class);
                startActivity(i2);
            }
        });
    }
}