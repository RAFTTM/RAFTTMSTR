package com.raftt_m.or;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobOR_iOS {
	// ////////////////////////////GetAQuote//////////////////////////////
	// //////////////////////////////////////////////////////////////////

	@FindBy(xpath = "//UIAButton[@name='Ship']")
	public WebElement lnkShip;

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[3]")
	public WebElement lnkGetAQuote;

	@FindBy(xpath = "//UIAStaticText[@name='Get a Quote']")
	public WebElement txtGetAQuote;

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]")
	public WebElement txtOriginCity;

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[2]")
	public WebElement txtOriginZipCode;

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[3]")
	public WebElement txtDestinationCity;

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[4]")
	public WebElement txtDestinationZipCode;

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[5]")
	public WebElement txtWeight;

	@FindBy(xpath = "//UIAStaticText[@name='Additional shipping options']")
	public WebElement lnkAdditioanlShippingOptions;

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASwitch[2]")
	public WebElement chkboxDDO;

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAElement[4]")
	public WebElement DeliveryConfirmation;

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAElement[5]")
	public WebElement upsAccount;

	@FindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]")
	public WebElement btnContinueOnGetQuote;

	@FindBy(xpath = "//UIAStaticText[@name='Select a Service Level']")
	public WebElement txtServiceLevel;

	@FindBy(xpath = "//UIAStaticText[@name='UPS Ground']")
	public WebElement txtUPS_Ground;

	@FindBy(xpath = "//UIAStaticText[@name='Cost']")
	public WebElement txtCost;

	@FindBy(xpath = "//UIAStaticText[@name='Delivered by']")
	public WebElement txtDeliveredBy;

	@FindBy(xpath = "//UIAStaticText[@name='Package information']")
	public WebElement txtPackageInformation;

	@FindBy(xpath = "//UIAScrollView[1]/UIAStaticText[21]")
	public WebElement txtShipmentStatus;

	@FindBy(xpath = "//UIATableCell[1]/UIAStaticText[@name='UPS ISMD']")
	public WebElement txtUPSISMD;

	// //////////////////////OR_TrackingDetails//////////////////////////////
	// ////////////////////////////////////////////////////////////////

	/*--------------------------- 
	 * Text objects add below 
	 *---------------------------*/
	@FindBy(xpath = "//UIAScrollView[1]/UIAStaticText[30]")
	public WebElement txtTrackingNoOnDetails;
	
	@FindBy(xpath = "//UIAButton[@name='soon to expire close icon']|//UIAButton[@name='Cancel']")
	public WebElement btnSetBack;
	
	@FindBy(xpath = "//UIANavigationBar[1]/UIAButton[1]")
	public WebElement btnback;

	WebDriver driver;

	public MobOR_iOS(WebDriver driver) {
		this.driver = driver;
		// PageFactory.initElements(driver, this);
		PageFactory.initElements(driver, this);
	}

}
