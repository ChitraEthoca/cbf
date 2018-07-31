package webform;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.BasePage;
import utils.Constants;


public class ExternalSingleRequestFormPage extends BasePage {

	Constants constants = new Constants();
	private By titleRequestFormLtr = By.xpath("//h1[contains(text(),'Request Form')]");
	private By titleRequestTypeLtr = By.xpath("//h2/span[contains(text(),'Request Type')]");
	private By subtitleCategoryLtr = By.xpath("//label[text()='Category']");
	private By selectDropDownCategoryLtr = By.id("j_id0:BillingForm:inputCategory");
	private By txtboxDescriptionCategoryLtr = By.xpath("//div[@id='j_id0:BillingForm:theCategory']/div/span");
	private By subtitleWorkItemTypeLtr = By.xpath("//label[text()='Work Item Type']");
	private By selectDropDownWITLtr = By.id("j_id0:BillingForm:ReqType");
	private By txtboxDescriptionWITLtr = By.xpath("//div[@id='j_id0:BillingForm:theWorkItemType']/div/span");
	private By subtitleSubmissionTypeLtr = By.xpath("//label[text()='Submission Type']");
	private By selectDropDownSubmissionTypeLtr = By.id("j_id0:BillingForm:inputSubType");
	private By requestorEmailLtr = By
			.xpath("//label[contains(text(),'Email')]/../div/div[@class='requiredInput']/input");
	private By requestorNameLtr = By.xpath("//label[contains(text(),'Name')]/../div/div[@class='requiredInput']/input");
	private By requestInforChkboxLtr = By.xpath("//label[contains(@for,'requestInfoCheckbox')]/span");
	private By accountIdLtr = By.xpath("//label[contains(text(),'Account')]/../div/div[@class='requiredInput']/input");
	private By infoFldLtr = By.xpath("//label[contains(text(),'Info')]/../div/textarea");
	private By servicePointIdLtr = By
			.xpath("//label[contains(text(),'Service Point')]/../div/div[@class='requiredInput']/input");
	private By meterNumberLtr = By
			.xpath("//label[contains(text(),'Meter Number')]/../div/div[@class='requiredInput']/input");
	/*private By serviceAgreementIdLtr = By
			.xpath("//label[contains(text(),'Service Agreement ID')]/../div/div[@class='requiredInput']/input");*/
	private By serviceAgreementIdLtr = By
			.xpath("//*[@name='j_id0:BillingForm:j_id95:1:j_id100']");
	//*[@name='j_id0:BillingForm:j_id95:1:j_id100']
	private By detailsInputLtr = By
			.xpath("//label[contains(text(),'Details')]/../div/div[@class='requiredInput']/textarea");
	private By emailLinkLtr = By.xpath(
			"//span[text()='For any questions please email:']/following-sibling::a[text()='ExternalWebformSupport@pge.com']");
	private By chooseFileBtnLtr = By.xpath(
			"//h3[text()='Attach Up to 5 Supporting Documents']/../div/div/div[contains(@class,'file-selector')]/div/input");
	private By csvDownloadLinkLtr = By.xpath("//span[contains(@class,'download')]/following-sibling::a");
	private By chooseCSVFileBtnLtr = By.xpath("//input[@accept='.csv']");
	private By errOnaccountIdLtr = By
			.xpath("//label[contains(text(),'Account')]/../div/div[@class='requiredInput']/div[@class='errorMsg']");
	private By errOndetailsInputLtr = By
			.xpath("//label[contains(text(),'Details')]/../div/div[@class='requiredInput']/div[@class='errorMsg']");
	private By errOnSplashScreenLtr = By
			.xpath("//span[contains(@id,'error')]//div//tbody//td[@class='messageCell']/div[@class='messageText']");
	private By submitBtnLtr = By.xpath("//input[@value='Submit']");
	private By ResetBtnLtr = By.xpath("//input[@value='Reset']");
	private By successfulTxtLtr = By.xpath("//div[@class='pbBody']/h1[contains(text(),'Submitted!')]");

