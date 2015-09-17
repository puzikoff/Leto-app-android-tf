package ru.letoapp.screens.cards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;


public class CreditDetailsScreen extends AppScreenBase{
	By loadingIndicator = By.xpath("//ProgressBar[@id='progress_network_loading']");
	String title = "Платёжная дата";
	By statusBlock = By.xpath("//TextView[@value='СТАТУС']");
	By status = By.xpath("//TextView[@value='СТАТУС']/following-siblings::TextView[@id='label_text']");
	By contractBlock = By.xpath("//TextView[@value='ДОГОВОР']");
	By paymentDateBlock = By.xpath("//TextView[@value='ПЛАТЁЖНАЯ ДАТА']");
	By creditDetails = By.xpath("//TextView[@value='ДЕТАЛИЗАЦИЯ ПО КРЕДИТУ']");
	By paymentComposition = By.xpath("//TextView[@value='СОСТАВ ПЛАТЕЖА']");

	public CreditDetailsScreen(WebDriver driver) {
		super(driver);
	}
	
	public void verify() {
		verify.assertEquals(getTitleFromActionBar(), title, "title");
		verify.assertTrue(findElement(contractBlock, driver).isDisplayed(), "Contract block");
		verify.assertTrue(findElement(paymentDateBlock, driver).isDisplayed(), "Payment date block");
		verify.assertTrue(findElement(statusBlock, driver).isDisplayed(), "Status block");
		if(findElement(statusBlock, driver).getText().contains("Осталось оплатить")) {
			verify.assertTrue(findElement(creditDetails, driver).isDisplayed(), "Credit details");
			verify.assertTrue(findElement(paymentComposition, driver).isDisplayed(), "Payment composition");
		}
		verify.assertAll();
	}
	
	public void waitForVanishLoadingIndicator() {
		waitForVanish(loadingIndicator);
	}

}
