package tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class T04_PageTitle {

    public static void main(String[] args) throws InterruptedException {

        // Task4:
        // Invoke FireFox Driver
        WebDriver driver = new FirefoxDriver();

        // Go to https://www.youtube.com/
        driver.get("https://www.youtube.com/");

        // Verify the page title contains the word video.
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        if (title.contains("video")) {
            System.out.println("Title contains 'video': Test Passed!");
        } else {
            System.err.println("Title does not contain 'video': Test Failed!");
        }


        // Close the driver

        driver.quit();

    }

}
