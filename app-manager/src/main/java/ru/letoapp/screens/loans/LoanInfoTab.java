package ru.letoapp.screens.loans;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import ru.letoapp.AppScreenBase;


public class LoanInfoTab extends AppScreenBase{	
	
	By contractBtn = By.id("widget_show_contract_details");
	By creditOperationsBtn = By.id("layout_action_show_loan_operations");
	By insuranceBtn = By.id("widget_show_insurance");
	By noInsurance = By.id("widget_no_insurance");
	By repaymentCardBtn = By.id("widget_show_repayment_card");
	By paymentsScheduleBtn = By.id("widget_show_payment_schedule");
	By superRateBtn = By.id("widget_superrate_info");
	
	final String  INFO_TAB_LOCATOR = "//ViewPager/NoSaveStateFrameLayout[2]";
	
	@FindBy(how = How.XPATH, using = INFO_TAB_LOCATOR)
	WebElement infoTab;

	public LoanInfoTab(WebDriver driver) {
		super(driver);
	}
	
	public void verify() {
		verify.assertTrue(findElement(contractBtn, driver).isDisplayed(), "Contract");
		verify.assertTrue(findElement(creditOperationsBtn, driver).isDisplayed(), "Credit operations");
		verify.assertTrue(findElement(insuranceBtn, driver) != null, "Insurance");
		verify.assertTrue(findElement(noInsurance, driver) != null, "No Insurance");
		verify.assertTrue((findElement(noInsurance, driver).isDisplayed())||(findElement(insuranceBtn, driver).isDisplayed()), "No Insurance or insurance displayed");
		verify.assertTrue(findElement(paymentsScheduleBtn, driver).isDisplayed(), "Payments schedule btn");
		verify.assertTrue(findElement(repaymentCardBtn, driver) != null, "Repayment card");
		verify.assertTrue(findElement(superRateBtn, driver) != null, "Super rate btn");
		verify.assertAll();
	}
	
	public void contractBtnClick() {		
		Log.info("Loan info tab: contract butoon click");
		clickAndWaitSpinerToVanish(contractBtn);	
	}
	
	public void creditOperationsBtnClick() {		
		Log.info("Loan info tab: Credit operations button click");
		clickAndWaitSpinerToVanish(creditOperationsBtn);	
	}
	
	public void insuranceBtnClick() {		
		Log.info("Loan info tab: Insurance button click");
		if(isInsuranceBtnClickable()) {
			Log.info("Loan info tab: Insurance button clickable");
			clickAndWaitSpinerToVanish(insuranceBtn);
		}
		else
			Log.info("Loan info tab: Insurance button is not clickable");
	}
	
	public void paymentsScheduleBtnClick() {		
		Log.info("Loan info tab: Payments schedule button click");
		clickAndWaitSpinerToVanish(paymentsScheduleBtn);	
	}
	
	public boolean isInsuranceBtnClickable() {
		if(isElementClickable(insuranceBtn)) {
			Log.info("Loan screen, info tab: insurance button is clickable");
			return true;
		}
		else {
			Log.info("Loan screen, info tab: insurance button  is not clickable");
			return false;
		}
	}

}
