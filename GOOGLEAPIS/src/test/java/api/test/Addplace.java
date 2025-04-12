package api.test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import api.endpoints.PlaceAPIendPoint;
import api.utilities.ExtentReportManager;
import api.utilities.JsonReaderAndMod;
import api.utilities.TextFileReaderAndMod;
import io.restassured.response.Response;

public class Addplace {


	ExtentTest loggerE;
	public Logger logger;


	@Test (invocationCount = 0) 
	public void TestAddPlaceAPI() throws IOException, URISyntaxException

	{
		  ExtentReportManager.getTest();
		logger= LogManager.getLogger(this.getClass());
		logger.info("********** Testing of the add place Api started  ***************");

		
		loggerE.info("Request body"+JsonReaderAndMod.addPlaceJson());
		Response response = PlaceAPIendPoint.addPlace();
		loggerE.info("Step 2: Sending Post request to /user");

		loggerE.info("Step 3: Response received");
		loggerE.info("Status Code: " + response.getStatusCode());
		loggerE.info("Response Time: " + response.time() + " ms");
		loggerE.info("Response Body:\n" + response.asPrettyString());

		// Assertions
		Assert.assertEquals(response.getStatusCode(), 200);
		loggerE.pass("Status Code validated successfully.");
	}
// Second test
@Test(invocationCount = 15)
public void  sqlInjectionM() throws IOException, URISyntaxException
{ 
	loggerE = ExtentReportManager.getTest();
	
	loggerE.info("Request body"+JsonReaderAndMod.addPlaceJson());
	Response response = PlaceAPIendPoint.addPlace();
	loggerE.info("Step 2: Sending Post request to /user");

	loggerE.info("Step 3: Response received");
	loggerE.info("Response Time: " + response.time() + " ms");
	loggerE.info("Response Body:\n" + response.asPrettyString());
	Assert.assertEquals(response.getStatusCode(), 200);
	loggerE.pass("Status Code validated successfully.");

}


}

