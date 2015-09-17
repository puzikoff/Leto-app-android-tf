package ru.letoapp.screens.deposits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;


public class DepositInfoTab extends AppScreenBase{
	
	By openingTitle = By.xpath("//TextView[@value='ОТКРЫТИЕ']");
	By signingDateBlock = By.xpath("//TextView[@value='ДАТА ЗАКЛЮЧЕНИЯ ДОГОВОРА']");
	By openedDateBlock = By.xpath("//TextView[@value='ДАТА ОТКРЫТИЯ ДОГОВОРА']");
	By initialAmountBlock = By.xpath("//TextView[@value='ПЕРВОНАЧАЛЬНЫЙ РАЗМЕР ВКЛАДА НА МОМЕНТ ОТКРЫТИЯ']");
	
	By conditionsTitle = By.xpath("//TextView[@value='УСЛОВИЯ']");
	By partialWithdrawBlock = By.xpath("//CaptionTextItemView_[@id='widget_partial_withdrawal_available']");	
	By additionBlock = By.xpath("//TextView[@value='ПОПОЛНЕНИЕ ВКЛАДА']");
	
	By operationsTitle = By.xpath("//TextView[@value='ОПЕРАЦИИ']");
	By additionsAmount = By.xpath("//CaptionTextItemView_//TextView[@value='СУММА ПОПОЛНЕНИЙ']");
	By depositOperationsBtn = By.id("widget_show_operation_history");
	
	By interestInfoTitle = By.xpath("//TextView[@value='ВЫПЛАТА %']");
	By interestPeriodBlock = By.xpath("//TextView[@value='ТИП ВЫПЛАТЫ ПРОЦЕНТОВ']");
	By interestTypeBlock = By.xpath("//TextView[@value='СПОСОБ ВЫПЛАТЫ ПРОЦЕНТОВ']");
	By paidInterestBlock =  By.xpath("//TextView[@value='СУММА ВЫПЛАЧЕННЫХ ПРОЦЕНТОВ']");
	By interestRatesBlock = By.xpath("//TextView[@value='СТАВКИ ПО ВКЛАДУ']");
	By earlyInterestRatesBlock = By.xpath("//NoSaveStateFrameLayout[2]//TextView[@value='СТАВКА ДОСРОЧНОГО ЗАКРЫТИЯ И ДРУГИЕ УСЛОВИЯ ЕГО ВЫПОЛНЕНИЯ']");
	
	By closingInfoTitle = By.xpath("//TextView[@value='ЗАКРЫТИЕ']");
	By closingDateBlock = By.xpath("//TextView[@value='ПЛАНОВАЯ ДАТА ЗАКРЫТИЯ']");
	By closedDateBlock = By.xpath("//TextView[@value='ВКЛАД ЗАКРЫТ']");
	By totalInterestAmount = By.xpath("//TextView[@value='ОБЩАЯ ПЛАНОВАЯ СУММА ПРОЦЕНТОВ ПРИ ЗАКРЫТИИ В СРОК, ВКЛЮЧАЯ УЖЕ ВЫПЛАЧЕННЫЕ']");

	public DepositInfoTab(WebDriver driver) {
		super(driver);
	}

	public void verifyOpenDeposit() {
		verify.assertTrue(findElement(openingTitle, driver).isDisplayed(), "Deposit info tab: opening title");
		verify.assertTrue(findElement(signingDateBlock, driver).isDisplayed(), "Deposit info tab: signing date");
		verify.assertTrue(findElement(openedDateBlock, driver).isDisplayed(), "Deposit info tab: opened date");
		verify.assertTrue(findElement(initialAmountBlock, driver).isDisplayed(), "Deposit info tab: initial amount");
		verify.assertTrue(findElement(conditionsTitle, driver).isDisplayed(), "Deposit info tab: conditions title");
		verify.assertTrue(findElement(partialWithdrawBlock, driver) != null, "Deposit info tab: partial withdraw");
		verify.assertTrue(findElement(additionBlock, driver).isDisplayed(), "Deposit info tab: addition");
		verify.assertTrue(findElement(operationsTitle, driver).isDisplayed(), "Deposit info tab: operations title");
		verify.assertTrue(findElement(additionsAmount, driver).isDisplayed(), "Deposit info tab: additions amount");
		verify.assertTrue(findElement(depositOperationsBtn, driver).isDisplayed(), "Deposit info tab: deposit operations title");
		verify.assertTrue(findElement(interestInfoTitle, driver).isDisplayed(), "Deposit info tab: interest info title");
		verify.assertTrue(findElement(interestPeriodBlock, driver).isDisplayed(), "Deposit info tab: interest period");
		verify.assertTrue(findElement(interestTypeBlock, driver).isDisplayed(), "Deposit info tab: interest type");
		verify.assertTrue(findElement(paidInterestBlock, driver).isDisplayed(), "Deposit info tab: paid interest");
		verify.assertTrue(findElement(interestRatesBlock, driver).isDisplayed(), "Deposit info tab: interest rates");
		verify.assertTrue(findElement(earlyInterestRatesBlock, driver).isDisplayed(), "Deposit info tab: early interest rates");
		verify.assertTrue(findElement(closingInfoTitle, driver).isDisplayed(), "Deposit info tab: closing info title");
		verify.assertTrue(findElement(closingDateBlock, driver).isDisplayed(), "Deposit info tab: closed date");
		verify.assertTrue(findElement(totalInterestAmount, driver).isDisplayed(), "Deposit info tab: total interest amount");
		verify.assertAll();
	}
	