	public String getRequestFormTxt(WebDriver driver) {
		waitForElementVisibility(driver, titleRequestFormLtr);
		return driver.findElement(titleRequestFormLtr).getText();
	}

	public String getRequestTypeTxt(WebDriver driver) {
		waitForElementVisibility(driver, titleRequestTypeLtr);
		return driver.findElement(titleRequestTypeLtr).getText();
	}

	public String getsubtitleCategoryTxt(WebDriver driver) {
		waitForElementVisibility(driver, subtitleCategoryLtr);
		return driver.findElement(subtitleCategoryLtr).getText();
	}

	public void chooseCategoryOption(WebDriver driver, String option) {
		selectDropdownValueFromList(driver, selectDropDownCategoryLtr, option);
	}

	public String getCategoryDescriptionTxt(WebDriver driver) {
		String desc_txt = null;
		if (isElementPresent(driver, txtboxDescriptionCategoryLtr)) {
			desc_txt = driver.findElement(txtboxDescriptionCategoryLtr).getAttribute("textContent");
		}
		return desc_txt;
	}

	public boolean isLinkPresentInDescription(WebDriver driver, String value) {
		boolean flag = false;
		if (whetherTxtIsLink(driver, value) != null) {
			flag = true;
		} else
			System.out.println("No LINK PRESENT IN DESCRIPTION TEXT");

		return flag;
	}

	public String getPartialLinkTxt(WebDriver driver, String value) {
		String partialTxt = whetherTxtIsLink(driver, value);
		return partialTxt;
	}

