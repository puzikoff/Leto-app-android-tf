package ru.letoapp.screens.payments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;


public class TransfersTab extends AppScreenBase{
	By transferToTheBudgetBtn = By.xpath("//TextView[@value='В бюджет']");
	By transferToAnotherBankClientBtn = By.xpath("//TextView[@value='Другому клиенту Лето Банка']");
	By transferBetweenAccountsBtn = By.xpath("//TextView[@value='Между своими счетами']");
	By transferToAnotherBankBtn = By.xpath("//TextView[@value='Перевод в другой банк']");
	
	public TransfersTab(WebDriver driver) {
		super(driver);
	}
	
	public void transferToTheBudgetBtnClick() throws Exception {
		Log.info("Transfers tab: transfer To The Budget Btn click");
		clickAndWaitSpinerToVanish(transferToTheBudgetBtn);
	}

	public void transferToAnotherBankClientBtnClick() throws Exception {
		Log.info("Transfers tab: transfer To Another Bank Client Btn click");
		clickAndWaitSpinerToVanish(transferToAnotherBankClientBtn);
	}
	
	public void transferBetweenAccountsBtnClick() throws Exception {
		Log.info("Transfers tab: transfer between accounts  Btn click");
		clickAndWaitSpinerToVanish(transferBetweenAccountsBtn);
	}
	
	public void transferToAnotherBankBtnClick() throws Exception {
		Log.info("Transfers tab: transfer To Another Bank Btn click");
		clickAndWaitSpinerToVanish(transferToAnotherBankBtn);
	}
}
