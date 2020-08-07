package com.amazon.testSteps;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.amazon.UI.LocatorStorage;
import com.amazon.actions.ActionMethods;
import com.amazon.commonUtilities.ApplicationKeywords;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class ToClickProductAndVerifyThePage extends ApplicationKeywords {

	public static String strRandomValue;
	@SuppressWarnings("unchecked")
	public static void ToClick_RandomProduct(String strTitle) throws InterruptedException,IOException 
	{


		List<MobileElement> elements = (List<MobileElement>) driver.findElement
				(By.xpath("//android.widget.TextView[@resource-id=‘com.amazon.list-search-results’]/following::android.widget.results"));

		if(elements.size()>1)
		{
			System.out.println("After Click on Search --> The List of Product Results are displayed");

			Random random = new Random();
			int Randomtxt = random.nextInt(elements.size());

			System.out.println("Random value number :"+Randomtxt);
			strRandomValue = elements.get(Randomtxt).getText();
			System.out.println("'"+strTitle+"' -->> Random Product is ###  '"+strRandomValue+"' ###");

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			elements.get(Randomtxt).click();
			ActionMethods.waitForElementToAppear(LocatorStorage.page_productInfo, 10);
			System.out.println(" Selected :: '\"+strTitle+\"' -->> Random Product is ###  '\"+strRandomValue+\"' ###");
		}else {
			System.err.println("After Click on Search --> The List of Product Results are displayed");

		}


	}
	
	public static String product_Name,product_price,product_Desc;
	public static void get_ProductInfo()
	{
		//After Selecting Product from the list-->get product name,price and description
		
		MobileElement ele = driver.findElement(MobileBy.
				AndroidUIAutomator("new UiSelector().resourceId(\"com.amazon.checkoutDisplayPage\")"));
		if(ele.isDisplayed())
		{
			product_Name = ActionMethods.getTextInfo(LocatorStorage.product_Name);
			product_price =  ActionMethods.getTextInfo(LocatorStorage.product_Price);
			product_Desc =  ActionMethods.getTextInfo(LocatorStorage.product_Description);
			
			System.out.println("Product Information---> '"+product_Name+"'   , '"+product_price+"'   , '"+product_Desc+"'  ");
			
		}else {
			System.err.println("Error-->It does not get product info");
		}
	}
	
	
	public static void click_BuyNow()
	{
		MobileElement ele = driver.findElement(By.xpath(LocatorStorage.btn_BuyNow));
		ele.click();
		ActionMethods.waitUntilCondition(LocatorStorage.page_productInfo, 10);
	}
	
	public static String checkout_product_Name,checkout_product_price,checkout_product_Desc;
	public static void Verify_ProductInfo_InCheckoutPage()
	{
		MobileElement ele = driver.findElement(By.xpath(LocatorStorage.page_productInfo));
		if(ele.isDisplayed())
		{
			checkout_product_Name = ActionMethods.getTextInfo(LocatorStorage.checkout_product_Name);
			checkout_product_price =  ActionMethods.getTextInfo(LocatorStorage.checkout_product_Price);
			checkout_product_Desc =  ActionMethods.getTextInfo(LocatorStorage.checkout_product_Description);
			
			Assert.assertTrue(checkout_product_Name.equals(product_Name));
			Assert.assertTrue(checkout_product_Name.equals(product_price));
			Assert.assertTrue(checkout_product_Name.equals(product_Desc));
			
		}
		
	}
	
	public static void click_PlaceOrder()
	{
		MobileElement ele = driver.findElement(By.xpath(LocatorStorage.btn_PlaceOrder));
		ele.click();
		ActionMethods.waitUntilCondition(LocatorStorage.msg_Placeorder, 10);
	}
	
	public static String orderConfirmMsg;
	public static void get_ConfirmMsg()
	{
		
		orderConfirmMsg = ActionMethods.getTextInfo(LocatorStorage.msg_Placeorder);
		Assert.assertTrue(orderConfirmMsg.equals("Place-order-success"));
	}
	

}
