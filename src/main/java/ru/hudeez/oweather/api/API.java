package ru.hudeez.oweather.api;

import ru.hudeez.oweather.api.exceptions.APIException;
import ru.hudeez.oweather.api.http.Request;

import java.net.http.HttpResponse;

public interface API {
    default String getResponse(String uri) throws APIException {

        Request request = new Request();
        HttpResponse<String> response;

        response = request.GET(uri);
        if (response == null) {
            throw new APIException("Response is null");
        }
        return response.body();
    }
}
