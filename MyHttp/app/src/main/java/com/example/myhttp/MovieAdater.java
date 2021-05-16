package com.example.myhttp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MovieAdater extends BaseAdapter {
    List<MovieVO> list;



    public MovieAdater(List<MovieVO> list) {
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
        View view = inflater.inflate(R.layout.movie_item, parent, false);

        TextView tvTitle = view.findViewById(R.id.tvTitle);
        TextView tvCode = view.findViewById(R.id.tvCode);
        TextView tvOpenday = view.findViewById(R.id.tvOpenDay);

        tvTitle.setText( list.get(position).getTitle() );
        tvCode.setText( list.get(position).getCode() );
        tvOpenday.setText( list.get(position).getOpenDay() );
        return view;
    }
}
