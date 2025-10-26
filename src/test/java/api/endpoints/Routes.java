package api.endpoints;

public class Routes {

	static String BaseURL = "http://192.168.0.105:8080/";

	// API end point for the login
	static String loginUrl = BaseURL + "Services/api/login/userlogin";

	// API to add or update a component
	static String add_Update_Component = BaseURL + "Services/api/web/nfc/component/addorupdate";
	
	//End point for the API to add or update cabinet serial structure from Webtool
	
	static String add_serial_Structure =BaseURL+ "Services/api/web/nfc/cabinet/serialstructure/addupdate";
	
	//commit

}
