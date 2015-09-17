package letoapp.sreens.loans;

import org.openqa.selenium.WebDriver;

import letoapp.AppScreenBase;

public class PaymentsScheduleScreen extends AppScreenBase{	
	
	String titleText = "График погашений";

	public PaymentsScheduleScreen(WebDriver driver) {
		super(driver);
	}

	public void verify() {
		verify.assertEquals(getTitleFromActionBar(), titleText, "Payments schedule screen: title");
		verify.assertAll();		
	}

}
