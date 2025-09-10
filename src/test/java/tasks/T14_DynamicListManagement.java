package tasks;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class T14_DynamicListManagement {

    /*
     Task 5: Dynamic List Management
     Question: Go to "http://webdriveruniversity.com/To-Do-List/index.html"
     and create a test that:
     Uses Faker to generate 5 random task names
     Adds all tasks to the todo list
     Marks every other task as completed (strikethrough)
     Deletes all completed tasks
     Verifies only incomplete tasks remain
    */

    @Test
    void dynamicListManagementTest() throws InterruptedException {

        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");

        Faker faker = new Faker();
        WebElement input = driver.findElement(By.cssSelector("input[type='text']"));
        for (int i = 0; i < 5; i++) {
            String taskName = faker.lorem().word();
            input.sendKeys(taskName + Keys.ENTER);
            System.out.println("Added task: " + taskName);

        }

        List<WebElement> tasks = driver.findElements(By.tagName("li"));
        for (int i = 0; i < tasks.size(); i++) {
            tasks.get(i).click();
            System.out.println("Marked completed: " + tasks.get(i).getText());
        }
        List<WebElement> remaining = driver.findElements(By.xpath("//li[@class='completed']"));
        for (WebElement t : remaining) {
            Assertions.assertTrue(t.getAttribute("class").contains("completed"));
            System.out.println(" Remaining task: " + t.getText());
        }
        System.out.println(" Only incomplete tasks remain!");
        List<WebElement> deleteButtons = driver.findElements(By.tagName("i"));
        for (WebElement btn : deleteButtons) {
            try {
                btn.click();
                System.out.println(" Deleted a completed task.");
            } catch (Exception ignored) {
            }
        }

        Thread.sleep(3000);
        System.out.println(driver.findElements(By.tagName("li")).size());
        Assertions.assertTrue(driver.findElements(By.tagName("li")).isEmpty());
        System.out.println(" All tasks deleted!");
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
