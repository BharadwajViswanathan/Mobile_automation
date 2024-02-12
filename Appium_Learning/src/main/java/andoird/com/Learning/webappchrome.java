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
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability("chromedriverExecutable","C:\\Users\\bharadwaj.viswanatha\\git\\mobileautomationlearning\\Appium_Learning\\chromedriver-win64\\chromedriver.exe");
		URL url =new URL("http://10.100.102.98:4723/");
		AppiumDriver driver = new AppiumDriver(url,dc);
		driver.get("https://google.com");
	}

}
