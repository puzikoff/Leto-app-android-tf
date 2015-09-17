package letoapp.sreens;

import letoapp.AppScreenBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentsInTerminalsSecreen extends AppScreenBase{
	String titleText = "Через терминалы";
	By hint = By.id("label_description");	
	String hintText = "Зачисление может занять от 2-х до 10-и рабочих дней";
	By bankNameBlock = By.xpath("//TextView[@value='НАИМЕНОВАНИЕ БАНКА']");
	By bankNameBlockText = By.xpath("//TextView[@value='НАИМЕНОВАНИЕ БАНКА']/following-sibling::TextView");
	String bankNameText = "ПАО \"Лето Банк\"";
	By bIKBlock = By.xpath("//TextView[@value='БИК']");
	By bIKBlockText = By.xpath("//TextView[@value='БИК']/following-sibling::TextView");
	String bikValue = "044585214";
	By iNNBlock = By.xpath("//TextView[@value='ИНН']");
	By iNNBlockText = By.xpath("//TextView[@value='ИНН']/following-sibling::TextView");
	String innValue = "3232005484";
	By kPPBlock = By.xpath("//TextView[@value='КПП']");
	By kPPBlockText = By.xpath("//TextView[@value='КПП']/following-sibling::TextView");
	String kPPValue = "997950001";
	By correspondentAccountBlock = By.xpath("//TextView[@value='КОРР. СЧЁТ']");
	By correspondentAccountBlockText = By.xpath("//TextView[@value='КОРР. СЧЁТ']/following-sibling::TextView");
	String corespondentAccountValue = "3010 1810 8000 0000 0214";	
	By clientAccountBlock = By.xpath("//TextView[@value='НОМЕР СЧЁТА КЛИЕНТА']");	
	By paymentPurposeBlock = By.xpath("//TextView[@value='НАЗНАЧЕНИЕ ПЛАТЕЖА']");	

	public PaymentsInTerminalsSecreen(WebDriver driver) {
		super(driver);
	}

	public void verify() {		
		verify.assertEquals(findElement(hint, driver).getText(), hintText, "Hint text");
		verify.assertEquals(findElement(bankNameBlockText, driver).getText(), bankNameText, "Bank name");
		verify.assertEquals(findElement(bIKBlockText, driver).getText(), bikValue, "BIK");
		verify.assertEquals(findElement(iNNBlockText, driver).getText(), innValue, "INN");
		verify.assertEquals(findElement(kPPBlockText, driver).getText(), kPPValue, "kPP");
		verify.assertEquals(findElement(correspondentAccountBlockText, driver).getText(), corespondentAccountValue, "Correspondent account");
		verify.assertTrue(findElement(clientAccountBlock, driver).isDisplayed(), "client account");
		verify.assertTrue(findElement(paymentPurposeBlock, driver).isDisplayed(), "Payment purpose");
		verify.assertTrue(getTitleFromActionBar().contains(titleText), "Payments via terminals screen: title");
		verify.assertAll();		
	}

}
