package encryption;

import java.util.HashMap;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import utils.BasePage;
import utils.Driver;
import utils.Utils;
import utils.Input;
import utils.LoginSteps;
import webform.ExternalSingleRequestFormPage;

public class IE_CustomerContactPage_731_732_764_S1 extends BasePage {
	WebDriver driver;
	HashMap<String, String> localData;

	Driver driverObj = new Driver();
	ExternalSingleRequestFormPage ESRFStepObj = new ExternalSingleRequestFormPage();
	LoginSteps loginStepsObj = new LoginSteps();
	SoftAssert softAssert = null;
	Logger logger;
	String parentWindow = null;

	private By usernameFldLocator = By.id("username");
	private By passwordFldLocator = By.id("password");
	// WI with data like customer contact and ABAC.
	private By WINumberLocator = By.xpath("//*[contains(text(),'00438051')]");

	private By AsBilledAmountLocator = By.id("00No0000008cglP");
	private By AsCorrectedAmountLocator = By.id("00No0000008cglT");
	private By BilledDateFromLocator = By.id("00No0000008cglR");
	private By BilledDateToLocator = By.id("00No0000008cglS");
	private By CustomerAjAmountLocator = By.id("Case.00Nq0000001eZPe-_help");

	private By customerContactInputEle = By.xpath("//*[@id='00Nq0000000ZKwc']");

	@FindBy(id = "phSearchInput")
	WebElement searchBoxEle;

	@FindBy(xpath = "//th[@scope=\"row\"]")
	WebElement WorkItemNumELE;

	@FindBy(xpath = "//*[@name=\"new_customer_contact\"]")
	WebElement newCustContactBtnEle;

	@FindBy(xpath = "//select[@id=\"00Nq0000000iAXY\"]")
	private WebElement soxReqInfoEle;
	@FindBy(xpath = "(//a[contains(text(),'RR')])[position()=1]")
	private WebElement viewContactEle;
	@FindBy(xpath = "//*[@name=\"view_cc_b_customer_contact\"]")
	private WebElement viewCCBContactBtnEle;
	@FindBy(xpath = "(//*[@value=' Edit '])[position()=1]")
	private WebElement editWIBtnEle;
	@FindBy(xpath = "//*[@name=\"save\"]")
	private WebElement saveBtnEle;

	@FindBy(xpath = "//*[contains(text(),'Work Items about to ')]")
	private WebElement WIsaveSuccessfullConfirmEle;
	@FindBy(xpath = "//*[@title=\"Checked\"]//..")
	private WebElement customerContactLogWithABACCheckboxele;

	@FindBy(xpath = "//div[@id=\"00Nq0000000ZKwc_ileinner\"]")
	private WebElement customerIdMainPageEle;

	@FindBy(xpath = "//*[@id=\"PER_ID\"]")
	private WebElement personIDCCBScreenEle;

	@FindBy(xpath = "(//*[contains(text(),'Edit')])[position()=3]")
	private WebElement relatedRecordEditlinkEle;

	@FindBy(xpath = "//*[@id=\"00Nq00000017pTZ\"]")
	private WebElement correctionCheckBoxEle;

	// SOX information field locators.
	@FindBy(xpath = "//*[@id=\"00No0000008cglY\"]")
	private WebElement billedToAmountEle;
	@FindBy(xpath = "//*[@id=\"00No0000008cglX\"]")
	private WebElement billedFromDateEle;
	@FindBy(xpath = "//*[@id=\"00No0000008cglZ\"]")
	private WebElement billedToDateEle;

	@FindBy(xpath = "(//td[@class=\" dataCell  \"])[position()=1]")
	private WebElement CustContactLogEntryEle;

	// @FindBy(xpath = "(//*[contains(text(),'RR-')])[position()=1]")
	@FindBy(xpath = "(//*[contains(text(),'RR-')])")
	private WebElement customerRelatedRecNamEle;

	@FindBy(xpath = "(//*[contains(text(),'CC LOG-')])[position()=1]")
	private WebElement customerContactLogNameEle;

	@FindBy(xpath = "//*[@name=\"view_cc_b_customer_contact\"]")
	private WebElement viewCCBCustomerContactEle;

	@FindBy(xpath = "(//*[@aria-labelledby=\"D_L_CC_LOG_CONTENT\"])[position()=1]//..")
	private WebElement CCLogStatementEle;
	@FindBy(xpath = "//*[contains(text(),'CC LOG-')]")
	private WebElement CCLOGNumberEle;
	@FindBy(xpath = "//*[contains(text(),'As Billed/Corrected From:')]")
	private WebElement CCLOGEntryTextEle;

	@FindBy(xpath = "//*[@title='Log']")
	private WebElement LogTabCCBele;

