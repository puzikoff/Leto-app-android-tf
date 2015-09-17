package letoapp.sreens.payments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import letoapp.AppScreenBase;

public class PaymentsTab extends AppScreenBase{
	By paymentsList = By.xpath("//ListView");
	
	public PaymentsTab(WebDriver driver) {
		super(driver);
	}

	public void categoryClick(String categoryName) {
		Log.info("Payments tab: Choose category - " + categoryName);
		findElement(By.xpath("//TextView[@value='" + categoryName + "']"), driver).click();		
		delay();		
	}
	
	public void paymentClick(String paymentName) {
		Log.info("Payments tab: Choose payment - " + paymentName);
		clickAndWaitSpinerToVanish(By.xpath("//TextView[@value='" + paymentName + "']"));				
	}
	
	public void flickPaymentsListDown() {
		Log.info("Payments tab: flick paymets menu down");
		flick(paymentsList, 0, -100, 0);
	}

}
