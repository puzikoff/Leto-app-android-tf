package ru.letoapp.screens.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;


public class ForgotCardNumberOrAccessCodeScreen extends AppScreenBase{	
	
	By cardNumberField = By.xpath("//MaskedEditText[1]");	
	By accessCodeField = By.xpath("//MaskedEditText[2]");	
	By nextBtn = By.xpath("//LinearLayout/Button");
	By callBtn = By.id("button_call_phone_number");

	public ForgotCardNumberOrAccessCodeScreen(WebDriver driver) {
		super(driver);
	}

	public void enterCardNumber(String cardNumber) throws Exception {		
		Log.info("Forgot Card Number Or Access Code Screen: Entering card number");
		findElement(cardNumberField, driver).clear();
		findElement(cardNumberField, driver).sendKeys(cardNumber);		
	}

	public void enterAccessCode(String accessCode) throws Exception {		
		Log.info("Forgot Card Number Or Access Code Screen: Entering access code");
		findElement(accessCodeField, driver).clear();
		findElement(accessCodeField, driver).sendKeys(accessCode);
	}

	public void NextBtnClick() throws Exception {		
		Log.info("Forgot Card Number Or Access Code Screen: Click next button");
		clickAndWaitSpinerToVanish(nextBtn);
		delay();
	}

}
