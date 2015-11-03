package ru.letoapp.screens;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import ru.letoapp.AppScreenBase;
import ru.letoapp.screens.popups.AndroidPopup;
import ru.letoapp.screens.popups.EmptyLoginPopup;
import ru.letoapp.screens.popups.EmptyPasswordPopup;
import ru.letoapp.screens.popups.GreetingPopup;

public class AuthScreen extends AppScreenBase {
	
	GreetingPopup greetingPopup;
	EmptyLoginPopup emptyLoginPopup;
	EmptyPasswordPopup emptyPasswordPopup;
	AndroidPopup androidPopup;

	By greetingMessage = By.id("sdl__message");
	By androidPopupLocator = By.id("alertTitle");
	By emptyLoginPopupLocator = By.xpath("//NoSaveStateFrameLayout/LinearLayout");
	By emptyPasswordPopupLocator = By.xpath("//NoSaveStateFrameLayout/LinearLayout");
	By authTitle = By.xpath("//ScrollView//TextView[3]");
	By authSubTitle = By.id("text_subtitle");
	By usernameTextField = By.id("text_username");
	By passwordTextField = By.id("text_password");
	By protCodeCheckbox = By.id("checkbox_set_protection_code");
	By loginBtn = By.id("button_login");	
	By remindLogPasLink = By.id("button_remind_login_or_password");
	By registerBtn = By.id("button_register");		
	String authTitleText = "Введите логин и пароль";
	String authSubTitleText = "Это поможет защитить ваши деньги";
	String protCodeCheckboxText = "Установить защитный код для быстрого входа";
	String loginBtnText = "Войти";
	String remindLogPasLinkText = "Забыли логин или пароль?";
	String registerBtnText = "Зарегистрироваться";	
	
	public AuthScreen(WebDriver driver) {
		super(driver);		
		greetingPopup = PageFactory.initElements(driver,GreetingPopup.class);
		greetingPopup.setDriver(driver);
		emptyLoginPopup = PageFactory.initElements(driver,EmptyLoginPopup.class);
		emptyLoginPopup.setDriver(driver);
		emptyPasswordPopup = PageFactory.initElements(driver,EmptyPasswordPopup.class);
		emptyPasswordPopup.setDriver(driver);
		androidPopup = PageFactory.initElements(driver, AndroidPopup.class);
		androidPopup.setDriver(driver);
		
	}	
	
	public GreetingPopup getGreetingPopup() {
		return greetingPopup;
	}
	
	public EmptyLoginPopup getEmptyLoginPopup() {
		return emptyLoginPopup;
	}

	public EmptyPasswordPopup getEmptyPasswordPopup() {
		return emptyPasswordPopup;
	}
	
	public AndroidPopup getAndroidPopup() {
		return androidPopup;
	}

	
	public boolean isEmptyLoginPopupDisplayed() {
		try {
				List <WebElement> emptyLoginPopups = driver.findElements(emptyLoginPopupLocator);
				if(!emptyLoginPopups.isEmpty()) {
					Log.info("Auth screen: Empty login popup displayed");
					return true;
				}
				Log.info("Auth screen: Empty login popup is not displayed");
				return false;
		}
		catch(NullPointerException e) {
			Log.info("Auth screen: Empty login popup is not displayed (NullPointerException)");
			return false;
		}
		
	}
	
	public boolean isAndroidPopupDisplayed() {
		try {
			List <WebElement> androidPopups = driver.findElements(androidPopupLocator);
			if(!androidPopups.isEmpty()) {
				Log.info("Auth screen: Android popup displayed");
				return true;
			}
			Log.info("Auth screen: Android popup is not displayed");
			return false;
		}
		catch(NullPointerException e) {
			Log.info("Auth screen: Android popup is not displayed (NullPointerException)");
			return false;
		}
	}
	
	public boolean isEmptyPasswordPopupDisplayed() {
		try {
			List <WebElement> emptyPasswordPopups = driver.findElements(emptyPasswordPopupLocator);
			if(!emptyPasswordPopups.isEmpty()) {
				Log.info("Auth screen: Empty password popup displayed");
				return true;
			}
			Log.info("Auth screen: Empty password popup is not displayed");
			return false;
		}
		catch(NullPointerException e) {
			Log.info("Auth screen: Empty password popup is not displayed (NullPointerException)");
			return false;
		}
	}		
	
	public boolean isGreetingMessageDisplayed() {
		try{
			List <WebElement> greetingPopUp = driver.findElements(greetingMessage);
			if(!greetingPopUp.isEmpty()) {
				Log.info("Auth screen: Greeting popup displayed");
				return true;
			}
			Log.info("Auth screen: Greeting popup is not displayed");
			return false;
		}
		catch(NullPointerException e) {
			Log.info("Auth screen: Greeting popup is not displayed (NullPointerException)");
			return false;
		}
	}		
	
	public void verifyAuthScreen() throws Exception {		
		verify.assertEquals(findElement(authTitle, driver).getText(), authTitleText, "Auth title text");	
		verify.assertEquals(findElement(authSubTitle, driver).getText(), authSubTitleText, "Auth subtitle text");
		verify.assertEquals(findElement(protCodeCheckbox, driver).getText(), protCodeCheckboxText, "Auth protect code text");		
		verify.assertEquals(findElement(loginBtn, driver).getText(), loginBtnText, "Login button text");
		verify.assertEquals(findElement(remindLogPasLink, driver).getText(), remindLogPasLinkText, "Remind login or password text");		
		verify.assertEquals(findElement(registerBtn, driver).getText(), registerBtnText, "Register button text");
		verify.assertAll();
	}
	
	public void setProtCodeCheckbox () throws Exception {		
		Log.info("Auth screen: Set protect code checkbox");
		click(protCodeCheckbox);
	}
	
	public boolean isProtCodeCheckboxSelected () throws Exception {
		Log.info("Auth screen: Is protect code selected: " + findElement(protCodeCheckbox, driver).isSelected());
		return findElement(protCodeCheckbox, driver).isSelected();
	}
	
	public void loginBtnClick () throws Exception {		
		Log.info("Auth screen: Click login button");
		clickAndWaitSpinerToVanish(loginBtn);
	}
	
	public void remindLogPasBtnClick () throws Exception {
		Log.info("Auth screen: Click remind login and password link");
		clickAndWaitSpinerToVanish(remindLogPasLink);
	}
	
	public void registerBtnClick () throws Exception {		
		Log.info("Auth screen: Click 'Registration' button'");
		clickAndWaitSpinerToVanish(registerBtn);
	}	
	
	public void enterUsername (String username) throws Exception {
		waitFor(usernameTextField);
		Log.info("Auth screen: Enter Username: " + username);
		findElement(usernameTextField, driver).clear();
		findElement(usernameTextField, driver).sendKeys(username);
	}
	
	public String getUsername () throws Exception {
		Log.info("Auth screen: get username");
		return findElement(usernameTextField, driver).getText();		
	}
	
	public void enterPassword (String password) throws Exception {
		waitFor(passwordTextField);
		Log.info("Auth screen: Enter password: " + password);
		findElement(passwordTextField, driver).clear();
		findElement(passwordTextField, driver).sendKeys(password);
	}
}
