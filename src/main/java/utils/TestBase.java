package utils;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase extends Driver {

	public static String log4jPropertyFilePath = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\log4j.properties";
	public final static Logger logger = Logger.getLogger(TestBase.class.getName());
	public static ExtentReports extentReport;
	public static ExtentTest eTest;
	public static Properties prop;
	public FileInputStream fis = null;
	static String chromeDriverPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
	static String gerkoDriverPath = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";
	static String extentReportPath = System.getProperty("user.dir") + "\\extentReports";
	// static String extentConfigFilePath = System.getProperty("user.dir") +
	// "\\src\\main\\resources\\extent-config.xml";
	// static Log log;

	static {

		extentReport = new ExtentReports(System.getProperty("user.dir") + "\\extentReports\\"
				+ new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss").format(Calendar.getInstance().getTime()) + ".html",
				false);
		// extentReport.loadConfig(new File(extentConfigFilePath));
		extentReport.addSystemInfo("Complex Billing", "Test");
		extentReport.addSystemInfo("Tester", "Chitra");

	}

	public TestBase() {

		prop = new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\configData.properties");

			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// This will initialize page factory web elements of the class who
		// extends this class.
		//PageFactory.initElements(Driver.driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	@BeforeTest()
	public void driverAndExtentReportSetup1() throws Exception {

		logger.info("Initialization");

		/*	
			eTest = extentReport.startTest(method.getName());
			eTest.log(LogStatus.INFO, method.getName() + " test started");*/
	}

	@BeforeMethod()
	public void driverAndExtentReportSetup(Method method) throws Exception {

		// initialization();

		/*loginPage = new LoginPage();
		
		try {
			loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		*/
		eTest = extentReport.startTest(method.getName());
		logger.info(method.getName() + " test started");

		// GenericUtilities.customAlertByJS(method.getName() + " test started");
	}

	@AfterMethod()
	public void afterMethod(ITestResult result) {

		try {
			getResult(result);

			if (result.getStatus() == ITestResult.SUCCESS) {

				String screenshot = Utils.takeScreenShot(result.getName());

				String image = eTest.addScreenCapture(screenshot);
				eTest.log(LogStatus.PASS, "title verification", image);

			}

			else if (result.getStatus() == ITestResult.FAILURE) {
				Thread.sleep(2000);
				String screenshot = Utils.takeScreenShot(result.getName());

				String image = eTest.addScreenCapture(screenshot);
				eTest.log(LogStatus.FAIL, image);
			}
			logger.info("Quitting driver and closing browser");
			// driver.quit();
		}

		catch (Exception e) {

			eTest.log(LogStatus.FAIL, e.getLocalizedMessage());

		}

	}

	@BeforeClass

	public void thisClassTestStarted() {
		logger.info("***** Test case execution of Class " + getClass().getName() + "started******");
	}

	@AfterClass(alwaysRun = true)
	public void endTest() {
		logger.info("***************All test cases of Class " + getClass().getName() + " executed******");

	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() throws Exception {
		// to delete directory
		FileUtils.deleteDirectory(extentReportPath);
		FileUtils.mkdir(extentReportPath);
		// extent report related code below
		extentReport.endTest(eTest);
		extentReport.flush();
		Thread.sleep(1000);

		logger.info("*********** All test classes run. Extent report generated and put in : " + extentReportPath
				+ " .Quitting browser**********");

	}

	// extent report related
	public void getResult(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {

			eTest.log(LogStatus.PASS, result.getName() + " test is pass");

		} else if (result.getStatus() == ITestResult.SKIP) {

			eTest.log(LogStatus.SKIP, result.getName() + " Test is skipped and reason is : " + result.getThrowable());

		} else if (result.getStatus() == ITestResult.FAILURE) {

			eTest.log(LogStatus.FAIL, result.getName() + " Test is failed and reason is : " + result.getThrowable());
		}

		else if (result.getStatus() == ITestResult.STARTED) {

			eTest.log(LogStatus.INFO, result.getName() + " - Test is started");
		}

	}

}