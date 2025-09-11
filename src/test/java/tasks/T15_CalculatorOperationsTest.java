package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class T15_CalculatorOperationsTest {

    /*
     Task 2: Calculator Operations Test
     Go to https://testpages.eviltester.com/styled/calculator
     Type any number in first and second input
     Click Calculate for each operation
     Get and verify results for all operations
     */

    @Test
    void calculatorOperationsTest() {
        driver.get("https://testpages.eviltester.com/styled/calculator");
        driver.findElement(By.id("number1")).sendKeys("25");
        driver.findElement(By.id("number2")).sendKeys("5");
        String[] operations = {"plus", "minus", "times", "divide"};
        for (String operation : operations) {
            Select select = new Select(driver.findElement(By.id("function")));
            select.selectByValue(operation);
            driver.findElement(By.id("calculate")).click();
            String result = driver.findElement(By.id("answer")).getText();
            switch (operation) {
                case "plus":
                    assertEquals(String.valueOf(25 + 5), result);
                    break;
                case "minus":
                    assertEquals(String.valueOf(25 - 5), result);
                    break;
                case "times":
                    assertEquals(String.valueOf(25 * 5), result);
                    break;
                case "divide":
                    assertEquals(String.valueOf(25 / 5), result);
                    break;
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
