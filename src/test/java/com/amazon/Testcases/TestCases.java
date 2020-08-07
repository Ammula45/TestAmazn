package com.amazon.Testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.amazon.testSteps.LoginTest;
import com.amazon.testSteps.SearchItemTest;
import com.amazon.testSteps.ToClickProductAndVerifyThePage;
import com.launchApp.LaunchAmazonTest;

public class TestCases {


	@Test(priority = 1)
	public static void TC1_LaunchApp() throws  InterruptedException, IOException
	{
		LaunchAmazonTest.LaunchApp();

	}

	@Test(priority = 2)
	public static void TC2_Login() throws  InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException
	{
		LoginTest.Login();

	}

	@Test(priority = 3)
	public static void TC3_SearchProduct() throws  InterruptedException, IOException, InvalidFormatException
	{
		SearchItemTest.SearchItem();
	}

	@Test(priority = 4)
	public static void TC4_ClickProduct()
	{
		try 
		{
			ToClickProductAndVerifyThePage.ToClick_RandomProduct("Select Random Product From List in Amazon Shopping");
		} 
		 catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 5)
	public static void TC5_GetProductInfo()
	{
		ToClickProductAndVerifyThePage.get_ProductInfo();

	}

	@Test(priority = 6)
	public static void TC6_Verify_ProductInfo_InCheckoutPage()
	{
		ToClickProductAndVerifyThePage.Verify_ProductInfo_InCheckoutPage();

	}

	@Test(priority = 7)
	public static void TC7_BuyNow()
	{
		ToClickProductAndVerifyThePage.click_BuyNow();

	}

	@Test(priority = 8)
	public static void TC8_PlaceOrder()
	{
		ToClickProductAndVerifyThePage.click_PlaceOrder();

	}

	@Test(priority = 9)
	public static void TC9_OrderConfirm()
	{
		ToClickProductAndVerifyThePage.get_ConfirmMsg();

	}


}
