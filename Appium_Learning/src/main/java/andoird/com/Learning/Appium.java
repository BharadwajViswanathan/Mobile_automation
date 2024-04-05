package andoird.com.Learning;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;

public class Appium {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Oneplus");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Uiautomator2");
		cap.setCapability(MobileCapabilityType.APP,"C:\\Users\\bharadwaj.viswanatha\\Downloads\\ApiDemos-debug.apk");
		URL url = new URL("http://10.100.102.98:4723/");

		AndroidDriver driver=new AndroidDriver(url, cap);
		//		driver.hideKeyboard();

//		driver.pressKey(new KeyEvent(AndroidKey.A));
//		Util.scroll(Util.ScrollDirection.DOWN, 0.5);
//        Thread.sleep(1000);
//	driver.findElementByAndroidUIAutomator("new UiScrollable(new    UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"WebView\").instance(0))");
	
	
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		HashMap<String, String> scrollObject = new HashMap<>();
//		scrollObject.put("direction", "down");
//		js.executeScript("mobile: swipe", scrollObject);
		
		//Tap
		/*AndroidTouchAction touch = new AndroidTouchAction(driver);
		touch.tap(ElementOption.element(element)).perform();

		//Press
		AndroidTouchAction touch = new AndroidTouchAction(driver);
		touch.press(ElementOption.element(element)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).release().perform();

		//Long Press
		AndroidTouchAction touch = new AndroidTouchAction(driver);
		touch.longPress(ElementOption.element(element)).release().perform();

		//Swipe
		AndroidTouchAction touch = new AndroidTouchAction(driver);
		touch.longPress(ElementOption.element(driver.findElementByXPath("//[@content-desc=‘15’]"))).moveTo(ElementOption.element(driver.findElementByXPath("//[@content-desc=‘45’]"))).release().perform();

		//Scroll
		driver.findElementsByAndroidUIAutomator(“new UiScrollable(new UiSelector()).scrollIntoView(text(“yourText”));”);

		//Drag and drop
		AndroidTouchAction touch = new AndroidTouchAction(driver);
		touch.longPress(ElementOption.element(element)).moveTo(ElementOption.element()).release().perform();*/
		}
}
