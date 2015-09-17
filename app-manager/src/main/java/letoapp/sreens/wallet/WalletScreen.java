package letoapp.sreens.wallet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import letoapp.AppScreenBase;

public class WalletScreen extends AppScreenBase{
	private WalletTab walletTab;
	private WalletInfoTab walletInfoTab;
	By infoTabBtn = By.xpath("//TextView[@value='ИНФОРМАЦИЯ']");
	By walletTabBtn = By.xpath("//TextView[@value='КОШЕЛЁК']");
	By updateIndicator = By.xpath("//ProgressBar");
	String title = "Мой кошелёк";
	

	public WalletScreen(WebDriver driver) {
		super(driver);
		walletTab = PageFactory.initElements(driver, WalletTab.class);
		walletInfoTab = PageFactory.initElements(driver, WalletInfoTab.class);
		walletTab.setDriver(driver);
		walletInfoTab.setDriver(driver);		
	}
	
	public WalletTab getWalletTab() {
		return walletTab;
	}
	
	public WalletInfoTab getWalletInfoTab() {
		return walletInfoTab;
	}
	
	public void infoTabClick() {
		Log.info("Wallet Screen: Information tab click");
		findElement(infoTabBtn, driver);
		delay();
	}
	
	public void walletTabClick() {
		Log.info("Wallet Screen: Wallet tab click");
		findElement(walletTabBtn, driver);
		delay(2000);
	}

	public void waitForVanishUpdateIndicator() {
		Log.info("Wallet screenn: Wait for vanish update spiner");		
		waitForVanish(updateIndicator);				
	}

	public void verify() {
		verify.assertEquals(getTitleFromActionBar(), title , "Wallet screen: title");
		verify.assertAll();
	}	
	
}
