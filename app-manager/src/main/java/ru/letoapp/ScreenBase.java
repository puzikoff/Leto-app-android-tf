package ru.letoapp;

import java.io.IOException;
import java.util.List;
import ru.letoapp.utilities.RetryStrategy;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.thoughtworks.selenium.Wait.WaitTimedOutException;

@SuppressWarnings("deprecation")
public class ScreenBase {
	public static final Logger Log = Logger.getLogger("App logger");
	private static final long DELAY_AFTER_ACTIVE_ACTION = 700;
	protected final int waitTimeout = 6000;
	protected SoftAssert verify = new SoftAssert();
	protected WebDriver driver;	  
	By drawerLoc = By.xpath("//FrameLayout[@id='mdc__layout_drawer_menu']//ScrollView");	
	By popupNextBtn = By.xpath("//Button[@id='sdl__positive_button']");
	By errorPopupTitleLocator = By.xpath("//TextView[@id='sdl__title']");
	By errorPopupMessageLocator = By.xpath("//TextView[@id='sdl__message']");
	String errorPopuptitleText = "Ошибка…";
	String errorPopuptitleText2 = "Ошибка";
	public By waitPopup = By.id("sdl__message");	
	String waitPopupText = "Пожалуйста, подождите…";

	    public ScreenBase(WebDriver driver) {
	        this.driver = driver;	     	       
	    }

	    public void setDriver(WebDriver driver) {
	        this.driver = driver;
	    }

	    public WebDriver getDriver() {
	        return driver;
	    }    
	    
	    public void delay() {
	        try {
	            Thread.sleep(DELAY_AFTER_ACTIVE_ACTION);
	        } catch (InterruptedException e) {}
	    }
	    
	    public void delay(long time) {
	        try {
	            Thread.sleep(time);
	        } catch (InterruptedException e) {Log.error("Delay error: " + e); }
	    }

	    
	    public void waitFor(String xpath) {
			WebDriverWait waitVar =  new WebDriverWait(driver, 60);
			By x = By.xpath(xpath);
			waitVar.until(ExpectedConditions.presenceOfElementLocated(x));			
		}
		
		public void waitFor(By locator) {			
			WebDriverWait waitVar =  new WebDriverWait(driver, 60);			
			waitVar.until(ExpectedConditions.presenceOfElementLocated(locator));			
		}
		
		public void waitForClickable(String xpath) {
			WebDriverWait waitVar =  new WebDriverWait(driver, 60);
			By x = By.xpath(xpath);
			waitVar.until(ExpectedConditions.elementToBeClickable(x));		
		}
		
		public void waitForClickable(By locator) {
			WebDriverWait waitVar =  new WebDriverWait(driver, 60);			
			waitVar.until(ExpectedConditions.elementToBeClickable(locator));		
		}
		
		public void systemBackBtnClick() {			
			 try {			
				 Runtime.getRuntime().exec("cmd /C adb shell input keyevent 4");
			 }
			 catch(IOException e) {
				 Log.info("IOExeption" + e);
			}
		}
		
		public void waitForDisappear(final By by) {	        
	        try {
	            Wait<WebDriver> wait = new WebDriverWait(getDriver(), waitTimeout, 100);	            
	            wait.until(new ExpectedCondition<String>() {
	                public String apply(WebDriver driver) {	                	
	                    try {
	                    	WebElement element = findElement(by, driver);
	                    	if (null == element) {
	                    		Log.info("[waitForDisappear] Element vanished");
	                    		return "not_present";
	                    	} else if (!element.isDisplayed()) {
	                    		Log.info("[waitForDisappear] Element vanished");
	                    		return "not_displayed";	                    
	                    	} else {
	                    		return null;
	                    	}
	                    	} catch (StaleElementReferenceException ex) {
	                    		Log.info(by.toString() + "[waitForDisappear] Element not attached to DOM, try again");	                        
	                    		return "not_attached_to_dom";
	                    	} catch (Exception e) {								
								e.printStackTrace();
								return null;
							}     
	                }	                
	            });
	        } catch (WaitTimedOutException e) {
	            Log.info(by.toString() + " : element is still present: ");
	            throw e;
	        }
	    }
	
