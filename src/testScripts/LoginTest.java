package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.PredefinedActions;
import pages.LoginPage;

public class LoginTest {

	@Test
	public void testCasec1() {
		System.out.println("STEP - Launch Chrome Browser & Hit url");
		PredefinedActions.start("https://avyas-trials77.orangehrmlive.com/auth/seamlessLogin");
		
		System.out.println("STEP - Enter valid login credentials");
		LoginPage loginPage = new LoginPage();
		loginPage.login("admin", "@Zk08fKYPd");
		
		System.out.println("VERIFY - home page is displayed");
		String expetedTitle = "Employee Management";
		String actualTitle = loginPage.getPageTitle();
		
		System.out.println("Aaradhy");
		System.out.println("mikku");
		
		Assert.assertEquals(actualTitle, expetedTitle, "Expected title was " + expetedTitle + " but actual title was " + actualTitle);
		
		PredefinedActions.closeBrowser();
	}
}
