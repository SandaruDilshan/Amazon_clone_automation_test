package dmt;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSignupTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

       
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increase wait time

        try {
            
            driver.get("http://localhost/Amazon_Clone%20-%20Unit-Tsting/sign_up.html");
            System.out.println("Opened sign-up page");

          
            WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
            nameField.sendKeys("Test User");    
            System.out.println("Entered name");

            WebElement emailField = driver.findElement(By.id("email"));
            emailField.sendKeys("testuser@example.com");
            System.out.println("Entered email");

            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("password123");
            System.out.println("Entered password");

            WebElement confirmPasswordField = driver.findElement(By.id("password_confirmation"));
            confirmPasswordField.sendKeys("password123");
            System.out.println("Entered password confirmation");

            WebElement signupButton = driver.findElement(By.name("submit"));
            signupButton.click();
            System.out.println("Clicked sign-up button");

            
            wait.until(ExpectedConditions.urlContains("sign_in.html"));
            System.out.println("Sign-up process completed");

    
            driver.get("http://localhost/Amazon_Clone%20-%20Unit-Tsting/sign_in.html");
            System.out.println("Opened login page");

            
            WebElement loginEmailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            loginEmailField.sendKeys("testuser@example.com");
       
            System.out.println("Entered login email");

            WebElement loginPasswordField = driver.findElement(By.id("password"));
            loginPasswordField.sendKeys("password123");
            System.out.println("Entered login password");

            WebElement loginButton = driver.findElement(By.name("submit"));
            loginButton.click();
            System.out.println("Clicked login button");

            
            wait.until(ExpectedConditions.urlContains("dashboard"));
            System.out.println("Login process completed");

        
            Thread.sleep(2000);

            driver.get("http://localhost/Amazon_Clone%20-%20Unit-Tsting/index.html");
            System.out.println("Opened index page");

        
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("Page Source: " + driver.getPageSource());
        } finally {
            
            driver.quit();
        }
    }
}
