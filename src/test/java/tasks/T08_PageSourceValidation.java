package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T08_PageSourceValidation {

    // Task 2: Page Source Validation
    static WebDriver driver;
    // Setup:
    // Use @BeforeEach to open Chrome and maximize.
    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // Test 1:
    // Navigate to https://www.selenium.dev.
    // Verify that the page source contains the word "WebDriver".
    @Test
    void seleniumPageSourceTest() {
        driver.get("https://www.selenium.dev");
        assert driver.getPageSource().contains("WebDriver");
    }


//    Test 2:
//    Navigate to https://www.python.org.
//    Assert the page source contains "Python".
    @Test
    void pythonPageSourceTest() {
        driver.get("https://www.python.org");
        assert driver.getPageSource().contains("Python");
    }

//    Teardown:
//    Close the browser with @AfterEach.
    @AfterEach
    void teardown() {
        driver.quit();
    }


}
