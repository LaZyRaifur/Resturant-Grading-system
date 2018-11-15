package com.example.raifur.foodgradingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class QRCode extends AppCompatActivity implements View.OnClickListener{


    Button btnSubmit;
    TextView nameTv,addressTv,IdTv;

    //qr code scanner object
    private IntentIntegrator QrScan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        //view implement
        btnSubmit = findViewById(R.id.buttonScan);
        nameTv = findViewById(R.id.NameTv);
        addressTv = findViewById(R.id.AddressTv);

        IdTv = findViewById(R.id.IdTv);
        //attaching onclick listener
        btnSubmit.setOnClickListener(this);

        //initialize scan object;
        QrScan = new IntentIntegrator(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            //if qr code has nothing on it
            if (result.getContents() == null) {
                Toast.makeText(this, "Result not found!!!", Toast.LENGTH_SHORT).show();
            } else {
                JSONObject object = null;
                try {
                    object = new JSONObject(result.getContents());

                    //setting value to text view
                    nameTv.setText(object.getString("name"));
                    addressTv.setText(object.getString("address"));
                    IdTv.setText(object.getString("id"));

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_SHORT).show();
                }
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onClick(View v) {

        //initiating the qr code scan
        QrScan.initiateScan();
    }
}
