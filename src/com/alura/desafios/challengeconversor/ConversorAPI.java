package com.alura.desafios.challengeconversor;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorAPI {
    private static final String API_KEY = "1813ca035c3cf5c8213753a0";
    private final HttpClientWrapper clientWrapper;

    public ConversorAPI() {
        this.clientWrapper = new HttpClientWrapper();
    }

    public double convertir(String moneda1, String moneda2, double amount) throws Exception {
        ApiRequestBuilder builder = new ApiRequestBuilder(API_KEY, moneda1, moneda2, amount);
        HttpRequest request = builder.build();
        HttpClient client = clientWrapper.getClient();
        HttpResponse<String> resp = client.send(request, HttpResponse.BodyHandlers.ofString());
        return ApiResponseHandler.handle(resp);
    }
}