package com.example.WeatherViewer;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class WeatherController {
    private int temperature = 0;
    private int humidity = 0;
    private String location = "Moscow";
    private String country = "Russia";
    private String serviceProvider = "weatherstack";
    private String weatherImageURL = "https://via.placeholder.com/100.png/09f/fff";
    private String weatherDescription = "Cloudy";
    public String serviceLink = "#";

    public Date currentTime = new Date();

    public String getCurrentTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy, hh:mm:ss", Locale.ENGLISH);
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

        switch (serviceProvider){
            case "weatherstack":{
                System.out.println("New instance of weatherstack creating: "+location);

                RestTemplate restTemplate = new RestTemplate();
                Weatherstack weatherstack = restTemplate.getForObject( Weatherstack.getUrl(location), Weatherstack.class );
                weatherImageURL = ( (List<String>) weatherstack.current.get("weather_icons") ).get(0);
                weatherDescription =( (List<String>) weatherstack.current.get("weather_descriptions") ).get(0);
                temperature = (int) weatherstack.current.get("temperature");
                humidity = (int) weatherstack.current.get("humidity");
                this.location = (String) weatherstack.location.get("name");
                country = (String) weatherstack.location.get("country");
                serviceLink = "https://weatherstack.com";
                break;
            }
            case "Яндекс.Погода":{
                System.out.println("New instance of Яндекс.Погода creating: "+location);
                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                headers.set("X-Yandex-API-Key", YandexWeather.getAccessKey());
                HttpEntity<YandexWeather> httpEntity = new HttpEntity<>(null, headers);
                ResponseEntity<YandexWeather> result = restTemplate.exchange(YandexWeather.getURI(location),HttpMethod.GET,httpEntity,YandexWeather.class);
                YandexWeather yandexWeather = result.getBody();
                weatherImageURL =YandexWeather.getIconURL((String) yandexWeather.fact.get("icon"));
                weatherDescription = YandexWeather.getWeatherCondition((String) yandexWeather.fact.get("condition"));
                temperature = (int) yandexWeather.fact.get("temp");
                humidity = (int) yandexWeather.fact.get("humidity");
                this.location = location;
                serviceLink = (String) yandexWeather.info.get("url");
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
