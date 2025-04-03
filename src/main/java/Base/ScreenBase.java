package Base;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ScreenBase 
{
	
	public static AppiumDriver driver;
	public WebDriverWait wait;
	
	public ScreenBase(AppiumDriver driver)
	{
		this.driver= driver;
	}
	
	public void hideKeyboard()
	{
		((HidesKeyboard) driver).hideKeyboard();
	}

	public void enter()
	{
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	}
}
