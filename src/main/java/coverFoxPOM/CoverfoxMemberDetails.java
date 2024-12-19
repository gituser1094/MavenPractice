package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverfoxMemberDetails {
	
	@FindBy(id = "Age-You")private  WebElement agedropdown;
	@FindBy(className = "next-btn") private WebElement next;
	
	public CoverfoxMemberDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void handleage(String age) {
		Reporter.log("enter age", true);
		Select s=new Select(agedropdown);
		s.selectByValue(age+"y");
	}
	public void clickOnNextButton() {
		Reporter.log("click on next button", true);
		next.click();
		
	}

}
