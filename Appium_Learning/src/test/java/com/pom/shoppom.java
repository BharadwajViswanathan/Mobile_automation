package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.tests.BaseClass;

public class shoppom extends BaseClass{

	@FindBy(xpath="//android.widget.FrameLayout[@content-desc=\"Shop\"]")
	private static WebElement shopfooter;
	
	@FindBy(xpath="//div[@class='hamburger ']")
	private static WebElement shophamburger;
	
	@FindBy(xpath="//div[.='Smart Watch' and @class='head']")
	private static WebElement smartwatch;
	
	public static void shop() {

		clickelement(shopfooter);
		System.out.println(" get context"+driver.getContext());
		System.out.println(" get contexts "+driver.getContextHandles());
		
		clickelement(shophamburger);
		clickelement(smartwatch);
	}
}
