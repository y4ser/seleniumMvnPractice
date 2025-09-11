package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class T19_MultiSelectOperations {

    /*
    Task 7: Multi-Select Operations
     Launch browser
     Open https://demoqa.com/select-menu
     Select Standard Multi-Select using element id
     Verify element is multi-select
     Select 'Opel' using index, then deselect using index
     Select 'Saab' using value, then deselect using value
     Deselect all options
     Close browser
     */

    @Test

    void MultiSelectOperationsTest() throws InterruptedException {

        driver.get("https://demoqa.com/select-menu");
        Thread.sleep(2000);


        WebElement multiSelectElement = driver.findElement(By.id("cars"));
        Select select = new Select(multiSelectElement);
        if (select.isMultiple()) {
            System.out.println("Element is multi-select.");

            select.selectByIndex(2);
            Thread.sleep(1000);

            select.deselectByIndex(2);
            Thread.sleep(1000);

            select.selectByValue("saab");
            Thread.sleep(1000);

            select.deselectByValue("saab");
            Thread.sleep(1000);

            select.deselectAll();
            System.out.println("All options deselected.");
        } else {
            System.out.println("Element is NOT multi-select.");
        }

}

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}


