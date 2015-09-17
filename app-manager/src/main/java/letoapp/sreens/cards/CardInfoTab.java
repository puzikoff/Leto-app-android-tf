package letoapp.sreens.cards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import letoapp.AppScreenBase;

public class CardInfoTab extends AppScreenBase{	
	
	By howToUseCardBtn = By.id("widget_action_how_to_use_card");
	By product = By.id("label_product");
	By cardOperationsBtn = By.id("widget_show_operation_history");
	By generalInformationText = By.xpath("//TextView[@value='ОБЩАЯ ИНФОРМАЦИЯ']");
	By productBlock = By.xpath("//TextView[@value='ПРОДУКТ']");
	By creditLimitBlock = By.xpath("//TextView[@value='КРЕДИТНЫЙ ЛИМИТ']");
	By spendCreditBlock = By.xpath("//TextView[@value='ИСПОЛЬЗОВАННЫЙ КРЕДИТ']");
	By paymentDateBlock = By.xpath("//TextView[@value='ПЛАТЁЖНАЯ ДАТА']");
	By paymentDateBlockText = By.xpath("//CaptionTextItemView_[@id='widget_payment_date']//TextView[@id='label_text']");
	By expirationDateBlock = By.xpath("//TextView[@value='КАРТА ДЕЙСТВУЕТ ДО']");
	By statusBlock = By.xpath("//TextView[@value='СТАТУС']");
	By contractNumberBlock = By.xpath("//TextView[@value='НОМЕР ДОГОВОРА']");
	By contractDateBlock = By.xpath("//TextView[@value='ДАТА ДОГОВОРА']");
	By paymentBlock = By.xpath("//TextView[@value='ПЛАТЁЖ']");
	
	public CardInfoTab(WebDriver driver) {
		super(driver);
	}	
	
	public void howToUseCardClick() {
		waitFor(howToUseCardBtn);
		Log.info("Card screen, info tab: How to use card button click");
		click(howToUseCardBtn);
	}
	
	public void cardOperationsClick() {
		waitFor(cardOperationsBtn);
		Log.info("Card screen, info tab: Card operations button click");
		clickAndWaitSpinerToVanish(cardOperationsBtn);	
	}

	public void verify() {
		Log.info("Card screen, info tab: verify");
		verify.assertTrue(findElement(howToUseCardBtn, driver).isDisplayed(), "How to use card");
		verify.assertTrue(findElement(cardOperationsBtn, driver).isDisplayed(), "Card operations");
		verify.assertTrue(findElement(generalInformationText, driver).isDisplayed(), "General information");
		verify.assertTrue(findElement(productBlock, driver).isDisplayed(), "Product block");
		verify.assertTrue(findElement(creditLimitBlock, driver).isDisplayed(), "Credit limit block");
		verify.assertTrue(findElement(spendCreditBlock, driver).isDisplayed(), "Spend credit block");
		verify.assertTrue(findElement(paymentDateBlock, driver).isDisplayed(), "Payment date");
		verify.assertTrue(findElement(expirationDateBlock, driver).isDisplayed(), "Expiration date");
		verify.assertTrue(findElement(statusBlock, driver).isDisplayed(), "Status");
		verify.assertTrue(findElement(contractNumberBlock, driver).isDisplayed(), "Contract number");
		verify.assertTrue(findElement(contractDateBlock, driver).isDisplayed(), "Contract date");
		verify.assertTrue(findElement(paymentBlock, driver).isDisplayed(), "Payment");
		verify.assertAll();
	}
	
	public String getPaymentDate() {
		Log.info("Get payment date from info tab");		
		String paymentDate = findElement(paymentDateBlockText, driver).getText();
		Log.info("Payment date block text: " + paymentDate);
		Log.info("Payment date: " + onlyNumbers(paymentDate));
		return onlyNumbers(paymentDate);
	}
}
