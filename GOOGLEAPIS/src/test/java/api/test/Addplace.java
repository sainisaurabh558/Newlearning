package api.test;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.PlaceAPIendPoint;
import api.utilities.StringConverter;
import io.restassured.response.Response;

public class Addplace {



	public Logger logger;
	String place_id;


	@Test (invocationCount = 15)
	public void TestAddPlaceAPI() throws IOException, URISyntaxException

	{
		logger= LogManager.getLogger(this.getClass());
		logger.info("********** Testing of the add place Api started  ***************");
		Response response = PlaceAPIendPoint.addPlace();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(response.getBody().asString());
		String Place_id= StringConverter.convertStringToJson( response, "place_id");
		System.out.println(Place_id);

	}

}
