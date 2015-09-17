package ru.letoapp.screens.popups;

import org.openqa.selenium.WebDriver;

public class NotImplementedPopup extends PopupBase{
	String titleText = "Ошибка…";
	String popupMessageText = "Поле «Логин» должно быть заполнено.";
	String nextBtnText = "Продолжить";	

	public NotImplementedPopup(WebDriver driver) {
		super(driver);
	}

}
