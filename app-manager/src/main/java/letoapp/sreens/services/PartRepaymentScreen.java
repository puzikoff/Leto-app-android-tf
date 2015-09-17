package letoapp.sreens.services;

import letoapp.AppScreenBase;
import letoapp.sreens.popups.TopUpMethodsPopup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PartRepaymentScreen extends AppScreenBase{
	TopUpMethodsPopup topUpMethodsPopup;
	
	String title = "Частичное досрочное";	
	By hint = By.xpath("//TextView[@id='label_content']");
	By nextPaymentBlock = By.xpath("//TextView[contains(@value, 'СЛЕДУЮЩИЙ ПЛАТЁЖ')]");
	By nextPayment = By.xpath("//TextView[contains(@value, 'СЛЕДУЮЩИЙ ПЛАТЁЖ')]/following::WeakMaskedEditText");
	By topUpMethodBlock = By.xpath("//TextView[@value='КАКИМ СПОСОБОМ ВЫ БУДЕТЕ ВНОСИТЬ ДЕНЬГИ?']");
	By topUpMethodList = By.xpath("//TextView[@value='КАКИМ СПОСОБОМ ВЫ БУДЕТЕ ВНОСИТЬ ДЕНЬГИ?']/following-sibling::LinearLayout");
	By calendarBlock = By.xpath("//TextView[@value='КОГДА ВЫ ПЛАНИРУЕТЕ ЭТО СДЕЛАТЬ?']");
	By amountBlock = By.xpath("//TextView[contains(@value, 'УКАЖИТЕ СУММУ')]");
	By amountField = By.xpath("//EditText[@id='edit_text']");
	By addTenBtn = By.xpath("//Button[@id='button_add_ten']");
	By addHundredBtn = By.xpath("//Button[@id='button_add_hundred']");
	By addThousandBtn = By.xpath("//Button[@id='button_add_thousand']");
	By connectBtn = By.xpath("//Button[@id='button']");
	By chosenTopUpMethodBlock = By.xpath("//TextView[@value='СПОСОБ']");
	By sumToGrantBlock = By.xpath("//TextView[@value='СУММА ДЛЯ ВНЕСЕНИЯ']");
	By planingGrantDateBlock = By.xpath("//TextView[@value='ПЛАНИРУЕМАЯ ДАТА ВНЕСЕНИЯ']");
	By grantDateBlock = By.xpath("//TextView[@value='ОРИЕНТИРОВОЧНО ДЕНЬГИ ЗАЧИСЛЯТСЯ']");
	By payAttentionBlock = By.xpath("//WeakMaskedEditText[@id='edit_text']");
	By newMonthlyPaymentBlock = By.xpath("//TextView[contains(@value, 'ЕЖЕМЕСЯЧНЫЙ ПЛАТЁЖ')]");
	By loanWillBePayedBlock = By.xpath("//TextView[contains(@value, 'КРЕДИТ БУДЕТ ПОЛНОСТЬЮ ПОГАШЕН')]");
	

	public PartRepaymentScreen(WebDriver driver) {
		super(driver);
		topUpMethodsPopup = PageFactory.initElements(driver, TopUpMethodsPopup.class);
		topUpMethodsPopup.setDriver(driver);
	}
	
	public TopUpMethodsPopup getTopUpMethodsPopup() {
		return topUpMethodsPopup;
	}
	
	public void verifyPartRepaymentFirstStep() {
		verify.assertTrue(getTitleFromActionBar().contains(title), "Part repayment screen: title");
		verify.assertTrue(findElement(hint, driver).isDisplayed(), "Part repayment screen: hint");
		verify.assertTrue(findElement(nextPaymentBlock, driver).isDisplayed(), "Part repayment screen: next payment");
		verify.assertTrue(findElement(topUpMethodBlock, driver).isDisplayed(), "Part repayment screen: top up methods");
		verify.assertTrue(findElement(calendarBlock, driver).isDisplayed(), "Part repayment screen: calendar");
		verify.assertTrue(findElement(amountBlock, driver).isDisplayed(), "Part repayment screen: amount");
		verify.assertTrue(findElement(addHundredBtn, driver).isDisplayed(), "Part repayment screen: add hundred button");
		verify.assertTrue(findElement(addTenBtn, driver).isDisplayed(), "Part repayment screen: add ten button");
		verify.assertTrue(findElement(addThousandBtn, driver).isDisplayed(), "Part repayment screen: add thousand button");		
		verify.assertAll();		
	}
	
	public void verifyPartRepaymentSecondStep() {
		verify.assertTrue(getTitleFromActionBar().contains(title), "Part repayment screen step 2: title");
		verify.assertTrue(findElement(chosenTopUpMethodBlock, driver).isDisplayed(), "Part repayment screen step 2: Choosen popup method");
		verify.assertTrue(findElement(sumToGrantBlock, driver).isDisplayed(), "Part repayment screen step 2: Sum to grant");
		verify.assertTrue(findElement(planingGrantDateBlock, driver).isDisplayed(), "Part repayment screen step 2: Planing grant date block");
		verify.assertTrue(findElement(grantDateBlock, driver).isDisplayed(), "Part repayment screen step 2: Grant date block");
		verify.assertTrue((findElement(newMonthlyPaymentBlock, driver) != null)||(findElement(loanWillBePayedBlock, driver) != null), "Part repayment screen step 2: New payment sum or credit will be payed block");				
		verify.assertAll();
	}
		
	public String getNextPayment() {
		Log.info("Part repayment screen: get next payment sum");		
		return onlyNumbers(findElement(nextPayment, driver).getText());
	}
	
	public String calculateSumToPay(String nextPaymentSum) {		
		Log.info("Part repayment screen: get next payment sum");
		return Integer.toString(Integer.parseInt(nextPaymentSum) + 1);		
	}
	
	public void tenRubBtnClick() {
		Log.info("Part repayment screen: Ten rub buttob click");
		findElement(addTenBtn, driver).click();
	}
	
	public void hundredRubBtnClick() {
		Log.info("Part repayment screen: Hundred rub buttob click");
		findElement(addHundredBtn, driver).click();
	}
	
	public void thousandRubBtnClick() {
		Log.info("Part repayment screen: thousand rub buttob click");
		findElement(addThousandBtn, driver).click();
	}
	
	public void connectBtnClick() {
		Log.info("Part repayment screen: connect button click");
		clickAndWaitSpinerToVanish(connectBtn);
	}
	
	public void enterAmount(String amount) {
		Log.info("Part repayment screen: Enter amount");
		findElement(amountField, driver).clear();
		findElement(amountField, driver).sendKeys(amount);
	}
	
	public void topUpMethodsListClick() {
		Log.info("Part repayment screen: Top up methods list click");
		click(topUpMethodList);
	}
	
	public void chooseNewDate(String date) {
		Log.info("Part repayment screen: Choose date: " + date);
		Assert.assertTrue(isElementClickable(By.xpath("//TextView[@id='label_day_of_month'][@value='" + date + "']")), "Part repayment screen: claculated new payment date is clickable");
		findElement(By.xpath("//TextView[@id='label_day_of_month'][@value='" + date + "']"), driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }				
	}
	

}
