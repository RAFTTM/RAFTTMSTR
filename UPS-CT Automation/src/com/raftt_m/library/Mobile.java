package com.raftt_m.library;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.raftt_m.or.MobOR_Android;
import com.raftt_m.or.MobOR_iOS;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@SuppressWarnings("rawtypes")
public class Mobile extends LaunchLoginAndLogout {
	static Logger log;
	static MobOR_iOS MobOR_iOS = null;
	static MobOR_Android MobOR_android = null;
	static String sPlatform = Utils.Platform();

	/**************************************************************
	 * Function Name - checkExistClick Description - To check object exists and
	 * click on it or not based on input Test case - Parameters - Date created -
	 * 17th Nov 2016 Developed by - Deepak Kapdi Last Modified By - Last
	 * Modified Date -
	 * 
	 * @return
	 * @throws Exception
	 ***************************************************************/
	public static void checkExistClick(AppiumDriver driver, ExtentTest logger,
			WebElement elm, String clickYesNo, String waitTimeShortOrLong,
			String objectName_PageName, String ssYesNo) throws Exception {
		String page[] = new String[2];
		page = objectName_PageName.split("_");

		if (waitTimeShortOrLong.equalsIgnoreCase("short")
				&& ssYesNo.equalsIgnoreCase("yes")) {
			waitShort.until(ExpectedConditions.visibilityOf(elm));
			Report.passLogWithSS(driver, logger, page[0] + " is displayed on "
					+ page[1] + " page");

		} else if (waitTimeShortOrLong.equalsIgnoreCase("short")
				&& ssYesNo.equalsIgnoreCase("no")) {
			waitShort.until(ExpectedConditions.visibilityOf(elm));

			Report.passLogWithoutSS(logger, "Validate " + page[0], page[0]
					+ " is displayed on " + page[1] + " page");

		} else if (waitTimeShortOrLong.equalsIgnoreCase("long")
				&& ssYesNo.equalsIgnoreCase("yes")) {
			waitLong.until(ExpectedConditions.visibilityOf(elm));
			Report.passLogWithSS(driver, logger, page[0] + " is displayed on "
					+ page[1] + " page");

		} else if (waitTimeShortOrLong.equalsIgnoreCase("long")
				&& ssYesNo.equalsIgnoreCase("no")) {
			waitLong.until(ExpectedConditions.visibilityOf(elm));

			Report.passLogWithoutSS(logger, "Validate " + page[0], page[0]
					+ " is displayed on " + page[1] + " page");

		}
		if (clickYesNo.equalsIgnoreCase("yes")) {
			Report.infoLog(logger, "Clicking on " + page[0]);
			if (elm.isEnabled()) {
				elm.click();
			}
		}
	}

	/**************************************************************
	 * Function Name - Click Description - Test case - Parameters - Date created
	 * - 29th Nov 2016 Developed by - Kamini Sengar Last Modified By - Last
	 * Modified Date -
	 * 
	 * @throws Exception
	 ***************************************************************/
	public static void Click(AppiumDriver<WebElement> driver, ExtentTest logger,
			WebElement elm, String waitTimeShortOrLong,
			String objectName_PageName, String ssYesNo) throws Exception {

		String page[] = new String[2];
		page = objectName_PageName.split("_");

		Report.infoLog(logger, "Clicking on " + page[0]);
		if (waitTimeShortOrLong.equalsIgnoreCase("short")
				&& ssYesNo.equalsIgnoreCase("yes")) {
			waitShort.until(ExpectedConditions.visibilityOf(elm));
			elm.click();
			Report.passLogWithSS(driver, logger, page[0] + " is displayed on "
					+ page[1] + " page");
		} else if (waitTimeShortOrLong.equalsIgnoreCase("short")
				&& ssYesNo.equalsIgnoreCase("no")) {
			waitShort.until(ExpectedConditions.visibilityOf(elm));
			elm.click();
			Report.passLogWithoutSS(logger, "Click On object", page[0]
					+ " is displayed on " + page[1] + " page");
		} else if (waitTimeShortOrLong.equalsIgnoreCase("long")
				&& ssYesNo.equalsIgnoreCase("yes")) {
			waitLong.until(ExpectedConditions.visibilityOf(elm));
			elm.click();
			Report.passLogWithSS(driver, logger, page[0] + " is displayed on "
					+ page[1] + " page");
		} else if (waitTimeShortOrLong.equalsIgnoreCase("long")
				&& ssYesNo.equalsIgnoreCase("no")) {
			waitLong.until(ExpectedConditions.visibilityOf(elm));
			elm.click();
			Report.passLogWithoutSS(logger, "Click On object", page[0]
					+ " is displayed on " + page[1] + " page");
		}
	}