		public void waitForVanishWaitPopup() {	
			final RetryStrategy retry = new RetryStrategy();
			 try {
		            Wait<WebDriver> wait = new WebDriverWait(getDriver(), waitTimeout, 60);	            
		            wait.until(new ExpectedCondition<String>() {
		                public String apply(WebDriver driver) {	    
		                	while(retry.shouldRetry()) {
		                		try {
		                			WebElement element = driver.findElement(waitPopup);
		                			if (null == element) {
		                    			Log.info("Wait popup vanished");
		                    			return "not_present";
		                			} else if (!element.isDisplayed()) {
		                				Log.info("Wait popup vanished");
		                				return "not_displayed";
		                			} else if (!element.getText().equals(waitPopupText)) {
		                				Log.info("Wait popup vanished : Became another element");
		                				return "not_displayed"; 
		                			} else {
		                				return null;
		                			}
		                    	} catch (StaleElementReferenceException e) {
		                    			Log.info("Wait popup is not attached to DOM, try again: ");	                        
		                    			try {
											retry.errorOccured(e);
										} catch (Exception e1) {											
											e1.printStackTrace();
										}
		                    	} catch (Exception e) {
		                    			Log.info("Exception e");
		                    			return "not_display";
		                    	}		                		
		                	}
							return "no more attempts";
		                }
		            });
		        } catch (WaitTimedOutException e) {
		            Log.info(waitPopup.toString() + "Timeout: Wait popup is still present");
		            throw e;
		   }			 
		}
		
		public boolean isWaitPopupDisplayed() throws Exception {
			RetryStrategy retry = new RetryStrategy();
			if(findElement(waitPopup, driver) != null) {
			while(retry.shouldRetry()) {				
				try {
							if(driver.findElement(waitPopup) == null) {
								Log.info("Wait popup is not displayed");
								return false;
							}
							if(driver.findElement(waitPopup).getText().equals(waitPopupText))
							{
								Log.info("Wait popup displayed");
								return true; 
							} 		
							else {
								Log.info("Wait popup is not displayed");
								return false;
							}		
					}
					catch (NullPointerException e) {
						Log.info("Wait popup is not displayed: " + e);
						return false;
					}
					catch (StaleElementReferenceException e) {
						Log.warn("Wait popup Got into StaleElement exception  ");
			            retry.errorOccured(e);
					}
					catch (NoSuchElementException e) {
						Log.info("Wait popup is not displayed: " + e);
						return false;
					}
				}
			}			
			Log.info("Wait popup is not displayed");
			return false;				
		}
		
		 public By getBy(String locator) {
	        if (locator.matches("^id=[\\d\\D]+"))
	            return By.id(locator.replaceAll("id=", ""));
	        else if (locator.matches("^xpath=[\\d\\D]+"))
	            return By.xpath(locator.replaceAll("xpath=", ""));
	        else if (locator.matches("^iexpath=[\\d\\D]+"))
	            return By.xpath(locator.replaceAll("iexpath=", ""));
	        else if (locator.contains("//"))
	            return By.xpath(locator);
	        else
	            return By.id(locator);
	    }
		
		 protected WebElement findElement(By by, WebDriver driver) throws Exception {
			 RetryStrategy retry = new RetryStrategy();
			 while(retry.shouldRetry()) {
				 try {
					 List<WebElement> elements = driver.findElements(by);
					 if (elements.size() > 0) {
						 return elements.get(0);
					 } else {
						 Log.error("No element found: " + by.toString());		        	
						 return null;
					 }
				 }
				 catch(InvalidElementStateException e) {
					 Log.error("No element found 'InvalidElementStateException'");				 
					 return null;
				 }			 
				 catch(NullPointerException e) {
					 Log.error("No element found 'NullPointerException'");				 
					 return null;
				 }
				 catch(StaleElementReferenceException e){
					 Log.warn("Got into StaleElement exception  " + by.toString());
		             retry.errorOccured(e);
				 }
			 } 
			 return null;
		 }
		 
		 public void click(By elementToClick) throws Exception {
			 if(findElement(elementToClick, driver).isDisplayed()) {
				 Log.info("Click on element" + elementToClick.toString());
				 findElement(elementToClick, driver).click();
				 delay();
			 }
			 else{
				 Log.error("No element " + elementToClick.toString() + " on the screen");
				 Assert.fail("No element " + elementToClick.toString() + " on the screen");
			 }
		 }
		 
		 public void clickAndWaitSpinerToVanish(By elementToClick) throws Exception {
			 if(findElement(elementToClick, driver).isDisplayed()) {
				 Log.info("Click on element" + elementToClick.toString());
				 findElement(elementToClick, driver).click();
				 delay();
				 Log.info("Wait for waiting spiner dissapear");
				 if(isWaitPopupDisplayed()) {
					 waitForVanishWaitPopup();
				 }
			 }
		 }
		
}
