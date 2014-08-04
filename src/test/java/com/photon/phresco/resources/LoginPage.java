package com.photon.phresco.resources;
import org.openqa.selenium.WebDriver;

import com.photon.phresco.selenium.util.CommonUtils;
import com.photon.phresco.selenium.util.CommonUtils.ElementType;


public class LoginPage {
	public static WebDriver driver;

	public static String LOGIN_BTN = "wu-header-login";
	public static String LOGIN_TEXT = "wu-username-textbox";
	public static String LOGIN_PWD_TEXT = "wu-password-textbox";
	public static String LOGIN_CONTINUE_BTN = "btn-do-login";
		
	public LoginPage(WebDriver driver){
		LoginPage.driver = driver;
	}
	
	/**send money Link verification **/
		public static void loginMainVerification()throws Exception{
			CommonUtils.conditionalDelay(ElementType.CLASS, LOGIN_BTN);
			CommonUtils.isElementPresent(ElementType.CLASS, LOGIN_BTN, "Login button");
			
		}
		public static void loginMainNavigation()throws Exception{
		
			CommonUtils.clickElement(ElementType.CLASS, LOGIN_BTN, "Login button");
		}
		public static void loginUserVerification()throws Exception{
			
			CommonUtils.conditionalDelay(ElementType.CLASS, LOGIN_CONTINUE_BTN);
			CommonUtils.isElementPresent(ElementType.ID, LOGIN_TEXT, "Login User name");
			CommonUtils.isElementPresent(ElementType.ID, LOGIN_PWD_TEXT, "Login Password ");
			CommonUtils.isElementPresent(ElementType.ID, LOGIN_CONTINUE_BTN, "Login continue name");
		}
		public static void loginUserData()throws Exception{
			CommonUtils.enterData(ElementType.ID,LOGIN_TEXT, CommonUtils.properties.getProperty("user_name"));
			CommonUtils.enterData(ElementType.ID,LOGIN_PWD_TEXT, CommonUtils.properties.getProperty("user_password"));
		}
		public static void loginUserNavigation()throws Exception{
			CommonUtils.clickElement(ElementType.ID, LOGIN_CONTINUE_BTN, "Login & continue Button");
		}
		public static void loginUserTest()throws Exception{
		loginMainVerification();
		loginMainNavigation();
		loginUserVerification();
		loginUserData();
		loginUserNavigation();
		}
}
