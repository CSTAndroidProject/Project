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

public class Quiz2Activity extends AppCompatActivity{

    private List<Country> countryList = new ArrayList<Country>();
    private Country country;
    private Button name;
    private ImageView flag1;
    private ImageView flag2;
    private ImageView flag3;
    private ImageView flag4;
    private static int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);
        initCountries();
        loadQuestion();
    }

    private void loadQuestion(){
        this.name = (Button)findViewById(R.id.button);
        this.flag1 = (ImageView)findViewById(R.id.image1);
        this.flag2 = (ImageView)findViewById(R.id.image2);
        this.flag3 = (ImageView)findViewById(R.id.image3);
        this.flag4 = (ImageView)findViewById(R.id.image4);

        // load country name randomly
        int rndInt = new Random().nextInt(countryList.size());
        country = countryList.get(rndInt);
        String rndStr = country.getName();
        int answer = country.getImageId();
        this.name.setText(rndStr);

        // load four options on imageView randomly
        List<Country> countries = pickFlag(countryList,4);
        int [] options = {answer, countries.get(0).getImageId(), countries.get(1).getImageId(), countries.get(2).getImageId()};
        for (int i = 0; i < options.length; i++) {
            for (int k = i + 1; k < options.length; k++) {
                if (options[i] == options[k]) {
                    options[k]= countries.get(3).getImageId();
                }
            }
        }

        // load four options on the imageView randomly
        ImageView images[] = {this.flag1, this.flag2, this.flag3, this.flag4};
        List<Integer> idx = new ArrayList<Integer>();
        for (final ImageView image: images){
            int n = new Random().nextInt(4);
            while(idx.contains(n)){
                n = new Random().nextInt(4);
            }
            idx.add(n);
            image.setImageResource(options[n]);
            image.setTag(options[n]);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(getDrawableId(image)==country.getImageId()){
                        Toast.makeText(Quiz2Activity.this, "Correct!", Toast.LENGTH_SHORT).show();
                        score++;
                        TextView scores = (TextView) findViewById(R.id.scoreText);
                        scores.setText(Integer.toString(score));
                        loadQuestion();
                    }else{
                        Toast.makeText(Quiz2Activity.this, "Wrong!", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }
            });
        }
    }

    private int getDrawableId(ImageView iv) {
        return (Integer) iv.getTag();
    }

    public static List<Country> pickFlag(List<Country>lst, int n){
        List<Country> flags = new LinkedList<Country>(lst);
        Collections.shuffle(flags);
        return flags.subList(0, n);
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
        Country ireland = new Country( R.drawable.flag_ireland, "Ireland");
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
