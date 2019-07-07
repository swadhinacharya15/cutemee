package tests;

import org.testng.annotations.Test;




import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.forgotPassword;
import pageObjects.homePage;
import pageObjects.loginPage;
import utils.TestData;
import utils.genericUtils;

public class ForgotPasswordPageTest extends BaseClass{


	
	@Test
	public void ForgotPasswordVerification() throws Exception {
		
		AndroidDriver<AndroidElement> driver=capabilities("CutemeeApp");
		System.out.println("Entering Forget Password Verification Method");
		 loginPage LoginPage=new loginPage(driver);
		 forgotPassword ForgotPassword=new forgotPassword(driver);
		 LoginPage.clickForgetPassword();
		 ForgotPassword.verifyForgotPasswordScreen();
		 System.out.println("Exiting Forget Password Verification Method");
	
	}
	
	
}
