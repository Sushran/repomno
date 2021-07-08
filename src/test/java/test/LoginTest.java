package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	WebDriver driver;
	Logger log;
	

	@Test(dataProvider="getLoginData")
	public void login(String email,String password,String expectedstatus) throws IOException, InterruptedException {
	
		

		LandingPage landingpage = new LandingPage(driver);
		landingpage.myAccountDropdown().click();
		log.debug("Clicked on My Account dropdown");
		landingpage.loginOption().click();
		log.debug("Clicked on login option");

		Thread.sleep(3000);

		LoginPage loginpage = new LoginPage(driver);
		loginpage.emailAddressField().sendKeys("email");
		log.debug("Email addressed got entered");
		loginpage.passwordField().sendKeys("password");
		log.debug("Password got entered");
		loginpage.loginButton().click();
		log.debug("Clicked on Login Button");
}
@BeforeMethod
	public void openapplication() throws IOException {
	
	 log = LogManager.getLogger(LoginTest.class.getName());
	 
	driver = intializeDriver();
	log.debug("Browser got launched");
	driver.get(prop.getProperty("url"));
	log.debug("Navigated to application URL");
	}
	
	
	
	
	@AfterMethod
	public void closure() {
		driver.close();
		log.debug("Browser got closed");

	}

	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = { { "sush@gmail.com", "sushmitha", "Success" } };
		
		return data;
	}

}