package com.tests;

import org.testng.annotations.Test;

import com.pom.Loginpom;

public class Login extends BaseClass {

	@Test
	private static void TC_001() {
		print("Started...");
		Loginpom.Login(prop.getProperty("mobilenumber"), prop.getProperty("profilename"), prop.getProperty("date"),
				prop.getProperty("month"), prop.getProperty("year"));
		print("Done");

	}
}
