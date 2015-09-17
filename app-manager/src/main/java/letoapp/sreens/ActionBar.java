package letoapp.sreens;

import letoapp.ScreenBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
		waitForClickable(menuBtn);
		findElement(menuBtn, driver).click();
		delay();
	}
	 
	public void navUpBtnClick() {
		Log.info("Action bar: Click NavUp button");
		waitForClickable(navUpBtn);
		findElement(navUpBtn, driver).click();			
		delay();
	}
	 
	public void contactsBtnClick() {		
		Log.info("Action bar: Click contacts button");	
		waitForClickable(contactsBtn);
		findElement(contactsBtn, driver).click();
		delay();
	}
	 
	public String getActionBarTitle() {		
		Log.info("Action bar: Get title");
		waitFor(actionBarTitle);
		Log.info("Action bar: Title: " + findElement(actionBarTitle, driver).getText());
		return findElement(actionBarTitle, driver).getText();
	} 

}
