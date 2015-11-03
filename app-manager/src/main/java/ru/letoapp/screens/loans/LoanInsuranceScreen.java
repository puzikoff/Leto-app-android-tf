package ru.letoapp.screens.loans;

import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;


public class LoanInsuranceScreen extends AppScreenBase{
	
	private String titleText = "Страховая защита";

	public LoanInsuranceScreen(WebDriver driver) {
		super(driver);
	}

	public void verify() throws Exception {
		verify.assertEquals(getTitleFromActionBar(), titleText , "Loan insurance screen: title");
		verify.assertAll();		
	}

}
