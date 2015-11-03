package ru.letoapp.screens.services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import ru.letoapp.AppScreenBase;


public class ChangePaymentDateScreen extends AppScreenBase{
	String title = "Меняю дату платежа";
	By serviceHint = By.xpath("//TextView[@id='label_content']");
	String serviceHintText = "Можно выбрать любое число с 4-го по 28-е. Максимальная величина переноса даты - 15 дней от текущего платежа";
	By commisionBlock = By.xpath("//TextView[@value='Комиссия за подключение']");
	By connectionPossibilityBlock = By.xpath("//TextView[@value='Возможность подключения']");
	By calendarBlock = By.xpath("//TextView[@value='Выберите новую дату']");
	By serviceChangesTitle = By.xpath("//TextView[@id='label_title'][@value='ЧТО БУДЕТ, ЕСЛИ ИЗМЕНИТЬ ДАТУ ПЛАТЕЖА?']");
	By nextPaymentBlock = By.xpath("//TextView[@value='Следующий платёж']");
	By closingDateBlock = By.xpath("//TextView[@value='Плановый срок погашения']");
	By connectBtn = By.xpath("//Button[@id='button']");
	By differenceBlock = By.xpath("//TextView[contains(@value, 'Вы уплатите')] ");
	
	public ChangePaymentDateScreen(WebDriver driver) {
		super(driver);
	}
	
	public void connectBtnClick() throws Exception {
		Log.info("Change Payment Date screen: connect button click");
		findElement(connectBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }		
	}
	
	public void verifyBeforeCalculationCard() throws Exception{
		Log.info("Card screen, Change Payment Date screen: verify before calculation");
		verify.assertEquals(getTitleFromActionBar(), title, "Title");
		verify.assertEquals(findElement(serviceHint, driver).getText(),  serviceHintText, "Service hint text");
		verify.assertTrue(findElement(connectionPossibilityBlock, driver).isDisplayed(), "Connection possibility block");
		verify.assertTrue(findElement(calendarBlock, driver).isDisplayed(), "Calendar block");
		verify.assertAll();		
	}
	
	public void verifyAfterCalculationLoan() throws Exception{
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
	
	public void verifyBeforeCalculationLoan() throws Exception{
		Log.info("Loan screen, Change Payment Date screen: verify before calculation");
		verify.assertEquals(getTitleFromActionBar(), title, "Title");
		verify.assertEquals(findElement(serviceHint, driver).getText(),  serviceHintText, "Service hint text");
		verify.assertTrue(findElement(connectionPossibilityBlock, driver) != null, "Connection possibility block");
		verify.assertTrue(findElement(calendarBlock, driver).isDisplayed(), "Calendar block");
		verify.assertAll();		
	}
	
	public void verifyAfterCalculationCard() throws Exception{
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
	
	public void chooseNewDate(String date) throws Exception {
		Log.info("Change payment date screen: Choose date: " + date);
		Assert.assertTrue(isElementClickable(By.xpath("//TextView[@id='label_day_of_month'][@value='" + date + "']")), "Change payment date screen: claculated new payment date is clickable");		
		clickAndWaitSpinerToVanish(By.xpath("//TextView[@id='label_day_of_month'][@value='" + date + "']"));
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
