package com.alura.desafios.challengeconversor;


import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ApiResponseHandler {

    public static double handle(HttpResponse<String> response) {
        int status = response.statusCode();
        String body = response.body();

        if (status != 200) {
            throw new RuntimeException("HTTP error: " + status);
        }

        JsonObject obj = JsonParser.parseString(body).getAsJsonObject();
        if (!"success".equals(obj.get("result").getAsString())) {
            throw new RuntimeException("API error: " + obj.get("error-type").getAsString());
        }
        return obj.get("conversion_result").getAsDouble();
    }
}
