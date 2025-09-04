package tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T05_VerifyUrl {

    public static void main(String[] args) {

        // Task5:
        // Invoke Chrome Driver
        WebDriver driver = new ChromeDriver();

        // Navigate to Facebook homepage URL: https://www.facebook.com/
        driver.navigate().to("https://www.facebook.com/");

        // Verify expected equals actual URL.
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Actual URL: " + actualUrl);

        if (actualUrl.equals("https://www.facebook.com/")) {
            System.out.println("URL matches exactly: Test Passed!");
        } else {
            System.err.println("URL does not match exactly: Test Failed!");
        }


        // Verify expected contains Facebook Word.
        if (actualUrl.contains("facebook")) {
            System.out.println("URL contains 'facebook': Test Passed!");
        } else {
            System.err.println("URL does not contain 'facebook': Test Failed!");
        }

        driver.quit();

    }

}
