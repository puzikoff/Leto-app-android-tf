package letoapp.sreens.payments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import letoapp.AppScreenBase;
import letoapp.utilities.PropertyReader;

public class AccountInfoScreen extends AppScreenBase{
	
	By accountField = By.xpath("//WeakMaskedEditText");
	By alert = By.id("image_alert_indicator");
	By nextBtn = By.xpath("//Button[@id='button']");
	

	public AccountInfoScreen(WebDriver driver) {
		super(driver);
	}
	
	public void enterAccount(String account) {
		Log.info("Account info screen: Entering account - " + account);
		findElement(accountField, driver).clear();
		findElement(accountField, driver).sendKeys(account);
	}
	
	public boolean isAlertDisplayed() {
		return isElementPresent(alert);
	}
	
	public boolean isNextBtnDisplayed() {
		return isElementPresent(nextBtn);
	}
	
	public void nextBtnClick(){
		Log.info("Account info screen: next button click - ");
		clickAndWaitSpinerToVanish(nextBtn);		
	}

	public void verify() {
		verify.assertTrue(findElement(accountField, driver) != null, "Account info screen: account field");
		verify.assertEquals(getTitleFromActionBar(), PropertyReader.getProperty("payment"), "Account info screen: title");
		verify.assertAll();
	}

}
