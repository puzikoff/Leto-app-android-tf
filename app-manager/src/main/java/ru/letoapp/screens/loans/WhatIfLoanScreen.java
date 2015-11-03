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
	
	public void payMoreWidgetClick() throws Exception{
		Log.info("What if screen: Pay more widget click");
		click(payMoreWidget);
	}
	
	public void payLessWidgetClick() throws Exception{
		Log.info("What if screen: Pay less widget click");
		click(payLessWidget);
	}
	
	public void payAllWidgetClick() throws Exception{
		Log.info("What if screen: Pay all widget click");
		click(payAllWidget);
	}
	
	public void insuranceCaseWidgetClick() throws Exception{
		Log.info("What if screen: Insurance case widget click");
		click(insuranceCaseWidget);
	}
	
	public void dismissPaymentWidgetClick() throws Exception{
		Log.info("What if screen: Dismiss payment widget click");
		click(dismissPaymentWidget);
	}
	
	public void decreasePaymentWidgetClick() throws Exception{
		Log.info("What if screen: Decrease payment widget click");
		click(decreasePaymentWidget);
	}
	
	public void changePayDateWidgetClick() throws Exception{
		Log.info("What if screen: Change pay date widget click");
		click(changePayDateWidget);
	}
	
	public void payAllClick() throws Exception {		
		Log.info("What if screen: Pay all click");
		clickAndWaitSpinerToVanish(payAll);	
	}
	
	public void payMoreClick() throws Exception {		
		Log.info("What if screen: Pay more click");
		clickAndWaitSpinerToVanish(payMore);
	}
		
	public void turnOffInsuranceClick() throws Exception {		
		Log.info("What if screen: turn Off Insurance click");
		clickAndWaitSpinerToVanish(turnOffInsurance);	
	}
	
	public void changePayDateClick() throws Exception {		
		Log.info("What if screen: changePayDate click");
		clickAndWaitSpinerToVanish(changePayDate);	
	}

	public void verify() throws Exception {
		verify.assertEquals(getTitleFromActionBar(), titleText, "What if screen: title");
		verify.assertAll();		
	}
}
