package tests;

import org.testng.annotations.Test;




import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.homePage;
import pageObjects.loginPage;
import utils.TestData;
import utils.genericUtils;

public class SkipLoginPageTest extends BaseClass{

	@Test
	public void SkipLoginVerification() throws Exception {
		
		AndroidDriver<AndroidElement> driver=capabilities("CutemeeApp");
		
		 loginPage LoginPage=new loginPage(driver);
		 
		 LoginPage.clickSkip();
		
	}
	
	
	
}
