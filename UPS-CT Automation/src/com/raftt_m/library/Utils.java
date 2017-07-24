package com.raftt_m.library;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

import java.io.IOException;
import java.util.Set;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.raftt_m.or.MobOR_Android;
import com.raftt_m.or.MobOR_iOS;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import java.sql.Date;
@SuppressWarnings("rawtypes")
public class Utils extends LaunchLoginAndLogout {
	static int sscount = 1;
	static MobOR_iOS MobOR_iOS = null;
	static MobOR_Android MobOR_android = null;

	static String sPlatform = Utils.Platform();

	/**************************************************************
	 * Function Name - captureSS Description - Take screenshot showing object
	 * Test case - Parameters - Date created - 17th Nov 2016 Developed by -
	 * Deepak Kapdi Last Modified By - Last Modified Date -28/12/2016 By
	 * Ramakant Sharma
	 ***************************************************************/
	public static String captureSS(AppiumDriver driver, ExtentTest logger,
			String Validation, String status) throws IOException {
		String path = null;
		String scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.BASE64);
		String ss = "data:image/png;base64," + scrFile;
		sscount++;
		System.out.println("Screenshot Path:--" + ss);
		path = logger.addScreenCapture(ss);
		System.out.println("SS =  " + path);
		logger.log(LogStatus.INFO, Validation);
		if (status.equalsIgnoreCase("PASS")) {
			logger.log(LogStatus.PASS, path);
		} else {
			logger.log(LogStatus.FAIL, path);
		}
		return path;
	}

	/**************************************************************
	 * Function Name - tearDown Description - To close the report Parameters -
	 * Date created - 17th Nov 2016 Developed by - Deepak Kapdi Last Modified By
	 * - Last Modified Date -
	 ***************************************************************/
	public static Boolean tearDown(AppiumDriver driver, ExtentTest logger,
			ExtentReports extent) throws InterruptedException, IOException {
		Boolean result = true;
		try {
			logger.log(LogStatus.INFO, "Execution completed");
			extent.endTest(logger);
		} catch (Exception e) {
			e.printStackTrace();
			Report.infoLog(logger, e.getMessage());
		}
		return result;
	}

	

	/**************************************************************
	 * Function Name - ScrollDown Description - To scroll the page - Date
	 * created - 30th Nov 2016 Developed by - Deepak Kapdi Last Modified By -
	 * Last Modified Date -
	 ***************************************************************/
	public static Boolean ScrollDown(AppiumDriver driver, ExtentTest logger,
			WebElement oEle) throws InterruptedException, IOException {
		Boolean foundflg = false;

		Dimension dimensions = driver.manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.75;
		Double screenHeightEnd = dimensions.getHeight() * 0.10;

		driver.swipe(0, screenHeightStart.intValue(), 0,
				screenHeightEnd.intValue(), 2000);
		/*
		 * if (oEle.isDisplayed()) { foundflg = true; }
		 */
		return foundflg;
	}
	/**************************************************************
	 * Function Name - SwitchContext Description - To change the context of app
	 * - Date created - 06th Dec 2016 Developed by - Deepak Kapdi Last Modified
	 * By - Last Modified Date -
	 ***************************************************************/
	@SuppressWarnings("unchecked")
	public static Boolean SwitchContext(AppiumDriver driver, ExtentTest logger,
			String ContextToBeSwitched) throws InterruptedException,
			IOException {
		Boolean foundflg = false;

		Set<String> contexts = driver.getContextHandles();

		// assertThat(contexts.size(), greaterThan(1));
		for (String context : contexts) {
			// System.out.println(contexts);
			// if (context.contains("WEBVIEW") && Context.equals("WEBVIEW"))
			// {
			if (context.contains("WEBVIEW")) {
				driver.context(context);
				break;
			}
			/*
			 * else if (context.contains("NATIVE_APP") &&
			 * Context.equals("NATIVE_APP")) { driver.context(("NATIVE_APP"));
			 * break; } else { System.out.println("Changing context"); }
			 */
		}
		return foundflg;
	}

	/**************************************************************
	 * Function Name - ScrollUp Description - To scroll up the page - Date
	 * created - 27th dec 2016 Developed by - Deepak Kapdi Last Modified By -
	 * Last Modified Date -
	 * 
	 * @throws Exception
	 ***************************************************************/
	public static Boolean ScrollUp(AppiumDriver driver, ExtentTest logger,
			WebElement oEle) throws Exception {
		Boolean foundflg = false;

		Dimension dimensions = driver.manage().window().getSize();
		int startX = (dimensions.width * 20) / 100;
		int endX = (dimensions.width * 22) / 100;

		int startY = (dimensions.height * 62) / 100;
		int endY = (dimensions.width * 35) / 100;

		TouchAction touchAction4 = new TouchAction(driver);
		touchAction4.press(startX, startY).moveTo(endX, endY).release();
		driver.performTouchAction(touchAction4);

		if (oEle.isDisplayed()) {
			Report.passLogWithSS(driver, logger,
					"Desired object is brought in view now");
		} else {
			Report.failLogWithoutSS(logger,
					"Desired object is not displayed in current view now");
		}
		return foundflg;
	}

	/**************************************************************
	 * Function Name - getDriver Description - platform Read with capabilities
	 * Test case - NA Parameters - Date created - 3-2-2017 Developed by -
	 * Ramakant Sharma Last Modified By - Last Modified Date -
	 * 
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 ***************************************************************/
	public static String Platform() {
		String sPlatform = null;
		try {
			ReadEnvPropFile oReadEnvProp = new ReadEnvPropFile();
			sPlatform = oReadEnvProp.getPlatform();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sPlatform;
	}
}