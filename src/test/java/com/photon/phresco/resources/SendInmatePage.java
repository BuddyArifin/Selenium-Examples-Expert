package com.photon.phresco.resources;
import org.openqa.selenium.WebDriver;

import com.photon.phresco.selenium.util.CommonUtils;
import com.photon.phresco.selenium.util.CommonUtils.ElementType;



public class SendInmatePage {
	public static WebDriver driver;

	public static String SEND_INMATE_LINK = "Sending money to an inmate?";
	public static String INMATE_CONT = "inmate";
	public static String FACILITY_NAME ="wu-smi-facility-name";
	public static String DROP_FACILITY = "wu-dropdown-arrow";
	public static String FACILTIY_TITLE = "wu-inmate-title-dropdown";
	public static String AMOUNT_INMATE = "wu-sm-inmate-amount";
	public static String SEND_AMOUNT_BTN = "wu-started-sm-inmate-btn";
	
	public static String SEND_INMATE_CONT = "send-money-inmate-container";
	public static String SEND_INMATE = "wu-po-send-online";
	public static String REGISTER_NOW = "register-now";
	
	public SendInmatePage(WebDriver driver){
		SendInmatePage.driver = driver;
	}
	
	public static void sendInmateVerification() throws Exception{
		
		CommonUtils.isElementPresent(ElementType.PLINK,SEND_INMATE_LINK , "Send Money to inmate");
	}

	public static void sendInmateNavigation() throws Exception{
		
		CommonUtils.clickElement(ElementType.PLINK, SEND_INMATE_LINK , "Send Money to inmate");
	}
	public static void sendMoneyInmateVerification() throws Exception
	{
		CommonUtils.conditionalDelay(ElementType.ID, INMATE_CONT);
		CommonUtils.conditionalDelay(ElementType.ID, AMOUNT_INMATE);
		CommonUtils.isElementPresent(ElementType.ID, FACILTIY_TITLE, "facility name");
		CommonUtils.isElementPresent(ElementType.ID, AMOUNT_INMATE, "Amount");
		CommonUtils.isElementPresent(ElementType.ID,SEND_AMOUNT_BTN,"Get started to Pay button");
	}
	public static void sendInmateFacilitySelect()throws Exception{
		CommonUtils.clickElement(ElementType.CLASS, DROP_FACILITY, "Facilty Selector");
		CommonUtils.selectDropDown(ElementType.ID, FACILITY_NAME, "FEDERAL BUREAU OF PRISON");
	}
	public static void sendMoneyInmateData() throws Exception{
		CommonUtils.enterData(ElementType.ID,AMOUNT_INMATE,CommonUtils.properties.getProperty("send_inmate_amount"));
	}
	public static void paymentInmateNavigation()throws Exception{
		
		CommonUtils.clickElement(ElementType.ID,SEND_AMOUNT_BTN,"Get started to Pay button");
	}
	public static void paymentInmateVerification()throws Exception{
		CommonUtils.conditionalDelay(ElementType.ID,SEND_INMATE);
		CommonUtils.isElementPresent(ElementType.ID, SEND_INMATE, "Send Money inmate online");
	}
	public static void paymentInmateSelection()throws Exception{
		CommonUtils.clickElement(ElementType.ID, SEND_INMATE, "Send Money inmate online");
	}
	
	public static void sendInmateTest()throws Exception{
		SendMoneyPage.sendMoneyLinkVerification();
		sendInmateVerification();
		sendInmateNavigation();
		sendMoneyInmateVerification();
		sendInmateFacilitySelect();
		sendMoneyInmateData();
		paymentInmateNavigation();
		paymentInmateVerification();
		paymentInmateSelection();
		PayBillsPage.payBillRegistration();
		PayBillsPage.payBillRegistrationNavigation();
	}
	
	
}