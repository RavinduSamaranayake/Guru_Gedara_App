package com.example.user.guruforstudent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Auth extends AppCompatActivity {
    Button scan_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        scan_btn = (Button)findViewById(R.id.btnscan);
        final Activity activity = this;
        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.initiateScan();
            }
        });
    }
    protected void onActivityResult(int requestCode , int resultCode , Intent data){
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result != null){
            if (result.getContents()==null){
                Toast.makeText(this,"You cancelled the scanning", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,result.getContents(),Toast.LENGTH_LONG).show();
            }

        }
        else{
            super.onActivityResult(requestCode,resultCode,data);
        }
    }
}
