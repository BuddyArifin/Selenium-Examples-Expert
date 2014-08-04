package com.photon.phresco.resources;

import org.openqa.selenium.WebDriver;

import com.photon.phresco.selenium.util.CommonUtils;
import com.photon.phresco.selenium.util.CommonUtils.ElementType;

public class ChallengerRegisterPage {
	public static WebDriver driver;
	    public static String HOMEPAGE_REGISTER_BUTTON = "wu-header-register";
		public static String REGISTER_EMAIL_TEXTFIELD = "wu_register_email";
		public static String REGISTER_PWD_TEXTFIELD = "wu_register_password";
		public static String REGISTER_REENTER_PWD_TEXTFIELD = "wu_register_password_repeat";
		public static String REGISTER_FIRSTNAME_TEXTFIELD = "wu_register_first_name";
		public static String REGISTER_LASTNAME_TEXTFIELD = "wu_register_last_name";
		public static String REGISTER_ADDRESS_LINE1_TEXTFIELD = "wu_register_addr_line1";
		public static String REGISTER_CITY_TEXTFIELD = "wu_register_city";
		public static String REGISTER_ZIPCODE_TEXTFIELD = "wu_register_postal_code";
		public static String REGISTER_PHONE_TEXTFIELD = "wu_register_phone";
		public static String REGISTER_Q1_DROPDOWN_FIELD = "wu_register_question1";
		public static String REGISTER_Q2_DROPDOWN_FIELD = "wu_register_question2";
		public static String REGISTER_Q3_DROPDOWN_FIELD = "wu_register_question3";
		public static String REGISTER_DATE_DROPDOWN_FIELD = "wu_register_birth_day";
		public static String REGISTER_MONTH_DROPDOWN_FIELD = "wu_register_birth_month";
		public static String REGISTER_YEAR_DROPDOWN_FIELD = "wu-register-birth-year_txt";
		public static String REGISTER_Q1_A1_TEXTFIELD = "wu_register_answer1";
		public static String REGISTER_Q1_A2_TEXTFIELD = "wu_register_answer2";
		public static String REGISTER_Q1_A3_TEXTFIELD = "wu_register_answer3";
		public static String DROPDOWN_STATE = "wu_register_state";
		public static String DROPDOWN_VAL = "//*[@id='wu_register_state']/option[37]";
		public static String REGISTER_Q1_DROPDOWN_VALUE = "//*[@id='wu_register_question1']/option[3]";
		public static String REGISTER_Q2_DROPDOWN_VALUE = "//*[@id='wu_register_question2']/option[4]";
		public static String REGISTER_Q3_DROPDOWN_VALUE = "//*[@id='wu_register_question3']/option[5]";
		public static String REGISTER_DAY_VALUE = "//*[@id='wu_register_birth_day']/option[4]";
		public static String REGISTER_MONTH_VALUE = "//*[@id='wu_register_birth_month']/option[3]";
		public static String RST_CAPTCHA_IMAGE = "wu-captcha-image";
		public static String RST_CAPTCHA_FIELD = "wu_register_captcha_text";
		
		public static String REGISTER_ESIGN_CHECKBOX  ="wu_register_terms";
		public static String REGISTER_CONTINUE_BUTTON  ="wu_register_continue";
		public static String REGISTER_EMAIL_VERIFICATION_TITLE = "wu-alert-title";
		public static String REGISTER_PIN_VERIFICATION_TITLE ="wu-ev-pin";
		public static String REGISTER_COMPLETE_VERIFICATION_BUTTON ="complete-verification";
		public static String CHALLENGER_REGISTER_FIELD ="wu_register_loyalty_number";
		
				
	public ChallengerRegisterPage(WebDriver driver){
		ChallengerRegisterPage.driver = driver;
	}
	
	/** Navigate to challanger page **/
	public static void navigateChallenger() throws Exception{
		CommonUtils.challanger();
	}
	
	/** Navigate to challanger page **/
	public static void navigateExpress() throws Exception{
		CommonUtils.express();
	}
		
