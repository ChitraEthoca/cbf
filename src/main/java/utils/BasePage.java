package utils;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class BasePage extends Driver {

	public void waitForElementVisibility(WebDriver driver, By elem) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elem));
	}

	public void waitForElementInvisibility(WebDriver driver, By elem) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
		webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(elem));
	}

	public void waitForElementInVisibility(WebDriver driver, By elem, String text) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
		webDriverWait.until(ExpectedConditions.invisibilityOfElementWithText(elem, text));
	}

	public void waitForALLElementsVisibility(WebDriver driver, By elem) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
		webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elem));
	}

	public void waitForElementClickable(WebDriver driver, By elem) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(elem));
	}

	public void selectDropdownValueFromList(WebDriver driver, By locator, String value) {
		waitForElementVisibility(driver, locator);
		waitForElementClickable(driver, locator);
		Select dropdown = new Select(driver.findElement(locator));
		dropdown.selectByVisibleText(value);
	}

	public String whetherTxtIsLink(WebDriver driver, String value) {
		String partialText = null;
		String[] words = value.split("\\s");
		for (String w : words) {
			if (driver.findElement(By.partialLinkText(w)).isDisplayed()) {
				partialText = w;
			}
		}
		return partialText;
	}
	public void enterKeys(WebDriver driver, By loc, String txt) throws Exception {
		waitForElementVisible(driver, loc, 60, 2);
		driver.findElement(loc).clear();
		driver.findElement(loc).sendKeys(txt);
		Thread.sleep(1000);
	}

	public void waitForElementVisible(WebDriver driver, By by, int waitTime, int scroll) throws Exception {
		if ((driver instanceof FirefoxDriver) | (driver instanceof InternetExplorerDriver)
				| (driver instanceof ChromeDriver)) {
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			} catch (Exception e) {
				Reporter.log("Element was not visible in " + waitTime + " sec");
				throw e;
			}
		}
	}
	
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().equals(fileName))
	            return flag=true;
	            }

	    return flag;
	}

	public void scrollToElement(WebDriver driver, By elem) {
		waitForElementVisibility(driver, elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(elem));
	}

	public void scrollDown(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,200)");
	}

	public void scrollToBottom(WebDriver driver) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
	}
	
	protected boolean isElementPresent(WebDriver driver,By by){
        try{
            driver.findElement(by);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }


	public void enterValue(WebDriver driver, By locator, String value) {
		waitForElementVisibility(driver, locator);
		waitForElementClickable(driver, locator);
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(value);
	}

	public void clearValue(WebDriver driver, By locator) {
		waitForElementVisibility(driver, locator);
		driver.findElement(locator).clear();
	}

	public String generateNumber() {
		long i = (long) (Math.random() * 100000 + 3333300000L);
		return String.valueOf(i);
	}
	
	public static void setClipboardData(String string) {
	    StringSelection stringSelection = new StringSelection(string);
	    Toolkit.getDefaultToolkit().getSystemClipboard()
	             .setContents(stringSelection, null);
	 }

	/**
	 * <h1>This method is scroll to buttom</h1>
	 * <p>
	 * This method scroll to bottom of the any element
	 * 
	 * @param driver
	 *            driver of the browser
	 * @param elmentId
	 *            It is the element id
	 */
	public void scrollDownOfElement(WebDriver driver, String elmentId) {
		waitForElementVisibility(driver, (By.id(elmentId)));
		String myScript = "document.getElementById('" + elmentId + "').scrollTop = document.getElementById('" + elmentId
				+ "').scrollHeight;";
		((JavascriptExecutor) driver).executeScript(myScript);
	}

	public static void waitForNewWindowAndSwitchToIt(WebDriver driver) throws InterruptedException {
		String cHandle = driver.getWindowHandle();
		String newWindowHandle = null;
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Wait for 20 seconds for the new window and throw exception if not found
		for (int i = 0; i < 20; i++) {
			if (allWindowHandles.size() > 1) {
				for (String allHandlers : allWindowHandles) {
					if (!allHandlers.equals(cHandle))
						newWindowHandle = allHandlers;
				}
				driver.switchTo().window(newWindowHandle);
				break;
			} else {
				Thread.sleep(1000);
			}
		}
		if (cHandle == newWindowHandle) {
			throw new RuntimeException("Time out - No window found");
		}
	}

	public static String getCurrentWindowTitle(WebDriver driver) {
		String windowTitle = driver.getTitle();
		return windowTitle;
	}
}