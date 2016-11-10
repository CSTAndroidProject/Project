package com.example.theresa.project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.lang.reflect.Field;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Class drawableClass = R.drawable.class;
        Field[] fields = drawableClass.getFields();
        Random rand = new Random();
        int rndInt = rand.nextInt(fields.length);
        try {
            int resID = fields[rndInt].getInt(drawableClass);
            ImageView img = (ImageView)findViewById(R.id.imageView);
            img.setImageResource(resID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
