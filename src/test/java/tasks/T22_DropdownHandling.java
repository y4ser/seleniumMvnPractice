package tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class T22_DropdownHandling extends TestBase {

    /*
    Task 6: Dropdown Handling
    Go to https://claruswaysda.github.io/Dropdowns.html
    In 1. Traditional Dropdown select 'Ford'
    In 2. Multi-Select Dropdown select 'Mercedes'
    In 3. Custom Dropdown (Bootstrap-like) select 'BMW'
    In 4. Static Auto-Suggest Dropdown select 'Tesla Model 3'
    In 5. Dynamic Auto-Suggest Dropdown select 'Toyota'
    */

    @Test
    void DropdownHandlingTest() throws InterruptedException {

//        Go to https://claruswaysda.github.io/Dropdowns.html
        driver.get("https://claruswaysda.github.io/Dropdowns.html");

//        In 1. Traditional Dropdown select 'Ford'
        WebElement traditional = driver.findElement(By.xpath("//select[@id='carSelect']"));
        Select select1 = new Select(traditional);
        select1.selectByVisibleText("Ford");
        Thread.sleep(3000);

//        In 2. Multi-Select Dropdown select 'Mercedes'
        WebElement multiSelect = driver.findElement(By.xpath("//select[@id='multiCarSelect']"));
        Select select2 = new Select(multiSelect);
        select2.selectByVisibleText("Mercedes");
        Thread.sleep(1000);

//        In 3. Custom Dropdown (Bootstrap-like) select 'BMW'
        driver.findElement(By.xpath("//div[@id='customDropdown']")).click();
        driver.findElement(By.xpath("//div[@class='custom-dropdown'][2]")).click();
        Thread.sleep(3000);


//        In 4. Static Auto-Suggest Dropdown select 'Tesla Model 3'
        WebElement staticAuto = driver.findElement(By.xpath("//input[@id='staticInput']"));
        staticAuto.sendKeys("Tesla Model 3");
        Thread.sleep(1000);
//        staticAuto.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//div[text()='Tesla Model 3']")).click();
        Thread.sleep(1000);

//        In 5. Dynamic Auto-Suggest Dropdown select 'Toyota'
        WebElement dynamicAuto = driver.findElement(By.xpath("//input[@id='dynamicInput']"));
        dynamicAuto.sendKeys("Toyota");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='dynamicInput']/following::div[normalize-space(text())='Toyota'][1]")).click();
        Thread.sleep(1000);

    }


}
