package org.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
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
				//SelectSeat.click();
				Thread.sleep(3000);
				/*
				 * WebElement UpperDeck = YatraOR.getSeatPreferance(); Thread.sleep(1000);
				 * boolean SeatPreference = UpperDeck.isDisplayed(); if(SeatPreference) {
				 * Reporter.log("UpperDeck is Selected",true);
				 * SAssert.assertTrue(SeatPreference); Thread.sleep(3000); UpperDeck.click();
				 * Thread.sleep(3000);
				 * 
				 * List<WebElement> AvailableSeats = YatraOR.getAvailableSeats();
				 * Reporter.log("Total Available Seats are : " + AvailableSeats.size(),true);
				 * for(WebElement ASeats:AvailableSeats) {
				 * Reporter.log("AvailableSeats Numbers are : "+ASeats.getText(),true); }
				 * WebElement ChoosingSeat = AvailableSeats.get(1); ChoosingSeat.click();
				 * Thread.sleep(6000);
				 * 
				 * } else { captureScreenshot(driver,"YatraSeatSelection");
				 * Reporter.log("UpperDeck is not Selected");
				 * SAssert.assertTrue(SeatPreference); }
				 */
				
				/*
				 * WebElement AvailableSeats = YatraOR.getAvailableSeats(); Thread.sleep(3000);
				 * AvailableSeats.click(); Thread.sleep(6000);
				 */
				List<WebElement> AvailableSeats = YatraOR.getAvailableSeats();
				 Reporter.log("Total Available Seats are : " + AvailableSeats.size(),true);
				 
			}
			else {
				captureScreenshot(driver, "YatraSeatSelection");
				Reporter.log("SelecctSeat button is enable",true);
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
