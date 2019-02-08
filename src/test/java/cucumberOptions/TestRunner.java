package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)// if run with test ng
@CucumberOptions(
		features="src/test/java/features",
		glue="stepDefination")
public class TestRunner extends AbstractTestNGCucumberTests{

}
