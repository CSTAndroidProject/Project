package com.example.theresa.project;

/**
 * Created by Tracy on 11/6/2016.
 */

public class Country {
    private int imageId;
    private String name;
    private String capital;
    private String region;
    private String subregion;
    private String population;
    private String currency;
    private String language;

    public Country(){
    }

    public Country(int imageId, String name){
        this.imageId = imageId;
        this.name = name;
    }
    public Country(String capital, String region, String subregion,
                   String population, String currency, String language ){

        this.capital = capital;
        this.region = region;
        this.subregion = subregion;
        this.population = population;
        this.currency = currency;
        this.language = language;
    }

    public int getImageId() {return imageId;}

    public String getName(){
        return name;
    }

    public String getCapital(){
        return capital;
    }

    public String getRegion(){
        return region;
    }

    public String getSubregion(){
        return subregion;
    }

    public String getPopulation(){
        return population;
    }

    public String getCurrency(){
        return currency;
    }

    public String getLanguage(){
        return language;
    }

}
