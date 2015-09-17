package ru.letoapp.screens.loans;

import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;


public class LoanContractScreen extends AppScreenBase{	
	private String titleText = "Договор";

	public LoanContractScreen(WebDriver driver) {
		super(driver);
	}

	public void verify() {
		verify.assertTrue(getTitleFromActionBar().contains(titleText ), "Loan contract screen: title");
		verify.assertAll();		
	}

}
