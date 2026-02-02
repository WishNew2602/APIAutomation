package com.WebApi.com.MapsApi;

import io.restassured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.PrintStream;
import java.util.List;

import static io.restassured.RestAssured.*;

//this class is to practice below items
//        RequestSpecification
//        ResponseSpecification
//        Api chaining - Payment gateway real time scenario of hitting phonepe from amazon application
//Question - JsonPath - Accessing key inside Json
//Idempotency
//        Statelessness
//Oauth,auth2,JWT, Basic, Bearer
//Headers of request and response
//Handling exception of json body
//Handling exception of tokens
//Queryparams, pathparams

public class PracticeConcepts {

    RequestSpecification request;

    public ResponseSpecification getResponse() {
        return response;
    }

    public RequestSpecification getRequest() {
        return request;
    }

    ResponseSpecification response;
    PrintStream log = new PrintStream(System.out);

    public RequestSpecification requestSpec() {
        request = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com/")
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .build();
        return request;
    }
    public ResponseSpecification givenResponseSpec() {
        response = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                .build();
        return response;
    }

    public static void main(String[] args) {

        PracticeConcepts practiceConcepts = new PracticeConcepts();
        Response response1 = given().spec(practiceConcepts.requestSpec()).
                when().get("/posts").then()
                            .spec(practiceConcepts.givenResponseSpec()).extract().response();
//        System.out.println(response1.asPrettyString());
        List<String> jsonPath = response1.jsonPath().getList("id");
        System.out.println(jsonPath);

        Response postResponse = given().spec(practiceConcepts.requestSpec())
                .body("""
                        {
                          "title": "API Interview Prep",
                          "body": "Using JSONPlaceholder",
                          "userId": 1
                        }
                    """)
                .when().post("/posts").then().extract().response();
        System.out.println(postResponse.jsonPath().getInt("id"));
        System.out.println(postResponse.jsonPath().getMap("$"));


    }
}
