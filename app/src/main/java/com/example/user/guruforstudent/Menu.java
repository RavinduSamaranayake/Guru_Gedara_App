package com.example.user.guruforstudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
     Button mlistpg;
     Button authpg;
     Button instpg;
     Button timepg;
     Button propg;
     Button msgpg;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mlistpg = (Button)findViewById(R.id.btnMain);
        authpg = (Button)findViewById(R.id.btnAuth);
        instpg =(Button)findViewById(R.id.btnIns);
        timepg =(Button)findViewById(R.id.btnTime);
        propg = (Button)findViewById(R.id.btnPro);
        msgpg = (Button)findViewById(R.id.btnMsg);
        mlistpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainlistpg();
            }
        });
        propg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPropg();
            }
        });
        authpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAuthpg();
            }
        });
        instpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInstpg();
            }
        });
        timepg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTimepg();
            }
        });
        msgpg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMsgpg();
            }
        });
    }
    public void openMainlistpg() {
        Intent intent = new Intent(this,MainList.class);
        startActivity(intent);
    }
    public void openAuthpg() {
        Intent intent = new Intent(this,Auth.class);
        startActivity(intent);
    }
    public void openInstpg() {
        Intent intent = new Intent(this,Institutes.class);
        startActivity(intent);
    }
    public void openTimepg() {
    }
    public void openMsgpg() {
    }
    public void openPropg() {
    }



}
