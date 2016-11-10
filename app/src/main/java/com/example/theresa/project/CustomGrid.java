package com.example.theresa.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Theresa on 2016-10-04.
 */
public class CustomGrid extends ArrayAdapter<Country>{

    private int resourceId;

    public CustomGrid(Context context, int textViewResourceId, List<Country> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Country country = getItem(position);
        View grid;
        if (convertView == null) {
            grid = LayoutInflater.from(getContext()).inflate(resourceId, null);
        } else {
            grid = (View) convertView;
        }
        TextView textView = (TextView) grid.findViewById(R.id.grid_text);
        ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
        textView.setText(country.getName());
        imageView.setImageResource(country.getImageId());

        return grid;
    }
}