package ru.letoapp.screens;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ru.letoapp.ScreenBase;

public class Drawer extends ScreenBase{
	
	By contactsBtn = By.id("widget_contacts");
	By aboutBankBtn = By.id("widget_about_bank");
	By profileBtn = By.id("widget_user");
	By exitBtn = By.id("widget_logout");

	public Drawer(WebDriver driver) {
		super(driver);		
	}
	
	public void contactsBtnClick() {		
		Log.info("Drawer: Contacts button click");
		click(contactsBtn);
	}
	
	public void aboutBankBtnClick() {		
		Log.info("Drawer: About bank button click");
		click(aboutBankBtn);
	}
	
	public void exitBtnClick() {		
		Log.info("Drawer: Exit button click");
		click(exitBtn);
	}
	
	public boolean isExitButtonVisible() {		
			List <WebElement> exitButns = driver.findElements(exitBtn);
			if(!exitButns.isEmpty()) {
				Log.info("Drawer: Exit button displayed");
				return true;
			}
			Log.info("Drawer: Exit button is not displayed");
			return false;
	}

	public boolean isTemplateDisplayed(String templateName) {
		if(findElement(By.xpath("//TextView[@value='" + templateName + "']"), driver).isDisplayed()) {
			Log.info("Drawer: Template '" + templateName + "' exist");
			return true;
		}
		else {
			Log.info("Drawer: No template '" + templateName + "' in drawer");
			return false;
		}
	}

}
