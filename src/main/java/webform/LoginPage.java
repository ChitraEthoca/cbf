package webform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.BasePage;

public class LoginPage extends BasePage{
	
	private By usernameFldLocator=By.id("username");
	private By passwordFldLocator=By.id("password");
	private By signinBtnLocator=By.id("Login");
	
	
	public void enterUsername(WebDriver driver,String userName){
		enterValue(driver, usernameFldLocator, userName);
	}
	
	public void enterPassword(WebDriver driver,String password){
		enterValue(driver, passwordFldLocator, password);	
	}
	
	public void clickOnSignBtn(WebDriver driver){
		waitForElementVisibility(driver, signinBtnLocator);
		driver.findElement(signinBtnLocator).click();
	}

}
