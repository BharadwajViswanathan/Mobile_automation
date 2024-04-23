package com.tests;

import org.testng.annotations.Test;

import com.pom.Friendspom;

public class validate_add_friends_through_common_interest extends BaseClass {
	@Test(dependsOnMethods = "TC_001", description = "validate add friends through common interest", enabled = true)
	private static void TC_004() {
		Friendspom.addfriendsthroughcommoninterest();
		navigateback();
	}
}
