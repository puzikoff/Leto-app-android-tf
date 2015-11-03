package ru.letoapp.screens.cards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ru.letoapp.AppScreenBase;
import ru.letoapp.screens.EditDisplayNameBlock;
import ru.letoapp.screens.popups.NotImplementedPopup;



public class CardScreen extends AppScreenBase{	
	private CardTab cardTab;
	private CardInfoTab cardInfoTab;
	private CardManagementTab cardManagementTab;
	private EditDisplayNameBlock editDisplayName;
	private NotImplementedPopup notImplementedPopup;
	By contractNameBlock = By.id("layout_product_name_container");
	String titleText = "Карта";	
	By cardTabBtn = By.xpath("//TextView[@value='КАРТА']");
	By infoTabBtn = By.xpath("//TextView[@value='ИНФОРМАЦИЯ']");
	By managementTabBtn = By.xpath("//TextView[@value='УПРАВЛЕНИЕ']");	
	By updateIndicator = By.xpath("//ProgressBar");

	public CardScreen(WebDriver driver) {
		super(driver);
		cardTab = PageFactory.initElements(driver, CardTab.class);
		cardInfoTab = PageFactory.initElements(driver, CardInfoTab.class);
		cardManagementTab = PageFactory.initElements(driver, CardManagementTab.class);
		editDisplayName = PageFactory.initElements(driver, EditDisplayNameBlock.class);
		cardTab.setDriver(driver);
		cardInfoTab.setDriver(driver);
		cardManagementTab.setDriver(driver);
		editDisplayName.setDriver(driver);
		notImplementedPopup = PageFactory.initElements(driver, NotImplementedPopup.class);
		notImplementedPopup.setDriver(driver);
	}
	
	public CardTab getCardTab(){
		return cardTab;
	}
	
	public CardInfoTab getCardInfoTab() {
		return cardInfoTab;
	}
	
	public CardManagementTab getCardManagementTab() {
		return cardManagementTab;
	}
	
	public EditDisplayNameBlock getEditDisplayName() {
		return editDisplayName;
	}
	
	public NotImplementedPopup getNotImplementedPopup() {
		return notImplementedPopup;
	}
	
	public void verify() throws Exception {		
		verify.assertEquals(getTitleFromActionBar(), titleText , "Card screen: title");
		verify.assertTrue(findElement(contractNameBlock, driver).isDisplayed(), "Edit contract name block displayed");
		verify.assertAll();		
	}		
	
	public void infoTabClick() throws Exception {
		Log.info("Card Screen: Information tab click");
		click(infoTabBtn);
	}

	public void managementTabClick() throws Exception {
		Log.info("Card Screen: Managementd tab click");
		click(managementTabBtn);		
	}
	
	public void cardTabClick() throws Exception {
		Log.info("Card Screen: Card tab click");
		click(cardTabBtn);
	}

	public void waitForVanishUpdateIndicator() {
		Log.info("Card screen: Wait for vanish update spiner");		
		waitForVanish(updateIndicator);				
	}
}
