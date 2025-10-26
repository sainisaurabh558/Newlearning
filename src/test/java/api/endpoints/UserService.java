package api.endpoints;

import io.restassured.response.Response;
import java.util.Base64;

import org.json.JSONObject;

import api.payload.AddComponent;
import api.payload.AddOrUpdateApiResponse;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import static io.restassured.RestAssured.*;

public class UserService {

	Response response;
	Header token;
	
public int  serverResponseCheck()
	{
		
int statuscode =		given().when().get(Routes.BaseURL).then().extract().response().statusCode();
return statuscode;
	}

	public void login(String randomValue) {

		String credentials = "sadmin:44647b017dd5bd380deceb96cee22614586f6da0a57af6a590df87625fec0b3a";
		String encodedCreds = Base64.getEncoder().encodeToString(credentials.getBytes());

		response = given().contentType("application/json").header("Authorization", "Basic " + encodedCreds)
				.body("{ \"randomValue\": \"" + randomValue + "\" }").when().post(Routes.loginUrl).then().extract()
				.response();

		// Debug headers
		System.out.println("=== Response Headers ===");
		for (Header h : response.getHeaders()) {
			System.out.println(h.getName() + ": " + h.getValue());
		}

		String tokenValue = response.getHeader("Bearer");

		if (tokenValue == null || tokenValue.trim().isEmpty()) {
			throw new RuntimeException("❌ Bearer token not found in response headers. Login failed.");
		}
		// Extract token

		this.token = new Header("Authorization", "Bearer " + tokenValue);
		System.out.println(token);

	}

	// Hitting the add or update component api

	public Response addOrUpdateComponent(AddComponent addcom) {
	
		if (token == null) {
			throw new IllegalStateException("❌ Token is null. Make sure login() succeeded before this call.");
		}
		Response response  = given().log().all().contentType("application/json").header(token).body(addcom).when()
				.post(Routes.add_Update_Component).then().extract().response();
		return response;
	}
	
	
	public Response  add_serial_Structure (JSONObject jsonobject)
	{
		
		Response response  = given().log().all().contentType("application/json").header(token).body(jsonobject.toString()).when()
				.post(Routes.add_serial_Structure).then().extract().response();
		
		return response;

	}
}
