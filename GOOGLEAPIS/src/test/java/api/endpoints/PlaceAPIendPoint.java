package api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ResourceBundle;

import api.utilities.JsonReader;
import io.restassured.response.Response;

public class PlaceAPIendPoint {


	// method created for getting URL's from properties file.
	static ResourceBundle getURL() {
		ResourceBundle routes = ResourceBundle.getBundle("endpointcollection"); // Load properties file // name of the
		// properties file
		return routes;
	}

	public static Response addPlace() throws IOException, URISyntaxException {
		String AddURL = getURL().getString("AddPlaceAPI_post");

		Response  response = given().body((JsonReader.addPlaceJson()).toString())
				.queryParam("key", "qaclick123").header("Content-Type", "Application/json").when().post(AddURL).then().extract().response();

		return response;

	}
}
