package com.example.user.guruforstudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Institutes extends AppCompatActivity {

   ListView list_1;

    String[] Institutes = {"Institutes 01","Institutes 02","Institutes 03"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institutes);
        list_1 = (ListView)findViewById(R.id.institutelist);

        CustomMainList customMainList = new CustomMainList(this,Institutes);
        list_1.setAdapter(customMainList);
        list_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(Institutes.this,"List Item was clicked at "+position,Toast.LENGTH_SHORT).show();
                openClasspg();
            }
        });



    }

    public void openClasspg() {
        Intent intent = new Intent(this,classes.class);
        startActivity(intent);
    }

}
