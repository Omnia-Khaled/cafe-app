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
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {
    TextView logout;
    TextView cold;
    TextView others;
    TextView amerName,capName,macName,vanLatteName;
    TextView amerDesc,capDesc,macDesc,latteDesc,mochaDesc,redEyeDesc,vanLatteDesc,doppioDesc,cortadoDesc;
    TextView addAmer,addCap,addMac,addLatte,addMocha,addBlack,addRedEye,addVanLatte,addDoppio,addCortado;
    TextView minusAmer,minusCap,minusMac,minusLatte,minusMocha,minusBlack,minusRedEye,minusVanLatte,minusDoppio,minusCortado;
    TextView countAmer,countCap,countMac,countLatte,countMocha,countBlack,countRedEye,countVanLatte,countDoppio,countCortado;
    TextView sumAmer,sumCap,sumMac,sumLatte,sumMocha,sumBlack,sumRedEye,sumVanLatte,sumDoppio,sumCortado;
    int numAmer,numCap,numMac,numLatte,numMocha,numBlack,numRedEye,numVanLatte,numDoppio,numCortado;
    int totalAmer,totalCap,totalMac,totalLatte,totalMocha,totalBlack,totalRedEye,totalVanLatte,totalDoppio,totalCortado;
    TextView totalClick;
    AlertDialog.Builder alertDialog;
    int totalThisActivity;
    int totalAll;
    int totalActivity3and4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //----------------------------------------------------
        logout=findViewById(R.id.Logout);
        cold=findViewById(R.id.id_cold);
        others=findViewById(R.id.id_other);
        totalClick=findViewById(R.id.tv_clickHere1);
        //--------------------------------------------------------
        amerName=findViewById(R.id.Amerc_txt_view);
        capName=findViewById(R.id.Cap_txt_view);
        macName=findViewById(R.id.Mac_txt_view);
        vanLatteName=findViewById(R.id.VanLatte_txt_view);
        // --------------------------------------------------------
        amerDesc=findViewById(R.id.AmercDesc_txt_view);
        capDesc=findViewById(R.id.CapDesc_txt_view);
        macDesc=findViewById(R.id.MacDesc_txt_view);
        latteDesc=findViewById(R.id.LatteDesc_txt_view);
        mochaDesc=findViewById(R.id.MochaDesc_txt_view);
        redEyeDesc=findViewById(R.id.RedEyeDesc_txt_view);
        vanLatteDesc=findViewById(R.id.VanLatteDesc_txt_view);
        doppioDesc=findViewById(R.id.DoppioDesc_txt_view);
        cortadoDesc=findViewById(R.id.CortadoDesc_txt_view);
        //----------------------------------------------------------
        addAmer=findViewById(R.id.tv_add_amer);
        addCap=findViewById(R.id.tv_add_cap);
        addMac=findViewById(R.id.tv_add_mac);
        addLatte=findViewById(R.id.tv_add_latte);
        addMocha=findViewById(R.id.tv_add_mocha);
        addBlack=findViewById(R.id.tv_add_balck);
        addRedEye=findViewById(R.id.tv_add_redeye);
        addVanLatte=findViewById(R.id.tv_add_hotvanlatte);
        addDoppio=findViewById(R.id.tv_add_dop);
        addCortado=findViewById(R.id.tv_add_cortado);
        //----------------------------------------------------
        minusAmer=findViewById(R.id.tv_minus_amer);
        minusCap=findViewById(R.id.tv_minus_cap);
        minusMac=findViewById(R.id.tv_minus_mac);
        minusLatte=findViewById(R.id.tv_minus_latte);
        minusMocha=findViewById(R.id.tv_minus_mocha);
        minusBlack=findViewById(R.id.tv_minus_black);
        minusRedEye=findViewById(R.id.tv_minus_redeye);
        minusVanLatte=findViewById(R.id.tv_minus_hotvanlatte);
        minusDoppio=findViewById(R.id.tv_minus_dop);
        minusCortado=findViewById(R.id.tv_minus_cortado);
        //-------------------------------------------------------
        countAmer=findViewById(R.id.tv_count_amer);
        countCap=findViewById(R.id.tv_count_cap);
        countMac=findViewById(R.id.tv_count_mac);
        countLatte=findViewById(R.id.tv_count_latte);
        countMocha=findViewById(R.id.tv_count_mocha);
        countBlack=findViewById(R.id.tv_count_black);
        countRedEye=findViewById(R.id.tv_count_redeye);
        countVanLatte=findViewById(R.id.tv_count_hotvanlatte);
        countDoppio=findViewById(R.id.tv_count_dop);
        countCortado=findViewById(R.id.tv_count_cortado);
        //---------------------------------------------------------
        sumAmer=findViewById(R.id.tv_sum_amer);
        sumCap=findViewById(R.id.tv_sum_cap);
        sumMac=findViewById(R.id.tv_sum_mac);
        sumLatte=findViewById(R.id.tv_sum_latte);
        sumMocha=findViewById(R.id.tv_sum_mocha);
        sumBlack=findViewById(R.id.tv_sum_black);
        sumRedEye=findViewById(R.id.tv_sum_redeye);
        sumVanLatte=findViewById(R.id.tv_sum_hotvanlatte);
        sumDoppio=findViewById(R.id.tv_sum_dop);
        sumCortado=findViewById(R.id.tv_sum_cortado);
        //---------------------------------------------------------
        Intent i=getIntent();
        int totalPaid2=i.getIntExtra("total2",0);
        int totalPaid3=i.getIntExtra("total3",0);
        totalActivity3and4=totalPaid2+totalPaid3;
        //---------------------------------------------------------
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),Sign_In.class));
                finish();
            }
        });
        //---------------------------------------------------------
        amerName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "Americano Coffee", Toast.LENGTH_SHORT).show();
            }
        });
        amerDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "Espresso drink made with hot water and espresso", Toast.LENGTH_SHORT).show();
            }
        });
        //------------------------------------------------------------
        capName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "Cappuccino", Toast.LENGTH_SHORT).show();
            }
        });
        capDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "A shot of espresso with steamed milk and milk foam", Toast.LENGTH_SHORT).show();
            }
        });
        //------------------------------------------------------------
        macName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "Macchiato", Toast.LENGTH_SHORT).show();
            }
        });
        macDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "2 shots of espresso and a small amount of milk", Toast.LENGTH_SHORT).show();
            }
        });
        //------------------------------------------------------------
        latteDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "Coffee drink with espresso, steamed milk and a layer of foam on top", Toast.LENGTH_SHORT).show();
            }
        });
        //------------------------------------------------------------
        mochaDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "One or more shots of espresso,Cocoa powder/ sugar,Steamed milk,Steamed milk froth and Shaved chocolate or chocolate syrup on top", Toast.LENGTH_SHORT).show();
            }
        });
        //------------------------------------------------------------
        redEyeDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "Espresso + Brewed Coffee", Toast.LENGTH_SHORT).show();
            }
        });
        //------------------------------------------------------------
        vanLatteName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "Vanilla Latte", Toast.LENGTH_SHORT).show();
            }
        });
        vanLatteDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "Hot espresso with vanilla syrup and hot milk", Toast.LENGTH_SHORT).show();
            }
        });
        //------------------------------------------------------------
        doppioDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "A double shot of espresso, the doppio is perfect for putting extra pep in your step.", Toast.LENGTH_SHORT).show();
            }
        });
        //------------------------------------------------------------
        cortadoDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "Perfect balance of espresso and warm steamed milk. The milk is used to cut back on the espresso’s acidity.", Toast.LENGTH_SHORT).show();
            }
        });
        //------------------------------------------------------------
        cold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
                intent.putExtra("total1",totalAll);
                startActivity(intent);
            }
        });
        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this,MainActivity4.class);
                intent.putExtra("total1",totalAll);
                startActivity(intent);
            }
        });
        addAmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numAmer++;
                countAmer.setText(Integer.toString(numAmer));
                totalAmer=numAmer*15;
                sumAmer.setText(Integer.toString(totalAmer));
            }
        });
        minusAmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numAmer>0)
                {
                    numAmer--;
                    countAmer.setText(Integer.toString(numAmer));
                    totalAmer=numAmer*15;
                    sumAmer.setText(Integer.toString(totalAmer));
                }
            }
        });
        addCap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numCap++;
                countCap.setText(Integer.toString(numCap));
                totalCap=numCap*25;
                sumCap.setText(Integer.toString(totalCap));
            }
        });
        minusCap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numCap>0)
                {
                    numCap--;
                    countCap.setText(Integer.toString(numCap));
                    totalCap=numCap*25;
                    sumCap.setText(Integer.toString(totalCap));
                }
            }
        });
        addMac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numMac++;
                countMac.setText(Integer.toString(numMac));
                totalMac=numMac*35;
                sumMac.setText(Integer.toString(totalMac));
            }
        });
        minusMac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numMac>0)
                {
                    numMac--;
                    countMac.setText(Integer.toString(numMac));
                    totalMac=numMac*35;
                    sumMac.setText(Integer.toString(totalMac));
                }
            }
        });
        addLatte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numLatte++;
                countLatte.setText(Integer.toString(numLatte));
                totalLatte=numLatte*20;
                sumLatte.setText(Integer.toString(totalLatte));
            }
        });
        minusLatte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numLatte>0)
                {
                    numLatte--;
                    countLatte.setText(Integer.toString(numLatte));
                    totalLatte=numLatte*20;
                    sumLatte.setText(Integer.toString(totalLatte));
                }
            }
        });
        addMocha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numMocha++;
                countMocha.setText(Integer.toString(numMocha));
                totalMocha=numMocha*53;
                sumMocha.setText(Integer.toString(totalMocha));
            }
        });
        minusMocha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numMocha>0)
                {
                    numMocha--;
                    countMocha.setText(Integer.toString(numMocha));
                    totalMocha=numMocha*53;
                    sumMocha.setText(Integer.toString(totalMocha));
                }
            }
        });
        addBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numBlack++;
                countBlack.setText(Integer.toString(numBlack));
                totalBlack=numBlack*10;
                sumBlack.setText(Integer.toString(totalBlack));
            }
        });
        minusBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numBlack>0)
                {
                    numBlack--;
                    countBlack.setText(Integer.toString(numBlack));
                    totalBlack=numBlack*10;
                    sumBlack.setText(Integer.toString(totalBlack));
                }
            }
        });
        addRedEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numRedEye++;
                countRedEye.setText(Integer.toString(numRedEye));
                totalRedEye=numRedEye*40;
                sumRedEye.setText(Integer.toString(totalRedEye));
            }
        });
        minusRedEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numRedEye>0)
                {
                    numRedEye--;
                    countRedEye.setText(Integer.toString(numRedEye));
                    totalRedEye=numRedEye*40;
                    sumRedEye.setText(Integer.toString(totalRedEye));
                }
            }
        });
        addVanLatte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numVanLatte++;
                countVanLatte.setText(Integer.toString(numVanLatte));
                totalVanLatte=numVanLatte*50;
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
                   totalVanLatte=numVanLatte*50;
                   sumVanLatte.setText(Integer.toString(totalVanLatte));
               }
            }
        });
        addDoppio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numDoppio++;
                countDoppio.setText(Integer.toString(numDoppio));
                totalDoppio=numDoppio*65;
                sumDoppio.setText(Integer.toString(totalDoppio));
            }
        });
        minusDoppio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numDoppio>0)
                {
                    numDoppio--;
                    countDoppio.setText(Integer.toString(numDoppio));
                    totalDoppio=numDoppio*65;
                    sumDoppio.setText(Integer.toString(totalDoppio));
                }
            }
        });
        addCortado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numCortado++;
                countCortado.setText(Integer.toString(numCortado));
                totalCortado=numCortado*75;
                sumCortado.setText(Integer.toString(totalCortado));
            }
        });
        minusCortado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numCortado>0)
                {
                    numCortado--;
                    countCortado.setText(Integer.toString(numCortado));
                    totalCortado=numCortado*75;
                    sumCortado.setText(Integer.toString(totalCortado));
                }
            }
        });
        totalClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalThisActivity=totalAmer+totalCortado+totalDoppio+totalBlack+totalMocha+totalLatte+totalRedEye+totalMac+totalCap+totalVanLatte;
                totalAll=totalThisActivity+totalActivity3and4;
                alertDialog=new AlertDialog.Builder(MainActivity2.this);
                alertDialog.setTitle("Finish");
                alertDialog.setCancelable(false);
                alertDialog.setMessage("Total= "+(totalAll));
                alertDialog.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity2.this, "Don’t forget, the cost of your order= "+(totalAll), Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.setNegativeButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(MainActivity2.this,PlaceOrder.class);
                        intent.putExtra("total1",totalAll);
                        startActivity(intent);
                    }
                });
                alertDialog.show();


            }
        });
    }



}