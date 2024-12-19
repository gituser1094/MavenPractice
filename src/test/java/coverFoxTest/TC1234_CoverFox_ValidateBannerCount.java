package coverFoxTest;

import java.io.IOException;

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
	
	@BeforeClass
	public void openApplication() throws IOException, InterruptedException {
		launchBrowser();
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
		Thread.sleep(1000);
		healthPlanPage.clickOnNextButton();
		Thread.sleep(1000);
		memberDetailsPage.handleage(Utility.readDataFromExcel(excelpath, sheetName, 0, 0));
		memberDetailsPage.clickOnNextButton();
		Thread.sleep(1000);
		addressDetailsPage.sendpincode(Utility.readDataFromExcel(excelpath, sheetName, 0, 1));
		addressDetailsPage.sendmobileno(Utility.readDataFromExcel(excelpath, sheetName, 0, 2));
		addressDetailsPage.clickOnContinueButton();
		Thread.sleep(3000);
		
	}
  @Test
  public void validatePolicyCount() {
	int textCount = resultPage.getCountFromText();
	int bannerCount = resultPage.getcountFromBanners();
	  Assert.assertEquals(textCount, bannerCount,"textCount not match with bannerCount,TCfailed");
	//  Assert.fail();
	   }
  @AfterClass
private void closeApplication() {
	closeBrowser();
	
}
}
