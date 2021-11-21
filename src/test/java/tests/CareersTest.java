package tests;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import common.BasePage;
import common.JsonHelper;
import common.publicData;
import pages.ButtomMenu;
import pages.Careers;

public class CareersTest extends BasePage{
	@AfterMethod
	public void testSetUp()
	{
		getUrl(publicData.ENVIRONMENT_URL);
	}
	
	@Test(testName= "Jobs are present in the list and can be inported", description =  "This test case imports all the jobs located on the page", priority = 1)
	public void checkUserCanProcessCredit() throws StreamWriteException, DatabindException, IOException  {
		ButtomMenu buttomMenu = new ButtomMenu(driver);
		buttomMenu.clickOnCareersLink();
		
		Careers careers = new Careers(driver);
		JsonHelper jsonHelper = new JsonHelper();
		
		jsonHelper.generateJsonFile(careers.getJobs(), "careers.json");
		
		assertTrue(careers!= null, "can not find any job in the list");
	}
}
