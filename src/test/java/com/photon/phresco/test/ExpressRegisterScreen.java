package com.photon.phresco.test;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.photon.phresco.resources.*;
import com.photon.phresco.selenium.util.CommonUtils;

public class ExpressRegisterScreen extends TestCase {

	@Before
	public void setUp() throws Exception {
		CommonUtils.testCaseName="User Registration";
		CommonUtils.launchingBrowser();
	}

	@After
	public void tearDown() throws Exception {
		CommonUtils.closeBrowser();
		if (CommonUtils.status == false){
			fail("User Registration Failed");
		} 
	}

	@Test
	public void test() throws Exception {
 	System.out.println("*********** USER REGISTRATION TEST CASES STARTED ************");
	CommonUtils.l.info("*********** USER REGISTRATION TEST CASES STARTED  ************");
	ExpressRegisterPage.expressRegisterTest();
	System.out.println("*********** USER REGISTRATION TEST CASES COMPLETED ************");
	CommonUtils.l.info("*********** USER REGISTRATION TEST CASES COMPLETED ************");
	}
}
