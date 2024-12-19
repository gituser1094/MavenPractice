package coverFoxPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ResultPage {
@FindBy(xpath = "//div[contains(text(),'matching Health')]")private WebElement result;
@FindBy(className = "plan-card-container")private List<WebElement> bannersNo;

public  ResultPage(WebDriver driver)
{
	
	PageFactory.initElements(driver, this);
}
public int getCountFromText() {
	Reporter.log("getting policy cout from text display", true);
	String resultInstring = result.getText().substring(0, 2);
	 int countFromText = Integer.parseInt(resultInstring);
	 return countFromText;
	
}
public int getcountFromBanners() {
	Reporter.log("getting policy count from banners", true);
	 int countFromBanner = bannersNo.size();
	 return countFromBanner;
}
/*public void validateresult() {
	 String resultInstring = result.getText().substring(0, 2);
	 int resultNum = Integer.parseInt(resultInstring);
	 int planListNo = bannersNo.size();
	 if(resultNum==planListNo) {
		 System.out.println("correct matching");
	 }else {
		 System.out.println("not matching");
	 }
	 }*/
	}

