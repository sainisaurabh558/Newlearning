package api.utilities;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.ArrayList;

import org.json.JSONObject;

import api.utilities.DataGenerator.ENUMCOL;       

public class JsonReader {


	public static JSONObject addPlaceJson() throws IOException, URISyntaxException {

		String path = System.getProperty("user.dir") + "/JsonContainer/Addplace.json";
		File file = new File(path);

		// Read the file content into a String
		String content = new String(Files.readAllBytes(file.toPath()));
		JSONObject jsonobject = new JSONObject(content);
		String name=DataGenerator.dataStringGenerator( ENUMCOL.LASTNAME);	
		jsonobject.put("name", name);
		System.out.println("name"+name);

		String accuracy=DataGenerator.getRandomNumber(3);
		jsonobject.put("accuracy", accuracy);
		System.out.println("accuracy"+accuracy);

		String  phone_number=DataGenerator.getRandomPhoneNo(10, 15);

		jsonobject.put("phone_number", "91"+phone_number);
		System.out.println("phone_number"+phone_number);

		String  address=DataGenerator.dataStringGenerator(ENUMCOL.Address);
		jsonobject.put("address", address);
		System.out.println("address"+address);

		String  website=DataGenerator.getRandomWebsiteName();
		jsonobject.put("website", website);
		System.out.println("website"+website);

		String  language=DataGenerator.getRandomAlphabets(10);
		jsonobject.put("language", "Lan "+language);
		System.out.println("language"+language);

		//Adding random value to the type array

		ArrayList<String> randomArray = new ArrayList<>();

		for(int i=0; i<jsonobject.getJSONArray("types").length(); i++)
		{

			randomArray.add(DataGenerator.getRandomAlphabets(i+5));

		}
		jsonobject.put("types", randomArray);
		System.out.println("randomArray"+randomArray);
		
		//Adding random value to the lat long
		
		JSONObject location= jsonobject.getJSONObject("location");
		location.put("lat", DataGenerator.getDoubleNumber());
		location.put("lng", DataGenerator.getDoubleNumber());
		
		jsonobject.put("location", location);
		
		
















		// Get the types array from the JSON object
		//		JSONArray typesArray = jsonobject.getJSONArray("types");
		//
		//		try {
		//
		//			for (int i = 0; i < typesArray.length(); i++) {
		//
		//				if (typesArray.getString(i).equals("shop")) {
		//					System.out.println("Before update: " + typesArray.getString(i));
		//
		//
		//					typesArray.put(i, "hello");  
		//
		//					System.out.println("After update: " + typesArray.getString(i));
		//					break; 
		//				}
		//			}
		//
		//
		//			jsonobject.put("types", typesArray);
		//
		//		} catch (Exception e) {
		//
		//			e.printStackTrace();
		//		}


		return jsonobject;
	}
}
