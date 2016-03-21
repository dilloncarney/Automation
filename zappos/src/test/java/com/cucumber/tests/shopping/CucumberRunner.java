package test.java.com.cucumber.tests.shopping;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * 
 * @author DC
 * @date 03 20 2016 
 * Description: Cucumber feature test suite.  Right click -> Run as -> JUnit Test.
 *
 */


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/CucumberSuites/Zappos/Features/MensShoeTest", 
glue = {"test.java.com/cucumber/tests/shopping"})
public class CucumberRunner {

}




