package ru.letoapp.screens.popups;

import org.openqa.selenium.WebDriver;

public class GreetingPopup extends PopupBase{	
	
	String messageText = "Уважаемый клиент, эта версия приложения является предварительной и находится в процессе тестирования. Мы будем рады получить ваши пожелания и предложения по работе сервиса на адрес электронной почты, который вы найдете в разделе «Контакты».\n\nБлагодарим вас за пользование услугами «Лето Банка»! Спасибо, что выбрали нас!";
	String titleText = "Информация";
	String nextBtnText = "Закрыть";
	
	public void verifyGreeting() {		
		waitFor(nextBtn);
		Log.info("Greeting popup: Verify greeting window");
		verify.assertEquals(findElement(message, driver).getText(), messageText, "Greeting message text");
		verify.assertEquals(findElement(title, driver).getText(), titleText, "Greeting title");	
		verify.assertAll();
	}

	public GreetingPopup(WebDriver driver) {
		super(driver);
	}	

}
