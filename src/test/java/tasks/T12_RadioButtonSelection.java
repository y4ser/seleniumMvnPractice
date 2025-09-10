package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.time.Instant;

public class T12_RadioButtonSelection {

    /*
    Task 3: Radio Button Selection
     Question: Navigate to "
     https://demoqa.com/radio-button". Create a test that:
     Attempts to select each radio button (Yes, Impressive, No)
     Prints whether each option is enabled/disabled
     For enabled options, select them and verify selection
     Print confirmation message for each successful selection
    */

    @Test
    void radioButtonSelectionTest() {

        driver.get("https://demoqa.com/radio-button");

        String[] ids = {"yesRadio", "impressiveRadio", "noRadio"};

        for (String id : ids) {
            WebElement input = driver.findElement(By.id(id));
            System.out.println(id + " enabled? " + input.isEnabled());

            if (input.isEnabled()) {
                WebElement label = driver.findElement(By.cssSelector("label[for='" + id + "']"));
//                wait.until(ExpectedConditions.elementToBeClickable(label));
                try {
                    label.click();
                } catch (Exception e) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", label);
                }

                Assertions.assertTrue(driver.findElement(By.id(id)).isSelected(), id + " not selected!");
                System.out.println("Selected " + id + " successfully ");
            } else {
                System.out.println(id + " is disabled — cannot select.");
            }
        }


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
