package testScripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.DashBoardPage_AV;


public class DashBoardTest_AV extends TestBase {

	@Test
	public void verifyWidgetsCountAndText() {
		
		DashBoardPage_AV dashBoardpage = new DashBoardPage_AV();
		
		System.out.println("VERIFY - Number of widgets on dashboard page");
		int totalWidgets = dashBoardpage.getNumberOfWidgets();
		Assert.assertEquals(totalWidgets, 9, "totalWidegets was not displayed as expected, expected was 9, actual widgets displayed "+ totalWidgets);
	
		List<String> listOfExpectedWidgetsText = new ArrayList<String>(
				Arrays.asList("Quick Access","Buzz Latest Posts", "My Actions",
						"Latest Documents", "Latest News", "Employees on Leave Today",
						"Time At Work", "Headcount by Location", "COVID-19 Report"));
		
		System.out.println("STEP - Get list of all widgets text");
		List<String> listOfActualWidgetsText = dashBoardpage.getAllWidgetsText();
		System.out.println(listOfActualWidgetsText);
	
		System.out.println("VERIFY - text of all widgets");
		Assert.assertEquals(listOfActualWidgetsText, listOfExpectedWidgetsText);
	}
	
	@Test
	public void verfiyProfileAboutContentTest() {
		DashBoardPage_AV dashboardPage = new DashBoardPage_AV();
		
		System.out.println("STEP - Mouse hover on Profile and Click on Settings");
		List<String> expectedProfileSettingOptions = new ArrayList<String>(Arrays.asList("Change Password", "About"));
		List<String> profileSettingOptions = dashboardPage.getSettingProfileOptions();
	
		System.out.println("VERIFY - Available setting options");
		Assert.assertEquals(profileSettingOptions, expectedProfileSettingOptions);
		
		System.out.println("STEP - Click on About link");
		dashboardPage.clickOnProfileAbout();
		
		SoftAssert softAssert = new SoftAssert();
		
		System.out.println("VERIFY - Company name");
		String companyName = "OrangeHRM (Pvt) Ltd(Parallel Demo)";
		softAssert.assertEquals(dashboardPage.getCompanyName(), companyName);
		
		System.out.println("VERIFY - Version");
		String version = "OrangeHRM 7.6.174705";
		softAssert.assertEquals(dashboardPage.getVersion(), version, "Expected version was " + version + " but displayed bersion was " + dashboardPage.getVersion());
		
		System.out.println("VERIFY - Employee");
		String employees = "95 (105 more allowed)";
		softAssert.assertEquals(dashboardPage.getEmployee(), employees);
		
		System.out.println("VERIFY - Users");
		String users = "81 (419 more allowed)";
		softAssert.assertEquals(dashboardPage.getUsers(), users);
		
		System.out.println("VERIFY - Renewal on");
		String Renewalon = "Fri, 30 Dec 2022";
		softAssert.assertEquals(dashboardPage.getRenewalOn(),Renewalon );
		
	}
		
}
