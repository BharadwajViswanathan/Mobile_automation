package andoird.com.Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import io.appium.java_client.AppiumDriver;

public class Tata_PageObjects extends Tata_Siddhi{
	
	public static WebElement onboardingScreen(AppiumDriver driver) {
		//Navigate to Onboarding Screens
		return driver.findElement(By.xpath("//android.view.View[@content-desc='1/3']"));
	}
	
	//Onboarding Screens Slide 1 & 2 : Skip Button
	@FindBy(xpath = "//android.view.View[@content-desc='Skip']")
	public static WebElement skip_Btn; 
	
	//Onboarding Screens Slide 1 & 2 : NEXT Button
    @FindBy(xpath = "//android.view.View[@content-desc='NEXT']")
	public static WebElement next_Btn; 
	
	//Onboarding Screen 1 : Single slideLogin
    @FindBy(xpath = "//android.view.View[@content-desc='1/3']")
   	public static WebElement slideLogin; 
    
    //Onboarding Screen 2 : Quick slideOneAccessTitle
    @FindBy(xpath = "//android.view.View[@content-desc='2/3']")
   	public static WebElement slideOneAccessTitle;  
    
    //Onboarding Screen 3 : Login
    @FindBy(xpath = "//android.view.View[@content-desc='3/3']")
	public static WebElement loginSlide; 
	
	//Onboarding Screen 3 : GET STARTED Button
	@FindBy(xpath = "//android.view.View[@content-desc='GET STARTED']")
	public static WebElement getStarted_Btn; 
	
	
	//Login Inputs : Agent Code
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.ImageView[5]")
	public static WebElement agentCode; 
	
	//Login Inputs : Password
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.EditText")
	public static WebElement password; 
	
	//Click Login Button 
	@FindBy(xpath = "//android.view.View[@content-desc='LOGIN']")
	public static WebElement login_Btn; 
	
		 
    //Click 'Continue Here' to Login to Siddhi App on new device
    @FindBy(xpath = "//android.view.View[@content-desc='CONTINUE HERE']")
 	public static WebElement continueHere_Btn; 
      
    //Setup Easy Login : Skip - PIN / Biometric Access
    @FindBy(xpath = "//android.view.View[@content-desc='SKIP']")
 	public static WebElement biometricSkip_Btn; 
    
    
    //Switching to External Apps - Raksha Connect
    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Raksha Connect']")
 	public static WebElement rakshaConnect_App; 
    
    //Raksha Connect - User Login - Invalid - Alert 
    @FindBy(xpath = "//android.widget.Button[@content-desc='OK']")
 	public static WebElement invalidUser_Login; 
    
    //Raksha Login Inputs : User ID
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")
 	public static WebElement rakshaUser_Id;
    
    //Raksha Login Inputs : Password
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")
 	public static WebElement rakshaLogin_Pwd;
    
    //Raksha Login Inputs : Continue
    @FindBy(xpath = "//android.widget.Button[@content-desc='Continue']")
 	public static WebElement rakshaLogin_Btn;
       
    
    //Switching to External Apps - Good Connect
    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Good Connect']")
 	public static WebElement goodConnect_App; 
    
    //Switching to External Apps - Sell Online
    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Sell Online']")
 	public static WebElement sellOnline_App; 
      
    //Switching to External Apps - ISIS
    @FindBy(xpath = "//android.widget.ImageView[@content-desc='ISIS']")
 	public static WebElement ISIS_App; 
    

    
    
    
    
/*    
     
    //Footer Menu Tabs - Reports
    @FindBy(xpath = "(//android.view.View[@content-desc='Reports'])[2]")
    //@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[3]")
    public static WebElement reports_tab; 
    
    //Footer Menu Tabs - My Apps
    @FindBy(xpath = "//android.view.View[@content-desc='My Apps']")
 	public static WebElement myApps_tab; 
    //Switch back from My Apps
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[1]")
 	public static WebElement navBack_btn; 
    
    //Footer Menu Tabs - Self Service
    @FindBy(xpath = "//android.view.View[@content-desc='Self Service']")
 	public static WebElement selfService_tab;
    
    //Footer Menu Tabs - More
    @FindBy(xpath = "//android.view.View[@content-desc='More']")
 	public static WebElement more_tab;
    
    
     
    //Profile Section Options Verification
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.ImageView[1]")
 	public static WebElement hamburgermenu;
    
    //Profile  Section
    @FindBy(xpath = "//android.view.View[@content-desc='SHARMA CONSULTANCY SERVICES SENIOR PARTNER']")
 	public static WebElement profileoption;
    
    
*/    
    


	
     

	 
     

     
     
}
