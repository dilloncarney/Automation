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
 * Description: common reusable notify me page code
 *
 */

public class NotifyMePage extends BasePage {

	/**
	 * TODO Work with DEV to see if we can find better identifiers.
	 */
	// Notify Me
	@FindBy(id = "notifyMePopupLink")
	public static WebElement btnNotifyMe;

	@FindBy(id = "email")
	public static WebElement txtNotifyEmail;

	@FindBy(css = "#styleId")
	public static WebElement selectNotifyColor;

	@FindBy(css = "#dimensionValueIds")
	public static WebElement selectNotifySize;

	@FindBy(name = "saveStockId")
	public static WebElement btnNotifySave;

	@FindBy(css = "li")
	public static WebElement lblNotifyWarningEmail;

	@FindBy(css = "h4.hc")
	public static WebElement lblNotifySent;

	public String msgNotifyErrorEmail = "We're sorry, but the email address you submitted is not recognized. Please try again, and double check your email format (example: someone@example.com).";
	public String msgNotifySent = "THANK YOU!";

	private static Logger LOGGER = Logger.getLogger(Thread.currentThread()
			.getStackTrace()[0].getClassName());

	public NotifyMePage(WebDriver driver) {
		super(driver);

	}

	/**
	 * Go to Notify Me
	 */
	public void notifyGoTo() {

		// Handle Popup/new tab
		String url = btnNotifyMe.getAttribute("href");
		driver.get(url);
	}

	/**
	 * Invalid Notify Me test
	 */
	public void notifyInvalid() {

		verifyText(lblNotifyWarningEmail, msgNotifyErrorEmail);
	}

	/**
	 * Valid Notify Me test
	 */
	public void notifyValid() {

		verifyText(lblNotifySent, msgNotifySent);
		LOGGER.info("Successful Notify Me submission");
	}

	/**
	 * Fill out Notify Me fields
	 */
	public void notifyFillOut(String email) {

		// Clear text field to be safe.
		txtNotifyEmail.clear();
		txtNotifyEmail.sendKeys(email);
		clickAndWait(btnNotifySave);
	}

}
