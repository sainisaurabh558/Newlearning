package api.test;

import java.io.IOException;
import java.net.URISyntaxException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import api.endpoints.PlaceAPIendPoint;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Addplace {



	public Logger logger;


	@Test (invocationCount = 5)
	public void TestAddPlaceAPI() throws IOException, URISyntaxException

	{
		logger= LogManager.getLogger(this.getClass());
		logger.info("********** Testing of the add place Api started  ***************");
		Response response = PlaceAPIendPoint.addPlace();
		Assert.assertEquals(response.getStatusCode(), 201);

	}

}
