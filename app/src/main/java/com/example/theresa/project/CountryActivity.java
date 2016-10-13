package com.example.theresa.project;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CountryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        Intent i = getIntent();
        String name = i.getStringExtra("name");
        int position = i.getIntExtra("position", 0);
        int[] itemId = i.getIntArrayExtra("imageIds");
    }
}
