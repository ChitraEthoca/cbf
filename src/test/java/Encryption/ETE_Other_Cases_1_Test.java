package Encryption;

import java.io.IOException;

import org.testng.annotations.Test;

import encryption.ETE_Other_Cases_1;
import utils.Log;
import utils.TestBase;

public class ETE_Other_Cases_1_Test extends TestBase{
	
	
	Log log= new Log();

	
	@Test
	public void ETE_Other_Cases_1_TestSteps() throws IOException
	{
		ETE_Other_Cases_1 objETE= new ETE_Other_Cases_1();
		objETE.validateCcbLogin();
		log.info(" CCB login done successfully");
		objETE.searchForAccount("9785716948");
		log.info("Account searched successfully");
		
	}	

}
