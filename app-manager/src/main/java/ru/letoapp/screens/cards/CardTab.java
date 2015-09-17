package ru.letoapp.screens.cards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import ru.letoapp.AppScreenBase;


public class CardTab extends AppScreenBase{	
	By expandBtn = By.id("label_card_info_total_caption");
	By totalAvailable = By.id("label_total_available");
	By creditFunds = By.id("label_credit_funds");
	By ownFunds = By.id("label_own_funds");
	By blockedFunds = By.id("label_blocked");
	By holdsBtn = By.id("layout_card_info_holds");
	By blockFundsSwitch = By.xpath("//Switch");
	By howWorksBlockFundsBtn = By.id("button_show_spending_block_info");
	By cardOperationsBtn = By.xpath("//ClickableItemView_[@id='label_action_last_transactions']//TextView");
	By whatIfBtn = By.xpath("//LinearLayout[@id='layout_what_if_container']");
	By mandatoryPayment = By.xpath("//LinearLayout[@id='layout_mandatory_payment_required']");
	By contractNameBlock = By.id("layout_product_name_container");
	By fundsBlock = By.id("layout_card_info_header");
	By blockFundsHint = By.xpath("//LinearLayout[@id='layout_spending_switch_container']//TextView[2]"); 
	String blockFundsHintText = "Временно отключает возможность снятия денег с карты";	
	By creditLimitBlock = By.xpath("//TextView[@value='КРЕДИТНЫЙ ЛИМИТ']");
	By topUpMethodsTitle = By.xpath("//TextView[@value='ДРУГИЕ СПОСОБЫ ПОПОЛНЕНИЯ']");
	By repaymentBtn = By.id("layout_autopayment_item_container");
	By inLetoBankOffices = By.xpath("//TextView[@value='В офисах банка']");
	By anotherBankPayment = By.xpath("//TextView[@value='Платежом из другого банка']");
	By paymentSystemsTerminals = By.xpath("//TextView[@value='Через терминалы платёжных систем']");	
	
	public CardTab(WebDriver driver) {
		super(driver);
	}
	
	public void verify() {				
		verify.assertTrue(findElement(fundsBlock, driver).isDisplayed(), "Funds block is displayed");		
		verify.assertEquals(findElement(blockFundsHint, driver).getText(), blockFundsHintText, "Block funds hint text");
		verify.assertTrue(findElement(blockFundsSwitch, driver).isDisplayed(), "Block funds switch  is displayed");
		verify.assertTrue(findElement(howWorksBlockFundsBtn, driver).isDisplayed(), "How works block funds is displayed");
		verify.assertTrue(findElement(cardOperationsBtn, driver).isDisplayed(), "card operations");		
		verify.assertTrue(findElement(whatIfBtn, driver).isDisplayed(), "What if");
		verify.assertAll();		
	}
	
	public void expandBtnClick() {
		waitFor(expandBtn);
		Log.info("Card screen, Card Tab: Expand button click");
		click(expandBtn);
	}
	
	public void mandatoryPaymentClick() {
		waitFor(mandatoryPayment);
		Log.info("Card screen, Card Tab: mandatory payment click");
		if(isMandatoryPaymentClickable()) {
			Log.info("Card screen, Card Tab: mandatory payment clickable");
			findElement(mandatoryPayment, driver).click();
			delay();
		}
		else{
			Log.info("Card screen, Card Tab: mandatory payment is not clickable");
			Assert.fail("Card screen, Card Tab: mandatory payment is not clickable");
		}
	}
	
	public boolean isMandatoryPaymentClickable() {
		if(isElementClickable(mandatoryPayment)) {
			Log.info("Card screen, card tab: mandatory payment is clickable");
			return true;
		}
		else {
			Log.info("Card screen, card tab: mandatory payment is not clickable");
			return false;
		}
	}
	
	public void holdsBtnClick() {
		waitFor(holdsBtn);
		Log.info("Card screen, Card Tab: Hold funds click");
		clickAndWaitSpinerToVanish(holdsBtn);
	}
	
	public void blockFundsSwitchClick() {
		waitFor(blockFundsSwitch);
		Log.info("Card screen, Card Tab: Block funds switch click");
		clickAndWaitSpinerToVanish(blockFundsSwitch);
	}
	
	public void howWorksBlockFundsBtnClick() {
		waitFor(howWorksBlockFundsBtn);
		Log.info("Card screen, Card Tab: How works block funds click");
		click(howWorksBlockFundsBtn);		
	}
	
	public void cardOperationsClick(){
		waitFor(cardOperationsBtn);
		Log.info("Card screen, Card Tab: Card operations click");
		clickAndWaitSpinerToVanish(cardOperationsBtn);	
	}
	
	public void whatIfBtnClick(){
		waitFor(whatIfBtn);
		Log.info("Card screen, Card Tab: What if button click");
		click(whatIfBtn);		
	}
	
	public String getTotalAvailable() {		
		String ta = null;
		waitFor(totalAvailable);		
		ta = findElement(totalAvailable, driver).getText();
		ta = onlyNumbers(ta);
		Log.info("Card tab: get Total Available: " + ta);
		return ta;
	}
	
	public String getCreditFunds() {		
		String cf = null;
		waitFor(creditFunds);
		cf = findElement(creditFunds, driver).getText();
		cf = onlyNumbers(cf);
		Log.info("Card tab: get Credit Funds: " + cf);
		return cf;
	}
	
	public String getOwnFunds() {		
		String of = null;
		waitFor(ownFunds);
		of = findElement(ownFunds, driver).getText();
		of = onlyNumbers(of);	
		Log.info("Card tab: get Own Funds: " + of);
		return of;
	}
	
	public String getBlockedFunds() {		
		String bf = null;
		waitFor(blockedFunds);
		bf = findElement(blockedFunds, driver).getText();
		bf = onlyNumbers(bf);	
		Log.info("Card Screen 'card' tab: get Blocked Funds: " + bf);
		return bf;
	}
	
	public void inLetoBankOfficesClick() {
		waitForClickable(inLetoBankOffices);
		Log.info("Card card tab: In leto bank offices payment click");
		clickAndWaitSpinerToVanish(inLetoBankOffices);	
	}
	
	public void anotherBankPaymentClick() {
		waitForClickable(anotherBankPayment);
		Log.info("Card card tab: Another bank payment click");
		clickAndWaitSpinerToVanish(anotherBankPayment);	
	}
	
	public void paymentSystemsTerminalsClick() {
		waitForClickable(paymentSystemsTerminals);
		Log.info("Card card tab: Payments systems terminalst click");
		clickAndWaitSpinerToVanish(paymentSystemsTerminals);	
	}

}
