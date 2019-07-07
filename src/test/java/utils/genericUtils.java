package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import tests.BaseClass;

public class genericUtils extends BaseClass{
	
	AndroidDriver<AndroidElement> driver;
	
	public genericUtils(AndroidDriver<AndroidElement> driver) {
	this.driver=driver;
	}

	public void scrollDownTillElement(String Element) throws Exception {
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+Element+"\"));");
		
	}
    
	public void hideKeyBoard() {
		driver.navigate().back();
		System.out.println("Keyboard Hidden");
	}
	
	
	
	

}
