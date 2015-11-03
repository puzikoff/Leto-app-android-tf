package ru.letoapp.screens.services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;


public class SkipPaymentScreen extends AppScreenBase{
	String title = "Пропускаю платеж";
	By hint = By.xpath("//TextView[@id='label_content']");
	String hintText = "При необходимости можно пропустить текущий платёж, увеличив срок кредита. Размер следующего платежа не увеличивается";
	By connectionPossibilityBlock = By.xpath("//TextView[@value='Возможность подключения']");
	By nextPaymentDateBlock = By.xpath("//TextView[@value='Дата следующего платежа']");
	By nextPaymentValue = By.xpath("//TextView[@value='Дата следующего платежа']/following::TextView[1]");
	By nextPaymentBlock = By.xpath("//TextView[@value='Следующий платёж']");
	By closingDateBlock = By.xpath("//TextView[@value='Плановый срок погашения']");
	By paymentDifferenceBlock = By.xpath("//TextView[contains(@value, 'Вы уплатите')]");	
	By connectBtn = By.xpath("//Button[@id='button']");
	
	public SkipPaymentScreen(WebDriver driver) {
		super(driver);	
	}
	
	public void verify() throws Exception {
		verify.assertEquals(getTitleFromActionBar(), title, "title");
		verify.assertEquals(findElement(hint, driver).getText(), hintText, "Hint");
		verify.assertTrue(findElement(connectionPossibilityBlock, driver).isDisplayed(), "Connection possibility block");
		verify.assertTrue(findElement(nextPaymentBlock, driver).isDisplayed(), "Nect payment block");
		verify.assertTrue(findElement(closingDateBlock, driver).isDisplayed(), "Closing date block");
		verify.assertTrue(findElement(paymentDifferenceBlock, driver).isDisplayed(), "Payment difference block");
		verify.assertTrue(findElement(connectBtn, driver).isDisplayed(), "Connection button");
	}
	
	public void connectBtnClick() throws Exception{
		Log.info("Skip payment service screen: Connect button click");
		findElement(connectBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}

}
