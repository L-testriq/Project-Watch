package com.watch.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesUtils {
	
	public static String getProperty(String key, String filePath) {
		try {
			FileInputStream fis = new FileInputStream(new File(filePath));
			Properties prop = new Properties();
			prop.load(fis);
			return prop.getProperty(key);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void setProperty(String key, String value, String filePath) {
		File file = new File(filePath);
		Properties prop = new Properties();
		if(file.exists()) {
			try {
				FileInputStream fis = new FileInputStream(file);
				prop.load(fis);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		prop.setProperty(key, value);
		try {
			FileOutputStream fos = new FileOutputStream(file);
			prop.store(fos, key);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
