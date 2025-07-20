package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//Typically this is how runners are created an initialized.
//Plugins allow for different kinds of reports, monochrome allows for more info.
//Plugins can even do multiple create reports.
//Tags allow for filtering  (decided within feature file)
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/login.feature", glue = {"stepdefinitions"}, monochrome = true,
        plugin = {"pretty", "junit:target/JUnitReports/loginreport.xml",
                "pretty", "json:target/JSONReports/loginreport.json",
                "pretty", "html:target/HTMLReports/loginreport.html"}
)
public class TestRunner {
}
