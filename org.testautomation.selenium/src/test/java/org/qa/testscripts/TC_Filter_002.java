package org.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_Filter_002 extends TC_YatraBuses_001 {
	int AfterFilter;
	@Test(priority = 2,dataProvider = "getData")
	public void YatraFilters(String Depart_Location, String Going_Location) throws IOException, InterruptedException {

		boolean FilterTitle = driver.getTitle().contains(Depart_Location) && driver.getTitle().contains(Going_Location);
		Thread.sleep(2000);
		if (FilterTitle) {
			Reporter.log("User is landed on the desired page", true);
			SAssert.assertTrue(FilterTitle);
			WebElement FilterTab = YatraOR.getFilter();
			boolean Filter = FilterTab.isDisplayed();
			if (Filter) {
				Reporter.log("Filter Tab is Displayed in the page!.", true);
				SAssert.assertTrue(Filter);
				Thread.sleep(2000);
				FilterTab.click();
				Reporter.log("BusType Element is clicked");
				Thread.sleep(2000);
				WebElement Seater = YatraOR.getAcSeater();
				boolean Acseater = Seater.isDisplayed();
				if (Acseater) {
					Reporter.log("AcSeater option is displayed", true);
					SAssert.assertTrue(Acseater);
					Thread.sleep(2000);
					YatraOR.getAcCheckbox().click();
				} else {
					captureScreenshot(driver, "YatraFilters");
					Reporter.log("AcSeater option is not displayed", true);
					SAssert.assertTrue(Acseater);
				}
				WebElement Sleeper = YatraOR.getAcSleeper();
				boolean AcSleeper = Sleeper.isEnabled();
				if (AcSleeper) {
					Reporter.log("AcSleeper checkbox is Enabled", true);
					SAssert.assertTrue(AcSleeper);
					Thread.sleep(2000);
					YatraOR.getAcSleeper().click();
				} else {
					captureScreenshot(driver, "YatraFilters");
					Reporter.log("AcSleeper checkbox is not enabled", true);
					SAssert.assertTrue(AcSleeper);
				}
				WebElement Depart = YatraOR.getDepartTime();
				boolean DepartTime = Depart.isDisplayed();
				if (DepartTime) {
					Reporter.log("DepartTime is Selected", true);
					SAssert.assertTrue(DepartTime);
					Thread.sleep(2000);
					YatraOR.getDepartTime().click();
				} else {
					captureScreenshot(driver, "YatraFilters");
					Reporter.log("DepartTime is not displayed", true);
					SAssert.assertTrue(DepartTime);
				}
				WebElement Arrival = YatraOR.getArrivalTime();
				boolean ArrivalTime = Arrival.isDisplayed();
				if (ArrivalTime) {
					Reporter.log("ArrivalTime is Selected", true);
					SAssert.assertTrue(ArrivalTime);
					Thread.sleep(2000);
					YatraOR.getArrivalTime().click();
				} else {
					captureScreenshot(driver, "YatraFilters");
					Reporter.log("ArrivalTime is not displayed", true);
					SAssert.assertTrue(ArrivalTime);
				}


				/*
				 * WebElement BPoint = YatraOR.getBoardingPoint(); boolean BoardingPoint =
				 * BPoint.isDisplayed(); if(BoardingPoint) {
				 * Reporter.log("BoardingPoint Text Field is Enabled",true);
				 * SAssert.assertTrue(BoardingPoint); Thread.sleep(2000);
				 * YatraOR.getBoardingPoint().sendKeys(BoardingPoints); Thread.sleep(2000);
				 * YatraOR.getBoarding().click();
				 * //YatraOR.getBoardingPoint().sendKeys(Keys.ARROW_DOWN,Keys.ENTER); } else {
				 * captureScreenshot(driver,"YatraFilters");
				 * Reporter.log("BoardingPoint Text Field is not Enabled",true);
				 * SAssert.assertTrue(BoardingPoint);
				 * 
				 * }
				 * 
				 * WebElement DPoint = YatraOR.getDroppingPoint(); boolean DroppingPoint =
				 * DPoint.isDisplayed(); if(DroppingPoint) {
				 * Reporter.log("Dropping Point text Field is Displayed",true);
				 * SAssert.assertTrue(DroppingPoint); Thread.sleep(2000);
				 * YatraOR.getDroppingPoint().sendKeys(DroppingPoints); Thread.sleep(2000);
				 * YatraOR.getDropping().click();
				 * //YatraOR.getDroppingPoint().sendKeys(Keys.ARROW_DOWN,Keys.ENTER); } else {
				 * captureScreenshot(driver,"YatraFilters");
				 * Reporter.log("Dropping Point text Field is not Displayed",true);
				 * SAssert.assertTrue(DroppingPoint); } WebElement Operators =
				 * YatraOR.getBusOperators(); boolean BusOperator = Operators.isDisplayed();
				 * if(BusOperator) { Reporter.log("BusOperators text Field is displayed" ,true);
				 * SAssert.assertTrue(BusOperator); Thread.sleep(2000);
				 * YatraOR.getBusOperators().sendKeys(BusOperators); Thread.sleep(2000);
				 * YatraOR.BOperator().click();
				 * //YatraOR.getBusOperators().sendKeys(Keys.ARROW_DOWN,Keys.ENTER); } else {
				 * captureScreenshot(driver,"YatraFilters");
				 * Reporter.log("BusOperators text Field is displayed",true);
				 * SAssert.assertTrue(BusOperator); }
				 */

				Thread.sleep(2000);
				WebElement ApplyBtn = YatraOR.getApplyFilters();
				boolean ApplyFilterBtn = ApplyBtn.isEnabled();
				if (ApplyFilterBtn) {
					Reporter.log("ApplyFilter button is enabled", true);
					SAssert.assertTrue(ApplyFilterBtn);
					Thread.sleep(2000);
					YatraOR.getApplyFilters().click();
					Thread.sleep(2000);

					List<WebElement> Result = YatraOR.getResult();
					Reporter.log("Available buses based on Filters : " + Result.size(), true);
					AfterFilter = Result.size();
					for (WebElement AvailableBus : Result) {
						Reporter.log(AvailableBus.getText(), true);
					}
					Thread.sleep(2000);
				} else {
					captureScreenshot(driver, "YatraFilters");
					Reporter.log("ApplyFilter is not displayed", true);
					SAssert.assertTrue(ApplyFilterBtn);
				}
				/*
				 * // List<WebElement> BusType = YatraOR.getBusType(); //
				 * System.out.println("Different BusType to choose" + BusType.size()); //
				 * for(WebElement Bus: BusType) { // Reporter.log(Bus.getText()); // }
				 */
			} else {
				captureScreenshot(driver, "YatraFilters");
				Reporter.log("Filter TAb is not Displayed in the page!..", true);
				SAssert.assertTrue(Filter);
			}
		} else {
			captureScreenshot(driver, "YatraFilters");
			Reporter.log("User is landed on the incorrect page!", true);
			SAssert.assertTrue(FilterTitle);
		}

		if(AfterFilter <= BeforeFilter) {
			Reporter.log("BeforeFilter : "+BeforeFilter,true);
			Reporter.log("AfterFilter :" +AfterFilter,true);
			Reporter.log("TestCase is Passed!",true);
		}

		//driver.navigate().to("https://www.yatra.com/");
		
		SAssert.assertAll();
	}

}
