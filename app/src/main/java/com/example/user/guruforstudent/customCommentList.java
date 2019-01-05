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

public class customCommentList extends ArrayAdapter<String> {
    List<String> commentList;
    private Activity context;
    public customCommentList(Activity context, List<String> commentList) {
        super(context, R.layout.comment_item,commentList);
        this.context = context;
        this.commentList = commentList;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;
        customCommentList.ViewHolder viewHolder = null;
        if(r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.comment_item,null,true);
            viewHolder = new customCommentList.ViewHolder(r);

            r.setTag(viewHolder);
        }
        else{
            viewHolder = (customCommentList.ViewHolder) r.getTag();
        }
        viewHolder.tv2.setText(commentList.get(position));

        return r;
    }
    class ViewHolder{
        TextView tv2;

        ViewHolder(View v){
            tv2 = v.findViewById(R.id.tvcomment);
        }
    }
}

