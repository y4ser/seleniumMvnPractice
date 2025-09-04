package tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T02_Maximize {

    public static void main(String[] args) throws InterruptedException{

        // Task2:
        WebDriver driver = new ChromeDriver();

        // Open URL: https://www.google.com/
        driver.get("https://www.google.com/");

        // Maximize the window.
        driver.manage().window().maximize();

        // Print the position and size of the page.
        System.out.println("Position: " + driver.manage().window().getPosition());
        System.out.println("Size: " + driver.manage().window().getSize());

        // Minimize the page.
        driver.manage().window().minimize();

        // Wait 5 seconds in the icon state and maximize the page.
        Thread.sleep(5000);
        driver.manage().window().maximize();

        // Print the position and dimensions of the page in maximized state.
        System.out.println("Position after maximize: " + driver.manage().window().getPosition());
        System.out.println("Size after maximize: " + driver.manage().window().getSize());

        // Make the page fullscreen.
        Thread.sleep(3000);
        driver.manage().window().fullscreen();

        // Close the Browser.
        Thread.sleep(3000);
        driver.close();

    }

}
