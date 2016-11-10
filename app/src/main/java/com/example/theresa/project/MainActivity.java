package com.example.theresa.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    GridView grid;

    private List<Country> countryList = new ArrayList<Country>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCountries();

        CustomGrid adapter = new CustomGrid(MainActivity.this, R.layout.grid_single, countryList);
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Toast.makeText(MainActivity.this, "You Clicked at " +countries[+ position], Toast.LENGTH_SHORT).show();
                Country country = countryList.get(position);
                Intent intent = new Intent(MainActivity.this, CountryActivity.class);
                intent.putExtra("imageIds", country.getImageId());
                intent.putExtra("country", country.getName());
                startActivity(intent);
            }
        });
        Button quiz = (Button)findViewById(R.id.button);
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });
    }
    private void initCountries(){
        Country australia = new Country( R.drawable.australia, "Australia");
        countryList.add(australia);
        Country brazil = new Country( R.drawable.brazil, "Brazil");
        countryList.add(brazil);
        Country canada = new Country( R.drawable.canada, "Canada");
        countryList.add(canada);
        Country china = new Country( R.drawable.china, "China");
        countryList.add(china);
        Country egypt = new Country( R.drawable.egypt, "Egypt");
        countryList.add(egypt);
        Country france = new Country( R.drawable.france, "France");
        countryList.add(france);
        Country germany = new Country( R.drawable.germany, "Germany");
        countryList.add(germany);
        Country india = new Country( R.drawable.india, "India");
        countryList.add(india);
        Country ireland = new Country( R.drawable.ireland, "Republic of Ireland");
        countryList.add(ireland);
        Country italy = new Country( R.drawable.italy, "Italy");
        countryList.add(italy);
        Country russia = new Country( R.drawable.russia, "Russia");
        countryList.add(russia);
        Country japan = new Country( R.drawable.japan, "Japan");
        countryList.add(japan);
        Country unitedstates = new Country( R.drawable.unitedstates, "United States");
        countryList.add(unitedstates);
        Country mexico = new Country( R.drawable.mexico, "Mexico");
        countryList.add(mexico);
        Country vietnam = new Country( R.drawable.vietnam, "Vietnam");
        countryList.add(vietnam);
        Country southkorea = new Country( R.drawable.korea, "South Korea");
        countryList.add(southkorea);
        Country unitedkingdom = new Country( R.drawable.unitedkingdom, "United Kingdom");
        countryList.add(unitedkingdom);
        Country turkey = new Country( R.drawable.turkey, "Turkey");
        countryList.add(turkey);
        Country thailand= new Country( R.drawable.thailand, "Thailand");
        countryList.add(thailand);
        Country spain = new Country( R.drawable.spain, "Spain");
        countryList.add(spain);
    }
}
