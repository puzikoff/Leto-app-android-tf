package ru.letoapp;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.letoapp.screens.ActionBar;
import ru.letoapp.screens.Drawer;
import ru.letoapp.screens.popups.ErrorPopup;
import ru.letoapp.utilities.RetryStrategy;
import ru.letoapp.utilities.ScreenshotMaker;

import com.thoughtworks.selenium.Wait.WaitTimedOutException;

@SuppressWarnings("deprecation")
public class AppScreenBase extends ScreenBase {
	public static final Logger Log = Logger.getLogger(AppScreenBase.class);	
	private ActionBar actionBar;
	private Drawer drawer;
	private ErrorPopup errorPopup;

	public AppScreenBase(WebDriver driver) {
		super(driver);
		actionBar = PageFactory.initElements(driver, ActionBar.class);
		drawer = PageFactory.initElements(driver, Drawer.class);
		errorPopup = PageFactory.initElements(driver, ErrorPopup.class);		
		actionBar.setDriver(driver);		
		drawer.setDriver(driver);
		errorPopup.setDriver(driver);
	}		
	
/* ---- Action Bar methods -----*/		
	public String getTitleFromActionBar() throws Exception {
		return actionBar.getActionBarTitle();
	}
	
	public void navUpBtnClick() throws Exception {		
		actionBar.navUpBtnClick();
	}
	
	public void menuBtnClick() throws Exception {
		actionBar.menuBtnClick();
	}
	
	public void openDrawer() throws Exception {
		actionBar.menuBtnClick();
	}
	
	public void closeDrawer() throws Exception {
		actionBar.menuBtnClick();
	}
	
	public void contactsBtnClick() throws Exception {
		actionBar.contactsBtnClick();
	}	

	public String getActionBarTitle() throws Exception {
		return actionBar.getActionBarTitle();
	}
	
/* ---- Action Bar methods Ends-----*/
	
/* ---- Drawer methods -----*/
	public Drawer getDrawer(){
		return drawer;
	}
	
/* ---- Drawer methods ENDS-----*/

/* ---- popups methods-----*/
	
	public ErrorPopup getErrorPopup() {
		return errorPopup;
	}
	
	public boolean isElementPresent(By element) throws Exception {
		RetryStrategy retry = new RetryStrategy();
		 while(retry.shouldRetry()) {
			 try {
				 if(driver.findElement(element) != null) {
					 Log.info("Element: " + element.toString() + " exist");
					 return true;
				 }
				 else {
					 Log.info("There is no element: " + element.toString() + " on the screen");
					 return false;
				 }
			 }
			 catch(StaleElementReferenceException e){
				 Log.warn("Got into StaleElement exception  " + element.toString());
	             retry.errorOccured(e);
			 }
		 }
		return false;
	}
	
	public boolean isElementDisplayed(By element) throws Exception {
		if(findElement(element, driver).isDisplayed()) {
			Log.info("Element: " + element.toString() + " displayed");
			return true;
		}
		else {
			Log.info("Element: " + element.toString() + " is not displayed");
			return false;
		}
	}
	
	
	public boolean isErrorPopupDisplayed() throws Exception {	
			RetryStrategy retry = new RetryStrategy();
			if(findElement(errorPopupTitleLocator, driver) != null) {
				while(retry.shouldRetry()) {
					try {
							if(findElement(errorPopupTitleLocator, driver) == null) {
								Log.info("Error popup is not displayed");
								return false;
							}
							if((findElement(errorPopupTitleLocator, driver).getText().equals(errorPopuptitleText))||(findElement(errorPopupTitleLocator, driver).getText().equals(errorPopuptitleText2))) 
							{
								Log.error("Error popup displayed");			
								Log.error(findElement(errorPopupMessageLocator, driver).getText());				
								takeScreenshot("Error Popup");
								findElement(popupNextBtn, driver).click();
								return true; 
							}			
							else {
								Log.info("Error popup is not displayed");
								return false;
							}
						}
					catch(NullPointerException e) {
						Log.info("Error popup is not displayed: ");
						return false;
					}
					catch(StaleElementReferenceException e) {
						Log.info("Stale reference exception: Error popup is not displayed: ");
						retry.errorOccured(e);
					}
				}
			}			
			return false;		
	}
	
