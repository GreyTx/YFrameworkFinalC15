package api_automation.stepDefinition;
import api_automation.utils.ApiUtilsWeather;
import api_automation.utils.LoggingUtils;
import api_automation.utils.TestBase;
import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;


import static api_automation.stepDefinition.Hooks.getScenario;
import static org.junit.Assert.assertEquals;



public class GetWeatherByCityName  extends TestBase {

    private Response responseCityName;


    @Given("User gets weather for {string}")
    public void user_gets_weather_for(String cityName) {
        responseCityName=ApiUtilsWeather.getWeatherByCityName(cityName);
        responseCityName.prettyPrint();
        LoggingUtils.logResponse(getScenario(),responseCityName.toString());

    }

    @Then("User validates response body has city {string} for {string}")
    public void user_validates_response_body_has_city_for(String city, String jsonPath) {
        Assert.assertNotNull(responseCityName);
        String responseBody = responseCityName.getBody().asString();
        String cityNameActual = JsonPath.read(responseBody, jsonPath).toString();
        assertEquals(city,cityNameActual);

    }


}