	/** Verify the elements in registration screen **/
	public static void registerScreenVerification() throws Exception{
		CommonUtils.isElementPresent(ElementType.ID, REGISTER_EMAIL_TEXTFIELD, "register email field");
		CommonUtils.isElementPresent(ElementType.ID, REGISTER_PWD_TEXTFIELD, "register password field");
		CommonUtils.isElementPresent(ElementType.ID, REGISTER_REENTER_PWD_TEXTFIELD, "re enter register password field");
		CommonUtils.isElementPresent(ElementType.ID, REGISTER_FIRSTNAME_TEXTFIELD, "register firstname field");
		CommonUtils.isElementPresent(ElementType.ID, REGISTER_LASTNAME_TEXTFIELD, "register lastname field");
		CommonUtils.isElementPresent(ElementType.ID, REGISTER_ADDRESS_LINE1_TEXTFIELD, "addressline 1 field");
		CommonUtils.isElementPresent(ElementType.ID, REGISTER_CITY_TEXTFIELD, "city field");
		CommonUtils.isElementPresent(ElementType.ID, REGISTER_ZIPCODE_TEXTFIELD, "zip code field");
		CommonUtils.isElementPresent(ElementType.ID, REGISTER_PHONE_TEXTFIELD, "primary phone text field");
		CommonUtils.isElementPresent(ElementType.ID, REGISTER_Q1_A1_TEXTFIELD, "q1 a1 text field");
		CommonUtils.isElementPresent(ElementType.ID, REGISTER_Q1_A2_TEXTFIELD, "q2 a2 text field");
		CommonUtils.isElementPresent(ElementType.ID, REGISTER_Q1_A3_TEXTFIELD, "q3 a3 text field");
		}
	
	/** Enter user name into the email field **/
	public static void enterEmailId() throws Exception{
		CommonUtils.enterData(ElementType.ID, REGISTER_EMAIL_TEXTFIELD, CommonUtils.properties.getProperty("challenger_register_email_id"));
	}
	
	/** Enter password and re password into the password and re enter password field **/
	public static void enterPassword() throws Exception{
		CommonUtils.enterData(ElementType.ID, REGISTER_PWD_TEXTFIELD, CommonUtils.properties.getProperty("register_pwd_value"));
		CommonUtils.enterData(ElementType.ID, REGISTER_REENTER_PWD_TEXTFIELD, CommonUtils.properties.getProperty("register_reenter_pwd_value"));
	}
	
	/** Enter primary phone number into phone number field **/
	public static void enterPhoneno() throws Exception{
		CommonUtils.enterData(ElementType.ID, REGISTER_PHONE_TEXTFIELD, CommonUtils.properties.getProperty("challenger_pho_no"));
	}
	
	/** Enter first name and last name into the first name and last name field **/
	public static void enterName() throws Exception{
		CommonUtils.enterData(ElementType.ID, REGISTER_FIRSTNAME_TEXTFIELD, CommonUtils.properties.getProperty("challenger_fst_name"));
	   	CommonUtils.enterData(ElementType.ID, REGISTER_LASTNAME_TEXTFIELD, CommonUtils.properties.getProperty("challenger_lst_name"));
	}
	
	/** Enter loyalty number into loyalty number field **/
	public static void enterLoyalty() throws Exception{
		CommonUtils.enterData(ElementType.ID, CHALLENGER_REGISTER_FIELD, CommonUtils.properties.getProperty("register_loyalty_no"));
	}
	
	/** Enter address into address field **/
	public static void enterAddress() throws Exception{
		CommonUtils.enterData(ElementType.ID, REGISTER_ADDRESS_LINE1_TEXTFIELD, CommonUtils.properties.getProperty("register_address_line1_value"));
	}
	
	/** Enter city into city field **/
	public static void enterCity() throws Exception{
		CommonUtils.enterData(ElementType.ID, REGISTER_CITY_TEXTFIELD, CommonUtils.properties.getProperty("register_city_value"));
	}
	
	/** select state from the drop-down **/
	public static void selectState() throws Exception{
		CommonUtils.clickElement(ElementType.ID, DROPDOWN_STATE, "state selection drop-down");
		CommonUtils.clickElement(ElementType.XPATH, DROPDOWN_VAL, "state from the drop-down");
	}
	
	/** Enter  zip code into the zip code field **/
	public static void enterZipCode() throws Exception{
		CommonUtils.enterData(ElementType.ID, REGISTER_ZIPCODE_TEXTFIELD, CommonUtils.properties.getProperty("register_zipcode_value"));
	}
	
	/** select month from the drop-down **/
	public static void selectMonth() throws Exception{
		CommonUtils.clickElement(ElementType.ID, REGISTER_MONTH_DROPDOWN_FIELD, "month drop-down");
		CommonUtils.clickElement(ElementType.XPATH, REGISTER_MONTH_VALUE, "month from drop-down");
	}
	
