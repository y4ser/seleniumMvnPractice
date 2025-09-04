package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_MinimizeWindow {

    public static void main(String[] args) throws InterruptedException {

        // Invoke Chrome Browser
        WebDriver driver = new ChromeDriver();

        // Open URL: https: https://www.w3schools.com/
        driver.get("https://www.w3schools.com/");
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());

        // Maximize the window.
        driver.manage().window().maximize();

        // Print the position and size of the page.
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());
        // Minimize the page.
        driver.manage().window().minimize();

        // Wait 7 seconds in the icon state and maximize the page.
        Thread.sleep(7000);
        driver.manage().window().maximize();
        // Print the position and dimensions of the page in maximized state.
        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());

        // Make the page fullscreen.
        Thread.sleep(3000);
        driver.manage().window().fullscreen();

        // Close the Browser.
        Thread.sleep(7000);
        driver.quit();

    }

}
