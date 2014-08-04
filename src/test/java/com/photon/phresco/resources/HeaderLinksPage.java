package com.photon.phresco.resources;
import org.openqa.selenium.WebDriver;

import com.photon.phresco.selenium.util.CommonUtils;
import com.photon.phresco.selenium.util.CommonUtils.ElementType;

public class HeaderLinksPage {
	public static WebDriver driver;

	public static String SITE_LOGO = "wu-header-logo";
	public static String USER_REG = "wu-header-register";
	public static String USER_LOGIN = "wu-header-login"; 
	
	public static String HDR_CONSUMER_LINK = "wu-header-cons";
	public static String HDR_BUSINESS_LINK = "wu-header-partners";
	public static String HDR_PARTNER_LINK = "wu-header-bus";
	public static String HDR_ABOUT_LINK ="wu-header-about-us";
	public static String HDR_COUNTRY = "wu-header-country";
	public static String HDR_LANGUAGE = "wu-header-language";
	
	public static String SEND_MONEY = "tab-send-money-link";
	public static String RECEIVE_MONEY = "tab-receive-money-link";
	public static String PAY_BILLS = "tab-pay-bills-link";
	public static String PREPAID_CARD = "tab-prepaid-card-link";
	
	public static String ASK_QUERRY = "overlayQuery";
	public static String ASK_BTN = "submitlink";
	
	
	public HeaderLinksPage(WebDriver driver){
		HeaderLinksPage.driver = driver;
	}
	
	/**Header Link verification **/
	public static void headerLinkVerification() throws Exception 
	{
		CommonUtils.isElementPresent(ElementType.CLASS,HDR_COUNTRY,"Verified country");
		CommonUtils.isElementPresent(ElementType.CLASS,HDR_LANGUAGE,"Language");
		
		CommonUtils.isElementPresent(ElementType.CLASS,HDR_CONSUMER_LINK,"counsumer link");
		CommonUtils.isElementPresent(ElementType.CLASS,HDR_BUSINESS_LINK,"business link");
		CommonUtils.isElementPresent(ElementType.CLASS,HDR_PARTNER_LINK, "Partner Link");
		CommonUtils.isElementPresent(ElementType.CLASS,HDR_ABOUT_LINK,"About us Link");
										
	}	
	
	/** Center Link verification **/
		public static void mainLinkVerification() throws Exception 
	{
		 CommonUtils.isElementPresent(ElementType.CLASS, SITE_LOGO, "Site Logo");
		 CommonUtils.isElementPresent(ElementType.CLASS, USER_REG, "User Registration");
		 CommonUtils.isElementPresent(ElementType.CLASS, USER_LOGIN, "User Login");
		 CommonUtils.isElementPresent(ElementType.ID, ASK_QUERRY , "Ask querry box");
		 CommonUtils.isElementPresent(ElementType.ID, ASK_BTN , " Ask button");
		 
		 
	}
		public static void centerLinkVerification() throws Exception 
		{
			 CommonUtils.isElementPresent(ElementType.ID, SEND_MONEY, "Send money link");
			 CommonUtils.isElementPresent(ElementType.ID, RECEIVE_MONEY, "Receive money link");
			 CommonUtils.isElementPresent(ElementType.ID, PAY_BILLS, "Pay bills link");
			 CommonUtils.isElementPresent(ElementType.ID, PREPAID_CARD, "Prepaid card link");
		}
	
	
}
