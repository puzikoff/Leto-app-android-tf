package letoapp.sreens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import letoapp.AppScreenBase;

public class WhatIfScreen extends AppScreenBase{

	public WhatIfScreen(WebDriver driver) {
		super(driver);
	}
	
	String titleText = "Что, если?..";

	
	/*-- Loan widgets --*/
	By payMoreWidget = By.xpath("//CollapsibleActionView_[@id='widget_what_if_pay_more']//ImageView[@id='image_static_block_indicator']");
	By payMoreWidgetText = By.xpath("//CollapsibleActionView_[@id='widget_what_if_pay_more']//TextView[@id='label_description']");
	String payMoreText = "В текущем периоде подключена услуга «Досрочное погашение», поэтому мы уменьшим размер ежемесячного платежа в последующих месяцах, если вы внесете средства сверх сумммы очередного платежа.";
	String payMoreText2 = "Все средства, внесенные сверх суммы платежа в этом месяце, будут использованы для погашения следующих платежей. Если вы подключите услугу «Досрочное погашение» и внесете сумму сверх суммы платежа, мы уменьшим размер ежемесячного платежа в последующих месяцах.";
	By payMore = By.xpath("//CollapsibleActionView_[@id='widget_what_if_pay_more']//TextView[@id='label_pressable_caption']");
	
	By payLessWidget = By.xpath("//CollapsibleActionView_[@id='widget_what_if_pay_less']//ImageView[@id='image_static_block_indicator']");
	By payLessWidgetText = By.xpath("//CollapsibleActionView_[@id='widget_what_if_pay_less']//TextView[@id='label_description']");
	String payLessText = "Вам нужно будет доплатить оставшуюся часть очередного платежа до наступления его даты.";
	
	By payAllWidget = By.xpath("//CollapsibleActionView_[@id='widget_what_if_pay_all']//ImageView[@id='image_static_block_indicator']");
	By payAllWidgetText = By.xpath("//CollapsibleActionView_[@id='widget_what_if_pay_all']//TextView[@id='label_description']");
	String payAllText = "Вы можете рассчитать сумму, которую потребуется внести, чтобы полностью погасить кредит до его планового закрытия.";
	String payAllText2= "";
	By payAll = By.xpath("//CollapsibleActionView_[@id='widget_what_if_pay_all']//TextView[@id='label_pressable_caption']");
	
	By insuranceCaseWidget = By.xpath("//CollapsibleContactBankActionView_[@id='widget_what_if_insurance_case']//TextView[@id='label_pressable_caption']");
	By insuranceCaseWidgetText = By.xpath("//CollapsibleContactBankActionView_[@id='widget_what_if_insurance_case']//TextView[@id='label_description']");
	String insuranceCaseText = "Позвоните в службу поддержки или приходите в офис Лето Банка";
	
	By skipPaymentWidget = By.xpath("//CollapsibleMultiActionView_[@id='widget_what_if_pass_case_alt']//ImageView[@id='image_static_block_indicator']");
	By skipPaymentWidgetText = By.xpath("//CollapsibleMultiActionView_[@id='widget_what_if_pass_case_alt']//TextView[@id='label_description']");
	String skipPaymentText = "У меня нет возможности оплатить следующий платёж, можно ли его пропустить?";
	By skipPayment = By.xpath("//CollapsibleMultiActionView_[@id='widget_what_if_pass_case_alt']//TextView[@id='label_pressable_caption']");
	
	By reducePaymentWidget = By.xpath("//CollapsibleMultiActionView_[@id='widget_what_if_decrease_case_alt']//ImageView[@id='image_static_block_indicator']");
	By reducePaymentWidgetText = By.xpath("//CollapsibleMultiActionView_[@id='widget_what_if_decrease_case_alt']//TextView[@id='label_description']");
	String reducePaymentText = "Мне трудно оплачивать кредит, можно ли уменьшить сумму ежемесячного платежа?";
	By reducePayment = By.xpath("//CollapsibleMultiActionView_[@id='widget_what_if_decrease_case_alt']//TextView[@id='label_pressable_caption'][@value='Что будет, если уменьшить платёж?']");
	
