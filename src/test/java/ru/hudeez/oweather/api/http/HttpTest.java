package ru.hudeez.oweather.api.http;

import org.junit.jupiter.api.Test;
import ru.hudeez.oweather.api.exceptions.APIException;

import java.net.http.HttpResponse;

public class HttpTest {
    @Test
    public void TestGetNotValidRequest() throws APIException {
        Request request = new Request();
        HttpResponse<String> response = request.GET("https://fdwdswdwsdswd");
        System.out.println(response);
    }

    @Test
    public void TestGetValidRequest() throws APIException {
        Request request = new Request();
        HttpResponse<String> response = request.GET("https://www.google.com");
        System.out.println(response);
    }

    @Test
    public void TestPOSTRequest() throws APIException {
        Request request = new Request();
        HttpResponse<String> response = request.POST(
                "https://httpbin.org/post",
                "",
                "Content-Type", "application/json"
                );
        System.out.println(response);
    }
}
