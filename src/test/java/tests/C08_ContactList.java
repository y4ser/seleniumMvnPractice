package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C08_ContactList {

    static WebDriver driver;
    @BeforeAll
    static void openBrowser(){
        driver = new ChromeDriver();
    }

    @BeforeEach
    void goToLink(){
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
    }

    @Test
    void titleTest() {
        String title = driver.getTitle();
        assertEquals("Contact List App", title, "Title did not match!");
    }

    @Test
    void linkTest() {
        String url = driver.getCurrentUrl();
        assertEquals("https://thinking-tester-contact-list.herokuapp.com/", url, "URL did not match!");
    }

    @Test
    void pageSourceTest() {
        Assertions.assertTrue(driver.getPageSource().contains("Created by Kristin Jackvony, Copyright 2021"), "Page source did not contain expected text");
    }


    @AfterEach
    void minimizeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.manage().window().minimize();
    }

    @AfterAll
    static void closeBrowser() throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }
}
