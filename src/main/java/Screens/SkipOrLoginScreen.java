package Screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;



public class SkipOrLoginScreen extends ScreenBase
{
	@AndroidFindBy(xpath="//android.view.ViewGroup[@resource-id=\"flipboard.app:id/account_login_buttons_skip\"]")
	public WebElement skip;
	
	
	

	public SkipOrLoginScreen(AppiumDriver driver)
	{
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	public HomeScreen SkipforNow()
	{
		skip.click();
		return new HomeScreen(driver);
		
		
	}
	
	
	
	
	

}
