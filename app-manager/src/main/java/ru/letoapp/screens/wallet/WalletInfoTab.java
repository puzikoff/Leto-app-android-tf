package ru.letoapp.screens.wallet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;


public class WalletInfoTab extends AppScreenBase{
	By walletOperationsBtn = By.xpath("//ClickableItemView_[@id='label_action_last_transactions']");
	By openedDateBlock = By.xpath("//TextView[@value='ДАТА ОТКРЫТИЯ']");
	By contractNumberBlock = By.xpath("//TextView[@value='НОМЕР ДОГОВОРА']");

	public WalletInfoTab(WebDriver driver) {
		super(driver);
	}
	
	public void verifyZeroWallet() throws Exception {	
		verify.assertTrue(findElement(openedDateBlock, driver).isDisplayed(), "Opened date ");
		verify.assertTrue(findElement(contractNumberBlock, driver).isDisplayed(), "contract number");
		verify.assertTrue(findElement(walletOperationsBtn, driver).isDisplayed(), "wallet operations button");
		verify.assertAll();
	}
	
	public void walletOperationsBtnClick() throws Exception {
		Log.info("Wallet Screen: Wallet operations button click");
		click(walletOperationsBtn);
	}

}
