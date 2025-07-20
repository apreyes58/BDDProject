package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/downloaduploaddemo.feature", glue = {"stepdefinitions"},
        plugin = {"pretty", "json:target/JSONReports/downloaduploaddemoreport.json",
                "pretty", "junit:target/JUnitReports/downloaduploaddemoreport.xml",
                "pretty", "html:target/HTMLReports/downloaduploaddemoreport.html"})
public class DownloadUploadDemoRunner {
}
