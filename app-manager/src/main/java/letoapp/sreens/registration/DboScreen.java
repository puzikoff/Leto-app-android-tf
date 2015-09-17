package letoapp.sreens.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import letoapp.AppScreenBase;

public class DboScreen extends AppScreenBase {
	
	String actionBarTitle = "Регистрация"; 
	By acceptTermsBtn = By.xpath("//ActionMenuItemView[@id='menu_item_accept_contract']");
	By contextMenuBtn = By.xpath("//ActionMenuItemView[@id='menu_item_more']");
	By sendEmailBtn = By.xpath("//TextView[contains(@value, 'Отправить на почту')]");
	String acceptTermsBtnText = "Принять условия договора";
	
	public DboScreen(WebDriver driver) {
		super(driver);		
	}
	
	public void verifyScreen() {
		verify.assertEquals(getTitleFromActionBar(), actionBarTitle, "Action bar title");
		verify.assertEquals(findElement(acceptTermsBtn, driver).getText(), acceptTermsBtnText, "Accept terms button text");
		verify.assertAll();
	}

	public void acceptLicenseTerms() {		
		waitFor(acceptTermsBtn);
		Log.info("Dbo Screen: Click 'Accept terms' button");
		findElement(acceptTermsBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }		
	}	
	
	public void contextMenuBtnClick() {		
		waitFor(contextMenuBtn);
		Log.info("Dbo Screen: Click menu button");
		findElement(contextMenuBtn, driver).click();
	}
	
	public void sendEmailBtnClick() {		
		waitFor(sendEmailBtn);
		Log.info("Dbo Screen: Click send email button");
		findElement(sendEmailBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }		
	}

}
