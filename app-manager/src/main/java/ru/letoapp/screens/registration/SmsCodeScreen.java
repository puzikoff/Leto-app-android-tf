package ru.letoapp.screens.registration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ru.letoapp.AppScreenBase;
import ru.letoapp.screens.popups.EmptySmsCodePopup;

public class SmsCodeScreen extends AppScreenBase{
	
	EmptySmsCodePopup emptySmsCodePopup;
	
	By smsCodeComment = By.id("label_phone_number_comment");
	By smsLabelEnterCode = By.id("label_enter_confirmation_code");
	By smsCodeField = By.id("text_confirmation_code");
	By nextBtn = By.id("button_further");
	By sendSmsAgainBtn = By.id("button_send_confirmation_code_again");	
	By smsLabelNotRecieve = By.id("label_16_4");
	By emptySmsCodePopupLocator = By.id("sdl__message");
	String smsCodeCommentText = "Вам отправлено SMS с кодом подтверждения регистрации на номер";
	String smsLabelEnterCodeText = "Введите код из SMS";
	String nextBtnText = "Далее";
	String smsLabelNotRecieveText = "SMS с кодом не пришло?";

	public SmsCodeScreen(WebDriver driver) {
		super(driver);		
		emptySmsCodePopup = PageFactory.initElements(driver, EmptySmsCodePopup.class);
		emptySmsCodePopup.setDriver(driver);
	}
	
	public EmptySmsCodePopup getEmptySmsCodePopup() {
		return emptySmsCodePopup;
	}
	
	public boolean isEmptySmsCodePopupDisplayed() throws Exception {		
		if(findElement(emptySmsCodePopupLocator, driver) != null) {
			Log.info("Sms code screen: Empty sms code popup displayed");
			return true;
		}
		Log.info("Sms code screen: Empty sms code popup is not displayed");
		return false;
	}

	
	public void verifyScreen() throws Exception {
		Log.info("SMS code screen: verify screen");
		verify.assertTrue(findElement(smsCodeComment, driver).getText().contains(smsCodeCommentText));
		verify.assertEquals(findElement(smsLabelEnterCode, driver).getText(), smsLabelEnterCodeText, "SMS label enter code");
		verify.assertEquals(findElement(nextBtn, driver).getText(), nextBtnText, "Next button text");
		verify.assertEquals(findElement(smsLabelNotRecieve, driver).getText(), smsLabelNotRecieveText, "Not recieve ?");
	}

	public void sendSmsAgainBtnClick() throws Exception {		
		Log.info("SMS Code Screen: Click 'send sms again'");
		findElement(sendSmsAgainBtn, driver).click();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
		delay();
	}

	public void nextBtnClick() throws Exception {					
		Log.info("SMS Code Screen: Click 'Next'");
		findElement(nextBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}

	public void enterSmsCode(String smsCode) throws Exception {		
		Log.info("SMS Code Screen: Enter sms code");
		findElement(smsCodeField, driver).clear();
		findElement(smsCodeField, driver).sendKeys(smsCode);
	}

}
