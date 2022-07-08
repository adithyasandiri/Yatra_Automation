package org.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.qa.utility.ExcelUtility;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_YatraBuses_001 extends TestBase {
	int BeforeFilter;

	@Test(dataProvider = "getData", priority = 1)
	public void SearchBuses(String Depart_Location, String Going_Location) throws InterruptedException, IOException {

		String HomeTitle = "Flight, Cheap Air Tickets , Hotels, Holiday, Trains Package Booking - Yatra.com";

		boolean title = driver.getTitle().contentEquals(HomeTitle);
		if (title) {
			Reporter.log("The user is landed on Yatra home page", true);
			SAssert.assertTrue(title);
			WebElement Buses = YatraOR.getBusModule();
			boolean displayed = Buses.isDisplayed();
			if (displayed) {
				Reporter.log("Buses Module is present in the current webpage!", true);
				SAssert.assertTrue(displayed);
				Buses.click();
				Thread.sleep(2000);

				WebElement DepartField = YatraOR.getDepartFromTextField();
				boolean DepartFieldDisplayed = DepartField.isDisplayed();
				if (DepartFieldDisplayed) {
					Reporter.log("DepartFrom text field  is present in the current webpage!", true);
					SAssert.assertTrue(DepartFieldDisplayed);
					DepartField.clear();
					Thread.sleep(3000);
					DepartField.sendKeys(Depart_Location);

					Thread.sleep(3000);
					DepartField.sendKeys(Keys.ENTER);
					Reporter.log(Depart_Location + " location is selected", true);

				} else {
					captureScreenshot(driver, "SearchBuses");
					Reporter.log("DepartField is not present in the webpage!.", true);
					SAssert.assertTrue(DepartFieldDisplayed);
				}

				// Going To Text Field.....

				WebElement GoingTo = YatraOR.getGoingToTextField();
				boolean GoingToDisplayed = GoingTo.isDisplayed();
				if (GoingToDisplayed) {
					Reporter.log("GoingTo text field  is present in the current webpage!", true);
					SAssert.assertTrue(GoingToDisplayed);

					Thread.sleep(3000);
					GoingTo.sendKeys(Going_Location);

					Thread.sleep(3000);
					// GoingTo.sendKeys(Keys.ENTER);
					// Reporter.log(Going_Location + " Destination is selected",true);
					List<WebElement> Going = YatraOR.getGoingToLocation();
					Reporter.log(Going_Location + " location is selected", true);

					for (WebElement GLocation : Going) {
						Reporter.log(GLocation.getText(), true);
					}
					WebElement Glocate = Going.get(0);
					Glocate.click();
				} else {
					captureScreenshot(driver, "SearchBuses");
					Reporter.log("Going To Text Field is not present in the webpage!", true);
					SAssert.assertTrue(GoingToDisplayed);
				}

				// Date Picker

				WebElement Calender = YatraOR.getCalender();
				boolean DatePicker = Calender.isEnabled();
				if (DatePicker) {
					Reporter.log("Calender is Enabled", true);
					SAssert.assertTrue(DatePicker);
					Calender.click();

					Thread.sleep(2000);
					WebElement Date = YatraOR.getDate();
					boolean Enable = Date.isEnabled();
					if (Enable) {
						Reporter.log("Date in calender is selected", true);
						SAssert.assertTrue(Enable);
						Date.click();
					} else {
						captureScreenshot(driver, "SearchBuses");
						Reporter.log("Date in calender is not selected", true);
						SAssert.assertTrue(Enable);
					}

				} else {
					captureScreenshot(driver, "SearchBuses");
					Reporter.log("Calender Field is not visible", true);
					SAssert.assertTrue(DatePicker);
				}

				// Search Button
				Thread.sleep(2000);
				WebElement SearchButton = YatraOR.getSearchButton();
				boolean button = SearchButton.isDisplayed();
				if (button) {
					Reporter.log("SearchButton is displayed", true);
					SAssert.assertTrue(button);
					SearchButton.click();
				} else {
					captureScreenshot(driver, "SearchBuses");
					Reporter.log("Search Button is not Displayed!", true);
					SAssert.assertTrue(button);
				}

				Thread.sleep(5000);

			}

			else {
				captureScreenshot(driver, "SearchBuses");
				Reporter.log("There is No Bus Tab in the page", true);
				SAssert.assertTrue(displayed);
			}
			boolean TestResult = driver.getTitle().contains(Depart_Location)
					&& driver.getTitle().contains(Going_Location);

			if (TestResult) {
				Reporter.log("TestCase Is Passed", true);
				SAssert.assertTrue(TestResult);
				Reporter.log("==============================================", true);
				List<WebElement> BusesRslt = YatraOR.getBusesResult();
				Reporter.log("Available Buses based on search Field : " + BusesRslt.size(), true);
				BeforeFilter = BusesRslt.size();

				
				  for(WebElement BusResult : BusesRslt) {
				  Reporter.log(BusResult.getText(),true);
				  
				  }
				  
				Reporter.log("==============================================", true);

			} else {
				captureScreenshot(driver, "SearchBuses");
				Reporter.log("TestCase is failed Try agin...!", true);
				SAssert.assertTrue(TestResult);
			}

		} else {
			captureScreenshot(driver, "SearchBuses");
			Reporter.log("Wrong websit!", true);
			Assert.assertTrue(title);
		}

		// driver.navigate().to("https://www.yatra.com/");

		SAssert.assertAll();
	}

	@DataProvider
	public String[][] getData() throws IOException {
		String xFile = "E:\\YatraProject\\AutomationProject\\org.testautomation.selenium\\src\\test\\java\\org\\qa\\testdata\\TestData1.xlsx";
		String xSheetName = "Sheet1";

		int rowCount = ExcelUtility.getRowCoount(xFile, xSheetName);
		int cellCount = ExcelUtility.getCellCount(xFile, xSheetName, rowCount);

		String[][] data = new String[rowCount][cellCount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				data[i - 1][j] = ExcelUtility.getCellData(xFile, xSheetName, i, j);

			}
		}
		return data;

		/*
		 * Object[][] data = new Object[2][2];
		 * 
		 * //DepartLocation data[0][0] ="Hyderabad"; data[1][0] = "Delhi";
		 * 
		 * //Going To Location data[0][1] = "Bangalore"; data[1][1] = "Jaipur";
		 * 
		 * return data;
		 */
	}

}
