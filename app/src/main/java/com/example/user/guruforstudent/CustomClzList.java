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
 * Created by USER on 4/6/2018.
 */

public class CustomClzList extends ArrayAdapter<String> {
    private String[] clzes;
    private Activity context;
    public CustomClzList(Activity context,String[] clzes) {
        super(context, R.layout.listview_clz,clzes);
        this.context = context;
        this.clzes = clzes;

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
            viewHolder.btn = (Button) r.findViewById(R.id.btnPay);
            viewHolder.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(),"Button was clicked at "+position,Toast.LENGTH_SHORT).show();
                }
            });
            r.setTag(viewHolder);
        }
        else{
            viewHolder = (CustomClzList.ViewHolder) r.getTag();
        }
        viewHolder.tv2.setText(clzes[position]);
        return r;
    }
    class ViewHolder{
        TextView tv2;
        Button btn;
        ViewHolder(View v){
            tv2 = v.findViewById(R.id.tvClz);
        }
    }
}



