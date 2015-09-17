package ru.letoapp.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotMaker {
	public static void takeScreenshot(WebDriver driver)
    {       
       File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       try {
    	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    	   String date = format.format(new Date());
           FileUtils.copyFile(scrFile, new File("Screenshots" + File.separator +  "screenshot-" +  date +".png"));
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
