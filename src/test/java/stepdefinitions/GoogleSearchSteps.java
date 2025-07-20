package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GoogleSearchSteps {

    //Create and declare Driver
    WebDriver driver = null;


    @Given("browser is opened")
    public void browserIsOpened() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        //Initialize driver
        driver = new ChromeDriver();

        //Try and find a better way to wait?
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        System.out.println("Step - browser is now opened");
    }

    @And("user is on google search page")
    public void userIsOnGoogleSearchPage() throws InterruptedException {
        //Navigate to google
        driver.navigate().to("https://google.com");
        //This makes the driver/whole app to wait.
        Thread.sleep(2000);
        System.out.println("Step - user is now on the google page");
    }

    @When("user enters a text in search box")
    public void userEntersATextInSearchBox() throws InterruptedException {
        //This is how drivers find elements(html)
        driver.findElement(By.className("gLFyf")).sendKeys("Speed of an unladen swallow");
        Thread.sleep(2000);
        System.out.println("Step - user is putting text");
    }

    @And("enters the search")
    public void entersTheSearch() throws InterruptedException {
        driver.findElement(By.className("gLFyf")).sendKeys(Keys.ENTER);
        Thread.sleep(15000);
        System.out.println("Step - user hits enter");
    }

    @Then("user navigates the search result")
    public void userNavigatesTheSearchResult() throws InterruptedException {
        //Returns true if it has the word, else none
        if (driver.getPageSource().contains("monty")) {
            System.out.println("Step - Contains it! User is now browsing the search results");
        } else
            System.out.println("User is not browsing the search result");
        Thread.sleep(2000);
        driver.quit();
    }
}
