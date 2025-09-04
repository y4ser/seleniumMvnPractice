package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T10_MultipleNavigationAndVerification {

    // Task 4: Multiple Navigation and Verification
     static WebDriver driver;
//    Setup:
//    Launch Chrome and maximize in @BeforeEach.
    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
//            Test 1:
//    Navigate Google → YouTube → LinkedIn.
//    Assert titles contain "Google", "YouTube", "LinkedIn" respectively.
    @Test
    void navigationAndTitleTest() {
        driver.get("https://www.google.com");
        assert driver.getTitle().contains("Google") : "Title does not contain 'Google'";

        driver.get("https://www.youtube.com");
        assert driver.getTitle().contains("YouTube") : "Title does not contain 'YouTube'";

        driver.get("https://www.linkedin.com");
        assert driver.getTitle().contains("LinkedIn") : "Title does not contain 'LinkedIn'";
    }

//            Test 2:
//    Navigate back twice and assert the URL of Google.
//    Navigate forward twice and assert URL of LinkedIn.
    @Test
    void navigationBackAndForwardTest() {
        driver.get("https://www.google.com");
        driver.get("https://www.youtube.com");
        driver.get("https://www.linkedin.com");

        driver.navigate().back();
        driver.navigate().back();
        assert driver.getCurrentUrl().equals("https://www.google.com/") : "URL is not Google";

        driver.navigate().forward();
        driver.navigate().forward();
        assert driver.getCurrentUrl().equals("https://www.linkedin.com/") : "URL is not LinkedIn";
    }

    // Teardown:
    // Use @AfterAll to quit the browser.

    @AfterEach
    void teardown() {
        driver.quit();
    }

}
