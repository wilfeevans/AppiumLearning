package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class CommonUtils
{
	public static AppiumDriver driver;
	public static DesiredCapabilities cap;
	
	public static FileInputStream fis;
	public static Properties prop= new Properties();
	
	public static String DeviceName;
	public static String UDID;
	public static String PlatformName;
	public static String PlatformVersion;
	public static String AutomationName;
	public static String AppPackage;
	public static String AppActivity;
	public static String AutoGrantPermissions;
	
	public static URL url;
	
	public static void loadAndroidConfigProperty(String loadPropertyFile) throws IOException
	{
		
		fis= new FileInputStream("./src/test/resources/Properties/" +loadPropertyFile +".properties");
		prop.load(fis);
		
		DeviceName= prop.getProperty("deviceName");	
		UDID= prop.getProperty("udid");
		PlatformName=prop.getProperty("platformName");
		AutomationName=prop.getProperty("automationName");
		PlatformVersion=prop.getProperty("PlatformVersion");
	    AutoGrantPermissions=prop.getProperty("autoGrantPermissions");
	    AppPackage=prop.getProperty("appPackage");
	    AppActivity=prop.getProperty("appActivity");
	    
	    
	}
	
	public static void setAndroidCapabilities()
	{
		     cap= new DesiredCapabilities( );
		    		
		        cap.setCapability("appium:deviceName", DeviceName);
		        cap.setCapability("appium:udid",UDID);
		        cap.setCapability("platformName",PlatformName);
		        cap.setCapability("appium:platformVersion",PlatformVersion);
		        cap.setCapability("appium:automationName",AutomationName);
		        cap.setCapability("appium:autoGrantPermissions",AutoGrantPermissions);
		        cap.setCapability("appium:appPackage",AppPackage);
		        cap.setCapability("appium:appActivity",AppActivity);
		}
	
	
	public static void loadIOSConfigProperty(String loadPropertyFile)
	{
		//code needs to be written
		
	}
	
	public static void setIOSCapabilities()
	{
		//code needs to be write
		
	}
	
	
	public static AppiumDriver getAndroidDriver() throws MalformedURLException
	{
		
		url= new URL("http://127.0.0.1:4723/");
		
		driver= new AndroidDriver(url,cap);
		
		return driver;
		
	}
	
	
	public static AppiumDriver getIOSDriver()
	{
		return driver;
		
	}
	
	
	
	

}
