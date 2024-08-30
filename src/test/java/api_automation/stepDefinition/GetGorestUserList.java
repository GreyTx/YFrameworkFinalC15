package api_automation.stepDefinition;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import api_automation.utils.ApiUtilsUserList;
import api_automation.utils.LoggingUtils;
import io.cucumber.core.api.Scenario;
import org.junit.Assert;
import com.jayway.jsonpath.JsonPath;
import api_automation.utils.TestBase;
import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static api_automation.stepDefinition.Hooks.getScenario;


public class GetGorestUserList extends TestBase {
	
	private Response response;



	@Given("User gets Employee List from Gorest API")
	public void user_gets_Employee_List_from_Gorest_API() {
		response = ApiUtilsUserList.getUsersList(property.getProperty("gorestApiURI"));
		LoggingUtils.logResponse(getScenario(), response.prettyPrint());
	}

	@Then("Validate if status code is {int}")
	public void validate_if_status_code_is(int statusCode) {
		LoggingUtils.logHttpCOde(getScenario(), response.getStatusCode());
		Assert.assertEquals(statusCode, response.getStatusCode());
		Assert.assertFalse(response.body().toString().isEmpty());
	}


	@Then("User retrieve and print unique Gorest user names")
	public void user_retrieve_and_print_unique_Gorest_user_names() {
		List<String> names = JsonPath.read(response.asString(), "$.data[*].name");
		Set<String> uniqueNames = new HashSet<>(names);

		for (String name : uniqueNames) {
			System.out.println(name);
		}

	}

	@Then("Find the first names whose gender is male")
	public void find_the_first_names_whose_gender_is_male() {
		List<String>names=JsonPath.read(response.asString(), "$.data[?(@.gender=='male')].name");

        Set<String>uniqueNamesMales =new HashSet<String>();
		uniqueNamesMales.addAll(names);

        for (String string : uniqueNamesMales) {
            System.out.println(string);
        }
	}


	

}
