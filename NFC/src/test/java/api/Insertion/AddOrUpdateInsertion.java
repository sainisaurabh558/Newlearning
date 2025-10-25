package api.Insertion;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.endpoints.UserService;
import api.payload.AddComponent;
import api.payload.SerialStructureDtoCabinet;
import api.utilities.RandomDataGenerator;
import io.restassured.response.Response;

public class AddOrUpdateInsertion {

	AddComponent addcom = new AddComponent();
	SerialStructureDtoCabinet SSDC = new SerialStructureDtoCabinet();
UserService userservice;
RandomDataGenerator RDG = new RandomDataGenerator();
Response response;



	public AddOrUpdateInsertion( UserService userservice) {
		this.userservice= userservice;
	}
	public  Response settingValueForAddAndUpdate(ExtentTest extentLogger, Logger logger) throws JsonProcessingException

	{

		logger.info("**************Insertion at the component API started******************");
	addcom.setComponentId("0x" + RDG.randomid());
	addcom.setCompanyId(RDG.getCompanyId());
	addcom.setPartName(RDG.getRandomString());
	addcom.setId(null);

	SSDC.setId(null);
	SSDC.setCompanyId(RDG.getCompanyId());
	SSDC.setPartType(RDG.getRandomString());
	SSDC.setSerialStructure(RDG.randomStructure() + "xxxxx");
	List<SerialStructureDtoCabinet> LS = new ArrayList<>();
	LS.add(SSDC);
	addcom.setSerialStructureDTOs(LS);
	
  response= userservice.addOrUpdateComponent(addcom);
  ObjectMapper mapper = new ObjectMapper();
  String jsonPayload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(addcom);
  if (extentLogger != null) {
	    extentLogger.info("Starting component AddOrUpdateInsertion");
	    extentLogger.info("payload injected for component "+ jsonPayload);
	}
 
 
 return response;
}
	public void sqlInjection()
	{
		
		
	}
	
}
