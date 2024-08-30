package api_automation.RequestBuilders;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

/**
 * Represents a request payload for creating a user, with fields for name,
 * email, gender, and status.
 *
 * The fields are serialized in the order: name, email, gender, status.
 */
@Data
@JsonPropertyOrder({"name", "email", "gender", "status"})
public class RequestBuilderCreateUser {

	private String name;
	private String email;
	private String gender;
	private String status;


}