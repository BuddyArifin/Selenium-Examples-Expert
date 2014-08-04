package com.photon.phresco.resources;

import org.openqa.selenium.WebDriver;
import com.photon.phresco.selenium.util.CommonUtils;
import com.photon.phresco.selenium.util.CommonUtils.ElementType;



public class SendMoneyPage {
	public static WebDriver driver;

	public static String SEND_MONEY_LINK = "tab-send-money-link";
	public static String SEND_MONEY_BTN = "go-to-sendmoney";
	public static String SENDING_MONEY_OPTION= "wu-sendmoney-options";
	public static String COUNTRY_LIST = "wu-dropdown-mask-container";						//"wu-country-list";
	public static String AMOUNT_TO ="input-amount-fea";
	public static String ZIP_CODE = "input-zip-fea";
	public static String RECEIVER_MONEY = "receiver_000"; //	"//*wu-receiver-money-option-label-container"							//
	public static String PAY_BY ="pay CreditCard";
	public static String PROCEED_PAY_BTN ="wu-button-continue wu-blue-button";
	public static String REGISTER_NOW_BTN = "register-now";
	
	public SendMoneyPage(WebDriver driver){
		SendMoneyPage.driver = driver;
	}
	
	/**send money Link verification **/
	
		public static void sendMoneyLinkVerification() throws Exception 
		{
			 CommonUtils.isElementPresent(ElementType.ID, SEND_MONEY_LINK, "Send money main link");
			 CommonUtils.mouseHover(ElementType.ID, SEND_MONEY_LINK, "Send money main link");
			 CommonUtils.isElementPresent(ElementType.ID, SEND_MONEY_BTN, "Send money main ");
			 					 	
		}
		/**send money Link navigation **/
		public static void sendMoneyNavigation() throws Exception
		{
			CommonUtils.clickElement(ElementType.ID, SEND_MONEY_LINK, "Send money main link");
			
		}
		
		/**send money main Link verification **/
		public static void sendMoneyMainVerification() throws Exception
		{   
			CommonUtils.waitForElement(ElementType.CLASS, SENDING_MONEY_OPTION);
			CommonUtils.isElementPresent(ElementType.CLASS, SENDING_MONEY_OPTION, "Sending money option");
//			CommonUtils.mouseHover(ElementType.ID,COUNTRY_LIST,"List of countries");
			CommonUtils.waitForElement(ElementType.CLASS, COUNTRY_LIST);
			CommonUtils.isElementPresent(ElementType.CLASS,COUNTRY_LIST,"List of countries");
			CommonUtils.isElementPresent(ElementType.ID, AMOUNT_TO, "Amount");
			CommonUtils.isElementPresent(ElementType.ID,ZIP_CODE,"Zipcode");
		}
		public static void enterAmountZip() throws Exception{
			
			CommonUtils.enterData(ElementType.ID,AMOUNT_TO, CommonUtils.properties.getProperty("send_amount_value"));
			CommonUtils.enterData(ElementType.ID,ZIP_CODE, CommonUtils.properties.getProperty("send_zipcode_value"));
			Thread.sleep(15000);
		}
			
		public static void receiverTypeVerification() throws Exception{	
			CommonUtils.waitForElement(ElementType.ID, RECEIVER_MONEY);
			CommonUtils.isElementPresent(ElementType.ID,RECEIVER_MONEY,"cash at agent location");
		}
		public static void receiverTypeSelection() throws Exception{	
			
			CommonUtils.clickElement(ElementType.ID,RECEIVER_MONEY,"cash at agent location");
		}
		public static void payByVerification() throws Exception{
			
			CommonUtils.isElementPresent(ElementType.CLASS, PAY_BY, "pay by credit/debit card ");
		}
		public static void payBySelection() throws Exception{
			
			CommonUtils.clickElement(ElementType.CLASS, PAY_BY, "pay by credit/debit card ");
		}
		public static void payButtonVerification() throws Exception{
			CommonUtils.isElementPresent(ElementType.ID, PROCEED_PAY_BTN, "continue payment button");
			Thread.sleep(5000);
			}
		public static void payButtonSelection() throws Exception{	
			CommonUtils.isElementPresent(ElementType.ID, REGISTER_NOW_BTN, "Register now button");
			CommonUtils.clickElement(ElementType.ID, REGISTER_NOW_BTN, "Register now button");
			
		}
		public static void sendMoneyTest()throws Exception{
			sendMoneyLinkVerification();
			sendMoneyNavigation();
			sendMoneyMainVerification();
			enterAmountZip();
			receiverTypeVerification();
			receiverTypeSelection();
			payByVerification();
			payBySelection();
			payButtonVerification();
			payButtonSelection();
			CommonUtils.waitForElement(ElementType.ID, RegisterPage.REGISTER_EMAIL_TEXTFIELD);
			RegisterPage.registerScreenVerification();
			RegisterPage.enterEmailId();
			RegisterPage.enterPassword();
			RegisterPage.enterPhoneno();
			RegisterPage.enterName();
			RegisterPage.enterAddress();
			RegisterPage.enterCity();
			RegisterPage.selectState();
			RegisterPage.enterZipCode();
			RegisterPage.selectMonth();
			RegisterPage.selectDate();
			RegisterPage.selectYear();
			RegisterPage.selectQuestion1();
			RegisterPage.enterAnswer1();
			RegisterPage.selectQuestion2();
			RegisterPage.enterAnswer2();
			RegisterPage.selectQuestion3();
			RegisterPage.enterAnswer3();
			RegisterPage.enterCaptchValue();
			RegisterPage.selectChechBox();
			RegisterPage.clickContinueButton();
		}
	
}
