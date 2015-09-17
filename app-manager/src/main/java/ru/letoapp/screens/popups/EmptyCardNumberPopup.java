package ru.letoapp.screens.popups;

import org.openqa.selenium.WebDriver;

public class EmptyCardNumberPopup extends PopupBase{
	
	String titleText = "Ошибка…";
	String popupMessageText = "Поле «Номер карты» должно быть заполнено.";
	String nextBtnText = "Продолжить";

	public EmptyCardNumberPopup(WebDriver driver) {
		super(driver);
	}
	
	public void verifyPopup() {
		Log.info("Empty card number popup: Verify empty login popup");
		verify.assertEquals(findElement(title, driver).getText(), titleText, "Popup title");
		verify.assertEquals(findElement(message, driver).getText(), popupMessageText, "Popup message");
		verify.assertEquals(findElement(nextBtn, driver).getText(), nextBtnText, "Popup next button");
		verify.assertAll();
	}

}