	/**************************************************************
	 * Function Name - EnterText Description - Test case - Parameters - Date
	 * created - 29th Nov 2016 Developed by - Kamini Sengar Last Modified By -
	 * Last Modified Date -
	 * 
	 * @throws Exception
	 ***************************************************************/
	public static void EnterText(AppiumDriver driver, ExtentTest logger,
			WebElement elm, String TextToBeSend, String waitTimeShortOrLong,
			String objectName_PageName, String ssYesNo) throws Exception {
		String sPlatform = Utils.Platform();
		String page[] = new String[2];
		page = objectName_PageName.split("_");

		Report.infoLog(logger, "Clicking on " + page[0]);
		if (waitTimeShortOrLong.equalsIgnoreCase("short")
				&& ssYesNo.equalsIgnoreCase("yes")) {
			waitShort.until(ExpectedConditions.visibilityOf(elm));
			if (sPlatform.equalsIgnoreCase("iOS")) {
				elm.sendKeys(TextToBeSend);
				handleIOSKeyboard();
			} else {
				elm.sendKeys(TextToBeSend);
			}
			if(TextToBeSend.contains("\n"))
			{	
				Report.passLogWithSS(driver, logger, "Blank space is entered in edit box");
			}else {

				Report.passLogWithSS(driver, logger, TextToBeSend
						+ " is entered in edit box");
			}
		}

		else if (waitTimeShortOrLong.equalsIgnoreCase("short")
				&& ssYesNo.equalsIgnoreCase("no")) {
			waitShort.until(ExpectedConditions.visibilityOf(elm));
			if (sPlatform.equalsIgnoreCase("iOS")) {
				elm.sendKeys(TextToBeSend);
				handleIOSKeyboard();
			} else {
				elm.sendKeys(TextToBeSend);
			}
			if(TextToBeSend.contains("\n"))
			{	
				Report.passLogWithSS(driver, logger, "Blank space is entered in edit box");
			}else {

				Report.passLogWithSS(driver, logger, TextToBeSend
						+ " is entered in edit box");
			}

		} else if (waitTimeShortOrLong.equalsIgnoreCase("long")
				&& ssYesNo.equalsIgnoreCase("yes")) {
			waitLong.until(ExpectedConditions.visibilityOf(elm));
			if (sPlatform.equalsIgnoreCase("iOS")) {
				elm.sendKeys(TextToBeSend);
				handleIOSKeyboard();
			} else {
				elm.sendKeys(TextToBeSend);
			}
			if(TextToBeSend.contains("\n"))
			{	
				Report.passLogWithSS(driver, logger, "Blank space is entered in edit box");
			}else {

				Report.passLogWithSS(driver, logger, TextToBeSend
						+ " is entered in edit box");
			}

		}

		else if (waitTimeShortOrLong.equalsIgnoreCase("long")
				&& ssYesNo.equalsIgnoreCase("no")) {
			waitLong.until(ExpectedConditions.visibilityOf(elm));
			if (sPlatform.equalsIgnoreCase("iOS")) {
				elm.sendKeys(TextToBeSend);
				handleIOSKeyboard();
			} else {
				elm.sendKeys(TextToBeSend);
			}
			if(TextToBeSend.contains("\n"))
			{	
				Report.passLogWithSS(driver, logger, "Blank space is entered in edit box");
			}else {

				Report.passLogWithSS(driver, logger, TextToBeSend
						+ " is entered in edit box");
			}

		}
	}

