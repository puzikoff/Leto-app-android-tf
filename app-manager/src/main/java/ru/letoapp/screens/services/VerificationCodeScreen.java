package ru.letoapp.screens.services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;


public class VerificationCodeScreen extends AppScreenBase{	
	
	By codeField = By.xpath("//MaskedEditText");
	By nextBtn = By.xpath("//Button[@id='button']");
	By comission = By.xpath("//TextView[@value='КОМИССИЯ']/following-sibling::LinearLayout/EditText");
	By amount = By.xpath("//TextView[@value='СУММА']/following-sibling::LinearLayout/EditText");
	By phoneNumber = By.xpath("//TextView[@value='НОМЕР ТЕЛЕФОНА']/following-sibling::LinearLayout/WeakMaskedEditText");

	public VerificationCodeScreen(WebDriver driver) {
		super(driver);
	}
	
	public void enterVerificationCode(String vc) {
		Log.info("Verification code screen: enter vc");
		findElement(codeField, driver).clear();
		findElement(codeField, driver).sendKeys(vc);
		delay();
	}

	public void nextBtnClick() {
		Log.info("Verification code screen: next btn click");
		clickAndWaitSpinerToVanish(nextBtn);
	}
	
	public String getComission() {
		Log.info("Payment tool screen: comission: " + findElement(comission, driver).getText());
		return onlyNumbers(findElement(comission, driver).getText());
	}
	
	public String getAmount() {
		Log.info("Payment tool screen: amount: " + findElement(amount, driver).getText());
		return onlyNumbers(findElement(amount, driver).getText());
	}
	
	public String getPhoneNumber() {
		Log.info("Payment tool screen: phoneNumber: " + findElement(phoneNumber, driver).getText());
		return onlyNumbers(findElement(phoneNumber, driver).getText());
	}
}
