package andoird.com.Learning;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.BASEPATH;

public class Start_And_Stroptheappiumserver {
	static AppiumDriverLocalService service;
	
	  
	@Test
	void launch() throws MalformedURLException {
		 service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
		            .usingAnyFreePort());
		    service.start();
	
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		dc.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability("chromedriverExecutable","C:\\Users\\bharadwaj.viswanatha\\git\\mobileautomationlearning\\Appium_Learning\\chromedriver-win64\\chromedriver.exe");
		URL url =new URL("http://10.100.102.98:4723/");
		AppiumDriver driver = new AppiumDriver(url,dc);
		driver.get("https://google.com");
		service.stop();
	}
}

