package andoird.com.Learning;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.api.client.util.Base64;
import com.google.common.io.Files;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;


public class Mobile_Gesture {

	public static void main(String[] args) throws InterruptedException, IOException {
		
	
		//
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Oneplus");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Uiautomator2");
		cap.setCapability("appPackage", "com.instagram.android");
		cap.setCapability("appActivity", "com.instagram.mainactivity.InstagramMainActivity");
		URL url = new URL("http://10.100.102.98:4723/");

		AndroidDriver driver = new AndroidDriver(url, cap);
		capturerecord(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));	
		WebElement username = driver.findElement(By.xpath(
				"//android.view.View[@text='Username, email or mobile number']/parent::android.view.ViewGroup/../android.widget.EditText"));
		username.sendKeys("93609579576");
		longpress(driver, username);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));	
		driver.findElement(By.xpath(
				"//android.view.View[@text='Password']//parent::android.view.ViewGroup/../android.widget.EditText"))
		.sendKeys("Test@123");
		driver.findElement(By.xpath("//android.view.View[@text='Log in']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.findElement(By.xpath("//android.view.View[@content-desc='Not now']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		//		driver.findElement(By.id("android:id/autofill_save_no")).click();
//		scrollandswipe(driver,"Left");
//		Thread.sleep(1000);
//		scrollandswipe(driver,"Right");
//	Thread.sleep(1000);
//		Tap(driver, 753,2163);
//		
//	
//			Thread.sleep(2000);
//			scrollandswipe(driver,"Down");
//			scrollandswipe(driver,"UP");

	}
	private static void Tap(AndroidDriver driver, int xaxis, int yaxis) {
		TouchAction action=new TouchAction(driver);
		action.tap(PointOption.point(xaxis,yaxis)).perform();
	}
	private static void doubleTap(AndroidDriver driver,Point cordinates) {
		TouchAction touch =new TouchAction(driver);
		TouchAction perform = touch.press(PointOption.point(cordinates)).release().perform().waitAction().press(PointOption.point(cordinates)).release().perform();
	}	 

	private static Point getCenterOfElement(Point location, Dimension size) {
		int centerx = ((int)location.getX()+size.getWidth() / 2);
		int centery = ((int)location.getY()+size.getWidth()/2);
		return new Point(centerx,centery);
	}

	private static void longpress(AndroidDriver driver,WebElement element) {
		TouchAction action =new TouchAction(driver);
		action.longPress(ElementOption.element(element)).perform();
	}

	private static void scrollandswipe(AndroidDriver driver, String direction) throws IOException {
		if(direction.equalsIgnoreCase("UP")){
			Dimension size = driver.manage().window().getSize();
			int start_x=size.getWidth() / 2;
			int start_y=size.getHeight() / 2;

			int end_x=start_x;
			int end_y=(int) (size.getHeight() * 0.25);


			TouchAction touch =new TouchAction(driver);
			touch.press(PointOption.point(start_x, start_y))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
			.moveTo(PointOption.point(end_x, end_y)).release().perform();
			System.out.println(start_x+" "+start_y+" "+direction);
			System.out.println(end_x+" End "+end_y+" "+direction);
		}else if(direction.equalsIgnoreCase("DOWN")) {
			Dimension size = driver.manage().window().getSize();
			int start_x=size.getWidth() / 2;
			int start_y = (int) (size.getHeight() * 0.75);		  
			int end_x=start_x;
			int end_y = size.getHeight() * 2; 
			TouchAction touch =new TouchAction(driver);
			touch.press(PointOption.point(start_x, start_y))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
			.moveTo(PointOption.point(end_x, end_y)).release().perform();
			System.out.println(start_x+" "+start_y+" "+direction);
			System.out.println(end_x+" End "+end_y+" "+direction);
		}else if(direction.equalsIgnoreCase("RIGHT")) {
			Dimension size = driver.manage().window().getSize();
			int start_x=size.getWidth() / 2;
			int start_y =size.getHeight() / 2;  
			int end_x=size.getWidth() * 2;
			int end_y = start_y;
			TouchAction touch =new TouchAction(driver);
			touch.press(PointOption.point(start_x, start_y))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
			.moveTo(PointOption.point(end_x, end_y)).release().perform();
			System.out.println(start_x+" "+start_y+" "+direction);
			System.out.println(end_x+" End "+end_y+" "+direction);
		}else if(direction.equalsIgnoreCase("LEFT")){
			Dimension size = driver.manage().window().getSize();
			int start_x=size.getWidth() / 2;
			int start_y =size.getHeight() / 2;		  
			int end_x=(int) (size.getWidth() *0.25) ;
			int end_y = start_y; 

			TouchAction touch =new TouchAction(driver);
			touch.press(PointOption.point(start_x, start_y))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
			.moveTo(PointOption.point(end_x, end_y)).release().perform();
			System.out.println(start_x+" "+start_y+" "+direction);
			System.out.println(end_x+" End "+end_y+" "+direction);		
			}else {
				System.out.println("Invalid Direction");
			}
		stoprecord(driver);
	}

	private static void capturerecord(AndroidDriver driver) {
		
//        AndroidStartScreenRecordingOptions options = new AndroidStartScreenRecordingOptions()
//                .withTimeLimit(Duration.ofMinutes(5)) // Set the time limit for recording
//                .withVideoSize("720x1280"); // Set the video size
        ((CanRecordScreen) driver).startRecordingScreen();
		  
	}
	private static void stoprecord(AndroidDriver driver) throws IOException {
		   String base64String = ((CanRecordScreen) driver).stopRecordingScreen();
	        byte[] data = Base64.decodeBase64(base64String);
	        File videoFile = new File("recordings/testVideo.mp4");
	        FileUtils.writeByteArrayToFile(videoFile, data);
        }
	
	}

