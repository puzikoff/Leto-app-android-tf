package ru.letoapp.screens.registration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ru.letoapp.AppScreenBase;
import ru.letoapp.screens.popups.EmptyAccessCodePopup;
import ru.letoapp.screens.popups.EmptyCardNumberPopup;
import ru.letoapp.screens.popups.IncorrectCardNumberOrAccesCodePopup;

public class CardCredentialsScreen extends AppScreenBase{	
	
	EmptyCardNumberPopup emptyCardNumberPopup;
	EmptyAccessCodePopup emptyAccessCodePopup;
	IncorrectCardNumberOrAccesCodePopup incorrectCardNumberOrAccesCodePopup;
	
	String actionBarTitleText = "Регистрация"; 
	By cardNumberTitle = By.xpath("//MaskedEditText[1]/../TextView[1]");
	By accessCodeTitle = By.xpath("//MaskedEditText[1]/../TextView[2]");
	By accessCodeTip = By.xpath("//MaskedEditText[1]/../TextView[3]");
	String cardNumberTitleText = "Введите номер вашей карты\nЛето Банка";
	String accessCodeTitleText = "Введите 6-значный код доступа";
	String accessCodeTipText = "Мы прислали его в SMS\nпри заключении договора с банком";
	By cardNumberField = By.id("text_card_number");
	By accessCodeField = By.id("text_access_code");
	By nextBtn = By.id("button_further");
	By forgetAccessLink = By.id("button_remind_access_code");
	String forgetAccessLinkText = "Не знаете код доступа?";
	String nextBtnText = "Далее";

	public CardCredentialsScreen(WebDriver driver) {
		super(driver);		
		emptyCardNumberPopup = PageFactory.initElements(driver, EmptyCardNumberPopup.class);
		emptyCardNumberPopup.setDriver(driver);
		emptyAccessCodePopup = PageFactory.initElements(driver, EmptyAccessCodePopup.class);
		emptyAccessCodePopup.setDriver(driver);
		incorrectCardNumberOrAccesCodePopup = PageFactory.initElements(driver, IncorrectCardNumberOrAccesCodePopup.class);
		incorrectCardNumberOrAccesCodePopup.setDriver(driver);
	}
	
	public EmptyCardNumberPopup getEmptyCardNumberPopup() {
		return emptyCardNumberPopup;
	}
	
	public EmptyAccessCodePopup getEmptyAccessCodePopup() {
		return emptyAccessCodePopup;
	}
	
	public IncorrectCardNumberOrAccesCodePopup getIncorrectCardNumberOrAccesCodePopup() {
		return incorrectCardNumberOrAccesCodePopup;
	}
	
	public void verifyScreen() throws Exception {
		verify.assertEquals(getActionBarTitle(), actionBarTitleText, "Action bar title");
		verify.assertEquals(findElement(cardNumberTitle, driver).getText(), cardNumberTitleText, "Card number title");		
		verify.assertEquals(findElement(accessCodeTitle, driver).getText(), accessCodeTitleText, "Access code title");
		verify.assertEquals(findElement(accessCodeTip, driver).getText(), accessCodeTipText, "Access code tip");		
		verify.assertEquals(findElement(nextBtn, driver).getText(), nextBtnText, "Next button text");
		verify.assertEquals(findElement(forgetAccessLink, driver).getText(), forgetAccessLinkText, "Forget Access code link text");
		verify.assertAll();
	}

	public void enterCardNumber(String cardNumber) throws Exception {
		waitFor(cardNumberField);
		Log.info("Card Credentials Screen: Entering card number");
		findElement(cardNumberField, driver).clear();
		findElement(cardNumberField, driver).sendKeys(cardNumber);		
	}

	public void enterAccessCode(String accessCode) throws Exception {
		waitFor(accessCodeField);
		Log.info("Card Credentials Screen: Entering access code");
		findElement(accessCodeField, driver).clear();
		findElement(accessCodeField, driver).sendKeys(accessCode);
	}

	public void NextBtnClick() throws Exception {
		waitFor(nextBtn);
		Log.info("Card Credentials Screen: Click next button");
		findElement(nextBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}

	public void forgotCardNumberBtnClick() throws Exception {
		waitFor(forgetAccessLink);
		Log.info("Card Credentials Screen: Click forget access code or card number button");
		findElement(forgetAccessLink, driver).click();	
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}

}
