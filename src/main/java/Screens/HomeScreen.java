package Screens;

import java.time.Duration;
import java.util.List;

import org.apache.commons.math3.stat.inference.TestUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class HomeScreen extends ScreenBase
{

	//@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.FrameLayout\").instance(26)")
	//public WebElement dailyEdition;
	
	@AndroidFindBys({
		
		@AndroidBy(id="flipboard.app:id/sliding_title_strip_container"), 
		//@AndroidBy(id="flipboard.app:id/sliding_image_image_view")
	})
	
	List<WebElement> container;
	
	public HomeScreen(AppiumDriver driver)
	{
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Photo Project Ideas to Get Unstuck\")")
	public WebElement PhotoProject;
	public WebElement menuSelection() throws InterruptedException
	{
		Thread.sleep(5000);
	//	System.out.println(dailyEdition.getText());
	//	dailyEdition.click();
		
     	return PhotoProject;
		}
	
	@AndroidFindBy(accessibility = "Following")
	public WebElement following;
	public void bottomSelection()
	{
		following.click();
	}
	

}
