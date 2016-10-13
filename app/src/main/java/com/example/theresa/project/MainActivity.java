package com.example.theresa.project;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends Activity {

    GridView grid;
    // Create an array that saves the country names
    private String[] countries = {"China", "India", "United States", "Indonesia", "Brazil", "Pakistan", "Nigeria", "Bangladesh", "Russia",
                                  "Japan", "Mexico", "Phillipines", "Ethiopia", "Vietnam", "Egypt", "Turkey", "Germany", "Iran", "Democratic Republic of the Congo", "Thailand"};

    private int[] imageId = {R.drawable.china, R.drawable.india, R.drawable.unitedstates, R.drawable.indonesia, R.drawable.brazil, R.drawable.pakistan, R.drawable.nigeria, R.drawable.bangladesh,
                             R.drawable.russia, R.drawable.japan, R.drawable.mexico, R.drawable.phillipines, R.drawable.ethiopia, R.drawable.vietnam, R.drawable.egypt, R.drawable.turkey, R.drawable.germany,
                             R.drawable.iran, R.drawable.republicofthecongo, R.drawable.thailand};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomGrid adapter = new CustomGrid(MainActivity.this, countries, imageId);
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Toast.makeText(MainActivity.this, "You Clicked at " +countries[+ position], Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, CountryActivity.class);
                i.putExtra("country",countries[+ position]);
                i.putExtra("position", position);
                i.putExtra("imageIds", imageId);
                startActivity(i);
            }
        });
    }
}
