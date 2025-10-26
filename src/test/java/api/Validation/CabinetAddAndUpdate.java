package api.Validation;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import io.restassured.response.Response;

public class CabinetAddAndUpdate {

	Response response;
	
	public static void cabinetvalidation(Response response, ExtentTest extentLogger ,Logger logger)
	
	{
		System.out.println("in the CabinetVALIDATION METHOD");
		
		System.out.println("resposnse payload "+response.asString());
		extentLogger.info("performing validation"+response.asString() );
		Assert.assertEquals(response.getStatusCode(), 200);
		extentLogger.info("performing validation on status code 200"+response.getStatusCode());
	if (response.getTime()>4000)
	{
		System.out.println("time is less than expected ");
		extentLogger.info("Reponse time validation less than 4000 milli sec "+response.getTime() );
	}

	}
}

