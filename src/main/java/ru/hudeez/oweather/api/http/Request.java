package ru.hudeez.oweather.api.http;

import ru.hudeez.oweather.api.exceptions.APIException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Request {
    public HttpResponse<String> GET(String uri) throws APIException {
        try (HttpClient httpClient = HttpClient.newHttpClient()){
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(uri))
                    .GET().build();
            return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException | URISyntaxException e) {
            throw new APIException(e.getMessage());
        }
    }

    public HttpResponse<String> POST(String uri, String body, String... headers) throws APIException {
        try (HttpClient httpClient = HttpClient.newHttpClient()){
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(uri))
                    .headers(headers)
                    .POST(HttpRequest.BodyPublishers.ofString(body)).build();
            return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        }  catch (IOException | InterruptedException | URISyntaxException e) {
            throw new APIException(e.getMessage());
        }
    }
}
