package api_automation.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiUtilsWeather extends  TestBase{


    public static Response getWeatherByCityName(String cityName) {
        RestAssured.baseURI = property.getProperty("weatherApiURI");
        Response response = given()
                .param("q", cityName)
                .param("appid", property.getProperty("weatherApiKey"))
                .when()
                .get();
        return response;
    }

    public static Response getWeatherByCityID(String cityID) {
        RestAssured.baseURI = property.getProperty("weatherApiURI");
        Response response = given()
                .param("id", cityID)
                .param("appid", property.getProperty("weatherApiKey"))
                .when()
                .get();
        return response;
    }
}
