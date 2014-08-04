package com.photon.phresco.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.photon.phresco.selenium.util.CommonUtils;
import com.photon.phresco.selenium.util.CommonUtils.ElementType;

public class RewardsPage {
	public static WebDriver driver;
	
	public static String LOGIN_GTEXT = "wu-username-textbox";
	public static String LOGIN_GPWD_TEXT = "wu-password-textbox";
	public static String LOGIN_GCONTINUE_BTN = "btn-do-login";
	
	public static String REWARDS_TAB = "rewards-tab"; //ID
	public static String GOLD_CARD_NUMBER = "wu-input-gold-card"; //ID
	public static String CONTINUE = "wu-gold-card-save"; //ID
	public static String REWARDS = "rewards-tab-accordion"; //ID
	public static String REDEEM_REWARDS = "Redeem-Rewards-tab"; //ID
	public static String REWARDS_HISTORY = "Reward-History-tab"; //ID
	public static String HOW_POINTS_WORK = "How-Points-Work-tab"; // ID
	public static String SORT_BY = ".//*[@id='wu-dropdown-selectbox']"; //ID
	public static String SORT = "wu-rewards-history-block"; //class 
	public static String CONFIRM_REWARD_POPUP = "payoutinfo-overlay-header";//class
	public static String REWARD_DETAIL_CONF = "wu-pop-middle";//class
	public static String CONTINUE_MERGE_BTN = "confirmMerging";//ID
	public static String CLOSE_MEARGE_POPUP = "payoutinfo-overlay-closeButton";//ID
	public static String REDEEM_BTN = "//div[@class='wu-rewards-block-layer']/div[3]//div[@data-desc='Gift Card']"; //XPATH
	
	public static String PROGRESS_BAR = "spinner-container";//CLASS
	public static String CONFIRM_REDEEMPTION_TITLE = "payoutinfo-overlay-header";//CLASS
//	public static String CONTINUE_REDEEM = "phoneRedeem-continue";//ID
	public static String CONTINUE_REDEEM = "payoutinfo-overlay-footer-button";//CLASS
	public static String SUCCESS_REDEEM_MSG = "wu-alert-message";//ID
	
	
	
	
	
		
	public RewardsPage(WebDriver driver)
	{
		RewardsPage.driver = driver;
	}

	public static void rewardsNavigation() throws Exception
	{
		CommonUtils.conditionalDelay(ElementType.ID, REWARDS_TAB);
		CommonUtils.isElementPresent(ElementType.ID, REWARDS_TAB, "Rewards Tab");
		CommonUtils.clickElement(ElementType.ID, REWARDS_TAB, "Rewards Tab clicked");
	}
	
