package com.example.user.guruforstudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.guruforstudent.Controls.FileRW;
import com.example.user.guruforstudent.Models.Course;
import com.example.user.guruforstudent.Models.Institue;

import java.util.ArrayList;
import java.util.List;

public class ChooseInstitue extends AppCompatActivity {
    Spinner crsSpin;
    Spinner spin;
    EditText regid;
    Button nxt;
   // Button logout;
    TextView regtxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting_reg);
        spin = (Spinner) findViewById(R.id.insNameSpin);
        crsSpin = (Spinner) findViewById(R.id.crsNameSpin);
        regid = (EditText)findViewById(R.id.reg);
        nxt = (Button)findViewById(R.id.toMainpg);
       // logout = (Button)findViewById(R.id.LogOut);
        regtxt =  (TextView) findViewById(R.id.tvregnm);

        loadSpin();
        //loadCrsSpin("E Soft Metro Campus");
        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomepg();
            }
        });
      /*  logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //FileRW rw = new FileRW();
                //rw.clearTheFile();
                tologinpg();

            }
        }); */
       spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // Notify the selected item text
                loadCrsSpin(selectedItemText);
                Toast.makeText
                        (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
                        .show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        }

    private void openHomepg() {
        Intent intent = new Intent(this,Home.class);
        startActivity(intent);
    }

  /*  public void tologinpg() {
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);


    } */

    private void loadSpin() {
        Institue ins = new Institue();
        List<String> insName = ins.getAllInstitutes();

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, insName);


        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // attaching data adapter to spinner
        spin.setAdapter(dataAdapter);


    }

    public void loadCrsSpin(String insname) {
        Course crs = new Course();
        List<String> crsName = crs.getAllcrs(insname);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, crsName);


        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // attaching data adapter to spinner
        crsSpin.setAdapter(dataAdapter);


    }

}
