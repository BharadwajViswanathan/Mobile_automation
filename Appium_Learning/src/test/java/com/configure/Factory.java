package com.configure;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import com.Driver.Driver;
import com.pom.Challengespom;
import com.pom.Friendspom;
import com.pom.Loginpom;
import com.pom.dashboardpom;
import com.pom.shoppom;


public class Factory extends Driver {
		/**
	 * page factory init elements classes
	 */
	

	private static final String exentreportfolder= System.getProperty("user.dir") + "/extent-report/";
	private static String extentreportfilepath = "";

	public static String getExtentReportFilePath()  {
		if (extentreportfilepath.isEmpty()) {
			try {
				extentreportfilepath = createReportPath();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return extentreportfilepath;
	}
	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public static String createReportPath() throws IOException {
		File file=new File("./src/test/resources/config/data.properties");
		FileInputStream fis= new FileInputStream(file);
		Properties props = new Properties();
		props.load(fis);
		if (props.getProperty("overridereports").equalsIgnoreCase("no")) {
			return exentreportfolder + config.getcurrenttime() + "/index.html";
		} else {
			return exentreportfolder+ "/index.html";
		}
	}

	public static void initelements() {
	PageFactory.initElements(driver, Loginpom.class);
	PageFactory.initElements(driver, dashboardpom.class);
	PageFactory.initElements(driver, Challengespom.class);
	PageFactory.initElements(driver, Friendspom.class);
	PageFactory.initElements(driver, shoppom.class);
	}
}
