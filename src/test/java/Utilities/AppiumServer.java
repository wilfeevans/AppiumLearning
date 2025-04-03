package Utilities;

import java.io.File;

import org.testng.annotations.Test;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServer 
{
		public static AppiumDriverLocalService service;
		
		
		public static void start(){
			
			// starting the Appium server code

			 service = AppiumDriverLocalService.buildService(
					new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
					.withAppiumJS(new File("C:\\Users\\wilfr\\.appium\\node_modules\\appium-uiautomator2-driver\\build\\index.js"))
					.withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\log.txt"))
					.withArgument(GeneralServerFlag.LOCAL_TIMEZONE));
					service.start();
					
		}
		
		
		public static void stop(){
			
			service.stop();
			
		}

	


}
