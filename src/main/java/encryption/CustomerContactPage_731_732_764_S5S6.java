/*package encryption;

import java.util.HashMap;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import utils.BasePage;
import utils.GenericUtilities;


public class CustomerContactPage_731_732_764_S5S6 extends BasePage {
	WebDriver driver;
	HashMap<String, String> localData;
	ObjectRead objectRead;

	private By usernameFldLocator = By.id("username");
	private By passwordFldLocator = By.id("password");
	// WI with data like customer contact and ABAC.
	private By WINumberLocator = By.xpath("//*[contains(text(),'00438051')]");
	// private By WINumberLocator1 =
	// By.xpath("//*[contains(text(),'00442195')]");

	private By AsBilledAmountLocator = By.id("00No0000008cglP");
	private By AsCorrectedAmountLocator = By.id("00No0000008cglT");
	private By BilledDateFromLocator = By.id("00No0000008cglR");
	private By BilledDateToLocator = By.id("00No0000008cglS");
	private By CustomerAjAmountLocator = By.id("Case.00Nq0000001eZPe-_help");

	private By customerContactInputEle = By.xpath("//*[@id='00Nq0000000ZKwc']");
	@FindBy(xpath = "//*[@id='00Nq0000000jVKC_ileinner']")
	private WebElement cclogText;
	@FindBy(xpath = "//*[@class=\"pbError\"]")
	private WebElement generalErrorMessage;
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
	@FindBy(xpath = "//*[@id=\"00Nq00000017pTa_chkbox\"]")
	private WebElement customerContactLogWithABACCheckboxele;

	// CCB login details
	@FindBy(xpath = "//*[@id=\"userId\"]")
	private WebElement CCBUserIdEle;
	@FindBy(xpath = "//input[@id=\"password\"]")
	private WebElement CCBPasswordEle;
	@FindBy(xpath = "//input[@id=\"loginButton\"]")
	private WebElement CCBLoginBtn;

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

	public CustomerContactPage_731_732_764_S5S6(WebDriver driver, HashMap<String, String> localData) throws Exception {
		this.driver = driver;
		this.localData = localData;
		this.waitForPageLoad(driver);
		objectRead = new ObjectRead(this.getClass().getSimpleName());
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

	public CustomerContactPage_731_732_764_S5S6 loginIntoApplication(Hashtable<String, String> testData)
			throws Exception {

		Reporter.log("Step 1 Started- Loginto application");
		try {
			String username = getTestDataValue("CSR_User");
			String password = getTestDataValue("CSR_Password");
			enterUsername(driver, username);
			enterPassword(driver, password);
			// COC.webAdaptor(Actions.setValueToXpathAndClick, "Login");
			driver.findElement(By.xpath("//input[@id=\"Login\"]")).click();
			Thread.sleep(4000);

			Reporter.log("Step 1 completed. Successfully logged into application");

		} catch (Exception E) {

			Reporter.log("Step 1- login failed");
		}
		return this;
	}

	public CustomerContactPage_731_732_764_S5S6 clickOnWorkItems() throws Exception {
		COC.webAdaptor(Actions.setValueToXpathAndClick, "HomeTab");
		COC.webAdaptor(Actions.setValueToXpathAndClick, "WorkItemsTab");

		GenericUtilities util = new GenericUtilities();

		WebElement homebutton = driver.findElement(By.xpath("//*[@href=\"/home/home.jsp\"]"));

		util.click(homebutton);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[contains(text(),'Work Items')]")).click();

		return this;
	}

	public CustomerContactPage_731_732_764_S5S6 selectMyWI() throws Exception {
		Select dropdown = new Select(driver.findElement(By.id("fcf")));
		dropdown.selectByIndex(3);
		return this;
	}

	@SuppressWarnings("deprecation")
	public CustomerContactPage_731_732_764_S5S6 navigateToWI_AddContact(Hashtable<String, String> testData)
			throws Exception {

		GenericUtilities util = new GenericUtilities();
		// Step 2
		// Reporter.log("Step 2 started");

		try {

			util.customAlertByJS("Step 2 started- Opening work item");

			Reporter.log("Step 2 started - Opening work item");
			util.switchToTab(0);
			clickOnWorkItems();
			Reporter.log("Clicked on Work Items to get the WI lists");
			selectMyWI();
			String WIwithoutCustCOntact = BasePage.getTestDataValue("WiWithABACLogAndCloseBtn_S3S4");

			WebElement WIwithoutContact = driver
					.findElement(By.xpath("//*[contains(text(),'" + WIwithoutCustCOntact + "')]"));

			util.click(WIwithoutContact);

			WebElement WorkItemDetail = driver.findElement(By.xpath("//*[contains(text(),'Work Item Detail')]"));
			Assert.assertTrue(WorkItemDetail.isDisplayed());

			Reporter.log(" Step 22 completed successfully. Work Item is successfully opened.");
		}

		catch (AssertionError e) {

			Reporter.log("Step 22 failed: " + e);

		}

		catch (Exception e) {

			Reporter.log("Step 22 failed: " + e);

		}

		// Step 23

		util.customAlertByJS(" Step 23 started");
		try {
			Reporter.log("Step 23 started- Edit and Save");
			driver.findElement(By.xpath("//*[@title=\"Edit\"]")).click();
			Thread.sleep(2000);
			enterKeys(driver, AsBilledAmountLocator, "");
			enterKeys(driver, AsCorrectedAmountLocator, "");
			enterKeys(driver, BilledDateFromLocator, "");
			enterKeys(driver, BilledDateToLocator, "");
			// enterKeys(driver, CustomerAjAmountLocator, "");

			util.sendKeys(billedToAmountEle, "");
			util.sendKeys(billedFromDateEle, "");
			util.click(billedToAmountEle);
			Thread.sleep(2000);
			util.sendKeys(billedToDateEle, "");
			billedToAmountEle.click();
			Thread.sleep(2000);
			if (correctionCheckBoxEle.isSelected() == true) {
				correctionCheckBoxEle.click();

			}
			driver.findElement(By.xpath("//*[@name=\"save\"]")).click();

			util.highlighElement(generalErrorMessage);
			Assert.assertTrue(generalErrorMessage.isDisplayed());
			Thread.sleep(2000);

			Reporter.log("Step 23 completed successfully");

		} catch (Exception e) {

			Reporter.log(" Step 23 failed");
		}

		// Step 24 started

		util.customAlertByJS(" Step 24 started");
		try {
			Reporter.log("Step 24 started");

			driver.findElement(By.xpath("//*[@name=\"cancel\"]")).click();

			clickOnWorkItems();
			selectMyWI();
			String WIwithoutCustCOntact = BasePage.getTestDataValue("WiWithABACLogAndCloseBtn_S3S4");

			WebElement WIwithoutContact = driver
					.findElement(By.xpath("//*[contains(text(),'" + WIwithoutCustCOntact + "')]"));

			util.click(WIwithoutContact);

			util.click(customerRelatedRecNamEle);

			BasePage.captureScreenshot("Step 24 -Related Record Details");

			Reporter.log("Step 24 completed successfully.");
		}

		catch (Exception e) {

			Reporter.log("Step 24 failed");
		}

		// Step 25

		util.customAlertByJS(" Step 25 started ");
		Reporter.log("Step 25 started");
		try {
			driver.navigate().back();

			WebElement editWIBtn = driver.findElement(By.xpath("//*[@title=\"Edit\"]"));
			util.click(editWIBtn);
			Thread.sleep(2000);
			enterKeys(driver, AsBilledAmountLocator, "2000");
			enterKeys(driver, AsCorrectedAmountLocator, "1000");
			enterKeys(driver, BilledDateFromLocator, "3/19/2018");
			enterKeys(driver, BilledDateToLocator, "3/19/2018");
			// enterKeys(driver, CustomerAjAmountLocator, "196");

			util.sendKeys(billedToAmountEle, "201");
			util.sendKeys(billedFromDateEle, "3/19/2018");
			util.click(billedToAmountEle);
			Thread.sleep(2000);
			util.sendKeys(billedToDateEle, "3/19/2018");

			util.click(billedToAmountEle);

			if (correctionCheckBoxEle.isSelected() == true) {
				correctionCheckBoxEle.click();

			}

			driver.findElement(By.xpath("//*[@name=\"save\"]")).click();
			Thread.sleep(2000);
			Assert.assertTrue(WIsaveSuccessfullConfirmEle.isDisplayed());

			Reporter.log(" Edit WI and save successful");
			Reporter.log("Step 25 passed");

		} catch (AssertionError e) {

			Reporter.log("Step 25 has failed");
			System.out.println("Exception happened while saving WI" + e.getLocalizedMessage());
		} catch (Exception e) {

			Reporter.log("Step 25 has failed");
			System.out.println("Exception happened while saving WI" + e.getLocalizedMessage());
		}

		// Step 26

		util.customAlertByJS(" Step 26 started");

		Reporter.log("Step 26 started");
		try {
			clickOnWorkItems();
			selectMyWI();
			String WIwithoutCustCOntact = BasePage.getTestDataValue("WiWithABACLogAndCloseBtn_S3S4");

			WebElement WIwithoutContact = driver
					.findElement(By.xpath("//*[contains(text(),'" + WIwithoutCustCOntact + "')]"));

			util.click(WIwithoutContact);
			util.scrollIntoView(customerRelatedRecNamEle);
			util.highlighElement(customerRelatedRecNamEle);
			util.click(customerRelatedRecNamEle);
			String CCLOG = util.getText(CCLOGNumberEle);
			Reporter.log(" CCLOG Number is : " + CCLOG);
			util.click(CCLOGNumberEle);
			util.highlighElement(customerContactLogWithABACCheckboxele);
			Assert.assertTrue(customerContactLogWithABACCheckboxele.isDisplayed());
			util.highlighElement(cclogText);
			Assert.assertTrue(cclogText.isDisplayed());
			Reporter.log("CC log entry test is  :" + cclogText.getText());
			Reporter.log("Step 26 passed");

		} catch (AssertionError e) {

			Reporter.log("Step 26 failed" + e.getLocalizedMessage());
		}

		catch (Exception e) {

			Reporter.log("Step 26 failed" + e.getLocalizedMessage());
		}

		// Step 27 - Validating log in CC&B customer contact. wait 2 mins.

		Reporter.log("Step 27 started");

		util.customAlertByJS(" Step 27 started");

		try {
			clickOnWorkItems();
			selectMyWI();
			String WIwithoutCustCOntact = BasePage.getTestDataValue("WiWithABACLogAndCloseBtn_S3S4");

			WebElement WIwithoutContact = driver
					.findElement(By.xpath("//*[contains(text(),'" + WIwithoutCustCOntact + "')]"));

			util.click(WIwithoutContact);

			util.click(customerRelatedRecNamEle);
			Thread.sleep(2000);
			util.click(CCLOGNumberEle);
			String CClogLogID1 = driver.findElement(By.xpath("//*[@id=\"00Nq0000000jVKD_ileinner\"]")).getText();
			driver.navigate().back();
			util.click(viewCCBContactBtnEle);
			util.switchToTab(1);

			try {

				util.CCBLogin(CCBUserIdEle, CCBPasswordEle, CCBLoginBtn);
				Reporter.log("CCB login done");
			}

			catch (Exception e) {

				Reporter.log("CCB already logged in");
			}
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.switchTo().frame("main");
			Thread.sleep(2000);
			driver.switchTo().frame("tabMenu");
			Thread.sleep(2000);

			util.click(LogTabCCBele);
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.switchTo().frame("main");
			Thread.sleep(2000);
			driver.switchTo().frame("tabPage");
			Thread.sleep(2000);

			String CCBLOGID1 = driver.findElement(By.xpath("//*[@name=\"CC_LOG$CC_LOG_ID\"]")).getText();

			Assert.assertEquals(CClogLogID1, CCBLOGID1);

			System.out.println(" Log id " + CCBLOGID1 + " verification successful. Log Entry is updated correctly.");
		}

		catch (AssertionError e) {

			Reporter.log("Step 27- Assertions have failed :" + e);

		}

		catch (Exception e) {

			Reporter.log("Step 27 has failed :" + e);

		}

		// Step 28

		util.customAlertByJS(" Step 28 started");
		Reporter.log("Step 28 started");
		try {
			util.switchToTab(0);
			clickOnWorkItems();
			selectMyWI();
			String WIwithoutCustCOntact = BasePage.getTestDataValue("WiWithABACLogAndCloseBtn_S3S4");

			WebElement WIwithoutContact = driver
					.findElement(By.xpath("//*[contains(text(),'" + WIwithoutCustCOntact + "')]"));

			util.click(WIwithoutContact);

			Reporter.log(" Step 28 passed-Work item opened successfully");
		}

		catch (Exception e) {

			Reporter.log(" Step 28 has failed " + e);
		}

		// STep 29- No abac changes. Correction= checked & save- error should
		// come.

		util.customAlertByJS(" Step 29 started");
		Reporter.log("Step 29 started");
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@title=\"Edit\"]")).click();

			if (correctionCheckBoxEle.isSelected() == false) {
				correctionCheckBoxEle.click();

			}
			driver.findElement(By.xpath("//*[@name=\"save\"]")).click();
			Thread.sleep(1000);
			Assert.assertTrue(generalErrorMessage.isDisplayed());
			Reporter.log("Error message is :" + generalErrorMessage.getText());
			Reporter.log("Step 29 passed");
		} catch (AssertionError e) {
			System.out.println("Exception happened while saving WI" + e.getLocalizedMessage());
		} catch (Exception e) {
			System.out.println("Exception happened while saving WI" + e.getLocalizedMessage());
		}

		// Step 30 update all abac info to blank. correction= checked

		util.customAlertByJS(" Step 30 started");
		Reporter.log("Step 30 started");
		try {
			util.switchToTab(0);
			clickOnWorkItems();
			selectMyWI();
			String WIwithoutCustCOntact = BasePage.getTestDataValue("WiWithABACLogAndCloseBtn_S3S4");

			WebElement WIwithoutContact = driver
					.findElement(By.xpath("//*[contains(text(),'" + WIwithoutCustCOntact + "')]"));

			util.click(WIwithoutContact);
			
				driver.findElement(By.xpath("//*[@title=\"Edit\"]")).click();
			Thread.sleep(2000);
			enterKeys(driver, AsBilledAmountLocator, "");
			enterKeys(driver, AsCorrectedAmountLocator, "");
			enterKeys(driver, BilledDateFromLocator, "");
			enterKeys(driver, BilledDateToLocator, "");
			// enterKeys(driver, CustomerAjAmountLocator, "");

			util.sendKeys(billedToAmountEle, "");
			util.sendKeys(billedFromDateEle, "");
			util.click(billedToAmountEle);
			Thread.sleep(2000);
			util.sendKeys(billedToDateEle, "");
			billedToAmountEle.click();
			if (correctionCheckBoxEle.isSelected()==false) {
				correctionCheckBoxEle.click();
				Reporter.log(" Correction check box is checked");
			}
			driver.findElement(By.xpath("//*[@name=\"save\"]")).click();
			Thread.sleep(2000);

			Assert.assertTrue(WIsaveSuccessfullConfirmEle.isDisplayed());

			Reporter.log("Step 30 passed- Edit WI and save successful");
			
		} 
		catch (AssertionError e) {
			Reporter.log("Step 30 failed" + e.getLocalizedMessage());
		} 

		catch (Exception e) {
			Reporter.log("Step 30 failed" + e.getLocalizedMessage());
		}
		
		
				
		
		// Step 31

		util.customAlertByJS(" Step 31 started");
		Reporter.log(" Step 31 started");
		try {
			clickOnWorkItems();
			selectMyWI();
			String WIwithoutCustCOntact = BasePage.getTestDataValue("WiWithABACLogAndCloseBtn_S3S4");

			WebElement WIwithoutContact = driver
					.findElement(By.xpath("//*[contains(text(),'" + WIwithoutCustCOntact + "')]"));

			util.click(WIwithoutContact);

			util.click(customerRelatedRecNamEle);
			
			Thread.sleep(2000);
			util.click(CCLOGNumberEle);
			util.highlighElement(cclogText);
			Reporter.log(" CC log text is :"+cclogText.getText());
			util.highlighElement(customerContactLogWithABACCheckboxele);
			Assert.assertTrue(customerContactLogWithABACCheckboxele.isDisplayed());
			Reporter.log("Step 31 passed");
		}

		catch (AssertionError e) {

			Reporter.log(" Step 31 failed " + e.getLocalizedMessage());
		}
		catch (Exception e) {

			Reporter.log(" Step 31 failed " + e.getLocalizedMessage());
		}


		// step 32
		util.customAlertByJS(" Step 32 started");
		Reporter.log("Step 32 started");
		try {
			driver.navigate().back();

			util.click(CCLOGNumberEle);
			String CClogLogID2 = driver.findElement(By.xpath("//*[@id=\"00Nq0000000jVKD_ileinner\"]")).getText();
			driver.navigate().back();
			util.click(viewCCBContactBtnEle);
			util.switchToTab(1);
			// comment below login later.
			try {

				util.CCBLogin(CCBUserIdEle, CCBPasswordEle, CCBLoginBtn);
				Reporter.log("CCB login done");
			}

			catch (Exception e) {

				Reporter.log("CCB already logged in");
			}
			
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.switchTo().frame("main");
			Thread.sleep(2000);
			driver.switchTo().frame("tabMenu");
			Thread.sleep(2000);

			util.click(LogTabCCBele);
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.switchTo().frame("main");
			Thread.sleep(2000);
			driver.switchTo().frame("tabPage");
			Thread.sleep(2000);

			String CCBLOGID2 = driver.findElement(By.xpath("//*[@name=\"CC_LOG$CC_LOG_ID\"]")).getText();
			Assert.assertEquals(CClogLogID2, CCBLOGID2);
			
			Reporter.log("Step 32 passed");

		} catch (AssertionError e) {

			Reporter.log("Step 32 failed"+e.getLocalizedMessage());
			
		} catch (Exception e) {

			Reporter.log("Step 32 failed");
		}

		// Step 33- Update ABAC info with new values.

		util.customAlertByJS(" Step 33 started");
		try {
			Reporter.log("Step 33 started");
			util.switchToTab(0);
			clickOnWorkItems();
			selectMyWI();
			String WIwithoutCustCOntact = BasePage.getTestDataValue("WiWithABACLogAndCloseBtn_S3S4");

			WebElement WIwithoutContact = driver
					.findElement(By.xpath("//*[contains(text(),'" + WIwithoutCustCOntact + "')]"));

			util.click(WIwithoutContact);

			util.click(customerRelatedRecNamEle);

			BasePage.captureScreenshot("Step 33 -Related Record Details");
			Reporter.log("Step 33 passed- Screenshot captured");
		} catch (Exception e) {
			Reporter.log("Step 33 failed");
		}

		// Step 34- Update all ABAC info to new values

		util.customAlertByJS("Step 34 started");
		Reporter.log("Step 34 started");
		try {
			driver.navigate().back();
			driver.findElement(By.xpath("//*[@title=\"Edit\"]")).click();
			Thread.sleep(2000);

			enterKeys(driver, AsBilledAmountLocator, "230");
			enterKeys(driver, AsCorrectedAmountLocator, "5500");
			enterKeys(driver, BilledDateFromLocator, "3/14/2018");
			enterKeys(driver, BilledDateToLocator, "3/14/2018");
			// enterKeys(driver, CustomerAjAmountLocator, "176");

			util.sendKeys(billedToAmountEle, "281");
			util.sendKeys(billedFromDateEle, "6/15/2018");
			util.click(billedToAmountEle);
			Thread.sleep(2000);
			util.sendKeys(billedToDateEle, "6/15/2018");
			util.click(billedToAmountEle);
			Thread.sleep(2000);

			if (correctionCheckBoxEle.isSelected()==false) {
				correctionCheckBoxEle.click();
				Reporter.log(" Correction check box is checked");
			}
			driver.findElement(By.xpath("//*[@name=\"save\"]")).click();
			
			Assert.assertTrue(WIsaveSuccessfullConfirmEle.isDisplayed());
			
			Reporter.log("Step 34 passed");

		} catch (Exception e) {

			Reporter.log("Step 34 failed");
		}

		// step 35- Done till 34

		util.customAlertByJS(" Step 35 started");
		try {
			clickOnWorkItems();
			selectMyWI();
			String WIwithoutCustCOntact = BasePage.getTestDataValue("WiWithABACLogAndCloseBtn_S3S4");

			WebElement WIwithoutContact = driver
					.findElement(By.xpath("//*[contains(text(),'" + WIwithoutCustCOntact + "')]"));

			util.click(WIwithoutContact);

			util.click(customerRelatedRecNamEle);
			Thread.sleep(1000);
			util.click(CCLOGNumberEle);
			util.highlighElement(cclogText);
			Reporter.log(" CC log text is :"+cclogText.getText());
			util.highlighElement(customerContactLogWithABACCheckboxele);
			Assert.assertTrue(customerContactLogWithABACCheckboxele.isDisplayed());
			Reporter.log("Step 35 passed");
			
		} catch (AssertionError e) {

			Reporter.log("Step 35 failed" + e.getLocalizedMessage());
		} catch (Exception e) {

			Reporter.log("Step 35 failed"+e.getLocalizedMessage());
		}

		// 36 done till 35

		util.customAlertByJS(" Step 36 started");
		Reporter.log("Step 36 started");
		driver.navigate().back();
		util.click(CCLOGNumberEle);
		String CClogLogID4 = driver.findElement(By.xpath("//*[@id=\"00Nq0000000jVKD_ileinner\"]")).getText();
		driver.navigate().back();
		util.click(viewCCBContactBtnEle);
		util.switchToTab(1);

		util.switchToWindow();

		driver.switchTo().defaultContent();

		Thread.sleep(2000);
		driver.switchTo().frame("main");
		Thread.sleep(2000);
		driver.switchTo().frame("tabMenu");
		Thread.sleep(2000);

		util.click(LogTabCCBele);
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("main");
		Thread.sleep(2000);
		driver.switchTo().frame("tabPage");
		Thread.sleep(2000);
		String CCBLOGID4 = driver.findElement(By.xpath("//*[@name=\"CC_LOG$CC_LOG_ID\"]")).getText();
		try {
			Assert.assertEquals(CClogLogID4, CCBLOGID4);

			Reporter.log(" Log id " + CCBLOGID4 + " verification successful");
			Reporter.log("Step 36 passed");
		} catch (AssertionError e) {
			Reporter.log(" Log id " + CCBLOGID4 + " verification UNsuccessful");
			Reporter.log("Step 36 failed");
		} catch (Exception e) {
			Reporter.log(" Log id " + CCBLOGID4 + " verification UNsuccessful");
			Reporter.log("Step 36 failed");
		}

		// Step 37

		util.customAlertByJS(" STep 37 started- logging out");
		Reporter.log("Step 37 started- logging out");
		util.switchToTab(0);
		WebElement logOutMenu = driver.findElement(By.xpath("//*[@id=\"userNav-arrow\"]"));
		util.click(logOutMenu);
		WebElement logoutButton = driver.findElement(By.xpath("//*[@title=\"Logout\"]"));
		util.click(logoutButton);
		Reporter.log(" logout done successfully");
		

		return this;
	}

}
*/