	/**************************************************************
	 * Function Name - VerifyText Description - Test case - Parameters - Date
	 * created - 29th Nov 2016 Developed by - Kamini Sengar Last Modified By -
	 * Last Modified Date -
	 * 
	 * @throws Exception
	 ***************************************************************/
	public static void VerifyText(AppiumDriver driver, ExtentTest logger,
			WebElement elm, String TexttobeChecked, String waitTimeShortOrLong,
			String objectName_PageName, String ssYesNo) throws Exception {
		String sPlatform = Utils.Platform();
		String page[] = new String[2];
		String actual_Text;
		page = objectName_PageName.split("_");
		if (sPlatform.equalsIgnoreCase("iOS")) {
			actual_Text = elm.getAttribute("value").trim();
		} else {
			actual_Text = elm.getAttribute("text").trim();
		}

		if (waitTimeShortOrLong.equalsIgnoreCase("short")
				&& ssYesNo.equalsIgnoreCase("yes")) {
			waitShort.until(ExpectedConditions.visibilityOf(elm));
			if (actual_Text.equalsIgnoreCase(TexttobeChecked)) {
				Report.passLogWithSS(driver, logger, TexttobeChecked
						+ " is present on " + page[1] + " page");
			} else {
				Report.failLog(driver, logger, TexttobeChecked
						+ " is not matching with actual text " + actual_Text);
			}
		} else if (waitTimeShortOrLong.equalsIgnoreCase("short")
				&& ssYesNo.equalsIgnoreCase("no")) {
			waitShort.until(ExpectedConditions.visibilityOf(elm));
			if (actual_Text.equalsIgnoreCase(TexttobeChecked)) {
				Report.passLogWithoutSS(logger, "Verified", TexttobeChecked
						+ " is present on " + page[1] + " page");
			} else {
				Report.failLogWithoutSS(logger, TexttobeChecked
						+ " is not matching with actual text " + actual_Text);
			}
		} else if (waitTimeShortOrLong.equalsIgnoreCase("long")
				&& ssYesNo.equalsIgnoreCase("yes")) {
			waitLong.until(ExpectedConditions.visibilityOf(elm));
			if (actual_Text.equalsIgnoreCase(TexttobeChecked)) {
				Report.passLogWithSS(driver, logger, TexttobeChecked
						+ " is present on " + page[1] + " page");
			} else {
				Report.failLog(driver, logger, TexttobeChecked
						+ " is not matching with actual text " + actual_Text);
			}
		}

		else if (waitTimeShortOrLong.equalsIgnoreCase("long")
				&& ssYesNo.equalsIgnoreCase("no")) {
			waitLong.until(ExpectedConditions.visibilityOf(elm));
			if (actual_Text.equalsIgnoreCase(TexttobeChecked)) {
				Report.passLogWithoutSS(logger, "Verified", TexttobeChecked
						+ " is present on " + page[1] + " page");
			} else {
				Report.failLogWithoutSS(logger, TexttobeChecked
						+ " is not matching with actual text " + actual_Text);
			}
		}

	}

	/**************************************************************
	 * Function Name - SelectFromList Description - Test case - Parameters -
	 * Date created - 29th Nov 2016 Developed by - Kamini Sengar Last Modified
	 * By - Last Modified Date -
	 * 
	 * @throws Exception
	 ***************************************************************/
	public static void SelectFromList(AppiumDriver<WebElement> driver, ExtentTest logger,
			WebElement elm, String ItemToBeSelected,
			String waitTimeShortOrLong, String objectName_PageName,
			String ssYesNo) throws Exception {

		if (waitTimeShortOrLong.equalsIgnoreCase("short")
				&& ssYesNo.equalsIgnoreCase("yes")) {
			waitShort.until(ExpectedConditions.visibilityOf(elm));
			if (elm.isSelected()) {
				Select sel = new Select(elm);
				sel.selectByValue(ItemToBeSelected);
				Report.passLogWithSS(driver, logger, ItemToBeSelected
						+ " is selected from the list");
			} else {
				Report.failLog(driver, logger, ItemToBeSelected
						+ " is not selected from list box");
			}
		}

		else if (waitTimeShortOrLong.equalsIgnoreCase("short")
				&& ssYesNo.equalsIgnoreCase("no")) {
			waitShort.until(ExpectedConditions.visibilityOf(elm));
			if (elm.isSelected()) {
				Select sel = new Select(elm);
				sel.selectByValue(ItemToBeSelected);
				Report.passLogWithoutSS(logger,
						"Item to be selelcted from list", ItemToBeSelected
						+ " Item from list is selected");
			} else {
				Report.failLogWithoutSS(logger, ItemToBeSelected
						+ " is not selected from list box");
			}
		}

		else if (waitTimeShortOrLong.equalsIgnoreCase("long")
				&& ssYesNo.equalsIgnoreCase("yes")) {
			waitLong.until(ExpectedConditions.visibilityOf(elm));
			if (elm.isSelected()) {
				Select sel = new Select(elm);
				sel.selectByValue(ItemToBeSelected);
				Report.passLogWithSS(driver, logger, ItemToBeSelected
						+ " Item from list is selected");
			} else {
				Report.failLog(driver, logger, ItemToBeSelected
						+ " is not selected from list box");
			}
		}

		else if (waitTimeShortOrLong.equalsIgnoreCase("long")
				&& ssYesNo.equalsIgnoreCase("no")) {
			waitLong.until(ExpectedConditions.visibilityOf(elm));
			if (elm.isSelected()) {
				Select sel = new Select(elm);
				sel.selectByValue(ItemToBeSelected);
				Report.passLogWithoutSS(logger,
						"Item select succesfully from list", ItemToBeSelected
						+ " Item from list is selected");
			} else {
				Report.failLogWithoutSS(logger, ItemToBeSelected
						+ " is not selected from list box");
			}
		}
	}