	public IE_CustomerContactPage_731_732_764_S1() throws Exception {

		this.driver = Driver.initialization();
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(WebDriver driver, String userName) {
		enterValue(driver, usernameFldLocator, userName);
	}

	public void enterPassword(WebDriver driver, String password) {
		enterValue(driver, passwordFldLocator, password);
	}

	public void clickOnWIWithStatusBWO(WebDriver driver, By loc) {
		driver.findElement(loc).click();
	}

	public void loginIntoApplication() {

		Reporter.log("Step 1 Started- Loginto application");
		try {

			driver.get(driverObj.getUrlTestSalesforce());

			loginStepsObj.login(driver, driverObj.getUsernameCSRTestSalesforce(),
					driverObj.getPasswordCSRTestSalesforce());

			Reporter.log("Step 1 completed. Successfully logged into application");

		} catch (Exception E) {

			Reporter.log("Step 1- login failed" + E.getLocalizedMessage());
		}
	}

	public IE_CustomerContactPage_731_732_764_S1 navigateToWI_AddContact() throws Exception {
		Input data = new Input();

		Utils util = new Utils();
		// Step 2
		Thread.sleep(1000);
		util.customAlertByJS("Step 2 started");
		try {
			util.openWi("WiWithoutCustContact");
		}

		catch (Exception e) {

			Reporter.log("Step 2 failed- Unable to open work item" + e.getLocalizedMessage());

		}

		// Step 3
		util.customAlertByJS("Step 3 started");
		Reporter.log("Step 3 started- Adding new customer contact");

		try {

			Thread.sleep(1000);
			util.click(newCustContactBtnEle);

			Thread.sleep(1000);
			//enterValue(driver, customerContactInputEle,data.Read("IE_CustomerContactPage_731_732_764_S1_Test", "CustomerContactID", 1));
			driver.findElement(By.xpath("//*[@id=\"00Nq0000000ZKwc\"]")).sendKeys("5500474012");
			Select dropdown = new Select(driver.findElement(By.id("00Nq0000000ZKwf")));
			dropdown.selectByValue("SmartRate");
			Select dropdown_1 = new Select(driver.findElement(By.id("00Nq0000000ZKwg")));
			dropdown_1.selectByValue("SmartRate Note");
			Select soxReqInfoDropdown = new Select(soxReqInfoEle);
			soxReqInfoDropdown.selectByIndex(3);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"00No0000008cgnn\"]"))
					.sendKeys(data.Read("CustomerContactPage_731_732_764_S1_Test", "AdditionalComments", 1));
			//driver.findElement(By.xpath("//*[@id=\"00Nq0000000iAXX\"]")).sendKeys("Service Point");
			driver.findElement(By.xpath("//*[@id=\"00Nq0000000iAXX\"]")).sendKeys("4195573605");

			driver.findElement(By.xpath("//*[@name=\"save\"]")).click();
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(1000);
			Reporter.log(" Step 3 completed successfully- new customer contact added");
		}

		catch (Exception e) {
			Reporter.log(" Step 3 failed :" + e);
		}

		// Step 4
		util.customAlertByJS("Step 4 started");
		Reporter.log("Step 4 started -  View CC&B Customer Contact");
		try {

			/*			util.openWi("WiWithoutCustContact");
						Thread.sleep(1000);
						util.click(viewContactEle);*/
			String CustID1 = customerIdMainPageEle.getText();
			String parent = driver.getWindowHandle();
			util.click(viewCCBContactBtnEle);
			Thread.sleep(1000);

			Set<String> allWindows = driver.getWindowHandles();
			for (String winHandle : allWindows) {
				
				if (!winHandle.equals(parent)) {
					driver.switchTo().window(winHandle);
				}
			}
			//((JavascriptExecutor) driver).executeScript("window.focus();");
			// driver.switchTo().window(parent);

			// parentWindow = driver.getWindowHandle();
			// The after having clicked the link, you need to switch to the
			// other window.

			/*Set<String> allWindows = driver.getWindowHandles();
			for (String curWindow : allWindows) {
				driver.switchTo().window(curWindow);
			}*/

			// util.switchToWindow(1);
			// util.switchToTab(1);

			/// driver.switchTo().window("Login Page");
			driver.manage().window().maximize();
			util.CCBLogin();
			driver.getTitle();
			
			// driver.switchTo().defaultContent();

			Thread.sleep(1000);
			driver.switchTo().frame("main");
			driver.switchTo().frame("tabMenu");

			util.click(LogTabCCBele);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("main");
			driver.switchTo().frame("tabPage");

			WebElement CCBLOGID0 = driver.findElement(By.xpath("//*[@name=\"CC_LOG$CC_LOG_ID\"]"));
			try {
				Assert.assertTrue(CCBLOGID0.isDisplayed());

				Reporter.log("Step 4 is completed successfully");

			} catch (AssertionError e) {

				Reporter.log("Step 4 failed" + e.getLocalizedMessage());
			}
		} catch (Exception e) {
			Reporter.log("Step 4 failed" + e.getMessage());

		} finally {
			//driver.close();
			//driver.switchTo().window(parentWindow);
		}

