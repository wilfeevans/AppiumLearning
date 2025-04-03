package Screens;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ChooseTopicScreen extends ScreenBase
{

	public ChooseTopicScreen(AppiumDriver driver) 
	{
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"flipboard.app:id/topic_picker_topic_row_topic_tag\"]")
	public List<WebElement> choose;
	
	@AndroidFindBy(id="flipboard.app:id/topic_picker_continue_button")
	public WebElement chooseButton; 
	
		
	public ChooseTopicScreen chooseLatestTopic(int topic)
	{
		for(int i=0; i<topic; i++)
		{
			choose.get(i).click();
			
		}
		
		return this;
		
	}
	
	
	public SkipOrLoginScreen clickButton()
	{
		chooseButton.click();
		return new SkipOrLoginScreen(driver);
	}
	
	
	
	
}