	By turnOffInsurance = By.xpath("//TextView[@id='Что, если я отключу страховую защиту?']");
	
	By changePayDateWidget = By.xpath("//CollapsibleMultiActionView_[@id='widget_what_if_change_date_case_alt']//ImageView[@id='image_static_block_indicator']");	
	By changePayDateWidgetText = By.xpath("//CollapsibleMultiActionView_[@id='widget_what_if_change_date_case_alt']//TextView[@id='label_description']");
	String changePayDateText = "Я попал в больницу или нахожусь в отпуске и мне неудобно платить в текущую дату. Можно ли перенести дату платежа?";	
	By changePayDate = By.xpath("//CollapsibleMultiActionView_[@id='widget_what_if_change_date_case_alt']//TextView[@id='label_pressable_caption']");
	
	/* - Card widgets */
	By whatIfCardLostWidget = By.id("widget_what_if_card_lost");
	By whatIfCardLostWidgetText = By.xpath("//CollapsibleContactBankActionView_[@id='widget_what_if_card_lost']//TextView[@id='label_description']");
	String whatIfCardLostText = "Установите запрет на снятие денежных средств и позвоните в клиентскую службу для блокировки карты. Специалисты банка проконсультируют по дальнейшим действиям.";
	
	By whatIfCardBrokenWidget = By.id("widget_what_if_card_broken");
	By whatIfCardBrokenWidgetText = By.xpath("//CollapsibleContactBankActionView_[@id='widget_what_if_card_broken']//TextView[@id='label_description']");
	String whatIfCardBrokenText = "Позвоните в клиентскую службу, специалисты банка проконсультируют по дальнейшим действиям.";
	
	By whatIfCardAbroadWidget = By.id("widget_what_if_abroad");
	By whatIfCardAbroadWidgetText = By.xpath("//CollapsibleActionView_[@id='widget_what_if_abroad']//TextView[@id='label_description']");
	String whatIfCardAbroadText = "Используя эту карту при оплате в других валютах, вы ничего не теряете.\n\nКурс конвертации банка будет равен курсу ЦБ РФ на дату совершения операции по ежедневно котируемым ЦБ РФ валютам (34 основные валюты).\n\nПо остальным валютам – конвертация будет происходить по курсам международной платежной системы через доллар США (далее конвертация доллар США – рубли будет также по курсу Банка России)";
	
	By whatIfNoAdditionWidget = By.id("widget_what_if_no_addition");
	By whatIfNoAdditionWidgetText = By.xpath("//CollapsibleActionView_[@id='widget_what_if_no_addition']//TextView[@id='label_description']");
	String whatIfNoAdditionText = "Принятые к зачислению деньги станут доступны для использования не позже следующего календарного дня за исключением суммы, которая пойдет на погашение ранее начисленных комиссий и процентов по кредиту. Если подключена услуга «SMS-информирование», то вы получите сообщение о том, что деньги зачислены.";
	
	By whatIfForgotPINWidget = By.xpath("//TextView[@value='Утерян/забыт ПИН-код']/../../../..");
	By whatIfForgotPINWidgetText = By.xpath("//TextView[@value='Утерян/забыт ПИН-код']/../../../..//TextView[@id='label_description']");
	
	String whatIfForgotPINText = "Для восстановления забытого/ утерянного ПИН-кода необходимо обратиться в клиентский центр, на стойку продаж или позвонить в клиентскую службу. При обращении в клиентскую службу, необходимо знать код доступа.";
	By whatIfCardNotReturnedWidget = By.xpath("//TextView[@value='Банкомат не вернул карту']/../../../..");
	By whatIfCardNotReturnedWidgetText = By.xpath("//TextView[@value='Банкомат не вернул карту']/../../../..//TextView[@id='label_description']");
	String whatIfCardNotReturnedText = "Установите запрет на снятие денежных средств и обратитесь в банк, чтобы заблокировать карту. Заблокировать карту можно при обращении в клиентский центр, на стойку продаж или по звонку в клиентскую службу.\n\nДалее необходимо произвести перевыпуск карты, обратившись в клиентский центр или на стойку продаж, при себе необходимо иметь паспорт.";
		
