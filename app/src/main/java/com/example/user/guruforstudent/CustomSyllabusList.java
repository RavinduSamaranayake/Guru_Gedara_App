package com.example.user.guruforstudent;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


import static com.example.user.guruforstudent.R.layout.syllabuslist;

/**
 * Created by USER on 4/6/2018.
 */

public class CustomSyllabusList extends ArrayAdapter<List<String>> {
    List<List<String>> syllabusName;
    private Activity context;
    public CustomSyllabusList(Activity context, List<List<String>> syllabusName) {
        super(context,R.layout.syllabuslist,syllabusName);
        this.context = context;
        this.syllabusName = syllabusName;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        CustomSyllabusList.ViewHolder viewHolder = null;
        if(r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.listview_institute,null,true);
            viewHolder = new CustomSyllabusList.ViewHolder(r);
            r.setTag(viewHolder);
        }
        else{
            viewHolder = (CustomSyllabusList.ViewHolder) r.getTag();
        }
        viewHolder.tv2.setText(syllabusName.get(position).get(0));
        return r;
    }

    class ViewHolder{ // this class use to create the items in a list item
        TextView tv2;
        ViewHolder(View v){
            tv2 = v.findViewById(R.id.tvIns);
        }
    }
}
