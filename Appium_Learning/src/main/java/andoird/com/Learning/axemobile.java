package andoird.com.Learning;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.deque.axe.AXE;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

public class axemobile {

	static AndroidDriver driver;

	public static void makeDriver() throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		dc.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
		//dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability("appPackage", "com.instagram.android");
		dc.setCapability("appActivity", "com.instagram.mainactivity.InstagramMainActivity");
		URL url =new URL("http://10.100.102.98:4723/");
		driver = new AndroidDriver(url,dc);
	}
	public static void main(String[] args) throws MalformedURLException {
		makeDriver();
		driver.get("https://www.impigertech.com/");
		URL scriptUrl = axemobile.class.getResource("/axe.min.js");
		org.json.JSONObject responseJSON = new AXE.Builder(driver, scriptUrl).analyze();
		JSONArray violations = responseJSON.getJSONArray("violations");
		if (violations.length() == 0) {
			System.out.println("No voilation");
		} else {
			AXE.writeResults("testAccessibilityWithWebElement", responseJSON);
			AXE.report(violations);
			System.out.println("there is voilation");
		}
		driver.quit();
	}

}


