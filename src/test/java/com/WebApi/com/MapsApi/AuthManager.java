package com.WebApi.com.MapsApi;

import io.restassured.RestAssured;

public class AuthManager {

    private static String token;

    public static String getAccessToken() {
        if (token == null) {
            // Logic to fetch token from an auth endpoint
            token = RestAssured.given()
                    .formParam("client_id", "my_id")
                    .post("/oauth/token")
                    .path("access_token");
        }
        return token;
    }
}