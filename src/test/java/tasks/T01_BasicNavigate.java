package tasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T01_BasicNavigate {

    public static void main(String[] args) throws InterruptedException{

        // Task1:
        WebDriver driver = new ChromeDriver();
        // Navigate to URL: https://clarusway.com/
        driver.navigate().to("https://clarusway.com/");

        // Navigate to URL: http://amazon.com/
        driver.navigate().to("http://amazon.com/");

        // Come back to the Clarusway using the back command.
        driver.navigate().back();

        // Again go back to the amazon website using forward command
        Thread.sleep(2000);
        driver.navigate().forward();

        // Refresh the Browser using refresh command.
        Thread.sleep(2000);
        driver.navigate().refresh();

        // Close the Browser.
        Thread.sleep(2000);
        driver.close();

    }

}
