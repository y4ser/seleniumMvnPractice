package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T07_BrowserHistoryExploration1 {

//    Task 1: Browser History Exploration
      static WebDriver driver;
//    Setup:
//    Use @BeforeEach to launch Chrome and maximize.
      @BeforeEach
        void setup(){
          driver = new ChromeDriver();
          driver.manage().window().maximize();

      }
//    Test 1:
//    Navigate to https://www.wikipedia.org/.
//    Navigate to https://www.google.com/.
//    Navigate back and forward multiple times, asserting the correct title at each step.
      @Test
        void navigationTest() throws InterruptedException {
            driver.get("https://www.wikipedia.org/");
            Thread.sleep(2000);
            String wikiTitle = driver.getTitle();
            assert wikiTitle.contains("Wikipedia");

            driver.navigate().to("https://www.google.com/");
            Thread.sleep(2000);
            String googleTitle = driver.getTitle();
            assert googleTitle.contains("Google");

            driver.navigate().back();
            Thread.sleep(2000);
            assert driver.getTitle().equals(wikiTitle);

            driver.navigate().forward();
            Thread.sleep(2000);
            assert driver.getTitle().equals(googleTitle);

            driver.navigate().back();
            Thread.sleep(2000);
            assert driver.getTitle().equals(wikiTitle);

            driver.navigate().forward();
            Thread.sleep(2000);
            assert driver.getTitle().equals(googleTitle);
        }
//    Test 2:
//    Use driver.navigate().refresh() on Google and assert the title still contains "Google".
      @Test
        void refreshTest() throws InterruptedException {
            driver.get("https://www.google.com/");
            Thread.sleep(2000);
            String googleTitle = driver.getTitle();
            assert googleTitle.contains("Google");

            driver.navigate().refresh();
            Thread.sleep(2000);
            assert driver.getTitle().contains("Google");
        }
//    Teardown:
//    Use @AfterEach to close the browser.
      @AfterEach
        void teardown() throws InterruptedException {
            Thread.sleep(2000);
            driver.quit();
        }

}
