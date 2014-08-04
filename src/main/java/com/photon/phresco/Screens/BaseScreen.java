package com.photon.phresco.Screens;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import com.photon.phresco.selenium.util.Constants;
import com.photon.phresco.selenium.util.ScreenException;
import com.photon.phresco.uiconstants.PhrescoUiConstants;

public class BaseScreen {

	public WebDriver driver;
	private ChromeDriverService chromeService = null;
	private InternetExplorerDriverService ieService = null;
	// private Log log = LogFactory.getLog("BaseScreen");
	private PhrescoUiConstants phrescoUiConstants = null;
	private String resolution = null;

	public BaseScreen(String selectedBrowser, String applicationURL,
			String applicatinContext, PhrescoUiConstants phrescoUiConstants)
			throws ScreenException {
		this.phrescoUiConstants = phrescoUiConstants;
		instantiateBrowser(selectedBrowser, applicationURL, applicatinContext);
	}

	public void instantiateBrowser(String selectedBrowser,
			String applicationURL, String applicationContext)
			throws ScreenException {

		if (selectedBrowser.equalsIgnoreCase(Constants.BROWSER_CHROME)) {
			try {
				chromeService = new ChromeDriverService.Builder()
						.usingDriverExecutable(new File(getChromeLocation()))
						.usingAnyFreePort().build();

				driver = new ChromeDriver(chromeService);

				setBrowserResolution();
				driver.navigate().to(applicationURL + applicationContext);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (selectedBrowser.equalsIgnoreCase(Constants.BROWSER_IE)) {
			try {
				ieService = new InternetExplorerDriverService.Builder()
						.usingDriverExecutable(new File(getIELocation()))
						.usingAnyFreePort().build();

				driver = new InternetExplorerDriver(ieService);

				setBrowserResolution();
				driver.navigate().to(applicationURL + applicationContext);
			} catch (Exception e) {
				e.printStackTrace();
			}
//			File file = new File("D:/Ganesh/makeup_proj/makeup_Framework_V1.4/iedriver/IEDriverServer.exe");
//			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
//			driver = new InternetExplorerDriver();
//
//			setBrowserResolution();
//			driver.navigate().to(applicationURL + applicationContext);

		} else if (selectedBrowser.equalsIgnoreCase(Constants.BROWSER_SAFARI)) {
			driver = new SafariDriver();

			setBrowserResolution();
			driver.navigate().to(applicationURL + applicationContext);
		} else if (selectedBrowser.equalsIgnoreCase(Constants.BROWSER_FIREFOX)) {
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("network.http.phishy-userpass-length", 255);
			driver = new FirefoxDriver(profile);
			setBrowserResolution();
			driver.manage().window().maximize();
			driver.navigate().to(applicationURL + applicationContext);
		} else if (selectedBrowser.equalsIgnoreCase(Constants.BROWSER_HTMLUNIT)) {
			try {
				DesiredCapabilities dc = DesiredCapabilities.htmlUnit();
				driver= new HtmlUnitDriver(dc);
				
				driver.navigate().to(applicationURL + applicationContext);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (selectedBrowser.equalsIgnoreCase(Constants.BROWSER_OPERA)) {
			Robot robot;
			try {
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_ALT);
				robot.keyPress(KeyEvent.VK_SPACE);
				robot.keyRelease(KeyEvent.VK_ALT);
				robot.keyRelease(KeyEvent.VK_SPACE);
				robot.keyPress(KeyEvent.VK_X);
				robot.keyRelease(KeyEvent.VK_X);

				driver.navigate().to(applicationURL + applicationContext);
			} catch (AWTException e) {
				e.printStackTrace();
			}
		} else {
			// throw new ScreenException(
			// "------Driver is not initiated properly. Please Check the availablity of the browser and start the test again-----------");
			System.out
					.println("------Driver is not initiated properly. Please Check the availablity of the browser and start the test again-----------");
		}
	}

	public void setBrowserResolution() {
		resolution = this.phrescoUiConstants.RESOLUTION;
		if (resolution != null) {
			String[] tokens = resolution.split("x");
			String resolutionX = tokens[0];
			String resolutionY = tokens[1];
			int Xpath = Integer.parseInt(resolutionX);
			int Ypath = Integer.parseInt(resolutionY);
			Dimension screenResolution = new Dimension(Xpath, Ypath);
			driver.manage().window().setSize(screenResolution);
		} else {
			driver.manage().window().maximize();
		}
	}

	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
			if (chromeService != null) {

			}
		}
	}

	public String getChromeLocation() {
		String directory = System.getProperty("user.dir");
		String targetDirectory = getChromeFile();
		String location = directory + targetDirectory;
		return location;
	}
	public String getIELocation() {
		String directory = System.getProperty("user.dir");
		String targetDirectory = getIEFile();
		String location = directory + targetDirectory;
		return location;
	}
	public String getChromeFile() {
		if (System.getProperty("os.name").startsWith(Constants.WINDOWS_OS)) {
			return Constants.WINDOWS_DIRECTORY + "/chromedriver.exe";
		} else if (System.getProperty("os.name").startsWith(Constants.LINUX_OS)) {
			return Constants.LINUX_DIRECTORY_64 + "/chromedriver";
		} else if (System.getProperty("os.name").startsWith(Constants.MAC_OS)) {
			return Constants.MAC_DIRECTORY + "/chromedriver";
		} else {
			throw new NullPointerException("******PLATFORM NOT FOUND********");
		}
	}
	
	public String getIEFile()
	{
		if (System.getProperty("os.name").startsWith(Constants.WINDOWS_OS))
		{
			return "/iedriver/IEDriverServer.exe";
		}
		 else {
			throw new NullPointerException("******PLATFORM NOT FOUND********");
		}
	}
	
}
