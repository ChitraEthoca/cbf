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

public class CustomerContactPage_731_732_764_S2 extends BasePage {
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
	@FindBy(xpath = "//*[@title=\"Checked\"]")
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

	public CustomerContactPage_731_732_764_S2(WebDriver driver, HashMap<String, String> localData) throws Exception {
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

	public CustomerContactPage_731_732_764_S2 loginIntoApplication(Hashtable<String, String> testData)
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

	public CustomerContactPage_731_732_764_S2 clickOnWorkItems() throws Exception {
		COC.webAdaptor(Actions.setValueToXpathAndClick, "HomeTab");
		COC.webAdaptor(Actions.setValueToXpathAndClick, "WorkItemsTab");

		GenericUtilities util = new GenericUtilities();

		WebElement homebutton = driver.findElement(By.xpath("//*[@href=\"/home/home.jsp\"]"));

		util.click(homebutton);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[contains(text(),'Work Items')]")).click();

		return this;
	}

	public CustomerContactPage_731_732_764_S2 selectMyWI() throws Exception {
		Select dropdown = new Select(driver.findElement(By.id("fcf")));
		dropdown.selectByIndex(3);
		return this;
	}

	@SuppressWarnings("deprecation")
	public CustomerContactPage_731_732_764_S2 navigateToWI_AddContact(Hashtable<String, String> testData)
			throws Exception {

		GenericUtilities util = new GenericUtilities();

		// Step 8 started

		util.customAlertByJS("Step 8 started");
		Reporter.log("Step 8 started");

		Reporter.log("Opening work item with no customer contacts");
		try {

			util.switchToTab(0);
			clickOnWorkItems();
			selectMyWI();
			String WIwithoutCustCOntact1 = BasePage.getTestDataValue("WiWithoutCustContact_S2");

			WebElement WIwithoutContact1 = driver
					.findElement(By.xpath("//*[contains(text(),'" + WIwithoutCustCOntact1 + "')]"));

			util.click(WIwithoutContact1);

			Thread.sleep(1000);
			Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Work Item Detail')]")).isDisplayed());

			Reporter.log("Step 8 completed- Work item opened successfully");
			Thread.sleep(1000);
		}

		catch (Exception e) {

			Reporter.log("Step 8 failed- Unable to open work item");

		}

		// Step 9 started

		util.customAlertByJS("Step 9 started");
		Reporter.log("Step 9 started");
		try {

			driver.findElement(By.xpath("//*[@title=\"Edit\"]")).click();
			Thread.sleep(2000);
			enterKeys(driver, AsBilledAmountLocator, "2000");
			Thread.sleep(2000);
			enterKeys(driver, AsCorrectedAmountLocator, "1000");
			Thread.sleep(2000);
			enterKeys(driver, BilledDateFromLocator, "4/18/2018");
			Thread.sleep(2000);
			enterKeys(driver, BilledDateToLocator, "4/18/2018");
			Thread.sleep(2000);
			// enterKeys(driver, CustomerAjAmountLocator, "196");
			// Thread.sleep(2000);
			util.sendKeys(billedToAmountEle, "201");
			Thread.sleep(2000);
			util.sendKeys(billedFromDateEle, "4/18/2018");
			Thread.sleep(2000);
			util.click(billedToAmountEle);
			Thread.sleep(2000);
			util.sendKeys(billedToDateEle, "4/18/2018");
			billedToAmountEle.click();
			Thread.sleep(2000);
			if (correctionCheckBoxEle.isSelected() == true) {
				correctionCheckBoxEle.click();

			}

			driver.findElement(By.xpath("//*[@name=\"save\"]")).click();
			Reporter.log(" Work item edited and saved successfully");
			Thread.sleep(2000);

			Reporter.log("Step 9 passed");
		} catch (Exception e) {
			System.out.println(e);
			Reporter.log("Step 9 failed");
		}

		// Step 10 started

		util.customAlertByJS("Step 10 started");
		Reporter.log("Step 10 started");

		try {

			util.switchToTab(0);
			clickOnWorkItems();
			selectMyWI();
			String WIwithoutCustCOntact1 = BasePage.getTestDataValue("WiWithoutCustContact_S2");

			WebElement WIwithoutContact1 = driver
					.findElement(By.xpath("//*[contains(text(),'" + WIwithoutCustCOntact1 + "')]"));

			util.click(WIwithoutContact1);
			Thread.sleep(1000);

			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@value=\"Close Work Item\"]")).click();

			WebElement statusDropdown = driver.findElement(By.xpath("//*[@id=\"cas7\"]"));
			util.selectByIndex(2, statusDropdown);

			WebElement postponeCredit = driver.findElement(By.xpath("//*[@id=\"00No0000008cgmD\"]"));
			util.selectByIndex(2, postponeCredit);

			WebElement subStatus = driver.findElement(By.xpath("//*[@id=\"00No0000008cgmk\"]"));
			util.selectByIndex(1, subStatus);

			WebElement rootCauseCategory = driver.findElement(By.xpath("//*[@id=\"00Nq0000000ZKwY\"]"));
			util.selectByIndex(5, rootCauseCategory);

			WebElement rootCausSUbCategory = driver.findElement(By.xpath("//*[@id=\"00No0000008cgmU\"]"));
			util.selectByIndex(2, rootCausSUbCategory);

			WebElement CustomerContactClass = driver.findElement(By.xpath("//*[@id=\"00No0000008cglg\"]"));

			util.selectByIndex(9, CustomerContactClass);

			WebElement CustContactType = driver.findElement(By.xpath("//*[@id=\"00No0000008cgll\"]"));

			util.selectByIndex(1, CustContactType);

			WebElement SOXReqInfo = driver.findElement(By.xpath("//*[@id=\"00Nq0000000iAXV\"]"));
			Thread.sleep(1000);
			util.selectByIndex(1, SOXReqInfo);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"00Nq0000000ZKwU\"]")).sendKeys("1234");

			WebElement WICloseSaveBtn = driver.findElement(By.xpath("//*[@value=\" Save \"]"));

			util.click(WICloseSaveBtn);
			Thread.sleep(1000);
			Reporter.log("Step 10 passed");
		}

		catch (Exception e) {
			System.out.println(e);
			Reporter.log("Step 10 failed");
		}

		// Step 11 started

		util.customAlertByJS("Step 11 started");
		Reporter.log("Step 11 started");
		try {

			util.switchToTab(0);
			clickOnWorkItems();
			selectMyWI();
			String WIwithoutCustCOntact1 = BasePage.getTestDataValue("WiWithoutCustContact_S2");

			WebElement WIwithoutContact1 = driver
					.findElement(By.xpath("//*[contains(text(),'" + WIwithoutCustCOntact1 + "')]"));

			util.click(WIwithoutContact1);
			Thread.sleep(1000);
			util.scrollIntoView(customerRelatedRecNamEle);
			Assert.assertTrue(customerRelatedRecNamEle.isDisplayed());
			util.click(customerRelatedRecNamEle);
			util.highlighElement(CustContactLogEntryEle);
			Assert.assertTrue(CustContactLogEntryEle.isDisplayed());
			Reporter.log("Log entry is : "+CustContactLogEntryEle.getText());
			//Assert.assertTrue(CustContactLogEntryEle.getText().contains("S1DL"));			
			Reporter.log(" Related records and logs verification done");
			Reporter.log(" Step 11 passed");

		}

		catch (AssertionError e) {
			
			Reporter.log("Step 11 failed"+e.getLocalizedMessage());

		}
		catch (Exception e) {
			Reporter.log("Step 11 failed"+e.getLocalizedMessage());

		}

		// Step 12 started

		util.customAlertByJS("Step 12 started");
		Reporter.log("Step 12 started");
		try {

			util.switchToTab(0);
			clickOnWorkItems();
			selectMyWI();
			String WIwithoutCustCOntact1 = BasePage.getTestDataValue("WiWithoutCustContact_S2");

			WebElement WIwithoutContact1 = driver
					.findElement(By.xpath("//*[contains(text(),'" + WIwithoutCustCOntact1 + "')]"));

			util.click(WIwithoutContact1);

			util.click(customerRelatedRecNamEle);
			Thread.sleep(2000);
			util.click(CCLOGNumberEle);
			Thread.sleep(1000);
			//Assert.assertTrue(customerContactLogWithABACCheckboxele.isDisplayed());
			//Assert.assertFalse(customerContactLogWithABACCheckboxele.isDisplayed());
			String CClogLogID = driver.findElement(By.xpath("//*[@id=\"00Nq0000000jVKD_ileinner\"]")).getText();
			driver.navigate().back();
			util.click(viewCCBContactBtnEle);
			util.switchToTab(1);
			try {

			util.CCBLogin(CCBUserIdEle, CCBPasswordEle, CCBLoginBtn);
			Reporter.log("CCB login done");
			
			
			util.scrollIntoView(customerContactLogNameEle);
			Assert.assertTrue(customerContactLogNameEle.isDisplayed());

			String ABACLogEntry = CustContactLogEntryEle.getText();
			driver.navigate().back();
			util.click(customerRelatedRecNamEle);
			util.click(viewCCBCustomerContactEle);
			util.switchToTab(1);
		
			driver.switchTo().frame("main");
			driver.switchTo().frame("tabPage");
			driver.switchTo().frame("CC_LOG_GRID");
			String CCBLOg = util.getText(CCLogStatementEle);
			Assert.assertEquals(ABACLogEntry.trim(), CCBLOg.trim());
			Reporter.log("SFDC and CC&B log entry verification done");
			
			
			
			
			
			
			
			
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

			String CCBLOGID = driver.findElement(By.xpath("//*[@name=\"CC_LOG$CC_LOG_ID\"]")).getText();

			Assert.assertEquals(CClogLogID, CCBLOGID);
			Reporter.log("Step 12 complete-Customer contact records and logs comparion between SFDC & CC&B was successfull");

			Reporter.log(" Step 12 passed");

		}
		catch (AssertionError e) {

			Reporter.log("Step 12 failed"+e.getLocalizedMessage());

		}
		catch (Exception e) {

			Reporter.log("Step 12 failed"+e.getLocalizedMessage());

		}

		return this;
	}

}
*/