	/**************************************************************
	 * Function Name - CheckUncheckRadioButton Description - Test case -
	 * Parameters - Date created - 29th Nov 2016 Developed by - Kamini Sengar
	 * Last Modified By - Last Modified Date -
	 * 
	 * @throws Exception
	 ***************************************************************/
	public static void CheckUncheckRadioButton(AppiumDriver<WebElement> driver,
			ExtentTest logger, WebElement elm, String CheckUncheck,
			String waitTimeShortOrLong, String objectName_PageName,
			String ssYesNo) throws Exception {
		String page[] = new String[2];
		page = objectName_PageName.split("_");

		if (waitTimeShortOrLong.equalsIgnoreCase("short")
				&& ssYesNo.equalsIgnoreCase("yes")) {
			waitShort.until(ExpectedConditions.visibilityOf(elm));
			if (elm.isDisplayed() && elm.isEnabled() && elm.isSelected()) {
				elm.click();
				Report.passLogWithSS(driver, logger, page[0]
						+ " Radio button is selected on " + page[1]);
			} else {
				Report.failLog(driver, logger, page[0] + " is not selected");
			}
		} else if (waitTimeShortOrLong.equalsIgnoreCase("short")
				&& ssYesNo.equalsIgnoreCase("no")) {
			waitShort.until(ExpectedConditions.visibilityOf(elm));
			if (elm.isDisplayed() && elm.isEnabled() && elm.isSelected()) {
				elm.click();
				Report.passLogWithoutSS(logger, "Radio button selection",
						page[0] + " Radio button is selected on " + page[1]);
			} else {
				Report.failLogWithoutSS(logger, page[0] + " is not checked");
			}
		} else if (waitTimeShortOrLong.equalsIgnoreCase("long")
				&& ssYesNo.equalsIgnoreCase("yes")) {
			waitLong.until(ExpectedConditions.visibilityOf(elm));
			if (elm.isDisplayed() && elm.isEnabled() && elm.isSelected()) {
				elm.click();
				Report.passLogWithSS(driver, logger, page[0]
						+ " radio button is selected on " + page[1]);
			} else {
				Report.failLog(driver, logger, page[0]
						+ " radio button is not selected on " + page[1]);
			}
		} else if (waitTimeShortOrLong.equalsIgnoreCase("long")
				&& ssYesNo.equalsIgnoreCase("no")) {
			waitLong.until(ExpectedConditions.visibilityOf(elm));
			if (elm.isDisplayed() && elm.isEnabled() && elm.isSelected()) {
				elm.click();
				Report.passLogWithoutSS(logger, "Select Radio button", page[0]
						+ " radio button is selected");
			} else {
				Report.failLog(driver, logger, page[0] + " is not checked on "
						+ page[1]);
			}
		}

	}

