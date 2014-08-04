package com.photon.phresco.resources;

import org.openqa.selenium.WebDriver;
import com.photon.phresco.selenium.util.CommonUtils;
import com.photon.phresco.selenium.util.CommonUtils.ElementType;



public class PayBillsPage {
	public static WebDriver driver;

	public static String PAY_BILLS_LINK = "tab-pay-bills-link";
	public static String PAY_BILLS_BTN = "go-to-paybills";
	public static String PAY_BILLS_CONTAINER= "wu-paybills-box-container";
	
	public static String BILLER_NAME = "wu-ep-paybills-biller";
	public static String AMOUNT_TO ="wu-ep-paybills-amount";
	public static String GET_PAY_BTN = "wu-ep-paybills-update";
	
	public static String SEND_OPTION = "wu-ep-po-container";
	public static String SEND_MONEY = "wu-po-send-online";
	public static String REGISTER_NOW = "register-now";
	
	public PayBillsPage(WebDriver driver){
		PayBillsPage.driver = driver;
	}
	
	public static void payBillLinkVerification() throws Exception{
		CommonUtils.conditionalDelay(ElementType.ID, PAY_BILLS_LINK);
		CommonUtils.isElementPresent(ElementType.ID, PAY_BILLS_LINK, "Pay bills link");
		CommonUtils.conditionalDelay(ElementType.ID, PAY_BILLS_LINK);
		CommonUtils.mouseHover(ElementType.ID, PAY_BILLS_LINK, "Pay bills link");
		CommonUtils.conditionalDelay(ElementType.ID, PAY_BILLS_BTN);
		CommonUtils.mouseHover(ElementType.ID, PAY_BILLS_BTN, "get started button");
		CommonUtils.isElementPresent(ElementType.ID, PAY_BILLS_BTN, "get started button");
	}
	public static void payBillNavigation() throws Exception{
		
		CommonUtils.clickElement(ElementType.ID, PAY_BILLS_BTN, "get started button");
	}
	public static void payBillMainVerification() throws Exception
	{
		CommonUtils.isElementPresent(ElementType.ID, BILLER_NAME, "Biller name");
		CommonUtils.isElementPresent(ElementType.ID, AMOUNT_TO, "Amount");
		CommonUtils.isElementPresent(ElementType.ID,GET_PAY_BTN,"Get started to Pay button");
	}
	public static void payBillMainDataEntry() throws Exception{
		CommonUtils.enterData(ElementType.ID, BILLER_NAME, CommonUtils.properties.getProperty("send_biller_value"));
		CommonUtils.enterData(ElementType.ID,AMOUNT_TO,CommonUtils.properties.getProperty("send_biller_amount"));
	}
	public static void paymentBillNavigation()throws Exception{
		
		CommonUtils.clickElement(ElementType.ID,GET_PAY_BTN,"Get started to Pay button");
	}
	public static void paymentBillVerification()throws Exception{
		CommonUtils.conditionalDelay(ElementType.CLASS,SEND_OPTION);
		CommonUtils.isElementPresent(ElementType.CLASS,SEND_OPTION,"Send online container");
		CommonUtils.isElementPresent(ElementType.ID, SEND_MONEY, "Send Money online");
	}
	public static void paymentBillSelection()throws Exception{
		CommonUtils.clickElement(ElementType.ID, SEND_MONEY, "Send Money online");
	}
	public static void payBillRegistration()throws Exception{
		CommonUtils.isElementPresent(ElementType.ID, REGISTER_NOW, "register now Link");
	}
	public static void payBillRegistrationNavigation()throws Exception{
		CommonUtils.clickElement(ElementType.ID, REGISTER_NOW, "register now Link");
	
	}
	public static void payBillTest()throws Exception{
		payBillLinkVerification();
		payBillNavigation();
		payBillMainVerification();
		payBillMainDataEntry();
		paymentBillNavigation();
		paymentBillVerification();
		paymentBillSelection();
		payBillRegistration();
		payBillRegistrationNavigation();
	}
	
	
}