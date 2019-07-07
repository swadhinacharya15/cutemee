package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class signUp {
	
	private AndroidDriver<AndroidElement> driver;
	public signUp(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	//SignUp Screen
	
	
	@AndroidFindBy(id="textView19")
	public WebElement SignUpSkip;
	
	@AndroidFindBy(id="sign_in_email")
	public WebElement SignUpEmail;
	
	@AndroidFindBy(id="sign_up_name")
	public WebElement SignUpName;
	
	
	@AndroidFindBy(id="sign_up_password")
	public WebElement SignUpPassword;
	
	
	@AndroidFindBy(id="sign_up_confirm_Password")
	public WebElement SignUpCofrmPass;
	
	
	@AndroidFindBy(id="sign_up")
	public WebElement SignUpBtn;
	
	@AndroidFindBy(id="already_have_an_account")
	public WebElement SignUpAlreadyHaveAccount;
	
	
	public void verifySignUpScreen() {
	    SignUpSkip.isDisplayed();
		SignUpPassword.isDisplayed();
		SignUpEmail.isDisplayed();
		SignUpName.isDisplayed();
		SignUpPassword.isDisplayed();
		SignUpCofrmPass.isDisplayed();
		SignUpBtn.isDisplayed();
	    SignUpAlreadyHaveAccount.isDisplayed();
	}
	
	
	


}
