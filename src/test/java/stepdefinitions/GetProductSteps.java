package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.net.URI;
import java.net.URISyntaxException;

public class GetProductSteps {

    private final String BASE = "https://fakestoreapi.com/";
    private Response response;

    @Given("User calls service {string}")
    public void userCallsServiceWithValidId(String url) throws URISyntaxException {
        RestAssured.baseURI = BASE;
        RequestSpecification requestSpecification = RestAssured.given();
        response = requestSpecification.when().get(new URI(url));
    }

    @Then("Service returns status code {int}")
    public void serviceReturnsStatusCode(int status) {
        int serviceResponseCode = response.then().extract().statusCode();
        Assert.assertEquals(status, serviceResponseCode);
    }

    @Then("Service returns {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void serviceReturnsTitlePriceDescriptionCategoryImageRating(String title, String price, String description, String category, String image, String rating, String status) {
        int responseCode = response.then().extract().statusCode();
        System.out.println("This code " + responseCode);
        if (responseCode == 200 && !response.asString().isEmpty()) {
            String actualTitle = response.then().extract().path("title");
            String actualPrice = response.then().extract().path("price").toString();
            String actualDescription = response.then().extract().path("description");
            String actualCategory = response.then().extract().path("category");
            String actualImage = response.then().extract().path("image");
            String actualRating = (response.then().extract().path("rating")).toString();
            if (actualTitle.equals(title) && actualPrice.equals(price) && actualDescription.equals(description) && actualCategory.equals(category) &&
                    actualImage.equals(image) && actualRating.equals(rating) && status.equals("green")) {
                Assert.assertEquals("green", status);
            } else {
                Assert.assertEquals("red", status);
            }
        } else {
            Assert.assertEquals(200, responseCode);
        }
//        Assert.assertEquals(actualTitle, title);
//        Assert.assertEquals(actualPrice, price);
//        Assert.assertEquals(actualDescription, description);
//        Assert.assertEquals(actualCategory, category);
//        Assert.assertEquals(actualImage, image);
    }

}
