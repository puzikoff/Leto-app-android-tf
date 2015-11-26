package ru.letoapp.screens.cards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;


public class CardManagementTab extends AppScreenBase{
	
	By blockFundsSwitch = By.xpath("//Switch");
	By phoneCallBtn = By.xpath("//Button[@id='button_call_phone_number']");
	By foreignPhoneCallBtn = By.xpath("//Button[@id='button_call_foreign_phone_number']");
	By howWorksBlockFundsBtn = By.id("button_show_spending_block_info");
	By connectingServiceHistoryBtn = By.id("widget_show_service_history");
	By changePayDateWidgetArrow = By.xpath("//TextView[@value='Меняю дату платежа']/../following-sibling::ImageView");
	By repaymentWidgetArrow = By.xpath("//TextView[@value='Автопогашение']/../following-sibling::ImageView");
	By changePaymentDateBtn = By.xpath("//TextView[@value='Меняю дату платежа']/../../..//TextView[@id='label_pressable_caption']");
	By repaymentBtn = By.xpath("//TextView[@value='Автопогашение']/../../..//TextView[@id='label_pressable_caption']");
	By blockFundsHint = By.xpath("//LinearLayout[@id='layout_spending_switch_container']//TextView[2]"); 
	By limitsBtn = By.xpath("//LinearLayout[@id='layout_action_bank_payment']");
	String blockFundsHintText = "Временно отключает возможность снятия денег с карты";

	public CardManagementTab(WebDriver driver) {
		super(driver);
	}
	
	public void verify() throws Exception {
		Log.info("Card screen, Management Tab: verify");
		verify.assertTrue(findElement(phoneCallBtn, driver).isDisplayed(), "Phone call button displayed");
		verify.assertTrue(findElement(foreignPhoneCallBtn, driver).isDisplayed(), "Foreign phone call is displayed");
		verify.assertEquals(findElement(blockFundsHint, driver).getText(), blockFundsHintText, "Block funds hint text");
		verify.assertTrue(findElement(blockFundsSwitch, driver).isDisplayed(), "Block funds switch  is displayed");
		verify.assertTrue(findElement(howWorksBlockFundsBtn, driver).isDisplayed(), "How works block funds is displayed");
		verify.assertTrue(findElement(connectingServiceHistoryBtn, driver).isDisplayed(), "Connecring services history button");		
		verify.assertAll();				
	}
	
	public void blockFundsSwitchClick() throws Exception {
		if(isBlockFundsSwitchDisplayed()) {
			Log.info("Card screen, Management Tab: Block funds switch click");
			clickAndWaitSpinerToVanish(blockFundsSwitch);
		}
	}
	
	public boolean isBlockFundsSwitchDisplayed() throws Exception {
		return isElementDisplayed(blockFundsSwitch);
	}
	
	public void connectingServiceHistoryBtnClick() throws Exception {		
		Log.info("Card screen, Management Tab: Connecting services history button click");
		clickAndWaitSpinerToVanish(connectingServiceHistoryBtn);	
	}
	
	public void howWorksBlockFundsBtnClick() throws Exception {		
		Log.info("Card screen, management Tab: How works block funds click");		
		click(howWorksBlockFundsBtn);		
	}
	
	public void changePayDateWidgetArrowClick() throws Exception {
		Log.info("Card screen, management tab: change payment date widget arrow click");
		click(changePayDateWidgetArrow);
	}
	
	public void repaymentWidgetArrowClick() throws Exception {
		Log.info("Card screen, management tab: repayment widget arrow click");
		click(repaymentWidgetArrow);
	}
	
	public boolean isChangePaymentBtnDisplayed() throws Exception {		
		if(findElement(changePaymentDateBtn, driver).isDisplayed()) {
			Log.info("Card screen, management tab: Change payment date is displayed");	
			return true;
		}
		else {
			Log.info("Card screen, management tab: Change payment date is not displayed");	
			return false;
		}
	}
	
	public void changePaymentDateBtnClick() throws Exception {
		Log.info("Card screen, management tab: change payment date btn click");
		clickAndWaitSpinerToVanish(changePaymentDateBtn);
	}
	
	public void repaymentBtnClick() throws Exception {
		Log.info("Card screen, management tab: repayment btn click");
		click(repaymentBtn);						
	}
	
	public void limitsBtnClick() throws Exception {
		Log.info("Card screen, management tab: limits btn click");
		click(limitsBtn);
	}

}
