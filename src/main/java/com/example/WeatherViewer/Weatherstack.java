package com.example.WeatherViewer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weatherstack {

    private static String accessKey = "01062c331431a73b9df07cb0d58d22f4";
    private static String startGetString = "http://api.weatherstack.com/current?access_key="+accessKey+"&query=";

    public static String getUrl(String location) {
        return startGetString+location;
    }

    public Map<String,Object> request;
    public Map<String,Object> location;
    public Map<String,Object> current;

    public static void getActualWeather(WeatherController weatherController){
        System.out.print("New instance of weatherstack creating for location: "+ weatherController.getLocation() +" ");
        try{
            RestTemplate restTemplate = new RestTemplate();
            Weatherstack weatherstack = restTemplate.getForObject( Weatherstack.getUrl(weatherController.getLocation()), Weatherstack.class );
            weatherController.setWeatherImageURL(((List<String>) weatherstack.current.get("weather_icons")).get(0));
            weatherController.setWeatherDescription(((List<String>) weatherstack.current.get("weather_descriptions")).get(0));
            weatherController.setTemperature((int) weatherstack.current.get("temperature"));
            weatherController.setHumidity((int) weatherstack.current.get("humidity"));
            weatherController.setLocation((String) weatherstack.location.get("name"));
            weatherController.setCountry((String) weatherstack.location.get("country"));
            weatherController.setServiceLink("https://weatherstack.com");
            System.out.println("Done!");
        }
        catch (NullPointerException e){
            System.out.println("Exception! "+e);
        }

    }
}
