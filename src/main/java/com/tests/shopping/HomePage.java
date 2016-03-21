package main.java.com.tests.shopping;

import java.util.logging.Logger;

import main.java.com.tests.common.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author DC
 * @date 03 20 2016 
 * Description: common reusable home page code
 *
 */

public class HomePage extends BasePage {

	/**
	 * TODO Work with DEV to see if we can find better identifiers.
	 */
	// Homepage
	@FindBy(xpath = "(//a[contains(@href, '/mens-shoes')])[3]")
	public static WebElement btnMensShoes;

	@FindBy(xpath = "(//a[contains(text(),'Athletic')])[7]")
	public WebElement btnShoeAthletic;

	private static Logger LOGGER = Logger.getLogger(Thread.currentThread()
			.getStackTrace()[0].getClassName());

	public HomePage(WebDriver driver) {
		super(driver);

	}

	/**
     * Go to the Men Shoes page
     */
	public void goToMenShoes() {

		LOGGER.info("Go to Mens Shoes");
		clickAndWait(btnMensShoes);
	}

	/**
     * Go to the Atheltic Shoes page
     */
	public void goToAthletic() {

		LOGGER.info("Go to Athletic");
		clickAndWait(btnShoeAthletic);
	}

}
