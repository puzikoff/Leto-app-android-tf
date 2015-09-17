package ru.letoapp.screens.popups;

import org.openqa.selenium.WebDriver;

public class TopUpMethodsPopup extends PopupBase{	
	String titleText = "Каким способом вы будете вносить деньги?";
	String nextBtnText = "Закрыть";

	public TopUpMethodsPopup(WebDriver driver) {
		super(driver);
	}
	
	public void verifyTopUpMethodsPopup() {		
		waitFor(nextBtn);
		Log.info("Topo up methods popup: Verify greeting window");		
		verify.assertEquals(findElement(title, driver).getText(), titleText, "Greeting title");		
		verify.assertEquals(findElement(nextBtn, driver).getText(), nextBtnText, "Next button text");
		verify.assertAll();
	}

}
