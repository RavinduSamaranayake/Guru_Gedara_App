package com.example.user.guruforstudent;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by USER on 4/5/2018.
 */

public class CustomList2 extends ArrayAdapter<String> {
    private String[] Tutes;
    private Activity context;
    public CustomList2(Activity context,String[] Tutes) {
        super(context, R.layout.listview2_item,Tutes);
        this.context = context;
        this.Tutes = Tutes;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        CustomList2.ViewHolder viewHolder = null;
        if(r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.listview2_item,null,true);
            viewHolder = new CustomList2.ViewHolder(r);
            viewHolder.btn = (Button) r.findViewById(R.id.viewbtn);
            viewHolder.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(),"Button was clicked at "+position,Toast.LENGTH_SHORT).show();
                }
            });
            r.setTag(viewHolder);
        }
        else{
            viewHolder = (CustomList2.ViewHolder) r.getTag();
        }
        viewHolder.tv2.setText(Tutes[position]);
        return r;
    }
    class ViewHolder{
        TextView tv2;
        Button btn;
        ViewHolder(View v){
            tv2 = v.findViewById(R.id.tvClass);
        }
    }
}


