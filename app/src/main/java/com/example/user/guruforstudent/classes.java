package com.example.user.guruforstudent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ListView;
import android.widget.Toast;

import com.example.user.guruforstudent.Models.Student;

import java.util.List;

public class classes extends AppCompatActivity {
    ListView list_1;
    Student std;

    //String[] clzes = {"Class 01","Class 02","Class 03"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        std = new Student();
        String id = Integer.toString(4);
        List<String> insName = std.getAllStRegIns(id);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);
        list_1 = (ListView)findViewById(R.id.clzlistview);

        CustomClzList customClzList = new CustomClzList(this,insName);
        list_1.setAdapter(customClzList);
        }
}
