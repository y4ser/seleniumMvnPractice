package tasks;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class T27_FindYoungestRecord extends TestBase {


    /*
         Task 4: Find Youngest Record
         Go to https://claruswaysda.github.io/addRecordWebTable.html
         Add 10 records using Faker.
         Find the name of the youngest record.
    */

    @Test
    void findYoungestRecordTest(){

//        Go to https://claruswaysda.github.io/addRecordWebTable.html
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");

//        Add 10 records using Faker.
        for (int i = 0; i < 10; i++) {
            driver.findElement(By.id("nameInput")).sendKeys(Faker.instance().name().fullName());
            driver.findElement(By.id("ageInput")).sendKeys(Faker.instance().number().numberBetween(18, 65) + "");
            new Select(driver.findElement(By.id("countrySelect"))).selectByIndex(Faker.instance().number().numberBetween(1, 5));
            driver.findElement(By.xpath("//button[@onclick='addRecord()']")).click();
        }

//        Find the name of the youngest record.
        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));

        String youngestName = "";
        int minAge = Integer.MAX_VALUE;

        for (WebElement row : rows){
            List<WebElement> cols = row.findElements(By.tagName("td"));

            String name = cols.get(0).getText();
            int age = Integer.parseInt(cols.get(1).getText());

            if (age < minAge){
                minAge = age;
                youngestName = name;
            }
        }

        System.out.println("Youngest record is: " + youngestName + " (" + minAge + ")");

    }

}
