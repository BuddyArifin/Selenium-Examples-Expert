package com.photon.phresco.selenium.util;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.photon.phresco.Screens.WelcomeScreen;
import com.photon.phresco.uiconstants.PhrescoUiConstants;

public class CommonUtils {
	private static PhrescoUiConstants phrescoUIConstants;
	private static WelcomeScreen welcomeScreen;
	private static String selectedBrowser;
	public static boolean status = true;
	public static boolean elemVal, conVal, enbl, chkd, checkElemVal = false; 
	public static String appURL=null;
	public static WebDriver driver=null;
	public static WebElement element ;
	public static File source;
	public static String snapshotPath, myErrorLog;
	public static String testCaseName = null;
	public static String findElem = null;
	public static ElementType [] finder = { ElementType.ID, ElementType.CLASS, ElementType.LINK, ElementType.NAME };
	public static Logger l = Logger.getLogger(CommonUtils.class.getName());
	public static ArrayList<String> listelm = new ArrayList<String>();
	public static  Properties properties = new Properties();
	public static InputStream inputStream;
		
	/** Launching the Browser Window **/
	public static void launchingBrowser() throws Exception {
		try {
			
			phrescoUIConstants = new PhrescoUiConstants();
			String applicationURL = phrescoUIConstants.PROTOCOL + "://"+ phrescoUIConstants.HOST + ":" + phrescoUIConstants.PORT;
			selectedBrowser = phrescoUIConstants.BROWSER;
			welcomeScreen = new WelcomeScreen(selectedBrowser, applicationURL, phrescoUIConstants.CONTEXT, phrescoUIConstants);	
			System.out.println("The driver is "+welcomeScreen.driver);
			l.info("The driver is "+welcomeScreen.driver);
			driver = welcomeScreen.driver;
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			//status = true;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		inputStream = new FileInputStream("../mywu 0.7/src/main/java/com/photon/phresco/selenium/util/mywu.properties");
		properties.load(inputStream);
	}
	
	/** To take error screenshot **/
	public static void captureScreen(String element) throws Exception {
		deleteScreenshotFiles();
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile,
				new File(GetCurrentDir.getCurrentDirectory() + "\\"
						+ System.currentTimeMillis() + ".png"));
//		Assert.assertNull(scrFile);
	}
	
	/** Element Type **/
	public enum ElementType{
		XPATH, ID, CLASS, NAME, CSS, LINK, PLINK
	}
		
	/** To Select the type of the Element **/
	private static WebElement GetWebElement(ElementType type, String elementValue)
			throws Exception {
		element = null;
		switch (type) {
		case XPATH:
			if (driver.findElements(By.xpath(elementValue)).size()>0){
			element = driver.findElement(By.xpath(elementValue));
			}else{
				element = null;
			}
			break;
		case ID:
			if (driver.findElements(By.id(elementValue)).size()>0){
				element = driver.findElement(By.id(elementValue));
				}else{
					element = null;
				}
			break;
		case CLASS:
			if((!elementValue.trim().contains(" ")) && isInteger(elementValue)){
			if (driver.findElements(By.className(elementValue)).size()>0){
				element = driver.findElement(By.className(elementValue));
				}else{
					element = null;
				}
			}else{
				element = null;
			}
			break;
		case NAME:
			if (driver.findElements(By.name(elementValue)).size()>0){
				element = driver.findElement(By.name(elementValue));
				}else{
					element = null;
				}
			break;
		case CSS:
			if (driver.findElements(By.cssSelector(elementValue)).size()>0){
				element = driver.findElement(By.cssSelector(elementValue));
				}else{
					element = null;
				}
			break;
		case LINK:
			if (driver.findElements(By.linkText(elementValue)).size()>0){
				element = driver.findElement(By.linkText(elementValue));
				}else{
					element = null;
				}
			break;
		case PLINK:
			if (driver.findElements(By.partialLinkText(elementValue)).size()>0){
				element = driver.findElement(By.partialLinkText(elementValue));
				}else{
					element = null;
				}
			break;
		default:
		}
		return element;
	}
		
