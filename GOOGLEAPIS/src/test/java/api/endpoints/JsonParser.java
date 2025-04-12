package api.endpoints;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.List;

import org.json.JSONObject;

import api.utilities.JsonReaderAndMod;
import api.utilities.TextFileReaderAndMod;
import io.restassured.response.Response;

public class JsonParser {

	public static void main(String[] args) throws IOException, URISyntaxException {
		
	
		String path = System.getProperty("user.dir") + "/JsonContainer/Addplace.json";
		File file = new File(path);

		// Read the file content into a String
		String content = new String(Files.readAllBytes(file.toPath()));
		JSONObject jsonobject = new JSONObject(content);
	TextFileReaderAndMod textFileReaderAndMod = new TextFileReaderAndMod();
	List<String> list= textFileReaderAndMod.textReader();
	Response response = PlaceAPIendPoint.addPlace();

}
}