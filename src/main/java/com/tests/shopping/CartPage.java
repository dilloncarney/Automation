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
 * Description: common reusable cart page code
 *
 */

public class CartPage extends BasePage {

	// Shopping Cart
	@FindBy(id = "addToCart")
	public static WebElement btnAdd;

	@FindBy(css = "#cartInfoPopWarn-d3")
	public static WebElement lblWarningSize;

	@FindBy(css = "#cartInfoPopWarn-d4")
	public static WebElement lblWarningWidth;

	private static Logger LOGGER = Logger.getLogger(Thread.currentThread()
			.getStackTrace()[0].getClassName());

	public CartPage(WebDriver driver) {
		super(driver);

	}

	public void cartAdd() {

		LOGGER.info("Verify user can click add button.");
		clickAndWait(btnAdd);
	}

	public void cartInvalid() {

		LOGGER.info("Verify user cannot add item without making size/witch selection.");
		clickAndWait(btnAdd);
		verifyText(lblWarningSize, "Please select a size");
		verifyText(lblWarningWidth, "Please select a width");
	}

}
