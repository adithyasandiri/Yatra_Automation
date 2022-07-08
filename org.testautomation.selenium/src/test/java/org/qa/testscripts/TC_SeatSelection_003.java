package org.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_SeatSelection_003 extends TC_Filter_002 {
	@Test(priority = 3,dataProvider = "getData")
	public void YatraSeatSelection(String Depart_Location, String Going_Location) throws IOException, InterruptedException {

		boolean SeatSelctionTitle = driver.getTitle().contains(Depart_Location) && driver.getTitle().contains(Going_Location);
		if(SeatSelctionTitle) {
			Reporter.log("User is landed on SeatSelection page",true);
			SAssert.assertTrue(SeatSelctionTitle);
			WebElement SelectSeat = YatraOR.getSelectSeatBtn();
			boolean SelectBtn = SelectSeat.isEnabled();
			if(SelectBtn) {
				Reporter.log("SelecctSeat button is enable",true);
				SAssert.assertTrue(SelectBtn);
				Thread.sleep(3000);

				jse.executeScript("arguments[0].click()", SelectSeat);//ElementClickInterceptedException 
				Thread.sleep(3000);
				
				//Printing Available seats and Selecting the Seats
				List<WebElement> AvailableSeats = YatraOR.getAvailableSeats();
				 Reporter.log("Total Available Seats are : " + AvailableSeats.size(),true);
				 
				 WebElement Seat = AvailableSeats.get(1);
				 Seat.click();
				Thread.sleep(3000);
				
				//Selecting the Boarding Pint
				List<WebElement> BoardingP = YatraOR.getBoardingPoints();
				 Reporter.log("==================================",true);
				 for(WebElement Boarding : BoardingP) {
					 Reporter.log(Boarding.getText(),true);
				 }
				 Reporter.log("==================================",true);
				 Thread.sleep(3000);
				 //WebElement SelectBP = YatraOR.getSelectBoarding();
				 //SelectBP.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
				 //Select select = new Select(SelectBP);
				  //select.selectByVisibleText("Suchitra");
				 //Selecting the Draping point
				 
//				 List<WebElement> DrapingP = YatraOR.getDroppingPoints();
//				 Reporter.log("==================================",true);
//				 for(WebElement Draping : DrapingP) {
//					 Reporter.log(Draping.getText(),true);
//				 }
//				 Reporter.log("==================================",true);
//				 WebElement DP = DrapingP.get(2);
//				 DP.click();
			}
			else {
				captureScreenshot(driver, "YatraSeatSelection");
				Reporter.log("SelecctSeat button is not enable",true);
				SAssert.assertTrue(SelectBtn);
			}
			


		}
		else {
			captureScreenshot(driver, "YatraSeatSelection");
			Reporter.log("Incorrect page please try agin..!",true);
			SAssert.assertTrue(SeatSelctionTitle);
		}


	}

}
