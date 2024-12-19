package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHealthPlanPage {

	@FindBy(className="next-btn")private WebElement nextbutton;
	public CoverFoxHealthPlanPage(WebDriver  driver) 
	{
		PageFactory.initElements(driver, this);
	}
    public void clickOnNextButton() 
    {
    	Reporter.log("click on next button", true);
			nextbutton.click();
			}
    
	}

