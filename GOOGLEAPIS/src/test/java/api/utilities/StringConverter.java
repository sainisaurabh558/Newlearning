package api.utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class StringConverter {


	public  static   String convertStringToJson(Response  response, String value)
	{

		JsonPath jsonPath = new JsonPath(response.asString());
		return jsonPath.getString(value);

	}
}