	public void verifyCardWhatIfScreen() {
		verify.assertEquals(getTitleFromActionBar(), titleText, "Title");
		verify.assertEquals(findElement(whatIfCardLostWidgetText, driver).getText(), whatIfCardLostText, "What if screen: what if card lost text");
		verify.assertEquals(findElement(whatIfCardBrokenWidgetText, driver).getText(), whatIfCardBrokenText, "What if screen: what if card broken text");		
		verify.assertEquals(findElement(whatIfCardAbroadWidgetText, driver).getText(), whatIfCardAbroadText, "What if screen: what if card abroad text");
		verify.assertEquals(findElement(whatIfNoAdditionWidgetText, driver).getText(), whatIfNoAdditionText, "What if screen: what if no card addition text");
		verify.assertEquals(findElement(whatIfForgotPINWidgetText, driver).getText(), whatIfForgotPINText, "What if screen: what if forgot PIN text");
		verify.assertEquals(findElement(whatIfCardNotReturnedWidgetText, driver).getText(), whatIfCardNotReturnedText, "What if screen: what if card not returned text");
		verify.assertAll();		
	}
	
	public void verifyLoanWhatIfScreen() {
		verify.assertEquals(getTitleFromActionBar(), titleText, "Title");
		verify.assertTrue((findElement(payMoreWidget, driver).isDisplayed()), "What if screen: pay more widget");						
		verify.assertTrue(findElement(payLessWidgetText, driver).getText().contains(payLessText), "What if screen: pay less text");		
		verify.assertTrue(findElement(payAllWidgetText, driver).getText().contains(payAllText), "What if screen: pay all text");		
		verify.assertEquals(findElement(insuranceCaseWidgetText, driver).getText(), insuranceCaseText, "What if screen: insurance case text");		
		verify.assertEquals(findElement(skipPaymentWidgetText, driver).getText(), skipPaymentText, "What if screen: dismiss payment  text");		
		verify.assertEquals(findElement(reducePaymentWidgetText, driver).getText(), reducePaymentText, "What if screen: decrease payment text");		
		verify.assertEquals(findElement(changePayDateWidgetText, driver).getText(), changePayDateText, "What if screen: change pay date text");
		verify.assertAll();		
	}
	
	/* ------ Card widgets ------------*/
	
	public void whatIfCardLostWidgetClick(){
		Log.info("What if screen: what if card lost widget click");
		findElement(whatIfCardLostWidget, driver).click();
	}
	
	public void whatIfCardBrokenWidgetClick(){
		Log.info("What if screen: what if card broken widget click");
		findElement(whatIfCardBrokenWidget, driver).click();
	}
	
	public void whatIfCardAbroadWidgetClick(){
		Log.info("What if screen: what if card abroad widget click");
		findElement(whatIfCardAbroadWidget, driver).click();
	}
	
	public void whatIfNoAdditionWidgetClick(){
		Log.info("What if screen: what if no addition widget click");
		findElement(whatIfNoAdditionWidget, driver).click();
	}
	
	public void whatIfForgotPINWidgetClick(){
		Log.info("What if screen: what if forgot PIN widget click");
		findElement(whatIfForgotPINWidget, driver).click();
	}
	
	public void whatIfCardNotReturnedWidgetClick(){
		Log.info("What if screen: what if card not returned widget click");
		findElement(whatIfCardNotReturnedWidget, driver).click();
	}
		
	/* ------ Loan widgets ------------*/
	
	public void payLessWidgetClick(){
		Log.info("What if screen: Pay less widget click");
		findElement(payLessWidget, driver).click();
	}
			
	public void insuranceCaseWidgetClick(){
		Log.info("What if screen: Insurance case widget click");
		findElement(insuranceCaseWidget, driver).click();
	}
	
