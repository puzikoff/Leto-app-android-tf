package ru.letoapp.screens.popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TemplateContextMenu extends PopupBase{
	By payBtn = By.xpath("//TextView[@value='Оплатить…']");
	By renameBtn = By.xpath("//TextView[@value='Переименовать…']");
	By deleteBtn = By.xpath("//TextView[@value='Удалить']");

	public TemplateContextMenu(WebDriver driver) {
		super(driver);
	}
	
	public void payBtnClick() {
		Log.info("Template context menu: pay btn click");
		clickAndWaitSpinerToVanish(payBtn);		
	}
	
	public void renameBtnClick() {
		Log.info("Template context menu: rename btn click");
		click(renameBtn);		
	}
	
	public void deleteBtnClick() {
		Log.info("Template context menu: delete btn click");
		click(deleteBtn);		
	}

}
