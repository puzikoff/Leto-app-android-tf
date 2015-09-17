package ru.letoapp.screens.popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AndroidPopup extends PopupBase{	
	
	By title = By.id("alertTitle");
	By message = By.id("message");
	By dismiss = By.id("button2");
	By send = By.id("button1");
	
	public AndroidPopup(WebDriver driver) {
		super(driver);		
	}
	
	public void sendClick() {
		Log.info("Android popup: " + findElement(message, driver).getText());
		Log.info("Android popup: Click send");
		findElement(send, driver).click();
	}
	
	public void dismissClick() {
		Log.info("Android popup: " + findElement(message, driver).getText());
		Log.info("Android popup: Click send");
		findElement(dismiss, driver).click();
		
	}

}
