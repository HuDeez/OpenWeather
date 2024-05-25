package ru.hudeez.oweather.api.exceptions;

import org.junit.jupiter.api.Test;
import ru.hudeez.oweather.api.GeocodingAPI;

public class APIExceptionTest {
    @Test
    public void TestSearchCityOfNumber() throws APIException{
        GeocodingAPI geocodingAPI = new GeocodingAPI("1251212");
    }

    @Test
    public void TestSearchCityOfRandomSymbols() throws APIException {
        GeocodingAPI geocodingAPI = new GeocodingAPI("dsdlksdlskdskdjskdjks");
    }
}
