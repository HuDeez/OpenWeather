package ru.hudeez.oweather.models;


public class Weather {
    /*
    'Weather' params
     */
    private String main;
    private String description;
    private String icon;

    private String base;

    /*
    Main params
     */
    private double temp;
    private double feelsLike;
    private double tempMin;
    private double tempMax;
    private double pressure;
    private double humidity;
    private double seaLevel;
    private double groundLevel;

    private double visibility;

    /*
    Wind params
     */
    private double windSpeed;
    private double windDeg;
    private double windGust;

    private double clouds;
    private long dateTime;

    /*
    SYS Params
     */
    private String country;
    private long sunrise;
    private long sunset;

    public Weather(String main, String description, String icon, String base, double temp, double feelsLike, double tempMin, double tempMax, double pressure, double humidity, double seaLevel, double groundLevel, double visibility, double windSpeed, double windDeg, double windGust, double clouds, long dateTime, String country, long sunrise, long sunset) {
        this.main = main;
        this.description = description;
        this.icon = icon;
        this.base = base;
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.pressure = pressure;
        this.humidity = humidity;
        this.seaLevel = seaLevel;
        this.groundLevel = groundLevel;
        this.visibility = visibility;
        this.windSpeed = windSpeed;
        this.windDeg = windDeg;
        this.windGust = windGust;
        this.clouds = clouds;
        this.dateTime = dateTime;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    public String getBase() {
        return base;
    }

    public double getTemp() {
        return temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public double getTempMin() {
        return tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getSeaLevel() {
        return seaLevel;
    }

    public double getGroundLevel() {
        return groundLevel;
    }

    public double getVisibility() {
        return visibility;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getWindDeg() {
        return windDeg;
    }

    public double getWindGust() {
        return windGust;
    }

    public double getClouds() {
        return clouds;
    }

    public long getDateTime() {
        return dateTime;
    }

    public String getCountry() {
        return country;
    }

    public long getSunrise() {
        return sunrise;
    }

    public long getSunset() {
        return sunset;
    }
}
