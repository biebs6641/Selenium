package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class propertiesUtility {

	public static String getdata(String key) throws FileNotFoundException,IOException {
		
		//file
		File file =new File("C:\\Users\\LEGION\\Desktop\\testData.properties");
		
		//file reader -> it reads character by character data from the file
		FileReader fileReader = new FileReader(file);
		
		//properties Object
		Properties prop =new Properties();
		
		//load properties object
		prop.load(fileReader);
		 
		//getValue
		return (String) prop.get(key);
		
	}
}

