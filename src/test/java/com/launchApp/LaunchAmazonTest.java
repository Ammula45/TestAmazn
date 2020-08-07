package com.launchApp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LaunchAmazonTest {

	public static void LaunchApp() {

		
		DesiredCapabilities c = new DesiredCapabilities();
		c.setCapability("deviceName", "Redmi");
		c.setCapability("udid", "4e16508c0803"); //Give Device ID of your mobile phone
		c.setCapability("platformName", "Android");
		c.setCapability("platformVersion", "7.0 NRD90M");
		c.setCapability("app", "C:\\Users\\Ravikanth\\Desktop\\a1.apk");
		c.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		c.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");



		try
		{
			URL u = new URL("https://0.0.0.0:4723/wd/hub");
			AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(u, c);
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

		} 
		catch (MalformedURLException e) 
		{
			System.out.println(e.getMessage());
		}


	}



}
