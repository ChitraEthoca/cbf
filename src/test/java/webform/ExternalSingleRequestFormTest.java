package webform;
/*package tests.WebForm;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseClasses.Driver;
import steps.ExternalSingleRequestFormSteps;
import steps.LoginSteps;
import utilities.FileOperations;

@Listeners(utilities.TestListener.class)
public class ExternalSingleRequestFormTest {

	WebDriver driver = null;
	Driver driverObj = new Driver();
	ExternalSingleRequestFormSteps ESRFStepObj = new ExternalSingleRequestFormSteps();
	LoginSteps loginStepsObj = new LoginSteps();
	SoftAssert softAssert = null;
	Logger logger;

	@BeforeMethod(alwaysRun = true)
	private void startTest() throws IOException {
		driver = driverObj.createDriver();
		driver.get(driverObj.getUrl());
		driver.manage().window().maximize();
		loginStepsObj.login(driver, driverObj.getUsername(), driverObj.getPassword());
	}

	@Test(priority = 1, description = "S1_CBP_External Single Webform Submission Page With Billing Correction & Hetch Hetchy")
	public void bC_HetchHetchy_Single() throws IOException, InterruptedException, AWTException {
		softAssert = new SoftAssert();
		logger = Logger.getLogger("devpinoyLogger");
		logger.debug("Verifying The Request Form Page");
		String requestFormtxt = ESRFStepObj.verifyRequestFormTxt(driver);
		softAssert.assertEquals(requestFormtxt, FileOperations.getTestDataValue("Form Name"));
		logger.debug("Verifying The Request Form Type");
		String requestTypeTxt = ESRFStepObj.verifyRequestTypeTxt(driver);
		softAssert.assertEquals(requestTypeTxt, FileOperations.getTestDataValue("Form Type"));
		logger.debug("Verifying The Category SubTitle");
		String subtitleCategoryTxt = ESRFStepObj.verifySubtitleCategoryTxt(driver);
		softAssert.assertEquals(subtitleCategoryTxt, FileOperations.getTestDataValue("Sub Section_1"));
		logger.debug("Selecting the Category From DropDown");
		ESRFStepObj.selectACategoryOption(driver, FileOperations.getTestDataValue("Category_Option1"));
		logger.debug("Verifying The Description Corresponding to the Category Choosen Appears");
		String categoryDescriptionTxt = ESRFStepObj.verifyCategoryDescriptionTxt(driver);
		softAssert.assertEquals(categoryDescriptionTxt, "");
		logger.debug("Verifying The Work Item SubTitle");
		String subtitleWorkItemTypeTxt = ESRFStepObj.verifySubtitleWorkItemTypeTxt(driver);
		softAssert.assertEquals(subtitleWorkItemTypeTxt, FileOperations.getTestDataValue("Sub Section_2"));
		logger.debug("Selecting the Work Item From DropDown");
		ESRFStepObj.selectAWITypeOption(driver, FileOperations.getTestDataValue("WI_Option1"));
		logger.debug("Verifying The Description Corresponding to the WI Choosen Appears");
		String wITDescriptionTxt = ESRFStepObj.verifyWITDescriptionTxt(driver);
		softAssert.assertEquals(wITDescriptionTxt, "");
		logger.debug("Selecting the Single Submission Type From DropDown");
		ESRFStepObj.selectASubmissionTypeOption(driver, FileOperations.getTestDataValue("Submission_Option1"));
		logger.debug("Verifying The Submission Type SubTitle");
		String subtitleSubmissionTypeTxt = ESRFStepObj.verifySubtitleSubmissionTypeTxt(driver);
		softAssert.assertEquals(subtitleSubmissionTypeTxt, FileOperations.getTestDataValue("Sub Section_3"));
		logger.debug("Verifying The Requestor Email");
		String requestorsEmail = ESRFStepObj.verifyRequestorsEmail(driver);
		softAssert.assertEquals(requestorsEmail, FileOperations.getTestDataValue("Email"));
		logger.debug("Verifying The Requestor Name");
		String requestorsName = ESRFStepObj.verifyRequestorsName(driver);
		softAssert.assertEquals(requestorsName, FileOperations.getTestDataValue("Name"));
		logger.debug("Verifying The Notification Check Box is Editable");
		String status_chck = ESRFStepObj.verifyNotificationChckboxNonEditable(driver);
		// softAssert.assertEquals(status_chck, FileOperations.getTestDataValue("Notification_Check"));
		logger.debug("Enter the valid Servic Point Id");
		ESRFStepObj.addServicePointId(driver, FileOperations.getTestDataValue("Service Point ID"));
		logger.debug("Verify the info field");
		boolean str = ESRFStepObj.verifyInfoFld(driver);
		softAssert.assertEquals(str, true);
		logger.debug("Enter the valid Meter No.");
		ESRFStepObj.addMeterNumber(driver);
		logger.debug("Enter the valid Details Info");
		ESRFStepObj.addDetailsInfo(driver);
		logger.debug("Browsing and Uploading file as an attachmentS");
		ESRFStepObj.uploadAsAttachment(driver);
		logger.debug("Submission of WebForm With All Mandatory Fields");
		ESRFStepObj.clickOnSubmit(driver);
		logger.debug("Verifying Form is Submitted Successfully");
		ESRFStepObj.verifySuccessfulMsg(driver);
		softAssert.assertAll();
	}

	@Test(priority = 2, description = "S1_CBP_External Single Webform Submission Page With Billing Correction & Miscellaneous Webform")
	public void bC_MiscellaneousWebform_Single() throws IOException, InterruptedException, AWTException {
		softAssert = new SoftAssert();
		logger = Logger.getLogger("devpinoyLogger");
		logger.debug("Verifying The Request Form Page");
		String requestFormtxt = ESRFStepObj.verifyRequestFormTxt(driver);
		softAssert.assertEquals(requestFormtxt, FileOperations.getTestDataValue("Form Name"));
		logger.debug("Verifying The Request Form Type");
		String requestTypeTxt = ESRFStepObj.verifyRequestTypeTxt(driver);
		softAssert.assertEquals(requestTypeTxt, FileOperations.getTestDataValue("Form Type"));
		logger.debug("Verifying The Category SubTitle");
		String subtitleCategoryTxt = ESRFStepObj.verifySubtitleCategoryTxt(driver);
		softAssert.assertEquals(subtitleCategoryTxt, FileOperations.getTestDataValue("Sub Section_1"));
		logger.debug("Selecting the Category From DropDown");
		ESRFStepObj.selectACategoryOption(driver, FileOperations.getTestDataValue("Category_Option1"));
		logger.debug("Verifying The Description Corresponding to the Category Choosen Appears");
		String categoryDescriptionTxt = ESRFStepObj.verifyCategoryDescriptionTxt(driver);
		// softAssert.assertEquals(categoryDescriptionTxt, "");
		logger.debug("Verifying The Work Item SubTitle");
		String subtitleWorkItemTypeTxt = ESRFStepObj.verifySubtitleWorkItemTypeTxt(driver);
		softAssert.assertEquals(subtitleWorkItemTypeTxt, FileOperations.getTestDataValue("Sub Section_2"));
		logger.debug("Selecting the Work Item From DropDown");
		ESRFStepObj.selectAWITypeOption(driver, FileOperations.getTestDataValue("WI_Option2"));
		logger.debug("Verifying The Description Corresponding to the WI Choosen Appears");
		String wITDescriptionTxt = ESRFStepObj.verifyWITDescriptionTxt(driver);
		softAssert.assertEquals(wITDescriptionTxt, "");
		logger.debug("Selecting the Submission Type From DropDown");
		ESRFStepObj.selectASubmissionTypeOption(driver, FileOperations.getTestDataValue("Submission_Option1"));
		logger.debug("Verifying The Submission Type SubTitle");
		String subtitleSubmissionTypeTxt = ESRFStepObj.verifySubtitleSubmissionTypeTxt(driver);
		softAssert.assertEquals(subtitleSubmissionTypeTxt,FileOperations.getTestDataValue("Sub Section_3"));
		logger.debug("Verifying The Requestor Email");
		String requestorsEmail = ESRFStepObj.verifyRequestorsEmail(driver);
		softAssert.assertEquals(requestorsEmail, FileOperations.getTestDataValue("Email"));
		logger.debug("Verifying The Requestor Name");
		String requestorsName = ESRFStepObj.verifyRequestorsName(driver);
		softAssert.assertEquals(requestorsName, FileOperations.getTestDataValue("Name"));
		logger.debug("Verifying The Notification Check Box is Editable");
		String status_chck = ESRFStepObj.verifyNotificationChckboxNonEditable(driver);
		// softAssert.assertEquals(status_chck, FileOperations.getTestDataValue("Notification_Check"));
		logger.debug("Enter the valid Details Info");
		ESRFStepObj.addDetailsInfo(driver);
		logger.debug("Verify the info field");
		boolean str = ESRFStepObj.verifyInfoFld(driver);
		softAssert.assertEquals(str, true);
		logger.debug("Browsing and Uploading file as an attachmentS");
		ESRFStepObj.uploadAsAttachment(driver);
		logger.debug("Submission of WebForm With All Mandatory Fields");
		ESRFStepObj.clickOnSubmit(driver);
		logger.debug("Verifying Form is Submitted Successfully");
		ESRFStepObj.verifySuccessfulMsg(driver);
		softAssert.assertAll();

	}

	@Test(priority = 3, description = "S1_CBP_External Single Webform Submission Page With Billing Correction & Rate Change Webform")
	public void bC_RateChangeWebform_Single() throws IOException, InterruptedException, AWTException {
		softAssert = new SoftAssert();
		logger = Logger.getLogger("devpinoyLogger");
		logger.debug("Verifying The Request Form Page");
		String requestFormtxt = ESRFStepObj.verifyRequestFormTxt(driver);
		softAssert.assertEquals(requestFormtxt, FileOperations.getTestDataValue("Form Name"));
		logger.debug("Verifying The Request Form Type");
		String requestTypeTxt = ESRFStepObj.verifyRequestTypeTxt(driver);
		softAssert.assertEquals(requestTypeTxt, FileOperations.getTestDataValue("Form Type"));
		logger.debug("Verifying The Category SubTitle");
		String subtitleCategoryTxt = ESRFStepObj.verifySubtitleCategoryTxt(driver);
		softAssert.assertEquals(subtitleCategoryTxt, FileOperations.getTestDataValue("Sub Section_1"));
		logger.debug("Selecting the Category From DropDown");
		ESRFStepObj.selectACategoryOption(driver, FileOperations.getTestDataValue("Category_Option1"));
		logger.debug("Verifying The Description Corresponding to the Category Choosen Appears");
		String categoryDescriptionTxt = ESRFStepObj.verifyCategoryDescriptionTxt(driver);
		// softAssert.assertEquals(categoryDescriptionTxt, "");
		logger.debug("Verifying The Work Item SubTitle");
		String subtitleWorkItemTypeTxt = ESRFStepObj.verifySubtitleWorkItemTypeTxt(driver);
		softAssert.assertEquals(subtitleWorkItemTypeTxt, FileOperations.getTestDataValue("Sub Section_2"));
		logger.debug("Selecting the Work Item From DropDown");
		ESRFStepObj.selectAWITypeOption(driver, FileOperations.getTestDataValue("WI_Option3"));
		logger.debug("Verifying The Description Corresponding to the WI Choosen Appears");
		String wITDescriptionTxt = ESRFStepObj.verifyWITDescriptionTxt(driver);
		softAssert.assertEquals(wITDescriptionTxt, "");
		logger.debug("Selecting the Submission Type From DropDown");
		ESRFStepObj.selectASubmissionTypeOption(driver, FileOperations.getTestDataValue("Submission_Option1"));
		logger.debug("Verifying The Submission Type SubTitle");
		String subtitleSubmissionTypeTxt = ESRFStepObj.verifySubtitleSubmissionTypeTxt(driver);
		softAssert.assertEquals(subtitleSubmissionTypeTxt, FileOperations.getTestDataValue("Sub Section_3"));
		logger.debug("Verifying The Requestor Email");
		String requestorsEmail = ESRFStepObj.verifyRequestorsEmail(driver);
		softAssert.assertEquals(requestorsEmail, FileOperations.getTestDataValue("Email"));
		logger.debug("Verifying The Requestor Name");
		String requestorsName = ESRFStepObj.verifyRequestorsName(driver);
		softAssert.assertEquals(requestorsName, FileOperations.getTestDataValue("Name"));
		logger.debug("Verifying The Notification Check Box is Editable");
		String status_chck = ESRFStepObj.verifyNotificationChckboxNonEditable(driver);
		// softAssert.assertEquals(status_chck, FileOperations.getTestDataValue("Notification_Check"));
		logger.debug("Enter the valid Service Agreement No.");
		ESRFStepObj.addServiceAgreementNo(driver, FileOperations.getTestDataValue("Service Agreement ID"));
		logger.debug("Verify the info field");
		boolean str = ESRFStepObj.verifyInfoFld(driver);
		softAssert.assertEquals(str, true);
		logger.debug("Enter the valid Details Info");
		ESRFStepObj.addDetailsInfo(driver);
		logger.debug("Browsing and Uploading file as an attachmentS");
		ESRFStepObj.uploadAsAttachment(driver);
		logger.debug("Submission of WebForm With All Mandatory Fields");
		ESRFStepObj.clickOnSubmit(driver);
		logger.debug("Verifying Form is Submitted Successfully");
		ESRFStepObj.verifySuccessfulMsg(driver);
		softAssert.assertAll();
	}

	@Test(priority = 4, description = "S1_CBP_External Single Webform Submission Page With Third Party Intake & DA CCA Webform")
	public void TPI_DACCAWebform_Single() throws IOException, InterruptedException, AWTException {
		softAssert = new SoftAssert();
		logger = Logger.getLogger("devpinoyLogger");
		logger.debug("Verifying The Request Form Page");
		String requestFormtxt = ESRFStepObj.verifyRequestFormTxt(driver);
		softAssert.assertEquals(requestFormtxt, FileOperations.getTestDataValue("Form Name"));
		logger.debug("Verifying The Request Form Type");
		String requestTypeTxt = ESRFStepObj.verifyRequestTypeTxt(driver);
		softAssert.assertEquals(requestTypeTxt, FileOperations.getTestDataValue("Form Type"));
		logger.debug("Verifying The Category SubTitle");
		String subtitleCategoryTxt = ESRFStepObj.verifySubtitleCategoryTxt(driver);
		softAssert.assertEquals(subtitleCategoryTxt, FileOperations.getTestDataValue("Sub Section_1"));
		logger.debug("Selecting the Category From DropDown");
		ESRFStepObj.selectACategoryOption(driver, FileOperations.getTestDataValue("Category_Option2"));
		logger.debug("Verifying The Description Corresponding to the Category Choosen Appears");
		String categoryDescriptionTxt = ESRFStepObj.verifyCategoryDescriptionTxt(driver);
		// softAssert.assertEquals(categoryDescriptionTxt, "");
		logger.debug("Verifying The Work Item SubTitle");
		String subtitleWorkItemTypeTxt = ESRFStepObj.verifySubtitleWorkItemTypeTxt(driver);
		softAssert.assertEquals(subtitleWorkItemTypeTxt, FileOperations.getTestDataValue("Sub Section_2"));
		logger.debug("Selecting the Work Item From DropDown");
		ESRFStepObj.selectAWITypeOption(driver, FileOperations.getTestDataValue("WI_Option4"));
		logger.debug("Verifying The Description Corresponding to the WI Choosen Appears");
		String wITDescriptionTxt = ESRFStepObj.verifyWITDescriptionTxt(driver);
		softAssert.assertEquals(wITDescriptionTxt, "");
		logger.debug("Selecting the Submission Type From DropDown");
		ESRFStepObj.selectASubmissionTypeOption(driver, FileOperations.getTestDataValue("Submission_Option1"));
		logger.debug("Verifying The Submission Type SubTitle");
		String subtitleSubmissionTypeTxt = ESRFStepObj.verifySubtitleSubmissionTypeTxt(driver);
		softAssert.assertEquals(subtitleSubmissionTypeTxt, FileOperations.getTestDataValue("Sub Section_3"));
		logger.debug("Verifying The Requestor Email");
		String requestorsEmail = ESRFStepObj.verifyRequestorsEmail(driver);
		softAssert.assertEquals(requestorsEmail, FileOperations.getTestDataValue("Email"));
		logger.debug("Verifying The Requestor Name");
		String requestorsName = ESRFStepObj.verifyRequestorsName(driver);
		softAssert.assertEquals(requestorsName, FileOperations.getTestDataValue("Name"));
		logger.debug("Verifying The Notification Check Box is Editable");
		String status_chck = ESRFStepObj.verifyNotificationChckboxNonEditable(driver);
		// softAssert.assertEquals(status_chck, FileOperations.getTestDataValue("Notification_Check"));
		logger.debug("Enter the valid Service Agreement No.");
		ESRFStepObj.addServiceAgreementNo(driver, FileOperations.getTestDataValue("Service Agreement ID"));
		logger.debug("Verify the info field");
		boolean str = ESRFStepObj.verifyInfoFld(driver);
		softAssert.assertEquals(str, true);
		logger.debug("Enter the valid Details Info");
		ESRFStepObj.addDetailsInfo(driver);
		logger.debug("Browsing and Uploading file as an attachmentS");
		ESRFStepObj.uploadAsAttachment(driver);
		logger.debug("Submission of WebForm With All Mandatory Fields");
		ESRFStepObj.clickOnSubmit(driver);
		logger.debug("Verifying Form is Submitted Successfully");
		ESRFStepObj.verifySuccessfulMsg(driver);
		softAssert.assertAll();
	}
	
@Test(priority = 5, description = "S1_CBP_External Multiple Webform Submission Page With Billing Correction & Hetch Hetchy")
	public void bC_HetchHetchy_Multiple() throws IOException, InterruptedException, AWTException {
		String requestFormtxt = ESRFStepObj.verifyRequestFormTxt(driver);
		softAssert.assertEquals(requestFormtxt, FileOperations.getTestDataValue("Form Name"));
		logger.debug("Verifying The Request Form Type");
		String requestTypeTxt = ESRFStepObj.verifyRequestTypeTxt(driver);
		softAssert.assertEquals(requestTypeTxt, FileOperations.getTestDataValue("Form Type"));
		logger.debug("Verifying The Category SubTitle");
		String subtitleCategoryTxt = ESRFStepObj.verifySubtitleCategoryTxt(driver);
		softAssert.assertEquals(subtitleCategoryTxt, FileOperations.getTestDataValue("Sub Section_1"));
		logger.debug("Selecting the Category From DropDown");
		ESRFStepObj.selectACategoryOption(driver, FileOperations.getTestDataValue("Category_Option1"));
		logger.debug("Verifying The Description Corresponding to the Category Choosen Appears");
		String categoryDescriptionTxt = ESRFStepObj.verifyCategoryDescriptionTxt(driver);
		softAssert.assertEquals(categoryDescriptionTxt, "");
		logger.debug("Verifying The Work Item SubTitle");
		String subtitleWorkItemTypeTxt = ESRFStepObj.verifySubtitleWorkItemTypeTxt(driver);
		softAssert.assertEquals(subtitleWorkItemTypeTxt, FileOperations.getTestDataValue("Sub Section_2"));
		logger.debug("Selecting the Work Item From DropDown");
		ESRFStepObj.selectAWITypeOption(driver, FileOperations.getTestDataValue("WI_Option1"));
		logger.debug("Verifying The Description Corresponding to the WI Choosen Appears");
		String wITDescriptionTxt = ESRFStepObj.verifyWITDescriptionTxt(driver);
		softAssert.assertEquals(wITDescriptionTxt, "");
		logger.debug("Selecting the Multiple Submission Type From DropDown");
		ESRFStepObj.selectASubmissionTypeOption(driver, FileOperations.getTestDataValue("Submission_Option2"));
		logger.debug("Verifying The Submission Type SubTitle");
		String subtitleSubmissionTypeTxt = ESRFStepObj.verifySubtitleSubmissionTypeTxt(driver);
		softAssert.assertEquals(subtitleSubmissionTypeTxt, FileOperations.getTestDataValue("Sub Section_3"));
		logger.debug("Verifying The Requestor Email");
		String requestorsEmail = ESRFStepObj.verifyRequestorsEmail(driver);
		softAssert.assertEquals(requestorsEmail, FileOperations.getTestDataValue("Email"));
		logger.debug("Verifying The Requestor Name");
		String requestorsName = ESRFStepObj.verifyRequestorsName(driver);
		softAssert.assertEquals(requestorsName, FileOperations.getTestDataValue("Name"));
		logger.debug("Verifying The Notification Check Box is Editable");
		String status_chck = ESRFStepObj.verifyNotificationChckboxNonEditable(driver);
		// softAssert.assertEquals(status_chck, FileOperations.getTestDataValue("Notification_Check"));
		logger.debug("Enter the valid Details Info");
		ESRFStepObj.addDetailsInfo(driver);
		logger.debug("Download the CSV Template");
		ESRFStepObj.verifyisCSVDownloaded(driver, FileOperations.getTestDataValue("NameOfFile_BC"));
		logger.debug("Upload The CSV FIle");
		ESRFStepObj.uploadCSVASAttachment(driver, FileOperations.getTestDataValue("NameOfFile_BC")+".csv");
		logger.debug("Browsing and Uploading file as an attachmentS");
		ESRFStepObj.uploadAsAttachment(driver);
		logger.debug("Submission of WebForm With All Mandatory Fields");
		ESRFStepObj.clickOnSubmit(driver);
		logger.debug("Verifying Form is Submitted Successfully");
		ESRFStepObj.verifySuccessfulMsg(driver);
		softAssert.assertAll();
	}
	
	@Test(priority = 6, description = "S1_CBP_External Single Webform Submission Page With Third Party Intake & DA CCA Webform")
	public void TPI_DACCAWebform_Multiple() throws IOException, InterruptedException, AWTException {
		softAssert = new SoftAssert();
		logger = Logger.getLogger("devpinoyLogger");
		logger.debug("Verifying The Request Form Page");
		String requestFormtxt = ESRFStepObj.verifyRequestFormTxt(driver);
		softAssert.assertEquals(requestFormtxt, FileOperations.getTestDataValue("Form Name"));
		logger.debug("Verifying The Request Form Type");
		String requestTypeTxt = ESRFStepObj.verifyRequestTypeTxt(driver);
		softAssert.assertEquals(requestTypeTxt, FileOperations.getTestDataValue("Form Type"));
		logger.debug("Verifying The Category SubTitle");
		String subtitleCategoryTxt = ESRFStepObj.verifySubtitleCategoryTxt(driver);
		softAssert.assertEquals(subtitleCategoryTxt, FileOperations.getTestDataValue("Sub Section_1"));
		logger.debug("Selecting the Category From DropDown");
		ESRFStepObj.selectACategoryOption(driver, FileOperations.getTestDataValue("Category_Option2"));
		logger.debug("Verifying The Description Corresponding to the Category Choosen Appears");
		String categoryDescriptionTxt = ESRFStepObj.verifyCategoryDescriptionTxt(driver);
		// softAssert.assertEquals(categoryDescriptionTxt, "");
		logger.debug("Verifying The Work Item SubTitle");
		String subtitleWorkItemTypeTxt = ESRFStepObj.verifySubtitleWorkItemTypeTxt(driver);
		softAssert.assertEquals(subtitleWorkItemTypeTxt, FileOperations.getTestDataValue("Sub Section_2"));
		logger.debug("Selecting the Work Item From DropDown");
		ESRFStepObj.selectAWITypeOption(driver, FileOperations.getTestDataValue("WI_Option4"));
		logger.debug("Verifying The Description Corresponding to the WI Choosen Appears");
		String wITDescriptionTxt = ESRFStepObj.verifyWITDescriptionTxt(driver);
		softAssert.assertEquals(wITDescriptionTxt, "");
		logger.debug("Selecting the Submission Type From DropDown");
		ESRFStepObj.selectASubmissionTypeOption(driver, FileOperations.getTestDataValue("Submission_Option2"));
		logger.debug("Verifying The Submission Type SubTitle");
		String subtitleSubmissionTypeTxt = ESRFStepObj.verifySubtitleSubmissionTypeTxt(driver);
		softAssert.assertEquals(subtitleSubmissionTypeTxt, FileOperations.getTestDataValue("Sub Section_3"));
		logger.debug("Verifying The Requestor Email");
		String requestorsEmail = ESRFStepObj.verifyRequestorsEmail(driver);
		softAssert.assertEquals(requestorsEmail, FileOperations.getTestDataValue("Email"));
		logger.debug("Verifying The Requestor Name");
		String requestorsName = ESRFStepObj.verifyRequestorsName(driver);
		softAssert.assertEquals(requestorsName, FileOperations.getTestDataValue("Name"));
		logger.debug("Verifying The Notification Check Box is Editable");
		String status_chck = ESRFStepObj.verifyNotificationChckboxNonEditable(driver);
		// softAssert.assertEquals(status_chck, FileOperations.getTestDataValue("Notification_Check"));
		logger.debug("Enter the valid Details Info");
		ESRFStepObj.addDetailsInfo(driver);
		logger.debug("Download the CSV Template");
		ESRFStepObj.verifyisCSVDownloaded(driver, FileOperations.getTestDataValue("NameOfFile_TPI"));
		logger.debug("Upload The CSV FIle");
		ESRFStepObj.uploadCSVASAttachment(driver, FileOperations.getTestDataValue("NameOfFile_TPI")+".csv" );
		logger.debug("Browsing and Uploading file as an attachments");
		ESRFStepObj.uploadAsAttachment(driver);
		logger.debug("Submission of WebForm With All Mandatory Fields");
		ESRFStepObj.clickOnSubmit(driver);
		logger.debug("Verifying Form is Submitted Successfully");
		ESRFStepObj.verifySuccessfulMsg(driver);
		softAssert.assertAll();
	}
	
	@Test(priority = 7, description = "S1_CBP_External Webform Submission Reset Functionality")
	public void bC_HetchHetchy_Reset() throws IOException, InterruptedException, AWTException {
		softAssert = new SoftAssert();
		logger = Logger.getLogger("devpinoyLogger");
		logger.debug("Verifying The Request Form Page");
		String requestFormtxt = ESRFStepObj.verifyRequestFormTxt(driver);
		softAssert.assertEquals(requestFormtxt, FileOperations.getTestDataValue("Form Name"));
		logger.debug("Verifying The Request Form Type");
		String requestTypeTxt = ESRFStepObj.verifyRequestTypeTxt(driver);
		softAssert.assertEquals(requestTypeTxt, FileOperations.getTestDataValue("Form Type"));
		logger.debug("Verifying The Category SubTitle");
		String subtitleCategoryTxt = ESRFStepObj.verifySubtitleCategoryTxt(driver);
		softAssert.assertEquals(subtitleCategoryTxt, FileOperations.getTestDataValue("Sub Section_1"));
		logger.debug("Selecting the Category From DropDown");
		ESRFStepObj.selectACategoryOption(driver, FileOperations.getTestDataValue("Category_Option2"));
		logger.debug("Verifying The Description Corresponding to the Category Choosen Appears");
		String categoryDescriptionTxt = ESRFStepObj.verifyCategoryDescriptionTxt(driver);
		// softAssert.assertEquals(categoryDescriptionTxt, "");
		logger.debug("Verifying The Work Item SubTitle");
		String subtitleWorkItemTypeTxt = ESRFStepObj.verifySubtitleWorkItemTypeTxt(driver);
		softAssert.assertEquals(subtitleWorkItemTypeTxt, FileOperations.getTestDataValue("Sub Section_2"));
		logger.debug("Selecting the Work Item From DropDown");
		ESRFStepObj.selectAWITypeOption(driver, FileOperations.getTestDataValue("WI_Option4"));
		logger.debug("Verifying The Description Corresponding to the WI Choosen Appears");
		String wITDescriptionTxt = ESRFStepObj.verifyWITDescriptionTxt(driver);
		softAssert.assertEquals(wITDescriptionTxt, "");
		logger.debug("Selecting the Submission Type From DropDown");
		ESRFStepObj.selectASubmissionTypeOption(driver, FileOperations.getTestDataValue("Submission_Option1"));
		logger.debug("Verifying The Submission Type SubTitle");
		String subtitleSubmissionTypeTxt = ESRFStepObj.verifySubtitleSubmissionTypeTxt(driver);
		softAssert.assertEquals(subtitleSubmissionTypeTxt, FileOperations.getTestDataValue("Sub Section_3"));
		logger.debug("Verifying The Requestor Email");
		String requestorsEmail = ESRFStepObj.verifyRequestorsEmail(driver);
		softAssert.assertEquals(requestorsEmail, FileOperations.getTestDataValue("Email"));
		logger.debug("Verifying The Requestor Name");
		String requestorsName = ESRFStepObj.verifyRequestorsName(driver);
		softAssert.assertEquals(requestorsName, FileOperations.getTestDataValue("Name"));
		logger.debug("Verifying The Notification Check Box is Editable");
		String status_chck = ESRFStepObj.verifyNotificationChckboxNonEditable(driver);
		// softAssert.assertEquals(status_chck, FileOperations.getTestDataValue("Notification_Check"));
		logger.debug("Enter the valid Service Agreement No.");
		ESRFStepObj.addServiceAgreementNo(driver, FileOperations.getTestDataValue("Service Agreement ID"));
		logger.debug("Verify the info field");
		boolean str = ESRFStepObj.verifyInfoFld(driver);
		softAssert.assertEquals(str, true);
		logger.debug("Enter the valid Details Info");
		ESRFStepObj.addDetailsInfo(driver);
		
		logger.debug("Submission of WebForm With All Mandatory Fields");
		logger.debug("Reset the Filled Webform");
		ESRFStepObj.clickOnReset(driver);
		softAssert.assertAll();
		softAssert = new SoftAssert();
		ESRFStepObj.selectACategoryOption(driver, FileOperations.getTestDataValue("Category_Option2"));
		ESRFStepObj.selectAWITypeOption(driver, FileOperations.getTestDataValue("WI_Option4"));
		ESRFStepObj.selectASubmissionTypeOption(driver, FileOperations.getTestDataValue("Submission_Option1"));
		logger.debug("Enter the valid Service Point Id");
		ESRFStepObj.addServicePointId(driver, FileOperations.getTestDataValue("Service Point ID"));
		logger.debug("Enter the valid Random Generated MTR Number");
		ESRFStepObj.addMeterNumber(driver);
		logger.debug("Enter the valid Details Info in the Details Field");
		ESRFStepObj.addDetailsInfo(driver);
		logger.debug("Browsing & Uploading file as in attachment");
		ESRFStepObj.uploadAsAttachment(driver);
		logger.debug("Reset the Filled Webform");
		ESRFStepObj.clickOnReset(driver);
		softAssert.assertAll();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}*/