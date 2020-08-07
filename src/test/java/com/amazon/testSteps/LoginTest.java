package com.amazon.testSteps;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.amazon.UI.LocatorStorage;
import com.amazon.actions.ActionMethods;
import com.amazon.commonUtilities.ApplicationKeywords;

public class LoginTest extends ActionMethods {

	

	public static void Login() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {

		String userName = ApplicationKeywords.ReadExcelData("Username");
		String passWord = ApplicationKeywords.ReadExcelData("Password");

		ActionMethods.typeIn(LocatorStorage.txt_Username, userName);
		ActionMethods.typeIn(LocatorStorage.txt_password, passWord);
		ActionMethods.isClick(LocatorStorage.btn_login);

		if(driver.findElementByAndroidUIAutomator(LocatorStorage.page_Home).isDisplayed())
		{
			System.out.println("Login Successfully");
		}
		else
		{
			System.out.println("Login failed");
		}
	}

}
