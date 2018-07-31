package utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Utils extends TestBase {

	private static Workbook book;
	//public static WebDriver driver=null;
	@SuppressWarnings("unused")
	private static String filePath = System.getProperty("user.dir") + "\\screenshots\\";
	public static JavascriptExecutor js = (JavascriptExecutor) driver;
	//protected final static Logger log = Logger.getLogger(Utils.class.getName());

	private static Sheet sheet;
	static Log log = new Log();
	// CCB login details
	@FindBy(xpath = "//*[@id=\"userId\"]")
	private static WebElement CCBUserIdEle;
	@FindBy(xpath = "//input[@id=\"password\"]")
	private static WebElement CCBPasswordEle;
	@FindBy(xpath = "//input[@id=\"loginButton\"]")
	private static WebElement CCBLoginBtn;

	@FindBy(id = "phSearchInput")
	WebElement searchBoxEle;

	@FindBy(xpath = "//th[@scope=\"row\"]")
	WebElement WorkItemNumELE;

	public Utils() throws IOException {

		PageFactory.initElements(driver, this);
	}

	public static void acceptAlertPopup(WebDriver driver) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Error....." + e.getMessage());
		}
	}

	/**
	 * Assert Actual and Expected Strings
	 */
	public static String takeScreenShot(String methodName) {
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {

			log.error(e.getLocalizedMessage());
		}
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String destFileName = formater.format(calendar.getTime());
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String DestFile = filePath + methodName + destFileName + ".png";
		try {
			FileUtils.copyFile(scrFile, new File(DestFile));
			System.out.println("***Placed screen shot in " + filePath + " ***");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return DestFile;
	}

	public static void assertAndCompareStrings(String actual, String expected) {

		try {
			Assert.assertEquals(actual, expected);
			log.info("Actual string: [ " + actual + " ] does match with Expected string: [ " + expected + " ]");

		} catch (AssertionError e) {
			log.error("Actual string: [ " + actual + " ] does not match with Expected string: [ " + expected + " ]");

		}

	}

	public static void collectBrowserJSerrorMessages() {
		/*
		 * Below code will collect all f12 broswe console errors and flush to
		 * log file.
		 */
		log.info(" Method to collect Browser console erros called...........");
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : logEntries) {

			log.info(entry.getTimestamp() + " " + entry.getLevel() + " " + entry.getMessage());
		}
	}

	public static void dismissAlertPopup(WebDriver driver) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			log.error("Error....." + e.getMessage());
		}
	}

	public static String getAlertPopupMessage(WebDriver driver) {
		try {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		} catch (NoAlertPresentException e) {
			log.error("Error....." + e.getMessage());
			return null;
		}
	}

	public static String getCurrentSystemDate() {
		DateFormat df = new SimpleDateFormat("MM/dd/YYYY");
		Date dateobj = new Date();
		return df.format(dateobj);
	}

	public static Object[][] getTestData(String sheetName, String sheetPath) {

		log.info("********* Reading data from sheet: " + sheetName);
		FileInputStream file = null;
		try {
			file = new FileInputStream(sheetPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static void switchToFrameByElement(WebDriver driver, WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (Exception e) {
			log.error("Error....." + e.getMessage());
		}
	}

	public static void switchToFrameByIndex(WebDriver driver, int index) {
		try {
			driver.switchTo().frame(index);
		} catch (Exception e) {
			log.error("Error....." + e.getMessage());
		}
	}

	public static void switchToMultipleFrame(WebDriver driver, int frameCount) {
		try {
			for (int i = 0; i < frameCount; i++)
				driver = driver.switchTo().frame(i);
		} catch (Exception e) {
			log.error("Error....." + e.getMessage());
		}
	}

	public static void waitForElemewntToBeClickable(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	/*************************************************************
	 * @author :Chitra
	 * @Method_Name: FileWrite
	 * @Description : Property File Write
	 * @param: FileName-
	 *             Complete path of file
	 * @param: ObName-
	 *             Object to be write into the file
	 * @param: ObValue
	 *             - Value of the Object written to the file
	 ***********************************************************/
	public static void FileWrite(String FileName, String ObName, String ObValue) {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

			BufferedWriter out = new BufferedWriter(new FileWriter("c://output.txt"));

			String inputLine = null;
			do {
				inputLine = in.readLine();
				out.write(inputLine);
				out.newLine();
			} while (!inputLine.equalsIgnoreCase("eof"));
			System.out.print("Write Successful");
			out.close();
			in.close();
		} catch (IOException e1) {
			System.out.println("Error during reading/writing");
		}

	}

	public static void waitForVisibilityOfElement(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void wait(int timeInSeconds) {
		try {
			Thread.sleep(timeInSeconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void pressEnter() {
		try {
			Thread.sleep(5000l);
			Actions ac = new Actions(driver);
			ac.sendKeys(Keys.ENTER).build().perform();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	/*
	 * below code will perform broken links test. All links which are not
	 * working will be caught here.
	 */

	public void brokenLinksTest() throws MalformedURLException, IOException {

		log.info(" Broken links test started for URL : " + driver.getCurrentUrl());

		List<WebElement> list = driver.findElements(By.tagName("a"));

		List<WebElement> ActiveLinks = new ArrayList<WebElement>();

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getAttribute("href") != null) {

				ActiveLinks.add(list.get(i));

			}

		}
		log.info(" Active links are  " + ActiveLinks.size());

		for (int j = 0; j < ActiveLinks.size(); j++) {
			try {
				HttpURLConnection connection = (HttpURLConnection) new URL(ActiveLinks.get(j).getAttribute("href"))
						.openConnection();
				connection.connect();
				connection.disconnect();
				log.info(ActiveLinks.get(j).getAttribute("href") + ".....>" + connection.getResponseMessage());

			}

			catch (Exception e) {

				log.error(".......Broken links test failed for URL : " + ActiveLinks.get(j).getAttribute("href")
						+ " \n " + e + " ..........");

			}
		}
	}

	public static void click(WebElement element) throws Exception {
		try {
			scrollIntoView(element);
			waitForElemewntToBeClickable(element);
			highlighElement(element);
			element.click();
			Thread.sleep(1000);
			log.info("Clicked element-- " + element.toString());
		}

		catch (Exception e) {

			log.info("Unable to click element :" + element);
		}

	}

	public static void customAlertByJS(String alertMessage) throws InterruptedException {

		js.executeScript("alert('" + alertMessage + "')");

		Thread.sleep(2000);
		driver.switchTo().alert().accept();

	}

	// Draws a red border around the found element. Does not set it back anyhow.
	public void drawborder(WebElement element) {
		js.executeScript("arguments[o].style.border='3px solid blue'", element);

	}

	public String getText(WebElement element) {

		waitForVisibilityOfElement(element);
		element.getText();
		log.info("Element text is--" + element.getText());
		return element.getText();

	}

	public static void highlighElement(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.background='magenta'", element);

	}

	public boolean isElementDisplayed(WebElement element) {

		return element.isDisplayed();

	}

	public void javascriptExecutorClick(WebDriver driver, WebElement element) {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				((JavascriptExecutor) driver).executeScript("arguements[0].click(, arg1);", element);
			}
		} catch (Exception e) {
			log.error("Error....." + e.getMessage());
		}
	}

	public void JSscroll(WebElement element) {

		js.executeScript("arguments[0].scrollIntoView(true);", element);
		log.info(" Scrolled to...." + element);
	}

	public static void scrollIntoView(WebElement element) throws Exception {
		highlighElement(element);
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		Thread.sleep(500);

	}

	public void CCBLogin() {
		Driver driverObj = new Driver();
		log.info("CCB login started");

		try {
			
			Utils.sendKeys(CCBUserIdEle, driverObj.CCBLoginUserName());
			Utils.sendKeys(CCBPasswordEle, driverObj.CCBLoginUserPassword());
			Utils.click(CCBLoginBtn);

			log.info("CCB logged in successfully");

		} catch (Exception e) {

			log.error("CCB login failed " + e.getLocalizedMessage());
		}
	}

	public void openWi(String workItemNum) {
		Input data = new Input();
		/*try {
			Thread.sleep(2000);
			sendKeys(searchBoxEle, workItemNum);
			searchBoxEle.sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			click(WorkItemNumELE);
		//	WorkItemNumELE.sendKeys(Keys.ENTER);
			
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		String WIwithoutCustCOntact = data.Read("IE_CustomerContactPage_731_732_764_S1_Test", workItemNum, 1);
		System.out.println(WIwithoutCustCOntact);
		try {

			{
				// switchToTab(0);
				// clickOnWorkItems();
				selectMyWI();

				WebElement WIwithoutContact = driver
						.findElement(By.xpath("//*[contains(text(),'" + WIwithoutCustCOntact + "')]"));
				Utils.scrollIntoView(WIwithoutContact);
				click(WIwithoutContact);
				// util.openWi(WIwithoutCustCOntact);

			}

			Thread.sleep(1000);
		}

		catch (Exception e) {

			Reporter.log(" Unable to open work item" + e.getLocalizedMessage());

		}

	}

	public static void clickOnWorkItems() throws Exception {

		Utils util = new Utils();

		WebElement homebutton = driver.findElement(By.xpath("//*[@href=\"/home/home.jsp\"]"));

		Utils.click(homebutton);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[contains(text(),'Work Items')]")).click();

	}

	public void selectMyWI() throws Exception {
		Select dropdown = new Select(driver.findElement(By.id("fcf")));
		// util.scrollIntoView(driver.findElement(By.id("fcf")));
		dropdown.selectByIndex(3);
	}

	public void scrollIntoViewAndClick(WebElement element) throws Exception {
		try {
			js.executeScript("arguments[0].scrollIntoView(true)", element);
			Thread.sleep(500);
			element.click();
			log.info(" Scrolled to  " + element + " and clicked");
		}

		catch (Exception e) {

			log.error(" Unable to click " + element + " " + e);
		}

	}

	public void scrollToElement(WebDriver driver, WebElement element) {
		Point location = element.getLocation();

		js.executeScript("javascript:window.scrollBy(0," + location.y + ")");
	}

	public void selectByIndex(int index, WebElement element) {

		highlighElement(element);
		Select s = new Select(element);
		s.selectByIndex(index);
		log.info("Selected element --" + index);

	}

	public void selectByName(String name, WebElement element) {

		Select s = new Select(element);
		s.selectByVisibleText(name);
		log.info("Selected element --" + name);

	}

	public void selectUploadFilebyRobot(String path) throws AWTException {

		log.info(" Selecting file using robot class");
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(path);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, selection);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		log.info(" File selected using Robot and path is:- " + path.toString().toUpperCase());

	}

	/**
	 * @author Chitra
	 * @param element
	 *            - Element to which data needs to be entered.
	 * @param keyword-
	 *            The data which needs to be sent to the element.
	 * @throws Exception-
	 *             Throws exception when any of the step fails.
	 */

	public static void sendKeys(WebElement element, String keyword) throws Exception {

		scrollIntoView(element);
		waitForVisibilityOfElement(element);
		element.click();
		element.clear();
		highlighElement(element);
		element.sendKeys(keyword);
		log.info(" Send data " + keyword + " to element : " + element);
	}

	public static void sendkeysActions(WebElement element, String keyword) {

		Actions action = new Actions(driver);
		action.moveToElement(element);
		action.click(element);
		// element.clear();
		action.sendKeys(keyword);
		action.build().perform();
		log.info(" Sent data: " + keyword + " to...." + element);
	}

	public static void switchToDefaultWindow(WebDriver driver) {

		driver.switchTo().defaultContent();
		log.info(" Switching to default window ");
	}

	public static void switchToTab(int tabNo) {

		ArrayList<String> tabsCount = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabsCount.get(tabNo));
		log.info(" Sitched to tab no: " + tabNo);
	}

	public static void switchToFrameById(WebDriver driver, String id) {
		try {

			driver.switchTo().frame(id);
			log.info("Switching to frame : " + id);
		} catch (Exception e) {
			log.error("Error....." + e.getMessage());
		}
	}
	public static boolean switchToFrameByName(WebDriver driver, String strName) {
		try {

			driver.switchTo().frame(strName);
			log.info("Switching to frame : " + strName);
			
			return true;
		} catch (Exception e) {
			log.error("Error....." + e.getMessage());
			return false;
		}
	}
	public static void switchToWindow(int i) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		ArrayList<String> ids = new ArrayList<String>();

		while (itr.hasNext()) {

			ids.add(itr.next());
		}

		driver.switchTo().window(ids.get(i));

	}

	public static void switchToParentWindow() {

		driver.switchTo().defaultContent();

	}

}
