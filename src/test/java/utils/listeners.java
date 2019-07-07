package utils;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import tests.BaseClass;

public class listeners implements ITestListener{

	public void onTestStart(ITestResult result) {
		String Name=result.getName();
		try {
			Runtime.getRuntime().exec("adb shell screenrecord /sdcard/"+Name+".mp4");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSuccess(ITestResult result) {
		String Name=result.getName();
		try {
			Runtime.getRuntime().exec(Keys.CONTROL + "c");
			
			Runtime.getRuntime().exec("adb pull /sdcard/test.mp4 "+System.getProperty("user.dir")+"/Videos/"+Name+".mp4");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String Name=result.getName();
		try {
			BaseClass.getScreenshot(Name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Runtime.getRuntime().exec(Keys.CONTROL + "c");
			
			Runtime.getRuntime().exec("adb pull /sdcard/test.mp4 "+System.getProperty("user.dir")+"/Videos/"+Name+".mp4");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
