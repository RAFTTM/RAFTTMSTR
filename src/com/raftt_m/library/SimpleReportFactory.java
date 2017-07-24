package com.raftt_m.library;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class SimpleReportFactory {

	public static ExtentReports reporter;

	public static synchronized ExtentReports getReporter(String reportPath) {
		if (reporter == null) {
			reporter = new ExtentReports(reportPath, true,
					DisplayOrder.NEWEST_FIRST);
		}
		return reporter;
	}

	/**************************************************************
	 * Function Name - closeReporter Description - To close the ExtentReport
	 * object Test case - Parameters - Date created - 17th Nov 2016 Developed by
	 * - Deepak Kapdi Last Modified By -Piyush Ballal Last Modified Date
	 * -29/11/2016
	 ***************************************************************/
	public static synchronized void closeReporter(ExtentReports extent) {
		extent.flush();
		extent.close();
	}

}