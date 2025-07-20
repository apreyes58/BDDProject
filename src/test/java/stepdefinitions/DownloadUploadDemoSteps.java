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

import java.io.File;
import java.time.Duration;

import static org.junit.Assert.fail;

public class DownloadUploadDemoSteps {
    WebDriver driver = null;
    WebDriverWait wait = null;
    String userDownload = System.getProperty("user.home") + File.separator + "Downloads";

    @Given("User has browser opened")
    public void userHasBrowserOpened() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        System.out.println("Step - User has browser opened");
    }

    @And("User goes on the website")
    public void userGoesOnTheWebsite() {
        driver.get("https://demoqa.com/");
        wait.until(ExpectedConditions.urlMatches("https://demoqa.com/"));
        System.out.println("Step - user is now on the website");
    }

    @When("User clicks on elements tab")
    public void userClicksOnElementsTab() {
        driver.findElement(By.xpath("//h5[text()='Elements']")).click();
        wait.until(ExpectedConditions.urlMatches("https://demoqa.com/elements"));
        System.out.println("Step - user is now on the elements tab");
    }

    @Then("User clicks on upload and download tab")
    public void userClicksOnUploadAndDownloadTab() {
        driver.findElement(By.id("item-7")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("downloadButton")));
        System.out.println("Step - user is now on the upload and download tab");
    }

    @And("User selects download button and is downloaded")
    public void userSelectsDownloadButtonAndIsDownloaded() throws InterruptedException {
        driver.findElement(By.id("downloadButton")).click();
        Thread.sleep(3000);
        if (isFileDownloaded(userDownload, "sampleFile.jpeg"))
            System.out.println("Step - User has downloaded the file");
        else
            fail("File was not downloaded");
    }

    @Then("User uploads the downloaded file and confirm uploaded")
    public void userUploadsTheDownloadedFileAndConfirmUploaded() {
        File sample = new File(userDownload + "/sampleFile.jpeg");
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(sample.getAbsolutePath());
        //driver.findElement(By.id("uploadFile")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("uploadedFilePath"), "C:\\fakepath\\sampleFile.jpeg"));
        System.out.println("Step - User uploaded the downloaded file");
        System.out.println("Test successful!");
        driver.quit();
    }

    public boolean isFileDownloaded(String downloadPath, String filename) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(filename)) {
                return true;
            }
        }
        return false;
    }
}
