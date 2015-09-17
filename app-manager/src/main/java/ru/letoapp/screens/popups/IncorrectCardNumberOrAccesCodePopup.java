package ru.letoapp.screens.popups;

import org.openqa.selenium.WebDriver;

public class IncorrectCardNumberOrAccesCodePopup extends PopupBase{	

	String titleText = "Ошибка…";
	String popupMessageText = "Неверный номер карты или код доступа. Попробуйте ввести их еще раз.";
	String nextBtnText = "Продолжить";
	
	public IncorrectCardNumberOrAccesCodePopup(WebDriver driver) {
		super(driver);
	}
	
	public void verifyPopup() {
		Log.info("Incorrect card number or access code popup: Verify empty login popup");
		verify.assertEquals(findElement(title, driver).getText(), titleText, "Popup title");
		verify.assertEquals(findElement(message, driver).getText(), popupMessageText, "Popup message");
		verify.assertEquals(findElement(nextBtn, driver).getText(), nextBtnText, "Popup next button");
		verify.assertAll();
	}

}
