package ru.letoapp.screens.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;


public class ForgotAccountOrAccessCodeScreen extends AppScreenBase{	
	
	By accountNumberField = By.xpath("//MaskedEditText[1]");
	By accessCodeField = By.xpath("//MaskedEditText[2]");
	By nextBtn = By.xpath("//LinearLayout/Button");
	By callBtn = By.id("button_call_phone_number");

	public ForgotAccountOrAccessCodeScreen(WebDriver driver) {
		super(driver);
	}

	public void enterAccountNumber(String accountNumber) throws Exception {
		waitFor(accountNumberField);
		Log.info("Forgot account Or Access Code Screen: Entering account number");
		findElement(accountNumberField, driver).clear();
		findElement(accountNumberField, driver).sendKeys(accountNumber);		
	}

	public void enterAccessCode(String accessCode) throws Exception {
		waitFor(accessCodeField);
		Log.info("Forgot Account Or Access Code Screen: Entering acces code");
		findElement(accessCodeField, driver).clear();
		findElement(accessCodeField, driver).sendKeys(accessCode);
	}

	public void NextBtnClick() throws Exception {
		waitFor(nextBtn);
		Log.info("Forgot Account Or Access Code Screen: Click next button");
		findElement(nextBtn, driver).click();	
		delay();
	}
}
