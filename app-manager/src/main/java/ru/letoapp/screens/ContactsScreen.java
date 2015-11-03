package ru.letoapp.screens;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ru.letoapp.AppScreenBase;
import ru.letoapp.screens.popups.PhoneCallPopup;

public class ContactsScreen extends AppScreenBase{
	
	PhoneCallPopup phoneCallPopup;
	
	By stillToRepayTheLoan = By.xpath("//TextView[@id='label_caption']");
	String stillToRepayTheLoanText = "Где ещё погасить кредит?";
	By addressesOnMap = By.xpath("//TextView[@id='label_captionlabel_action_addresses_on_map']");
	String addressesOnMapText = "Адреса на карте";
	By phoneCallBtn = By.xpath("//TextView[@id='label_phone_number']");
	String phoneCallText = "ПОЗВОНИТЬ В ЛЕТО БАНК";
	String phoneCallNumber = "+7 800 550 0770";
	By phoneCallTip = By.xpath("//NoSaveStateFrameLayout/LinearLayout/TextView[2]");
	String phoneCallTipText = "Клиентская служба ответит на ваши вопросы\nс 8:00 до 22:00 по московскому времени.\nЗвонок по России бесплатный";
	By foreignPhoneCallBtn = By.xpath("//TextView[@id='label_foreign_phone_number']");
	String foreignPhoneCallText = "+7 495 532 1300";
	By writeToBank = By.xpath("//LinearLayout[@id='layout_section_write_to_us']");
	String writeToBankText = "Написать в Лето Банк";
	By bankSite = By.xpath("//LinearLayout[@id='layout_section_web']");
	String bankSiteText = "Сайт банка";
	
	public ContactsScreen(WebDriver driver) {
		super(driver);		
		phoneCallPopup = PageFactory.initElements(driver, PhoneCallPopup.class);
		phoneCallPopup.setDriver(driver);
	}
	
	public PhoneCallPopup getPhoneCallPopup() {
		return phoneCallPopup;
	}
	
	public void stillToRepayTheLoanClick () throws Exception {		
		Log.info("Contacts screen: Where still to repay the loan");
		click(stillToRepayTheLoan);
	}
	
	public void phoneCallClick () throws Exception {		
		Log.info("Contacts screen: Phone call click");
		click(phoneCallBtn);
	}
	
	public void foreignPhoneCallClick () throws Exception {		
		Log.info("Contacts screen: Foreign Phone call click");
		click(foreignPhoneCallBtn);
	}
	
	public void writeToBankClick () throws Exception {		
		Log.info("Contacts screen: Write to bank click");
		click(writeToBank);
	}
	
	public void bankSiteClick () throws Exception {		
		Log.info("Contacts screen: Write to bank click");
		click(bankSite);
	}

}
