package com.example.WeatherViewer;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class WeatherController {
    private int temperature;
    private int humidity;
    private String location;
    private String country;
    private String serviceProvider;
    private String weatherImageURL;
    private String weatherDescription;

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public void setWeatherImageURL(String weatherImageURL) {
        this.weatherImageURL = weatherImageURL;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public void setServiceLink(String serviceLink) {
        this.serviceLink = serviceLink;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    private String serviceLink;

    public Date currentTime;

    public String getCurrentTime() {
        currentTime = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy, HH:mm:ss", Locale.ENGLISH);
        return simpleDateFormat.format(currentTime);
    }

    public String getServiceLink() {
        return serviceLink;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public String getCountry() {
        return country;
    }

    public String getWeatherImageURL() {
        return weatherImageURL;
    }

    public String getLocation() {
        return location;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public WeatherController(String location, String serviceProvider) {

        this.location = location;
        this.serviceProvider = serviceProvider;
        this.temperature = 0;
        this.humidity = 0;
        this.country = "Russia";
        this.weatherImageURL = "https://via.placeholder.com/100.png/09f/fff";
        this.weatherDescription = "Clear";
        this.serviceLink = "#";

        switch (serviceProvider){
            case "weatherstack":{
                Weatherstack.getActualWeather(this);
                break;
            }
            case "Яндекс.Погода":{
                YandexWeather.getActualWeather(this);
                break;
            }

        }
    }

    public int getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }
}
