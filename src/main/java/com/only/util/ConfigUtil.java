package com.only.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {

	private static Properties config;
	static
	{
		try(
			 InputStream in = ConfigUtil.class.getClassLoader().getResourceAsStream("config.properties");
		) {
			config= new Properties();
			config.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	}
	
	
	public static String getValue(String key)
	{
		return config.getProperty(key);
	}
	
	
	public static String getBasePackage()
	{
		return getValue("basePackage");
	}


	public static String getModelPackage()
	{
		return getBasePackage()+"."+getValue("modelPackage");
	}

	public static String getServicePackage()
	{
		return getBasePackage()+"."+getValue("servicePackage");
	}

	public static String getMapperPackage()
	{
		return getBasePackage()+"."+getValue("mapperPackage");
	}
	
	 
	
}
