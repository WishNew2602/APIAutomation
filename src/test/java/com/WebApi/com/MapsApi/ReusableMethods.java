package com.WebApi.com.MapsApi;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {

	public static JsonPath rawToJson(String resp) {
		JsonPath js = new JsonPath(resp);
		return js;
	}
}
