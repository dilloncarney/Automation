package main.java.com.tests.common;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * 
 * @author DC
 * @date 03 20 2016 
 * Description: common reusable core code
 *
 */

public class BasePage {

	private static Logger LOGGER = Logger.getLogger(Thread.currentThread()
			.getStackTrace()[0].getClassName());
	public WebDriver driver;

	/**
	 * 
	 * @param _driver
	 */
	public BasePage(WebDriver _driver) {

		driver = _driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * 
	 * @param env
	 */
	public void setUp(String env) {

		String url = BasePage.setUpEnv(env);

		driver.manage().deleteAllCookies();
		driver.get(url);
	}

	/**
	 * 
	 * @param env
	 */
	public static String setUpEnv(String env) {

		env = env.toLowerCase();
		String url = "";

		LOGGER.info(String.format("Will go to URL based on env [%s] sent in.",
				env));

		switch (env) {
		case "dev":
			url = "http://www.dev.zappos.com";
			break;
		case "qa":
			url = "http://www.qa.zappos.com";
			break;
		case "staging":
			url = "http://www.staging.zappos.com";
			break;
		case "prod":
			url = "http://www.zappos.com";
			break;
		default:
			LOGGER.info("No env sent in.  Will default to QA.");
			url = "qa";
			break;
		}

		LOGGER.info(String.format("Our environemnt is [%s], will open [%s]",
				env, url));
		return url;
	}

	/**
	 * 
	 * @param element
	 */
	public void clickAndWait(WebElement element) {

		int time = 9;
		// Wait for page to load
		WebDriverWait wait = new WebDriverWait(driver, time);

		LOGGER.info(String.format("Waiting for [%s] to load.", element));

		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		LOGGER.info(String.format("PASS: Clicked [%s].", element));
	}

	/**
	 * Given that a web element is displayed, then verify is expected text
	 * appears.
	 * 
	 * @param identifier
	 * @param expectedText
	 */
	public void verifyText(WebElement element, String expectedText) {

		LOGGER.info(String.format("Check for [%s].", expectedText));

		int time = 9;
		// Wait for page to load
		WebDriverWait wait = new WebDriverWait(driver, time);

		LOGGER.info(String.format("Waiting for [%s] to load.", element));

		wait.until(ExpectedConditions.visibilityOf(element));

		if (element.isDisplayed()) {

			Assert.assertTrue(element.getText().contains(expectedText), (String
					.format("Expected [%s], but page shows [%s].",
							expectedText, element.getText())));

		} else {
			Assert.fail(String
					.format("FAIL: Unable to verify text because we could not find web element [%s] on the page.",
							element));
		}

		LOGGER.info(String.format("PASS: Found [%s].", expectedText));
	}
}
