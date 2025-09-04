package tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T06_VerifySourceCode {

    public static void main(String[] args) {

        // Task6:
        WebDriver driver = new ChromeDriver();

        // Go to the Amazon URL: https://www.amazon.com/
        driver.get("https://www.amazon.com/");


        // Verify that it writes "Performance Metrics" or " Gateway" from the Source code.
        String pageSource = driver.getPageSource();

        if (pageSource.contains("Performance Metrics") || pageSource.contains("Gateway")) {
            System.out.println("Test Passed!");
        } else {
            System.err.println("Test Failed!");
        }

        driver.quit();

    }

}
