package com.metr.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetPropData 
{
  public static String propData(String key) throws IOException{
	  Properties prop = new Properties();
	  FileInputStream fis = new FileInputStream("src\\main\\resources\\config.properties");
	  prop.load(fis);
	 String data= prop.getProperty(key);
	 return data;
  }
}
