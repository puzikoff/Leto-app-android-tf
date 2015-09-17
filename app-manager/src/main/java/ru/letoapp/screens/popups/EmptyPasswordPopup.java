package ru.letoapp.screens.popups;

import org.openqa.selenium.WebDriver;

public class EmptyPasswordPopup extends PopupBase{
	
	String titleText = "Ошибка…";
	String popupMessageText = "Поле «Пароль» должно быть заполнено.";
	String nextBtnText = "Продолжить";

	public EmptyPasswordPopup(WebDriver driver) {
		super(driver);
	}

	public void verifyPopup() {
		Log.info("Empty password popup: Verify empty password popup");
		verify.assertEquals(findElement(title, driver).getText(), titleText);
		verify.assertEquals(findElement(message, driver).getText(), popupMessageText);
		verify.assertEquals(findElement(nextBtn, driver).getText(), nextBtnText);
		verify.assertAll();
	}
	
}
