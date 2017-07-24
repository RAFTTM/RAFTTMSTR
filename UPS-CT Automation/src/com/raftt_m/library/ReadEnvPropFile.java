/**************************************************************
   Class Name 			- ReadEnvPropFile
   Description			- Class for reading Env.Properties file
   Date created 		- 14-Nov-16
   Developed by 		- Deepak Kapdi
   Last Modified By		-
   Last Modified Date 	-
 ***************************************************************/

package com.raftt_m.library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadEnvPropFile {

	Properties oProp;
	FileInputStream Input;

	// Constructor ReadEnvPropFile for creating InputStream object
	public ReadEnvPropFile() throws IOException {
			try {
				Input = new FileInputStream(System.getProperty("user.dir")
						+ "/Env.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			oProp = new Properties();
			oProp.load(Input);
	}

	/**************************************************************
	 * Method Name - Release() Description - This method is used to retrieve the
	 * Release value from the Env.Properties file Date created - 15-Nov-16
	 * Developed by - Deepak Kapdi Last Modified By - Last Modified Date -
	 ***************************************************************/
	public String Release() {

		// Storing the value of 'Release' from the Evn.Properties file
		String sRelease = oProp.getProperty("Release");

		return sRelease;
	}

	/**************************************************************
	 * Method Name - testDataFile() Description - This method is used to
	 * retrieve the testDataFile value from the Env.Properties file Date created
	 * - 15-Nov-16 Developed by - Deepak Kapdi Last Modified By - Last Modified
	 * Date -
	 ***************************************************************/
	public String TestDataFile() {

		// Storing the value of 'TestDataFile' from the Evn.Properties file
		String sTestDataFile = oProp.getProperty("TestDataFile");

		return sTestDataFile;
	}

	/**************************************************************
	 * Method Name - objTimeOut() Description - This method is used to retrieve
	 * the objTimeOut value from the Env.Properties file Date created -
	 * 15-Nov-16 Developed by - Deepak Kapdi Last Modified By - Last Modified
	 * Date -
	 ***************************************************************/
	public String ObjTimeOutLong() {

		// Storing the value of 'ObjTimeOutLong' from the Evn.Properties file
		String ObjTimeOutLong = oProp.getProperty("ObjTimeOutLong");

		return ObjTimeOutLong;
	}

	public String ObjTimeOutShort() {

		// Storing the value of 'ObjTimeOutShort' from the Evn.Properties file
		String ObjTimeOutShort = oProp.getProperty("ObjTimeOutShort");

		return ObjTimeOutShort;
	}

	/**************************************************************
	 * Method Name - executedBy() Description - This method is used to retrieve
	 * the executedBy value from the Env.Properties file Date created -
	 * 15-Nov-16 Developed by - Deepak Kapdi Last Modified By - Last Modified
	 * Date -
	 ***************************************************************/
	public String ExecutedBy() {

		// Storing the value of 'Executed_By' from the Evn.Properties file
		String sExecutedBy = oProp.getProperty("Executed_By");

		return sExecutedBy;
	}

	/**************************************************************
	 * Method Name - host() Description - This method is used to retrieve the
	 * host value from the Env.Properties file Date created - 14-Nov-16
	 * Developed by - Deepak Kapdi Last Modified By - Last Modified Date -
	 ***************************************************************/
	public String host() {

		// Storing the value of 'host' from the Evn.Properties file
		String host = oProp.getProperty("host");

		return host;
	}

	/**************************************************************
	 * Method Name - Report_Path() Description - This method is used to retrieve
	 * the Report_Path value from the Env.Properties file Date created -
	 * 14-Nov-16 Developed by - Deepak Kapdi Last Modified By - Last Modified
	 * Date -
	 ***************************************************************/
	public String Report_Path() {

		// Storing the value of 'Report_Path' from the Evn.Properties file
		String Report_Path = oProp.getProperty("Report_Path");

		return Report_Path;
	}

	/**************************************************************
	 * Method Name - ssPath() Description - This method is used to retrieve the
	 * ssPath value from the Env.Properties file Date created - 14-Nov-16
	 * Developed by - Deepak Kapdi Last Modified By - Last Modified Date -
	 ***************************************************************/
	public String ssPath() {

		// Storing the value of 'Report_Path' from the Evn.Properties file
		String ssPath = oProp.getProperty("ssPath");

		return ssPath;
	}

	/**************************************************************
	 * Method Name - ReportsInFolders() Description - This method is used to
	 * retrieve the Reports folder from the Env.Properties file Date created -
	 * 15-Nov-16 Developed by - Deepak Kapdi Last Modified By - Last Modified
	 * Date -
	 ***************************************************************/
	public String ReportsInFolders() {

		return oProp.getProperty("ReportsInFolders");
	}

	/**************************************************************
	 * Method Name - ReportsInFolders() Description - This method is used to
	 * retrieve the platform from the Env.Properties file Date created -
	 * 03-Feb-17 Developed by - Ramakant Sharma Last Modified By - Last Modified
	 * Date -
	 ***************************************************************/
	public String getPlatform() {

		String platform = oProp.getProperty("Platform");
		return platform;
	}
}
