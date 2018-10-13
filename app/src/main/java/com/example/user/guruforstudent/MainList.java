package com.example.user.guruforstudent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainList extends AppCompatActivity {
    ListView list_1;
    ListView list_2;
    String[] classes = {"class 01","class 02","class 03"};
    String[] Tutes = {"tute 01","tute 02","tute 03"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);
        list_1 = (ListView)findViewById(R.id.lv1);
        list_2 = (ListView)findViewById(R.id.lv2);
        CustomListview customListview = new CustomListview(this,classes);
        list_1.setAdapter(customListview);
        CustomList2 customList2 = new CustomList2(this,Tutes);
        list_2.setAdapter(customList2);
        list_2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainList.this,"List Item was clicked at "+position,Toast.LENGTH_SHORT).show();
            }
        });



    }
}
