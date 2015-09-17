package letoapp.sreens.loans;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import letoapp.AppScreenBase;
import letoapp.sreens.EditDisplayNameBlock;

public class LoanScreen extends AppScreenBase{
	
	private PaymentTab paymentTab;
	private LoanInfoTab loanInfoTab;
	private LoanManagementTab loanManagementTab;
	private EditDisplayNameBlock editDisplayName;
	String actionBarTitle = "Кредит";	
	By paymentTabBtn = By.xpath("//TextView[@value='ПЛАТЁЖ']");
	By infoTabBtn = By.xpath("//TextView[@value='ИНФОРМАЦИЯ']");
	By managementTabBtn = By.xpath("//TextView[@value='УПРАВЛЕНИЕ']");	
	By updateIndicator = By.xpath("//ProgressBar[@id='progress_contract_loading']");

	public LoanScreen(WebDriver driver) {
		super(driver);	
		paymentTab = PageFactory.initElements(driver, PaymentTab.class);
		loanInfoTab = PageFactory.initElements(driver, LoanInfoTab.class);
		loanManagementTab = PageFactory.initElements(driver, LoanManagementTab.class);
		editDisplayName = PageFactory.initElements(driver, EditDisplayNameBlock.class);
		paymentTab.setDriver(driver);
		loanInfoTab.setDriver(driver);
		loanManagementTab.setDriver(driver);
		editDisplayName.setDriver(driver);
	}
	
	public void verify() {
		Log.info("Loan screen: verify screen");
		Log.info(getTitleFromActionBar());
		verify.assertEquals(getTitleFromActionBar(), actionBarTitle , "Loan screen: title");
		verify.assertAll();
	}
	
	public PaymentTab getPaymentTab(){
		return paymentTab;
	}
	
	public LoanInfoTab getLoanInfoTab() {
		return loanInfoTab;
	}
	
	public LoanManagementTab getLoanManagementTab() {
		return loanManagementTab;
	}
	
	public EditDisplayNameBlock getEditDisplayName() {
		return editDisplayName;
	}
	
	public void infoTabClick() {
		Log.info("Loan Screen: Information tab click");
		findElement(infoTabBtn, driver).click();
		delay();
	}

	public void managementTabClick() {
		Log.info("Loan Screen: Managementd tab click");
		findElement(managementTabBtn, driver).click();
		delay();		
	}
	
	public void paymentTabClick() {
		Log.info("Loan Screen: Payment tab click");
		findElement(paymentTabBtn, driver).click();
		delay();
	}
	
	public void waitForVanishUpdateIndicator() {
		Log.info("Loan screen: Wait for vanish update spiner");		
		waitForVanish(updateIndicator);			

	}	

}