	public void verifyClosedDeposit() {
		verify.assertTrue(findElement(openingTitle, driver).isDisplayed(), "Deposit info tab: opening title");
		verify.assertTrue(findElement(signingDateBlock, driver).isDisplayed(), "Deposit info tab: signing date");
		verify.assertTrue(findElement(openedDateBlock, driver).isDisplayed(), "Deposit info tab: opened date");
		verify.assertTrue(findElement(initialAmountBlock, driver).isDisplayed(), "Deposit info tab: initial amount");
		verify.assertTrue(findElement(conditionsTitle, driver).isDisplayed(), "Deposit info tab: conditions title");
		verify.assertTrue(findElement(partialWithdrawBlock, driver) != null, "Deposit info tab: partial withdraw");		
		verify.assertTrue(findElement(operationsTitle, driver).isDisplayed(), "Deposit info tab: operations title");		
		verify.assertTrue(findElement(depositOperationsBtn, driver).isDisplayed(), "Deposit info tab: deposit operations title");
		verify.assertTrue(findElement(interestInfoTitle, driver).isDisplayed(), "Deposit info tab: interest info title");
		verify.assertTrue(findElement(interestPeriodBlock, driver).isDisplayed(), "Deposit info tab: interest period");
		verify.assertTrue(findElement(interestTypeBlock, driver).isDisplayed(), "Deposit info tab: interest type");
		verify.assertTrue(findElement(paidInterestBlock, driver).isDisplayed(), "Deposit info tab: paid interest");
		verify.assertTrue(findElement(interestRatesBlock, driver).isDisplayed(), "Deposit info tab: interest rates");
		verify.assertTrue(findElement(earlyInterestRatesBlock, driver).isDisplayed(), "Deposit info tab: early interest rates");
		verify.assertTrue(findElement(closingInfoTitle, driver).isDisplayed(), "Deposit info tab: closing info title");
		verify.assertTrue(findElement(closedDateBlock, driver).isDisplayed(), "Deposit info tab: closed date");
		verify.assertTrue(findElement(totalInterestAmount, driver).isDisplayed(), "Deposit info tab: total interest amount");
		verify.assertAll();
	}
	
	public void verifyCanceledDeposit() {
		verify.assertTrue(findElement(openingTitle, driver).isDisplayed(), "Deposit info tab: opening title");
		verify.assertTrue(findElement(signingDateBlock, driver).isDisplayed(), "Deposit info tab: signing date");		
		verify.assertTrue(findElement(conditionsTitle, driver).isDisplayed(), "Deposit info tab: conditions title");
		verify.assertTrue(findElement(partialWithdrawBlock, driver) != null, "Deposit info tab: partial withdraw");		
		verify.assertTrue(findElement(operationsTitle, driver).isDisplayed(), "Deposit info tab: operations title");	
		verify.assertTrue(findElement(additionsAmount, driver).isDisplayed(), "Deposit info tab: deposit additions");
		verify.assertTrue(findElement(depositOperationsBtn, driver).isDisplayed(), "Deposit info tab: deposit operations title");
		verify.assertTrue(findElement(interestInfoTitle, driver).isDisplayed(), "Deposit info tab: interest info title");
		verify.assertTrue(findElement(interestPeriodBlock, driver).isDisplayed(), "Deposit info tab: interest period");
		verify.assertTrue(findElement(interestTypeBlock, driver).isDisplayed(), "Deposit info tab: interest type");
		verify.assertTrue(findElement(paidInterestBlock, driver).isDisplayed(), "Deposit info tab: paid interest");
		verify.assertTrue(findElement(interestRatesBlock, driver).isDisplayed(), "Deposit info tab: interest rates");
		verify.assertTrue(findElement(earlyInterestRatesBlock, driver).isDisplayed(), "Deposit info tab: early interest rates");		
		verify.assertAll();
	}
	
	public void depositOperationsClick() {
		waitFor(depositOperationsBtn);
		Log.info("Deposit screen, info tab: Card operations button click");
		clickAndWaitSpinerToVanish(depositOperationsBtn);	
	}

}
