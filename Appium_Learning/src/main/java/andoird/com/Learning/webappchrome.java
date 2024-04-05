package andoird.com.Learning;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

public class webappchrome {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		dc.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
		//dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability("chromedriverExecutable","C:\\Users\\bharadwaj.viswanatha\\git\\mobileautomationlearning\\Appium_Learning\\chromedriver-win64\\chromedriver.exe");
		URL url =new URL("http://10.100.102.98:4723/");
		

		
		AppiumDriver driver = new AppiumDriver(url,dc);
		String platformName = driver.getCapabilities().getCapability("platformName").toString();
		System.out.println("Platform Name: " + platformName);

		// Get the platform version
		String platformVersion = driver.getCapabilities().getCapability("platformVersion").toString();
		System.out.println("Platform Version: " + platformVersion);

		// Get the device name
		String deviceName = driver.getCapabilities().getCapability("deviceName").toString();
		System.out.println("Device Name: " + deviceName);

		// Get the app package
		String appPackage = driver.getCapabilities().getCapability("appPackage").toString();
		System.out.println("App Package: " + appPackage);

		// Get the app activity
		String appActivity = driver.getCapabilities().getCapability("appActivity").toString();
		System.out.println("App Activity: " + appActivity);
		
		
		String deviceVersion = driver.getCapabilities().getCapability("platformVersion").toString();
		System.out.println("Device Version: " + deviceVersion);

		// Get other capabilities as needed...

		driver.get("https://google.com");
		
	}

}
