package com.raftt_m.library;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import org.apache.commons.exec.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.raftt_m.or.MobOR_Android;
import com.raftt_m.or.MobOR_iOS;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

@SuppressWarnings("rawtypes")
public class LaunchLoginAndLogout {
	static String sPlatform;
	public static int ssCount = 0;
	public static WebDriverWait waitLong;
	public static WebDriverWait waitShort;
	public static String reportPath;
	public ExtentReports extent;
	public ExtentTest logger;
	public static ReadEnvPropFile oReadEnvProp;
	public static AppiumDriver driver;
	public static String country = null;
	public static String platformName;
	static MobOR_iOS MobOR_iOS = null;
	static MobOR_Android MobOR_android = null;


	protected String getStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);
		return sw.toString();
	}

	/**************************************************************
	 * Function Name - LaunchLoginAndLogout Description - Test case - NA
	 * Parameters - Date created - 16th Nov 2016 Developed by - Deepak Kapdi
	 * Last Modified By - Last Modified Date -
	 * 
	 * @return
	 ***************************************************************/

	public AppiumDriver LaunchLoginAndLogout(String scriptName, String deviceName, String platform) throws Exception {

		String sPlatform = Utils.Platform();
		if(sPlatform.equalsIgnoreCase("Android")){
			driver = null;

			if (platform.contains("_")) {
				String arr[] = platform.split("_");
				country = arr[1];
				platformName = arr[0];
			} else
				platformName = platform;
			ReadEnvPropFile oReadEnvProp = new ReadEnvPropFile();

			Report.exeBy = oReadEnvProp.ExecutedBy();
			Report.sReportFilePath = oReadEnvProp.Report_Path();
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
					.format(new java.util.Date());
			String reportPath = Report.sReportFilePath + "\\" + "Exec_Report" + "_"
					+ scriptName + "_" + timeStamp + ".html";
			extent = SimpleReportFactory.getReporter(reportPath);

			logger = getLogger(scriptName, platformName.toUpperCase());
			logger.assignAuthor(Report.exeBy.toUpperCase());
			logger.assignCategory("Automation");

			driver = getDriver(deviceName, platformName);
			driver.manage()
			.timeouts()
			.implicitlyWait(
					Integer.parseInt(oReadEnvProp.ObjTimeOutShort()),
					TimeUnit.SECONDS);

			waitLong = new WebDriverWait(driver, Integer.parseInt(oReadEnvProp
					.ObjTimeOutLong()));
			waitShort = new WebDriverWait(driver, Integer.parseInt(oReadEnvProp
					.ObjTimeOutShort()));	
		}else{
			driver = null;
			ReadEnvPropFile oReadEnvProp = new ReadEnvPropFile();
			Report.exeBy = oReadEnvProp.ExecutedBy();
			Report.sReportFilePath = oReadEnvProp.Report_Path();
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
			String reportPath = Report.sReportFilePath + "\\" + "Exec_Report" + "_" + scriptName + "_" + timeStamp
					+ ".html";
			//String reportPath = "reportme.html";
			extent = SimpleReportFactory.getReporter(reportPath);

			logger = getLogger(scriptName, platform.toUpperCase());
			logger.assignAuthor(Report.exeBy.toUpperCase());
			logger.assignCategory("Automation");

			driver = getDriver(deviceName, platform);
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(oReadEnvProp.ObjTimeOutShort()),
					TimeUnit.SECONDS);

			waitLong = new WebDriverWait(driver, Integer.parseInt(oReadEnvProp.ObjTimeOutLong()));
			waitShort = new WebDriverWait(driver, Integer.parseInt(oReadEnvProp.ObjTimeOutShort()));
		}

		return (driver);
	}

	/**************************************************************
	 * Function Name - getLogger Description - Test case - NA Parameters - Date
	 * created - 16th Nov 2016 Developed by - Deepak Kapdi Last Modified By -
	 * Last Modified Date -
	 ***************************************************************/
	public ExtentTest getLogger() {
		return logger;
	}

	/**************************************************************
	 * Function Name - getLogger Description - For reporting Test case - NA
	 * Parameters - Date created - 16th Nov 2016 Developed by - Deepak Kapdi
	 * Last Modified By - Last Modified Date -
	 ***************************************************************/
	public ExtentTest getLogger(String scriptName, String platform) {
		logger = extent.startTest(scriptName + "_" + platform.toUpperCase());
		return logger;
	}

	/**************************************************************
	 * Function Name - getExtent Description - For reporting Test case - NA
	 * Parameters - Date created - 16th Nov 2016 Developed by - Deepak Kapdi
	 * Last Modified By - Last Modified Date -
	 ***************************************************************/
	public ExtentReports getExtent() {
		return extent;
	}

	/**************************************************************
	 * Function Name - StartStopAppium Description - For starting and stopping
	 * the Appium Test case - NA Parameters - Date created - 21st Nov 2016
	 * Developed by - Akhilesh Jain Last Modified By - Last Modified Date -
	 ***************************************************************/
	public static AppiumDriverLocalService service;
	public static AppiumServiceBuilder service1;
	public static AppiumServiceBuilder ser;

	public static void StartStopAppium() throws InterruptedException {
		String sPlatform = Utils.Platform();
		if (sPlatform.equalsIgnoreCase("Android")) {
			service = AppiumDriverLocalService
					.buildService(new AppiumServiceBuilder()
							.usingDriverExecutable(
									new File(
											"C:\\Program Files\\nodejs\\node.exe"))
							.withAppiumJS(
									new File(
											"C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js"))
							.withIPAddress("127.0.0.1").usingPort(4723));

			startAppiumServer();
		} else {
			/*service = AppiumDriverLocalService
					.buildService(new AppiumServiceBuilder()
							.usingDriverExecutable(
									new File(
											"/usr/local/lib/node_modules/appium/build/lib/main.js"))
							.withAppiumJS(
									new File(
											"/usr/local/lib/node_modules/appium/build/lib/appium.js"))
							.withIPAddress("127.0.0.1").usingPort(4723));*/
			ser = new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node")).withAppiumJS(
					new File("/Applications/Appium.app/Contents/Resources/node_modules/appium/lib/server/main.js"));
			ser.build().start();
			//startAppiumServer();
			// stopAppiumServer();
		}
	}

	public static void startAppiumServer() throws InterruptedException {

		service.start();
		System.out.println("Appium Server has started");
		Thread.sleep(5000L);
	}

	public static void stopAppiumServer() {
		service.stop();
		CommandLine command = new CommandLine("cmd");
		command.addArgument("taskkill");
		command.addArgument("/F");
		command.addArgument("/IM");
		command.addArgument("node.exe");
		System.out.println("Appium Server has stopped");
	}

	/**************************************************************
	 * Function Name - getDriver Description - Setting the Android/iOS driver
	 * with capabilities Test case - NA Parameters - Date created - 21st Nov
	 * 2016 Developed by - Sindhu Nemani Last Modified By - Last Modified Date -
	 ***************************************************************/

	public AppiumDriver getDriver(String deviceName, String platform)
			throws InterruptedException, IOException {
		StartStopAppium();
		//startAppiumServer();
		String sPlatform = Utils.Platform();
		driver = null;

		if (sPlatform.equalsIgnoreCase("Android")) {

			// Set capabilities here for Android Native app
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", deviceName);
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
			capabilities.setCapability("platformName", platform);
			capabilities.setCapability("appPackage", "com.ups.mobile.android");
			capabilities.setCapability("appActivity",
					"md5252de5ee5326fe34d69a668de314d0ce.SplashActivity");
			capabilities.setCapability(CapabilityType.VERSION, "6.0.1");
			capabilities.setCapability("unicodeKeyboard", "true");
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
					capabilities);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		} else if (sPlatform.equals("iOS")) {

			// Set capabilities here for iOS Native app

			/*DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
					"iOS");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
					"9.2");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
					"iphone6");
			capabilities
			.setCapability(MobileCapabilityType.BROWSER_NAME, "iOS");
			capabilities.setCapability(MobileCapabilityType.VERSION, "");
			capabilities.setCapability("appPackage", "");
			capabilities.setCapability("appActivity", "");
			driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),
					capabilities);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);*/
			File f = new File("/UPS_APKs/IPA/UPS.MobileX_DEBUG_6_0_0_13.ipa");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0.1");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
			capabilities.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
			driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}

		return (driver);
	}

	public static void closeDriver() {
		// driver.close();
		stopAppiumServer();
	}

	/**************************************************************
	 * Function Name - LoginToApp Description - Handle IOS Keyboard Test case -
	 * NA Parameters - Date created - 6nd Mar 2017 Developed by - Ramakant
	 * Sharma Last Modified By - Last Modified Date -
	 * 
	 * @return
	 ***************************************************************/
	public static void handleIOSKeyboard() {
		try {
			IOSDriver<WebElement> Keyboard = (IOSDriver<WebElement>) driver;
			Keyboard.getKeyboard().sendKeys(Keys.RETURN);
		} catch (Exception e) {
			driver.tap(1, 367, 72, 1);
		}
	}

	/**************************************************************
	 * Function Name - LoginToApp Description - Stop test case on failure Test
	 * case - NA Parameters - Date created - 6nd Mar 2017 Developed by -
	 * Ramakant Sharma Last Modified By - Akhilesh Jain Last Modified Date -
	 * 9-Mar-2017
	 * 
	 * @return
	 * @throws Exception
	 ***************************************************************/
	public static void stopOnFailure(AppiumDriver driver, ExtentTest logger,
			ExtentReports extent, ITestResult result) throws Exception {
		String errormessage = result.getThrowable().toString();

		if (errormessage.contains("Build")) {
			int number = errormessage.lastIndexOf("Build");
			result.getThrowable().getMessage().substring(0, number);
			Report.failLog(driver, logger, result.getThrowable().getMessage()
					.substring(0, number));
		} else {
			Report.failLog(driver, logger, "An Exception has occured");
		}

		Utils.tearDown(driver, logger, extent);
		extent.flush();
		driver.closeApp();
		driver.quit();
	}

	// Code updated - 22Nov
	/**************************************************************
	 * Function Name - ClickSelectFrameObjects Description - Nevigate back in
	 * iOS buttons from frame Test case - Parameters - Date created - 17th Mar
	 * 2017 Developed by - Ramakant Sharma Last Modified By - Last Modified Date
	 * -
	 * 
	 * @throws Exception
	 * @throws IOException
	 * @throws InterruptedException
	 ***************************************************************/
	public static void NavigateBackiOS(AppiumDriver driver, ExtentTest logger)
			throws Exception {
		MobOR_iOS = PageFactory.initElements(driver, MobOR_iOS.class);
		// waitLong.until(ExpectedConditions.visibilityOf(MobOR_iOS.btnSetBack));
		Mobile.checkExistClick(driver, logger, MobOR_iOS.btnSetBack, "Yes",
				"Long", "Back_Current", "No");
	}

	/**************************************************************
	 * Function Name - ClickSelectFrameObjects Description - cancel or back in
	 * iOS buttons from frame Test case - Parameters - Date created - 25th Mar
	 * 2017 Developed by - Ramakant Sharma Last Modified By - Last Modified
	 * Date -
	 * 
	 * @throws Exception
	 * @throws IOException
	 * @throws InterruptedException
	 ***************************************************************/
	public static void btnBackiOS(AppiumDriver driver, ExtentTest logger)
			throws Exception {
		MobOR_iOS = PageFactory.initElements(driver, MobOR_iOS.class);
		Mobile.checkExistClick(driver, logger, MobOR_iOS.btnback, "Yes",
				"short", "Back_Current", "No");
	}

}
