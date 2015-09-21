package ru.letoapp.screens;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import ru.letoapp.AppScreenBase;

public class DepositsListScreen extends AppScreenBase{
	String title = "Сбережения и накопления";
	By updateSpiner = By.xpath("//ProgressBar");

	public DepositsListScreen(WebDriver driver) {
		super(driver);
	}
	
	public void verify() {
		verify.assertEquals(getActionBarTitle(), title, "Deposits list screen: title");
	}

	public void waitForVanishUpdateSpiner() {
		waitForVanish(updateSpiner);		
	}
	
	public void openDeposit(String depositName) {
		Log.info("Deposits list: Open deposit: " + depositName);						
		List <WebElement> deposits = driver.findElements(By.xpath("//TextView[@value='" + depositName + "']"));
		if(!deposits.isEmpty()) {				
			deposits.get(0).click();		
			delay();		
		}
		else {
			Log.error("Deposits list: No deposit with such name");
			Assert.fail("Deposits list: No deposit with such name");
		}
	}

}
