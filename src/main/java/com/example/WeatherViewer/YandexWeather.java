package com.example.WeatherViewer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YandexWeather {
    public Map<String,Object> fact;
    public Map<String,Object> info;

    private static String accessKey = "4c1c3e7b-707e-4ced-b45e-3524c48d42dc";
    private static String startGetString = "https://api.weather.yandex.ru/v1/forecast?";
    private static Map<String,String> cities = new HashMap<String,String>();
    static{
      cities.put("Chelyabinsk","lat=55.164440&lon=61.436844");
      cities.put("Moscow","lat=55.751244&lon=37.618423");
      cities.put("Ekaterinburg","lat=56.833332&lon=60.583332");
      cities.put("Perm","lat=58.000000&lon=56.316666");
      cities.put("Ufa","lat=54.733334&lon=56.000000");
      cities.put("Rostov-na-Donu","lat=47.233334&lon=39.700001");
      cities.put("Omsk","lat=54.983334&lon=73.366669");
      cities.put("Kazan","lat=55.796391&lon=49.108891");
      cities.put("St. Petersburg","lat=59.937500&lon=30.308611");
      cities.put("Tobolsk","lat=58.200348&lon=68.256332");
      cities.put("Berdsk","lat=54.766323&lon=83.086037");
      cities.put("Kaliningrad","lat=54.715424&lon=20.509207");
      cities.put("Yaroslavl","lat=57.629971&lon=39.872799");
      cities.put("Blagoveshchensk","lat=50.272778&lon=127.540405");
      cities.put("Astrakhan","lat=46.358803&lon=48.059937");
      cities.put("Vorkuta","lat=67.496780&lon=64.060638");
      cities.put("Krasnodar","lat=45.039268&lon=38.987221");
      cities.put("Orenburg","lat=51.776272&lon=55.099594");
      cities.put("Makhachkala","lat=42.966633&lon=47.512630");
      cities.put("Tambov","lat=52.723598&lon=41.442307");
      cities.put("Samara","lat=53.241505&lon=50.221245");
      cities.put("Saratov","lat=51.592365&lon=45.960804");
      cities.put("Tyumen","lat=57.161297&lon=65.525017");
      cities.put("Yakutsk","lat=62.035454&lon=129.675476");
      cities.put("Berezniki","lat=59.410412&lon=56.791721");
      cities.put("Lyubertsy","lat=55.688713&lon=37.901073");
      cities.put("Salekhard","lat=66.530426&lon=66.613708");
      cities.put("Vladimir","lat=56.143063&lon=40.410934");
      cities.put("Sochi","lat=43.588348&lon=39.729996");
      cities.put("Magadan","lat=59.560246&lon=150.798599");
      cities.put("Arkhangelsk","lat=64.542465&lon=40.537319");
      cities.put("Kostroma","lat=57.767193&lon=40.976257");
      cities.put("Volgograd","lat=48.700001&lon=44.516666");
      cities.put("Syktyvkar","lat=61.666668&lon=50.816666");
      cities.put("Yoshkar-Ola","lat=56.633331&lon=47.866669");
      cities.put("Fryazino","lat=55.950001&lon=38.049999");
      cities.put("Vologda","lat=59.222340&lon=39.882431");
      cities.put("Novosibirsk","lat=55.018803&lon=82.933952");
    };
    public static String getIconURL(String icon){
        return "https://yastatic.net/weather/i/icons/blueye/color/svg/"+icon+".svg";
    }
    public static String getWeatherCondition(String condition){
        return condition.replaceAll("-"," ");
    }
    public static String getURI(String location){
        return startGetString+cities.get(location);
    }
    public static String getAccessKey(){
        return accessKey;
    }


}
