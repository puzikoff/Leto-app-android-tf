package letoapp.sreens.registration;

import letoapp.AppScreenBase;
import letoapp.sreens.popups.EmptyEmailPopup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SendEmailScreen extends AppScreenBase{	
	
	EmptyEmailPopup emptyEmailPopup;
	
	By emailField = By.id("text_email");
	By sendBtn = By.id("button_send");
	By emptyEmailPopupError = By.xpath("//TextView[@value='Поле «Адрес электронной почты» должно быть заполнено.']");
	By emptyEmailPopupLocator = By.id("sdl__positive_button");
	By title = By.xpath("//TextView[contains(@value, 'На него будет отправлен договор')]");
	
	public SendEmailScreen(WebDriver driver) {
		super(driver);		
		emptyEmailPopup = PageFactory.initElements(driver, EmptyEmailPopup.class);
		emptyEmailPopup.setDriver(driver);
	}
	
	public EmptyEmailPopup getEmptySmsCodePopup() {
		return emptyEmailPopup;
	}
	
	public boolean isEmptySmsCodePopupDisplayed() {		
		if(findElement(emptyEmailPopupLocator, driver) != null) {
			Log.info("Send email screen: Empty email popup displayed");
			return true;
		}
		Log.info("Send email screen: Empty email popup is not displayed");
		return false;
	}

	public void sendBtnClick() {		
		waitFor(sendBtn);		
		Log.info("Send Email Screen: Click send button");
		findElement(sendBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}
	

	public void enterEmail(String email) {
		Log.info("Send Email Screen: Entering email: " + email);
		findElement(emailField, driver).clear();
		findElement(emailField, driver).sendKeys(email);		
	}

}
