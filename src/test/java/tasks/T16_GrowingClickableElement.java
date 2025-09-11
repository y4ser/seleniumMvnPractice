package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class T16_GrowingClickableElement {

    /*
     Task 4: Growing Clickable Element
     Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
     Click "click me" button
     Verify "Event Triggered" appears
    */

    @Test
    public void testGrowingClickable() {
        driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");
        WebElement button = driver.findElement(By.id("growbutton"));

        // Waiting until the "Event Triggered" (growbuttonstatus) shows
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("growbuttonstatus")));


        // Retrieve the result message and verify the message contains "Event Triggered"
        String message = driver.findElement(By.id("growbuttonstatus")).getText();
        System.out.println("Retrieved message: " + message);
        Assertions.assertEquals("Event Triggered",message);
}

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
