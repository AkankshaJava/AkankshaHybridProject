package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.PredefinedActions;

public class LoginPage extends PredefinedActions{

	public void login(String userName, String password) {
		enterUsername(userName);
		enterPassword(password);
		hitOnLoginBtn();
	}
	
	public void enterUsername(String userName) {
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		driver.findElement(By.id("txtPassword")).sendKeys(password);
	}
	
	public void hitOnLoginBtn() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	public boolean isUserNameErrorMsgeDisplayed() {
		WebElement userNameErrorMsg = driver.findElement(By.cssSelector("#txtUsername-error"));
		return userNameErrorMsg.isDisplayed();
	}
	
	public boolean isPasswordErrorMsgeDisplayed() {
		WebElement passwordErrorMsg = driver.findElement(By.cssSelector("#txtPassword-error"));
		return passwordErrorMsg.isDisplayed();
	}
	
	public boolean isLogoDisplayed() {
		return driver.findElement(By.cssSelector("div.organization-logo.shadow>img")).isDisplayed();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}
