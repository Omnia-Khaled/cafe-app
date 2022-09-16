package com.example.cafehouse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity3 extends AppCompatActivity {
    TextView logout;
    TextView hot;
    TextView others;
    TextView affogaName,brewName,milkshakeName,vanLatteName,horchaName;
    TextView affogaDesc,brewDesc,milkshakeDesc,vanLatteDesc,horchaDesc;
    TextView addaffoga,addBrew,addMilkshake,addVanLatte,addHorcha;
    TextView minusaffoga,minusBrew,minusMilkshake,minusVanLatte,minusHorcha;
    TextView countaffoga,countBrew,countMilkshake,countVanLatte,countHorcha;
    TextView sumaffoga,sumBrew,sumMilkshake,sumVanLatte,sumHorcha;
    int numaffoga,numBrew,numMilkshake,numVanLatte,numHorcha;
    int totalaffoga,totalBrew,totalMilkshake,totalVanLatte,totalHorcha;
    int totalThisActivity;
    int totalActivity2and4;
    TextView totalClick;
    int totalAll;
    AlertDialog.Builder alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //----------------------------------------------------
        logout=findViewById(R.id.Logout);
        hot=findViewById(R.id.id_hot);
        others=findViewById(R.id.id_other);
        totalClick=findViewById(R.id.tv_clickHere2);
        //--------------------------------------------------------
        affogaName=findViewById(R.id.cafeAffogato_txt_view);
        brewName=findViewById(R.id.ColdBrew_txt_view);
        milkshakeName=findViewById(R.id.Milkshake_txt_view);
        vanLatteName=findViewById(R.id.IceVan_txt_view);
        horchaName=findViewById(R.id.Horchate_txt_view);
        //--------------------------------------------------------
        affogaDesc=findViewById(R.id.cafeAffogatoDesc_txt_view);
        brewDesc=findViewById(R.id.ColdBrewDesc_txt_view);
        milkshakeDesc=findViewById(R.id.MilkshakeDesc_txt_view);
        vanLatteDesc=findViewById(R.id.IceVanDesc_txt_view);
        horchaDesc=findViewById(R.id.HorchateDesc_txt_view);
        //--------------------------------------------------------
        addaffoga=findViewById(R.id.tv_add_cafeaffog);
        addBrew=findViewById(R.id.tv_add_coldBrew);
        addMilkshake=findViewById(R.id.tv_add_milkshake);
        addVanLatte=findViewById(R.id.tv_add_icevan);
        addHorcha=findViewById(R.id.tv_add_horch);
        //-------------------------------------------------------
        minusaffoga=findViewById(R.id.tv_minus_cafeaffog);
        minusBrew=findViewById(R.id.tv_minus_coldBrew);
        minusMilkshake=findViewById(R.id.tv_minus_milkshake);
        minusVanLatte=findViewById(R.id.tv_minus_icevan);
        minusHorcha=findViewById(R.id.tv_minus_horch);
        //-------------------------------------------------------
        countaffoga=findViewById(R.id.tv_count_cafeaffog);
        countBrew=findViewById(R.id.tv_count_coldBrew);
        countMilkshake=findViewById(R.id.tv_count_milkshake);
        countVanLatte=findViewById(R.id.tv_count_icevan);
        countHorcha=findViewById(R.id.tv_count_horch);
        //-------------------------------------------------------
        sumaffoga=findViewById(R.id.tv_sum_cafeaffog);
        sumBrew=findViewById(R.id.tv_sum_coldBrew);
        sumMilkshake=findViewById(R.id.tv_sum_milkshake);
        sumVanLatte=findViewById(R.id.tv_sum_icevan);
        sumHorcha=findViewById(R.id.tv_sum_horch);
        //-------------------------------------------------------
        Intent i=getIntent();
        int totalPaid1=i.getIntExtra("total1",0);
        int totalPaid3=i.getIntExtra("total3",0);
        totalActivity2and4=totalPaid1+totalPaid3;
        //-------------------------------------------------------
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),Sign_In.class));
                finish();
            }
        });
        //-------------------------------------------------------
        affogaName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity3.this, "Café Affogato", Toast.LENGTH_SHORT).show();
            }
        });
        affogaDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity3.this, "Italian coffee", Toast.LENGTH_SHORT).show();
            }
        });
        //------------------------------------------------------------
        brewName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity3.this, "Cold Brew", Toast.LENGTH_SHORT).show();
            }
        });
        brewDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity3.this, "higher coffee to water ratio than regular drip coffee", Toast.LENGTH_SHORT).show();
            }
        });
        //------------------------------------------------------------
        milkshakeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity3.this, "Milkshake", Toast.LENGTH_SHORT).show();
            }
        });
        milkshakeDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity3.this, "Thick and creamy with a rich coffee and chocolate flavor", Toast.LENGTH_SHORT).show();
            }
        });
        //------------------------------------------------------------
        vanLatteName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity3.this, "Ice Vanilla Latte", Toast.LENGTH_SHORT).show();
            }
        });
        vanLatteDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity3.this, "Cold coffee drink made with espresso, ice, milk, and vanilla syrup", Toast.LENGTH_SHORT).show();
            }
        });
        //------------------------------------------------------------
        horchaName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity3.this, "Horchata Latte", Toast.LENGTH_SHORT).show();
            }
        });
        horchaDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity3.this, "Mixing homemade cinnamon rice milk with a shot of espresso", Toast.LENGTH_SHORT).show();
            }
        });
        //------------------------------------------------------------
        hot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity3.this,MainActivity2.class);
                intent.putExtra("total2",totalAll);
                startActivity(intent);
            }
        });
        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity3.this,MainActivity4.class);
                intent.putExtra("total2",totalAll);
                startActivity(intent);
            }
        });
        addaffoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numaffoga++;
                countaffoga.setText(Integer.toString(numaffoga));
                totalaffoga=numaffoga*20;
                sumaffoga.setText(Integer.toString(totalaffoga));
            }
        });
        minusaffoga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(numaffoga>0)
                {
                    numaffoga--;
                    countaffoga.setText(Integer.toString(numaffoga));
                    totalaffoga=numaffoga*20;
                    sumaffoga.setText(Integer.toString(totalaffoga));
                }
            }
        });
        addBrew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numBrew++;
                countBrew.setText(Integer.toString(numBrew));
                totalBrew=numBrew*25;
                sumBrew.setText(Integer.toString(totalBrew));
            }
        });
        minusBrew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numBrew>0)
                {
                    numBrew--;
                    countBrew.setText(Integer.toString(numBrew));
                    totalBrew=numBrew*25;
                    sumBrew.setText(Integer.toString(totalBrew));
                }
            }
        });
        addMilkshake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numMilkshake++;
                countMilkshake.setText(Integer.toString(numMilkshake));
                totalMilkshake=numMilkshake*35;
                sumMilkshake.setText(Integer.toString(totalMilkshake));
            }
        });
        minusMilkshake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numMilkshake>0)
                {
                    numMilkshake--;
                    countMilkshake.setText(Integer.toString(numMilkshake));
                    totalMilkshake=numMilkshake*35;
                    sumMilkshake.setText(Integer.toString(totalMilkshake));
                }
            }
        });
        addVanLatte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numVanLatte++;
                countVanLatte.setText(Integer.toString(numVanLatte));
                totalVanLatte=numVanLatte*20;
                sumVanLatte.setText(Integer.toString(totalVanLatte));
            }
        });
        minusVanLatte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numVanLatte>0)
                {
                    numVanLatte--;
                    countVanLatte.setText(Integer.toString(numVanLatte));
                    totalVanLatte=numVanLatte*20;
                    sumVanLatte.setText(Integer.toString(totalVanLatte));
                }
            }
        });
        addHorcha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numHorcha++;
                countHorcha.setText(Integer.toString(numHorcha));
                totalHorcha=numHorcha*53;
                sumHorcha.setText(Integer.toString(totalHorcha));
            }
        });
        minusHorcha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numHorcha>0)
                {
                    numHorcha--;
                    countHorcha.setText(Integer.toString(numHorcha));
                    totalHorcha=numHorcha*53;
                    sumHorcha.setText(Integer.toString(totalHorcha));
                }
            }
        });
        totalClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                totalThisActivity=totalBrew+totalHorcha+totalaffoga+totalMilkshake+totalVanLatte;
                totalAll=totalActivity2and4+totalThisActivity;
                alertDialog=new AlertDialog.Builder(MainActivity3.this);
                alertDialog.setTitle("Finish");
                alertDialog.setCancelable(false);
                alertDialog.setMessage("Total= "+(totalAll));
                alertDialog.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity3.this, "Don’t forget, the cost of your order= "+(totalAll), Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.setNegativeButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(MainActivity3.this,PlaceOrder.class);
                        intent.putExtra("total2",totalAll);
                        startActivity(intent);
                    }
                });
                alertDialog.show();
            }
        });

    }


}