package ru.letoapp.screens.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;


public class SecurityCodeScreen extends AppScreenBase{
	
	By setTitle = By.xpath("//TextView[contains(@value, 'Введите защитный код')]");
	By confirmTitle = By.xpath("//TextView[contains(@value, 'Повторите защитный код')]");
	By authTitle = By.xpath("//TextView[contains(@value, 'Введите защитный код')]");
	By disMissBtn = By.xpath("//Button[@id='button_miss']");
	By remindSecurityCodeBtn = By.xpath("//Button[@id='button_remind_protection_code']");
	

	public SecurityCodeScreen(WebDriver driver) {
		super(driver);	
	}
	
	public void verifyScreen() {		
	}
	
	public void clickNumber(String number) throws Exception {		
		Log.info("Security Code Screen: Click number: " + number);
		findElement(By.xpath("//Button[@id='button_keyboard_" + number + "']"), driver).click();	
		delay();
	}
	

	public void enterSecurityCode(String code) throws Exception {		
		Log.info("Security Code Screen: Enter code: " + code);
		char[] codeArray = code.toCharArray();
		for(int i = 0; i < 4; ++i) {
			findElement(By.xpath("//Button[@id='button_keyboard_" + String.valueOf(codeArray[i]) + "']"), driver).click();	
			delay();
		}
	}
	
	public void remindSecurityCodeBtnClick() throws Exception{		
		Log.info("Security Code Screen:  remind security code click");
		findElement(remindSecurityCodeBtn, driver).click();
		delay();
	}
	
	public void dismissBtnClick() throws Exception{		
		Log.info("Security Code Screen:  Dismiss button click");
		clickAndWaitSpinerToVanish(disMissBtn);
		delay();
	}

}
