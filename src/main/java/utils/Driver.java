package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Driver {

	public static WebDriver driver = null;

	public Driver() {
		
		//PageFactory.initElements(driver, this);
		
		
	}
	
	public static String getRootPath() {
		return System.getProperty("user.dir");

	}

	public static String getBrowserType() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "browserName");
	}

	public String getUrl() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "url");
	}

	public String getUsername() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "username");
	}

	public String getPassword() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "password");
	}

	public String getUrlBA() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "urlBA");
	}

	public String getUsernameBA() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "usernameBA");
	}

	public String getPasswordBA() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "passwordBA");
	}

	// salesforce login as CSR
	public String getUrlTestSalesforce() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "urlTestSalesforce");
	}

	public String getUsernameCSRTestSalesforce() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "usernameCSRTestSalesforce");
	}

	public String getPasswordCSRTestSalesforce() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "passwordCSRTestSalesforce");
	}

	// salesforce login as Admin
	public String getUsernameAdminTestSalesforce() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "usernameAdminTestSalesforce");
	}

	public String getPasswordAdminTestSalesforce() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "passwordAdminTestSalesforce");
	}
	// CCB login details

	public String CCBLoginUserName() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "CCBUserID");
	}

	public String CCBLoginUserPassword() {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		return fileOperations.getValueFromPropertyFile(constants.CONFIG_WEB_FILE_PATH, "CCBPassword");
	}

	public void writeErrorInLogFile(LogEntries logEntries, String currentURL) throws IOException {
		FileOperations fileOperations = new FileOperations();
		Constants constants = new Constants();
		fileOperations.writeJSErrorInLogFile(constants.CONFIG_WEB_ERROR_LOG_PATH, logEntries, currentURL);
	}

	public static WebDriver initialization()  {
		try {
		String browserName = getBrowserType();
		if (browserName.equalsIgnoreCase("chrome") || browserName.equalsIgnoreCase("ch")) {
			System.setProperty("webdriver.chrome.driver", "C://Users//c4p4//workspace//CBFinal//lib//chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);

			driver = new ChromeDriver(cap);
			driver.manage().window().maximize();

		} else if (browserName.equalsIgnoreCase("internet explorer") || browserName.equalsIgnoreCase("ie")) {

			
				System.setProperty("webdriver.ie.driver",
						"C:\\Users\\c4p4\\workspace\\complexbilling\\libs\\IEDriverServer_64.exe");
				

				DesiredCapabilities objIEDesiredCapabilities = DesiredCapabilities.internetExplorer();
				objIEDesiredCapabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
				objIEDesiredCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
				objIEDesiredCapabilities
						.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				objIEDesiredCapabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
				objIEDesiredCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
				
				
				driver = new InternetExplorerDriver(objIEDesiredCapabilities);

				System.out.println(driver);
				driver.manage().window().maximize();
			}
		}
			catch (Exception e) {

				e.printStackTrace();
			}
		return driver;
		}
		
	

	public WebDriver getCurrentWebDriver() {
		return driver;
	}

}