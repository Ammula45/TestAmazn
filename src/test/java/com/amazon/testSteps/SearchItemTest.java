package com.amazon.testSteps;

import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;

import com.amazon.UI.LocatorStorage;
import com.amazon.actions.ActionMethods;
import com.amazon.commonUtilities.ApplicationKeywords;

import io.appium.java_client.MobileElement;

public class SearchItemTest extends ApplicationKeywords {
	
	@SuppressWarnings("unchecked")
	public static void SearchItem() throws InterruptedException, IOException, InvalidFormatException {

		String searchItemName = ApplicationKeywords.ReadExcelData("Search_Item");
		
		ActionMethods.typeIn(LocatorStorage.txt_SearchItem, searchItemName);
		ActionMethods.isClick(LocatorStorage.icon_Search);
		
		List<MobileElement> elements = (List<MobileElement>) driver.findElement
		(By.xpath("//android.widget.TextView[@resource-id=‘com.amazon.list-search-results’]/following::android.widget.results"));
				
		int sizeElem = elements.size();
		if(sizeElem>1)
		{
			System.out.println("After Click on Search --> The List of Product Results are displayed");
		}else
		{
			System.err.println("After Click on Search --> The List of Product Results are displayed");
		}
		
		
	}

}
