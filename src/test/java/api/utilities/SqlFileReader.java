package api.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SqlFileReader 
{

 public static List<String> readerSqlFile() throws IOException
 {
	 List<String> sqldata = new ArrayList<>();
 String path= System.getProperty("user.dir")+ "/src/test/resources/SQLInjectionPayload.txt";	 
File file = new File(path);

Scanner scanner = new Scanner(file);
while(scanner.hasNextLine())
{
    	
	String linedata = scanner.nextLine();
	sqldata.add(linedata);
}
return sqldata;
	 
 }
 
 public static void main(String[] args) throws IOException {
List<String>lines=  SqlFileReader.readerSqlFile();
	
System.out.println(lines);
}
 
}