	/** select date from the drop-down **/
	public static void selectDate() throws Exception{
		CommonUtils.clickElement(ElementType.ID, REGISTER_DATE_DROPDOWN_FIELD, "date drop-down");
		CommonUtils.clickElement(ElementType.XPATH, REGISTER_DAY_VALUE, "date from drop-down");
	}
	
	/** select year from the drop-down **/
	public static void selectYear() throws Exception{
		CommonUtils.enterData(ElementType.ID, REGISTER_YEAR_DROPDOWN_FIELD, CommonUtils.properties.getProperty("birth_year_value"));
	}
	
	/** select question from the drop-down **/
	public static void selectQuestion1() throws Exception{
		CommonUtils.clickElement(ElementType.ID, REGISTER_Q1_DROPDOWN_FIELD, "Question1");
		CommonUtils.clickElement(ElementType.XPATH, REGISTER_Q1_DROPDOWN_VALUE, "question from drop-down");
	}
	
	/** Enter  answer into the answer field **/
	public static void enterAnswer1() throws Exception{
		CommonUtils.enterData(ElementType.ID, REGISTER_Q1_A1_TEXTFIELD, CommonUtils.properties.getProperty("register_q1_a1_value"));
	}
	
	/** select question from the drop-down **/
	public static void selectQuestion2() throws Exception{
		CommonUtils.clickElement(ElementType.ID, REGISTER_Q2_DROPDOWN_FIELD, "Question2");
		CommonUtils.clickElement(ElementType.XPATH, REGISTER_Q2_DROPDOWN_VALUE, "question from drop-down");
	}
	
	/** Enter  answer into the answer field **/
	public static void enterAnswer2() throws Exception{
		CommonUtils.enterData(ElementType.ID, REGISTER_Q1_A2_TEXTFIELD, CommonUtils.properties.getProperty("register_q2_a2_value"));
	}
	
	/** select question from the drop-down **/
	public static void selectQuestion3() throws Exception{
		CommonUtils.clickElement(ElementType.ID, REGISTER_Q3_DROPDOWN_FIELD, "Question3");
		CommonUtils.clickElement(ElementType.XPATH, REGISTER_Q3_DROPDOWN_VALUE, "question from drop-down");
	}
	
	/** Enter  answer into the answer field **/
	public static void enterAnswer3() throws Exception{
		CommonUtils.enterData(ElementType.ID, REGISTER_Q1_A3_TEXTFIELD, CommonUtils.properties.getProperty("register_q3_a3_value"));
	}
	
	/** Enter  captcha value into the captcha field **/
	public static void enterCaptchValue() throws Exception{
			CommonUtils.captchaHandler(RST_CAPTCHA_IMAGE, RST_CAPTCHA_FIELD);
	}
	
	/** Select chech box for terms & conditions **/
	public static void selectChechBox() throws Exception{
		CommonUtils.clickElement(ElementType.ID, REGISTER_ESIGN_CHECKBOX, "terms & conditions");
	}
	
	/** Click on continue registration button **/
	public static void clickContinueButton() throws Exception{
		Thread.sleep(15000);
		CommonUtils.clickElement(ElementType.ID, REGISTER_CONTINUE_BUTTON, "continue button");
		CommonUtils.waitForElement(ElementType.ID, REGISTER_EMAIL_VERIFICATION_TITLE);
	}
	/** Verify the register email verification title **/
	public static void verifiedRegisterEmailTitle() throws Exception{
		CommonUtils.isElementPresent(ElementType.ID, REGISTER_EMAIL_VERIFICATION_TITLE, "register email title");
	}
	
	public static void challengerRegisterTest()throws Exception{
		navigateChallenger();
		CommonUtils.waitForElement(ElementType.ID, REGISTER_EMAIL_TEXTFIELD);
		registerScreenVerification();
		enterEmailId();
		enterPassword();
		enterPhoneno();
		enterName();
		enterLoyalty();
		enterAddress();
		enterCity();
		selectState();
		enterZipCode();
		selectMonth();
		selectDate();
		selectYear();
		selectQuestion1();
		enterAnswer1();
		selectQuestion2();
		enterAnswer2();
		selectQuestion3();
		enterAnswer3();
		enterCaptchValue();
		selectChechBox();
		clickContinueButton();
		verifiedRegisterEmailTitle();
	}
}
	
