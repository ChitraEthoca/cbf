/*package utils;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import pages.WebForm.ExternalSingleRequestFormPage;

public class ExternalSingleRequestFormSteps {

	ExternalSingleRequestFormPage exterPageObj = new ExternalSingleRequestFormPage();

	public String verifyRequestFormTxt(WebDriver driver) {
		return exterPageObj.getRequestFormTxt(driver);
	}

	public String verifyRequestTypeTxt(WebDriver driver) {
		return exterPageObj.getRequestTypeTxt(driver);
	}

	public void selectACategoryOption(WebDriver driver, String value) {
		exterPageObj.chooseCategoryOption(driver, value);
	}

	public String verifySubtitleCategoryTxt(WebDriver driver) {
		return exterPageObj.getsubtitleCategoryTxt(driver);
	}
	
	public void addServicePointId(WebDriver driver, String txt) {
		exterPageObj.enterServicePointId(driver, txt);
	}

	public String verifyCategoryDescriptionTxt(WebDriver driver) {
		String getPartTxt = null;
		String desc_txt = exterPageObj.getCategoryDescriptionTxt(driver);
		if (exterPageObj.isLinkPresentInDescription(driver, desc_txt))
			getPartTxt = exterPageObj.getPartialLinkTxt(driver, desc_txt);
		exterPageObj.clickOnPartialLinkDescriptionTxt(driver, getPartTxt);
		return desc_txt;
	}
	
	public boolean verifyInfoFld(WebDriver driver){
		return exterPageObj.isInfoFieldDisplayed(driver);
	}
	
	public boolean verifySuccessfulMsg(WebDriver driver) {
		return exterPageObj.successMsgDisplayed(driver);
	}

	public String verifySubtitleWorkItemTypeTxt(WebDriver driver) {
		return exterPageObj.getsubtitleWorkItemTypeTxt(driver);
	}

	public void selectAWITypeOption(WebDriver driver, String value) {
		exterPageObj.chooseWITypeOption(driver, value);
	}

	public String verifyWITDescriptionTxt(WebDriver driver) {
		String getPartTxt = null;
		String desc_txt = exterPageObj.getWITDescriptionTxt(driver);
		if (exterPageObj.isLinkPresentInDescription(driver, desc_txt))
			getPartTxt = exterPageObj.getPartialLinkTxt(driver, desc_txt);
		exterPageObj.clickOnPartialLinkDescriptionTxt(driver, getPartTxt);
		return desc_txt;
	}

	public void selectASubmissionTypeOption(WebDriver driver, String value) {
		exterPageObj.chooseSubmissionTypeOption(driver, value);
	}

	public String verifySubtitleSubmissionTypeTxt(WebDriver driver) {
		return exterPageObj.getsubtitleSubmissionTypeTxt(driver);
	}

	public String verifyRequestorsEmail(WebDriver driver) {
		return exterPageObj.getRequestorsEmail(driver);
	}

	public String verifyRequestorsName(WebDriver driver) {
		return exterPageObj.getRequestorsName(driver);
	}
	
	public String verifyNotificationChckboxNonEditable(WebDriver driver){
		return exterPageObj.completionNotificationChckbox(driver);
	}
	
	public void addServiceAgreementNo(WebDriver driver, String txt){
		exterPageObj.enterServiceAgreementId(driver, txt);
	}
	
	public void addMeterNumber(WebDriver driver){
		exterPageObj.enterMeterNumber(driver, "MTR_");
	}

	public void addDetailsInfo(WebDriver driver) {
		exterPageObj.enterDetailsInput(driver, "This is the details info");
	}
	
	public void clickOnSubmit(WebDriver driver) {
		exterPageObj.clickOnSumitBtn(driver);
	}
	
	public void uploadAsAttachment(WebDriver driver) throws AWTException, InterruptedException{
		exterPageObj.uploadAttachment(driver);
	}
	
	public boolean verifyisCSVDownloaded(WebDriver driver, String FileName) {
		return exterPageObj.isCSVDownloaded(driver, FileName);
	}
	
	public void uploadCSVASAttachment(WebDriver driver, String FileName) throws AWTException, InterruptedException{
		exterPageObj.uploadCSVAttachment(driver, FileName);
	}
	public void clickOnReset(WebDriver driver) {
		exterPageObj.clickOnResetBtn(driver);
	}

}
*/