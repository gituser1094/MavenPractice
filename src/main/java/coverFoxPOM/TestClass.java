package coverFoxPOM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.coverfox.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		CoverFoxHomePage home=new CoverFoxHomePage(driver);
		home.clickOnGenderButton();
		
		CoverFoxHealthPlanPage health=new CoverFoxHealthPlanPage(driver);
		health.clickOnNextButton();
		
		CoverfoxMemberDetails member=new CoverfoxMemberDetails(driver);
		member.handleage("20y");
		member.clickOnNextButton();
		
		CoverfoxAddressDetails address=new CoverfoxAddressDetails(driver);
		address.sendpincode("411046");
		address.sendmobileno("8888888888");
		address.clickOnContinueButton();
		
	//	ResultPage result=new ResultPage(driver);
	//	Thread.sleep(2000);
	//	result.validateresult();
		Thread.sleep(1000);
		driver.quit();
		
		
	 //  ResultPage.
	   
		
	//	ResultPage result=new ResultPage();
	//	result.

	}

}
