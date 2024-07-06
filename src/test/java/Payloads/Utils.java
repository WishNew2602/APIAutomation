package Payloads;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	
    static RequestSpecification req;
    static ResponseSpecification resSpec;
    static PrintStream log;
    public RequestSpecification commReqSpec() throws FileNotFoundException {

        try {
            log = new PrintStream(Files.newOutputStream(Paths.get("logging.txt")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON)
				.build();
		 return req;
	}
	public ResponseSpecification commResSpec() {
		resSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
		return resSpec;
	}
	
    public static RequestSpecification reqSpecOpenWeatherAPI(){
        try {
			log = new PrintStream(new FileOutputStream("openWeatherlog.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		req = RestAssured.with().baseUri("http://api.openweathermap.org/data/2.5")
        		.header("Content-Type", "application/json");
        return req;
    }
}
