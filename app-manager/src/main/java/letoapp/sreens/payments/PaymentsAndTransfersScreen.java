package letoapp.sreens.payments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import letoapp.AppScreenBase;

public class PaymentsAndTransfersScreen extends AppScreenBase{
	By serachField = By.xpath("//EditText");
	String title = "Платежи и переводы";
	
	private PaymentsTab paymentsTab;
	private TemplatesTab templatesTab;
	private TransfersTab transfersTab;
	By templatesTabBtn = By.xpath("//TextView[@value='ШАБЛОНЫ']");
	By paymentsTabBtn = By.xpath("//TextView[@value='ПЛАТЕЖИ']");
	By transfersTabBtn = By.xpath("//TextView[@value='ПЕРЕВОДЫ']");	

	public PaymentsAndTransfersScreen(WebDriver driver) {
		super(driver);
		paymentsTab = PageFactory.initElements(driver, PaymentsTab.class);
		transfersTab = PageFactory.initElements(driver, TransfersTab.class);
		templatesTab = PageFactory.initElements(driver, TemplatesTab.class);
		paymentsTab.setDriver(driver);
		transfersTab.setDriver(driver);
		templatesTab.setDriver(driver);
	}
	
	public void verify() {
		Log.info("Verify payments and transfers screen");
		verify.assertEquals(getTitleFromActionBar(), title, "Verify payments and transfers screen: Title");
		verify.assertAll();
	}
	
	public PaymentsTab getPaymentsTab () {
		return paymentsTab;
	}
	
	public TemplatesTab getTemplatesTab() {
		return templatesTab;
	}
	
	public TransfersTab getTransfersTab() {
		return transfersTab;
	}
	
	public void searchBy(String searchString) {
		Log.info("Menu: Search by - " + searchString);
		findElement(serachField, driver).clear();
		findElement(serachField, driver).sendKeys(searchString);
	}
	
	public void templatesTabBtnClick() {
		Log.info("Payments and transfers screen: Templates tab click");
		findElement(templatesTabBtn, driver).click();
		delay();
	}
	
	public void paymentsTabBtnClick() {
		Log.info("Payments and transfers screen: Payments tab click");
		findElement(paymentsTabBtn, driver).click();
		delay();
	}
	
	public void transfersTabBtnClick() {
		Log.info("Payments and transfers screen: Transfers tab click");
		findElement(transfersTabBtn, driver).click();
		delay();
	}

}
