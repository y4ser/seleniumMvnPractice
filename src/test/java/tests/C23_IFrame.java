package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C23_IFrame extends TestBase {

    /*
        Go to https://claruswaysda.github.io/iframe.html
        Type your name in input
        Click on 'Bold' button
        Assert the alert message
    */

    @Test
    void iFrameTest(){
//        Go to https://claruswaysda.github.io/iframe.html
        driver.get("https://claruswaysda.github.io/iframe.html");

//        Type your name in input
//        driver.switchTo().frame("mce_0_ifr");

        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));

        driver.findElement(By.xpath("//input[@placeholder='Type here...']")).sendKeys("Yaser");

//        Click on 'Bold' button
        driver.switchTo().defaultContent();
//        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("//button[.='Bold']")).click();//This is inside default content

//        Assert the alert message
        String alertMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        System.out.println("alertMessage = " + alertMessage);
        Assertions.assertEquals("Bold button clicked",alertMessage);

    }
}
