package com.example.user.guruforstudent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class classes extends AppCompatActivity {
    ListView list_1;

    String[] clzes = {"Class 01","Class 02","Class 03"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);
        list_1 = (ListView)findViewById(R.id.clzlistview);

        CustomClzList customClzList = new CustomClzList(this,clzes);
        list_1.setAdapter(customClzList);



    }

}
