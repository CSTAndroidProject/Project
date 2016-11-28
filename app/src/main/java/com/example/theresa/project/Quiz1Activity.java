package com.example.theresa.project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Quiz1Activity extends AppCompatActivity{

    private List<Country> countryList = new ArrayList<Country>();
    private Country country;
    private ImageView flag;
    private Button option_1;
    private Button option_2;
    private Button option_3;
    private Button option_4;
    private static int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz1);
        initCountries();
        loadQuestion();
    }

    private void loadQuestion(){

        this.flag = (ImageView)findViewById(R.id.imageView);
        this.option_1 = (Button)findViewById(R.id.button1);
        this.option_2 = (Button)findViewById(R.id.button2);
        this.option_3 = (Button)findViewById(R.id.button3);
        this.option_4 = (Button)findViewById(R.id.button4);

        // load flag image randomly
        int rndInt = new Random().nextInt(countryList.size());
        country = countryList.get(rndInt);
        int resID = country.getImageId();
        String answer = country.getName();
        flag.setImageResource(resID);

        // remove duplicate
        List<Country> countries = pickName(countryList,4);
        String [] options = {answer,countries.get(0).getName(),countries.get(1).getName(),countries.get(2).getName()};
        for (int i = 0; i < options.length; i++) {
            for (int k = i + 1; k < options.length; k++) {
                if (options[i] == options[k]) {
                    options[k]= countries.get(3).getName();
                }
            }
        }

        // load four options on the button randomly
        Button btns[] = {this.option_1, this.option_2, this.option_3, this.option_4};
        List<Integer> idx = new ArrayList<Integer>();
        for (final Button btn: btns){
            int n = new Random().nextInt(4);
            while(idx.contains(n)){
                n = new Random().nextInt(4);
            }
            idx.add(n);
            btn.setText(options[n]);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button clicked = (Button)view;
                    if(clicked.getText().toString()== country.getName()){
                        Toast.makeText(Quiz1Activity.this, "Correct!", Toast.LENGTH_SHORT).show();
                        score++;
                        TextView scores = (TextView) findViewById(R.id.scoreText);
                        scores.setText(Integer.toString(score));
                        loadQuestion();
                    }else{
                        Toast.makeText(Quiz1Activity.this, "Wrong!", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }
            });
        }
    }

    public static List<Country> pickName(List<Country>lst, int n){
        List<Country> names = new LinkedList<Country>(lst);
        Collections.shuffle(names);
        return names.subList(0, n);
    }

    private void initCountries(){
        Country australia = new Country( R.drawable.flag_australia, "Australia");
        countryList.add(australia);
        Country brazil = new Country( R.drawable.flag_brazil, "Brazil");
        countryList.add(brazil);
        Country canada = new Country( R.drawable.flag_canada, "Canada");
        countryList.add(canada);
        Country china = new Country( R.drawable.flag_china, "China");
        countryList.add(china);
        Country egypt = new Country( R.drawable.flag_egypt, "Egypt");
        countryList.add(egypt);
        Country france = new Country( R.drawable.flag_france, "France");
        countryList.add(france);
        Country germany = new Country( R.drawable.flag_germany, "Germany");
        countryList.add(germany);
        Country india = new Country( R.drawable.flag_india, "India");
        countryList.add(india);
        Country ireland = new Country( R.drawable.flag_ireland, "Republic of Ireland");
        countryList.add(ireland);
        Country italy = new Country( R.drawable.flag_italy, "Italy");
        countryList.add(italy);
        Country russia = new Country( R.drawable.flag_russia, "Russia");
        countryList.add(russia);
        Country japan = new Country( R.drawable.flag_japan, "Japan");
        countryList.add(japan);
        Country unitedstates = new Country( R.drawable.flag_unitedstates, "United States");
        countryList.add(unitedstates);
        Country mexico = new Country( R.drawable.flag_mexico, "Mexico");
        countryList.add(mexico);
        Country vietnam = new Country( R.drawable.flag_vietnam, "Vietnam");
        countryList.add(vietnam);
        Country southkorea = new Country( R.drawable.flag_korea, "South Korea");
        countryList.add(southkorea);
        Country unitedkingdom = new Country( R.drawable.flag_unitedkingdom, "United Kingdom");
        countryList.add(unitedkingdom);
        Country turkey = new Country( R.drawable.flag_turkey, "Turkey");
        countryList.add(turkey);
        Country thailand= new Country( R.drawable.flag_thailand, "Thailand");
        countryList.add(thailand);
        Country spain = new Country( R.drawable.flag_spain, "Spain");
        countryList.add(spain);
    }

}
