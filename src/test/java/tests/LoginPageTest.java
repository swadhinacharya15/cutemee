package tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;




import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.homePage;
import pageObjects.loginPage;
import utils.TestData;
import utils.genericUtils;

public class LoginPageTest extends BaseClass{

	@Test
	public void LoginPageVerification() throws Exception {
		
		AndroidDriver<AndroidElement> driver=capabilities("CutemeeApp");
		Runtime.getRuntime().exec("adb shell screenrecord /sdcard/demo.mp4");
		 loginPage LoginPage=new loginPage(driver);
		 LoginPage.verifyLoginScreen();
		 Runtime.getRuntime().exec(Keys.CONTROL+"c");
	
		
	}
	
	@Test(dataProvider="InputData",dataProviderClass=TestData.class)
	public void LoginPageFlow(String username) throws Exception {
		
		AndroidDriver<AndroidElement> driver=capabilities("CutemeeApp");
		 loginPage LoginPage=new loginPage(driver);
		 LoginPage.Login(username);
		 
	}
	

	
	
}
