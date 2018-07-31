package webform;
/*package tests.WebForm;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseClasses.Driver;
import steps.LoginSteps;

public class LoginTest extends LoginSteps {
	
	WebDriver driver=null;
	Driver driverObj=new Driver();
	LoginSteps loginStepsObj = new LoginSteps();
	SoftAssert softAssert=null;
	
	@BeforeClass
	private void startTest() throws IOException {
		driver=driverObj.createDriver();
		driver.get(driverObj.getUrl());
		driver.manage().window().maximize();
	}
	
	@Test(description="Verify login with valid credentials", priority=1,groups="Smoke")
	public void loginIntoApplication() throws IOException, InterruptedException{
		softAssert=new SoftAssert();
		loginStepsObj.login(driver, driverObj.getUsername(), driverObj.getPassword());
	}
	
	@AfterClass(alwaysRun=true)
	public void endTest(){
		driver.quit();
		driver=null;
	}
}
*/