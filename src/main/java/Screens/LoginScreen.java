package Screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen extends ScreenBase
{

	public LoginScreen(AppiumDriver driver) 
	{
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(id="flipboard.app:id/first_launch_get_started_button")
	public WebElement startButton;
	
	public ChooseTopicScreen getStarted()
	{
		startButton.click();
		
		return new ChooseTopicScreen(driver);
		
	}
	
	

}
