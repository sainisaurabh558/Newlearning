package api.utilities;

import java.io.File;              // Import the File class for handling file paths
import java.io.IOException;       // Import IOException to handle file I/O exceptions
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;      // Import Files for reading file content

import org.json.JSONObject;       // Import the JSONObject class
public class JsonReader {

    public static JSONObject addPlaceJson() throws IOException, URISyntaxException {
    	
    	
    	String  path =System.getProperty("user.dir")+"/JsonContainer/Addplace.json";
    	File file = new File(path);
        String content = new String(Files.readAllBytes(file.toPath()));
        
        JSONObject Jsob = new JSONObject(content);
        
        System.out.println("Data fecthed from the file jsob"+Jsob);

        return Jsob;
    }
}
