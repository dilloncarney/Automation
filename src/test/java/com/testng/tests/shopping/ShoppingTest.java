package test.java.com.testng.tests.shopping;

import main.java.com.tests.common.BasePage;
import main.java.com.tests.shopping.CartPage;
import main.java.com.tests.shopping.HomePage;
import main.java.com.tests.shopping.NotifyMePage;
import main.java.com.tests.shopping.ShoePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.logging.*;

/**
 * 
 * @author DC
 * @date 03 20 2016 
 * Description: Test Case for Mens Shoe Test page
 */

public class ShoppingTest {

	private static Logger LOGGER = Logger.getLogger(Thread.currentThread()
			.getStackTrace()[0].getClassName());
	private static WebDriver driver;

	/**
	 * TODO: separate this page out into Home Page, Cart, Notify.
	 */
	
	/*
	 * Given a user can access Zappos home page 
	 * They should be able to view a shoe
	 * They should not be able to add to cart without making a selection
	 * And should be able to fill out a 'notify me' forum if we do not have their size.
	 */

	/******************
	 * Home Page
	 ******************/
	
	@BeforeClass
	@Parameters("env")
	public void setupSelenium(String env) {

		LOGGER.info("Starting Test");
		driver = new ChromeDriver();

		BasePage basePage = new BasePage(driver);
		basePage.setUp(env);
	}

	@Test(description = "Zappos -> Mens -> Shoes -> Notify Me Test", enabled = true)
	public void homepageTest() {

		LOGGER.info("Starting Test Case");
		HomePage home = new HomePage(driver);

		home.goToMenShoes();
		home.goToAthletic();

	}

	
	/******************
	 * Shopping Cart
	 ******************/
	
	@Test(description = "Zappos -> Mens -> Shoes -> Notify Me Test", enabled = true, dependsOnMethods = "homepageTest", priority = 1)
	public void shoeTest() {

		LOGGER.info("Starting Test Case");
		ShoePage shoe = new ShoePage(driver);

		shoe.goToInvoShoe();
		shoe.goToModel();
	}

	@Test(description = "Zappos -> Mens -> Shoes -> Notify Me Test", enabled = true, dependsOnMethods = "shoeTest", priority = 1)
	public void cartTest() {

		LOGGER.info("Starting Test Case");
		CartPage cart = new CartPage(driver);

		cart.cartAdd();
		cart.cartInvalid();
	}

	
	/******************
	 * Notify
	 ******************/
	
	@Test(description = "Zappos -> Mens -> Shoes -> Notify Me Test", enabled = true, dependsOnMethods = "cartTest", priority = 1)
	public void notifyTest() {

		LOGGER.info("Starting Test Case");
		NotifyMePage notify = new NotifyMePage(driver);

		notify.notifyGoTo();
		notify.notifyFillOut("!@#$%^");
		notify.notifyInvalid();
		notify.notifyFillOut("DillonCarney+01@gmail.com");
		notify.notifyValid();
	}

	@AfterClass
	public void closeSelenium() {

		LOGGER.info("Ending Test");
		driver.close();
		driver.quit();
	}

}
