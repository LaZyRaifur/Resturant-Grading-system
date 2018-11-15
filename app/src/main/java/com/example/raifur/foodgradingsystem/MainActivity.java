package com.example.raifur.foodgradingsystem;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView nameTv,addressTv;

    //qr code scanner object
    private IntentIntegrator QrScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        //circle menu
        CircleMenu circleMenu = findViewById(R.id.circleMenu);

        circleMenu.setMainMenu(Color.parseColor("#1b0000"),R.drawable.ic_home_black_24dp,R.drawable.ic_add_circle_black_24dp)
                .addSubMenu(Color.parseColor("#ff8a50"),R.drawable.qr_code)
        .addSubMenu(Color.parseColor("#bbdefb"),R.drawable.placeholder)
                .addSubMenu(Color.parseColor("#76d275"),R.drawable.dinner)
                .addSubMenu(Color.parseColor("#ffd600"),R.drawable.cutlery)
                .addSubMenu(Color.parseColor("#c30000"),R.drawable.fork)
        .addSubMenu(Color.parseColor("#ea80fc"),R.drawable.about)
                .addSubMenu(Color.parseColor("#c6ff00"),R.drawable.tools)
        .setOnMenuSelectedListener(new OnMenuSelectedListener() {
            @Override
            public void onMenuSelected(int i) {
                switch (i){
                    case 0:
                        Intent qrIntent = new Intent(MainActivity.this,QRCode.class);
                        startActivity(qrIntent);


                }
            }
        });


    }

}
