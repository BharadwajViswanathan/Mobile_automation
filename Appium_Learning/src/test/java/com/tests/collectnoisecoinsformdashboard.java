package com.tests;

import org.testng.annotations.Test;

import com.pom.Loginpom;
import com.pom.dashboardpom;

public class collectnoisecoinsformdashboard extends BaseClass{
	
	@Test(dependsOnMethods = "TC_001", description = "Collect noise coins from the dashboard", enabled = true)
	private static void TC_007() {
		Loginpom.Login(null,prop.getProperty("testingemailname"));
		dashboardpom.collectcoins();
		navigateback();
		implictwait(3);
		navigateback();
}
}