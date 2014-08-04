package com.photon.phresco.test;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.photon.phresco.resources.*;
import com.photon.phresco.selenium.util.CommonUtils;

public class PayBillsScreen extends TestCase {

	@Before
	public void setUp() throws Exception {
		CommonUtils.testCaseName="PayBills";
		CommonUtils.launchingBrowser();
	}

	@After
	public void tearDown() throws Exception {
		CommonUtils.closeBrowser();
		if (CommonUtils.status == false){
			fail("PAY BILLS Navigation test case Failed");
		} 
	}

	@Test
	public void test() throws Exception {
 	System.out.println("*********** PAY BILLS NAVIGATION TEST CASES STARTED ************");
	CommonUtils.l.info("*********** PAY BILLS NAVIGATION TEST CASES STARTED  ************");
	PayBillsPage.payBillTest();
	System.out.println("*********** PAY BILLS NAVIGATION TEST CASES COMPLETED ************");
	CommonUtils.l.info("*********** PAY BILLS NAVIGATION TEST CASES COMPLETED ************");
	}

}
