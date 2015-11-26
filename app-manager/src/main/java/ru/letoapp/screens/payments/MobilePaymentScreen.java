package ru.letoapp.screens.payments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;

public class MobilePaymentScreen extends AppScreenBase{
	
	By accountField = By.xpath("//WeakMaskedEditText");	
	By nextBtn = By.xpath("//Button[@id='button']");
	By amountField = By.xpath("//EditText[@id='edit_text']");	
	By tenRubBtn = By.xpath("//Button[@id='button_add_ten']");
	By hundredRubBtn = By.xpath("//Button[@id='button_add_hundred']");
	By thousandRubBtn = By.xpath("//Button[@id='button_add_thousand']");	
	By paymentToolBtn = By.xpath("//FrameLayout[@id='layout_payment_tool_container']");
	By commissionCommentBtn = By.xpath("//ImageButton[@id='button_show_comment']");
	By commissionComment = By.xpath("//ImageButton[@id='button_show_comment']/preceding-sibling::TextView[@id='label_comment']");
	By commissionRecalculatingProgressBar = By.xpath("//ProgressBar[@id='progress_commission_recalculating']");
	By commission = By.xpath("//TextView[@id='label_commission_caption']/following-sibling::TextView[@id='label_commission_amount']");
	By total = By.xpath("//TextView[@id='label_total_caption']/following-sibling::TextView[@id='label_total_amount']");
	By saveTemplateSwitch = By.xpath("//Switch");

	public MobilePaymentScreen(WebDriver driver) {
		super(driver);
	}
	
	public void enterAccount(String account) throws Exception {
		Log.info("Mobile payment screen: Entering account - " + account);
		findElement(accountField, driver).clear();
		findElement(accountField, driver).sendKeys(account);
	}
	
	public void enterAmount(String amount) throws Exception {
		Log.info("Mobile payment screen: Enter amount");
		findElement(amountField, driver).clear();
		findElement(amountField, driver).sendKeys(amount);
	}
	
	public boolean isNextBtnDisplayed() throws Exception {
		return isElementPresent(nextBtn);
	}
	
	public void tenRubBtnClick() throws Exception {
		Log.info("Mobile payment screen: Ten rub buttob click");
		findElement(tenRubBtn, driver).click();
	}
	
	public void hundredRubBtnClick() throws Exception {
		Log.info("Mobile payment screen: Hundred rub buttob click");
		findElement(hundredRubBtn, driver).click();
	}
	
	public void thousandRubBtnClick() throws Exception {
		Log.info("Mobile payment screen: thousand rub buttob click");
		findElement(thousandRubBtn, driver).click();
	}
		
	public void nextBtnClick() throws Exception{
		Log.info("Mobile payment screen: next button click");
		clickAndWaitSpinerToVanish(nextBtn);		
	}
	
	public void paymentToolBtnClick() throws Exception {
		Log.info("Mobile payment screen: payment tool button click");
		click(paymentToolBtn);		
	}
	
	public String getCommissionAmount() throws Exception {
		Log.info("Mobile payment screen: commission amount : " + findElement(commission, driver).getText());
		return findElement(commission, driver).getText();		
	}
	
	public String getTotalAmount() throws Exception {
		Log.info("Mobile payment screen: total amount: " + findElement(total, driver).getText());
		return findElement(total, driver).getText();		
	}
	
	public String getCommissionComment() throws Exception {
		Log.info("Mobile payment screen: commission comment: " + findElement(commissionComment, driver).getText());
		return findElement(commissionComment, driver).getText();		
	}
	
	public void turnSaveTemplateSwitch() throws Exception {
		Log.info("Mobile payment screen: turn save template switch");
		click(saveTemplateSwitch);
	}
	
	public void waitForVanishCommissionRecalculateSpiner() {
		waitFor(commissionRecalculatingProgressBar);
		Log.info("Mobile payment screen: Wait for vanish commission recalculate spiner");
		waitForVanish(commissionRecalculatingProgressBar);		
	}


}
