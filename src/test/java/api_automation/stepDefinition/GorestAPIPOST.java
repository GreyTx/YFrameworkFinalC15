package api_automation.stepDefinition;
import api_automation.RequestBuilders.RequestBuilderCreateUser;
import api_automation.utils.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.en.*;
import io.restassured.response.Response;


import static api_automation.stepDefinition.Hooks.getScenario;
import static api_automation.utils.JsonHandler.convertObjectToJson;
import java.net.HttpURLConnection;


import org.junit.Assert;

public class GorestAPIPOST extends TestBase{


	private String requestData;
	private static Response response;
	private String userID;



	@Given("User create request data with {string} , {string} , {string} , {string}")
	public void user_create_request_data_with(String name, String email, String gender, String status) throws JsonProcessingException {
		 //Create request in Java object
		RequestBuilderCreateUser reqBuilder = new RequestBuilderCreateUser();
		reqBuilder.setName(name);
		reqBuilder.setEmail(email);
		reqBuilder.setGender(gender);
		reqBuilder.setStatus(status);

		// Convert object to JSON string
		requestData = convertObjectToJson(reqBuilder);

		// Write request data to report
		LoggingUtils.logResponse( getScenario(), requestData);
		//scenario.embed(requestData.getBytes(), APPLICATION_JSON);
	}


	@When("User sumbits POST request to GOREST api")
	public void user_sumbits_POST_request_to_GOREST_api() {

		      response = ApiUtilsPostUser.PostUser(requestData);
		      String strResponse=response.prettyPrint();

			//write response to file
		LoggingUtils.log( getScenario(), "Response received \n" + strResponse);

	}


	@When("User validates if statusCode is {int}")
	public void user_validates_if_statusCode_is(int statusCode) {
	    Assert.assertEquals(statusCode, response.getStatusCode());
		LoggingUtils.logHttpCOde( getScenario(), response.getStatusCode());

	}

	@Then("User retrieves userID from response")
	public void user_retrieves_userID_from_response() {

		 userID = JsonPath.read(response.asString(), "$.data.id").toString();
		LoggingUtils.log( getScenario(), "User ID: "+userID );


	}

	@Then("User deletes data with userID")
	public void user_deletes_data_with_userID() {
		Response resp = ApiUtilsPostUser.DeleteUser(userID);
		//String strResponse=resp.prettyPrint();
		LoggingUtils.log( getScenario(),"HTTP code after user was deleted " + resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), HttpURLConnection.HTTP_NO_CONTENT);



	}



}