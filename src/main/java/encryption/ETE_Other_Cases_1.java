package encryption;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;
import utils.Log;
import utils.TestBase;
import utils.Utils;

public class ETE_Other_Cases_1 extends TestBase {

	String ccbUrL = "http://cisapptst12:7835/spl/loginPage.jsp";
	Log log = new Log();

	@FindBy(id = "ACCT_ID")
	WebElement accIdEle;
	public WebDriver driver;

	public ETE_Other_Cases_1() {

		driver = Driver.initialization();

		PageFactory.initElements(driver, this);

	}

	public void validateCcbLogin() throws IOException {
		Utils util = new Utils();
		driver.get(ccbUrL);
		util.CCBLogin();

	}

	public void searchForAccount(String strAccNO) {

		try {

			Utils.switchToFrameByName(driver, "main");
			Utils.switchToFrameByName(driver, "tabPage");
			Utils.switchToFrameByName(driver, "srch_frame");
			Utils.sendKeys(accIdEle, strAccNO);
			Utils.pressEnter();
			
		} catch (Exception e) {

			log.error("Unable to search account: " + e.getLocalizedMessage());
			e.printStackTrace();
		}

	}
}
