package ru.letoapp.screens;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.ScreenBase;

public class ActionBar extends ScreenBase{
	
	By menuBtn = By.xpath("//ImageView[@id='home']");
	By navUpBtn = By.xpath("//ImageView[@id='up']");
	By actionBarTitle = By.xpath("//TextView[@id='action_bar_title']");
	By contactsBtn = By.xpath("//ActionMenuItemView[@id='menu_item_contacts']");
		
	public ActionBar(WebDriver driver) {
		super(driver);
	} 	 
	
	public void menuBtnClick() {
		Log.info("Action bar: Menu button click");
		click(menuBtn);
	}
	 
	public void navUpBtnClick() {
		Log.info("Action bar: Click NavUp button");
		click(navUpBtn);
	}
	 
	public void contactsBtnClick() {		
		Log.info("Action bar: Click contacts button");	
		click(contactsBtn);
	}
	 
	public String getActionBarTitle() {		
		Log.info("Action bar: Get title");
		waitFor(actionBarTitle);
		Log.info("Action bar: Title: " + findElement(actionBarTitle, driver).getText());
		return findElement(actionBarTitle, driver).getText();
	} 

}
