package pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class forgotPassword {

	private AndroidDriver<AndroidElement> driver;
	public forgotPassword(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Forget Password Screen
	
	
	@AndroidFindBy(id="imageView5")
	public WebElement ForgetPassImage;
	
	@AndroidFindBy(id="textView2")
	public WebElement ForgetPassMainText;
	
	@AndroidFindBy(id="textView4")
	public WebElement ForgetPassTagLine;
	
	
	@AndroidFindBy(id="forgot_password_email")
	public WebElement ForgetPassEmail;
	
	
	@AndroidFindBy(id="reset_password_btn")
	public WebElement ForgetPassResetBtn;
	
	
	@AndroidFindBy(id="tv_forgot_password_go_back")
	public WebElement ForgetPassGoBackBtn;
	
	//Strings
	String ForgotPasswordMain="Forgot Password ?";
	String ForgotPasswordTag="Just enter your registred Email id ,We will send password reset to your email!";
	String ForgotPassEmail="Enter Email Id";
	String ForgotPassResetPass="Reset Password";
	String ForgotPassGoBack="< < Go back";
	public void verifyForgotPasswordScreen() {
		
		assertEquals(ForgetPassMainText.getText(), ForgotPasswordMain);
		assertEquals(ForgetPassTagLine.getText(), ForgotPasswordTag);
		assertEquals(ForgetPassEmail.getText(), ForgotPassEmail);
		assertEquals(ForgetPassResetBtn.getText(), ForgotPassResetPass);
		assertEquals(ForgetPassGoBackBtn.getText(), ForgotPassGoBack);
		assertTrue(ForgetPassImage.isDisplayed(),"Image Displayed");
		
	}
	
	
	
	
	
	
	
}
