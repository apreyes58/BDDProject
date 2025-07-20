package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginDemoSteps {
    WebDriver driver = null;
    WebDriverWait wait = null;

    @Given("user has browser opened")
    public void userHasBrowserOpened() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        //Initialize driver
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Try and find a better way to wait?
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        System.out.println("Step - browser is now opened");
    }

    @And("user goes on the login page")
    public void userGoesOnTheLoginPage() {
        driver.get("https://the-internet.herokuapp.com/login");
        //Is this the way to validate?`
        wait.until(ExpectedConditions.titleIs("The Internet"));
        System.out.println("Step - User is on the login page!");
    }

    @When("user enters their username and password")
    public void userEntersTheirUsernameAndPassword() {
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        wait.until(ExpectedConditions.and(ExpectedConditions.attributeContains(By.id("username"), "value", "tomsmith"),
                ExpectedConditions.attributeContains(By.id("password"), "value", "SuperSecretPassword!")));
        System.out.println("Step - User now entered their credentials");
    }

    @And("user presses enter or clicked login")
    public void userPressesEnter() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("Step - User has pressed enter to login!");
    }

    @Then("user is brought to the home page")
    public void userIsBroughtToTheHomePage() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h2"), "Secure Area"));
        System.out.println("Step - user is on the homepage!");
    }
}
