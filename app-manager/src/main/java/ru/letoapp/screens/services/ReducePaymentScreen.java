package ru.letoapp.screens.services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;


public class ReducePaymentScreen extends AppScreenBase{
		
	String titleText = "Уменьшаю платеж";
	By hint = By.xpath("//TextView[@id='label_content']");	
	String hintText = "Простое решение поможет снизить размер ежемесячного платежа (начиная со следующего), увеличив срок кредита";
	By connectionPossibilityBlock = By.xpath("//TextView[@value='Возможность подключения']");
	String nextPaymentText = "Следующий платеж";
	By nextPaymentBlock = By.xpath("//TextView[@value='Следующий платёж']");
	By nextPaymentDefault = By.xpath("//ComparatorView_[1]//TextView[@id='label_default']");
	By nextPaymentNew = By.xpath("//ComparatorView_[1]//TextView[@id='label_text']");
	By nextPaymentDifference = By.xpath("//ComparatorView_[1]//TextView[@id='label_comment']");
	String rateText = "Ставка по кредиту";
	By rateBlock = By.xpath("//TextView[@value='Ставка по кредиту']");
	By rateDefault = By.xpath("//ComparatorView_[2]//TextView[@id='label_default']");
	By rateNew = By.xpath("//ComparatorView_[2]//TextView[@id='label_text']");	
	By rateDifference = By.xpath("//ComparatorView_[2]//TextView[@id='label_comment']");
	String planDateText = "Плановый срок погашения";
	By closingDateBlock = By.xpath("//TextView[@value='Плановый срок погашения']");
	By planDateDefault = By.xpath("//ComparatorView_[3]//TextView[@id='label_default']");
	By planDateNew = By.xpath("//ComparatorView_[3]//TextView[@id='label_text']");
	By planDateDifference = By.xpath("//ComparatorView_[3]//TextView[@id='label_comment']");
	By paymentDifferenceBlock = By.xpath("//TextView[contains(@value, 'Вы уплатите')]");	
	By connectBtn = By.xpath("//Button[@id='button']");
	
	public ReducePaymentScreen(WebDriver driver) {
		super(driver);		
	}
	
	public void connectBtnClick() throws Exception{
		Log.info("Reduce paymnet service screen: Connect button click");
		findElement(connectBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}
	
	public void verify() throws Exception {
		verify.assertEquals(getTitleFromActionBar(), titleText, "Reduce payment screen: Title");
		verify.assertTrue(findElement(hint, driver).isDisplayed(), "Reduce payment screen: hint");
		verify.assertTrue(findElement(connectionPossibilityBlock, driver).isDisplayed(), "Reduce payment screen: possibility block");
		verify.assertTrue(findElement(nextPaymentBlock, driver).isDisplayed(), "Reduce payment screen: next payment block");
		verify.assertTrue(findElement(rateBlock, driver).isDisplayed(), "Reduce payment screen: rate block");
		verify.assertTrue(findElement(closingDateBlock, driver).isDisplayed(), "Reduce payment screen: planing close date block");
		verify.assertTrue(findElement(paymentDifferenceBlock, driver).isDisplayed(), "Reduce payment screen: payment difference block");
		verify.assertAll();
	}

}
