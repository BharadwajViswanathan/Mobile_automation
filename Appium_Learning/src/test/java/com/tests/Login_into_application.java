package com.tests;

import org.testng.annotations.Test;

import com.configure.config;
import com.pom.Challengespom;
import com.pom.Friendspom;
import com.pom.Loginpom;
import com.pom.dashboardpom;
import com.pom.shoppom;

public class Login_into_application extends BaseClass {

	@Test(description = "Login into application",enabled=true)
	private static void TC_001() {
		Loginpom.Teamsandconditions();
		Loginpom.Login(prop.getProperty("mobilenumber"),prop.getProperty("testingemailname"));

		Loginpom.profile(prop.getProperty("profilename"), prop.getProperty("date"), prop.getProperty("month"),
				prop.getProperty("year"), prop.getProperty("height"), prop.getProperty("weight"),
				prop.getProperty("steps"));
	}

}
