package com.example.theresa.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * Created by Theresa on 2016-10-04.
 */
public class CustomGrid extends BaseAdapter{
    private Context mContext;
    private final String[] countries;
    private final int[] Imageid;

    public CustomGrid(Context c,String[] countries,int[] Imageid ) {
        mContext = c;
        this.Imageid = Imageid;
        this.countries = countries;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return countries.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_single, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            textView.setText(countries[position]);
            imageView.setImageResource(Imageid[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}