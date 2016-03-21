package main.java.com.tests.shopping;

import java.util.logging.Logger;

import main.java.com.tests.common.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * 
 * @author DC
 * @date 03 20 2016 
 * Description: common reusable shoe page code
 *
 */

public class ShoePage extends BasePage {

	/**
	 * TODO Work with DEV to see if we can find better identifiers.
	 */
	// Inov-8 Shoes
	@FindBy(xpath = "//img[@alt='inov-8 - F-Lite™ 195']")
	public static WebElement btnShoeFLit195;

	@FindBy(css = "a[title='Inov-8 - (33 Items)']")
	public static WebElement btnShoeBrandInov;

	private static Logger LOGGER = Logger.getLogger(Thread.currentThread()
			.getStackTrace()[0].getClassName());

	public ShoePage(WebDriver driver) {

		super(driver);
	}

	/**
	 * Go to Invo-8's shoe page
	 */
	public void goToInvoShoe() {

		LOGGER.info("Go to Shoe Brand: Invo-8");
		clickAndWait(btnShoeBrandInov);
	}

	/**
	 * TODO: Find a way to dynamically send in the model to click using '%s'.
	 * Go to a shoe model
	 */
	public void goToModel() {

		LOGGER.info("Go to Shoe Brand: Invo-8");
		clickAndWait(btnShoeFLit195);
	}

}