	/*
	public boolean isErrorPopupDisplayed() {
		int f = 0;		
		do {
			if(findElement(errorPopupTitleLocator, driver) != null) {
				try {
						if(findElement(errorPopupTitleLocator, driver) == null) {
							Log.info("Error popup is not displayed");
							return false;
						}
						if((findElement(errorPopupTitleLocator, driver).getText().equals(errorPopuptitleText))||(findElement(errorPopupTitleLocator, driver).getText().equals(errorPopuptitleText2))) 
						{
							Log.error("Error popup displayed");			
							Log.error(findElement(errorPopupMessageLocator, driver).getText());				
							takeScreenshot("Error Popup");
							findElement(popupNextBtn, driver).click();
							return true; 
						}			
						else {
							Log.info("Error popup is not displayed");
							return false;
						}
					}
				catch(NullPointerException e) {
					Log.info("Error popup is not displayed: ");
					return false;
				}
				catch(StaleElementReferenceException e) {
					Log.info("Stale reference exception: Error popup is not displayed: ");
					++f;					
				}
			}
			else{
				Log.info("Error popup is not displayed");
				return false;
			}
		}
		while(f < 2);
		return false;
	}
	*/

	
	public void waitForVanish(final By elementToVanish) {		
		 try {
	            Wait<WebDriver> wait = new WebDriverWait(getDriver(), waitTimeout, 60);	            
	            wait.until(new ExpectedCondition<String>() {
	                public String apply(WebDriver driver) {	                	
	                    try {
	                    		WebElement element = findElement(elementToVanish, driver);
	                    		if (null == element) {
	                    			Log.info(elementToVanish.toString() + " vanished");
	                    			return "not_present";
	                    		} else if (!element.isDisplayed()) {
	                    			Log.info(elementToVanish.toString() + "vanished");
	                    			return "not_displayed";	                    	 
	                    		} else {
	                    			return null;
	                    		}
	                    		} catch (StaleElementReferenceException ex) {
	                    			Log.info(elementToVanish.toString() + " StaleElementReferenceException: ");	                        
	                    			return "StaleElementReferenceException";
	                    		} catch (InvalidElementStateException exp) {
	                    			Log.info(elementToVanish.toString() + " InvalidElementStateException: ");
	                    			return "InvalidElementStateException";
	                    		} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									return "Exception e";
								}
	                		}	                
	            });
	        } catch (WaitTimedOutException e) {
	            Log.info("Timeout: " + elementToVanish.toString() + " is still present");
	            throw e;
	   }
	}
	
	public boolean isElementClickable(By element) {
		try
		{
		   WebDriverWait wait = new WebDriverWait(driver, 1);
		   wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));
		   Log.info("Element: " + element.toString() + " is clicklable");
		   return true;
		}
		catch (Exception e)
		{
			Log.info("Element: " + element.toString() + " is not clicklable");
			return false;
		}
	}
	
/* ---- Error popup methods ends -----*/

/* ------ Common methods --- */
	
	
	public String onlyNumbers(String s) {
		s = s.replaceAll("\\D+", "");	
		return s;
	}
	
	public void swipeOpenDrawer() {
		try {
			TouchActions flickAction = new TouchActions(driver).flick(findElement(drawerLoc, driver), -450, 0, 0);
			flickAction.perform();
		}
		catch (Exception e) {
			Log.info("Flick : Exception" + e);
		}
		
	}	
	
	public void scrollDown(){
		try {
			TouchActions scrollDown = new TouchActions(driver).scroll(0, +200);
			scrollDown.perform();			
		}
		catch (Exception e) {
			Log.info("Scroll : Exception" + e);
		}
	}
	
	public void scroll(int x, int y){
		try {
			TouchActions scrollAction = new TouchActions(driver).scroll(x, y);
			scrollAction.perform();			
		}
		catch (Exception e) {
			Log.info("Scroll : Exception" + e);
		}
	}
	
	public void flick(By element, int x, int y, int speed){
		try {
			TouchActions flickAction = new TouchActions(driver).flick(findElement(element, driver), x, y, speed);
			flickAction.perform();			
		}
		catch (Exception e) {
			Log.info("Flick : Exception" + e);
		}
	}
	
	/* ------ Common methods --- ENDS*/	
	
	public void takeScreenshot()
    {       
		Log.info("Taking screenshot");
		ScreenshotMaker.takeScreenshot(driver);
    }
	
	public void takeScreenshot(String name)
    {       
		Log.info("Taking screenshot");
		ScreenshotMaker.takeScreenshot(name, driver);
    }

}
