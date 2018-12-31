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

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by USER on 4/5/2018.
 */
//this class use to create the crs name list view.......
public class CustomMainList extends ArrayAdapter<String> {

    List<String> crsNameList;
    private Activity context;
    public CustomMainList(Activity context, List<String> crsNameList) {
        super(context, R.layout.listview_institute,crsNameList);
        this.context = context;
        this.crsNameList = crsNameList;

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
            r.setTag(viewHolder);
        }
        else{
            viewHolder = (CustomMainList.ViewHolder) r.getTag();
        }
        viewHolder.tv2.setText(crsNameList.get(position));
        return r;
    }

    class ViewHolder{ // this class use to create the items in a list item
        TextView tv2;
        ViewHolder(View v){
            tv2 = v.findViewById(R.id.tvIns);
        }
    }
}

