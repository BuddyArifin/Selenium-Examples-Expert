package com.photon.phresco.resources;
import org.openqa.selenium.WebDriver;

import com.photon.phresco.selenium.util.CommonUtils;
import com.photon.phresco.selenium.util.CommonUtils.ElementType;



public class HomePage {
	public static WebDriver driver;
	public static String PROMO_SLIDER = "wu-image-slider";
	public static String  SEND_MONEY_ONLINE = "wu-sendmoneymini-title";
	public static String ZIP_CODE="wu_sendmoneymini_zip";
	public static String COUNTRY_LIST = "wu-homescreen-dropdown-destination-list-content";
	public static String SEND_AMOUNT = "wu_sendmoneymini_amount";
	public static String SEND_BTN = "wu_sendmoneymini_getStarted";
	public static String SPINNER_CLASS = "spinner-container";
	
	public HomePage(WebDriver driver){
		HomePage.driver = driver;
	}
	
	public static void homeScreenVerification() throws Exception {
		CommonUtils.isElementPresent(ElementType.CLASS, PROMO_SLIDER, "Promotion slider");
		CommonUtils.isElementPresent(ElementType.CLASS, SEND_MONEY_ONLINE, "send money online widget");
		CommonUtils.isElementPresent(ElementType.ID, ZIP_CODE ," zip code" );
		CommonUtils.isElementPresent(ElementType.ID, COUNTRY_LIST ,"Country list");
		CommonUtils.isElementPresent(ElementType.ID, SEND_AMOUNT , "send amount");
		CommonUtils.isElementPresent(ElementType.ID, SEND_BTN , "Get started button");
	}
		 
}
	
