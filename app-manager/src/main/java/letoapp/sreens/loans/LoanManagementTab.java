package letoapp.sreens.loans;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import letoapp.AppScreenBase;

public class LoanManagementTab extends AppScreenBase{
	
	By repaymentBlock = By.xpath("//TextView[@value='Автопогашение']");
	By changePayDateBlock = By.xpath("//TextView[@value='Меняю дату платежа']");
	By skipPayBlock = By.xpath("//TextView[@value='Пропустить платёж']");
	By reducePayBlock = By.xpath("//TextView[@value='Уменьшить платёж']");
	By connectingServicesHistoryBtn = By.xpath("//TextView[@value='История подключения услуг']");	
	
	final String  MANAGEMENT_TAB_LOCATOR = "//ViewPager/NoSaveStateFrameLayout[2]";
	
	@FindBy(how = How.XPATH, using = MANAGEMENT_TAB_LOCATOR)
	WebElement managmentTab;

	public LoanManagementTab(WebDriver driver) {
		super(driver);
	}
	
	public void verify(){
		verify.assertTrue(findElement(connectingServicesHistoryBtn, driver).isDisplayed(), "Connecting services history");
		verify.assertAll();
	}
	
	public void serviceDetailsClick(String serviceName){
		Log.info("Loan management tab: " + serviceName + " detailes click");
		if(findElement(By.xpath("//TextView[@value='" + serviceName + "']/../../ImageView"), driver) != null) {
			findElement(By.xpath("//TextView[@value='" + serviceName + "']/../../ImageView"), driver).click();
			if(findElement(By.xpath("//TextView[@value='" + serviceName + "']/../../..//TextView[@id='label_pressable_caption']"), driver).isDisplayed()) {				
				findElement(By.xpath("//TextView[@value='" + serviceName + "']/../../..//TextView[@id='label_pressable_caption']"), driver).click();
				delay();
				if(isWaitPopupDisplayed()) {
					waitForVanishWaitPopup();
				}
			}
			else {
				Log.info("Loan management tab: " + serviceName + " connected");
				Assert.fail("Loan management tab: " + serviceName + " connected");
			}
		}
		else {
			Log.info("Loan management tab: " + serviceName + " is unavailable");
			Assert.fail("Loan management tab: " + serviceName + " is unavailable");
		}
	}
	
	public void unwrapServiceBlock(String serviceName){
		Log.info("Loan management tab: Unwrap service " + serviceName + " block");
		findElement(By.xpath("//TextView[@value='" + serviceName + "']/../../ImageView"), driver).click();
	}
	
	public void wrapServiceBlock(String serviceName){
		Log.info("Loan management tab: Wrap service " + serviceName + " block");
		findElement(By.xpath("//TextView[@value='" + serviceName + "']/../../ImageView"), driver).click();		
	}
	
	public void connectingServicesHistoryBtnClick() {
		Log.info("Loan management tab: Connecting services button click");
		findElement(connectingServicesHistoryBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }
	}

}
