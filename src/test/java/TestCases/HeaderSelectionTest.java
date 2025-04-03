package TestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import Screens.HomeScreen;
import Screens.LoginScreen;
import Screens.SkipOrLoginScreen;
import Utilities.TestUtils;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class HeaderSelectionTest extends BaseTest
{
	LoginScreen loginScreen;
	SkipOrLoginScreen skipOrLoginScreen;
	HomeScreen homescreen;
	

	@BeforeTest
	public void init() throws IOException
	{
		setUp();
		loginScreen=new LoginScreen(driver);
		skipOrLoginScreen= new SkipOrLoginScreen(driver);
		homescreen=new HomeScreen(driver);
	}
	

	@Test(priority=1)
	public void validateGetStarted() throws InterruptedException
	{
		loginScreen.getStarted().chooseLatestTopic(4).clickButton().SkipforNow();
				
	}
	
	
		
	@Test(priority=2)
	public void getHeader() throws InterruptedException
	{
		WebElement ele=homescreen.menuSelection();	
		Thread.sleep(2000);
		
		TestUtils.swipeLeft(driver, 2);
		Thread.sleep(2000);
        TestUtils.swipToFindElementTopToBottom(driver, ele);
		Thread.sleep(4000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
	
	
	}
	
	
	
	@Test(priority=3)
	public void getFooter()
	{
		homescreen.bottomSelection();	
	}
	
	
	
	@AfterTest
	public void quitDriver() throws InterruptedException
	{
		quit();
	}


	

}
