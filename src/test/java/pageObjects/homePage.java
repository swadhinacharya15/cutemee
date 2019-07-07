package pageObjects;



import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class homePage {

	private AndroidDriver<AndroidElement> driver;
	public homePage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id="grid_product_layout_viewall_btn")
	public WebElement gridViewAllBtn;
	
	@AndroidFindBy(id="sign_in_password")
	public WebElement passwordField;
	
	@AndroidFindBy(id="sign_in_btn")
	public WebElement signInBtn;
	
	@AndroidFindBy(id="hs_product_title")
	public List<WebElement> productTitle;
	
	public void printProduct() {
		for(int i=0;i<productTitle.size();i++) {
			System.out.println(productTitle.get(i).getText());
			
			assertEquals("Redmi 5A", productTitle.get(i).getText());
		}
	}
   
	
	

}
