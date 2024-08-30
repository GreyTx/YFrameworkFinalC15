package api_automation.utils;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ApiUtilsUserList {

    public static Response getUsersList(String uri) {
        return given().when().get(uri);
    }
}
