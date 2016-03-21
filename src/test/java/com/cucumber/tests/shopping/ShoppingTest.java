package test.java.com.cucumber.tests.shopping;

import java.util.logging.Logger;

import main.java.com.tests.common.BasePage;
import main.java.com.tests.shopping.CartPage;
import main.java.com.tests.shopping.HomePage;
import main.java.com.tests.shopping.NotifyMePage;
import main.java.com.tests.shopping.ShoePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author DC
 * @date 03 20 2016 
 * Description: Cucumber Test Case for Mens Shoe Test
 */

public class ShoppingTest {

	private static Logger LOGGER = Logger.getLogger(Thread.currentThread()
			.getStackTrace()[0].getClassName());
	private static WebDriver driver;

	/**
	 * TODO: separate this page out into Home Page, Cart, Notify.
	 */
	
	/******************
	 * Home Page
	 ******************/

	@BeforeClass
	@Given("^i open zappos \"([^\"]*)\"$")
	public void i_open_zappos(String env) {

		/**
		 * TODO: implement additional browsers. Check with PM/Marketing to see
		 * which browsers/version ..are used the most amongst our customers.
		 */

		LOGGER.info("Starting Test");
		driver = new ChromeDriver();

		BasePage basePage = new BasePage(driver);
		basePage.setUp(env);
	}

	@When("^i click mens shoes$")
	public void i_click_mens_shoes() {

		LOGGER.info("Starting Test Case");
		HomePage home = new HomePage(driver);

		home.goToMenShoes();
		home.goToAthletic();

	}

	@Then("^i should get shoe$")
	public void i_should_get_shoe() {

		LOGGER.info("Starting Test Case");
		ShoePage shoe = new ShoePage(driver);

		shoe.goToInvoShoe();
		shoe.goToModel();
	}

	
	/******************
	 * Shopping Cart
	 ******************/
	
	@When("^i click add to cart$")
	public void i_click_add_to_cart() {

		LOGGER.info("Starting Test Case");
		CartPage cart = new CartPage(driver);

		cart.cartAdd();
	}

	@Then("^i see cart error$")
	public void i_see_cart_error() {

		LOGGER.info("Starting Test Case");
		CartPage cart = new CartPage(driver);

		cart.cartInvalid();
	}

	
	/******************
	 * Notify
	 ******************/
	
	@Given("^i am notify page$")
	public void i_am_notify_page() {

		LOGGER.info("Starting Test Case");
		NotifyMePage notify = new NotifyMePage(driver);

		notify.notifyGoTo();
	}

	@And("^i submit invalid notify info$")
	public void i_submit_invalid_notify_info() {

		LOGGER.info("Starting Test Case");
		NotifyMePage notify = new NotifyMePage(driver);

		notify.notifyFillOut("!@#$%^&*");
	}

	@Then("^i should trigger invalid notify message$")
	public void i_should_trigger_invalid_notify_message() {

		LOGGER.info("Starting Test Case");
		NotifyMePage notify = new NotifyMePage(driver);

		notify.notifyInvalid();

	}

	@When("^i submit valid notify info$")
	public void i_submit_valid_notify_info() {

		LOGGER.info("Starting Test Case");
		NotifyMePage notify = new NotifyMePage(driver);

		notify.notifyFillOut("DillonCarney+01@gmail.com");
	}

	@Then("^i should trigger valid notify message$")
	public void i_should_trigger_valid_notify_message() {

		LOGGER.info("Starting Test Case");
		NotifyMePage notify = new NotifyMePage(driver);

		notify.notifyValid();
	}

	
	/******************
	 * End of Test
	 ******************/
	
	@Then("^i am closing browser$")
	public void i_am_closing_browser() {

		LOGGER.info("Ending Test");
		driver.close();
		driver.quit();
	}

}
