/*** MY Western Union Automation Framework***/

package com.photon.phresco.test;
import com.photon.phresco.selenium.util.CommonUtils;

import junit.framework.Test;
import junit.framework.TestSuite;

/** AllTest runs all the test cases that are included in this class */
public class AllTest {
	static{
		System.getProperties().put("org.apache.commons.logging.simplelog.defaultlog", "fatal");
		}
	static { 
		System.setProperty("my.log", "src/Log/AutomationTest.log"); 
		}

	public static Test suite() throws Exception {
		TestSuite suite = new TestSuite(AllTest.class.getName());
		initiateTest();
		/*** Test cases are called here ***/
		suite.addTestSuite(HomeScreen.class);
		suite.addTestSuite(RegisterScreen.class);
		//suite.addTestSuite(SendMoneyScreen.class);
		suite.addTestSuite(PayBillsScreen.class);
		suite.addTestSuite(ActivityLoginScreen.class);
	    suite.addTestSuite(OverviewLoginScreen.class);
		suite.addTestSuite(SendInmateScreen.class);
		suite.addTestSuite(ChallengerRegisterScreen.class);
		suite.addTestSuite(RewardsScreen.class);
		suite.addTestSuite(ExpressRegisterScreen.class);
		return suite;
	}
	
	/*** Initial Test cases are called here ***/
	public static void initiateTest() throws Exception{
		CommonUtils.deleteScreenshotFiles();
	}
	
	static{
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
		System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http","warn");
	}
}
