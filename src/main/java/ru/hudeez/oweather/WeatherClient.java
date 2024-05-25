package ru.hudeez.oweather;


import ru.hudeez.oweather.api.CurrenWeatherAPI;
import ru.hudeez.oweather.api.GeocodingAPI;
import ru.hudeez.oweather.api.config.Configuration;
import ru.hudeez.oweather.api.exceptions.APIException;
import ru.hudeez.oweather.api.settings.Language;
import ru.hudeez.oweather.api.settings.ResponseFormat;
import ru.hudeez.oweather.api.settings.Units;

public class WeatherClient {

    public WeatherClient(String token) {
        Configuration.TOKEN = token;
    }

    public GeocodingAPI getGeocodingAPI(String cityName) throws APIException {
        return new GeocodingAPI(cityName);
    }

    public GeocodingAPI getGeocodingAPI(String cityName, String countryCode) throws APIException {
        return new GeocodingAPI(cityName, countryCode);
    }

    public CurrenWeatherAPI getCurrentWeatherAPI(String cityName, Units units, Language language, ResponseFormat... mode){
        return new CurrenWeatherAPI(cityName, units, language, mode);
    }

    public CurrenWeatherAPI getCurrentWeatherAPI(String cityName,String countryCode, Units units, Language language, ResponseFormat... mode){
        return new CurrenWeatherAPI(cityName, countryCode, units, language, mode);
    }

}
