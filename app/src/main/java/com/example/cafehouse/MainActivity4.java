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

public class MainActivity4 extends AppCompatActivity {
    TextView logout;
    TextView hot;
    TextView cold;
    TextView cheeseName;
    TextView donWhiteDesc;
    TextView addCen,addDonchoco,addWaffle,addCheese,addDonWhite;
    TextView minusCen,minusDonchoco,minusWaffle,minusCheese,minusDonWhite;
    TextView countCen,countDonchoco,countWaffle,countCheese,countDonWhite;
    TextView sumCen,sumDonchoco,sumWaffle,sumCheese,sumDonWhite;
    int numCen,numDonChoco,numWaffle,numCheese,numDonWhite;
    int totalCen,totalDonChoco,totalWaffle,totalCheese,totalDonWhite;
    int totalThisActivity;
    int totalActivity2and3;
    int totalAll;
    Button totalClick;
    AlertDialog.Builder alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //----------------------------------------------------
        logout=findViewById(R.id.Logout);
        hot=findViewById(R.id.id_hot);
        cold=findViewById(R.id.id_cold);
        totalClick=findViewById(R.id.btn_clickHere);
        //---------------------------------------------------
        cheeseName=findViewById(R.id.Cheesecake_txt_view);
        donWhiteDesc=findViewById(R.id.DonutWhiteDesc_txt_view);
        //-----------------------------------------------------
        addCen=findViewById(R.id.tv_add_cennapon);
        addDonchoco=findViewById(R.id.tv_add_donchoco);
        addWaffle=findViewById(R.id.tv_add_waffle);
        addCheese=findViewById(R.id.tv_add_cheesechoco);
        addDonWhite=findViewById(R.id.tv_add_donwhite);
        //-----------------------------------------------------
        countCen=findViewById(R.id.tv_count_cenapon);
        countDonchoco=findViewById(R.id.tv_count_donchoco);
        countWaffle=findViewById(R.id.tv_count_waffle);
        countCheese=findViewById(R.id.tv_count_cheesechoco);
        countDonWhite=findViewById(R.id.tv_count_donwhite);
        //-----------------------------------------------------
        sumCen=findViewById(R.id.tv_sum_cenapon);
        sumDonchoco=findViewById(R.id.tv_sum_donchoco);
        sumWaffle=findViewById(R.id.tv_sum_waffle);
        sumCheese=findViewById(R.id.tv_sum_cheesechoco);
        sumDonWhite=findViewById(R.id.tv_sum_donwhite);
        //-----------------------------------------------------
        minusCen=findViewById(R.id.tv_minus_cenapon);
        minusDonchoco=findViewById(R.id.tv_minus_donchoco);
        minusWaffle=findViewById(R.id.tv_minus_waffle);
        minusCheese=findViewById(R.id.tv_minus_cheesechoco);
        minusDonWhite=findViewById(R.id.tv_minus_donwhite);
        //-----------------------------------------------------
        Intent i=getIntent();
        int totalPaid1=i.getIntExtra("total1",0);
        int totalPaid2=i.getIntExtra("total2",0);
        totalActivity2and3=totalPaid1+totalPaid2;
        //-----------------------------------------------------
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),Sign_In.class));
                finish();
            }
        });
        //-------------------------------------------------------
        cheeseName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity4.this, "cheesecake", Toast.LENGTH_SHORT).show();
            }
        });
        donWhiteDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity4.this, "White Frosting", Toast.LENGTH_SHORT).show();
            }
        });
        //-----------------------------------------------------
        hot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity4.this,MainActivity2.class);
                intent.putExtra("total3",totalAll);
                startActivity(intent);
            }
        });
        cold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity4.this,MainActivity3.class);
                intent.putExtra("total3",totalAll);
                startActivity(intent);
            }
        });
        addCen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numCen++;
                countCen.setText(Integer.toString(numCen));
                totalCen=numCen*15;
                sumCen.setText(Integer.toString(totalCen));
            }
        });
        minusCen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numCen>0)
                {
                    numCen--;
                    countCen.setText(Integer.toString(numCen));
                    totalCen=numCen*15;
                    sumCen.setText(Integer.toString(totalCen));
                }
            }
        });
        addDonchoco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numDonChoco++;
                countDonchoco.setText(Integer.toString(numDonChoco));
                totalDonChoco=numDonChoco*10;
                sumDonchoco.setText(Integer.toString(totalDonChoco));
            }
        });
        minusDonchoco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numDonChoco>0)
                {
                    numDonChoco--;
                    countDonchoco.setText(Integer.toString(numDonChoco));
                    totalDonChoco=numDonChoco*10;
                    sumDonchoco.setText(Integer.toString(totalDonChoco));
                }
            }
        });
        addWaffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numWaffle++;
                countWaffle.setText(Integer.toString(numWaffle));
                totalWaffle=numWaffle*35;
                sumWaffle.setText(Integer.toString(totalWaffle));
            }
        });
        minusWaffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numWaffle>0){
                    numWaffle--;
                    countWaffle.setText(Integer.toString(numWaffle));
                    totalWaffle=numWaffle*35;
                    sumWaffle.setText(Integer.toString(totalWaffle));
                }
            }
        });
        addCheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numCheese++;
                countCheese.setText(Integer.toString(numCheese));
                totalCheese=numCheese*20;
                sumCheese.setText(Integer.toString(totalCheese));
            }
        });
        minusCheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numCheese>0){
                    numCheese--;
                    countCheese.setText(Integer.toString(numCheese));
                    totalCheese=numCheese*20;
                    sumCheese.setText(Integer.toString(totalCheese));
                }
            }
        });
        addDonWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numDonWhite++;
                countDonWhite.setText(Integer.toString(numDonWhite));
                totalDonWhite=numDonWhite*53;
                sumDonWhite.setText(Integer.toString(totalDonWhite));
            }
        });
        minusDonWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numDonWhite>0)
                {
                    numDonWhite--;
                    countDonWhite.setText(Integer.toString(numDonWhite));
                    totalDonWhite=numDonWhite*53;
                    sumDonWhite.setText(Integer.toString(totalDonWhite));
                }
            }
        });
        totalClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               totalThisActivity=totalCen+totalWaffle+totalDonWhite+totalCheese+totalDonChoco;
                alertDialog=new AlertDialog.Builder(MainActivity4.this);
                totalAll=totalThisActivity+totalActivity2and3;
                alertDialog.setTitle("Finish");
                alertDialog.setCancelable(false);
                alertDialog.setMessage("Total= "+(totalAll));
                alertDialog.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity4.this, "Don’t forget, the cost of your order= "+(totalAll), Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.setNegativeButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(MainActivity4.this,PlaceOrder.class);
                        intent.putExtra("total3",totalAll);
                        startActivity(intent);
                    }
                });
                alertDialog.show();
            }
        });

    }


}