package com.example.cafehouse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Visa extends AppCompatActivity {
EditText cardNumber,cvv,expDate,nameHolder;
    AlertDialog.Builder alertDialog;
Button payNow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visa);
        cardNumber=findViewById(R.id.ed_CardNumber);
        cvv=findViewById(R.id.ed_CVV);
        expDate=findViewById(R.id.ed_ExDate);
        nameHolder=findViewById(R.id.ed_name);
        payNow=findViewById(R.id.btn_PayNow);
        payNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cNum = cardNumber.getText().toString().trim();
                String exDate = expDate.getText().toString().trim();
                String nameHold = nameHolder.getText().toString().trim();
                String cardVV = cvv.getText().toString().trim();
                if (TextUtils.isEmpty(cNum)) {
                    cardNumber.setError("Card Number is Required");
                    return;
                }else if(cNum.length() < 16||cNum.length() > 16){
                    cardNumber.setError("Card Number Must be 16 Number");
                    return;
                } else if(TextUtils.isEmpty(exDate)){
                    expDate.setError("Expiry Date is Required");
                    return;
                }else if(TextUtils.isEmpty(cardVV)){
                    cvv.setError("CVV is Required");
                    return;
                }else if (cardVV.length() < 3||cardVV.length() > 3){
                    cvv.setError("CVV Must be 3 Numbers");
                    return;
                }else if(TextUtils.isEmpty(nameHold)){
                    nameHolder.setError("Card Holder is Required");
                    return;
                } else{
                    alertDialog = new AlertDialog.Builder(Visa.this);
                    alertDialog.setTitle("Done");
                    alertDialog.setCancelable(false);
                    alertDialog.setMessage("Payment completed successfully");
                    alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            startActivity(new Intent(getApplicationContext(),End_Animation.class));
                            Toast.makeText(Visa.this, "Thank You, see you soon", Toast.LENGTH_SHORT).show();
                        }
                    });
                    alertDialog.show();
                }
            }
        });
    }
}