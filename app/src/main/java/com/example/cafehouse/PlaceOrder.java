package com.example.cafehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PlaceOrder extends AppCompatActivity {
TextView paidAmount;
EditText address,phoneNumber;
Button removeAll,placeOredr;
AlertDialog.Builder alertDialog;
Bundle bn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        paidAmount=findViewById(R.id.Paid_txt_view);
        address=findViewById(R.id.ed_address);
        phoneNumber=findViewById(R.id.ed_Phone);
        removeAll=findViewById(R.id.btn_removeAll);
        placeOredr=findViewById(R.id.btn_placeOrder);
        Intent i=getIntent();
        int totalPaid1=i.getIntExtra("total1",0);
        int totalPaid2=i.getIntExtra("total2",0);
        int totalPaid3=i.getIntExtra("total3",0);
        int allTotalPaid=totalPaid1+totalPaid2+totalPaid3;
        paidAmount.setText(String.valueOf(allTotalPaid)+" L.E");

        removeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                address.setText(null);
                phoneNumber.setText(null);
            }
        });
        placeOredr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sAddress = address.getText().toString().trim();
                String phone = phoneNumber.getText().toString().trim();
                if (TextUtils.isEmpty(sAddress)) {
                    address.setError("Address is Required");
                    return;
                }else if(TextUtils.isEmpty(phone)){
                    phoneNumber.setError("Phone Number is Required");
                    return;
                }else {
                    alertDialog = new AlertDialog.Builder(PlaceOrder.this);
                    alertDialog.setTitle("Order Placed Successfully");
                    alertDialog.setCancelable(false);
                    alertDialog.setMessage("Choose Payment Method");
                    alertDialog.setPositiveButton("Cash On Delivery", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            startActivity(new Intent(getApplicationContext(),End_Animation.class));
                        }
                    });
                    alertDialog.setNegativeButton("VISA", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            startActivity(new Intent(getApplicationContext(),Visa.class));
                        }
                    });
                    alertDialog.show();
                }

            }
        });

    }
}