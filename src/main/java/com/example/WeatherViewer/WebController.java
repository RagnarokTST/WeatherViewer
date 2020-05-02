package com.example.WeatherViewer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller

public class WebController {

    @GetMapping
    public String main(@RequestParam(name="serviceSelect", required=false, defaultValue = "") String serviceProvider,
                       @RequestParam(name="locationSelect", required=false, defaultValue = "") String location,
                       Map<String, Object> model,
                       HttpServletResponse response,
                       @CookieValue(value = "service", defaultValue = "") String ckService,
                       @CookieValue(value = "location", defaultValue = "") String ckLocation) {


        model.put("weatherstack","");
        model.put("Яндекс.Погода","");

        // looking for GET-data, if empty - searching data in COOKIES. If both empty - loading default.
        if(location.equals("")){
            location = ckLocation.equals("") ? "Moscow" : ckLocation;
        }
        if(serviceProvider.equals("")){
            serviceProvider = ckService.equals("") ? "weatherstack" : ckService;
        }
        model.put(serviceProvider,"selected");

        WeatherController actual = new WeatherController(location,serviceProvider);

        model.put("location", actual.getLocation());
        model.put("temperature",actual.getTemperature());
        model.put("humidity",actual.getHumidity());
        model.put("weatherImage",actual.getWeatherImageURL());
        model.put("country",actual.getCountry());
        model.put("weatherDescription",actual.getWeatherDescription());
        model.put("serviceLink",actual.getServiceLink());
        model.put("serviceProvider",actual.getServiceProvider());
        model.put("currentTime",actual.getCurrentTime());







        //adding COOKIE to save user's choice
        Cookie cookieService = new Cookie("service", serviceProvider);
        Cookie cookieLocation = new Cookie("location", location);
        response.addCookie(cookieService);
        response.addCookie(cookieLocation);

        return "main";
    }

}