		// Step 5
	/*	util.customAlertByJS(" Step 5 started");
		Reporter.log("Step 5 started - Related Record Verification");
		try {

			util.switchToWindow(0);
			//util.scrollToTop();
			GenericUtilities.clickOnWorkItems();
			util.openWi("WiWithoutCustContact");
			Thread.sleep(1000);
			util.scrollIntoView(customerRelatedRecNamEle);
			Thread.sleep(1000);
			Assert.assertTrue(customerRelatedRecNamEle.isDisplayed());
			Reporter.log(" Related records verification done");
			Reporter.log("STep 5 passed");
		}
		
		catch (AssertionError e) {
			Reporter.log("Step 5 failed"+e.getLocalizedMessage());

		}
		catch (Exception e) {
			Reporter.log("Step 5 failed"+e.getLocalizedMessage());

		}

		// step 6

		util.customAlertByJS("Step 6 started");
		Reporter.log("Step 6 started - Adding ABAC Info");
		try {
			util.openWi("WiWithoutCustContact");

			WebElement EditBtn = driver.findElement(By.xpath("//*[@title=\"Edit\"]"));
			util.click(EditBtn);
			Thread.sleep(2000);
			enterKeys(driver, AsBilledAmountLocator, "200");
			Thread.sleep(2000);
			enterKeys(driver, AsCorrectedAmountLocator, "100");
			Thread.sleep(2000);
			enterKeys(driver, BilledDateFromLocator, "6/15/2018");
			Thread.sleep(2000);
			enterKeys(driver, BilledDateToLocator, "6/18/2018");
			Thread.sleep(2000);
			// enterKeys(driver, CustomerAjAmountLocator, "190");
			Thread.sleep(2000);
			util.sendKeys(billedToAmountEle, "201");
			Thread.sleep(2000);
			util.sendKeys(billedFromDateEle, "6/14/2018");
			Thread.sleep(2000);
			util.click(billedToAmountEle);
			Thread.sleep(2000);
			util.sendKeys(billedToDateEle, "6/18/2018");
			Thread.sleep(2000);
			util.click(billedToAmountEle);
			Thread.sleep(2000);
			if (correctionCheckBoxEle.isSelected() == true) {
				correctionCheckBoxEle.click();
				Reporter.log(" unhecked correction check box");
			}
			driver.findElement(By.xpath("//*[@name=\"save\"]")).click();
			Reporter.log("ABAC info updated successfully");
			Thread.sleep(2000);
			Reporter.log("Edit WI and save successful");
		} catch (Exception e) {

			System.out.println(e);

			Reporter.log(" Step 6 failed" + e.getLocalizedMessage());
		}

		// Step 7

		// util.customAlertByJS(" Step 7 started");
		Reporter.log("Step 7 started - Inserting CC-Log Entry");
		try {
			util.openWi("WiWithoutCustContact");
			Thread.sleep(1000);

			util.click(customerRelatedRecNamEle);

			util.scrollIntoView(customerContactLogNameEle);
			Assert.assertTrue(customerContactLogNameEle.isDisplayed());

			String ABACLogEntry = CustContactLogEntryEle.getText();
			driver.navigate().back();
			//util.click(customerRelatedRecNamEle);
			util.click(viewCCBCustomerContactEle);
			util.switchToTab(1);

			try {
			
			util.CCBLogin(CCBUserIdEle, CCBPasswordEle, CCBLoginBtn);
			Reporter.log("CCB login done");
			}
			
			catch (Exception e) {
			
			Reporter.log("CCB already logged in");
			}
			driver.switchTo().frame("main");
			driver.switchTo().frame("tabPage");
			driver.switchTo().frame("CC_LOG_GRID");
			String CCBLOg = util.getText(CCLogStatementEle);
			Assert.assertEquals(ABACLogEntry.trim(), CCBLOg.trim());
			Reporter.log("SFDC and CC&B log entry verification done");

			util.switchToTab(0);
			util.click(customerContactLogNameEle);
			Thread.sleep(1000);
			Assert.assertTrue(customerContactLogWithABACCheckboxele.isDisplayed());

			Reporter.log("Step 7 completed successfully");

		}

		catch (AssertionError e) {

			Reporter.log("Step 7 failed" + e.getLocalizedMessage());
		} catch (Exception e) {

			Reporter.log("Step 7 failed" + e.getLocalizedMessage());
		}*/
		return this;
	}

}
