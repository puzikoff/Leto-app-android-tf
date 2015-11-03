package ru.letoapp.screens.services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;


public class EarlyRepaymentScreen extends AppScreenBase{
	String title = "Досрочное погашение";
	By hint = By.xpath("//TextView[@id='label_content']");
	By comissionBlock = By.xpath("//TextView[@value='Комиссия за подключение']");
	By connectBtn = By.xpath("//Button[@id='button']");

	public EarlyRepaymentScreen(WebDriver driver) {
		super(driver);
	}

	public void verify() throws Exception {
		verify.assertEquals(getTitleFromActionBar(), title, "title");
		verify.assertTrue(findElement(comissionBlock, driver).isDisplayed(), "Comission block");
		verify.assertTrue(findElement(connectBtn, driver).isDisplayed(), "Connect button");
		verify.assertAll();		
	}
	
	public void connectBtnClickAndWait() throws Exception {
		Log.info("Early repayment screen: connect button click");
		clickAndWaitSpinerToVanish(connectBtn);
	}

}
