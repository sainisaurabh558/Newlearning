package api.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextFileReaderAndMod {
	String line;

	public  String textReader() throws FileNotFoundException
	{

		String path = System.getProperty("user.dir") + "/JsonContainer/sqlInjection.txt";
		File file = new File(path);
		Scanner filetxt= new Scanner(file);

		while(filetxt.hasNextLine())
		{

			this.line = filetxt.nextLine();
			System.out.println(this.line );

		}
		return line;

	}


}

