package org.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99Pages {
	
	WebDriver driver;
	
	@FindBy(name = "userName")
	WebElement UnameTxtField;
	
	@FindBy(name  ="password")
	WebElement PwdTxtField;
	
	@FindBy(name= "submit")
	WebElement SubmitBtn;
	
	public WebElement getUserNameTxtField() {
		return UnameTxtField;
	}
	
	public WebElement getPwd() {
		return PwdTxtField;
	}
	
	public WebElement getSubmit() {
		return SubmitBtn;
	}
	
	public Guru99Pages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

}
