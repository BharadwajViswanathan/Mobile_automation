package com.Driver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.ExtentReport.ExtentReport;
import com.configure.Factory;
import com.configure.config;
import com.tests.BaseClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Driver {

	public static AndroidDriver driver;
	public static SoftAssert Softassert;

	public static Properties prop;


	@BeforeSuite
	public static void BeforeLaunchingbrowser() throws IOException {
		config.Getdatafrompropertiesfile();
		Softassert=new SoftAssert();
	}
	
	@BeforeMethod
	public static void LaunchBrowser() throws MalformedURLException{

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME,prop.getProperty("Platformname"));
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Uiautomator2");
		cap.setCapability("appPackage",prop.getProperty("appPackage"));
		cap.setCapability("appActivity",prop.getProperty("appActivity"));
		cap.setCapability("autoGrantPermissions",prop.getProperty("autoGrantPermissions"));
		URL url = new URL("http://10.100.102.98:4723/");
		driver = new AndroidDriver(url, cap);
		Deviceinfo();
		BaseClass.implictwait(10);
		Factory.initelements();
		
	}
	/**
	 * Close the Browser
	 * @throws IOException 
	 */
	@AfterMethod
	public void CloseBrowser() throws IOException {
		driver.quit();
		Softassert.assertAll();
	}

	public static void Deviceinfo() {
		ExtentReport.extent.setSystemInfo("PlatformName",driver.getCapabilities().getCapability("platformName").toString());
		ExtentReport.extent.setSystemInfo("platformVersion",driver.getCapabilities().getCapability("platformVersion").toString());
		ExtentReport.extent.setSystemInfo("deviceName",driver.getCapabilities().getCapability("deviceName").toString());
		ExtentReport.extent.setSystemInfo("appPackage",driver.getCapabilities().getCapability("appPackage").toString());
		ExtentReport.extent.setSystemInfo("appActivity",driver.getCapabilities().getCapability("appActivity").toString());
		
	}
}
