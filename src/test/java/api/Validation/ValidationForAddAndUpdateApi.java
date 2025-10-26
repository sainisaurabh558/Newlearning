package api.Validation;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.MatcherAssert.assertThat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.payload.AddOrUpdateApiResponse;
import api.utilities.ExtentReportManager;
import io.restassured.module.jsv.JsonSchemaValidationException;
import io.restassured.response.Response;

public class ValidationForAddAndUpdateApi {
	Response response;
	String jsonResponse;
	AddOrUpdateApiResponse pojoResponse;

	public void ValidationOnResponse(Response response, ExtentTest extentLogger ,Logger logger) throws IOException


	
// In this class we have the data in the form of the response(object reference and also in the form of the pojo classpojoResponse)
	{
		 String rawBody = response.getBody().asString();
		logger.info("Validtion on the component api started");
		 if (extentLogger != null) {
		        extentLogger.log(Status.INFO, "Validating response: " + rawBody);
		    } else {
		        logger.warn("ExtentLogger was null when trying to log validation message.");
		    }
		 try {
		 pojoResponse = response.as(AddOrUpdateApiResponse.class);
		 }
		 catch (Exception e) 
		 {
		        logger.error("Failed to parse response to POJO. Raw body: " + rawBody, e);
		        extentLogger.log(Status.FAIL, "Failed to parse response to POJO: " + e.getMessage());
		        throw new RuntimeException("Could not parse JSON response", e);
		    }
		ObjectMapper mapper = new ObjectMapper();
		jsonResponse = mapper.writeValueAsString(pojoResponse);
		String schema = new String(Files.readAllBytes(Paths.get("src/test/resources/CreateorUpdateAPIschema.json")));
		
		try {
			assertThat(jsonResponse, matchesJsonSchema(schema));
			System.out.println("schema passed");
			extentLogger.info("Schema passed with this format"+schema);
		}

		catch (JsonSchemaValidationException e) {
			System.out.println("schema of add and updated component does not match");
			System.err.println("Details: " + e.getMessage());
		}

		System.out.println(pojoResponse.getMessage().getMessageKey());
		System.out.println(pojoResponse.getMessage().getMessage());

Assert.assertEquals(response.getStatusCode(), 200);
extentLogger.info("status code validated"+response.getStatusCode());
Assert.assertEquals(response.getHeader("Content-Type"), "application/json");
extentLogger.info("Header content -type value verified"+response.getHeader("Content-Type"));
Assert.assertNotEquals(response.getStatusCode(), 401);
	}
}