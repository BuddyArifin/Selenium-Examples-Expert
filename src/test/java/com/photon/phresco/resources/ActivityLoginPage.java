package com.photon.phresco.resources;
import org.openqa.selenium.WebDriver;

import com.photon.phresco.selenium.util.CommonUtils;
import com.photon.phresco.selenium.util.CommonUtils.ElementType;

public class ActivityLoginPage {
	public static WebDriver driver;
	public static String ACTIVITY_TAB = "activity-tab";
	public static String ACTIVITY_CONTAINER = "summary-header-activity";
	public static String ACTIVITY_MSG = "page-header ";
	
	public ActivityLoginPage(WebDriver driver){
		ActivityLoginPage.driver = driver;
	}
	  public static void activityNavigation()throws Exception{
			CommonUtils.conditionalDelay(ElementType.ID, ACTIVITY_TAB);
			CommonUtils.clickElement(ElementType.ID, ACTIVITY_TAB, "Activity Tab");
			
		}
		public static void activityVerification()throws Exception{
			CommonUtils.conditionalDelay(ElementType.CLASS, ACTIVITY_MSG);
			CommonUtils.conditionalDelay(ElementType.CLASS, ACTIVITY_CONTAINER);

		}
		public static void activityLoginTest()throws Exception{
			LoginPage.loginUserTest();
			activityNavigation();
			activityVerification();
			OverviewLoginPage.overviewPageVerification();
			OverviewLoginPage.overviewPageDetailVerification();
		}
}
