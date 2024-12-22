package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverfoxAddressDetails {
	@FindBy(xpath = "(//input[@type='number'])[1]")private WebElement pincode;
	@FindBy(id = "want-expert")private WebElement mobileNo;
	@FindBy(xpath = "//div[text()='Continue']")private WebElement continueButton;
	
	public CoverfoxAddressDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	public void sendpincode(String pin) {
		Reporter.log("enterring pin", true);
		pincode.sendKeys(pin);
		
	}
	public void sendmobileno(String mobNo) {
		Reporter.log("enterring mobile", true);
		mobileNo.sendKeys(mobNo);
	}
	public void clickOnContinueButton() {
		Reporter.log("clicking button", true);
		continueButton.click();
	}

}
