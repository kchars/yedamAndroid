package com.example.mylist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class EmpAdater extends BaseAdapter {
    List<EmpVO> list;

    public EmpAdater(List<EmpVO> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item, parent, false);
        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvMobile = view.findViewById(R.id.tvMobile);
        tvName.setText( list.get(position).getName() );
        tvMobile.setText( list.get(position).getMobile() );
        return view;
    }
}
