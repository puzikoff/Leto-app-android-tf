package ru.letoapp.screens.limits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;

public class SpecificLimitScreen extends AppScreenBase{
	By limitTitle = By.xpath("//TextView[@id='text_title']");
	By limitAmount = By.xpath("//TextView[@id='text_amount']");
	By limitDiagramm = By.xpath("//DonutView[@id='widget_donut']");
	By restoreBigBtn = By.xpath("//LinearLayout[@id='layout_restore_container']");
	By restoreBtn = By.xpath("//Button[@id='button_restore']");
	By closeBtn = By.xpath("//Button[@id='button_close']");	
	By usedAmount = By.xpath("//TextView[@value='Использовано']/preceding-sibling::TextView");
	By availableAmount = By.xpath("//TextView[@value='Доступно']/preceding-sibling::TextView");
	By restoreAmount = By.xpath("//TextView[contains(@value,'Восстановлено')]/preceding-sibling::TextView");

	public SpecificLimitScreen(WebDriver driver) {
		super(driver);
	}
	
	public String getLimitTitle() throws Exception {
		Log.info("Specific limit screen, Limit title: " + findElement(limitTitle, driver).getText());
		return findElement(limitTitle, driver).getText();
	}
	
	public String getLimitAmount() throws Exception {
		Log.info("Specific limit screen, Limit Amount: " + findElement(limitAmount, driver).getText());
		return findElement(limitAmount, driver).getText();
	}
	
	public void restoreBigBtnClick() throws Exception {
		Log.info("Specific limit screen, restore big button click");
		click(restoreBigBtn);
	}
	
	public void restoreBtnClick() throws Exception {
		Log.info("Specific limit screen, restore  button click");
		click(restoreBtn);
	}
	
	public void closeBtnClick() throws Exception {
		Log.info("Specific limit screen, close  button click");
		click(closeBtn);
	}
	
	public String getUsedAmount() throws Exception{
		Log.info("Specific limit screen, Used Amount: " + findElement(usedAmount, driver).getText());
		return findElement(usedAmount, driver).getText();	
	}
	
	public String getAvailableAmount() throws Exception{
		Log.info("Specific limit screen, Available Amount: " + findElement(availableAmount, driver).getText());
		return findElement(availableAmount, driver).getText();	
	}
	
	public String getRestoreAmount() throws Exception{
		Log.info("Specific limit screen, restore Amount: " + findElement(restoreAmount, driver).getText());
		return findElement(restoreAmount, driver).getText();	
	}

}
