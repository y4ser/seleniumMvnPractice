package tasks;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T03_Position {

    public static void main(String[] args) throws InterruptedException {

        // Task3:
        WebDriver driver = new ChromeDriver();

        // Go to the Amazon URL : https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        // Print the position and size of the page.
        int x =  driver.manage().window().getPosition().x;
        int y =  driver.manage().window().getPosition().y;
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        int height = driver.manage().window().getSize().height;
        int width = driver.manage().window().getSize().width;
        System.out.println("height = " + height);
        System.out.println("width = " + width);

        // Adjust the position and size of the page as desired.
        driver.manage().window().setPosition(new Point(200, 50));
        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(600, 600));


        // Test that the page is in the position and size you want.
        int newX = driver.manage().window().getPosition().x;
        int newY = driver.manage().window().getPosition().y;

        int newHeight = driver.manage().window().getSize().height;
        int newWidth = driver.manage().window().getSize().width;
        if (newX == 200 && newY == 50 && newHeight == 600 && newWidth == 600) {
            System.out.println("Test Passed!");
        } else {
            System.err.println("Test Failed!");
        }


        // Close the page.
        driver.close();
    }

}
