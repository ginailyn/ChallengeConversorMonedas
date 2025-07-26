package com.alura.desafios.challengeconversor;

import java.net.URI;
import java.net.http.HttpRequest;

public class ApiRequestBuilder {
    private final String apiKey;
    private final String base;
    private final String target;
    private final double amount;

    public ApiRequestBuilder(String apiKey, String base, String target, double amount) {
        this.apiKey = apiKey;
        this.base = base;
        this.target = target;
        this.amount = amount;
    }

    public HttpRequest build() {
        String uri = String.format(
                "https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%.6f",
                apiKey, base, target, amount
        );
        return HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Accept", "application/json")
                .GET()
                .build();
    }
}