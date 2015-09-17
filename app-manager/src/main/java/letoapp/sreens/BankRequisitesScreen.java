package letoapp.sreens;

import letoapp.AppScreenBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankRequisitesScreen extends AppScreenBase{
		
	By fullName = By.xpath("//CaptionTextItemView_[1]/TextView[2]");
	String fullNameText = "Публичное акционерное общество «Лето Банк»";
	By shortName = By.xpath("//CaptionTextItemView_[2]/TextView[2]");
	String shortNameText = "ПАО «Лето Банк»";
	By lawAddress = By.xpath("//CaptionTextItemView_[3]/TextView[2]");
	String lawAddressText = "101000, г. Москва, ул. Мясницкая, д. 35";
	By postAddress = By.xpath("//CaptionTextItemView_[4]/TextView[2]");
	String postAddressText = "107061, г. Москва, Преображенская площадь, д. 8";
	By corAccount = By.xpath("//CaptionTextItemView_[5]/TextView[2]");
	String corAccountText = "№ 3010 1810 8000 0000 0214, открытый\nв Отделении 2 Главного управления\nЦентрального банка Российской Федерации\nпо Центральному федеральному округу г. Москва";
	By iNN = By.xpath("//CaptionTextItemView_[6]/TextView[2]");
	String iNNValue = "3232005484";
	By bIK = By.xpath("//CaptionTextItemView_[7]/TextView[2]");
	String bIKValue = "044585214";
	By oKPOCode = By.xpath("//CaptionTextItemView_[8]/TextView[2]");
	String oKPOCodeValue = "09106059";
	By oKONCCode = By.xpath("//CaptionTextItemView_[9]/TextView[2]");
	String oKONCCodeValue = "96120";
	By bankOGRN = By.xpath("//CaptionTextItemView_[10]/TextView[2]");
	String bankOGRNValue = "1023200000010";
	By kPP = By.xpath("//CaptionTextItemView_[11]/TextView[2]");
	String kPPValue = "775001001";

	public BankRequisitesScreen(WebDriver driver) {
		super(driver);
	}
	
	public void verifyScreen() {		
		verify.assertEquals(findElement(fullName, driver).getText(), fullNameText, "Full name");
		verify.assertEquals(findElement(shortName, driver).getText(), shortNameText, "Short name");
		verify.assertEquals(findElement(lawAddress, driver).getText(), lawAddressText, "Law address");
		verify.assertEquals(findElement(postAddress, driver).getText(), postAddressText, "Post address");
		verify.assertEquals(findElement(corAccount, driver).getText(), corAccountText, "correspondent account");		
		verify.assertEquals(findElement(iNN, driver).getText(), iNNValue, "INN");
		verify.assertEquals(findElement(bIK, driver).getText(), bIKValue, "BIK");
		verify.assertEquals(findElement(oKPOCode, driver).getText(), oKPOCodeValue, "OKPO");
		verify.assertEquals(findElement(oKONCCode, driver).getText(), oKONCCodeValue, "OKON");
		verify.assertEquals(findElement(bankOGRN, driver).getText(), bankOGRNValue, "Bank OGRN");
		verify.assertEquals(findElement(kPP, driver).getText(), kPPValue, "KPP");
		verify.assertAll();
	}

}
