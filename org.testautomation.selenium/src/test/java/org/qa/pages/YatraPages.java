package org.qa.pages;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YatraPages {

	WebDriver driver;

	// Browser Selection
	public YatraPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "booking_engine_buses")
	WebElement BusModule;

	public WebElement getBusModule() {
		return BusModule;
	}

	// Depart From TextField

	@FindBy(name = "bus_leaving")
	WebElement DepartFromTextField;

	public WebElement getDepartFromTextField() {
		return DepartFromTextField;
	}

	@FindAll(@FindBy(xpath = "//*[@id=\"booking_engine_modues\"]/div/div[1]/div[2]/ul[1]/li[1]/div/div/ul/div/div/div/li[1]/span"))
	List<WebElement> DepartLocation;

	public List<WebElement> getDepartLocation() {
		return DepartLocation;
	}

	// GoingTo Text Filed

	@FindBy(name = "bus_dest")
	WebElement GoingToTextField;

	public WebElement getGoingToTextField() {
		return GoingToTextField;
	}

	@FindAll(@FindBy(xpath = "//*[@id=\"booking_engine_modues\"]/div/div[1]/div[2]/ul[1]/li[3]/div/div/ul/div/div/div/li[1]"))
	List<WebElement> GoingToLocation;

	public List<WebElement> getGoingToLocation() {
		return GoingToLocation;
	}

	// Calender

	@FindBy(id = "BE_bus_depart_date")
	WebElement Calender;

	public WebElement getCalender() {
		return Calender;
	}
	/*
	 * @FindBy(id="26/04/2022") WebElement Date; public WebElement getDate() {
	 * return Date; }
	 */

	@FindBy(id = "26/07/2022")
	WebElement Date;

	public WebElement getDate() {
		return Date;
	}
	// Search Button

	@FindBy(id = "BE_bus_search_btn")
	WebElement SearchButton;

	public WebElement getSearchButton() {
		return SearchButton;
	}

	@FindAll(@FindBy(xpath = "//div[@class=\"v-card__text srp-touple\"]"))
	List<WebElement> BusesResult;

	public List<WebElement> getBusesResult() {
		return BusesResult;
	}

	// Locater and WebElement for Filter Function

	@FindBy(className = "fi-down-open-big")
	WebElement Filter;

	public WebElement getFilter() {
		return Filter;
	}

	@FindAll(@FindBy(xpath = "/html/body/div[1]/div/div[4]/div[1]/div[2]/div/div[2]/div[1]"))
	List<WebElement> BusType;

	public List<WebElement> getBusType() {
		return BusType;
	}

	@FindBy(xpath = "//*[@id=\"busDesktop\"]/div/div[4]/div[1]/div[2]/div/div[2]/div[1]/label[1]/span[2]")
	WebElement AcSeater;

	public WebElement getAcSeater() {
		return AcSeater;
	}

	@FindBy(xpath = "//*[@id=\"busDesktop\"]/div/div[4]/div[1]/div[2]/div/div[2]/div[1]/label[1]/span[1]")
	WebElement AcCheckbox;

	public WebElement getAcCheckbox() {
		return AcCheckbox;
	}

	@FindBy(xpath = "//*[@id=\"busDesktop\"]/div/div[4]/div[1]/div[2]/div/div[2]/div[1]/label[3]/span[1]")
	WebElement AcSleeper;

	public WebElement getAcSleeper() {
		return AcSleeper;
	}

	@FindBy(xpath = "//*[@id=\"busDesktop\"]/div/div[4]/div[1]/div[2]/div/div[2]/div[2]/div[1]/label[2]/span[2]")
	WebElement DepartTime;

	public WebElement getDepartTime() {
		return DepartTime;
	}

	@FindBy(xpath = "//*[@id=\"busDesktop\"]/div/div[4]/div[1]/div[2]/div/div[2]/div[2]/div[2]/label[4]/span[2]")
	WebElement ArrivalTime;

	public WebElement getArrivalTime() {
		return ArrivalTime;
	}

	@FindBy(xpath = "//*[@id=\"busDesktop\"]/div/div[4]/div[1]/div[2]/div/div[1]/button[2]/div")
	WebElement ApplyFilters;

	public WebElement getApplyFilters() {
		return ApplyFilters;
	}

	@FindAll(@FindBy(xpath = "//div[@class=\"v-card__text srp-touple\"]"))
	List<WebElement> Result;

	public List<WebElement> getResult() {
		return Result;
	}

	@FindBy(xpath = "//*[@id=\"busDesktop\"]/div/div[4]/div[1]/div[2]/div/div[2]/div[3]/div/div[2]/input")
	WebElement BoardingPoint;

	public WebElement getBoardingPoint() {
		return BoardingPoint;
	}

	@FindBy(xpath = "//*[@id=\"busDesktop\"]/div/div[4]/div[1]/div[2]/div/div[2]/div[4]/div/div[2]/input")
	WebElement DroppingPoint;

	public WebElement getDroppingPoint() {
		return DroppingPoint;
	}

	@FindBy(xpath = "//*[@id=\"busDesktop\"]/div/div[4]/div[1]/div[2]/div/div[2]/div[5]/div/div[2]/input")
	WebElement BusOperators;

	public WebElement getBusOperators() {
		return BusOperators;
	}

	@FindBy(xpath = "/html/body/div[1]/div/div[4]/div[1]/div[2]/div/div[2]/div[3]/div/div[3]/label[1]/span[1]")
	WebElement Boarding;

	public WebElement getBoarding() {
		return Boarding;
	}

	@FindBy(xpath = "/html/body/div[1]/div/div[4]/div[1]/div[2]/div/div[2]/div[4]/div/div[3]/label[1]/span[1]")
	WebElement Dropping;

	public WebElement getDropping() {
		return Dropping;
	}

	@FindBy(xpath = "/html/body/div[1]/div/div[4]/div[1]/div[2]/div/div[2]/div[5]/div/div[3]/label[1]/span[1]")
	WebElement BOperator;

	public WebElement BOperator() {
		return BOperator;
	}

	// SeatSelection test case

	@FindBy(xpath = "/html/body/div[1]/div/div[6]/div[3]/div/div[6]/button/div")
	WebElement SelectSeatBtn;

	public WebElement getSelectSeatBtn() {
		return SelectSeatBtn;
	}


	@FindAll(@FindBy(xpath = "//li[@class='sleeper Sleeper']"))
	List<WebElement> AvailableSeats;
	public List<WebElement> getAvailableSeats(){
		return AvailableSeats;
	}
	@FindAll(@FindBy(xpath="//*[@id=\"city\"]/div/div/div[1]/div"))
	List<WebElement> BoardingPoints;
	public List<WebElement> getBoardingPoints(){
		return BoardingPoints;
	}
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[6]/div[16]/div[1]/section[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
	WebElement SelectBoarding;
	public WebElement getSelectBoarding() {
		return SelectBoarding;
	}
	
	@FindAll(@FindBy(xpath= "//*[@id=\"city\"]/div/div/div[2]/div"))
	List<WebElement> DroppingPoints;
	public List<WebElement> getDroppingPoints(){
		return DroppingPoints;
	}
	@FindAll(@FindBy(xpath="//*[@id=\"city\"]/div/div"))
	List<WebElement> Amount;
	public List<WebElement> getAmount(){
		return Amount;
	}
	@FindBy(xpath="")
	WebElement ConfirmSeats;
	public WebElement getConfirmSeats() {
		return ConfirmSeats;
	}

}
