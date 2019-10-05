package com.example.myviewmodel;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class WeatherItems {
    private int id;
    private String name;
    private String currentWeather;
    private String description;
    private String temperature;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(String currentWeather) {
        this.currentWeather = currentWeather;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    WeatherItems(JSONObject jsonObject){
        try {
            String name = jsonObject.getString("name");
            String currentWeather = jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            String description = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
            double tempInKelvin = jsonObject.getJSONObject("main").getDouble("temp");
            double tempInCelsius = tempInKelvin - 273;
            String temperature = new DecimalFormat("##.##").format(tempInCelsius);
            this.id = id;
            this.name = name;
            this.currentWeather = currentWeather;
            this.description = description;
            this.temperature = temperature;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
