package ru.letoapp.screens.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;


public class AccountCredentialsScreen extends AppScreenBase{	
	
	By accountNumberField = By.id("text_account_number");
	By accessCodeField = By.id("text_access_code");
	By nextBtn = By.id("button_further");
	By forgetAccessLink = By.id("button_remind_account_number_or_access_code");
	

	public AccountCredentialsScreen(WebDriver driver) {
		super(driver);	
	}	
	
	public void enterAccountNumber(String accountNumber) throws Exception {	
		Log.info("Account Credentials Screen: Entering account number");
		findElement(accountNumberField, driver).clear();
		findElement(accountNumberField, driver).sendKeys(accountNumber);		
	}

	public void enterAccessCode(String accessCode) throws Exception {		
		Log.info("Account Credentials Screen: Entering access code");
		findElement(accessCodeField, driver).clear();
		findElement(accessCodeField, driver).sendKeys(accessCode);
	}

	public void NextBtnClick() throws Exception {		
		Log.info("Account Credentials Screen: Click next button");
		clickAndWaitSpinerToVanish(nextBtn);
		delay();
	}

	public void forgotAccountBtnClick() throws Exception {		
		Log.info("Account Credentials Screen: Click forget acces code button");
		clickAndWaitSpinerToVanish(forgetAccessLink);
		delay();
	}

}
