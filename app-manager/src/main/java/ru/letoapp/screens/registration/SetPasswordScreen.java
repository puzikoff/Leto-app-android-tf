package ru.letoapp.screens.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;


public class SetPasswordScreen extends AppScreenBase{
	
	By nextBtn = By.id("button_further");
	By passwordField = By.id("text_password");
	By confirmPasswordField = By.id("text_confirm_password");
	By wrongConfirmPasswordError = By.xpath("//TextView[contains(@value, 'Пароли не совпадают')]");
	By weakPasswordError = By.xpath("//TextView[contains(@value, 'Ненадёжный пароль')]");
	By errorPopupLocator = By.id("sdl__message");

	public SetPasswordScreen(WebDriver driver) {
		super(driver);
	}	

	public void enterPassword(String password) throws Exception {		
		Log.info("Set Password Screen: Entering password: " + password);
		findElement(passwordField, driver).clear();
		findElement(passwordField, driver).sendKeys(password);
	}

	public void isWeakPasswordErrorDisplayed() throws Exception {		
		if(findElement(weakPasswordError, driver).isDisplayed())
			Log.info("Set Password Screen: Error: " + findElement(weakPasswordError, driver).getText());
		else
			Log.error("Set Password Screen: No weak password error");
	}

	public void confirmPassword(String confirmPassword) throws Exception {		
		Log.info("Set Password Screen: Confirm password: " + confirmPassword);
		findElement(confirmPasswordField, driver).clear();
		findElement(confirmPasswordField, driver).sendKeys(confirmPassword);
	}

	public void isWrongConfirmPasswordErrorDisplayed() throws Exception {		
		if(findElement(wrongConfirmPasswordError, driver).isDisplayed())
			Log.info("Set Password Screen: Error: " + findElement(wrongConfirmPasswordError, driver).getText());
		else
			Log.error("Set Password Screen: No wrong confirm password error");
	}

	public void nextBtnClick() throws Exception {		
		Log.info("Set Password Screen: Click next button");
		clickAndWaitSpinerToVanish(nextBtn);
		delay();
	}

}
