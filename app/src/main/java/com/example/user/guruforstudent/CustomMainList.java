package com.example.user.guruforstudent;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
//import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
//import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by USER on 4/5/2018.
 */

public class CustomMainList extends ArrayAdapter<String> {

    private String[] Institutes;
    private Activity context;
    public CustomMainList(Activity context,String[] Institutes) {
        super(context, R.layout.listview_institute,Institutes);
        this.context = context;
        this.Institutes = Institutes;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        CustomMainList.ViewHolder viewHolder = null;
        if(r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.listview_institute,null,true);
            viewHolder = new CustomMainList.ViewHolder(r);
            viewHolder.btn = (Button) r.findViewById(R.id.viewbtn);
            viewHolder.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(),"Button was clicked at "+position,Toast.LENGTH_SHORT).show();
                    //openclzpg();
                }
            });
            r.setTag(viewHolder);
        }
        else{
            viewHolder = (CustomMainList.ViewHolder) r.getTag();
        }
        viewHolder.tv2.setText(Institutes[position]);
        return r;
    }

    public void openclzpg() {
        //Intent intent = new Intent(this,classes.class); This instance have given a error.. so I have to fix this problem later
        //startActivity(intent);
    }




    class ViewHolder{
        TextView tv2;
        Button btn;
        ViewHolder(View v){
            tv2 = v.findViewById(R.id.tvIns);
        }
    }
}

