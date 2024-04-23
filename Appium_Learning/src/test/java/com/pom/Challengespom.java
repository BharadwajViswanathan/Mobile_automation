package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tests.BaseClass;

public class Challengespom extends BaseClass{

	@FindBy(xpath="//android.widget.FrameLayout[@content-desc='Challenges']")
	private static WebElement Challengesfooter;

	@FindBy(xpath="//android.widget.Button[@text='Create a challenge']")
	private static WebElement createachallenge;

	@FindBy(xpath="//android.widget.EditText[@resource-id='com.noisefit:id/etName']")
	private static WebElement challengename;

	@FindBy(xpath="//android.widget.TextView[@text='Distance']")
	private static WebElement DistancechallengeType;

	@FindBy(xpath="//android.widget.TextView[@text='Steps']")
	private static WebElement StepschallengeType;
	@FindBy(xpath="//android.widget.TextView[@text='Calories']")
	private static WebElement CalorieschallengeType;

	@FindBy(xpath="//android.view.ViewGroup[@resource-id='com.noisefit:id/layoutTarget']//android.view.View[@resource-id='com.noisefit:id/layoutTarget1']")
	private static WebElement setchallangetarget;

	@FindBy(xpath="//android.view.ViewGroup[@resource-id='com.noisefit:id/layoutTarget']//android.widget.TextView[@resource-id='com.noisefit:id/tvTargetMin']")
	private static WebElement MinTarget;
	@FindBy(xpath="//android.view.ViewGroup[@resource-id='com.noisefit:id/layoutTarget']//android.widget.TextView[@resource-id='com.noisefit:id/tvTargetMax']")
	private static WebElement MaxTarget;
	@FindBy(xpath="//android.view.ViewGroup[@resource-id='com.noisefit:id/layoutTarget']//android.widget.TextView[@resource-id='com.noisefit:id/isb_progress']")
	private static WebElement targetprogess;
	@FindBy(xpath="//android.widget.TextView[@resource-id='com.noisefit:id/tvSearchFriend']")
	private static WebElement addparticipants;
	@FindBy(xpath="//android.widget.EditText[@resource-id='com.noisefit:id/tvSearchFriend']")
	private static WebElement searchparticipants;
	@FindBy(xpath="//android.widget.CheckBox[@resource-id='com.noisefit:id/checkbox']")
	private static WebElement participantscheckbox;
	@FindBy(xpath="//android.widget.Button[@resource-id='com.noisefit:id/btnSave']")
	private static WebElement participantssavebutton;
	@FindBy(xpath="//android.widget.Toast")
	private static WebElement toastmessage;

	static String scrollandclickcreateChallengebutton="Create challenge";
	static String settarget="Set target";

	public static void createchallenge(String name,String participantsaname) {
		clickelement(Challengesfooter);
		clickelement(createachallenge);
		sendkeys(challengename, name);
		clickelement(StepschallengeType);
		wait3sec();
		scrollandselect(settarget);
		int seekBarWidth = setchallangetarget.getSize().getWidth();

		int startX = setchallangetarget.getLocation().getX();
		int yaxis = setchallangetarget.getLocation().getY();
		int endX = startX + seekBarWidth;
		print("StartX "+startX);
		print("yaxis "+yaxis);
		print("EndX "+endX);
		
//		seekbarscrollsuingtouchaction(startX,endX-20,yaxis);
//		print("Set Target value "+targetprogess.getText());
		clickelement(addparticipants);
		sendkeys(searchparticipants, participantsaname);
		clickelement(participantscheckbox);
		clickelement(participantssavebutton);
		wait3sec();
		scrollandselect(scrollandclickcreateChallengebutton);
	
	}

}
