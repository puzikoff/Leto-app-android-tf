package ru.letoapp.screens.popups;

import org.openqa.selenium.WebDriver;

public class TemplateDeleteConfirmationPopup extends PopupBase{
	String titleText = "Информация";
	String popupMessageText = "Вы действительно хотите удалить шаблон?";
	String nextBtnText = "Да";
	String noBtnText = "Нет";

	public TemplateDeleteConfirmationPopup(WebDriver driver) {
		super(driver);
	}
	
	public void verifyPopup() {
		Log.info("Template delete confirmation popup: Verify");
		verify.assertEquals(findElement(title, driver).getText(), titleText, "Popup title");
		verify.assertEquals(findElement(message, driver).getText(), popupMessageText, "Popup message");
		verify.assertEquals(findElement(nextBtn, driver).getText(), nextBtnText, "Popup yes button");
		verify.assertEquals(findElement(noBtn, driver).getText(), noBtnText, "Popup no button");
		verify.assertAll();
	}

}
