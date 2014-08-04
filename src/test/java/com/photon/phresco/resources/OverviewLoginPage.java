package com.photon.phresco.resources;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.photon.phresco.selenium.util.CommonUtils;
import com.photon.phresco.selenium.util.CommonUtils.ElementType;



public class OverviewLoginPage {
	public static WebDriver driver;

		
	public static String HEADER_NAME = "header-name";
	public static String OVERVIEW_TAB = "overview-tab";
	public static String RECENT_ACTIVITY = "wu-overview-clearfix-summary-header";
	public static String MONEY_SENDER = "money-send-name";
	public static String ACTIVITY_DATE = "wu-activity-date";
	public static String ACTITVTY_AMOUNT = "activity-amount";
	public static String LIST_ACTIVITY = "//*[@class='wu-listActivity']/li";
	public static String DETAIL_LIST_ACTIVITY = "//*[@class='wu-listActivity']/li[1]";
	public static String SEE_DETAIL = "see-details";
	public static String TR_DETAILS = "wu-activity-dashboard-detail";
	public OverviewLoginPage(WebDriver driver){
		OverviewLoginPage.driver = driver;
	}
	
		public static void overviewPageNavigation()throws Exception{
			
			CommonUtils.conditionalDelay(ElementType.ID, OVERVIEW_TAB);
			CommonUtils.isElementPresent(ElementType.ID, OVERVIEW_TAB, "Over view Tab");
			CommonUtils.isElementPresent(ElementType.ID, HEADER_NAME, "Login User Name");
			CommonUtils.conditionalDelay(ElementType.CLASS, RECENT_ACTIVITY);
//			CommonUtils.isElementPresent(ElementType.CLASS, RECENT_ACTIVITY ,"Recent Activity Container");
		}
		public static void overviewPageVerification()throws Exception
		{
			
			
			
//			WebElement activity = 
			List <WebElement> allActivity = CommonUtils.driver.findElements(By.xpath(LIST_ACTIVITY));
			System.out.println("#############################################");
			System.out.print("available activities are: ");
			System.out.println(allActivity.size());
					int i=1;
					for (WebElement activity :allActivity){
					String sender = activity.findElement(By.id(MONEY_SENDER)).getText();
					String actTime = activity.findElement(By.className(ACTIVITY_DATE)).getText();
					String senderamount = activity.findElement(By.className(ACTITVTY_AMOUNT)).getText();
					System.out.println("activity:"+i+" ");
					System.out.println(sender + actTime + senderamount );
					i++;
					}
					System.out.println("Transaction Screen verified");
		}				
		public static void overviewPageDetailVerification()throws Exception
		{		
			WebElement detail = CommonUtils.driver.findElement(By.xpath(DETAIL_LIST_ACTIVITY));	
			detail.findElement(By.className(SEE_DETAIL)).click();
			System.out.println("SEE_DETAIL button click is done ");
			CommonUtils.conditionalDelay(ElementType.CLASS, "tracking-id");
			String transvalue = CommonUtils.driver.findElement(By.className(TR_DETAILS)).getText();
			System.out.println("#############################################");
			System.out.println("Transaction details are:");
			System.out.println(transvalue);
			System.out.println("Transaction Detail Screen verified");
			
		}
			
		
	
		public static void overviewLoginTest()throws Exception{
			
			LoginPage.loginUserTest();
			overviewPageNavigation();
			overviewPageVerification();
			overviewPageDetailVerification();
			
		}
}
