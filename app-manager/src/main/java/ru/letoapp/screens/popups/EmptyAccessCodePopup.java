package ru.letoapp.screens.popups;

import org.openqa.selenium.WebDriver;

public class EmptyAccessCodePopup extends PopupBase{	
	
	String titleText = "Ошибка…";
	String popupMessageText = "Поле «Код доступа» должно быть заполнено.";
	String nextBtnText = "Продолжить";
	
	public EmptyAccessCodePopup(WebDriver driver) {
		super(driver);
	}
	
	public void verifyPopup() {
		Log.info("Empty access code popup: Verify empty login popup");
		verify.assertEquals(findElement(title, driver).getText(), titleText, "Popup title");
		verify.assertEquals(findElement(message, driver).getText(), popupMessageText, "Popup message");
		verify.assertEquals(findElement(nextBtn, driver).getText(), nextBtnText, "Popup next button");
		verify.assertAll();
	}
}
