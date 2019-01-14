package com.laudablesolutions.cricwiz;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdopter extends ArrayAdapter<RowItems> {

    LayoutInflater flater;

    public CustomAdopter(Activity context,int resouceId, int textviewId, List<RowItems> list){

        super(context,resouceId,textviewId, list);
        flater = context.getLayoutInflater();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        RowItems rowItem = getItem(position);

        View rowview = flater.inflate(R.layout.list_view_items,null,true);

        TextView txtTitle = (TextView) rowview.findViewById(R.id.title);
        txtTitle.setText(rowItem.getTitle());

        ImageView imageView = (ImageView) rowview.findViewById(R.id.icon);
        imageView.setImageResource(rowItem.getImageId());

        return rowview;
    }
}
