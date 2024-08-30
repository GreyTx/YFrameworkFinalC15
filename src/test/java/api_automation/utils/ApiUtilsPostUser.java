package api_automation.utils;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class ApiUtilsPostUser  extends TestBase {


    private static final String BEARER_TOKEN_PREFIX = "Bearer ";
    private static final String APPLICATION_JSON = "application/json";

    public static Response PostUser (String requestData){

            return   given()
                    .header("Authorization", BEARER_TOKEN_PREFIX + property.getProperty("gorestAPIKey"))
                    .contentType(APPLICATION_JSON)
                    .body(requestData).
                    when()
                    .post(property.getProperty("gorestApiURI"));

    }


    public static Response DeleteUser (String userID){

        return   given()
                .header("Authorization", BEARER_TOKEN_PREFIX + property.getProperty("gorestAPIKey"))
                .when()
                .delete(property.getProperty("gorestApiURI")+"/"+userID);

    }


}
