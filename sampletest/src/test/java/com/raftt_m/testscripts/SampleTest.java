package com.raftt_m.testscripts;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.raftt_m.library.LaunchLoginAndLogout;
import com.raftt_m.library.Report;
import com.raftt_m.library.SimpleReportFactory;
import com.raftt_m.library.Utils;
import com.raftt_m.or.MobOR_Android;
import com.raftt_m.or.MobOR_iOS;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
	
import io.appium.java_client.AppiumDriver;

public class SampleTest {
	@SuppressWarnings("rawtypes")
	AppiumDriver driver;
	ExtentTest logger;
	ExtentReports extent;
	static String sPlatform = Utils.Platform();
	static MobOR_Android MobOR_android = null;
	static MobOR_iOS MobOR_iOS = null;
	@Parameters({ "Script_Name", "DeviceName", "Device_Platform" })
	@BeforeTest
	public void beforeTest(String scriptName, String deviceName, String platform)
			throws Exception {

		LaunchLoginAndLogout launchLogout = new LaunchLoginAndLogout();
		driver = launchLogout.LaunchLoginAndLogout(scriptName, deviceName,
				platform);
		logger = launchLogout.getLogger();
		extent = launchLogout.getExtent();
	}
	@Test
	public void sampletest() throws Exception{
		Report.passLogWithSS(driver, logger, "Sample Application executed");	
	}
	@AfterMethod
	public void test(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			LaunchLoginAndLogout.stopOnFailure(driver, logger, extent, result);
		} else {
			extent.flush();
		}
	}

	@AfterTest
	public void afterTest() throws Exception {
		try {
			Utils.tearDown(driver, logger, extent);
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@AfterSuite
	public void closeReport() throws InterruptedException {
		try {
			SimpleReportFactory.closeReporter(extent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
