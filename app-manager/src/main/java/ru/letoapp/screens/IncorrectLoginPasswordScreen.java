package ru.letoapp.screens;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;

public class IncorrectLoginPasswordScreen extends AppScreenBase{
	
	By title = By.xpath("//Button[@id='button_try_again']/../TextView[1]");
	By subTitle = By.xpath("//Button[@id='button_try_again']/../TextView[2]");
	By resetTip = By.xpath("//Button[@id='button_reset_credentials']/../TextView[1]");
	By resetTip2 = By.xpath("//Button[@id='button_reset_credentials']/../TextView[2]");
	By tryAgainBtn = By.id("button_try_again");
	By resetCredentialsBtn = By.id("button_reset_credentials");
	String titleText = "Логин или пароль неверные";
	String subTitleText = "Попробуйте ввести их ещё раз";
	String tryAgainBtnText = "Попробовать ещё раз";
	String resetTipText = "Если вам не удается вспомнить логин или пароль, вы можете сбросить их и установить заново";	
	String resetTip2Text = "Вам понадобится 16-значный номер вашей платёжной карты Лето Банка или 20-значный номер вашего счёта в Лето Банке, который начинается с цифры 4";
	String resetCredentialsBtnText = "Сбросить логин и пароль";
	
	public IncorrectLoginPasswordScreen(WebDriver driver) {
		super(driver);		
	}
	
	public void verifyScreen() {
		Log.info("Incorrect Login or Password Screen: Verify screen");
		verify.assertEquals(findElement(title, driver).getText(), titleText, "Title");		
		verify.assertEquals(findElement(subTitle, driver).getText(), subTitleText, "Subtitle");		
		verify.assertEquals(findElement(tryAgainBtn, driver).getText(), tryAgainBtnText, "Try again button");		
		verify.assertEquals(findElement(resetTip, driver).getText(), resetTipText, "Reset credentials tip");		
		verify.assertEquals(findElement(resetTip2, driver).getText(), resetTip2Text, "Reset credentials tip 2");		
		verify.assertEquals(findElement(resetCredentialsBtn, driver).getText(), resetCredentialsBtnText, "Reset credentials button");		
		verify.assertAll();		
	}

	public void tryAgainBtnClick() {		
		Log.info("Incorrect Login or Password Screen: Try again button click");
		click(tryAgainBtn);
	}
	
	public void resetCredentialsBtnClick() {
		Log.info("Incorrect Login or Password Screen: Reset credentials button click");
		click(resetCredentialsBtn);				
	}

}
