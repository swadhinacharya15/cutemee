package tests;

import org.testng.annotations.Test;




import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.homePage;
import pageObjects.loginPage;
import pageObjects.signUp;
import utils.TestData;
import utils.genericUtils;

public class SignUpPageTest extends BaseClass{

	@Test
	public void SignUpPageVerification() throws Exception {
		
		AndroidDriver<AndroidElement> driver=capabilities("CutemeeApp");
		
		 loginPage LoginPage=new loginPage(driver);
		 signUp SignUp=new signUp(driver);
		 
		 LoginPage.clickSignup();
		 SignUp.verifySignUpScreen();
	
		
	}
	
	
	
}
