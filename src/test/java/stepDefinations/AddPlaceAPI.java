package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import Payloads.TestDataBuild;
import Payloads.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class AddPlaceAPI extends Utils{

	RequestSpecification req;
	ResponseSpecification resSpec;
	TestDataBuild data = new TestDataBuild();
	Response responce;
	@Given("Add Place Payload")
	public void add_place_payload() {
		try {
			req = given().spec(commReqSpec()).body(data.addPlaceJSon());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@When("User calls {string} API using post http request")
	public void user_calls_api_using_post_http_request(String string) {
		responce = req.when().post("/maps/api/place/add/json")
				.then().spec(commResSpec()).extract().response();
	}
	@Then("The API call got successfull and status code is {int}")
	public void the_api_call_got_successfull_and_status_code_is(Integer int1) {
		assertEquals(responce.getStatusCode(), 200);
	}
	@Then("{string} in Responce Body is {string}")
	public void in_responce_body_is(String keyValue, String expectedValue) {
		JsonPath js = new JsonPath(responce.asString());
		assertEquals(js.get(keyValue).toString(), expectedValue);
	} 
}
