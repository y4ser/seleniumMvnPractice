package tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class T21_DrawingPractice extends TestBase {

    /*
        Task 4: Drawing Practice
        Go to https://claruswaysda.github.io/Draw.html
        Draw a triangle
        Reset
    */

    @Test
    void DrawingPracticeTest() throws InterruptedException {

//        Go to https://claruswaysda.github.io/Draw.html
        driver.get("https://claruswaysda.github.io/Draw.html");

//        Draw a triangle
        WebElement canvas = driver.findElement(By.id("myCanvas"));

        int canvasWidth = canvas.getSize().getWidth();
        int canvasHeight = canvas.getSize().getHeight();

        int startX = canvasWidth / 2;
        int startY = canvasHeight / 4;

        int offsetX1 = 100;   // move right-down
        int offsetY1 = 150;
        int offsetX2 = -200;  // move left (to form base)
        int offsetY2 = 0;
        int offsetX3 = 100;   // move back to start (right-up)
        int offsetY3 = -150;

        Actions actions = new Actions(driver);
        actions.moveToElement(canvas, startX - canvasWidth/2, startY - canvasHeight/2) // moveToElement uses offsets relative to element center
                .clickAndHold()
                .moveByOffset(offsetX1, offsetY1)
                .moveByOffset(offsetX2, offsetY2)
                .moveByOffset(offsetX3, offsetY3)
                .release()
                .perform();

        Thread.sleep(3000);

//        Reset

        driver.findElement(By.id("resetButton")).click();

    }


}
