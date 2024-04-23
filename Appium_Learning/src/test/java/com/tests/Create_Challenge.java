package com.tests;

import org.testng.annotations.Test;

import com.configure.config;
import com.pom.Challengespom;
import com.pom.Loginpom;

public class Create_Challenge extends BaseClass {
	@Test(dependsOnMethods = "TC_001", description = "Create Challenge", enabled = true)
	private static void TC_008() {
		Challengespom.createchallenge(config.getcurrenttime(), prop.getProperty("participantname"));
		navigateback();
		navigateback();
	}
}
