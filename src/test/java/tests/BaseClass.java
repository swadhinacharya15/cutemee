package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass  {
	static AndroidDriver<AndroidElement> driver;
	public static AppiumDriverLocalService service ;
	@BeforeTest
	public AppiumDriverLocalService startServer() throws IOException, InterruptedException
	{
		
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	boolean flag=	checkIfServerIsRunnning(4723);
	if(!flag)
	{
		
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
	 System.out.println("Appium service started!");
		return service;
		
	}
	@AfterTest
	public void killServer() {
		 service.stop();	
	}
public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}



	public AndroidDriver<AndroidElement> capabilities(String appName) throws Exception {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\global.properties");
		Properties prop=new Properties();
		prop.load(fis);

	
		File appDir=new File("src");
		File app=new File(appDir,(String) prop.get(appName));
		String device=(String) prop.get("deviceName");
		String UUID=(String) prop.get("UUID");
		String OsVersion=(String) prop.get("OsVersion");
		String PlatformName=(String) prop.get("PlatformName");

        String UDID = System.getProperty("UDID");
		DesiredCapabilities caps=new DesiredCapabilities();
		// caps.setCapability("platformName", "ANDROID");
		// caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, PlatformName);
		caps.setCapability(MobileCapabilityType.VERSION, OsVersion);
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		caps.setCapability(MobileCapabilityType.UDID, UDID);
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20);
		caps.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());
		// caps.setCapability(MobileCapabilityType.APP, "");
		// caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		// caps.setCapability("appPackage", "com.delvo.commerce");
		//  caps.setCapability("appActivity", "com.delvo.commerce.SplashActivity");

		URL url=new URL("http://0.0.0.0:4723/wd/hub");
		driver=new AndroidDriver<AndroidElement>(url,caps);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Appium Started......!");
		return driver;
	}
	public static void getScreenshot(String s) throws IOException
	{
		
		File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));
	
	}

}
