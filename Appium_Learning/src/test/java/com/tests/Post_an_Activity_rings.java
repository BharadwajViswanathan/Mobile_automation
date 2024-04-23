package com.tests;

import org.testng.annotations.Test;

import com.pom.Friendspom;

public class Post_an_Activity_rings extends BaseClass{
	@Test(dependsOnMethods = "TC_001", description = "Post an Activity rings", enabled = true)
	private static void TC_005() {
		Friendspom.postanactivity(prop.getProperty("captionforpost"));
		navigateback();
		navigateback();
	}
}
