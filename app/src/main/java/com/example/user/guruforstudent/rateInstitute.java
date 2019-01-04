package com.example.user.guruforstudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.guruforstudent.Models.Institue;
import com.example.user.guruforstudent.Models.Student;
import com.example.user.guruforstudent.Models.User;
import com.example.user.guruforstudent.Models.teacher;

import java.util.List;

public class rateInstitute extends AppCompatActivity {
    ListView list_1;
    Student std;
    teacher tch;
    User user;
    Institue institue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_institute);
            std = new Student();
            tch = new teacher();
            user =new User();
            institue = new Institue();
            String id;
            int ulevel = user.getCurIdCurLevel(); //check whether the current user level is student or teacher
            if(ulevel == 4) { //the current user is student
                id = Integer.toString(std.getCurStId());
                final List<String> insName = std.getAllStRegIns(id); //this make final because use for inner class
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_classes);
                list_1 = (ListView)findViewById(R.id.clzlistview);

                CustomClzList customClzList = new CustomClzList(this,insName);
                list_1.setAdapter(customClzList);
                list_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(rateInstitute.this,"Rate "+insName.get(position) ,Toast.LENGTH_SHORT).show();
                        String instname = insName.get(position); //get the institute name using clicked item index for insName list
                        int insId = institue.getInsId(instname); //to convert to the institute id
                        int stid = std.getCurStId(); //re get the current student id
                        openRateg(stid,insId); // to open the rate page


                    }
                });
            }
          /*  else if(ulevel == 3) { //the current user is teacher
                id = Integer.toString(tch.getCurTeachId());
                final List<String> insName = tch.getAllTeachRegIns(id);
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_classes);
                list_1 = (ListView)findViewById(R.id.clzlistview);

                CustomClzList customClzList = new CustomClzList(this,insName);
                list_1.setAdapter(customClzList);
                list_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(InstituteList.this,"View Your "+insName.get(position) +" Courses",Toast.LENGTH_SHORT).show();
                        String instname = insName.get(position);
                        String insId = institue.getInsId(instname);
                        institute_id = insId;
                        String tid = Integer.toString(tch.getCurTeachId());
                        crsName = tch.getAllTeachRegCrs(tid,insId); //get the registered course name list of selected Institute and save to static list
                        openCrslistpg(); // to open the crslist page


                    }
                });
            } */

        }

    private void openRateg(int stid, int insId) {
        Intent intent = new Intent(this, viewComments.class);
        intent.putExtra("studentId",stid); //to pass to the next page
        intent.putExtra("instituteId",insId);
        startActivity(intent);
    }
}

