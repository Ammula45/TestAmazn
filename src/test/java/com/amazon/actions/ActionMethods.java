package com.amazon.actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class ActionMethods {

	public static AndroidDriver<MobileElement> driver;
	public static WebElement ele ;

	public static void ScreenSwipe()
	{
		Dimension size = driver.manage().window().getSize(); 

		int startx = (int) (size.width * 0.8);          
		int endx = (int) (size.width * 0.20);       
		int starty = size.height / 2;   

		driver.swipe(startx, starty, endx, starty, 1000);


	}

	public static void isClick(String strXpath) throws InterruptedException
	{
		if(driver.findElementByAndroidUIAutomator(strXpath).isDisplayed())
		{
			
			driver.findElementByAndroidUIAutomator(strXpath).click();
			Thread.sleep(2000);
			}else {
				System.err.println("Error Found in Click Actions :: " +strXpath);
			}
	

	}
	
	public static void typeIn(String strXpath,String sendChar)
	{
		MobileElement ele = driver.findElement(By.xpath(strXpath));
		ele.sendKeys(sendChar);
	}
	


	public static void clickAndHold(String objectLocator) {

		//com.amazon.edp-feature-declaration
		MobileElement ele = driver.findElement(MobileBy.
				AndroidUIAutomator("new UiSelector().resourceId(\" "+objectLocator+"\")"));

		try {
			TouchAction action = new TouchAction(driver);
			action.longPress(ele);
			action.release();
			action.perform().waitAction(2000);
			System.out.println("ClickAndHold on :" + objectLocator);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	public static void clickOnTextView(String textValue) {

		MobileElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='" + textValue + "']"));

		if(ele.isDisplayed())
		{
			ele.click();
		}else {
			System.err.println("Not Click");
		}
	}

	
	public static void scrollToExact(String text) {
		try {
			driver.scrollToExact(text);
			System.out.println("Scroll to exact '" + text + "' text");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static void swipe(int startx, int starty, int endx, int endy,
			int durationMS) {
		try {
			driver.swipe(startx, starty, endx, endy, durationMS);
			System.out.println("Perform swipe operation");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static String getTextInfo(String strXpath)
	{
		MobileElement ele = driver.findElement(By.xpath(strXpath));
		String get_Text = ele.getText();
		return get_Text;
		
	}

	public static void waitForElementToAppear(String xpath,int TimeOutInSeconds)
	{
		WebElement element = null;
		boolean isElementClickable=false;
		int counter=0;
		do
		{
			try {

				if(!xpath.isEmpty())
				{
					element = driver.findElement(By.xpath(xpath));
				}
				else
				{
					isElementClickable = driver.findElement(By.xpath(xpath)).isDisplayed();
				}			

				if(element!=null||isElementClickable==true)
				{
					break;
				}
				else
				{
					TimeUnit.SECONDS.sleep(TimeOutInSeconds);
				}
			} 
			catch (NoSuchElementException NoSuchEx) 
			{
				try {
					TimeUnit.SECONDS.sleep(TimeOutInSeconds);
				} catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}

			catch (Exception e) 
			{
				System.out.println("Exception occured upon waiting for an element "+e.getLocalizedMessage());
			}
			counter=counter+1;
		}while(counter!=10);  

	}
	
	public static void waitUntilCondition(String xpath,int TimeOutInSeconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, TimeOutInSeconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(By
		            .xpath(xpath)));

		
		
	}
	

}
