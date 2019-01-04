package com.example.user.guruforstudent;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.user.guruforstudent.Models.Course;
import com.example.user.guruforstudent.Models.Institue;

import java.util.List;

public class viewComments extends AppCompatActivity {
    ListView list_1;
    FloatingActionButton addrevbtn;
    Institue ins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_comments);
        list_1 = (ListView)findViewById(R.id.commentlistview);
        ins = new Institue();
        addrevbtn = (FloatingActionButton)findViewById(R.id.addreview);
        final int stdid = Integer.parseInt(getIntent().getStringExtra("studentId"));
        final int insId = Integer.parseInt(getIntent().getStringExtra("instituteId"));
        List<String> commentList = ins.getComments(insId); //get the comment List...
        CustomMainList customMainList = new CustomMainList(this,commentList);

        list_1.setAdapter(customMainList); //set the list items for list view
        addrevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              addNewReviewPg(stdid,insId);
            }
        });


    }

    private void addNewReviewPg(int stdid, int insId) {   //to load to the add review custom layout

    }
}

