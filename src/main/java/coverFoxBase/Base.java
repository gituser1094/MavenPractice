package coverFoxBase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import coverFoxUtility.Utility;

public class Base {

	protected static WebDriver driver;
	public void launchBrowser() throws IOException, InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get(Utility.readDataFrompropertyfile("url"));
		Reporter.log("lanching browser", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		Reporter.log("waiting", true);
		
	}public void closeBrowser() {
		Reporter.log("closing Browser", true);
		driver.quit();
	}
}