	public static void rewardsAddCard() throws Exception
	{   
		//CommonUtils.wait_for_progressbar(PROGRESS_BAR);
		CommonUtils.conditionalDelay(ElementType.ID, GOLD_CARD_NUMBER);
	    CommonUtils.isElementPresent(ElementType.ID, GOLD_CARD_NUMBER, "Gold card number field");
		
		//CommonUtils.conditionalDelay(ElementType.ID, GOLD_CARD_NUMBER);
		CommonUtils.enterData(ElementType.ID, GOLD_CARD_NUMBER, CommonUtils.properties.getProperty("GoldcardNum"));
		CommonUtils.getFocus(ElementType.ID, GOLD_CARD_NUMBER);
		CommonUtils.isElementPresent(ElementType.ID, CONTINUE, "Continue button");
		CommonUtils.clickElement(ElementType.ID, CONTINUE, "Continue button clicked");
		CommonUtils.conditionalDelay(ElementType.CLASS, CONFIRM_REWARD_POPUP);
		CommonUtils.isElementPresent(ElementType.CLASS, CONFIRM_REWARD_POPUP, "confirmation pop up");
		CommonUtils.isElementPresent(ElementType.ID, CONTINUE_MERGE_BTN, "Merge button");
		CommonUtils.clickElement(ElementType.ID, CLOSE_MEARGE_POPUP, "close mearge button clicked");
			
	}
	
	
	public static void redeemRewards() throws Exception
	{
		CommonUtils.conditionalDelay(ElementType.ID, REDEEM_REWARDS);
		CommonUtils.isElementPresent(ElementType.ID, REDEEM_REWARDS, "Redeem Rewards");
		CommonUtils.clickElement(ElementType.ID, REDEEM_REWARDS, "Redeem Rewards");
		CommonUtils.conditionalDelay(ElementType.XPATH, REDEEM_BTN);
		CommonUtils.isElementPresent(ElementType.XPATH, REDEEM_BTN, "Redeem button");
		CommonUtils.clickElement(ElementType.XPATH, REDEEM_BTN, "Redeem button");
//		CommonUtils.conditionalDelay(ElementType.CLASS, CONFIRM_REDEEMPTION_TITLE);
		CommonUtils.isElementPresent(ElementType.CLASS, CONFIRM_REDEEMPTION_TITLE, "confirm redeemption title");
//		CommonUtils.isElementPresent(ElementType.ID, CONTINUE_REDEEM, "confirm redeemption button");
		CommonUtils.clickElement(ElementType.CLASS, CONTINUE_REDEEM, "confirm redeemption button");
		CommonUtils.conditionalDelay(ElementType.ID, SUCCESS_REDEEM_MSG);
		CommonUtils.isElementPresent(ElementType.ID, SUCCESS_REDEEM_MSG, "redeem success message");
		
		
	}
	
	
	public static void rewardsHistory() throws Exception
	{
		
		CommonUtils.isElementPresent(ElementType.ID, REWARDS_HISTORY, "Rewards History");
		CommonUtils.clickElement(ElementType.ID, REWARDS_HISTORY, "Rewards History clicked");
		CommonUtils.conditionalDelay(ElementType.ID, SORT);
		CommonUtils.isElementPresent(ElementType.ID, SORT, "Sort by");
		
		Select select = new Select(CommonUtils.driver.findElement(By.xpath(SORT_BY)));
		String sortOrder = select.getFirstSelectedOption().getText();
		System.out.println("Rewards History default order "+sortOrder);
		CommonUtils.l.info("Rewards History default order "+sortOrder);
				
		CommonUtils.selectDropDown(ElementType.XPATH, SORT_BY, CommonUtils.properties.getProperty("Oldest_first"));
		sortOrder = select.getFirstSelectedOption().getText();
		System.out.println("Rewards History order "+sortOrder);
		CommonUtils.l.info("Rewards History order "+sortOrder);
	}
	
	public static void loginRewardUserData()throws Exception{
		CommonUtils.enterData(ElementType.ID,LOGIN_GTEXT, CommonUtils.properties.getProperty("Reward_user_name"));
		CommonUtils.enterData(ElementType.ID,LOGIN_GPWD_TEXT, CommonUtils.properties.getProperty("Reward_user_password"));
	}
	public static void loginRewardUserNavigation()throws Exception{
		CommonUtils.clickElement(ElementType.ID, LOGIN_GCONTINUE_BTN, "Login & continue Button");
	}
	
	public static void howPointsWork() throws Exception
	{
		
		CommonUtils.isElementPresent(ElementType.ID, HOW_POINTS_WORK, "How Points Work");
		CommonUtils.clickElement(ElementType.ID, HOW_POINTS_WORK, "How Points Work");
	}
	
	public static void rewardsLoginTest() throws Exception
	{
		LoginPage.loginMainVerification();
		LoginPage.loginMainNavigation();
		loginRewardUserData();
		loginRewardUserNavigation();
		rewardsNavigation();
		rewardsAddCard();
		redeemRewards();
		rewardsHistory();
		howPointsWork();
	}
}
