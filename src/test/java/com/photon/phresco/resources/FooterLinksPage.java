package com.photon.phresco.resources;
import org.openqa.selenium.WebDriver;

import com.photon.phresco.selenium.util.CommonUtils;
import com.photon.phresco.selenium.util.CommonUtils.ElementType;



public class FooterLinksPage {
	public static WebDriver driver;

	public static String FOOTER_MENU = "wu-footer-menu-title";
	public static String FOOTER_LIST = "wu-footer-menu-list";
	public static String SEND_MONEY_CONTENT="wu-footer-sendmoney-content";
	public static String EMAIL_LETTER = "email-submit";
	
	public FooterLinksPage(WebDriver driver){
		FooterLinksPage.driver = driver;
	}
	
	/**Footer Link verification **/
	public static void footerLinkVerification() throws Exception 
	{
		CommonUtils.isElementPresent(ElementType.CLASS,FOOTER_MENU,"footer menu title");
		CommonUtils.isElementPresent(ElementType.CLASS,FOOTER_LIST,"footer menu list");
		CommonUtils.isElementPresent(ElementType.CLASS,SEND_MONEY_CONTENT,"footer content menu");
		CommonUtils.isElementPresent(ElementType.CLASS,EMAIL_LETTER,"email alerts signup");
								
	}	
	
	
}
