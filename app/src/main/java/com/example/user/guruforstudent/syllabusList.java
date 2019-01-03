package com.example.user.guruforstudent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.guruforstudent.Models.Syllabus;

import java.util.List;

public class syllabusList extends AppCompatActivity {
    Syllabus syllabus;
    ListView list_1;
    //classes clz;
    //CourseList crs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus_list);
        list_1 = (ListView)findViewById(R.id.clzlistview);
        syllabus = new Syllabus();
        //clz = new classes();
        //crs = new CourseList();
        String insid = InstituteList.getInsId();
        String crsid = CourseList.getCrsId();
        List<List<String>> syllabuslist =  syllabus.getAllsyllabus(insid,crsid);

        CustomSyllabusList customsyllabus = new CustomSyllabusList(this,syllabuslist);
        list_1.setAdapter(customsyllabus); //set the list items for list view
        list_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
               // Toast.makeText(Institutes.this,"List Item was clicked at "+position,Toast.LENGTH_SHORT).show();

            }
        });

    }
}
