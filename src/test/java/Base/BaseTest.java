package Base;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import Utilities.AppiumServer;
import Utilities.CommonUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest
{
	
	public AndroidDriver driver;
	public static String loadPropertyFile="AndroidConfigProperty";
	public static Logger log= Logger.getLogger(BaseTest.class);
	
	public void setUp() throws IOException
	{
		if(driver==null)
		{
			PropertyConfigurator.configure("./src/test/resources/Properties/Log4j.properties");
			
			if(loadPropertyFile.startsWith("Android"))
			{
				 //AppiumServer.start();
				log.info("Appium Server Started");
				CommonUtils.loadAndroidConfigProperty(loadPropertyFile);
				log.info(loadPropertyFile +"Property File Loaded");
				CommonUtils.setAndroidCapabilities();
				driver=(AndroidDriver) CommonUtils.getAndroidDriver();
				
			}
			
			else if(loadPropertyFile.startsWith("IOS"))
			{
				
				//code to be written
			}
			
			
		}
			
		}
		
	
	public void quit() throws InterruptedException
	{
		Thread.sleep(20000);
		driver.quit();
		log.info("Test Case Execution Completed");
		
		//AppiumServer.stop();
		log.info("Appium Server Stopped");
	}
	
	
	

}