	/** Enter captcha image text **/
	public static void captchaHandler(String elementid, String textfld) throws Exception{
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		  js.executeScript("document.getElementById('"+elementid+"').setAttribute('value', '-897204064')");  
		  driver.findElement(By.id(textfld)).sendKeys(properties.getProperty("captcha_value"));  
	}
	
//	/** Element Verification for multiple values**/
//	public static void unconditionalElementPresent(ElementType type, String [] element)throws Exception {
//		elemVal = false;
//		try {
//			WebElement elem = GetWebElement(type, element);
//			if (elem != null ){
//				elemVal = elem.isDisplayed();
//			}else {
//				elemVal = false;
//			}
//			if (elemVal == true) {
//				System.out.println("Verifying " + findElem + " is PASSED");
//				l.info("Verifying " + findElem + " is PASSED");
//			} else {
//				System.out.println("Verifying " + listelm + " is FAILED");
//				l.info("Verifying " + listelm + " is FAILED");
//				captureScreen(listelm.toString());
//				status = false;
//			}
//		} catch (Exception e) {
//			System.out.println("Verifying " + listelm + " is FAILED");
//			l.info("Verifying " + listelm + " is FAILED");
//			captureScreen(listelm.toString());
//			myErrorLog = e.getMessage();
//			status = false;
//		}
//	}
	
	/** Element Verification **/
	public static void uncondSingleElementPresent(ElementType type, String element)throws Exception {
		elemVal = false;
		try {
			WebElement elem = GetWebElement(type, element);
			if (elem != null ){
				elemVal = elem.isDisplayed();
			}else {
				elemVal = false;
			}
			
			if (elemVal == true) {
				System.out.println("Verifying " + element + " is PASSED");
				l.info("Verifying " + element + " is PASSED");
			} else {
				System.out.println("Verifying " + element + " is FAILED");
				l.info("Verifying " + element + " is FAILED");
				captureScreen(element);
				status = false;
			}
		} catch (Exception e) {
			System.out.println("Verifying " + element + " is FAILED");
			l.info("Verifying " + element + " is FAILED");
			captureScreen(element);
			myErrorLog = e.getMessage();
			status = false;
		}
	}
	
	/**Initial Element Verification **/
	public static void checkElementPresent(ElementType type, String element)throws Exception {
		checkElemVal = false;
		String Identifier = null;
		try {
			WebElement elem = GetWebElement(type, element);
			if (elem != null ){
				checkElemVal = elem.isDisplayed();
				Identifier = type.toString().toLowerCase();
			}else {
				checkElemVal = false;
				Identifier = "id, class, link or name";
			}
			
			if (checkElemVal == true) {
				System.out.println( element +" is available in the application");
				l.info(element +" is available in the application");
			} else {
				System.out.println(listelm +" "+ element +" is not available in the application");
				l.info(element +" is not available in the application");
				captureScreen(listelm.toString());
			}
		} catch (Exception e) {
			System.out.println(element +" "+ Identifier +" is not available in the application");
			l.info(element +" "+ Identifier +" is not available in the application");
			captureScreen(element.toString());
			myErrorLog = e.getMessage();
		}
	}
	
