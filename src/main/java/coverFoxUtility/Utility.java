package coverFoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	public static void takeScreenshot(WebDriver driver,String filename) throws IOException {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
		
		File dest=new File("C:\\Users\\Shree\\eclipse-workspace\\Automation_selenium\\screenshots"+filename+timestamp+".png");
		FileHandler.copy(source, dest);
	}
		
		public static String readDataFromExcel(String excelpath,String sheetname,int rollno,int cellno) throws EncryptedDocumentException, IOException {
			FileInputStream myfile=new FileInputStream(excelpath);
			String value = WorkbookFactory.create(myfile).getSheet(sheetname).getRow(rollno).getCell(cellno).getStringCellValue();
			return value;
	}
		
		public static String readDataFrompropertyfile(String Key) throws IOException {
			Properties prop=new Properties();
			FileInputStream myfile=new FileInputStream("C:\\Users\\Shree\\eclipse-workspace\\Automation_selenium\\config.properties");
			prop.load(myfile);
			String value=prop.getProperty(Key);
			return value;
		}
}
