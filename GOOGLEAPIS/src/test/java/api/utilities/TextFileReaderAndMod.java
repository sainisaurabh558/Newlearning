package api.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileReaderAndMod {

	public  List<String> textReader() throws FileNotFoundException
	{

		List<String> lines = new ArrayList<>();
		String path = System.getProperty("user.dir") + "/JsonContainer/sqlInjection.txt";
		File file = new File(path);
		Scanner filetxt= new Scanner(file);

		while(filetxt.hasNextLine())
		{

			String line = filetxt.nextLine();
			lines.add(line);
			
		}
		filetxt.close();
		return lines;
		
	}


}