	public String clickOnPartialLinkDescriptionTxt(WebDriver driver, String value) {
		WebElement linkByPartialText = driver.findElement(By.partialLinkText(value));
		linkByPartialText.click();
		try {
			waitForNewWindowAndSwitchToIt(driver);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getCurrentWindowTitle(driver);
	}

	public String getsubtitleWorkItemTypeTxt(WebDriver driver) {
		waitForElementVisibility(driver, subtitleWorkItemTypeLtr);
		return driver.findElement(subtitleWorkItemTypeLtr).getText();
	}

	public void chooseWITypeOption(WebDriver driver, String option) {
		selectDropdownValueFromList(driver, selectDropDownWITLtr, option);
	}

	public String getWITDescriptionTxt(WebDriver driver) {
		String desc_txt = null;
		if (isElementPresent(driver, txtboxDescriptionWITLtr)) {
			desc_txt = driver.findElement(txtboxDescriptionWITLtr).getAttribute("textContent");
		}
		return desc_txt;
	}

	public String getsubtitleSubmissionTypeTxt(WebDriver driver) {
		waitForElementVisibility(driver, subtitleSubmissionTypeLtr);
		return driver.findElement(subtitleSubmissionTypeLtr).getText();
	}

	public void chooseSubmissionTypeOption(WebDriver driver, String option) {
		selectDropdownValueFromList(driver, selectDropDownSubmissionTypeLtr, option);
	}

	public String getRequestorsEmail(WebDriver driver) {
		waitForElementVisibility(driver, requestorEmailLtr);
		return driver.findElement(requestorEmailLtr).getAttribute("value");
	}

	public String getRequestorsName(WebDriver driver) {
		waitForElementVisibility(driver, requestorNameLtr);
		return driver.findElement(requestorNameLtr).getAttribute("value");
	}

	public String completionNotificationChckbox(WebDriver driver) {
		waitForElementVisibility(driver, requestInforChkboxLtr);
		WebElement chkboxelem = driver.findElement(requestInforChkboxLtr);
		String Result = null;
		if (chkboxelem.isEnabled()) {
			chkboxelem.click();
			if (chkboxelem.isSelected() != false) {
				Result = "CHECKBOX IS NON EDITABLE";
			} else
				Result = "CHECKBOX IS EDITABLE";
			chkboxelem.click();
		}
		return Result;
	}

	public void enterAccountId(WebDriver driver) {
		waitForElementVisibility(driver, accountIdLtr);
		enterValue(driver, accountIdLtr, generateNumber());
	}

	public void enterServicePointId(WebDriver driver, String Point_id) {
		waitForElementVisibility(driver, servicePointIdLtr);
		scrollToElement(driver, servicePointIdLtr);
		Point_id= Point_id.replaceAll("[^0-9]", "");
		System.out.println(Point_id);
		enterValue(driver, servicePointIdLtr, Point_id);
	}

	public void enterServiceAgreementId(WebDriver driver, String Agreement_id) {
		waitForElementVisibility(driver, serviceAgreementIdLtr);
		scrollToElement(driver, serviceAgreementIdLtr);
		Agreement_id= Agreement_id.replaceAll("[^0-9]", "");
		System.out.println(Agreement_id);
		enterValue(driver, serviceAgreementIdLtr, Agreement_id);
	}

	public void enterMeterNumber(WebDriver driver, String value) {
		waitForElementVisibility(driver, meterNumberLtr);
		String mtr_no = value + generateNumber();
		enterValue(driver, meterNumberLtr, mtr_no);
	}

	public void enterDetailsInput(WebDriver driver, String value) {
		waitForElementVisibility(driver, detailsInputLtr);
		scrollToElement(driver, detailsInputLtr);
		enterValue(driver, detailsInputLtr, value);
	}

	public void clickOnEmailLink(WebDriver driver) {
		waitForElementVisibility(driver, emailLinkLtr);
		driver.findElement(emailLinkLtr).click();
	}

	public void clickOnSumitBtn(WebDriver driver) {
		waitForElementVisibility(driver, submitBtnLtr);
		scrollToElement(driver, submitBtnLtr);
		driver.findElement(submitBtnLtr).click();
	}

	public void clickOnResetBtn(WebDriver driver) {
		waitForElementVisibility(driver, ResetBtnLtr);
		driver.findElement(ResetBtnLtr).click();
	}

	public boolean isCSVDownloaded(WebDriver driver, String fileName) {
		waitForElementVisibility(driver, csvDownloadLinkLtr);
		scrollToElement(driver, csvDownloadLinkLtr);
		driver.findElement(csvDownloadLinkLtr).click();
		return isFileDownloaded(constants.CONFIG_WEB_DOWNLOADS_PATH, fileName);

	}

	public void uploadCSVAttachment(WebDriver driver, String FileName) throws AWTException, InterruptedException {
		System.out.println(constants.CONFIG_UPLOAD_PATH + "\\"+FileName);
		setClipboardData(constants.CONFIG_UPLOAD_PATH + "\\"+FileName);
		WebElement fileInput = driver.findElement(chooseCSVFileBtnLtr);
		fileInput.click();
		Thread.sleep(5000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void uploadAttachment(WebDriver driver) throws AWTException, InterruptedException {
		Thread.sleep(1000);
		scrollToElement(driver, chooseFileBtnLtr);
		setClipboardData(constants.CONFIG_UPLOAD_PATH + "\\Koala.jpg");
		WebElement fileInput = driver.findElement(chooseFileBtnLtr);
		fileInput.click();
		Thread.sleep(5000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		// fileInput.sendKeys("C:/Users/c4p4/workspace/Koala.jpg");
	}
	
	public boolean isInfoFieldDisplayed(WebDriver driver) {
		boolean status;
		waitForElementVisibility(driver, infoFldLtr);
		status = isElementPresent(driver, infoFldLtr);
		return status ;
	}
	
	public boolean successMsgDisplayed(WebDriver driver) {
		boolean status;
		status = isElementPresent(driver, successfulTxtLtr);
		return status ;
		
	}

}
