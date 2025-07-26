package com.alura.desafios.challengeconversor;

import java.net.http.HttpClient;
import java.time.Duration;

public class HttpClientWrapper {
    private final HttpClient client;

    public HttpClientWrapper() {
        this.client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();
    }

    public HttpClient getClient() {
        return client;
    }
}