	/**************************************************************
	 * Function Name - GenerateRandomValue Description - Test case - Parameters
	 * - Date created - 29th Nov 2016 Developed by - Kamini Sengar Last Modified
	 * By - Last Modified Date -
	 ***************************************************************/
	public static int GenerateRandomValue(AppiumDriver driver,
			ExtentTest logger, WebElement elm, String objectName_PageName) {

		Random ran = new Random();
		int x = ran.nextInt();

		return x;

	}

	/**************************************************************
	 * Function Name - CheckUncheckCheckBoxButton Description - Test case -
	 * Parameters - Date created - 29th Nov 2016 Developed by - Kamini Sengar
	 * Last Modified By - Last Modified Date -
	 * 
	 * @throws Exception
	 ***************************************************************/

	public static void CheckUncheckCheckBoxButton(AppiumDriver driver,
			ExtentTest logger, WebElement elm, String CheckUncheck,
			String waitTimeShortOrLong, String objectName_PageName,
			String ssYesNo) throws Exception {

		String page[] = new String[2];
		page = objectName_PageName.split("_");

		boolean checkstatus;

		checkstatus = elm.isSelected();
		if (waitTimeShortOrLong.equalsIgnoreCase("short")
				&& ssYesNo.equalsIgnoreCase("yes")) {
			waitShort.until(ExpectedConditions.visibilityOf(elm));
			if (checkstatus == false) {
				elm.click();
				Report.passLogWithSS(driver, logger, CheckUncheck
						+ " is checked");
			} else {
				Report.failLog(driver, logger, page[0] + " is not checked on "
						+ page[1]);
			}
		}

		else if (waitTimeShortOrLong.equalsIgnoreCase("short")
				&& ssYesNo.equalsIgnoreCase("no")) {
			waitShort.until(ExpectedConditions.visibilityOf(elm));
			if (checkstatus == true) {
				Report.passLogWithSS(driver, logger, CheckUncheck
						+ "already checked ");
			} else {
				Report.failLogWithoutSS(logger, page[0] + " is not checked on "
						+ page[1]);
			}
		} else if (waitTimeShortOrLong.equalsIgnoreCase("long")
				&& ssYesNo.equalsIgnoreCase("yes")) {
			waitLong.until(ExpectedConditions.visibilityOf(elm));
			if (checkstatus == false) {
				elm.click();
				Report.passLogWithSS(driver, logger, CheckUncheck
						+ " is checked");
			} else {
				Report.failLog(driver, logger, page[0] + " is not checked on "
						+ page[1]);
			}
		}

		else if (waitTimeShortOrLong.equalsIgnoreCase("long")
				&& ssYesNo.equalsIgnoreCase("no")) {
			waitLong.until(ExpectedConditions.visibilityOf(elm));
			if (checkstatus == true) {
				Report.passLogWithSS(driver, logger, CheckUncheck
						+ "already checked ");
			} else {
				Report.failLogWithoutSS(logger, page[0] + " is not checked on "
						+ page[1]);
			}
		}

	}

	/**************************************************************
	 * Function Name - ClickDialogButton Description - Test case - Parameters -
	 * Date created - 03rd Dec 2016 Developed by - Deepak Kapdi Last Modified By
	 * - Last Modified Date -
	 * 
	 * @throws Exception
	 ***************************************************************/
	public static void ClickDialogButton(AppiumDriver driver,
			ExtentTest logger, String ButtonText_PopupMsg) throws Exception {
		boolean blnflag = false;
		String dialog[] = new String[2];
		dialog = ButtonText_PopupMsg.split("_");

		WebElement frameLayout = driver.findElement(By
				.className("android.widget.FrameLayout"));
		List<WebElement> obj = frameLayout.findElements(By
				.className("android.widget.Button"));

		int i = 0;

		while (!blnflag) {
			if (obj.get(i).getText().equalsIgnoreCase("OK")) {
				Report.passLogWithSS(driver, logger, dialog[0]
						+ " is displayed & clicked on " + dialog[1] + " dialog");
				obj.get(i).click();
				blnflag = true;
			} else if ((obj.get(i).getText().equalsIgnoreCase("Save"))) {
				Report.passLogWithSS(driver, logger, dialog[0]
						+ " is displayed & clicked on " + dialog[1] + " dialog");
				obj.get(i).click();
				blnflag = true;
			} else {
				/*
				 * Report.passLogWithSS(driver, logger, dialog[0] +
				 * " is Not displayed " + dialog[1] + " dialog");
				 * obj.get(i).click(); blnflag = false;
				 */
			}
			i++;
		}

	}

