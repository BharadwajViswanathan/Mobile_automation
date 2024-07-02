package andoird.com.Learning;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class axeautomation {
	static AndroidDriver driver;

	AndroidDriver makeDriver() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Oneplus 6");
		capabilities.setCapability("appPackage", "com.instagram.android");
		capabilities.setCapability("appActivity", "com.instagram.mainactivity.InstagramMainActivity");
		URL url = new URL("http://10.100.102.98:4723/");

		return new AndroidDriver(url, capabilities);
	}

	@BeforeMethod
	public void setup() throws MalformedURLException {
		driver = makeDriver();
	}

	@Test
	public void test() {

		AxeReport reporter = builder.withDriver(driver).analyze();

		List<AxeReporter.Violation> violations = reporter.results().violations();

		for (AxeReporter.Violation violation : violations) {
			System.out.println("Description: " + violation.description());
			System.out.println("Help: " + violation.help());
			System.out.println("Impact: " + violation.impact());
			System.out.println("Nodes: " + violation.nodes().size());
			// Print additional information if needed
			System.out.println("------------");
		}
	}



}


