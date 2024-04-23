package com.tests;

import org.testng.annotations.Test;

import com.pom.Friendspom;
import com.pom.Loginpom;
import com.pom.dashboardpom;

public class Accept_the_friend_request extends BaseClass{
	@Test(dependsOnMethods = "TC_001",description = "Accept the friend request", enabled = true)
	private static void TC_006() {
		dashboardpom.Logout();
		Loginpom.Login(null,prop.getProperty("existingemailname"));
		Friendspom.acceptfriendrequest();
		dashboardpom.Logout();
		
	}
}
