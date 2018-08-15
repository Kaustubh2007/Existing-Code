package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "D:\\Oxygen\\com.cucumber.freecrm1.framework\\src\\main\\java\\features\\createcase.feature",
		glue = "stepDefinition",
		format= {"pretty", "html:test-output/freecrmtest.html", "json:json_output/freecrmtest.json", "junit:junit_output/freecrm.xml"},
		monochrome = true,
		strict = true,
		dryRun = false,
		tags = {}
		)
public class Runner {

}
