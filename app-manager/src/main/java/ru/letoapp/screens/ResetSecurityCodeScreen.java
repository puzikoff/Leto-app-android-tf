package ru.letoapp.screens;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;

public class ResetSecurityCodeScreen extends AppScreenBase{
	
	By resetSecurityCodeBtn = By.xpath("//Button[@id='button_reset_protection_code']");

	public ResetSecurityCodeScreen(WebDriver driver) {
		super(driver);
	}
	
	public void resetSecurityCodeBtnClick() throws Exception {
		Log.info("Reset Security Code Screen: Reset security code button click");
		click(resetSecurityCodeBtn);
	}

}
