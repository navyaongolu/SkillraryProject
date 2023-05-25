package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains all reusable methods to perform actions
 * on properties file
 * @author navya
 *
 */
public class PropertiesUtility {
	private Properties property;
	/**
	 * This method is used to initialize properties file
	 * @param filepath
	 */
			
	public void propertiesInit(String filepath)
	{
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		property = new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
	}
	/**
	 * This method is used to fetch data from properties file
	 * @param key
	 * @return
	 */
	public String readData(String key)
	{
		return property.getProperty(key);
	}
	/**
	 * this method is used to write and save data to properties file
	 * @param key
	 * @param Value
	 * @param filepath
	 */
	public void writeToProperties(String key,String Value,String filepath)
	{
		property.put(key,Value);
		FileOutputStream fos =null;
		try {
			fos=new FileOutputStream(filepath);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			property.store(fos, "updated");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
