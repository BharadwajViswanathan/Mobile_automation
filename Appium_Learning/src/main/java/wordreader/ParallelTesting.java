package wordreader;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ParallelTesting {

	public AndroidDriver driver;

	@BeforeMethod
	@Parameters({ "deviceName", "platformVersion", "appiumServer", "udid" })
	public void setUp(String deviceName, String platformVersion, String appiumServer, String udid)
			throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", deviceName);
		caps.setCapability("platformVersion", platformVersion);
		caps.setCapability("udid", udid);
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.tataaia.siddhi");
		caps.setCapability("appActivity", "com.tataaia.siddhi.MainActivity");
		caps.setCapability("noReset", false);

		URL serverURL = new URL(appiumServer);
		driver = new AndroidDriver(serverURL, caps);
	}

	@Test
	public void loginTest() throws InterruptedException {
		Thread.sleep(8000);
		WebElement el1 = driver.findElement(By.xpath("//android.view.View[@content-desc='NEXT']"));
		el1.click();

		WebElement el2 = driver.findElement(By.xpath("//android.view.View[@content-desc='NEXT']"));
		el2.click();
		WebElement el3 = driver.findElement(By.xpath("//android.view.View[@content-desc='GET STARTED']"));
		el3.click();
		WebElement el4 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.ImageView[5]"));
		el4.click();
		el4.sendKeys("46802");
		WebElement el5 = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText"));
		el5.click();
		el5.sendKeys("Talic&564");
        driver.hideKeyboard();
		WebElement login_btn = driver.findElement(By.xpath("//android.view.View[@content-desc='LOGIN']"));
		login_btn.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement continueHere_Btn = driver
				.findElement(By.xpath("//android.view.View[@content-desc='CONTINUE HERE']"));
		continueHere_Btn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement biometricSkip_Btn = driver.findElement(By.xpath("//android.view.View[@content-desc='SKIP']"));
		biometricSkip_Btn.click();
	}
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
