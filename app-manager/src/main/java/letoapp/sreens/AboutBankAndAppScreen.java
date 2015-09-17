package letoapp.sreens;

import letoapp.AppScreenBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutBankAndAppScreen extends AppScreenBase{
	
	By writeToUsBtn = By.id("layout_section_write_to_us");
	By bankName = By.xpath("//ScrollView//LinearLayout/LinearLayout[1]/TextView[1]");
	String bankNameText = "ПАО «Лето Банк»";
	By bankLicense = By.xpath("//ScrollView//LinearLayout/LinearLayout[1]/TextView[2]");
	String bankLicenseText = "Лицензия ЦБ РФ на осуществление банковских операций № 650 от 25 марта 2015.";
	By vtbInfo = By.xpath("//ScrollView//LinearLayout/LinearLayout[1]/TextView[3]");
	String vtbInfoText = "Является частью международной финансовой группы ВТБ.";	
	By version = By.id("label_application_version");
	
	public AboutBankAndAppScreen(WebDriver driver) {
		super(driver);
	}
	
	public void verify() {
		verify.assertEquals(findElement(bankName, driver).getText(), bankNameText, "Bank name");
		verify.assertEquals(findElement(bankLicense, driver).getText(), bankLicenseText, "Bank license");
		verify.assertEquals(findElement(vtbInfo, driver).getText(), vtbInfoText, "VTB information");
		verify.assertTrue(findElement(version, driver).isDisplayed(), "Version exist");		
		verify.assertAll();
	}
	
	public void writeToUsBtnClick() {
		Log.info("About bank and application: write to us button click");
		click(writeToUsBtn);
	}

}
