package com.pom;

import java.awt.print.Printable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.configure.otp;
import com.google.inject.spi.Element;
import com.tests.BaseClass;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Loginpom extends BaseClass {

	@FindBy(xpath = "//android.widget.CheckBox")
	private static WebElement TCandprivacypolicycheckbox;

	@FindBy(xpath = "//android.widget.Button[@text='Agree and continue']")
	private static WebElement Agree_and_continuebutton;

	@FindBy(xpath = "//android.widget.Button[@text='Continue']")
	private static WebElement Continuebutton;

	@FindBy(xpath = "//android.view.View[@content-desc='Login via Email']")
	private static WebElement LoginviaEmail;

	@FindBy(xpath = "//android.widget.EditText[@content-desc='Enter Email Id here']")
	private static WebElement Enteremailid;

	@FindBy(xpath = "//android.widget.EditText[@resource-id='com.noisefit:id/etOtp']")
	private static WebElement Otpfield;

	@FindBy(xpath = "//android.widget.EditText[@content-desc='Enter Mobile number here']")
	private static WebElement Entermobilenumber;

	@FindBy(xpath = "//android.widget.Button[@text='Cancel']")
	private static WebElement Cancelbutton;

	@FindBy(xpath = "//android.widget.Button[@text='Yes']")
	private static WebElement Yesbutton;

	@FindBy(xpath = "//android.widget.TextView[contains(@text,'NOIFIT')]/../android.view.ViewGroup/android.widget.TextView")
	private static WebElement notificationmobileotp;

	@FindBy(xpath = "//android.widget.Button[@content-desc='Clear all notifications.']")
	private static WebElement notificationclearall;

	@FindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_one_time_button']")
	private static WebElement onlythistimelocationpermission;

	@FindBy(xpath = "//android.widget.Button[@text='Pair later']")
	private static WebElement pairlater;

	@FindBy(xpath = "//android.widget.Button[@text='Let’s do this']")
	private static WebElement profileletsdothisbutton;

	@FindBy(xpath = "//android.widget.EditText[@resource-id='com.noisefit:id/tvName']")
	private static WebElement profilename;

	@FindBy(xpath = "//android.widget.CompoundButton")
	private static List<WebElement> profileinterestcomponetElements;

	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']")
	private static WebElement permissionframe;

	@FindBy(xpath = "//android.widget.EditText[@resource-id='android:id/numberpicker_input']")
	private static List<WebElement> datepicker;

	@FindBy(xpath="(//android.widget.NumberPicker)[1]/android.widget.Button")
	private static WebElement previousmonthdatapicker;

	@FindBy(xpath="(//android.widget.NumberPicker)[2]/android.widget.Button")
	private static WebElement previousdatedatapicker;

	@FindBy(xpath="(//android.widget.NumberPicker)[3]/android.widget.Button")
	private static WebElement previousyeardatapicker;
	
	@FindBy(xpath="//android.widget.RadioButton[@resource-id='com.noisefit:id/ivMan']")
	private static WebElement manradiobutton;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.noisefit:id/btnImperial']")
	private static WebElement imperialtall;
	
	@FindBy(id="com.noisefit:id/rvHeight")
	private static WebElement heightvalues;

	public static void Login(String mobilenumber, String Profilename,String date,String month,String year) {
		if (!TCandprivacypolicycheckbox.isSelected()) {
			clickelement(TCandprivacypolicycheckbox);
			clickelement(Agree_and_continuebutton);
		} else {
			clickelement(Agree_and_continuebutton);
		}
		clickelement(Continuebutton);
		clickelement(LoginviaEmail);

		String emailid = otp.setemailid();
		sendkeys(Enteremailid, emailid);
		clickelement(Continuebutton);
		String emailotp = otp.getemailotp();
		sendkeys(Otpfield, emailotp);
		clickelement(Continuebutton);
		try {
			sendkeys(Entermobilenumber, mobilenumber);
			clickelement(Continuebutton);
			driver.openNotifications();
			String otp = Gettext(notificationmobileotp);
			String mobileotp = getnotificationotp(otp);
			clickelement(notificationclearall);
			sendkeys(Otpfield, mobileotp);
			clickelement(Continuebutton);
		} catch (WebDriverException e) {
			print("Login Successfull.....");
		}
		profile(Profilename, date, month, year);
	}

	static String getnotificationotp(String mobileotp) {
		String otp = null;
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(mobileotp);
		while (matcher.find()) {
			otp = matcher.group();
		}
		return otp;

	}

	private static void profile(String Profilename,String date,String month,String year) {
		// clickelement(onlythistimelocationpermission);
		clickelement(pairlater);
		clickelement(profileletsdothisbutton);
		sendkeys(profilename, Profilename);
		clickelement(Continuebutton);

		for (int i = 0; i < 5; i++) {
			int size = profileinterestcomponetElements.size();
			int random = (int) (Math.random() * size);
			if (profileinterestcomponetElements.get(random).getAttribute("checked").equals("false")) {
				clickelement(profileinterestcomponetElements.get(random));
			} else {
				--i;
			}
		}
		clickelement(Continuebutton);
		
		selectdate(datepicker.get(1),date,"date");
		selectdate(datepicker.get(0),month,"month");
		selectdate(datepicker.get(2),year,"year");
			
		clickelement(Continuebutton);
		clickelement(manradiobutton);
		clickelement(Continuebutton);
		clickelement(imperialtall);
		selectheightvalue();
		clickelement(Continuebutton);
	}
	
	private static void selectdate(WebElement element,String text,String field) {
		if(field.equalsIgnoreCase("month")){
			long startTime = System.currentTimeMillis();
			long endTime = startTime + 480000;
			while (System.currentTimeMillis() < endTime) {			
				if(element.getText().equalsIgnoreCase(text)) {	
					break;
				} else{
					clickelement(previousmonthdatapicker);
				}
			}
		}else if(field.equalsIgnoreCase("date")) {
			long startTime = System.currentTimeMillis();
			long endTime = startTime + 480000;
			while (System.currentTimeMillis() < endTime) {			
				if(element.getText().equalsIgnoreCase(text)) {	
					break;
				} else{
					clickelement(previousdatedatapicker);
				}
			}
		}else if(field.equalsIgnoreCase("year")) {
			long startTime = System.currentTimeMillis();
			long endTime = startTime + 480000;
			while (System.currentTimeMillis() < endTime) {			
				if(element.getText().equalsIgnoreCase(text)) {	
					break;
				} else{
					clickelement(previousyeardatapicker);
				}
			}
		}else {
			print("Invalid Date was entered");
		}
	}
	
	private static void selectheightvalue() {
	  driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()"
    		        + ".resourceId(\"com.noisefit:id/rvHeight\")).scrollIntoView("
    		        + "new UiSelector().text(\"46 in\"));"));
	}
}
