package com.example.user.guruforstudent;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by USER on 4/2/2018.
 */

public class CustomListview extends ArrayAdapter<String>{
private String[] classes;
private Activity context;
    public CustomListview(Activity context,String[] classes) {
        super(context, R.layout.listview1_item,classes);
        this.context = context;
        this.classes = classes;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        ViewHolder viewHolder = null;
        if(r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.listview1_item,null,true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) r.getTag();
        }
        viewHolder.tv1.setText(classes[position]);
        return r;
    }
    class ViewHolder{
        TextView tv1;
        ViewHolder(View v){
            tv1 = v.findViewById(R.id.tvClass);
        }
    }
}
