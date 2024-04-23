package com.tests;

import org.testng.annotations.Test;

import com.pom.Friendspom;

public class validate_add_friends_through_contract extends BaseClass{
	@Test(dependsOnMethods = "TC_001", description = "validate add friends through contract", enabled = true)
	private static void TC_003() {
		Friendspom.addfriendsthroughcontact(prop.getProperty("participantname"));
	}
}
