package TestCases;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseTest;
import Screens.ChooseTopicScreen;
import Screens.LoginScreen;
import Screens.SkipOrLoginScreen;

public class FlipBoardLoginTest extends BaseTest
{
	
	LoginScreen loginScreen;
	ChooseTopicScreen chooseTopicScreen;
	SkipOrLoginScreen skipOrLoginScreen;
	
	@BeforeTest
	public void init() throws IOException
	{
		setUp();
		loginScreen=new LoginScreen(driver);
		chooseTopicScreen= new ChooseTopicScreen(driver);
		skipOrLoginScreen= new SkipOrLoginScreen(driver);
		
	}
	
	@Test(priority=1)
	public void validateGetStarted()
	{
		loginScreen.getStarted();
	}
	
	@Test(priority=2)
	public void chooseTopic() throws InterruptedException
	{
		chooseTopicScreen.chooseLatestTopic(4);
		chooseTopicScreen.clickButton();
				
	}
	
	@Test(priority=3)
	public void skippingNow() throws InterruptedException
	{
		Thread.sleep(6000);
		skipOrLoginScreen.SkipforNow();
		
	}
	
	
	
		
	
	@AfterTest
	public void quitDriver() throws InterruptedException
	{
		quit();
	}

}
