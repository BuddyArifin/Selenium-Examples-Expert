package com.photon.phresco.test;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.photon.phresco.resources.*;
import com.photon.phresco.selenium.util.CommonUtils;

public class OverviewLoginScreen extends TestCase {

	@Before
	public void setUp() throws Exception {
		CommonUtils.testCaseName="OverviewLogin";
		CommonUtils.launchingBrowser();
	}

	@After
	public void tearDown() throws Exception {
		CommonUtils.closeBrowser();
		if (CommonUtils.status == false){
			fail("OverviewLogin Navigation test case Failed");
		} 
	}

	@Test
	public void test() throws Exception {
 	System.out.println("*********** OVERVIEW LOGIN TEST CASES STARTED ************");
	CommonUtils.l.info("*********** OVERVIEW LOGIN TEST CASES STARTED  ************");
	OverviewLoginPage.overviewLoginTest();
	System.out.println("*********** OVERVIEW LOGIN TEST CASES COMPLETED ************");
	CommonUtils.l.info("*********** OVERVIEW LOGIN TEST CASES COMPLETED ************");
	}

}
