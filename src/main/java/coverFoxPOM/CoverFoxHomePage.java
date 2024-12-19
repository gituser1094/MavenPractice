package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHomePage {
	//variable
	//constructor
	//methods
	//WebElwment gender=driver.findelement(By.xpath)

	@FindBy(xpath = "//div[text()='Male']") private WebElement gender;
	public CoverFoxHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void clickOnGenderButton()
	{
		Reporter.log("click on gender button", true);
		gender.click();
	}
	
	
}
