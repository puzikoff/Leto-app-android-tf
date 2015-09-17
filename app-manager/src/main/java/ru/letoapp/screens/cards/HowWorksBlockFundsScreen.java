package ru.letoapp.screens.cards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;


public class HowWorksBlockFundsScreen extends AppScreenBase{
	String title = "Как работает запрет трат?";
	By howWorksBlockFunds = By.xpath("//TextView[@id='label_instructions']");
	//String howWorksBlockFundsText = "При включении запрета трат все операции\nсписания денег с карты вне приложения станут\nневозможными. Запрет трат можно выключить в\nлюбой момент.";
	String howWorksBlockFundsText = "При включении запрета трат все операции списания денег с карты вне приложения станут невозможными. Запрет трат можно выключить в любой момент.";
	public HowWorksBlockFundsScreen(WebDriver driver) {
		super(driver);
	}
	
	public void verify() {
		Log.info("How works block funds screen: verify");
		verify.assertEquals(getTitleFromActionBar(), title);
		Log.info("How works block funds text:  " + findElement(howWorksBlockFunds, driver).getText());
		verify.assertEquals(findElement(howWorksBlockFunds, driver).getText(), howWorksBlockFundsText, "How works block funds text");
		verify.assertAll();
	}

}