	public void dismissPaymentWidgetClick(){
		Log.info("What if screen: Dismiss payment widget click");
		findElement(skipPaymentWidget, driver).click();
	}
	
	public void decreasePaymentWidgetClick(){
		Log.info("What if screen: Decrease payment widget click");
		findElement(reducePaymentWidget, driver).click();
	}
		
	public void payAllClick() {
		Log.info("What if screen: Pay all widget click");
		findElement(payAllWidget, driver).click();
		if(findElement(payAll, driver) != null) {			
			Log.info("What if screen: Pay all click");
			findElement(payAll, driver).click();
			delay();		
			if(isWaitPopupDisplayed()) {
				waitForVanishWaitPopup();
			}
		}
		else {
			Log.info("What if screen: Full repayment connected");
			Assert.fail("What if screen: Full repayment connected");
		}
	}
	
	public void payMoreClick() {
		Log.info("What if screen: Pay more widget click");
		findElement(payMoreWidget, driver).click();
		if(findElement(payMore, driver) != null) {
			Log.info("What if screen: Pay more click");
			findElement(payMore, driver).click();
			delay();	
			if(isWaitPopupDisplayed()) {
				waitForVanishWaitPopup();
			}
		}
		else {
			Log.info("What if screen: Part repayment connected");
			Assert.fail("What if screen: Part repayment connected");
		}
	}
	
	public void skipPaymentClick() {
		Log.info("What if screen: Skip payment widget click");
		findElement(skipPaymentWidget, driver).click();
		if(findElement(skipPayment, driver) != null) {
			Log.info("What if screen: Dismiss payment click");
			findElement(skipPayment, driver).click();
			delay();	
			if(isWaitPopupDisplayed()) {
				waitForVanishWaitPopup();
			}
		}
		else {
			Log.info("What if screen: Dismiss payment payment connected or unavailable");
			Assert.fail("What if screen: Dismiss payment connected or unavailable");
		}
	}
	
	public void changePayDateClick() {
		Log.info("What if screen: Change pay date widget click");
		findElement(changePayDateWidget, driver).click();
		if(findElement(changePayDate, driver) != null) {
			Log.info("What if screen: changePayDate click");
			findElement(changePayDate, driver).click();
			delay();	
			if(isWaitPopupDisplayed()) {
				waitForVanishWaitPopup();
			}
		}
		else {
			Log.info("What if screen: Change payment date connected");
			Assert.fail("What if screen: Change payment date connected");
		}
	}
	
	public void reducePaymentClick() {
		Log.info("What if screen: reduce payment widget click");
		findElement(reducePaymentWidget, driver).click();
		if(findElement(reducePayment, driver) != null) {
			Log.info("What if screen: Reduce payment click");
			findElement(reducePayment, driver).click();
			delay();	
			if(isWaitPopupDisplayed()) {
				waitForVanishWaitPopup();
			}
		}
		else {
			Log.info("What if screen: Reduce payment connected or unavailable");
			Assert.fail("What if screen: Reduce payment connected or unavailable");
		}
	}

	public void payMoreWidgetClick() {
		Log.info("What if screen: Pay more widget click");
		findElement(payMoreWidget, driver).click();	
	}
	
	public void payAllWidgetClick() {
		Log.info("What if screen: Pay all widget click");
		findElement(payAllWidget, driver).click();		
	}
	
	public void skipPaymentWidgetClick() {
		Log.info("What if screen: Skip payment widget click");
		findElement(skipPaymentWidget, driver).click();		
	}
	
	public void reducePaymentWidgetClick() {
		Log.info("What if screen: Reduce payment widget click");
		findElement(reducePaymentWidget, driver).click();		
	}
	
	public void changePaymentDateWidgetClick() {
		Log.info("What if screen: Change payment date widget click");
		findElement(changePayDateWidget, driver).click();		
	}

	public void verifyDepositWhatIfScreen() {
		// TODO Auto-generated method stub
		
	}



}
