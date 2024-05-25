package ru.hudeez.oweather.api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ru.hudeez.oweather.WeatherClient;
import ru.hudeez.oweather.api.config.Configuration;
import ru.hudeez.oweather.api.exceptions.APIException;
import ru.hudeez.oweather.api.http.Status;


public class GeocodingAPI implements API{
    private final double lat;
    private final double lon;

    public GeocodingAPI(String cityName) throws APIException {

        Status status = new Status();

        if ((status.connectionStatusCode() >= 200) && (status.connectionStatusCode() < 300)) {
            if (cityName.matches("-?\\d+")) throw new APIException("City can't be a number!");

            String uri = Configuration.GEO_URL + "direct?q=" + cityName + "&appid=" + Configuration.TOKEN;
            JSONArray geoArray;
            JSONObject body;
            try {
                geoArray = new JSONArray(getResponse(uri));
                body = geoArray.getJSONObject(0);
            } catch (JSONException exception) {
                throw new APIException("City is invalid!");
            }
            this.lat = body.getDouble("lat");
            this.lon = body.getDouble("lon");

        } else {
            throw new APIException("Status Code: " + status.connectionStatusCode());
        }
    }

    public GeocodingAPI(String cityName, String countryCode) throws APIException {

        Status status = new Status();

        if ((status.connectionStatusCode() >= 200) && (status.connectionStatusCode() < 300)) {
            if (cityName.matches("-?\\d+")) throw new APIException("City can't be a number!");

            String uri = Configuration.GEO_URL + "direct?q=" + cityName + "," + countryCode + "&appid=" + Configuration.TOKEN;
            JSONArray geoArray;
            JSONObject body;
            try {
                geoArray = new JSONArray(getResponse(uri));
                body = geoArray.getJSONObject(0);
            } catch (JSONException exception) {
                throw new APIException("City is invalid!");
            }
            this.lat = body.getDouble("lat");
            this.lon = body.getDouble("lon");

        } else {
            throw new APIException("Status Code: " + status.connectionStatusCode());
        }

    }


    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }
}
