package testScripts;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.PredefinedActions;
import pages.LoginPage;
import utility.PropertyFileOpeartions;

public class TestBase {

	@BeforeMethod
	public void setUP() throws IOException {
		PropertyFileOpeartions fileOperations = new PropertyFileOpeartions(".//Config_AV/Setting_AV.Properties");
		String url = fileOperations.getKeyValue("url");
		PredefinedActions.start(url);
		
		LoginPage loginPage = new LoginPage();
		loginPage.login(fileOperations.getKeyValue("userName"),fileOperations.getKeyValue("password"));
	}

	@AfterMethod
	public void close() {
		PredefinedActions.closeBrowser();
	}
	
}

