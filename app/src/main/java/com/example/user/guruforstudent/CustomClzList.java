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

/**
 * Created by USER on 4/6/2018.
 */

public class CustomClzList extends ArrayAdapter<String> {
    List<String> insName;
    private Activity context;
    public CustomClzList(Activity context, List<String> insName) {
        super(context, R.layout.listview_clz,insName);
        this.context = context;
        this.insName = insName;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        CustomClzList.ViewHolder viewHolder = null;
        if(r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.listview_clz,null,true);
            viewHolder = new CustomClzList.ViewHolder(r);

            r.setTag(viewHolder);
        }
        else{
            viewHolder = (CustomClzList.ViewHolder) r.getTag();
        }
        viewHolder.tv2.setText(insName.get(position));

        return r;
    }
    class ViewHolder{
        TextView tv2;

        ViewHolder(View v){
            tv2 = v.findViewById(R.id.tvClz);
        }
    }
}



