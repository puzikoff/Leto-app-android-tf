package ru.letoapp.screens.services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import ru.letoapp.AppScreenBase;


public class ChangePaymentDateScreen extends AppScreenBase{
	String title = "Меняю дату платежа";
	By serviceHint = By.xpath("//TextView[@id='label_content']");
	String serviceHintText = "Можно выбрать любое число с 4-го по 28-е. Максимальная величина переноса даты - 15 дней от текущего платежа";
	By commisionBlock = By.xpath("//TextView[@value='КОМИССИЯ ЗА ПОДКЛЮЧЕНИЕ']");
	By connectionPossibilityBlock = By.xpath("//TextView[@value='ВОЗМОЖНОСТЬ ПОДКЛЮЧЕНИЯ']");
	By calendarBlock = By.xpath("//TextView[@value='ВЫБЕРИТЕ НОВУЮ ДАТУ']");
	By serviceChangesTitle = By.xpath("//TextView[@id='label_title'][@value='ЧТО БУДЕТ, ЕСЛИ ИЗМЕНИТЬ ДАТУ ПЛАТЕЖА?']");
	By nextPaymentBlock = By.xpath("//TextView[@value='СЛЕДУЮЩИЙ ПЛАТЁЖ']");
	By closingDateBlock = By.xpath("//TextView[@value='ПЛАНОВЫЙ СРОК ПОГАШЕНИЯ']");
	By connectBtn = By.xpath("//Button[@id='button']");
	By differenceBlock = By.xpath("//TextView[contains(@value, 'ВЫ УПЛАТИТЕ')] ");
	
	public ChangePaymentDateScreen(WebDriver driver) {
		super(driver);
	}
	
	public void connectBtnClick() {
		Log.info("Change Payment Date screen: connect button click");
		findElement(connectBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }		
	}
	
	public void verifyBeforeCalculationCard(){
		Log.info("Card screen, Change Payment Date screen: verify before calculation");
		verify.assertEquals(getTitleFromActionBar(), title, "Title");
		verify.assertEquals(findElement(serviceHint, driver).getText(),  serviceHintText, "Service hint text");
		verify.assertTrue(findElement(connectionPossibilityBlock, driver).isDisplayed(), "Connection possibility block");
		verify.assertTrue(findElement(calendarBlock, driver).isDisplayed(), "Calendar block");
		verify.assertAll();		
	}
	
	public void verifyAfterCalculationLoan(){
		Log.info("Loan screen, Change Payment Date screen: verify after calculation");
		verify.assertEquals(getTitleFromActionBar(), title, "Title");
		verify.assertEquals(findElement(serviceHint, driver).getText(),  serviceHintText, "Service hint text");
		verify.assertTrue(findElement(commisionBlock, driver).isDisplayed(), "Commission block");
		verify.assertTrue(findElement(connectionPossibilityBlock, driver).isDisplayed(), "Connection possibility block");
		verify.assertTrue(findElement(calendarBlock, driver).isDisplayed(), "Calendar block");
		verify.assertTrue(findElement(nextPaymentBlock, driver).isDisplayed(), "Next payment block");
		verify.assertTrue(findElement(closingDateBlock, driver).isDisplayed(), "Closing date block");
		verify.assertTrue(findElement(differenceBlock, driver).isDisplayed(), "Sum difference block");
		verify.assertTrue(findElement(connectBtn, driver).isDisplayed(), "Connect button");
		verify.assertAll();
	}
	
	public void verifyBeforeCalculationLoan(){
		Log.info("Loan screen, Change Payment Date screen: verify before calculation");
		verify.assertEquals(getTitleFromActionBar(), title, "Title");
		verify.assertEquals(findElement(serviceHint, driver).getText(),  serviceHintText, "Service hint text");
		verify.assertTrue(findElement(connectionPossibilityBlock, driver) != null, "Connection possibility block");
		verify.assertTrue(findElement(calendarBlock, driver).isDisplayed(), "Calendar block");
		verify.assertAll();		
	}
	
	public void verifyAfterCalculationCard(){
		Log.info("Card screen, Change Payment Date screen: verify after calculation");
		verify.assertEquals(getTitleFromActionBar(), title, "Title");
		verify.assertEquals(findElement(serviceHint, driver).getText(),  serviceHintText, "Service hint text");
		verify.assertTrue(findElement(commisionBlock, driver).isDisplayed(), "Commission block");
		verify.assertTrue(findElement(connectionPossibilityBlock, driver).isDisplayed(), "Connection possibility block");
		verify.assertTrue(findElement(calendarBlock, driver).isDisplayed(), "Calendar block");
		verify.assertTrue(findElement(nextPaymentBlock, driver).isDisplayed(), "Next payment block");
		verify.assertTrue(findElement(connectBtn, driver).isDisplayed(), "Connect button");
		verify.assertAll();
	}
	
	public void chooseNewDate(String date) {
		Log.info("Change payment date screen: Choose date: " + date);
		Assert.assertTrue(isElementClickable(By.xpath("//TextView[@id='label_day_of_month'][@value='" + date + "']")), "Change payment date screen: claculated new payment date is clickable");
		findElement(By.xpath("//TextView[@id='label_day_of_month'][@value='" + date + "']"), driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }				
	}
	
	public String calculateNewPaymentDate(int paymentDate) {
		Log.info("Calculate new payment date from info tab");		
		if((paymentDate < 5)&&(paymentDate > 1)) { 
			Log.info("New payment date: 5");
			return "5";
		}	
		if((paymentDate < 15)&&(paymentDate >= 5)) {
			Log.info("New payment date: " + (paymentDate + 1));
			return Integer.toString(paymentDate + 1);
		}
		if((paymentDate >= 15)&&(paymentDate <= 28)) {
			Log.info("New payment date: " + (paymentDate - 1));
			return Integer.toString(paymentDate - 1);
		}
		if((paymentDate <= 31)&&(paymentDate > 28 )) {
			Log.info("New payment date: 28");
			return "28";
		}
		else
			return "Can't calculate new payment date";
	}	

}
