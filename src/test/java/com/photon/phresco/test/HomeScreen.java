package com.photon.phresco.test;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.photon.phresco.resources.*;
import com.photon.phresco.selenium.util.CommonUtils;

public class HomeScreen extends TestCase {

	@Before
	public void setUp() throws Exception {
		CommonUtils.testCaseName="GuestUserNavigation";
		CommonUtils.launchingBrowser();
	}

	@After
	public void tearDown() throws Exception {
		CommonUtils.closeBrowser();
		if (CommonUtils.status == false){
			fail("Guest User Navigation test case Failed");
		} 
	}

	@Test
	public void test() throws Exception {
 	System.out.println("*********** GUEST USER NAVIGATION TEST CASES STARTED ************");
	CommonUtils.l.info("*********** GUEST USER NAVIGATION TEST CASES STARTED  ************");
	HeaderLinksPage.headerLinkVerification();
	HeaderLinksPage.centerLinkVerification();
	HeaderLinksPage.mainLinkVerification();
	HomePage.homeScreenVerification();
	FooterLinksPage.footerLinkVerification();
	System.out.println("*********** GUEST USER NAVIGATION TEST CASES COMPLETED ************");
	CommonUtils.l.info("*********** GUEST USER NAVIGATION TEST CASES COMPLETED ************");
	}
}
