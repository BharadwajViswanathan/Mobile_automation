package com.tests;

import org.testng.annotations.Test;

import com.pom.dashboardpom;

public class delete_an_account extends BaseClass{
	@Test(dependsOnMethods = "TC_001", description = "Delete an account", enabled = true)
	private static void TC_009() {
		dashboardpom.deleteaccount();
	}
}
