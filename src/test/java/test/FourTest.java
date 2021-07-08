package test;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class FourTest extends Base {
	public WebDriver driver;
@Test	
public void testfour() throws IOException, InterruptedException {
	
	System.out.println("sush has updated this statement");
	
	System.out.println();
	System.out.println("test four");
	driver = intializeDriver();
	driver.get("http://tutorialsninja.com/demo/");
	Thread.sleep(2000);
	Assert.assertTrue(false);
	
}
@AfterMethod
public void closure() {
	driver.close();
}
}
