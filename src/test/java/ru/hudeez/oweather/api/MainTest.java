package ru.hudeez.oweather.api;

import org.junit.jupiter.api.Test;
import ru.hudeez.oweather.WeatherClient;
import ru.hudeez.oweather.models.City;
import ru.hudeez.oweather.models.Weather;

import static ru.hudeez.oweather.api.settings.Language.RU;
import static ru.hudeez.oweather.api.settings.Units.METRIC;

public class MainTest {
    @Test
    public void TestMain() {
        WeatherClient client = new WeatherClient("YOUR TOKEN");
        CurrenWeatherAPI currenWeatherAPI = client.getCurrentWeatherAPI("Moscow", METRIC, RU);
        City city = currenWeatherAPI.getCity();
        Weather weather = city.getCityWeather();
        System.out.println(weather.getDateTime());
    }
}
