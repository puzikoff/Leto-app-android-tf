package letoapp.sreens.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import letoapp.AppScreenBase;

public class SecurityCodeScreen extends AppScreenBase{
	
	By setTitle = By.xpath("//TextView[contains(@value, 'Введите защитный код')]");
	By confirmTitle = By.xpath("//TextView[contains(@value, 'Повторите защитный код')]");
	By authTitle = By.xpath("//TextView[contains(@value, 'Введите защитный код')]");
	By disMissBtn = By.id("button_miss");
	By remindSecurityCodeBtn = By.xpath("//Button[@id='button_remind_protection_code']");
	

	public SecurityCodeScreen(WebDriver driver) {
		super(driver);	
	}
	
	public void verifyScreen() {		
	}
	
	public void clickNumber(String number) {
		waitFor("//RelativeLayout/FrameLayout");
		Log.info("Security Code Screen: Click number: " + number);
		findElement(By.id("button_keyboard_" + number), driver).click();	
		delay();
	}
	
	public void remindSecurityCodeBtnClick(){
		waitFor(remindSecurityCodeBtn);
		Log.info("Security Code Screen:  remind security code click");
		findElement(remindSecurityCodeBtn, driver).click();
		delay();
	}
	
	public void dismissBtnClick(){
		waitFor(disMissBtn);
		Log.info("Security Code Screen:  Dismiss button click");
		findElement(disMissBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}

}
