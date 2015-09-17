package letoapp.sreens.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import letoapp.AppScreenBase;

public class ForgotPswScreen extends AppScreenBase{	
	
	String actionBarTitle = "Забыли логин или пароль?";
	String titleText = "Вы всегда можете получить\nновые логин и пароль";
	String tipText = "Вам понадобится 16-значный номер вашей платёжной карты Лето Банка или 20-значный номер вашего счёта в Лето Банке, который начинается с цифры 4";
	String newCredentialsBtnText = "Получить новые логин и пароль";
	By title = By.xpath("//FrameLayout[@id='mdc__layout_content']//TextView[1]");
	By tip = By.xpath("//FrameLayout[@id='mdc__layout_content']//TextView[2]");
	By newCredentialsBtn = By.id("button_get_new_credentials");

	public ForgotPswScreen(WebDriver driver) {
		super(driver);		
	}
	
	public void verifyScreen() {
		Log.info("Forgot login or password screen: verify screen");
		verify.assertEquals(getTitleFromActionBar(), actionBarTitle, "Forgot login or password screen: Action bar title");
		verify.assertEquals(findElement(title, driver).getText(), titleText, "Forgot login or password screen: Title text");
		Log.info(findElement(title, driver).getText());
		verify.assertEquals(findElement(tip, driver).getText(), tipText, "Forgot login or password screen: Tip text");
		findElement(tip, driver).getText();
		verify.assertEquals(findElement(newCredentialsBtn, driver).getText(), newCredentialsBtnText, "Forgot login or password screen: Button text");
		verify.assertAll();
	}

	public void getNewCredentialsBtnClick() {
		waitFor(newCredentialsBtn);
		Log.info("Forgot Psw Screen: New credentials button click");
		findElement(newCredentialsBtn, driver).click();	
		delay();
	}

}