	/** Element Verification **/
	public static void isElementPresent(ElementType type, String element,String forlog)throws Exception {
		elemVal = false;
		try {
			WebElement elem = GetWebElement(type, element);
			if (elem != null ){
				elemVal = elem.isDisplayed();
			}else {
				elemVal = false;
			}
			
			if (elemVal == true) {
				System.out.println("Verifying " + forlog + " is PASSED");
				l.info("Verifying " + forlog + " is PASSED");
			} else {
				System.out.println("Verifying " + forlog + " is FAILED");
				l.info("Verifying " + forlog + " is FAILED");
				captureScreen(element);
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Verifying " + forlog + " is FAILED");
			l.info("Verifying " + forlog + " is FAILED");
			captureScreen(element);
			myErrorLog = e.getMessage();
			status = false;
		}
	}
	
	/** Verifying element is enabled or not **/
	public static boolean checkIsEnabled(ElementType type, String element, String forLog)throws Exception {
		enbl = false;
		try {
			WebElement elem = GetWebElement(type,element);
			if (elem != null ){
				enbl = elem.isEnabled();
			}else {
				enbl = false;
			}
			if (enbl == true) {
				System.out.println("Verifying " + forLog + " is ENABLED");
				l.info("Verifying " + forLog + " is ENABLED");
			} else {
				System.out.println("Verifying " + forLog + " is DISABLED");
				l.info("Verifying " + forLog + " is DISABLED");
				captureScreen(element);
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Verifying " + forLog + " is DISABLED");
			l.info("Verifying " + forLog + " is DISABLED");
			captureScreen(element);
			myErrorLog = e.getMessage();
			status = false;
		}
		return enbl;
	}

	/** Verifying element is selected or not **/
	public static boolean checkIsSelected(ElementType type, String element, String forLog)throws Exception {
		chkd = false;
		try {
			WebElement elem = GetWebElement(type,element);
			if (elem != null ){
				chkd = elem.isSelected();
			}else {
				chkd = false;
			}
			if (chkd == true) {
				System.out.println("Verifying " + forLog + " is SELECTED");
				l.info("Verifying " + forLog + " is SELECTED");
			} else {
				System.out.println("Verifying " + forLog + " is UNSELECTED");
				l.info("Verifying " + forLog + " is UNSELECTED");
				captureScreen(element);
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Verifying " + forLog + " is UNSELECTED");
			l.info("Verifying " + forLog + " is UNSELECTED");
			captureScreen(element);
			myErrorLog = e.getMessage();
			status = false;
		}
		return chkd;
	}
	
	/** Click Element **/
	public static void clickElement(ElementType type,String element,String forlog) throws Exception {
		boolean clkelm = false;
		try {
			WebElement elem = GetWebElement(type, element);
			if (elem != null ){
				elem.click();
				System.out.println("Clicking " + forlog + " is PASSED");
				l.info("Clicking " + forlog + " is PASSED");
				Thread.sleep(5000);
				clkelm = true;
			}
			if (clkelm == false){
				System.out.println("Clicking " + forlog + " is FAILED");
				l.info("Clicking " + forlog + " is FAILED");
				captureScreen(element);
				status = false;
			}
		} catch (Exception e) {
			System.out.println("Clicking " + forlog + " is FAILED");
			l.info("Clicking " + forlog + " is FAILED");
			captureScreen(element);
			myErrorLog = e.getMessage();
			status = false;
		}
	}
	
	/** DBL Click Element **/
	public static void dblClickElement(ElementType type,String element) throws Exception {
		boolean clkelm = false;
		try {
			WebElement elem = GetWebElement(type, element);
			if (elem != null ){
				elem.click();
				Thread.sleep(100);
				elem.click();
				System.out.println("Clicking " + element + " is PASSED");
				l.info("Clicking " + element + " is PASSED");
				Thread.sleep(5000);
				clkelm = true;
			}
			if (clkelm == false){
				System.out.println("Clicking " + element + " is FAILED");
				l.info("Clicking " + element + " is FAILED");
				captureScreen(element);
				status = false;
			}
		} catch (Exception e) {
			System.out.println("Clicking " + element + " is FAILED");
			l.info("Clicking " + element + " is FAILED");
			captureScreen(element);
			myErrorLog = e.getMessage();
			status = false;
		}
	}
		
	/** Closing the Browser Window **/
	public static void closeBrowser() throws Exception {
		try {
			if (!welcomeScreen.driver.getClass().getSimpleName().equals("HtmlUnitDriver")) {
				System.out.println("<============= Closing Browser Window =============>");
				l.info("<============= Closing Browser Window =============>");
			}else{
				System.out.println("<============= Closing Headless Mode =============>");
				l.info("<============= Closing Headless Mode =============>");
			}
			welcomeScreen.closeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** Deleting the screenshot file **/
	public static void deleteScreenshotFiles() 
	{
		File file = new File("../mywu 0.5/target/surefire-reports/ScreenShots/");  
		String[] myFiles;     
        if(file.isDirectory())
        {  
            myFiles = file.list(); 
            for (int i=0; i<myFiles.length; i++) 
            {  
                 File myFile = new File(file, myFiles[i]);
                 myFile.delete();  
             }  
          }  
	}
	
	/** Wait for register email field to appear 
	 * @param string 
	 * @param id **/
	public static void waitForElement(ElementType type, String element) throws Exception{
		CommonUtils.conditionalDelay(type, element);
	}
	
	/** verify pre-populated fld**/
	
	public static void verifyPrePopulatedFld(ElementType type, String element,String forlog) throws Exception{
		int webElementValue = 0;
		try {
			WebElement elem = GetWebElement(type, element);
			if (elem != null ){
				webElementValue = elem.getText().length();
				System.out.println("the value======"+ elem.getText());
			}
			if(webElementValue == 0){
				System.out.println("Verified the values in " + forlog
						+ " have not pre-populated");
				l.info("Verified the values in " + forlog
						+ " have not pre-populated");
				captureScreen(listelm.toString());
			}
			else{
				System.out.println("Verified the values in " + forlog
						+ " have pre-populated");
				l.info("Verified the values in " + forlog
						+ " have pre-populated");
				}
			}
		catch(Exception e){
			myErrorLog = e.getMessage();
			System.out.println("Exception captured" +e);
			captureScreen(listelm.toString());
		}
	}
	
	/** Conditional Delay **/
	public static void conditionalDelay(ElementType type, String elementValue) throws Exception {
		try{
			long curSysTime = System.currentTimeMillis() / 1000;
			long finalCurSysTime  = 0;
			boolean result=false; conVal=false;
			do {
				try{
					WebElement elem = GetWebElement(type, elementValue);
					if (elem != null ){
					result = elem.isDisplayed();
					}else{
						break;
					}
					}catch(Exception e){
					
					}		
					if (result==true ) {
						Thread.sleep(1000);
						conVal=true;
						break;					
					} 
					else{
						Thread.sleep(1000);
						conVal=false;
					}
					finalCurSysTime = System.currentTimeMillis() / 1000;
				} while ((!result) && (finalCurSysTime <= (curSysTime + 60)));
			}
		catch(Exception e){
			myErrorLog = e.getMessage();
			System.out.println("Exception captured" +e);
		}
	}
	
	public static void wait_for_progressbar(String element) throws Exception{
		try{
		WebElement progress_element = driver.findElement(By.className(element));
		while(progress_element.isDisplayed() == true){
			 Thread.sleep(1000);
		}
		}
		catch (Exception e){
			myErrorLog = e.getMessage();
			System.out.println("Exception captured" +e);
			captureScreen(listelm.toString());
		}
			
	}
	public static String timeStamp(){
		 Calendar currentDate = Calendar.getInstance();
		  SimpleDateFormat formatter= 
		  new SimpleDateFormat("HHmmss");
		  String value = formatter.format(currentDate.getTime());
		  return value;
	}
	
	/** Entering data into the text box field **/
	public static void enterData(ElementType type, String element, String value)
			throws Exception {
		boolean data = false;
		try {
	
			WebElement elem = GetWebElement(type, element);
			if (elem != null ){
			elem.clear();
			elem.sendKeys(value);
			Thread.sleep(2000);
				System.out.println("The value " + value
					+ " is ENTERED SUCCESSFULLY");
				l.info("The value " + value + " is ENTERED SUCCESSFULLY");
				data = true;
				}
			if (data == false){
				System.out.println("The value " + value
						+ " is not entered");
				l.info("The value " + value + " is not entered");
				captureScreen(listelm.toString());
			}

		} catch (Exception e) {
			System.out.println("The value " + value + " is not entered");
			l.info("The value " + value + " is not entered");
			captureScreen(listelm.toString());
			myErrorLog = e.getMessage();
			status = false;
		}
	}
	
	/** Selecting an option from the drop-down **/
	public static void selectDropDown(ElementType type, String element,
			String selectValue) throws Exception {
		boolean sel = false;
		try {
			WebElement elem = GetWebElement(type, element);
			if (elem != null ){
			Select option = new Select(elem);
			option.selectByVisibleText(selectValue);
			Thread.sleep(2000);
			System.out.println(selectValue+ " is select successfully");
			l.info(selectValue + " is select successfully");
			sel = true;
			}
			
			if (sel == false){
				System.out.println(selectValue+ " is not selected");
				l.info(selectValue + " is not selected");
			}
		} catch (Exception e) {
			System.out.println(selectValue
					+ " is not selected");
			l.info(selectValue + " is not selected");
			status = false;
		}
	}
	
	public static void getFocus(ElementType type,String element){
		try {
			WebElement elem = GetWebElement(type, element);
			elem.sendKeys(Keys.TAB);
		} catch (Exception e) {
		    e.printStackTrace();
		}
     }
	
	
 /** Mouse hover Element **/
	public static void mouseHover(ElementType type,String element, String forLog) throws Exception {
		boolean clkelm = false;
		try {
			WebElement elem = GetWebElement(type, element);
			if (elem != null ){
			 Actions actions = new Actions(driver);
				actions.moveToElement(elem);
				actions.perform();
				System.out.println("Hovering" + forLog + " is PASSED");
				l.info("Hovering " + forLog + " is PASSED");
//				Thread.sleep(1000);
				clkelm = true;
			}
			if (clkelm == false){
				System.out.println("Hovering " + forLog + " is FAILED");
				l.info("Hovering" + forLog + " is FAILED");
				captureScreen(element);
				status = false;
			}
		} catch (Exception e) {
			System.out.println("Hovering " + forLog + " is FAILED");
			l.info("Hovering " + forLog + " is FAILED");
			captureScreen(element);
			myErrorLog = e.getMessage();
			status = false;
		}
	}
	
	/*Page reload */
    
    public static void pageReload()throws Exception{
           driver.navigate().refresh();
    }
    public static String LINK_TEST = "http://cmsqa-makeup.photoninfotech.com/Articles/haute-off-the-press-should-brown-girls-spray-tan";
    public static void navigateTest()throws Exception{
    	
    	driver.navigate().to(LINK_TEST);
    }
    public static String LINK_TEST1 = "http://cmsqa-makeup.photoninfotech.com/Everything";
    public static void navigateTest1()throws Exception{
    	
    	driver.navigate().to(LINK_TEST1);
    }
    
    public static String EXPRESS_URL = "http://10.23.233.32:4503/content/wucom/base/en_US/expressregister.html";
    public static void express()throws Exception{
    	
    	driver.navigate().to(EXPRESS_URL);
    }
    
    public static String CHALLANGER_URL = "http://10.23.233.32:4503/content/wucom/base/en_US/mywuregister.html";
    public static void challanger()throws Exception{
    	
    	driver.navigate().to(CHALLANGER_URL);
    }
/** Link Checker via Xpath of the menu**/
    
    public static void linkChecker(ElementType type,String element) throws Exception {
    	boolean Lelem = false ;
    	try {
			WebElement elem = GetWebElement(type, element);
			if (elem != null ){
				
				List <WebElement> allLinks = elem.findElements(By.tagName("a"));
				System.out.println("#############################################");
				System.out.print("available links are: ");
				System.out.println(allLinks.size());
						int i=1;
						for (WebElement alinks :allLinks){
						String menu = alinks.getAttribute("href");
						System.out.println("Link:"+i+" ");
						System.out.println(menu);
						System.out.println("Status : available");
						System.out.println("-----------------------------------------------------------");
						i++;
						}	
				
				Lelem = true;
			}
			if (Lelem == false){
				System.out.println("Link Check " + element + " is NOT available");
				l.info("Link check" + element + " is NOT available");
				captureScreen(element);
				status = false;
			}
		} catch (Exception e) {
			System.out.println("Link check " + element + " is NOT available");
			l.info("Link check " + element + " is NOT available");
			captureScreen(element);
			myErrorLog = e.getMessage();
			status = false;
		}
    	
    }
    
//    Access pages for links 
    public static void navigationChecker(ElementType type,String element) throws Exception {
    	boolean Lelem = false ;
    	try {
			WebElement elem = GetWebElement(type, element);
			if (elem != null ){
			 int i=1;
					List <WebElement> navLinks = elem.findElements(By.tagName("a"));
					  
					String data[] = new String[navLinks.size()];
					
					for(int j=0;j < navLinks.size() ;j++)
					{ 
					
					String Link = navLinks.get(j).getAttribute("href");
					 
//					System.out.println("Link : "+i +" ==> "+Link);
					
					data[j] = Link ;
							
					i++;
								 
						}	
					System.out.println("navigation of link started");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					int l=1;
					for(int k=0; k < navLinks.size();k++,l++)
					{
						driver.get(data[k]);
						
						System.out.println("Link :"+l);
						System.out.println(data[k]);
						System.out.println("navigated successfully");
						System.out.println("===================================================");
					}
				
				Lelem = true;
			}
			if (Lelem == false){
				System.out.println(Lelem);
				System.out.println("Link Check " + element + " is NOT available");
				l.info("Link check" + element + " is NOT available");
				captureScreen(element);
				status = false;
			}
		} catch (Exception e) {
			System.out.println("Link check E" + element + " is NOT available");
			l.info("Link check " + element + " is NOT available");
			captureScreen(element);
			myErrorLog = e.getMessage();
		
			status = false;
		}
    }
    
	
	/** Checking Integer value **/
	public static boolean isInteger(String str) {
	    try {
	        Integer.parseInt(str);
	        return false;
	    } catch (NumberFormatException nfe) {
	        return true;
	    }
	}
	public static void linkNavigate(String element,String forlog) throws Exception {
		boolean clkelm = false;
		try {
			if (element != null ){
				driver.navigate().to(element);
				System.out.println("Clicking " + forlog + " is PASSED");
				l.info("Clicking " + forlog + " is PASSED");
				Thread.sleep(5000);
				clkelm = true;
			}
			if (clkelm == false){
				System.out.println("Clicking " + forlog + " is FAILED");
				l.info("Clicking " + forlog + " is FAILED");
				captureScreen(element);
				status = false;
			}
		} catch (Exception e) {
			System.out.println("Clicking " + forlog + " is FAILED");
			l.info("Clicking " + forlog + " is FAILED");
			captureScreen(element);
			myErrorLog = e.getMessage();
			status = false;
		}
	}
}
