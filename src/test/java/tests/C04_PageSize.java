package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_PageSize {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        // Go to the w3school URL : https://www.w3schools.com/
        driver.get("https://www.w3schools.com/");

        // Print the position and size of the page.
        int height = driver.manage().window().getSize().height;
        int width = driver.manage().window().getSize().width;
        System.out.println("height = " + height);
        System.out.println("width = " + width);

        int x = driver.manage().window().getPosition().x;
        int y = driver.manage().window().getPosition().y;
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        Thread.sleep(3000);

        // Adjust the position and size of the page as desired.
        driver.manage().window().setPosition(new Point(600, 10));
        Thread.sleep(3000);
        driver.manage().window().setSize(new Dimension(954, 500));


        // Test that the page is in the position and size you want.
        int newHeight = driver.manage().window().getSize().height;
        int newWidth = driver.manage().window().getSize().width;

        int newX = driver.manage().window().getPosition().x;
        int newY = driver.manage().window().getPosition().y;

        if (newHeight == 500 && newWidth == 954 && newX == 600 && newY == 10) {
            System.out.println("Test Passed!");
        } else {
            System.err.println("Test Failed!");
        }
        //Close the page.

        driver.quit();

    }

}
