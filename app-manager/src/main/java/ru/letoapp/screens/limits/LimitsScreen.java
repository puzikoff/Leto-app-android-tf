package ru.letoapp.screens.limits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;

public class LimitsScreen extends AppScreenBase{
	By saveLimitsBtn = By.xpath("//Button[@id='button_save_limits']");
	String mainLimitGroupName = "ВСЕ РАСХОДНЫЕ ОПЕРАЦИИ";
	String limitName = "Месячный лимит";
	
	public LimitsScreen(WebDriver driver) {
		super(driver);
	}
	
	public void turnSwitch(String groupName) throws Exception {
		Log.info("Limits screen: turn switch " + groupName);
		click(By.xpath("//TextView[@value='" + groupName + "']/following-sibling::Switch"));
	}
	
	public void editLimit(String groupName, String limitName, String limitValue) throws Exception {
		Log.info("Limits screen: To limit: " + limitName + " from group " + groupName + " set limit " + limitValue);
		findElement(By.xpath("//TextView[@value='" + groupName +"']" +
				"/../../LinearLayout[@id='layout_active_limits']" +
				"//TextView[@value='" + limitName +"']/following-sibling::LinearLayout//EditText"), driver).clear();
		findElement(By.xpath("//TextView[@value='" + groupName +"']" +
				"/../../LinearLayout[@id='layout_active_limits']" +
				"//TextView[@value='" + limitName +"']/following-sibling::LinearLayout//EditText"), driver).sendKeys(limitValue);	
	}
	
	public void openLimit(String groupName, String limitName) throws Exception {
		Log.info("Limits screen: Open limit: " + limitName + " from group " + groupName);
		click(By.xpath("//TextView[@value='" + groupName +"']" +
				"/../../LinearLayout[@id='layout_active_limits']" +
				"//TextView[@value='" + limitName +"']/following-sibling::LinearLayout//DonutView"));		
	}
	
	public void deleteLimit(String groupName, String limitName) throws Exception {
		Log.info("Limits screen: Delete limit: " + limitName + " from group " + groupName);
		click(By.xpath("//TextView[@value='" + groupName +"']" +
				"/../../LinearLayout[@id='layout_active_limits']" +
				"//TextView[@value='" + limitName +"']/following-sibling::LinearLayout//ImageButton"));		
	}
	
	public void editLimit(String limitValue) throws Exception {
		Log.info("Limits screen: To limit: " + limitName + " from group " + mainLimitGroupName + " set limit " + limitValue);
		findElement(By.xpath("//TextView[@value='" + mainLimitGroupName +"']" +
				"/../../LinearLayout[@id='layout_active_limits']" +
				"//TextView[@value='" + limitName +"']/following-sibling::LinearLayout//EditText"), driver).clear();
		findElement(By.xpath("//TextView[@value='" + mainLimitGroupName +"']" +
				"/../../LinearLayout[@id='layout_active_limits']" +
				"//TextView[@value='" + limitName +"']/following-sibling::LinearLayout//EditText"), driver).sendKeys(limitValue);
	
	}
	
	public void openLimit() throws Exception {
		Log.info("Limits screen: Open limit: " + limitName + " from group " + mainLimitGroupName);
		click(By.xpath("//TextView[@value='" + mainLimitGroupName +"']" +
				"/../../LinearLayout[@id='layout_active_limits']" +
				"//TextView[@value='" + limitName +"']/following-sibling::LinearLayout//DonutView"));		
	}
	
	public void deleteLimit() throws Exception {
		Log.info("Limits screen: Delete limit: " + limitName + " from group " + mainLimitGroupName);
		click(By.xpath("//TextView[@value='" + mainLimitGroupName +"']" +
				"/../../LinearLayout[@id='layout_active_limits']" +
				"//TextView[@value='" + limitName +"']/following-sibling::LinearLayout//ImageButton"));		
	}	
	
}
