package com.raftt_m.library;

import com.raftt_m.library.*;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

@SuppressWarnings("all")
public class Report extends LaunchLoginAndLogout {

	// Global variable declaration
	public static String reportFile, iterStatus, testStatus, screenshotFile,
			exeBy, fmtRepData, imgSize;
	public static String sReportFilePath;

	// logging methods
	// pass log with screenshot
	public static void passLogWithSS(AppiumDriver driver, ExtentTest logger,
			String validation) throws Exception {
			String path = Utils.captureSS(driver, logger, validation,"PASS");
	}

	// pass log with no screenshot
	public static void passLogWithoutSS(ExtentTest logger, String stepName,
			String validation) {

			LaunchLoginAndLogout launchLogout = new LaunchLoginAndLogout();
			logger.log(LogStatus.PASS, stepName, validation);
	}

	// fail log with screenshot
	public static void failLog(AppiumDriver driver, ExtentTest logger,
			String validation) throws Exception {
			String path = Utils.captureSS(driver, logger, validation,"FAIL");
	}

	// fail log without screenshot
	public static void failLogWithoutSS(ExtentTest logger, String validation) {
		logger.log(LogStatus.FAIL, validation);
	}

	// info without screenshot
	public static void infoLog(ExtentTest logger, String message) {
		logger.log(LogStatus.INFO, message);
	}

}