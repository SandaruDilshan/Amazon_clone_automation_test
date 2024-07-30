package dmt;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddtemTest {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increase wait time

        try {
            // Open the login page
            driver.get("http://localhost/Amazon_Clone%20-%20Unit-Tsting/sellor_sign_up.html");
            System.out.println("Opened login page");

            // Fill in the login form
            WebElement loginEmailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            loginEmailField.sendKeys("testseller@example.com");
            System.out.println("Entered login email");

            WebElement loginPasswordField = driver.findElement(By.id("password"));
            loginPasswordField.sendKeys("password123");
            System.out.println("Entered login password");

            WebElement loginButton = driver.findElement(By.name("submit"));
            loginButton.click();
            System.out.println("Clicked login button");

            // Wait for the login process to complete
            wait.until(ExpectedConditions.urlContains("sellor_acc.php")); // Adjust URL as needed
            System.out.println("Login process completed");

            // Navigate to the add item page
            driver.get("http://localhost/Amazon_Clone%20-%20Unit-Tsting/itemform.html");
            System.out.println("Opened add item page");

            // Fill in the add item form
            WebElement itemCategoryDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("itemcatogary")));
            itemCategoryDropdown.sendKeys("Electronics");
            System.out.println("Selected item category");

            WebElement itemNameField = driver.findElement(By.id("itemname"));
            itemNameField.sendKeys("Sample Item");
            System.out.println("Entered item name");

            WebElement itemImageField = driver.findElement(By.id("image-input"));
            itemImageField.sendKeys("C:\\Users\\NEW\\Desktop\\electronics.jpeg"); // Adjust the path to your image
            System.out.println("Uploaded item image");

            WebElement itemDescriptionField = driver.findElement(By.id("message"));
            itemDescriptionField.sendKeys("This is a sample item description.");
            System.out.println("Entered item description");

            WebElement itemQuantityField = driver.findElement(By.id("quentity"));
            itemQuantityField.sendKeys("10");
            System.out.println("Entered item quantity");

            WebElement itemPriceField = driver.findElement(By.id("price"));
            itemPriceField.sendKeys("99.99");
            System.out.println("Entered item price");

            WebElement listItemsButton = driver.findElement(By.name("submit"));
            listItemsButton.click();
            System.out.println("Clicked list items button");

            // Wait for the redirection to 'sellor_acc.php'
            wait.until(ExpectedConditions.urlContains("sellor_acc.php")); // Adjust URL as needed
            System.out.println("Redirected to seller account page");

            driver.get("http://localhost/Amazon_Clone%20-%20Unit-Tsting/sellor_acc.php");
            System.out.println("Opened add item page");

            // Optional: Wait for an element on the seller account page to confirm successful redirection
            WebElement sellerAccountHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1"))); // Adjust selector as needed
            System.out.println("Seller account page header text: " + sellerAccountHeader.getText());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("Page Source: " + driver.getPageSource());
        } finally {
            
            driver.quit();
        }
    }
}
