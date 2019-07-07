package pageObjects;

import static org.testng.Assert.assertTrue;

import java.awt.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.genericUtils;

public class loginPage {

	private AndroidDriver<AndroidElement> driver;
	public loginPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id="sign_in_email")
	public WebElement emailField;
	
	@AndroidFindBy(id="sign_in_password")
	public WebElement passwordField;
	
	@AndroidFindBy(id="sign_in_btn")
	public WebElement signInBtn;
	
	@AndroidFindBy(id="Icon")
	public WebElement logo;
	
	@AndroidFindBy(id="sign_in_forgot_password")
	public WebElement ForgetPasswordBtn;
	
	@AndroidFindBy(id="sign_in_dont_have_account")
	public WebElement signUpBtn;
	
	@AndroidFindBy(id="sign_in_close_btn")
	public WebElement skipBtn;
	
	@AndroidFindBy(id="main_search_icon")
	public WebElement homePageSearchIcon;
	

   
	
	public void Login(String username) {
		System.out.println("Entering Login Method");
		 emailField.sendKeys(username);
		 passwordField.sendKeys("swadhin#11");
	     driver.navigate().back();
		 signInBtn.click();
		 if(homePageSearchIcon.isDisplayed()) {
			 System.out.println("Login Succesfull");
		 }
		 else {
			 System.out.println("Login Failed");
		 }
	}
	public void clickSkip() {
		skipBtn.click();
		System.out.println("Skip Btn Clicked");
		assertTrue(homePageSearchIcon.isDisplayed(), "Successfully navigated to home screen");
	}
	
	public void clickSignup() {
		signUpBtn.click();
		System.out.println("Sign Up Btn Clicked");
	}
    
	public void clickForgetPassword() {
		ForgetPasswordBtn.click();
		System.out.println("Sign Up Btn Clicked");
	}
	
	public void verifyLoginScreen() {
		logo.isDisplayed();
		emailField.isDisplayed();
		passwordField.isDisplayed();
	   	signUpBtn.isDisplayed();
		skipBtn.isDisplayed();
		ForgetPasswordBtn.isDisplayed();
		System.out.println("Verified SignIn Page");
	}
}
