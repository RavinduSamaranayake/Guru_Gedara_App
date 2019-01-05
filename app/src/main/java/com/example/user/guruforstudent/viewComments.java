package com.example.user.guruforstudent;

import android.app.Activity;
import android.app.Dialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
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
              addNewReviewPg(viewComments.this,stdid,insId);
            }
        });


    }

    private void addNewReviewPg(Activity activity, int stdid, int insId) {   //to load to the add review custom layout
        Dialog dialog =new Dialog(activity);
        dialog.setContentView(R.layout.ratings);
        dialog.setTitle("Review Institute");
        final RatingBar mRatingBar  = (RatingBar) findViewById(R.id.ratingBar);
        final TextView mRatingScale = (TextView) findViewById(R.id.tvRatingScale);
        final EditText mFeedback = (EditText) findViewById(R.id.etFeedback);
        final Button mSendFeedback = (Button) findViewById(R.id.btnSubmit);
        //set width of dialog
        int width =(int)(activity.getResources().getDisplayMetrics().widthPixels*0.95);
        //set high of dialog
        int high =(int)(activity.getResources().getDisplayMetrics().widthPixels*1);
        dialog.getWindow().setLayout(width,high);
        dialog.show();
        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                mRatingScale.setText(String.valueOf(v));
                switch ((int) ratingBar.getRating()) {
                    case 1:
                        mRatingScale.setText("Very bad");
                        break;
                    case 2:
                        mRatingScale.setText("Need some improvement");
                        break;
                    case 3:
                        mRatingScale.setText("Good");
                        break;
                    case 4:
                        mRatingScale.setText("Great");
                        break;
                    case 5:
                        mRatingScale.setText("Excellent");
                        break;
                    default:
                        mRatingScale.setText("");
                }
            }
        });

        mSendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFeedback.getText().toString().isEmpty()) {
                    Toast.makeText(viewComments.this, "Please fill in feedback text box", Toast.LENGTH_LONG).show();
                } else {
                    mFeedback.setText("");
                    mRatingBar.setRating(0);
                    Toast.makeText(viewComments.this, "Thank you for sharing your feedback", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

