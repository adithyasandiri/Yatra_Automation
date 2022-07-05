package org.qa.testscripts;

import org.testng.annotations.Test;

public class TC_Guru99_001 extends TestBase {
	
	@Test
	public void LoginAcion() {
		
		Guru99OR.getUserNameTxtField().sendKeys(prop.getProperty("Uname"));
		Guru99OR.getPwd().sendKeys(prop.getProperty("Pwd"));
		Guru99OR.getSubmit().click();
		
	}

}
