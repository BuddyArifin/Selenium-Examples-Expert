package com.photon.phresco.test;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.photon.phresco.resources.*;
import com.photon.phresco.selenium.util.CommonUtils;

public class SendMoneyScreen extends TestCase {

	@Before
	public void setUp() throws Exception {
		CommonUtils.testCaseName="SendMoney";
		CommonUtils.launchingBrowser();
	}

	@After
	public void tearDown() throws Exception {
		CommonUtils.closeBrowser();
		if (CommonUtils.status == false){
			fail("SEND MONEY Navigation test case Failed");
		} 
	}

	@Test
	public void test() throws Exception {
 	System.out.println("*********** SEND MONEY NAVIGATION TEST CASES STARTED ************");
	CommonUtils.l.info("*********** SEND MONEY NAVIGATION TEST CASES STARTED  ************");
	SendMoneyPage.sendMoneyTest();
	RegisterPage.registerTest();
	System.out.println("*********** SEND MONEY NAVIGATION TEST CASES COMPLETED ************");
	CommonUtils.l.info("*********** SEND MONEY NAVIGATION TEST CASES COMPLETED ************");
	}

}
