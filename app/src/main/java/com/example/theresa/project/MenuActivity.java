package com.example.theresa.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button btnName = (Button)findViewById(R.id.btn_name);
        Button btnFlag = (Button)findViewById(R.id.btn_flag);

        btnName.setOnClickListener(this);
        btnFlag.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn_name){
            this.startActivity( new Intent(MenuActivity.this, Quiz1Activity.class));
        }else if(view.getId()==R.id.btn_flag){
            this.startActivity( new Intent(MenuActivity.this, Quiz2Activity.class));
        }
    }
}
