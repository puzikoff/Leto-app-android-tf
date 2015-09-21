package ru.letoapp.screens.deposits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ru.letoapp.AppScreenBase;
import ru.letoapp.screens.EditDisplayNameBlock;



public class DepositScreen extends AppScreenBase{
	
	private DepositTab depositTab;
	private DepositInfoTab depositInfoTab;
	private EditDisplayNameBlock editDisplayName;
	
	String title = "Вклад";
	By depositTabBtn = By.xpath("//TextView[@value='ВКЛАД']");	
	By infoTabBtn = By.xpath("//TextView[@value='ИНФОРМАЦИЯ']");	
	By updateIndicator = By.xpath("//ProgressBar");
	
	public DepositScreen(WebDriver driver) {
		super(driver);
		depositTab = PageFactory.initElements(driver,DepositTab.class);
		depositInfoTab = PageFactory.initElements(driver, DepositInfoTab.class);
		editDisplayName = PageFactory.initElements(driver, EditDisplayNameBlock.class);
		depositTab.setDriver(driver);
		depositInfoTab.setDriver(driver);
		editDisplayName.setDriver(driver);
	}
	
	public DepositTab getDepositTab(){
		return depositTab;
	}
	
	public DepositInfoTab getDepositInfoTab(){
		return depositInfoTab;
	}
	
	public EditDisplayNameBlock getEditDisplayName() {
		return editDisplayName;
	}

	public void depositInfoTabClick() {
		Log.info("Deposit Screen: Managementd tab click");
		click(infoTabBtn);		
	}
	
	public void depositTabClick() {
		Log.info("Deposit Screen: Deposit tab click");
		click(depositTabBtn);
	}

	public void waitForVanishUpdateIndicator() {
		Log.info("Deposit screen: Wait for vanish update spiner");		
		waitForVanish(updateIndicator);				
	}

	public void verify() {
		verify.assertEquals(getTitleFromActionBar(), title , "Deposit screen: title");		
		verify.assertAll();				
	}
}
