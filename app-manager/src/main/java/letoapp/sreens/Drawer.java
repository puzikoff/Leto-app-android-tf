package letoapp.sreens;

import java.util.List;

import letoapp.ScreenBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Drawer extends ScreenBase{
	
	By contactsBtn = By.id("widget_contacts");
	By aboutBankBtn = By.id("widget_about_bank");
	By profileBtn = By.id("widget_user");
	By exitBtn = By.id("widget_logout");

	public Drawer(WebDriver driver) {
		super(driver);		
	}
	
	public void contactsBtnClick() {
		waitFor(contactsBtn);
		Log.info("Drawer: Contacts button click");
		findElement(contactsBtn, driver).click();
		delay();
	}
	
	public void aboutBankBtnClick() {
		waitFor(aboutBankBtn);
		Log.info("Drawer: About bank button click");
		findElement(aboutBankBtn, driver).click();
		delay();
	}
	
	public void exitBtnClick() {
		waitFor(exitBtn);
		Log.info("Drawer: Exit button click");
		findElement(exitBtn, driver).click();
		delay();
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
		if(findElement(By.xpath("//TextView[@value='" + templateName + "']"), driver).isDisplayed())
			return true;
		else
			return false;
	}

}
