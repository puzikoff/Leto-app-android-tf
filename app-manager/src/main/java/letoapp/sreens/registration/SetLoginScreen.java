package letoapp.sreens.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import letoapp.AppScreenBase;

public class SetLoginScreen extends AppScreenBase {
	
	By nextBtn = By.id("button_further");
	By loginField = By.id("text_login");

	public SetLoginScreen(WebDriver driver) {
		super(driver);
	}

	public void enterLogin(String login) {
		waitFor(loginField);
		Log.info("Set Login Screen: Entering login: " + login);
		findElement(loginField, driver).clear();
		findElement(loginField, driver).sendKeys(login);
	}

	public void nextBtnClick() {
		waitFor(nextBtn);
		Log.info("Set Login Screen: Click next button");
		findElement(nextBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}

}
