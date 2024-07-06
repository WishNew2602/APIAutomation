package stepDefinations;
import static org.junit.Assert.assertEquals;

import Payloads.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OpenWeatherApiSteps extends Utils{
    private RequestSpecification request;
    private Response response;

    @Given("I have built GET request")
    public void i_have_built_get_request() {
        request = reqSpecOpenWeatherAPI();
        System.out.println("request ........." + request.log().all());
    }

    @Given("^I have provided (.+) and (.+) as Query params and API Key$")
    public void i_have_provided_city_and_country_as_query_params_and_apikey(String city, String country) {
    	city = city + "," + country;
        request = request.queryParam("q", city)
                .queryParam("appid", "204320a8b8bbc343067cf570c2de3707");
    }

    @When("I Get Response from API")
    public void i_get_response_from_api() {
        response = request.when().get("/weather").then().spec(commResSpec()).extract().response();
    }
    @Then("^I verify the (.+) in Response$")
    public void i_verify_the_city_in_response(String expectedCity) {
        String actualCity = response.jsonPath().getString("name");
        assertEquals(expectedCity, actualCity);
    }
}