	/**************************************************************
	 * Function Name - ClickDialogButtonCancel Description - This is a duplicate
	 * method of ClickDialogButton() which is not a generic. Not sure where the
	 * above method is in use. So making another one.Test case - Parameters -
	 * Date created - 03rd Dec 2016 Developed by - Deepak Kapdi Last Modified By
	 * - Sindhu Nemani Last Modified Date - 19/1/2017
	 * 
	 * @throws Exception
	 ***************************************************************/
	public static void ClickDialogButtonCancel(AppiumDriver driver,
			ExtentTest logger, String ButtonText_PopupMsg, String sBtnText)
					throws Exception {
		boolean blnflag = false;
		String dialog[] = new String[2];
		dialog = ButtonText_PopupMsg.split("_");

		WebElement frameLayout = driver.findElement(By
				.className("android.widget.FrameLayout"));
		List<WebElement> obj = frameLayout.findElements(By
				.className("android.widget.Button"));

		int i = 0;

		while (!blnflag) {
			if (obj.get(i).getText().equalsIgnoreCase(sBtnText)) {
				Report.passLogWithSS(driver, logger, dialog[0]
						+ " is displayed & clicked on " + dialog[1] + " dialog");
				obj.get(i).click();
				blnflag = true;
			}
			i++;
		}

	}

	/**************************************************************
	 * Function Name - NavigateBack() Description - Test case - Parameters -
	 * Date created - 05th Dec 2016 Developed by - Deepak Kpadi Last Modified By
	 * - Last Modified Date -
	 * 
	 * @throws InterruptedException
	 ***************************************************************/
	public static void NavigateBack(AppiumDriver driver)
			throws InterruptedException {
		Thread.sleep(1000);

		driver.navigate().back();

		Thread.sleep(1000);

	}

	/**************************************************************
	 * Function Name - ClickSelectFrameObjects Description - Select radio
	 * buttons from frame Test case - Parameters - Date created - 20th Dec 2016
	 * Developed by - Deepak Kapdi Last Modified By - Last Modified Date -
	 * 
	 * @throws Exception
	 ***************************************************************/
	public static void ClickSelectFrameObjects(AppiumDriver<WebElement> driver,
			ExtentTest logger, String OptionToBeSelected_Popup)
					throws Exception {
		boolean blnflag = false;
		String dialog[] = new String[2];
		dialog = OptionToBeSelected_Popup.split("_");

		WebElement frameLayout = driver.findElement(By
				.className("android.widget.ListView"));
		List<WebElement> obj = frameLayout.findElements(By
				.className("android.widget.CheckedTextView"));

		int i = 0;

		while (!blnflag) {
			// if (obj.get(i).getText().equalsIgnoreCase(dialog[0])) {
			if (obj.get(i).getText().contains(dialog[0])) {
				Report.passLogWithSS(driver, logger, dialog[0]
						+ " is displayed & clicked on " + dialog[1] + " dialog");
				obj.get(i).click();
				blnflag = true;
			}
			i++;
		}

	}

	/**************************************************************
	 * Function Name - GenerateRandomValue Description - Test case - Parameters
	 * - Date created - 29th Nov 2016 Developed by - Kamini Sengar Last Modified
	 * By - Last Modified Date -
	 ***************************************************************/
	public static int GenerateRandomValue() {

		Random ran = new Random();
		int x = ran.nextInt();

		return x;

	}

	/**************************************************************
	 * Function Name - ClickSelectFrameObjects Description - Select radio
	 * buttons from frame Test case - Parameters - Date created - 23th Feb 2017
	 * Developed by - Ramakant Sharma Last Modified By - Last Modified Date -
	 * @throws IOException 
	 * @throws InterruptedException 
	 ***************************************************************/
	public static void selectDropDown(String dropDownProperty,String valToSelect) throws InterruptedException, IOException{
		IOSElement listObj=((IOSElement)driver.findElement(By.xpath(dropDownProperty)));
		listObj.setValue(valToSelect);
		IOSElement tableObj=((IOSElement)driver.findElement(By.name(valToSelect)));
		tableObj.click();
	}
}