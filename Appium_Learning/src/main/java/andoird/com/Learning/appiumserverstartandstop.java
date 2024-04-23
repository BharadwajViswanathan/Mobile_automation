package andoird.com.Learning;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


public class appiumserverstartandstop {
	public static AppiumDriverLocalService service;
	static String appium_nodepath="C:\\Program Files\\nodejs\\node.exe";
	static String appium_Js="C:\\Users\\bharadwaj.viswanatha\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\main.js";
	public static void startServer() {
	    Runtime runtime = Runtime.getRuntime();
	    try {
	        runtime.exec("cmd.exe /c start cmd.exe /k \"appium \"");
	        Thread.sleep(10000);
	    } catch (IOException | InterruptedException e) {
	        e.printStackTrace();
	    }
	}

	public static void stopServer() {
	    Runtime runtime = Runtime.getRuntime();
	    try {
	        runtime.exec("taskkill /F /IM node.exe");
	        runtime.exec("taskkill /F /IM cmd.exe");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	@Test
	public static void demo() throws MalformedURLException {
		startServer();
		DesiredCapabilities dc = new DesiredCapabilities();

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Oneplus");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Uiautomator2");
		cap.setCapability("appPackage", "com.instagram.android");
		cap.setCapability("appActivity", "com.instagram.mainactivity.InstagramMainActivity");
		URL url = new URL("http://10.100.102.98:4723/");

		AndroidDriver driver = new AndroidDriver(url, cap);
		WebElement username = driver.findElement(By.xpath(
				"//android.view.View[@text='Username, email or mobile number']/parent::android.view.ViewGroup/../android.widget.EditText"));
		username.sendKeys("93609579576");
	
		stopServer();
	}
}
