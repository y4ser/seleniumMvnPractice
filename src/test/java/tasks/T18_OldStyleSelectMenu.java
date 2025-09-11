package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class T18_OldStyleSelectMenu {

    /*
     Task 6: Old Style Select Menu
     Launch browser
     Open https://demoqa.com/select-menu
     Select Old Style Select Menu using element id
     Print all dropdown options
     Select 'Purple' using index
     Select 'Magenta' using visible text
     Select an option using value
     Close browser
    * */

    @Test
    void oldStyleSelectMenuTest() throws InterruptedException{

//        Task 6: Old Style Select Menu
//        Launch browser
//        Open https://demoqa.com/select-menu
        driver.get("https://demoqa.com/select-menu");

//        Select Old Style Select Menu using element id
        WebElement oldStyleSelect = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(oldStyleSelect);

//        Print all dropdown options
        List<WebElement> options = select.getOptions();
        System.out.println("Dropdown options:");
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

//        Select 'Purple' using index
        select.selectByIndex(4);
        Thread.sleep(1000);

//        Select 'Magenta' using visible text
        select.selectByVisibleText("Magenta");
        Thread.sleep(1000);

//        Select an option using value
        select.selectByValue("3");
        Thread.sleep(1000);


    }

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
