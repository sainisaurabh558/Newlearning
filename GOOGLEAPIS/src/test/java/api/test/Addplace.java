package api.test;

import java.io.IOException;
import java.net.URISyntaxException;

import api.endpoints.PlaceAPIendPoint;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Addplace {

	public static void main(String[] args) throws IOException, URISyntaxException {

		String response1 = PlaceAPIendPoint.addPlace();
		System.out.println(response1);
	JsonPath jp = new JsonPath(response1);
	System.out.println("Hello1");
	System.out.println(jp.getString("status"));
	System.out.println("Hello2");


	}
}
