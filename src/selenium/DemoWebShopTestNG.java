package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoWebShopTestNG {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        // Set the path to the ChromeDriver executable
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\tussa\\Downloads\\chromedriver_win32\\chromedriver.exe");
        
        // Create a new instance of ChromeDriver
        driver = new ChromeDriver();
        
        // Launch the website
        driver.get("https://demowebshop.tricentis.com/");
    }

    @Test
    public void verifyHomePageElements() {
        try {
            // Verify the visibility of home page elements using XPath expressions
            verifyElementVisibility("//a[@class='logo']", "Demo Web Shop logo");
            verifyElementVisibility("//a[text()='Register']", "Register");
            verifyElementVisibility("//a[text()='Log in']", "Log in");
            verifyElementVisibility("//span[@id='topcartlink']", "Shopping Cart");
            verifyElementVisibility("//span[@class='wishlist-qty']", "Wishlist");
        } catch (Exception e) {
            System.out.println("Failed to verify home page elements: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = "verifyHomePageElements")
    public void addToCartFirstProduct() {
        // Code for adding the first product to cart
    }

    @Test(dependsOnMethods = "addToCartFirstProduct")
    public void verifyAddToCartPage() {
        // Code for verifying the Add to Cart page
    }

    @AfterClass
    public void teardown() {
        // Quit the WebDriver instance and close the browser
        driver.quit();
    }

    private void verifyElementVisibility(String xpathExpression, String elementName) {
        // Find the element using the provided XPath expression
        WebElement element = driver.findElement(By.xpath(xpathExpression));
        
        // Verify that the element is displayed on the screen
        Assert.assertTrue(element.isDisplayed(), elementName + " is visible on the screen.");
    }
}
