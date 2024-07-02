package andoird.com.Learning;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class Tata_Siddhi {

	private static AppiumDriver driver;


	@Test
	public void tc01_App_Launch() throws IOException, InterruptedException {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
		dc.setCapability("udid", "emulator-5554");
		dc.setCapability("newCommandTimeout", 30);
//		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3a XL");
//		dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\bharadwaj.viswanatha\\Downloads\\SAUDA APP 1.apk");
		dc.setCapability("appPackage", "com.tataaia.siddhi");
		dc.setCapability("appActivity", "com.tataaia.siddhi.MainActivity");
		dc.setCapability("noReset", false);

		URL url = new URL("http://localhost:4723/");
	
		driver = new AndroidDriver(url, dc);

		System.out.println("Application started...");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));


	}

	@Test(priority = 1)
	public void tc02_Onboarding_Screens_SlideAnimation() throws InterruptedException {

		PageFactory.initElements(driver, Tata_PageObjects.class);


		// Navigating to Onboarding Screens
		Tata_PageObjects.onboardingScreen(driver).click();
		Tata_PageObjects.next_Btn.click();
		Tata_PageObjects.next_Btn.click();
		Tata_PageObjects.getStarted_Btn.click();



	}

	@Test(priority = 2)
	public void tc03_Login_using_Credentials() throws IOException, InterruptedException {


		PageFactory.initElements(driver, Tata_PageObjects.class);
		// Entering the Agent Code
		Thread.sleep(3000);
		Tata_PageObjects.agentCode.click();
		Tata_PageObjects.agentCode.sendKeys("46802");

		// Entering the Password
		Thread.sleep(3000);
		Tata_PageObjects.password.click();
		Tata_PageObjects.password.sendKeys("Talic&564");

		// Click Login
		Tata_PageObjects.login_Btn.click();

		Thread.sleep(6000);

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("login.png");
		FileUtils.copyFile(sourceFile, destinationFile);


		// Click 'Continue Here' to Login to Siddhi App on new device
		Tata_PageObjects.continueHere_Btn.click();

		// Setup Easy Login - Skip PIN/Biometric Access
		Tata_PageObjects.biometricSkip_Btn.click();

		// testCase = extentReport.createTest("TC04_Footer Menu Tab Switching Verification");
		// Self Service Menu
		Thread.sleep(3000);
		action_clickOnPosition(490, 1417);
		// More Tab
		Thread.sleep(3000);
		action_clickOnPosition(636, 1399);
		// Home Menu
		Thread.sleep(3000);
		action_clickOnPosition(64, 1397);

	}

	@Test(priority = 3)
	public void tc04_Switching_to_External_Apps() throws InterruptedException {

		PageFactory.initElements(driver, Tata_PageObjects.class);
		// My Apps Menu
		Thread.sleep(6000);
		action_clickOnPosition(357, 1371);

		// Navigate to Raksha Connect
		Tata_PageObjects.rakshaConnect_App.click();
		// Switch back to TATA AIA Siddhi App (assuming back button is used)
		driver.navigate().back();

		// Navigate to Good Connect
		Tata_PageObjects.goodConnect_App.click();
		// Switch back to TATA AIA Siddhi App (assuming back button is used)
		Thread.sleep(3000);
		driver.navigate().back();

		// Navigate to Sell Online
		Tata_PageObjects.sellOnline_App.click();
		// Switch back to TATA AIA Siddhi App (assuming back button is used)
		Thread.sleep(3000);
		driver.navigate().back();

		// Navigate to ISIS
		Tata_PageObjects.ISIS_App.click();
		// Switch back to TATA AIA Siddhi App (assuming back button is used)
		Thread.sleep(3000);
		driver.navigate().back();

	}

	@Test(priority = 4)
	public void tc05_Switching_to_Raksha_Connect() throws InterruptedException {

		PageFactory.initElements(driver, Tata_PageObjects.class);

		Thread.sleep(6000);

		// My Apps Menu
		action_clickOnPosition(357, 1371);

		// Navigate to Raksha Connect
		Tata_PageObjects.rakshaConnect_App.click();

		// Handling Invalid User - Login Alert
		Tata_PageObjects.invalidUser_Login.click();
		Tata_PageObjects.invalidUser_Login.click();

		// Raksha Connect App login
		Thread.sleep(3000);
		Tata_PageObjects.rakshaUser_Id.click();
		Tata_PageObjects.rakshaUser_Id.sendKeys("46802");
		Thread.sleep(5000);
		Tata_PageObjects.rakshaLogin_Pwd.click();
		Tata_PageObjects.rakshaLogin_Pwd.sendKeys("Talic&564");
		Tata_PageObjects.rakshaLogin_Btn.click();

		// Raksha Connect User Login Invalid - Alert
		Tata_PageObjects.invalidUser_Login.click();

		// Switch back to TATA AIA Siddhi App (assuming back button is used)
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();

	}

	// Click Element
	public static void action_clickOnPosition(int pointA_X, int pointA_Y) {
		PointerInput finger = new PointerInput(org.openqa.selenium.interactions.PointerInput.Kind.TOUCH, "finger");
		org.openqa.selenium.interactions.Sequence clickPosition = new org.openqa.selenium.interactions.Sequence(finger,
				1);
		clickPosition.addAction(finger.createPointerMove(Duration.ZERO, Origin.viewport(), pointA_X, pointA_Y))
		.addAction(finger.createPointerDown(MouseButton.LEFT.asArg()))
		.addAction(finger.createPointerUp(MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(clickPosition));
	}



	//		@BeforeSuite
	//		public void reportSetup() {
	//			extentReport = new ExtentReports();
	//			spark = new ExtentSparkReporter("index.html");
	//			spark.config().setReportName("Automation Report");
	//			spark.config().setTheme(Theme.DARK);
	//			extentReport.attachReporter(spark);
	//		}
	//
	//		@AfterSuite
	//		private void reportTearDown() {
	//			extentReport.flush();
	//		}

}


