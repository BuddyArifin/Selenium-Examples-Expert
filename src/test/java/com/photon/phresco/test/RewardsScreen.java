package com.photon.phresco.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.photon.phresco.resources.ActivityLoginPage;
import com.photon.phresco.resources.RewardsPage;
import com.photon.phresco.selenium.util.CommonUtils;

import junit.framework.TestCase;

public class RewardsScreen extends TestCase {

	@Before
	public void setUp() throws Exception
	{
		CommonUtils.testCaseName="OverviewLogin";
		CommonUtils.launchingBrowser();
	}
	
	@After
	public void tearDown() throws Exception {
		CommonUtils.closeBrowser();
		if (CommonUtils.status == false){
			fail("Rewards Navigation test case Failed");
		} 
	}
	
	@Test
	public void test() throws Exception {
 	System.out.println("*********** REWARDS LOGIN TEST CASES STARTED ************");
	CommonUtils.l.info("*********** REWARDS LOGIN TEST CASES STARTED  ************");
	
	RewardsPage.rewardsLoginTest();
	
	
	System.out.println("*********** REWARDS LOGIN TEST CASES COMPLETED ************");
	CommonUtils.l.info("*********** REWARDS LOGIN TEST CASES COMPLETED ************");
	}
}
