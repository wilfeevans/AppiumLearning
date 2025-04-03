package Rough;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeUtil 
{

	public static void swipeUp(AppiumDriver driver)
	{
		// Get screen size
        int screenWidth = driver.manage().window().getSize().width;
        int screenHeight = driver.manage().window().getSize().height;
		
		// Swipe coordinates (x, startY, endY)
        int startX = screenWidth / 2;
        int startY = (int) (screenHeight * 0.8); // Start from bottom of the screen
        int endY = (int) (screenHeight * 0.2); // End towards the top

        // Swipe action using TouchAction
        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(startX, startY))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();

        driver.quit();

		
		
	}
	
	
	
}
