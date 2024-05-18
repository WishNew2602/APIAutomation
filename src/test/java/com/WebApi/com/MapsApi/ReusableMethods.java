package com.WebApi.com.MapsApi;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReusableMethods {

	public static JsonPath rawToJson(String resp) {
		// TODO Auto-generated method stub
		JsonPath js = new JsonPath(resp);
		return js;
	}
}
