package letoapp;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;
import io.selendroid.standalone.log.LogLevelEnum;
import io.selendroid.common.device.DeviceTargetPlatform;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import letoapp.sreens.AboutBankAndAppScreen;
import letoapp.sreens.AboutBankScreen;
import letoapp.sreens.AnotherBankPaymentScreen;
import letoapp.sreens.AuthScreen;
import letoapp.sreens.BankRequisitesScreen;
import letoapp.sreens.CommonTimelineScreen;
import letoapp.sreens.ContactsScreen;
import letoapp.sreens.CreditCardsListScreen;
import letoapp.sreens.DashboardScreen;
import letoapp.sreens.DepositsListScreen;
import letoapp.sreens.InLetoBankOfficesScreen;
import letoapp.sreens.IncorrectLoginPasswordScreen;
import letoapp.sreens.LoansListScreen;
import letoapp.sreens.PaymentsInTerminalsSecreen;
import letoapp.sreens.ResetSecurityCodeScreen;
import letoapp.sreens.TimelineScreen;
import letoapp.sreens.WhatIfScreen;
import letoapp.sreens.WithdrawMoneyInATMScreen;
import letoapp.sreens.cards.CardScreen;
import letoapp.sreens.cards.CreditDetailsScreen;
import letoapp.sreens.cards.HowToUseCardScreen;
import letoapp.sreens.cards.HowWorksBlockFundsScreen;
import letoapp.sreens.deposits.DepositScreen;
import letoapp.sreens.loans.LoanContractScreen;
import letoapp.sreens.loans.LoanInsuranceScreen;
import letoapp.sreens.loans.LoanScreen;
import letoapp.sreens.loans.PaymentsScheduleScreen;
import letoapp.sreens.payments.AccountInfoScreen;
import letoapp.sreens.payments.AmountScreen;
import letoapp.sreens.payments.PaymentToolScreen;
import letoapp.sreens.payments.PaymentsAndTransfersScreen;
import letoapp.sreens.payments.StatusScreen;
import letoapp.sreens.registration.AccountCredentialsScreen;
import letoapp.sreens.registration.CardCredentialsScreen;
import letoapp.sreens.registration.DboScreen;
import letoapp.sreens.registration.ForgotAccountOrAccessCodeScreen;
import letoapp.sreens.registration.ForgotCardNumberOrAccessCodeScreen;
import letoapp.sreens.registration.ForgotPswScreen;
import letoapp.sreens.registration.RegistrationMethodScreen;
import letoapp.sreens.registration.SecurityCodeScreen;
import letoapp.sreens.registration.SendEmailScreen;
import letoapp.sreens.registration.SetLoginScreen;
import letoapp.sreens.registration.SetPasswordScreen;
import letoapp.sreens.registration.SmsCodeScreen;
import letoapp.sreens.services.ChangePaymentDateScreen;
import letoapp.sreens.services.EarlyRepaymentScreen;
import letoapp.sreens.services.FullRepaymentScreen;
import letoapp.sreens.services.PartRepaymentScreen;
import letoapp.sreens.services.ReducePaymentScreen;
import letoapp.sreens.services.SkipPaymentScreen;
import letoapp.sreens.services.TurnOffInsuranceScreen;
import letoapp.sreens.services.VerificationCodeScreen;
import letoapp.sreens.wallet.WalletScreen;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppManager {	
	SelendroidConfiguration serverConfig;
	SelendroidLauncher server;
	SelendroidCapabilities capabilities;
	protected WebDriver driver = null;
	protected static WebDriverWait waitDriver = null;
	private AuthScreen authScreen;
	private DashboardScreen dashboardScreen;
	private ContactsScreen contactsScreen;
	private CommonTimelineScreen commonTimelineScreen;
	private LoansListScreen loansListScreen;
	private LoanScreen loanScreen;
	private CreditCardsListScreen creditCardsListScreen;
	private CardScreen cardScreen;
	private DepositScreen depositScreen;
	private DboScreen dboScreen;
	private SendEmailScreen sendEmailScreen;
	private RegistrationMethodScreen registrationMethodScreen;
	private CardCredentialsScreen cardCredentialsScreen;
	private AccountCredentialsScreen accountCredentialsScreen;
	private SmsCodeScreen smsCodeScreen; 
	private SetLoginScreen setLoginScreen;
	private SetPasswordScreen setPasswordScreen;
	private SecurityCodeScreen securityCodeScreen;	
	private IncorrectLoginPasswordScreen incorrectLoginPasswordScreen;
	private ForgotPswScreen forgotPswScreen;
	private ForgotAccountOrAccessCodeScreen forgotAccountOrAccessCodeScreen;
	private ForgotCardNumberOrAccessCodeScreen forgotCardNumberOrAccessCodeScreen;
	private AboutBankAndAppScreen aboutBankAndAppScreen;
	private AboutBankScreen aboutBankScreen; 
	private BankRequisitesScreen bankRequisitesScreen;
	private ResetSecurityCodeScreen resetSecurityCodeScreen;	
	private PaymentsScheduleScreen paymentsScheduleScreen;
	private InLetoBankOfficesScreen inLetoBankOfficesScreen;
	private AnotherBankPaymentScreen anotherBankPaymentScreen;
	private PaymentsInTerminalsSecreen paymentsInTerminalsSecreen;
	private LoanContractScreen loanContractScreen;
	private TimelineScreen timelineScreen;
	private LoanInsuranceScreen loanInsuranceScreen;
	private ReducePaymentScreen reducePaymentScreen;
	private VerificationCodeScreen verificationCodeScreen;
	private WalletScreen walletScreen;
	private PaymentsAndTransfersScreen paymentsAndTransfersScreen;
	private AccountInfoScreen accountInfoScreen;
	private AmountScreen amountScreen;
	private PaymentToolScreen paymentToolScreen;	
	private StatusScreen statusScreen;
	private HowToUseCardScreen howToUseCardScreen; 
	private HowWorksBlockFundsScreen howWorksBlockFundsScreen;
	private CreditDetailsScreen creditDetailsScreen;
	private WhatIfScreen whatIfScreen;
	private ChangePaymentDateScreen changePaymentDateScreen;
	private EarlyRepaymentScreen earlyRepaymentScreen;
	private FullRepaymentScreen fullRepaymentScreen;
	private PartRepaymentScreen partRepaymentScreen;
	private SkipPaymentScreen skipPaymentScreen;
	private TurnOffInsuranceScreen turnOffInsuranceScreen;
	private WithdrawMoneyInATMScreen withdrawMoneyInATMScreen;
	private DepositsListScreen depositsListScreen;
		
	public void init() {		
		authScreen = new AuthScreen(driver);
		dashboardScreen = new DashboardScreen(driver);
		contactsScreen = new ContactsScreen(driver);
		commonTimelineScreen = new CommonTimelineScreen(driver);
		loansListScreen = new LoansListScreen(driver);
		loanScreen = new LoanScreen(driver);
		creditCardsListScreen = new CreditCardsListScreen(driver);
		cardScreen = new CardScreen(driver);
		depositScreen = new DepositScreen(driver);
		dboScreen = new DboScreen(driver);
		sendEmailScreen = new SendEmailScreen(driver);
		registrationMethodScreen = new RegistrationMethodScreen(driver);
		cardCredentialsScreen = new CardCredentialsScreen(driver);
		accountCredentialsScreen = new AccountCredentialsScreen(driver);
		smsCodeScreen = new SmsCodeScreen(driver);
		setLoginScreen = new SetLoginScreen(driver);
		setPasswordScreen = new SetPasswordScreen(driver);
		securityCodeScreen = new SecurityCodeScreen(driver);		
		incorrectLoginPasswordScreen = new IncorrectLoginPasswordScreen(driver);
		forgotPswScreen = new ForgotPswScreen(driver);
		forgotAccountOrAccessCodeScreen = new ForgotAccountOrAccessCodeScreen(driver);
		forgotCardNumberOrAccessCodeScreen = new ForgotCardNumberOrAccessCodeScreen(driver);
		aboutBankAndAppScreen = new AboutBankAndAppScreen(driver);
		aboutBankScreen = new AboutBankScreen(driver);
		bankRequisitesScreen = new BankRequisitesScreen(driver);
		resetSecurityCodeScreen = new ResetSecurityCodeScreen(driver);		
		paymentsScheduleScreen = new PaymentsScheduleScreen(driver);
		inLetoBankOfficesScreen = new InLetoBankOfficesScreen(driver);
		anotherBankPaymentScreen = new AnotherBankPaymentScreen(driver);
		paymentsInTerminalsSecreen = new PaymentsInTerminalsSecreen(driver);
		loanContractScreen = new LoanContractScreen(driver);
		timelineScreen = new TimelineScreen(driver);
		loanInsuranceScreen = new LoanInsuranceScreen(driver);
		reducePaymentScreen = new ReducePaymentScreen(driver);
		verificationCodeScreen = new VerificationCodeScreen(driver);
		walletScreen = new WalletScreen(driver);
		paymentsAndTransfersScreen = new PaymentsAndTransfersScreen(driver);
		accountInfoScreen = new AccountInfoScreen(driver);
		amountScreen = new AmountScreen(driver);
		paymentToolScreen = new PaymentToolScreen(driver);		
		statusScreen= new StatusScreen(driver);
		howToUseCardScreen = new HowToUseCardScreen(driver); 
		howWorksBlockFundsScreen = new HowWorksBlockFundsScreen(driver);
		creditDetailsScreen = new CreditDetailsScreen(driver);
		whatIfScreen = new WhatIfScreen(driver);
		changePaymentDateScreen = new ChangePaymentDateScreen(driver);
		earlyRepaymentScreen = new EarlyRepaymentScreen(driver);
		fullRepaymentScreen = new FullRepaymentScreen(driver);
		partRepaymentScreen = new PartRepaymentScreen(driver);
		skipPaymentScreen = new SkipPaymentScreen(driver);
		turnOffInsuranceScreen = new TurnOffInsuranceScreen(driver);
		withdrawMoneyInATMScreen = new WithdrawMoneyInATMScreen(driver);
		depositsListScreen = new DepositsListScreen(driver);
	}
	
	/* get Screens methods section */
	
	public AuthScreen getAuthScreen() {
		return authScreen;
	}
	
	public DashboardScreen getDashboardScreen() {
		return dashboardScreen;
	}
	
	public ContactsScreen getContactsScreen() {
		return contactsScreen;
	}
	
	public CommonTimelineScreen getCommonTimelineScreen() {
		return commonTimelineScreen;
	}
	
	public LoansListScreen getLoansListScreen() {
		return loansListScreen;
	}
	
	public LoanScreen getLoanScreen() {
		return loanScreen;
	}

	public CreditCardsListScreen getCreditCardsListScreen() {
		return creditCardsListScreen;
	}
	
	public CardScreen getCardScreen() {
		return cardScreen;
	}
	
	public DepositScreen getDepositScreen() {
		return depositScreen;
	}
	
	public DboScreen getDboScreen() {
		return dboScreen;
	}
	
	public SendEmailScreen getSendEmailScreen() {
		return sendEmailScreen;
	}
	
	public RegistrationMethodScreen getRegistrationMethodScreen() {
		return registrationMethodScreen;
	}
	
	public CardCredentialsScreen getCardCredentialsScreen() {
		return cardCredentialsScreen;
	}
	
	public AccountCredentialsScreen getAccountCredentialsScreen() {
		return accountCredentialsScreen;
	}
	
	public SmsCodeScreen getSmsCodeScreen() {
		return smsCodeScreen;
	}
	
	public SetLoginScreen getSetLoginScreen() {
		return setLoginScreen;
	}
	
	public SetPasswordScreen getSetPasswordScreen() {
		return setPasswordScreen;
	}
	
	public SecurityCodeScreen getSecurityCodeScreen() {
		return securityCodeScreen;
	}	
	
	public IncorrectLoginPasswordScreen getIncorrectLoginPasswordScreen() {
		return incorrectLoginPasswordScreen;
	}
	
	public ForgotPswScreen getForgotPswScreen() {
		return forgotPswScreen;
	}
	
	public ForgotAccountOrAccessCodeScreen getForgotAccountOrAccesCodeScreen() {
		return forgotAccountOrAccessCodeScreen;
	}
	
	public ForgotCardNumberOrAccessCodeScreen getForgotCardNumberOrAccessCodeScreen() {
		return forgotCardNumberOrAccessCodeScreen;
	}
	
	public AboutBankAndAppScreen getAboutBankAndAppScreen() {
		return aboutBankAndAppScreen;
	}
	
	public AboutBankScreen getAboutBankScreen() {
		return aboutBankScreen;
	}
	
	public BankRequisitesScreen getBankRequisitesScreen() {
		return bankRequisitesScreen;
	}
	
	public ResetSecurityCodeScreen getResetSecurityCodeScreen() {
		return resetSecurityCodeScreen;
	}
	
	public PaymentsScheduleScreen getPaymentsScheduleScreen() {
		return paymentsScheduleScreen;
	}
	
	public InLetoBankOfficesScreen getInLetoBankOfficesScreen() {
		return inLetoBankOfficesScreen;
	}
	
	public AnotherBankPaymentScreen getAnotherBankPaymentScreen() {
		return anotherBankPaymentScreen;
	}
	
	public PaymentsInTerminalsSecreen getPaymentsInTerminalsSecreen() {
		return paymentsInTerminalsSecreen;
	}
	
	public LoanContractScreen getLoanContractScreen() {
		return loanContractScreen;
	}
	
	public TimelineScreen getTimelineScreen() {
		return timelineScreen;
	}
	
	public LoanInsuranceScreen getLoanInsuranceScreen() {
		return loanInsuranceScreen;
	}
	
	public ReducePaymentScreen getReducePaymentScreen() {
		return reducePaymentScreen;
	}
	
	public VerificationCodeScreen getVerificationCodeScreen() {
		return verificationCodeScreen;
	}
	
	public WalletScreen getWalletScreen(){
		return walletScreen;
	}
	
	public PaymentsAndTransfersScreen getPaymentsAndTransfersScreen(){
		return paymentsAndTransfersScreen;
	}
	
	public AccountInfoScreen getAccountInfoScreen(){
		return accountInfoScreen;
	}
	
	public PaymentToolScreen getPaymentToolScreen(){
		return paymentToolScreen;
	}
	public StatusScreen getStatusScreen(){
		return statusScreen;
	}
	
	public AmountScreen getAmountScreen(){
		return amountScreen;
	}
	
	public HowWorksBlockFundsScreen getHowWorksBlockFundsScreen() {
		return howWorksBlockFundsScreen;
	}
	
	public HowToUseCardScreen getHowToUseCardScreen() {
		return howToUseCardScreen;
	}
	
	public CreditDetailsScreen getCreditDetailsScreen() {
		return creditDetailsScreen;
	}
	
	public WhatIfScreen getWhatIfScreen() {
		return whatIfScreen;
	}
	
	public ChangePaymentDateScreen getChangePaymentDateScreen() {
		return changePaymentDateScreen;
	}
	
	public EarlyRepaymentScreen getEarlyRepaymentScreen() {
		return earlyRepaymentScreen;
	}
	
	public PartRepaymentScreen getPartRepaymentScreen() {
		return partRepaymentScreen;
	}
	
	public FullRepaymentScreen getFullRepaymentScreen() {
		return fullRepaymentScreen;
	}
	
	public SkipPaymentScreen getSkipPaymentScreen() {
		return skipPaymentScreen;
	}
	
	public TurnOffInsuranceScreen getTurnOffInsuranceScreen() {
		return turnOffInsuranceScreen;
	}
	
	public WithdrawMoneyInATMScreen getWithdrawMoneyInATMScreen() {
		return withdrawMoneyInATMScreen;
	}
	
	public DepositsListScreen getDepositsListScreen() {
		return depositsListScreen;
	}
	
	/* Starting Selendroid */
	
	public void startServer(String appPath, boolean forceReinstall, boolean noClearData) 
	{
		serverConfig = new SelendroidConfiguration();
	    serverConfig.addSupportedApp(appPath);
	    serverConfig.setPort(4444);	    
	    serverConfig.setEmulatorPort(5554);	    
	    serverConfig.setDeviceLog(true);
	    serverConfig.setDeviceScreenshot(true);
	    serverConfig.setSelendroidServerPort(38080);
	    serverConfig.setForceReinstall(forceReinstall);
	    serverConfig.setNoClearData(noClearData);
	    serverConfig.setShouldKeepAdbAlive(true);
	    serverConfig.setPrintHelp(true);
	    serverConfig.setLogLevel(LogLevelEnum.INFO);
	    server = new SelendroidLauncher(serverConfig);
	    server.launchSelendroid();	            
	}

	public void initDriver(String appUnderTestId, String serverUrl, Boolean emulator, String appActivity) throws Exception 
	{
	    capabilities = new SelendroidCapabilities();        
	    capabilities.setAut(appUnderTestId);      
	    capabilities.setLaunchActivity(appActivity);   
	    if(emulator == true) {
	    	capabilities.setEmulator(true);
	    	capabilities.setPlatformVersion(DeviceTargetPlatform.ANDROID19);
	    }
	    driver = new SelendroidDriver(new URL(serverUrl), capabilities);
	    waitDriver = new WebDriverWait(driver, 90);	 
	} 
	    
	public void initDriver(String appUnderTestId, String serverUrl, Boolean emulator) throws Exception
	{
	    capabilities = new SelendroidCapabilities();	    
	    capabilities.setAut(appUnderTestId);
	    if(emulator == true) {
	    	capabilities.setEmulator(true);
	    	capabilities.setPlatformVersion(DeviceTargetPlatform.ANDROID19);
	    }
	    driver = new SelendroidDriver(new URL(serverUrl), capabilities); 
	    waitDriver = new WebDriverWait(driver, 90);
	}
	
	public void takeScreenshot()
    {       
       File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
       try {
    	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    	   String date = format.format(new Date());
           FileUtils.copyFile(scrFile, new File("Screenshots" + File.separator +  "screenshot-" +  date +".png"));
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public WebDriverWait getWaitDriver() {
		return waitDriver;
	}
	
	public SelendroidLauncher getServer() {
		return this.server;
	}
	
	public void stopServer() {
		if(getServer() != null) {
			getServer().stopSelendroid();
		}
	}
	
	public void stopDriver() {
		if(getDriver() != null) {
			getDriver().quit();			
		}	
	}

	
}
