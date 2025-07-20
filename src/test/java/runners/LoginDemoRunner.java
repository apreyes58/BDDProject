package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/logindemo.feature", glue = {"stepdefinitions"},
        plugin = {"pretty", "json:target/JSONReports/logindemoreport.json",
                "pretty", "junit:target/JUnitReports/logindemoreport.xml"})
public class LoginDemoRunner {
}
