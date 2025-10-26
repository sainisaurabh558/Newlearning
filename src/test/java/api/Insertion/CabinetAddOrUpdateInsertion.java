package api.Insertion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import com.aventstack.extentreports.ExtentTest;

import api.endpoints.UserService;
import api.utilities.RandomDataGenerator;
import io.restassured.response.Response;

public class CabinetAddOrUpdateInsertion {
	UserService userservice;
	RandomDataGenerator RDG = new RandomDataGenerator();
	Response response;
	
	public CabinetAddOrUpdateInsertion( UserService userservice) {
		this.userservice= userservice;
	}

	public  Response  settingValueForAddAndUpdateCabinet(ExtentTest extentLogger ,Logger logger ) throws IOException
	{
		String filejson= new String(Files.readAllBytes(Paths.get("src/test/resources/CabinetAddAndUpdate.json")));
		JSONObject jsonobject = new JSONObject(filejson);
		jsonobject.put("serialStructure", RDG.randomStructure()+"1xxxxxx");
		jsonobject.put("cabinetType", RDG.getRandomString());
		jsonobject.put("companyId", RDG.getCompanyId());
		jsonobject.put("id", JSONObject.NULL);
		response=userservice.add_serial_Structure(jsonobject);
		extentLogger.info("Calling the cabinet add/update api");
		extentLogger.info("Payload inject in cabinet api"+ jsonobject.toString());
		return response;
		
	}
}
