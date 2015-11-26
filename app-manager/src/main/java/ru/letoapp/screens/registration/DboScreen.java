package ru.letoapp.screens.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;


public class DboScreen extends AppScreenBase {
	
	String actionBarTitle = "Регистрация"; 
	By acceptTermsBtn = By.xpath("//ActionMenuItemView[@id='menu_item_accept_contract']");
	By contextMenuBtn = By.xpath("//ActionMenuItemView[@id='menu_item_more']");
	By sendEmailBtn = By.xpath("//TextView[contains(@value, 'Отправить на почту')]");
	String acceptTermsBtnText = "Принять условия договора";
	By content = By.xpath("//FrameLayout[@id='content']");
	
	public DboScreen(WebDriver driver) {
		super(driver);		
	}
	
	public void verifyScreen() throws Exception {
		verify.assertEquals(getTitleFromActionBar(), actionBarTitle, "Action bar title");
		verify.assertEquals(findElement(acceptTermsBtn, driver).getText(), acceptTermsBtnText, "Accept terms button text");
		verify.assertAll();
	}

	public void acceptLicenseTerms() throws Exception {		
		Log.info("Dbo Screen: Click 'Accept terms' button");
		clickAndWaitSpinerToVanish(acceptTermsBtn);
		delay();				
	}	
	
	public void contextMenuBtnClick() throws Exception {		
		Log.info("Dbo Screen: Click menu button");
		findElement(contextMenuBtn, driver).click();
	}
	
	public void sendEmailBtnClick() throws Exception {		
		Log.info("Dbo Screen: Click send email button");
		clickAndWaitSpinerToVanish(sendEmailBtn);
		delay();
	}
	
	public void scrollDownDBO(){
		Log.info("Dbo screen: scroll dbo content");
		flick(content, 0, -100, 0);
	}
		
		
		
		
	

}
