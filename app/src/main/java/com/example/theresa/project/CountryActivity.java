package com.example.theresa.project;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CountryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        Intent intent = getIntent();
        final String cname = intent.getStringExtra("country");
        final int cimage = intent.getIntExtra("imageIds", 0);

        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setImageResource(cimage);
        TextView countryName = (TextView)findViewById(R.id.countryText);
        countryName.setText(cname);

        new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... strings) {
                URL url = null;
                try {
                    url = new URL("https://restcountries.eu/rest/v1/name/" + cname);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                return requestContent(url);
            }

            @Override
            protected void onPostExecute(String res) {
                try {
                    JSONArray jsonArray = new JSONArray(res);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String name = jsonObject.getString("name");
                        String capital = jsonObject.getString("capital");
                        String region = jsonObject.getString("region");
                        String subregion = jsonObject.getString("subregion");
                        String population = jsonObject.getString("population");
                        String currency = jsonObject.getJSONArray("currencies").getString(0);
                        String language = jsonObject.getJSONArray("languages").getString(0);
                        if (name.equals(cname)){
                            TextView capitaltext = (TextView)findViewById(R.id.capitalText);
                            capitaltext.setText(capital);
                            TextView regiontext = (TextView)findViewById(R.id.regionText);
                            regiontext.setText(region);
                            TextView subregiontext = (TextView)findViewById(R.id.subregionText);
                            subregiontext.setText(subregion);
                            TextView populationtext = (TextView)findViewById(R.id.populationText);
                            populationtext.setText(population);
                            TextView currencytext = (TextView)findViewById(R.id.currencyText);
                            currencytext.setText(currency);
                            TextView languagetext = (TextView)findViewById(R.id.languageText);
                            languagetext.setText(language);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.execute();
    }

    public String requestContent(URL url) {
        HttpURLConnection connection = null;
        StringBuilder response = null;

        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null)
                connection.disconnect();
        }
        return response.toString();
    }
}


