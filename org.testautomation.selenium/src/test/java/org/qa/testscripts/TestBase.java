package org.qa.testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.qa.pages.Guru99Pages;
import org.qa.pages.YatraPages;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	WebDriver driver;
	YatraPages YatraOR;
	Guru99Pages Guru99OR;
	FileInputStream fileLoc;
	Properties prop;
	SoftAssert SAssert;
	JavascriptExecutor jse;


	@Parameters({"Browser","Url"})
	@BeforeClass
	public void setup(String Browser, String Url) throws IOException, InterruptedException {

		fileLoc = new FileInputStream("E:\\YatraProject\\AutomationProject\\org.testautomation.selenium\\src\\test\\java\\org\\qa\\testdata\\credentials.properties");
		prop = new Properties();
		prop.load(fileLoc); 


		if(Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}if(Browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		}

		driver.get(Url);
		driver.manage().window().maximize();
		YatraOR = new YatraPages(driver);
		Guru99OR = new Guru99Pages(driver);
		SAssert = new SoftAssert();
		jse = (JavascriptExecutor)driver; //ElementClickInterceptedException 


	
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}

	public void captureScreenshot(WebDriver driver,String tName) throws IOException {
		TakesScreenshot  ts = (TakesScreenshot)driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File Target = new File(System.getProperty("user.dir")+ "/ScreenShots/" +tName+".png");
		FileUtils.copyFile(Source,Target);
	}
}

