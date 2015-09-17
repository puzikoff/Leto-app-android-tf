package ru.letoapp.screens.popups;

import org.openqa.selenium.WebDriver;

public class ErrorPopup extends PopupBase{	
	
	String titleText = "Ошибка…";
	String titleText2 = "Ошибка";
	String popupMessageText = "";
	String nextBtnText = "Продолжить";

	public ErrorPopup(WebDriver driver) {
		super(driver);
	}

}
