package com.example.WeatherViewer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weatherstack {

    public static String getAccessKey() {
        return accessKey;
    }
    private static String accessKey = "01062c331431a73b9df07cb0d58d22f4";
    private static String startGetString = "http://api.weatherstack.com/current?access_key="+accessKey+"&query=";

    public static String getUrl(String location) {
        return startGetString+location;
    }

    public Map<String,Object> request;
    public Map<String,Object> location;
    public Map<String,Object> current;
}
