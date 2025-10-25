package api.endpoints;

public class Routes {

	static String BaseURL = "http://localhost:8080/";

	// API end point for the login
	static String loginUrl = BaseURL + "Services/api/login/userlogin";

	// API to add or update a component
	static String add_Update_Component = BaseURL + "Services/api/web/nfc/component/addorupdate";
	
	//End point for the API to add or update cabinet serial structure from webtool
	
	static String add_serial_Structure ="Services/api/web/nfc/cabinet/serialstructure/addupdate";
	
	//commit!

}
