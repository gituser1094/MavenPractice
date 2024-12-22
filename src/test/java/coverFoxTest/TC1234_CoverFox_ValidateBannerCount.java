package coverFoxTest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import coverFoxBase.Base;
import coverFoxPOM.CoverFoxHealthPlanPage;
import coverFoxPOM.CoverFoxHomePage;
import coverFoxPOM.CoverfoxAddressDetails;
import coverFoxPOM.CoverfoxMemberDetails;
import coverFoxPOM.ResultPage;
import coverFoxUtility.Utility;


public class TC1234_CoverFox_ValidateBannerCount extends Base{
	CoverFoxHomePage homePage;
	CoverFoxHealthPlanPage healthPlanPage;
	CoverfoxMemberDetails memberDetailsPage;
	CoverfoxAddressDetails addressDetailsPage;
	ResultPage resultPage;
	String excelpath=System.getProperty("user.dir")+ "\\DataSheets\\Excelsheet.xlsx";
	String sheetName="Sheet1";
	public static Logger logger;
	@BeforeClass
	public void openApplication() throws IOException, InterruptedException {
		launchBrowser();
		logger=Logger.getLogger("MavenPractice");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("opening application");

		
	}
	@BeforeMethod
	public void enterDetails() throws InterruptedException, EncryptedDocumentException, IOException
	{
	     homePage=new CoverFoxHomePage(driver);
		healthPlanPage=new CoverFoxHealthPlanPage(driver);
		memberDetailsPage=new CoverfoxMemberDetails(driver);
		addressDetailsPage=new CoverfoxAddressDetails(driver);
		resultPage=new ResultPage(driver);
		Thread.sleep(3000);
		homePage.clickOnGenderButton();
		logger.info("click on gender b");
		Thread.sleep(1000);
		healthPlanPage.clickOnNextButton();
		logger.info("click on next b");
		Thread.sleep(1000);
		memberDetailsPage.handleage(Utility.readDataFromExcel(excelpath, sheetName, 0, 0));
		logger.info("handle age");
		memberDetailsPage.clickOnNextButton();
		logger.info("click on next button");
		Thread.sleep(1000);
		logger.warn("enter valid pincode");
		addressDetailsPage.sendpincode(Utility.readDataFromExcel(excelpath, sheetName, 0, 1));
		logger.info("click on enterpin b");
		logger.warn("enter valid mobno");
        addressDetailsPage.sendmobileno(Utility.readDataFromExcel(excelpath, sheetName, 0, 2));
		logger.info("click on entermob");
		addressDetailsPage.clickOnContinueButton();
		logger.info("click on continue b");
		Thread.sleep(3000);
		
	}
  @Test
  public void validatePolicyCount() {
	int textCount = resultPage.getCountFromText();
	int bannerCount = resultPage.getcountFromBanners();
	logger.info("validate result");
	  Assert.assertEquals(textCount, bannerCount,"textCount not match with bannerCount,TCfailed");
	// Assert.fail();
	   }
  @AfterClass
private void closeApplication() {
	  logger.info("closing application");
	closeBrowser();
	
}
}
