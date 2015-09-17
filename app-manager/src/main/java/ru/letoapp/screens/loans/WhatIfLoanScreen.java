package ru.letoapp.screens.loans;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;


public class WhatIfLoanScreen extends AppScreenBase{
	
	String titleText = "Что, если?..";
	By payMoreWidget = By.id("widget_what_if_pay_more");
	By payLessWidget = By.id("widget_what_if_pay_less");
	By payAllWidget = By.id("widget_what_if_pay_all");
	By insuranceCaseWidget = By.id("widget_what_if_insurance_case");
	By dismissPaymentWidget = By.id("widget_what_if_pass_case_alt");
	By decreasePaymentWidget = By.id("widget_what_if_decrease_case_alt");
	By changePayDateWidget = By.id("widget_what_if_change_date_case_alt");
	By payMore = By.xpath("//TextView[@value='Что, если я внесу больше?']");
	By payAll = By.xpath("//TextView[@id='Сколько нужно внести, чтобы полностью погасить кредит?']");
	By turnOffInsurance = By.xpath("//TextView[@id='Что, если я отключу страховую защиту?']");
	By changePayDate = By.xpath("//TextView[@id='Что будет, если изменить дату платежа?']");
	

	public WhatIfLoanScreen(WebDriver driver) {
		super(driver);		
	}
	
	public void payMoreWidgetClick(){
		Log.info("What if screen: Pay more widget click");
		findElement(payMoreWidget, driver).click();
	}
	
	public void payLessWidgetClick(){
		Log.info("What if screen: Pay less widget click");
		findElement(payLessWidget, driver).click();
	}
	
	public void payAllWidgetClick(){
		Log.info("What if screen: Pay all widget click");
		findElement(payAllWidget, driver).click();
	}
	
	public void insuranceCaseWidgetClick(){
		Log.info("What if screen: Insurance case widget click");
		findElement(insuranceCaseWidget, driver).click();
	}
	
	public void dismissPaymentWidgetClick(){
		Log.info("What if screen: Dismiss payment widget click");
		findElement(dismissPaymentWidget, driver).click();
	}
	
	public void decreasePaymentWidgetClick(){
		Log.info("What if screen: Decrease payment widget click");
		findElement(decreasePaymentWidget, driver).click();
	}
	
	public void changePayDateWidgetClick(){
		Log.info("What if screen: Change pay date widget click");
		findElement(changePayDateWidget, driver).click();
	}
	
	public void payAllClick() {
		waitFor(payAll);
		Log.info("What if screen: Pay all click");
		findElement(payAll, driver).click();
		delay();		
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}
	
	public void payMoreClick() {
		waitFor(payMore);
		Log.info("What if screen: Pay more click");
		findElement(payMore, driver).click();
		delay();	
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }
	}
		
	public void turnOffInsuranceClick() {
		waitFor(turnOffInsurance);
		Log.info("What if screen: turn Off Insurance click");
		findElement(turnOffInsurance, driver).click();
		delay();	
		if(isWaitPopupDisplayed()) {
			waitForVanishWaitPopup();
	    }	
	}
	
	public void changePayDateClick() {
		waitFor(changePayDate);
		Log.info("What if screen: changePayDate click");
		findElement(changePayDate, driver).click();
		delay();	
		if(isWaitPopupDisplayed()) {
			waitForVanishWaitPopup();
	    }	
	}

	public void verify() {
		verify.assertEquals(getTitleFromActionBar(), titleText, "What if screen: title");
		verify.assertAll();		
	}
}
