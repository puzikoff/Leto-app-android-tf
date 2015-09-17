package ru.letoapp.screens.popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditDisplayNamePopup extends PopupBase{
	String titleText = "Изменить название";	
	String nextBtnText = "Далее";
	String noBtnText = "Отменить";
	By displayNameField = By.xpath("//EditText");

	public EditDisplayNamePopup(WebDriver driver) {
		super(driver);
	}
	
	public void verifyPopup() {
		Log.info("Edit template name popup: Verify");
		verify.assertEquals(findElement(title, driver).getText(), titleText, "Popup title");		
		verify.assertEquals(findElement(nextBtn, driver).getText(), nextBtnText, "Popup yes button");
		verify.assertEquals(findElement(noBtn, driver).getText(), noBtnText, "Popup no button");
		verify.assertAll();
	}
	
	public void editDisplayName(String newDisplayName) {
		Log.info("Edit template name popup: Edit template name ");
		Log.info("Edit display name block: Old name: " + findElement(displayNameField, driver).getText());
		Log.info("Edit display name block: New name: " + newDisplayName);
		findElement(displayNameField, driver).clear();
		findElement(displayNameField, driver).sendKeys(newDisplayName);	
	}

	
	

}
