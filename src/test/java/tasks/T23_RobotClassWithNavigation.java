package tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class T23_RobotClassWithNavigation extends TestBase {

    /*
       Task 4: Robot Class with Navigation and Form Submission:
     * Open a demo login page (e.g. https://the-internet.herokuapp.com/login).
     * Click into the username field.
     * Type the username using sendKeys.
     * Use the Robot class to:
     * Press Tab → go to password field.
     * Type the password using sendKeys.
     * Press Enter → submit the form.
     * Verify login success or error message.
     */

    @Test
    public void robotLoginTest() throws InterruptedException, AWTException {

        Robot robot = new Robot();

        // Step 1: Open demo login page
        driver.get("https://the-internet.herokuapp.com/login");

        // Step 2: Locate username field and type username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.click();
        usernameField.sendKeys("tomsmith");

        // Step 3: Use Robot to press TAB (move focus to password field)
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(500);

        // Step 4: Enter password
        WebElement passwordField = driver.switchTo().activeElement();
        passwordField.sendKeys("SuperSecretPassword!");

        // Step 5: Use Robot to press ENTER (submit form)
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);

        // Step 6: Verify login success or error message
        WebElement flashMessage = driver.findElement(By.id("flash"));
        String messageText = flashMessage.getText();
        System.out.println("Message displayed: " + messageText);

        // Assert condition
        assertTrue(messageText.contains("You logged into a secure area!"),"Login did not succeed. Message: " + messageText);

        System.out.println("Login Successful!");
    }
}

