package ru.letoapp.screens.deposits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;


public class DepositTab extends AppScreenBase{	
	
	String title = "Вклад";
	
	By depositInfo = By.xpath("//LinearLayout[@id='layout_deposit_info_container']");
	By depositInfoTotal = By.xpath("//LinearLayout[@id='layout_deposit_info_container']//TextView[@value='СУММА ВКЛАДА']");
	By depositInfoInitialPayment = By.xpath("//LinearLayout[@id='layout_deposit_info_container']//TextView[@value='ПЕРВОНАЧАЛЬНЫЙ ВЗНОС']");
	By depositInfoInitialAdditions = By.xpath("//LinearLayout[@id='layout_deposit_info_container']//TextView[@value='СУММА ПОПОЛНЕНИЙ']");
	By depositInfoInitialCapitalizedInterest = By.xpath("//LinearLayout[@id='layout_deposit_info_container']//TextView[@value='КАПИТАЛИЗИРОВАННЫЕ %']");	
	
	By depositBreakdown = By.xpath("//LinearLayout[@id='layout_deposit_breakdown_container']");
	By depositBreakdownWillBeAvailable = By.xpath("//LinearLayout[@id='layout_deposit_breakdown_container']//TextView[contains(@value, 'БУДЕТ ДОСТУПНО')]");
	By depositBreakdownInitialPayment = By.xpath("//LinearLayout[@id='layout_deposit_breakdown_container']//TextView[@value='ПЕРВОНАЧАЛЬНЫЙ ВЗНОС']");
	By depositBreakdownAdditions = By.xpath("//LinearLayout[@id='layout_deposit_breakdown_container']//TextView[@value='СУММА ПОПОЛНЕНИЙ']");
	By depositBreakdownCapitalizedInterest = By.xpath("//LinearLayout[@id='layout_deposit_breakdown_container']//TextView[@value='КАПИТАЛИЗИРОВАННЫЕ %']");
	
	By interestRatesBlock = By.xpath("//TextView[@value='СТАВКИ ПО ВКЛАДУ']");
	By closingDateBlock = By.xpath("//TextView[@value='ПЛАНОВАЯ ДАТА ЗАКРЫТИЯ']");
	By closedDateBlock = By.xpath("//TextView[@value='ВКЛАД ЗАКРЫТ']");
	
	By whatIfBtn = By.xpath("//LinearLayout[@id='layout_what_if_container']");
	
	By topUpMethodsTitle = By.xpath("//TextView[@value='ДРУГИЕ СПОСОБЫ ПОПОЛНЕНИЯ']");
	By inLetoBankOffices = By.xpath("//TextView[@value='В офисах банка']");
	By anotherBankPayment = By.xpath("//TextView[@value='Платежом из другого банка']");
	By paymentSystemsTerminals = By.xpath("//TextView[@value='Через терминалы платёжных систем']");	
	
	By canceledMessageLayout = By.xpath("//LinearLayout[@id='layout_canceled_message']");
	By canceledMessage = By.xpath("//LinearLayout[@id='layout_canceled_message']/TextView[@value='Вклад отменён']");
	
	By depositTerm = By.xpath("//TextView[@value='СРОК ВКЛАДА']");
	By minRequiredAmount = By.xpath("//TextView[@value='МИНИМАЛЬНАЯ СУММА ДЛЯ ОТКРЫТИЯ']");
	

	public DepositTab(WebDriver driver) {
		super(driver);
	}

	public void verifyOpenDeposit() {
		verify.assertTrue(findElement(depositBreakdown, driver) != null, "deposit breakdown container");		
		verify.assertTrue(findElement(depositInfo, driver) != null, "Deposit info container");
		verify.assertTrue(findElement(interestRatesBlock, driver).isDisplayed(), "Interest rates block");
		verify.assertTrue(findElement(closingDateBlock, driver).isDisplayed(), "Closing date block");		
		verify.assertTrue(findElement(whatIfBtn, driver).isDisplayed(), "What if");
		verify.assertAll();				
	}
	
	public void verifyClosedDeposit() {
		verify.assertTrue(findElement(depositBreakdown, driver) != null, "deposit breakdown container");
		verify.assertTrue(findElement(interestRatesBlock, driver).isDisplayed(), "Interest rates block");
		verify.assertTrue(findElement(closedDateBlock, driver).isDisplayed(), "Closed date block");
		verify.assertFalse(findElement(whatIfBtn, driver).isDisplayed(), "What if");
		verify.assertAll();		
	}
	
	public void verifyCanceledDeposit() {
		verify.assertTrue(findElement(depositTerm, driver).isDisplayed(), "Deposit term block");
		verify.assertTrue(findElement(interestRatesBlock, driver).isDisplayed(), "Interest rates block");
		verify.assertTrue(findElement(canceledMessage, driver).isDisplayed(), "canceled message");
		verify.assertTrue(findElement(minRequiredAmount, driver).isDisplayed(), "min required amount");
		verify.assertFalse(findElement(whatIfBtn, driver).isDisplayed(), "What if");
		verify.assertAll();		
	}
	
	public void unwrapDepositInfo() {
		Log.info("Deposit screen: unwrap deposit info container");
		click(depositInfo);
	}
	
	public void wrapDepositInfo() {
		Log.info("Deposit screen: wrap deposit info container");
		click(depositInfo);
	}
	
	public void unwrapDepositBreakdown() {
		Log.info("Deposit screen: unwrap deposit breakdown container");
		click(depositBreakdown);
	}
	
	public void wrapDepositBreakdown() {
		Log.info("Deposit screen: wrap deposit breakdown container");
		click(depositBreakdown);
	}
	
	public void whatIfBtnClick(){
		waitFor(whatIfBtn);
		Log.info("Deposit screen, deposit Tab: What if button click");
		click(whatIfBtn);		
	}
	
	public void inLetoBankOfficesClick() {
		waitForClickable(inLetoBankOffices);
		Log.info("Deposit tab: In leto bank offices payment click");
		clickAndWaitSpinerToVanish(inLetoBankOffices);	
	}
	
	public void anotherBankPaymentClick() {
		waitForClickable(anotherBankPayment);
		Log.info("Deposit tab: Another bank payment click");
		clickAndWaitSpinerToVanish(anotherBankPayment);	
	}
	
	public void paymentSystemsTerminalsClick() {
		waitForClickable(paymentSystemsTerminals);
		Log.info("Deposit tab: Payments systems terminalst click");
		clickAndWaitSpinerToVanish(paymentSystemsTerminals);	
	}
}
