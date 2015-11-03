package ru.letoapp.screens.cards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.AppScreenBase;


public class HowToUseCardScreen extends AppScreenBase{
	String title = "Как пользоваться картой";
	By howToUseCard = By.xpath("//TextView[@id='label_instructions']");
	String howToUseCardText = "числа следующего месяца.\n\n Если в течение расчетного периода вы использовали кредитные средства, выделенные банком, в день завершения платежного периода вам будет начислен минимальный платёж. Внесение минимального платежа обязательно и должно быть выполнено в течение следующего платежного периода.\n\n Если у вас не было задолженности на начало расчетного периода, до его окончания вы можете брать деньги у банка без процентов. Чтобы воспользоваться этой возможностью вам необходимо будет полностью погасить задолженность перед банком в течение следующего расчетного периода.\n\n Если на карте есть собственные средства, они будут в первую очередь использованы для оплаты. Если собственных средств нет или недостаточно для совершения платежа, будут использованы кредитные средства банка.";

	public HowToUseCardScreen(WebDriver driver) {
		super(driver);
	}
	
	public void verify() throws Exception {
		Log.info("How to use card screen: verify");
		verify.assertEquals(getTitleFromActionBar(), title);	
		verify.assertTrue(findElement(howToUseCard, driver).getText().contains(howToUseCardText), "How to use card text");
		verify.assertAll();
	}

}
