package api.test;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import java.net.Socket;

import com.aventstack.extentreports.ExtentTest;

import api.Insertion.AddOrUpdateInsertion;
import api.Insertion.CabinetAddOrUpdateInsertion;
import api.Validation.CabinetAddAndUpdate;
import api.Validation.ValidationForAddAndUpdateApi;
import api.endpoints.UserService;
import api.utilities.BaseForReportAndLogging;
import api.utilities.ExtentReportManager;
import io.restassured.response.Response;

public class Testfeature extends BaseForReportAndLogging{
	
	UserService userservice = new UserService();
	Response response;
	ValidationForAddAndUpdateApi validationForcomponentApi = new ValidationForAddAndUpdateApi();
	AddOrUpdateInsertion addorupdate = new AddOrUpdateInsertion(userservice);
	CabinetAddOrUpdateInsertion cabinetObject = new CabinetAddOrUpdateInsertion(userservice);

	// this is used to call the token generate method and also receiving the response.

	@BeforeSuite
	void serverStatus() {

		if (userservice.serverResponseCheck() == 200) {
			System.out.println("server working");
		} else {
			System.out.println("server not working");
		}
	}
	
       

	@BeforeClass
	void generateToken() {

		userservice.login("darshit");

	}
	@BeforeMethod
	void setupEach(Method method) {
	    initLoggers(this.getClass()); 
	}

	// this method is used to call the add/update component method

	@Test(invocationCount = 5, priority=1)
	
	void addOrUpdateComponent() throws IOException {
	 response = addorupdate.settingValueForAddAndUpdate(getExtentLogger(), getLogger() );
     	validationForcomponentApi.ValidationOnResponse(response, getExtentLogger(), getLogger());
	}
	
	@Test(invocationCount = 5, priority=2)
	void addOrUpdateCabinet() throws IOException {

		response= cabinetObject.settingValueForAddAndUpdateCabinet(getExtentLogger(), getLogger() );
     	CabinetAddAndUpdate.cabinetvalidation(response, getExtentLogger(), getLogger() );
	}

}
