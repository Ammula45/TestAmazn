package com.amazon.UI;

public class LocatorStorage {

	public static final String btn_AddToCart = "//android.widget.TextView[@text='addToCart']/..//android.widget.ImageButton";
	public static final String txt_SearchItem = "new UiSelector().resourceId(\"in.amazon.field-keywordsme\")";
	

	public static final String page_Home = "new UiSelector().resourceId(\"in.amazon.CustomerMsg\")";
	public static final String icon_Search = "//android.widget.ImageButton[@content-desc='Go']";
	
	public static final String product_Name ="//android.widget.TextView[@text='color-base-a-text']";
	public static final String product_Price ="//android.widget.TextView[@text='a-price-whole']";
	public static final String product_Description ="//android.widget.TextView[@text='edp-feature-declaration']";
	public static final String product_Availability ="//android.widget.TextView[@text='Currently unavailable.']";

	
	
	public static final String btn_BuyNow = "//android.widget.ImageButton[@content-desc='submit.buy-now']";
	public static final String page_productInfo =  "new UiSelector().resourceId(\"com.amazon.checkoutDisplayPage\")";

	
	public static final String checkout_product_Name ="//android.widget.TextView[@text='asin-title']";
	public static final String checkout_product_Price ="//android.widget.TextView[@text='color-price']//..//android.widget.TextView[@resource-id='decoration']";
	public static final String checkout_product_Description ="//android.widget.TextView[@text='order-summary-grand-total']//..//android.widget.TextView[@resource-id='total-price']";

	
	public static final String btn_PlaceOrder = "//android.widget.ImageButton[@content-desc='placeYourOrder1']";

	
	public static final String  msg_Placeorder = "//android.widget.TextView[@content-desc='Place-order-success']";

	public static final String txt_Username = "new UiSelector().resourceId(\"in.amazon.shopping:id/username\")";
	public static final String txt_password = "Password textbox #androiduiautomator=new UiSelector().resourceId(\"in.amazon.shopping:id/password\")";
	public static final String btn_login = "Log In button #androiduiautomator=new UiSelector().text(\"Log In\")";
	public static final String lnk_year= "year link #xpath=//android.widget.TextView[@resource-id='android:id/date_picker_year']";

	
	public static final String txt_url = "Url textbox #androiduiautomator=new UiSelector().resourceId(\"in.amazon.shopping:id/host\")";




}
