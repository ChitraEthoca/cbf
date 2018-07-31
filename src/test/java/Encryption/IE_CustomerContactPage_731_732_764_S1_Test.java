package Encryption;

import org.testng.annotations.Test;

import encryption.IE_CustomerContactPage_731_732_764_S1;
import utils.TestBase;


public class IE_CustomerContactPage_731_732_764_S1_Test extends TestBase {

	@Test()
	public void checkCustomerContact() throws Exception {
		try {

			IE_CustomerContactPage_731_732_764_S1 contactPage_S1 = new IE_CustomerContactPage_731_732_764_S1();

			contactPage_S1.loginIntoApplication();

			contactPage_S1.navigateToWI_AddContact();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			// super.tearDown();
		}

	}
}
