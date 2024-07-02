package andoird.com.Learning;

import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.remote.MobileCapabilityType;
import io.opentelemetry.context.Context;

public class network_handing {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Oneplus");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Uiautomator2");
		cap.setCapability("appPackage", "com.tataaia.siddhi");
		cap.setCapability("appActivity", "com.tataaia.siddhi.MainActivity");
		cap.setCapability("noReset", false);
		URL url = new URL("http://10.100.102.98:4723/");

		AndroidDriver driver=new AndroidDriver(url, cap);
		ConnectionState connection = driver.get
		System.out.println(connection.getBitMask());
		System.out.println(connection.isDataEnabled());
		System.out.println(connection.isWiFiEnabled());
		System.out.println(connection.hashCode());
		System.out.println(connection);

	}
}
