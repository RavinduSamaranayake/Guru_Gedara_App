package com.example.user.guruforstudent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ListView;
import android.widget.Toast;

import com.example.user.guruforstudent.Models.Student;
import com.example.user.guruforstudent.Models.User;
import com.example.user.guruforstudent.Models.teacher;

import java.util.List;

public class classes extends AppCompatActivity {
    ListView list_1;
    Student std;
    teacher tch;
    User user;

    //String[] clzes = {"Class 01","Class 02","Class 03"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        std = new Student();
        tch = new teacher();
        user =new User();
        String id;
        int ulevel = user.getCurIdCurLevel(); //check whether the current user level is student or teacher
        if(ulevel == 4) { //the current user is student
            id = Integer.toString(std.getCurStId());
            List<String> insName = std.getAllStRegIns(id);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_classes);
            list_1 = (ListView)findViewById(R.id.clzlistview);

            CustomClzList customClzList = new CustomClzList(this,insName);
            list_1.setAdapter(customClzList);
        }
        else if(ulevel == 3) { //the current user is teacher
            id = Integer.toString(tch.getCurTeachId());
            List<String> insName = tch.getAllTeachRegIns(id);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_classes);
            list_1 = (ListView)findViewById(R.id.clzlistview);

            CustomClzList customClzList = new CustomClzList(this,insName);
            list_1.setAdapter(customClzList);
        }

        }
}
