package Rough;

import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ScrollUtils {
	
	public static WebElement ele;

	 public static void scrollToText(AndroidDriver driver, String text) {
	        WebElement element=driver.findElement(AppiumBy.androidUIAutomator( "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + text + "\"));"
	        ));
	        System.out.println("Found element with text: " + text);
	        element.click();  // You can perform further actions after finding the element
	    }

	
	//Scroll to a particular element
	
	public static WebElement scrollToElement(By by,AndroidDriver driver) {
		WebElement element = null;
		int numberOfTimes = 10;
		Dimension size = driver.manage().window().getSize();
		int anchor = (int)(size.width / 2);
		//Swipe up to scroll down
		int startPoint = (int)(size.height - 10);
		int endPoint = 10;

		for (int i = 0; i < numberOfTimes; i++) {
		try {
		new TouchAction(driver)
		.longPress(PointOption.point(anchor, startPoint)) //.press(point(anchor, startPoint)) if used press need proper waiting time
		//.waitAction(waitOptions(ofMillis(miliseconds)))
		.moveTo(PointOption.point(anchor, endPoint)).release().perform();
		element = (WebElement) driver.findElement(by);
		i = numberOfTimes;
		} catch (NoSuchElementException ex) {
		System.out.println(String.format("Element not available. Scrolling (%s) times�", i + 1));
		}
		}
		return element;
		}
	
	public static void scrollDown(AndroidDriver driver) {
	    //if pressX was zero it didn't work for me
	    int pressX = driver.manage().window().getSize().width / 2;
	    // 4/5 of the screen as the bottom finger-press point
	    int bottomY = driver.manage().window().getSize().height * 4/5;
	    // just non zero point, as it didn't scroll to zero normally
	    int topY = driver.manage().window().getSize().height / 8;
	    //scroll with TouchAction by itself
	    scroll(pressX, bottomY, pressX, topY,driver);
	}



	public static void scroll(int fromX, int fromY, int toX, int toY, AndroidDriver driver) {
	    TouchAction touchAction = new TouchAction(driver);
	    touchAction.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
	}
	
	
	
	public static void scrollUp(int howManySwipes,AppiumDriver  driver) {
		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		// calculate coordinates for vertical swipe
		int startVerticalY = (int) (size.height * 0.8);
		int endVerticalY = (int) (size.height * 0.21);
		int startVerticalX = (int) (size.width / 2.1);
		  try {
		      for (int i = 1; i <= howManySwipes; i++) {
						new TouchAction((PerformsTouchActions) driver).press(PointOption.point(startVerticalX, startVerticalY))
								.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(startVerticalX, endVerticalY)).release()
								.perform();
					}
				} catch (Exception e) {
					//print error or something
				}
	}
	
	
	
	public static void scrollDown(int howManySwipes,AppiumDriver driver) {
		org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		// calculate coordinates for vertical swipe
		int startVerticalY = (int) (size.height * 0.8);
		int endVerticalY = (int) (size.height * 0.21);
		int startVerticalX = (int) (size.width / 2.1);
		  try {
		      for (int i = 1; i <= howManySwipes; i++) {
						new TouchAction((PerformsTouchActions) driver).press(PointOption.point(startVerticalX, endVerticalY))
								.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(startVerticalX, startVerticalY)).release()
								.perform();
					}
				} catch (Exception e) {
					//print error or something
				}
		  
		  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

public static  WebElement swipeScreen(AppiumDriver driver, WebElement ele) throws InterruptedException
	{
		int count=1;
		int i=1;
		
			
		while(i<=count)
		{	
			try
		 {
				ele= driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"flipboard.app:id/board_item_title\" and @text=\"FLORIDA\"]"));
				
				if(ele.isDisplayed())
				{
					
					ele.click();
					break;
		        }
			
		}
		
				
		catch(NoSuchElementException e)
			{
			
Dimension dim=driver.manage().window().getSize();
int height=dim.getHeight();
int width= dim.getWidth();
		
int x= width/2;
int y= height/2;

int startX= x;
int endY= (int) (height * 0.25);

PointerInput finger= new PointerInput(Kind.TOUCH,"finger");


Sequence sequence= new Sequence(finger, 1)
		.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), x, y))
		.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		.addAction(new Pause(finger,Duration.ofMillis(200)))
		.addAction(finger.createPointerMove(Duration.ofMillis(200),PointerInput.Origin.viewport(), startX, endY))
		.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singleton(sequence));
	
			}
			
			i++;
			count++;
			
		}
	
	     
	  
	return ele;
		    	   
		    	   
	}	    	   
	            

public static void swipeLeft(AppiumDriver driver)
{
	Dimension dim=driver.manage().window().getSize();
	int height=dim.getHeight();
	int width= dim.getWidth();
			
	int x= width/2;
	int y= height/2;
	
	System.out.println("X:" + x);
	System.out.println("Y:" + y);

	int endX= (int) (width * 0.05);
	int endY= (int) (height * 0.95);

	PointerInput finger= new PointerInput(Kind.TOUCH,"finger");


	Sequence sequence= new Sequence(finger, 1)
			.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), x, y))
			.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
			.addAction(new Pause(finger,Duration.ofMillis(200)))
			.addAction(finger.createPointerMove(Duration.ofMillis(200),PointerInput.Origin.viewport(), endX, y))
			.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	        driver.perform(Collections.singleton(sequence));

	
	
}
		
public static void swipeRight(AppiumDriver driver)
{
	Dimension dim=driver.manage().window().getSize();
	int height=dim.getHeight();
	int width= dim.getWidth();
			
	int startX= (int) (width * 0.1);
	int startY= height/2;
	
	System.out.println("X:" + width);
	System.out.println("Y:" + height);

	int endX= (int) (width * 0.9);
	int endY=  height/2;

	PointerInput finger= new PointerInput(Kind.TOUCH,"finger");


	Sequence sequence= new Sequence(finger, 1)
			.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), startX,startY))
			.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
			.addAction(new Pause(finger,Duration.ofMillis(200)))
			.addAction(finger.createPointerMove(Duration.ofMillis(200),PointerInput.Origin.viewport(), endX, endY))
			.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	        driver.perform(Collections.singleton(sequence));

	
	
}

	
	
	
	
	
	
	

		  
	
}
