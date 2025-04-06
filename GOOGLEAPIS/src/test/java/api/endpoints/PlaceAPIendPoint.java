package api.endpoints;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ResourceBundle;

import api.utilities.JsonReader;

public class PlaceAPIendPoint {

	// method created for getting URL's from properties file

	// method created for getting URL's from properties file
	static ResourceBundle getURL() {
		ResourceBundle routes = ResourceBundle.getBundle("endpointcollection"); // Load properties file // name of the
																				// properties file
		return routes;
	}

	public static String addPlace() throws IOException, URISyntaxException {
		String AddURL = getURL().getString("AddPlaceAPI_post");
		System.out.println("here is the URL fetched"+AddURL);

		String response = given().body((JsonReader.addPlaceJson()).toString())
				.queryParam("key", "qaclick123").header("Content-Type", "Application/json").when().post(AddURL).then().extract().response().asString();

		return response;
		System.out.println(response);

	}
}
