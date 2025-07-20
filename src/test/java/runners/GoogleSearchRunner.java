package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/searchgoogle.feature", glue = {"stepdefinitions"},
        plugin = {"pretty", "json:target/JSONReports/googlesearchreport.json",
                "pretty", "junit:target/JUnitReports/googlesearchreport.xml",
                "pretty", "html:target/HTMLReports/googlesearchreport.html"})
public class GoogleSearchRunner {
}
