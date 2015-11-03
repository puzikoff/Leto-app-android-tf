package ru.letoapp.screens.services;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ru.letoapp.AppScreenBase;
import ru.letoapp.screens.popups.TopUpMethodsPopup;

public class FullRepaymentScreen extends AppScreenBase{
	TopUpMethodsPopup topUpMethodsPopup;
	
	String title = "Полное досрочное";	
	By topUpMethodBlock = By.xpath("//TextView[@value='Каким способом вы будете вносить деньги?']");
	By topUpMethodList = By.xpath("//TextView[@value='Каким способом вы будете вносить деньги?']/following-sibling::LinearLayout");
	By calendarBlock = By.xpath("//TextView[@value='Когда вы планируете это сделать?']");
	By connectBtn = By.xpath("//Button[@id='button']");
	By chosenTopUpMethodBlock = By.xpath("//TextView[@value='Способ']");
	By sumToGrantBlock = By.xpath("//TextView[@value='Cумма для внесения']"); //в слове сумма с-английская
	By planingGrantDateBlock = By.xpath("//TextView[@value='Планируемая дата внесения']");
	By grantDateBlock = By.xpath("//TextView[@value='Ориентировочно деньги зачисляться']");
	By payAttentionBlock = By.xpath("//WeakMaskedEditText[@id='edit_text']");
	By saveFundsBlock = By.xpath("//TextView[@value='Вы экономите на % ']");

	public FullRepaymentScreen(WebDriver driver) {
		super(driver);
		topUpMethodsPopup = PageFactory.initElements(driver, TopUpMethodsPopup.class);
		topUpMethodsPopup.setDriver(driver);
	}
	
	public TopUpMethodsPopup getTopUpMethodsPopup() {
		return topUpMethodsPopup;
	}
	
	public void verifyFullRepaymentFirstStep() throws Exception {
		verify.assertTrue(getTitleFromActionBar().contains(title), "Full repayment screen: title");
		verify.assertTrue(findElement(topUpMethodBlock, driver).isDisplayed(), "Full repayment screen: top up methods");
		verify.assertTrue(findElement(calendarBlock, driver).isDisplayed(), "Full repayment screen: calendar");				
		verify.assertAll();		
	}
	
	public void verifyFullRepaymentSecondStep() throws Exception {
		verify.assertTrue(getTitleFromActionBar().contains(title), "Full repayment screen step 2: title");
		verify.assertTrue(findElement(chosenTopUpMethodBlock, driver).isDisplayed(), "Full repayment screen step 2: Choosen popup method");
		//verify.assertTrue(findElement(sumToGrantBlock, driver).isDisplayed(), "Full repayment screen step 2: Sum to grant");
		verify.assertTrue(findElement(planingGrantDateBlock, driver).isDisplayed(), "Full repayment screen step 2: Planing grant date block");
		verify.assertTrue(findElement(grantDateBlock, driver).isDisplayed(), "Full repayment screen step 2: Grant date block");
		verify.assertTrue(findElement(saveFundsBlock, driver).isDisplayed(), "Full repayment screen step 2: New payment sum or credit will be payed block");				
		verify.assertAll();
	}
	
	public void chooseNewDate(String date) throws Exception {
		Log.info("Full repayment screen: Choose date: " + date);
		Assert.assertTrue(isElementClickable(By.xpath("//TextView[@id='label_day_of_month'][@value='" + date + "']")), "Full repayment screen: claculated new payment date is clickable");
		findElement(By.xpath("//TextView[@id='label_day_of_month'][@value='" + date + "']"), driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }				
	}
	
	public void topUpMethodsListClick() throws Exception {
		Log.info("Full repayment screen: Top up methods list click");
		click(topUpMethodList);
	}
	
	public void connectBtnClick() throws Exception {
		Log.info("Full repayment screen: connect button click");
		clickAndWaitSpinerToVanish(connectBtn);
	}

}
