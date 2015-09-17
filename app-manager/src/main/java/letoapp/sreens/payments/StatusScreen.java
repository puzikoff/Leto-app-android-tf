package letoapp.sreens.payments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import letoapp.AppScreenBase;

public class StatusScreen extends AppScreenBase{
	By status = By.xpath("//TextView[@id = 'label_status']");
	By progressBar = By.xpath("//ProgressBar[@id = 'progress_loading']");
	String successStatusText = "Успешно";
	String failedStatusText = "Отклонена";
	By editTemplateNameFiled = By.xpath("//EditText[@id = 'edit_template_name']");
	By templateHint = By.xpath("//EditText[@id = 'edit_template_name']//preceding-sibling::TextView");
	String templateHintText = "Вы можете создать шаблон перевода, чтобы в дальнейшем платить быстрее.";
	By createTemplateBtn = By.xpath("//Button[@id='button_create_template']");
	By comission = By.xpath("//TextView[@value='КОМИССИЯ']/following-sibling::LinearLayout/EditText");
	By amount = By.xpath("//TextView[@value='СУММА']/following-sibling::LinearLayout/EditText");
	By phoneNumber = By.xpath("//TextView[@value='НОМЕР ТЕЛЕФОНА']/following-sibling::LinearLayout/WeakMaskedEditText");
	

	public StatusScreen(WebDriver driver) {
		super(driver);
	}

	public void editTemplateName(String templateName) {
		Log.info("Payment status screen: edit template name, new name: " + templateName);
		findElement(editTemplateNameFiled, driver).clear();
		findElement(editTemplateNameFiled, driver).sendKeys(templateName);
		delay();
	}
	
	public void createTemplaetBtnClick() {
		Log.info("Payment status screen: create template btn click");
		clickAndWaitSpinerToVanish(createTemplateBtn);		
	}
	
	public void waitForVanishUpdateStatus() {		
		waitFor(progressBar);
		Log.info("Payment status screen: create template btn click");
		waitForVanish(progressBar);	
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
