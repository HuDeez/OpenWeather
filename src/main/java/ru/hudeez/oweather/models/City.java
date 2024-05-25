package ru.hudeez.oweather.models;

public class City {
    private final String cityName;
    private String countryCode;
    private Double lat;
    private Double lon;
    private Weather cityWeather;


    public City(String cityName, String countryCode, Double lat, Double lon, Weather cityWeather) {
        this.cityName = cityName;
        this.countryCode = countryCode;
        this.lat = lat;
        this.lon = lon;
        this.cityWeather = cityWeather;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }

    public String getCityName() {
        return cityName;
    }


    public String getCountryCode() {
        return countryCode;
    }

    public Weather getCityWeather() {
        return cityWeather;
    }
}
