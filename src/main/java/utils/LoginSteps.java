package utils;

import org.openqa.selenium.WebDriver;

import webform.LoginPage;

public class LoginSteps {

	LoginPage loginPageObj = new LoginPage();

	public void login(WebDriver driver, String username, String password) {
		loginPageObj.enterUsername(driver, username);
		loginPageObj.enterPassword(driver, password);
		loginPageObj.clickOnSignBtn(driver);
	}

}
