package ru.letoapp.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;


public class WithdrawMoneyInATMScreen extends AppScreenBase {

	public WithdrawMoneyInATMScreen(WebDriver driver) {
		super(driver);
	}
	
	String titleText = "Снять в банкомате";
	By hint = By.xpath("//TextView[@id='text_remaining_money']");	
	String hintText = "Выплачен";
	By addressesOnMap = By.xpath("//TextView[@id='label_action_addresses_on_map']");
	By getQRBtn = By.id("button_get_qr");
	String getQRBtnText = "Получить штрих-код";
	By contractNumberBlock = By.xpath("//TextView[@value='НОМЕР ДОГОВОРА']");
	By loadingIndicator = By.xpath("//ProgressBar[@id='progress_loading']");
	By labelLoading = By.xpath("//TextView[@id='label_loading']");
	String errorLoadingText = "Извините, произошла ошибка, мы уже работаем над ее исправлением.";
	By errorLoading = By.xpath("//TextView[@value='Извините, произошла ошибка, мы уже работаем над ее исправлением.']");

	public void getQRBtnClick() {
		Log.info("Get QR code button click");
		click(getQRBtn);		
	}

	public void verify() {		
		verify.assertTrue(findElement(hint, driver).getText().contains(hintText), "Hint text");
		verify.assertTrue(findElement(addressesOnMap, driver).isDisplayed(), "Addresses on map");
		verify.assertTrue(findElement(getQRBtn, driver).isDisplayed(), "Get QR button");
		verify.assertTrue(findElement(contractNumberBlock, driver).isDisplayed(), "Contract name block");
		verify.assertEquals(getTitleFromActionBar(), titleText , "Withdraw money in ATM screen: title");
		verify.assertAll();		
	}
	
	public void waitForVanishLoadingIndicator() {
		waitFor(loadingIndicator);
		Log.info("Wait for vanish update spiner");
		waitForVanish(loadingIndicator);		
	}
		
	public boolean isLoadingErrorExist() {		
		if(findElement(errorLoading, driver) != null){
			Log.error("QR code screen: Loading ERROR");
			//takeScreenshot();
			return true;
		}
		else return false;		
	}

}
