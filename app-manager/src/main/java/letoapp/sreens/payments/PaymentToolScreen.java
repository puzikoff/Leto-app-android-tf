package letoapp.sreens.payments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import letoapp.AppScreenBase;
import letoapp.utilities.PropertyReader;

public class PaymentToolScreen extends AppScreenBase{
	By nextBtn = By.xpath("//Button[@id='button']");
	By comission = By.xpath("//TextView[@value='КОМИССИЯ']/following-sibling::LinearLayout/EditText");
	By amount = By.xpath("//TextView[@value='СУММА']/following-sibling::LinearLayout/EditText");
	By phoneNumber = By.xpath("//TextView[@value='НОМЕР ТЕЛЕФОНА']/following-sibling::LinearLayout/WeakMaskedEditText");
	By comissionBlock = By.xpath("//TextView[@value='КОМИССИЯ']");
	By amountBlock = By.xpath("//TextView[@value='СУММА']");
	By phoneNumberBlock = By.xpath("//TextView[@value='НОМЕР ТЕЛЕФОНА']");
	By subtitle = By.xpath("//TextView[@value='ОПЛАТИТЬ С']");
	String subtitleText = "ОПЛАТИТЬ С";
	
	
	public void verify () {
		verify.assertEquals(findElement(subtitle, driver).getText(), subtitleText, "Payment tool screen: subtitle");
		//verify.assertFalse(isPaymentToolDetailsEmpty(PropertyReader.getProperty("cardName")), "Payment tool screen: Card deteails is empty");
		verify.assertTrue(findElement(comissionBlock, driver) != null, "Payment tool screen: comission block");
		verify.assertTrue(findElement(amountBlock, driver) != null, "Payment tool screen: amount block");
		verify.assertTrue(findElement(phoneNumberBlock, driver) != null, "Payment tool screen: phone number block");
		verify.assertAll();
	}
	
	public boolean isPaymentToolDetailsEmpty (String paymentToolName) {
		if(findElement(By.xpath("//TextView[@value='" + paymentToolName + "']/../following-sibling::TextView"), driver).getText() != "") {
			return false;
		}
		else {
			Log.info("Payment tool screen: payment tool " + paymentToolName + " details is empty");
			takeScreenshot();
			return true;
		}			
	}
	
	public PaymentToolScreen(WebDriver driver) {
		super(driver);
	}
	
	public void choosePaymentTool(String paymentTool) {
		Log.info("Payment tool screen: Choose payment tool - " + paymentTool);
		clickAndWaitSpinerToVanish(By.xpath("//TextView[@value='" + paymentTool + "']/following-sibling::TextView/following-sibling::RadioButton"));				
	}

	public void nextBtnClick(){
		Log.info("Amount screen: next button click");
		clickAndWaitSpinerToVanish(nextBtn);
	}
	
	public String getComission() {
		Log.info("Payment tool screen: comission: " + findElement(comission, driver).getText());
		return onlyNumbers(findElement(comission, driver).getText());
	}
	
	public String getAmount() {
		Log.info("Payment tool screen: amount: " + findElement(amount, driver).getText());
		return onlyNumbers(findElement(amount, driver).getText());
	}
	
	public String getPhoneNumber() {
		Log.info("Payment tool screen: phoneNumber: " + findElement(phoneNumber, driver).getText());
		return onlyNumbers(findElement(phoneNumber, driver).getText());
	}
}
