package ru.letoapp.screens;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ru.letoapp.ScreenBase;

public class EditDisplayNameBlock extends ScreenBase{
	
	By editNameBtn = By.id("button_edit");
	By displayName = By.id("label_user_defined_name");
	By labelContractState = By.id("label_contract_state");
	By popupTitle = By.id("sdl__title");
	By editDisplayNamePopupNextBtn = By.id("sdl__positive_button");
	By editDisplayNamePopupCancelBtn = By.id("sdl__negative_button");
	By displayNameField = By.xpath("//EditText");

	public EditDisplayNameBlock(WebDriver driver) {
		super(driver);
	}

	public void editDisplayNameBtnClick() {		
		Log.info("Edit display name block: Click edit button");
		findElement(editNameBtn, driver).click();
		delay();
	}
	
	public String getDisplayName() {
		Log.info("Edit display name block: Get display name");
		Log.info("Edit display name block: Display name: " + findElement(displayName, driver).getText());
		return findElement(displayName, driver).getText();
	}
	
	public String getDisplayNameFromEditPopup(){
		Log.info("Edit display name block: Get display name fron edit popup");
		Log.info("Edit display name block: Display name fron edit popup: " + findElement(displayNameField, driver).getText());
		return findElement(displayNameField, driver).getText();
	}
	
	public String getLabelContractState() {
		List<WebElement> labelContractStates = driver.findElements(labelContractState);
		if(!labelContractStates.isEmpty()) {
			Log.info("Edit display name block: Get label contract state");
			Log.info("Edit display name block: Label contract state: " + findElement(labelContractState, driver).getText());
			return findElement(labelContractState, driver).getText();
		}
		Log.info("Edit display name block: No label contract state");
		return "No label contract state";
	}
	
	public void editDisplayName(String newDisplayName) {
		Log.info("Edit display name block: Edit display name");
		Log.info("Edit display name block: Old name: " + findElement(displayNameField, driver).getText());
		Log.info("Edit display name block: New name: " + newDisplayName);
		findElement(displayNameField, driver).clear();
		findElement(displayNameField, driver).sendKeys(newDisplayName);	
	}
	
	public void editDisplayNamePopupNextBtnClick() {
		Log.info("Edit display name block: Click next");
		findElement(editDisplayNamePopupNextBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }		

	}
	
	public void editDisplayNamePopupCancelBtnClick() {
		Log.info("Edit display name block: Click cancel");
		findElement(editDisplayNamePopupCancelBtn, driver).click();
		delay();
	}

}
