package ru.hudeez.oweather.api;


import org.json.JSONArray;
import org.json.JSONObject;
import ru.hudeez.oweather.WeatherClient;
import ru.hudeez.oweather.api.config.Configuration;
import ru.hudeez.oweather.api.exceptions.APIException;
import ru.hudeez.oweather.api.settings.Language;
import ru.hudeez.oweather.api.settings.ResponseFormat;
import ru.hudeez.oweather.api.settings.Units;
import ru.hudeez.oweather.models.City;
import ru.hudeez.oweather.models.Weather;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CurrenWeatherAPI implements API {
    private City city;

    public CurrenWeatherAPI(String cityName, Units units, Language language, ResponseFormat... mode) {
        try {
            GeocodingAPI geocodingAPI = new GeocodingAPI(cityName);
            double lat = geocodingAPI.getLat();
            double lon = geocodingAPI.getLon();
            String uri = Configuration.WEATHER_URL + "weather?lat=" + lat + "&lon=" + lon + "&appid=" + Configuration.TOKEN + "&mode=" + mode.toString() + "&units=" + units.toString() + "&lang=" + language.toString();

            JSONObject body = new JSONObject(getResponse(uri));

            /*
            Weather params
             */
            JSONArray weatherBody = body.getJSONArray("weather");
            String main = weatherBody.getJSONObject(0).getString("main");
            String description = weatherBody.getJSONObject(0).getString("description");
            String icon = weatherBody.getJSONObject(0).getString("icon");

            String base = body.getString("base");

            /*
            Main params
             */
            JSONObject mainBody = body.getJSONObject("main");
            double temp = mainBody.getDouble("temp");
            double feelsLike = mainBody.getDouble("feels_like");
            double tempMin = mainBody.getDouble("temp_min");
            double tempMax = mainBody.getDouble("temp_max");
            double pressure = mainBody.getDouble("pressure");
            double humidity = mainBody.getDouble("humidity");
            double seaLevel = mainBody.getDouble("sea_level");
            double groundLevel = mainBody.getDouble("grnd_level");

            double visibility = body.getDouble("visibility");

            /*
            Wind params
             */
            JSONObject windBody = body.getJSONObject("wind");
            double windSpeed = windBody.getDouble("speed");
            double windDeg = windBody.getDouble("deg");
            double windGust = windBody.getDouble("gust");

            JSONObject cloudsBody = body.getJSONObject("clouds");
            double clouds = cloudsBody.getDouble("all");

            long datetime = body.getLong("dt");

            /*
            SYS params
             */
            JSONObject sys = body.getJSONObject("sys");
            String country = sys.getString("country");
            long sunrise = sys.getLong("sunrise");
            long sunset = sys.getLong("sunset");

            /*
            Icon init
             */

            Map<String, String> emoji = new HashMap<>(Map.of(
                    "01", "☀️",
                    "02", "⛅",
                    "03", "☁️",
                    "04", "\uD83D\uDCA8",
                    "09", "\uD83C\uDF27️",
                    "10", "\uD83C\uDF26️",
                    "11", "\uD83C\uDF29️",
                    "13", "❄️",
                    "50", "\uD83C\uDF2B️"
            ));

            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(icon);
            String iconWeather = null;
            while (matcher.find()) {
                iconWeather = emoji.get(matcher.group());
            }

            /*
            Init objects
             */
            Weather weatherObject = new Weather(main, description, iconWeather, base, temp, feelsLike, tempMin, tempMax, pressure, humidity, seaLevel, groundLevel, visibility,
                    windSpeed, windDeg, windGust, clouds, datetime, country, sunrise, sunset);

            this.city = new City(cityName, country, lat, lon, weatherObject);

        } catch (APIException exception) {
            exception.printStackTrace();
        }
    }

    public CurrenWeatherAPI(String cityName, String countryCode, Units units, Language language, ResponseFormat... mode) {
        try {
            GeocodingAPI geocodingAPI = new GeocodingAPI(cityName, countryCode);
            double lat = geocodingAPI.getLat();
            double lon = geocodingAPI.getLon();
            String uri = Configuration.WEATHER_URL + "weather?lat=" + lat + "&lon=" + lon + "&appid=" + Configuration.TOKEN + "&mode=" + mode.toString() + "&units=" + units.toString() + "&lang=" + language.toString();

            JSONObject body = new JSONObject(getResponse(uri));

            /*
            Weather params
             */
            JSONArray weatherBody = body.getJSONArray("weather");
            String main = weatherBody.getJSONObject(0).getString("main");
            String description = weatherBody.getJSONObject(0).getString("description");
            String icon = weatherBody.getJSONObject(0).getString("icon");

            String base = body.getString("base");

            /*
            Main params
             */
            JSONObject mainBody = body.getJSONObject("main");
            double temp = mainBody.getDouble("temp");
            double feelsLike = mainBody.getDouble("feels_like");
            double tempMin = mainBody.getDouble("temp_min");
            double tempMax = mainBody.getDouble("temp_max");
            double pressure = mainBody.getDouble("pressure");
            double humidity = mainBody.getDouble("humidity");
            double seaLevel = mainBody.getDouble("sea_level");
            double groundLevel = mainBody.getDouble("grnd_level");

            double visibility = body.getDouble("visibility");

            /*
            Wind params
             */
            JSONObject windBody = body.getJSONObject("wind");
            double windSpeed = windBody.getDouble("speed");
            double windDeg = windBody.getDouble("deg");
            double windGust = windBody.getDouble("gust");

            double clouds = body.getDouble("clouds");

            long datetime = body.getLong("dt");

            /*
            SYS params
             */
            JSONObject sys = body.getJSONObject("sys");
            String country = sys.getString("country");
            long sunrise = sys.getLong("sunrise");
            long sunset = sys.getLong("sunset");

            /*
            Icon init
             */

            Map<String, String> emoji = new HashMap<>(Map.of(
                    "01", "☀️",
                    "02", "⛅",
                    "03", "☁️",
                    "04", "\uD83D\uDCA8",
                    "09", "\uD83C\uDF27️",
                    "10", "\uD83C\uDF26️",
                    "11", "\uD83C\uDF29️",
                    "13", "❄️",
                    "50", "\uD83C\uDF2B️"
            ));

            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(icon);
            String iconWeather = null;
            while (matcher.find()) {
                iconWeather = emoji.get(matcher.group());
            }

            /*
            Init objects
             */
            Weather weatherObject = new Weather(main, description, iconWeather, base, temp, feelsLike, tempMin, tempMax, pressure, humidity, seaLevel, groundLevel, visibility,
                    windSpeed, windDeg, windGust, clouds, datetime, country, sunrise, sunset);

            this.city = new City(cityName, country, lat, lon, weatherObject);

        } catch (APIException exception) {
            exception.printStackTrace();
        }
    }

    public City getCity() {
        return city;
    }
}
