package com.example.thjen.swipelistviewdemo;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class adapter extends BaseAdapter {

    List<item> list;
    Context context;
    int layout;

    public adapter ( Context context, int layout , List list) {

        this.context = context;
        this.layout = layout;
        this.list = list;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder {

        TextView tv1, tv2,tv3;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder = new ViewHolder();

        if ( view == null ) {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout, null);
            holder.tv1 = view.findViewById(R.id.tv1);
            holder.tv2 = view.findViewById(R.id.tv2);
            holder.tv3 = view.findViewById(R.id.tv3);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.tv1.setText(list.get(i).getItem1());
        holder.tv2.setText(list.get(i).getItem2());
        holder.tv3.setText(list.get(i).getItem3());

        return view;
    }

}
