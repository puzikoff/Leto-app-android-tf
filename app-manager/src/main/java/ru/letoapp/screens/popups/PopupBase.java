package ru.letoapp.screens.popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.ScreenBase;

public class PopupBase extends ScreenBase{
	
	By title = By.id("sdl__title");
	By message = By.id("sdl__message");
	By nextBtn = By.id("sdl__positive_button");
	By noBtn = By.id("sdl__negative_button");

	public PopupBase(WebDriver driver) {
		super(driver);
	}
	
	public void nextBtnClick () throws Exception {
		waitForClickable(nextBtn);
		Log.info("Popup: Click next button");
		findElement(nextBtn, driver).click();
		delay();
	}
	
	public void yesBtnClick () throws Exception {
		waitForClickable(nextBtn);
		Log.info("Popup: Click yes button");
		findElement(nextBtn, driver).click();
		delay();
	}
	
	public void noBtnClick () throws Exception {
		waitForClickable(noBtn);
		Log.info("Popup: Click no button");
		findElement(noBtn, driver).click();
		delay();
	}

}
