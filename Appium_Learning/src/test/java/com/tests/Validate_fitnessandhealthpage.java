package com.tests;

import org.testng.annotations.Test;

import com.pom.dashboardpom;

public class Validate_fitnessandhealthpage extends BaseClass {
	@Test(dependsOnMethods = "TC_001", description = "Validate fitness and health page", enabled = true)
	private static void TC_002() {
		dashboardpom.fitnessandhealth();
		navigateback();
		navigateback();

	}
}
