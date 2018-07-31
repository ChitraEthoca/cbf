package Encryption;
/*package tests.Encryption;

import java.util.HashMap;
import java.util.Hashtable;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.framework.core.BaseTest;
import com.automation.framework.core.COCDriverScript;
import com.automation.framework.core.Status;
import com.automation.framework.exceptions.DriverScriptException;
import com.automation.framework.utilities.ObjectRead;
import com.pge.COC.pageObjects.CustomerContactPage_731_732_764_S1;

public class JIRA731_732_764CustomerContact extends BaseTestClass {

	private static String almID = "";
	ObjectRead objectRead;
	BaseTest base;

	@DataProvider(name = "testDataProvider")
	public Object[][] testDataProvider() throws DriverScriptException {
		base = new BaseTest(almID);
		return ObjectRead.getConsolidatedTestDataArray(this.getClass().getSimpleName(), "SFDC");
	}

	@Test(dataProvider = "testDataProvider")
	public void checkCustomerContact(Hashtable<String, String> testData, ITestContext context) throws Exception {
		try {
			super.initializeDriver(testData);
			super.launchApplication(COCDriverScript.globalParamMap.get("url_sfdc"));
			HashMap<String, String> localData = new HashMap<String, String>();
		CustomerContactPage_731_732_764_S1 contactPage_S1 = new CustomerContactPage_731_732_764_S1(driver,localData);

			//CustomerContactPage_731_732_764_S2 contactPage_S2 = new CustomerContactPage_731_732_764_S2(driver, localData);

			// CustomerContactPage_731_732_764 contactPage =
			// newCustomerContactPage_731_732_764(driver, localData);

			//CustomerContactPage_731_732_764_S3S4 contactPage_S3S4 = new CustomerContactPage_731_732_764_S3S4(driver,localData);

			 //CustomerContactPage_731_732_764_S5S6 contactPage_S5S6 = new CustomerContactPage_731_732_764_S5S6(driver,localData);

			contactPage_S1.loginIntoApplication(testData);

			contactPage_S1.navigateToWI_AddContact(testData);

		} catch (Exception e) {
			COCDriverScript.logMessage("testStepFail", e.getMessage(), Status.FAIL);

			e.printStackTrace();
			throw new Exception(e.getMessage());
			
		} finally {

			// Call tear down method

			//super.tearDown();
		}

	}
}
*/