package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class T11_CheckboxInteraction {

    /*
     Task 2: Checkbox Interaction
     Question: Go to "https://the-internet.herokuapp.com/checkboxes".
     Write a method that:
     Checks the current state of both checkboxes
     Ensures both checkboxes are selected (click only if not already selected)
     Verify both checkboxes are checked after the operations
     Print the status of each checkbox to console
    */
    @Test
    void checkboxInteractionTest() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        List<WebElement> checkboxList = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement checkbox : checkboxList) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }

            System.out.println("Checkbox is selected: " + checkbox.isSelected());

            if (!checkbox.isSelected()) {
                Assertions.fail();
            }
        }
    }
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
