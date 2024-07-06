package Cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:target/cucumber-reports/cucumber.html"},
		features = "src\\test\\resources\\Features",
		glue = "stepDefinations",
		tags = "@current",
		monochrome = true
		)

public class TestRunner {

}
