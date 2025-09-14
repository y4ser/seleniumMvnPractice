package tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class T20_DragAndDropPractice extends TestBase {

    /*
        Task 3: Drag and Drop Practice
         Go to https://claruswaysda.github.io/dragAndDrop.html
         Drag the items in their right places
         Assert the success message
    */

//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Test
    void DragAndDropPracticeTest() throws InterruptedException {

//        Go to https://claruswaysda.github.io/dragAndDrop.html
        driver.get("https://claruswaysda.github.io/dragAndDrop.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//        Drag the items in their right places
        WebElement source1 = driver.findElement(By.id("piece1"));
        WebElement target1 = driver.findElement(By.id("slot1"));

        WebElement source2 = driver.findElement(By.id("piece2"));
        WebElement target2 = driver.findElement(By.id("slot2"));

        WebElement source3 = driver.findElement(By.id("piece3"));
        WebElement target3 = driver.findElement(By.id("slot3"));

        String jsDragAndDrop = """
            function triggerDragAndDrop(source, target) {
                const dataTransfer = new DataTransfer();
                source.dispatchEvent(new DragEvent('dragstart', {dataTransfer}));
                target.dispatchEvent(new DragEvent('drop', {dataTransfer}));
                source.dispatchEvent(new DragEvent('dragend', {dataTransfer}));
            }
            triggerDragAndDrop(arguments[0], arguments[1]);
        """;

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(jsDragAndDrop, source1, target1);
        js.executeScript(jsDragAndDrop, source2, target2);
        js.executeScript(jsDragAndDrop, source3, target3);


//        Assert the success message
        WebElement congratsMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("celebrate")));
        assertTrue(congratsMessage.isDisplayed(), "Success message should be displayed");
        assertTrue(congratsMessage.getText().contains("Congratulations!"), "Message should contain 'Congratulations!'");

        System.out.println("Congratulations Message: " + congratsMessage.getText());

    }

}
