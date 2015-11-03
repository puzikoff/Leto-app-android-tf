package ru.letoapp.screens.loans;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import ru.letoapp.AppScreenBase;


public class PaymentTab extends AppScreenBase{
	
	String titleText = "Кредит";
	final String PAYMENT_TAB_LOCATOR = "//ViewPager/NoSaveStateFrameLayout[1]";
	By remainingMoneyHint = By.xpath("//TextView[@id='text_remaining_money']");
	By remainingMoneyBlock = By.xpath("//TextView[@value='ОСТАЛОСЬ ВАШИХ ДЕНЕГ']");
	String remainingMoneyHintText = "Выплачен";
	By paymentsSchedule = By.id("widget_payments_grid");
	By moreDetailed = By.xpath("//TextView[@id='label_top_date']/../TextView[2]");
	By paymentBlockTitle = By.id("label_title_payment");
	String paymentBlockTitleText = "ОПЛАТИТЕ";
	By currentPaymentBlock = By.id("layout_action_current_payment");
	By whatIf = By.id("layout_what_if_container");
	By nextPaymentDate = By.id("label_next_payment_date");
	By repayment = By.xpath("//TextView[@value='Автопогашение с карты другого банка']");
	By inLetoBankOffices = By.xpath("//TextView[@value='В офисах банка']");
	By anotherBankPayment = By.xpath("//TextView[@value='Платежом из другого банка']");
	By paymentSystemsTerminals = By.xpath("//TextView[@value='Через терминалы платёжных систем']");
	By withdrawMoneyInATM = By.xpath("//TextView[@value='Снять в банкомате']");	
	
	@FindBy(how = How.XPATH, using = PAYMENT_TAB_LOCATOR)
	WebElement paymentTab;
	
	public PaymentTab(WebDriver driver) {
		super(driver);
	}
	
	public void verifyOpenLoan() throws Exception {
		verify.assertTrue(findElement(paymentsSchedule, driver).isDisplayed(), "Payments schedule");
		verify.assertTrue(findElement(paymentBlockTitle, driver).isDisplayed(), "Payment block title");
		verify.assertTrue(findElement(currentPaymentBlock, driver).isDisplayed(), "Current payment block");
		verify.assertTrue(findElement(whatIf, driver).isDisplayed(), "What if block");
		verify.assertTrue(findElement(repayment, driver).isDisplayed(), "Repayment block");
		verify.assertTrue(findElement(inLetoBankOffices, driver).isDisplayed(), "In leto offices");
		verify.assertTrue(findElement(anotherBankPayment, driver).isDisplayed(), "Another bank payment");
		verify.assertTrue(findElement(paymentSystemsTerminals, driver).isDisplayed(), "What if block");
		verify.assertAll();
	}
	
	public void verifyPreclosedLoan() throws Exception {
		verify.assertTrue(findElement(remainingMoneyHint, driver).isDisplayed(), "Remaining money hint");
		verify.assertTrue(findElement(remainingMoneyHint, driver).getText().contains(remainingMoneyHintText), "Remaining money hint text");
		verify.assertTrue(findElement(paymentsSchedule, driver).isDisplayed(), "Payments schedule");
		verify.assertTrue(findElement(remainingMoneyBlock, driver).isDisplayed(), "Remaining money block");
		verify.assertTrue(findElement(withdrawMoneyInATM, driver).isDisplayed(), "Withdraw money in ATM");
		verify.assertAll();
	}
		
	public void paymentScheduleClick() throws Exception {
		waitFor(paymentsSchedule);
		Log.info("Loan payment tab: Payment schedule click");
		clickAndWaitSpinerToVanish(paymentsSchedule);			
	}
	
	public void whatIfClick() throws Exception {
		waitForClickable(whatIf);
		Log.info("Loan payment tab: What if? click");
		clickAndWaitSpinerToVanish(whatIf);			
	}
	
	public void inLetoBankOfficesClick() throws Exception {
		waitForClickable(inLetoBankOffices);
		Log.info("Loan payment tab: In leto bank offices payment click");
		clickAndWaitSpinerToVanish(inLetoBankOffices);			
	}
	
	public void withdrawMoneyInATMClick() throws Exception {
		waitForClickable(withdrawMoneyInATM);
		Log.info("Loan payment tab: Withdraw money in ATM");
		clickAndWaitSpinerToVanish(withdrawMoneyInATM);			
	}
	
	public void anotherBankPaymentClick() throws Exception {
		waitForClickable(anotherBankPayment);
		Log.info("Loan payment tab: Another bank payment click");
		clickAndWaitSpinerToVanish(anotherBankPayment);			
	}
	
	public void paymentSystemsTerminalsClick() throws Exception {
		waitForClickable(paymentSystemsTerminals);
		Log.info("Loan payment tab: Payments systems terminalst click");
		clickAndWaitSpinerToVanish(paymentSystemsTerminals);			
	}
	
	public String getPaymentDate() throws Exception {
		Log.info("Loan screen, Payment tab: Get payment date from payment tab");		
		String paymentDate = findElement(nextPaymentDate, driver).getText();
		Log.info("Payment date block text: " + paymentDate);
		Log.info("Payment date: " + onlyNumbers(paymentDate));
		return onlyNumbers(paymentDate);
	}
}
