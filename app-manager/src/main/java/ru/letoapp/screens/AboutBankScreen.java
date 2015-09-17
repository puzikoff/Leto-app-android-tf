package ru.letoapp.screens;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;

public class AboutBankScreen extends AppScreenBase{
	
	By aboutBankAndAppBtn = By.id("action_show_app_info");
	By bankRequisitesBtn = By.id("action_show_bank_requisites");
	String title = "О банке";

	public AboutBankScreen(WebDriver driver) {
		super(driver);
	}
	
	public void verify() {
		verify.assertEquals(getTitleFromActionBar(), title);
		verify.assertTrue(findElement(aboutBankAndAppBtn, driver).isDisplayed(), "About bank and application button is displayed");
		verify.assertTrue(findElement(bankRequisitesBtn, driver).isDisplayed(), "Bank requisites button is displayed");
		verify.assertAll();
	}

	public void aboutBankAndAppBtnClick() {		
		Log.info("About bank screen: About bank and application button click");
		click(aboutBankAndAppBtn);		
	}

	public void bankRequisitesBtnClick() {		
		Log.info("About bank screen: Bank requisites button click");
		click(bankRequisitesBtn);
	}

}
