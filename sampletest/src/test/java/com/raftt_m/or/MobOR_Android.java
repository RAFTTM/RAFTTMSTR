package com.raftt_m.or;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobOR_Android {

	/*--------------------------- 
	 * Columns objects add below 
	 *---------------------------*/
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Display Settings')]/parent::*/parent::*//child::android.view.ViewGroup[3]"
			+ "| //android.widget.TextView[contains(@text,'Tracking Details')]/parent::*/parent::*//child::android.view.View[3]")
	public WebElement txtHidePastDeliveries;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Close')]")
	public WebElement txtCloseBtn;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Display Settings')]")
	public WebElement txtDisplaySettings;

	@FindBy(xpath = "//android.widget.EditText[contains(@text,'Enter a Tracking Number')]/parent::*//parent::*//parent::*//parent::*//parent::*//parent::*//child::android.view.ViewGroup[2]//android.view.ViewGroup[1]//android.view.ViewGroup[1]//android.widget.ListView[1]//android.widget.LinearLayout[1]//android.widget.TextView")
	public WebElement txtTrackingNumbers;

	@FindBy(xpath = "//*[@class='android.widget.Button' and @NAF='true' and @index='0']")
	public WebElement btnToastMessage;

	@FindBy(xpath = "//android.widget.Button[contains(@text,'More login options')] ")
	public WebElement btnloginoptions;

	// ////////////////////Web Driver///////////////////////////
	// ///////////////////////////////////////////////////////////

	WebDriver driver;

	public MobOR_Android(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
