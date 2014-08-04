package com.photon.phresco.selenium.util;

public class Constants {

	public static final String BROWSER_IE = "internetExplorer";
	public static final String BROWSER_FIREFOX = "firefox";
	public static final String BROWSER_CHROME = "chrome";
	public static final String BROWSER_SAFARI = "safari";
	public static final String BROWSER_OPERA = "opera";
	public static final String BROWSER_IPHONE = "iphonehybrid";
	public static final String BROWSER_ANDROID = "androidhybrid";
	public static final String BROWSER_HTMLUNIT = "htmlunit";

	public static String DEFAULT_TIMEOUT = "180000";
	public static String ONE_MINUTE_TIMEOUT = "60000";
	public static String THIRTY_SECOND_TIMEOUT = "30000";
	public static String WINDOWS_OS = "Windows";
	public static String LINUX_OS = "Linux";
	public static String MAC_OS = "Mac";
	public static String DIRECTORY = "/chromedriver";
	public static String WINDOWS_DIRECTORY = DIRECTORY + "/windows";
	public static String LINUX_DIRECTORY_32 = DIRECTORY + "/linux-32";
	public static String MAC_DIRECTORY = DIRECTORY + "/mac";
	public static String LINUX_DIRECTORY_64 = DIRECTORY + "/linux-64";
	public static void setDefaultTimeout(String timeout) {
		int parseInt = Integer.parseInt(timeout);
		if (parseInt > 0) {
			DEFAULT_TIMEOUT = timeout;
		}
	}
}