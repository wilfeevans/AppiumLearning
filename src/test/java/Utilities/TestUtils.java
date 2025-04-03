package Utilities;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TestUtils {

	public static void swipeScreenUp(AppiumDriver driver, int count) throws InterruptedException 
	{
		
		for(int i=0; i<count; i++)
		{		
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();

		int x = width / 2;
		int y = height / 2;

		int startX = x;
		int endY = (int) (height * 0.25);

		PointerInput finger = new PointerInput(Kind.TOUCH, "finger");

		Sequence sequence = new Sequence(finger, 1)
				.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
				.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger, Duration.ofMillis(200)))
				.addAction(
						finger.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), startX, endY))
				.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Collections.singleton(sequence));

		}
	}

	public static void swipeScreenDown(AppiumDriver driver, int count) throws InterruptedException 
	{
		for( int i=0; i<count; i++)
		{
			
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();

		int x = width / 2;
		int y = height / 2;

		System.out.println("x:" + x);
		System.out.println("y:" + y);

		int startX = x;
		int endY = (int) (y * 2.1);

		PointerInput finger = new PointerInput(Kind.TOUCH, "finger");

		Sequence sequence = new Sequence(finger, 1)
				.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
				.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger, Duration.ofMillis(200)))
				.addAction(
						finger.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), startX, endY))
				.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Collections.singleton(sequence));

		}
	}

	public static WebElement swipToFindElementTopToBottom(AppiumDriver driver, WebElement ele) throws InterruptedException 
	{
		int count = 1;
		int i = 1;

		while (i <= count) {
		try{

				if (ele.isDisplayed()) {

					ele.click();
					break;
				}

			}

			catch(NoSuchElementException e) {

				Dimension dim = driver.manage().window().getSize();
				int height = dim.getHeight();
				int width = dim.getWidth();

				int x = width / 2;
				int y = height / 2;

				int startX = x;
				int endY = (int) (height * 0.25);

				PointerInput finger = new PointerInput(Kind.TOUCH, "finger");

				Sequence sequence = new Sequence(finger, 1)
						.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
						.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
						.addAction(new Pause(finger, Duration.ofMillis(200)))
						.addAction(finger.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(),
								startX, endY))
						.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

				driver.perform(Collections.singleton(sequence));

			}

			i++;
			count++;

		}

		return ele;

	}

		
	public static void swipeLeft(AppiumDriver driver, int count) 
	{
		for(int i=0; i<count; i++)
		{
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();

		int x = width / 2;
		int y = height / 2;

		System.out.println("X:" + x);
		System.out.println("Y:" + y);

		int endX = (int) (width * 0.05);
		int endY = (int) (height * 0.95);

		PointerInput finger = new PointerInput(Kind.TOUCH, "finger");

		Sequence sequence = new Sequence(finger, 1)
				.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
				.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger, Duration.ofMillis(200)))
				.addAction(finger.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), endX, y))
				.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Collections.singleton(sequence));

		}
	}
	

	public static void swipeRight(AppiumDriver driver, int count) 
	{
		for(int i=0; i<count; i++)
		{
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();

		int startX = (int) (width * 0.1);
		int startY = height / 2;

		System.out.println("X:" + width);
		System.out.println("Y:" + height);

		int endX = (int) (width * 0.9);
		int endY = height / 2;

		PointerInput finger = new PointerInput(Kind.TOUCH, "finger");

		Sequence sequence = new Sequence(finger, 1)
				.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
				.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger, Duration.ofMillis(200)))
				.addAction(finger.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), endX, endY))
				.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Collections.singleton(sequence));

		}
	}
	
	
	public static WebElement swipeForLeftElement(WebElement ele, AppiumDriver driver) 
	{
	
		int count = 1;
		int i = 1;

		while (i <= count) {
			try {

				if (ele.isDisplayed()) {

					ele.click();
					break;
				}

			}

			catch (NoSuchElementException e) 
			{		
		
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();

		int x = width / 2;
		int y = height / 2;

		System.out.println("X:" + x);
		System.out.println("Y:" + y);

		int endX = (int) (width * 0.05);
		int endY = (int) (height * 0.95);

		PointerInput finger = new PointerInput(Kind.TOUCH, "finger");

		Sequence sequence = new Sequence(finger, 1)
				.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
				.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger, Duration.ofMillis(200)))
				.addAction(finger.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), endX, y))
				.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Collections.singleton(sequence));
     
			}

			i++;
			count++;

		}

		return ele;

	}

	
	

}
