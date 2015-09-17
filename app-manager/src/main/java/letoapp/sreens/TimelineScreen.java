package letoapp.sreens;

import letoapp.AppScreenBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TimelineScreen extends AppScreenBase{
	
	private String loanOperationsTitleText = "Операции по кредиту";
	private String cardOperationsTitleText = "Операции по карте";
	private String depositOperationsTitleText = "Операции по вкладу";
	private String walletOperationsTitleText = "Операции по кошельку";
	private String connectionServicesHistoryTitleText = "История подключения услуг";
	private String holdsTitleText = "Заблокировано";
	By updateSpiner = By.xpath("//ProgressBar[@id='progress_loading']");

	By loadingError = By.xpath("//ProgressBar[@id='progress_loading']/following-sibling::TextView");

	public TimelineScreen(WebDriver driver) {
		super(driver);
	}

	public void verifyLoanOperationsScreen() {
		verify.assertTrue(getTitleFromActionBar().contains(loanOperationsTitleText), "Loan operations screen: title");
		verify.assertAll();	
	}
	
	public void verifyCardOperationsScreen() {
		verify.assertTrue(getTitleFromActionBar().contains(cardOperationsTitleText), "Card operations screen: title");
		verify.assertAll();	
	}
	
	public void verifyDepositOperationsScreen() {
		verify.assertTrue(getTitleFromActionBar().contains(depositOperationsTitleText), "deposit operations screen: title");
		verify.assertAll();	
	}
	
	public void verifyWalletOperationsScreen() {
		verify.assertTrue(getTitleFromActionBar().contains(walletOperationsTitleText), "wallet operations screen: title");
		verify.assertAll();		
	}
	
	public void verifyConnectionServicesHistoryScreen() {
		verify.assertEquals(getTitleFromActionBar(), connectionServicesHistoryTitleText, "Connection services history screen: title");
		verify.assertAll();	
	}

	public void verifyHoldsScreen() {
		verify.assertTrue(getTitleFromActionBar().contains(holdsTitleText), "Holds screen: title");
		verify.assertAll();	
	}
	
	public boolean isLoadingErrorExist() {		
		if(findElement(loadingError, driver)!= null){
			Log.error("Timeline screen: Loading ERROR");
			takeScreenshot();
			return true;
		}
		else return false;		

	}

	public void waitForVanishUpdateSpiner() {
		waitForVanish(updateSpiner);		
	}

	

}
