package ru.letoapp.screens.payments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;

public class PaymentToolChoiceScreen extends AppScreenBase{
	
	String titleText = "Оплатить с ......";
	By title = By.xpath("//TextView[@id='sdl__title']");
	By cancelBtn = By.xpath("//Button[@id='sdl__positive_button']");
		
	public PaymentToolChoiceScreen(WebDriver driver) {
		super(driver);
	}
	
	public void verify() throws Exception {
		verify.assertEquals(findElement(title, driver).getText(), titleText, "Payment tool choice screen: Title");
		verify.assertAll();
	}
	
	public void cancelBtnClick() throws Exception {
		Log.info("Payment tool choice screen: cancel button click");
		click(cancelBtn);
	}
	
}
