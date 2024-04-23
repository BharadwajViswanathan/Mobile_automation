package com.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ExtentReport.Extentlogger;
import com.tests.BaseClass;

public class dashboardpom extends BaseClass{

	@FindBy(xpath="//android.widget.TextView[@text='Home']")
	private static WebElement Homefooter;

	@FindBy(xpath="//android.widget.ImageView[@resource-id='com.noisefit:id/ivProfileImage']")
	private static WebElement profileimageondashboard;

	@FindBy(xpath="//android.widget.TextView[@resource-id='com.noisefit:id/tvName']")
	private static WebElement profilename;

	@FindBy(xpath="//android.widget.TextView[@text='Logout']")
	private static WebElement Logout;
	@FindBy(xpath="//android.widget.TextView[@text='Delete Account']")
	private static WebElement deleteaccount;

	@FindBy(xpath="//android.widget.TextView[@text='Fitness and health']")
	private static WebElement fitnessandhealthoption;

	@FindBy(xpath="//android.view.ViewGroup[@resource-id='com.noisefit:id/rowMain']/android.widget.TextView")
	private static List<WebElement> listoffitnessandhealth;

	@FindBy(xpath="//android.view.ViewGroup[@resource-id='com.noisefit:id/layoutToolbar']//android.widget.TextView[@resource-id='com.noisefit:id/tvTitle']")
	private static WebElement Detailfitnesstoolbar;

	@FindBy(xpath="//android.widget.TextView[@text='Delete Account']")
	private static WebElement Deleteaccountbutton;

	@FindBy(xpath="//android.widget.Button[@text='Allow']")
	private static WebElement allowbutton;

	@FindBy(xpath="//android.view.View[@resource-id='com.noisefit:id/vCoinsBack']")
	private static WebElement coinbackindashboard;

	@FindBy(xpath="//android.widget.TextView[@text='Collect your Noise Coins']/../android.widget.ImageView[@resource-id='com.noisefit:id/ivTaskMore']")
	private static WebElement collectyournoisecoins;

	@FindBy(xpath="//android.widget.TextView[@text='Collect all']")
	private static WebElement collectall;

	public static void deleteaccount() {
		clickelement(Homefooter);
		clickelement(profileimageondashboard);
		clickelement(profilename);
		clickelement(deleteaccount);
		clickelement(allowbutton);
	}

	public static void fitnessandhealth() {
		clickelement(profileimageondashboard);
		clickelement(fitnessandhealthoption);
		for (int i=0;i<listoffitnessandhealth.size();i++) {
			wait3sec();
			String fitnessname = listoffitnessandhealth.get(i).getText();
			clickelement(listoffitnessandhealth.get(i));
			Softassert.assertEquals(Detailfitnesstoolbar.getText(), fitnessname);
			wait3sec();
			navigateback();

		}
	}
	public static void Logout() {
		clickelement(Homefooter);
		clickelement(profileimageondashboard);
		clickelement(profilename);
		clickelement(Logout);
		clickelement(allowbutton);
	}
	public static void collectcoins() {
		clickelement(coinbackindashboard);
		clickelement(collectyournoisecoins);
		clickelement(collectall);
		wait3sec();
	}
}
