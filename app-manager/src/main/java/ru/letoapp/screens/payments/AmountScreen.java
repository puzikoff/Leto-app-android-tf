package ru.letoapp.screens.payments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;
import ru.letoapp.utilities.PropertyReader;


public class AmountScreen extends AppScreenBase{
	By amountField = By.xpath("//EditText[@id='edit_text']");
	By alert = By.id("image_alert_indicator");
	By nextBtn = By.xpath("//Button[@id='button']");
	By tenRubBtn = By.xpath("//Button[@id='button_add_ten']");
	By hundredRubBtn = By.xpath("//Button[@id='button_add_hundred']");
	By thousandRubBtn = By.xpath("//Button[@id='button_add_thousand']");
	By phoneNumber = By.xpath("//TextView[@value='НОМЕР ТЕЛЕФОНА']/following-sibling::LinearLayout/WeakMaskedEditText");
	By phoneNumberBlock = By.xpath("//TextView[@value='НОМЕР ТЕЛЕФОНА']");
	
	public AmountScreen(WebDriver driver) {
		super(driver);
	}
	
	public void verify() {
		verify.assertEquals(getTitleFromActionBar(), PropertyReader.getProperty("payment"), "Amount screen: title");
		verify.assertTrue(findElement(phoneNumberBlock, driver) != null, "Amount screen: phone number block");
		verify.assertAll();
	}
	
	public boolean isAlertDisplayed() {
		return isElementPresent(alert);
	}
	
	public void tenRubBtnClick() {
		Log.info("Amount screen: Ten rub buttob click");
		findElement(tenRubBtn, driver).click();
	}
	
	public void hundredRubBtnClick() {
		Log.info("Amount screen: Hundred rub buttob click");
		findElement(hundredRubBtn, driver).click();
	}
	
	public void thousandRubBtnClick() {
		Log.info("Amount screen: thousand rub buttob click");
		findElement(thousandRubBtn, driver).click();
	}
	
	public void enterAmount(String amount) {
		Log.info("Amount screen: Enter amount");
		findElement(amountField, driver).clear();
		findElement(amountField, driver).sendKeys(amount);
	}
	
	public void nextBtnClick(){
		Log.info("Amount screen: next button click");
		clickAndWaitSpinerToVanish(nextBtn);		
	}

	public String getAmount() {
		Log.info("Amount screen: Amount: " + findElement(amountField, driver).getText());
		return onlyNumbers(findElement(amountField, driver).getText());		
	}
	
	public String getPhoneNumber() {
		Log.info("Amount screen: Phone number: " + findElement(phoneNumber, driver).getText());
		return onlyNumbers(findElement(phoneNumber, driver).getText());		
	}
	
}
