package com.pom;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ExtentReport.Extentlogger;
import com.tests.BaseClass;

public class Friendspom extends BaseClass{

	@FindBy(xpath="//android.widget.FrameLayout[@content-desc='Friends']")
	private static WebElement friends;

	@FindBy(xpath="//android.widget.Button[@text='Agree and continue']")
	private static WebElement agreeandcontinuebutton;
	@FindBy(xpath="//android.widget.ImageView[@resource-id='com.noisefit:id/ivAddFriend']")
	private static WebElement addfriends;
	@FindBy(id="com.noisefit:id/tvDesc")
	private static WebElement addcontactdesc;

	@FindBy(xpath="//android.widget.Button[@text='Continue']")
	private static WebElement continuebutton;
	@FindBy(xpath="//android.widget.EditText[@resource-id='com.noisefit:id/etSearch']")
	private static WebElement addcontactsearchfield;
	@FindBy(xpath="//android.widget.TextView[@text='Add']")
	private static WebElement addbutton;
	@FindBy(xpath="//android.widget.TextView[@text='Remove']")
	private static WebElement Removebutton;
	@FindBy(xpath="//android.widget.TextView[@text='Common Interests']")
	private static WebElement commoninterestpeoples;

	@FindBy(xpath="//android.widget.Button[@text='New post']")
	private static WebElement friendsnewpost;

	@FindBy(xpath="//android.view.ViewGroup[@resource-id='com.noisefit:id/lytEmptyPost']")
	private static WebElement addmedia;
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.noisefit:id/tvActivityRing']")
	private static WebElement activityrings;

	@FindBy(xpath="//android.widget.TextView[@text='Image 2']/parent::android.view.ViewGroup")
	private static WebElement postimage;

	@FindBy(xpath="//android.widget.TextView[@text='Layout']")
	private static WebElement layout;
	@FindBy(xpath="//android.widget.TextView[@text='Style 2']/parent::android.view.ViewGroup")
	private static WebElement poststyle;
	@FindBy(xpath="//android.widget.TextView[@text='Next']")
	private static WebElement nextbutton;
	@FindBy(xpath="//android.widget.EditText[@resource-id='com.noisefit:id/etTextCreator']")
	private static WebElement postcaption;
	@FindBy(xpath="//android.widget.TextView[@text='Post']")
	private static WebElement postbutton;

	@FindBy(xpath="//android.widget.ImageView[@resource-id='com.noisefit:id/ivAddedFriendCount']")
	private static WebElement addfriendsrequest;
	@FindBy(xpath="//android.widget.TextView[@text='Accept']")
	private static List<WebElement> acceptfriendrequest;

	@FindBy(xpath="//android.widget.TextView[@text='NoiseFit']/../..//android.widget.TextView[@text='Friend request accepted']")
	private static WebElement Friendsacceptednotification;
	@FindBy(xpath = "//android.widget.Button[@content-desc='Clear all notifications.']")
	private static WebElement notificationclearall;

	public static void addfriendsthroughcontact(String contactname) {
		clickelement(friends);
		clickelement(agreeandcontinuebutton);
		clickelement(addfriends);
		sendkeys(addcontactsearchfield, contactname);
		clickelement(addbutton);
		Softassert.assertTrue(Removebutton.isDisplayed());	

	}

	public static void addfriendsthroughcommoninterest() {
		clickelement(commoninterestpeoples);
		for(int i=0;i<5;i++) {
			try {
				sendkeys(addcontactsearchfield, randomcharacters());
				clickelement(addbutton);
				Softassert.assertTrue(Removebutton.isDisplayed());	
				addcontactsearchfield.clear();
			}
			catch(WebDriverException e) {
				addcontactsearchfield.clear();
				--i;
			}
		}
	}

	public static void postanactivity(String captionforpost) {
		clickelement(friendsnewpost);
		clickelement(addmedia);
		clickelement(activityrings);
		clickelement(postimage);
		clickelement(layout);
		clickelement(poststyle);
		clickelement(nextbutton);
		wait3sec();
		sendkeys(postcaption,captionforpost);
		clickelement(postbutton);
	}
	public static void acceptfriendrequest() {
		clickelement(friends);
		clickelement(addfriendsrequest);
		for (WebElement webElement : acceptfriendrequest) {
			clickelement(webElement);
			driver.openNotifications();
			Softassert.assertTrue(Friendsacceptednotification.isDisplayed());
			clickelement(notificationclearall);
		}
		navigateback();
		navigateback();

	}
}
