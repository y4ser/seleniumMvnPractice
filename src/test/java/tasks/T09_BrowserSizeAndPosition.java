package tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T09_BrowserSizeAndPosition {

    // Task 3: Browser Size and Position
     WebDriver driver;

    //Setup:
    // Open Chrome in @BeforeEach.
    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
    }

    //Test 1:
    // Navigate to https://www.bbc.com.
    // Set browser size to 800x600 and assert the window size.
    @Test
    void bbcWindowSizeTest() {
        driver.get("https://www.bbc.com");
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(800, 600));
        org.openqa.selenium.Dimension size = driver.manage().window().getSize();
        assert size.getWidth() == 800 && size.getHeight() == 600 : "Window size is not 800x600";
    }


    // Test 2:
    // Move the window to position (100, 100) and assert its position.
    @Test
    void bbcWindowPositionTest() {
        driver.get("https://www.bbc.com");
        driver.manage().window().setPosition(new org.openqa.selenium.Point(100, 100));
        org.openqa.selenium.Point position = driver.manage().window().getPosition();
        assert position.getX() == 100 && position.getY() == 100 : "Window position is not (100, 100)";

        // Teardown:
        // Close the browser.
        driver.quit();
    }

}