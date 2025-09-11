package tasks;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class T17_BasicDropDownOperations extends TestBase{

    /*
     Task 5: Basic DropDown Operations
     Go to https://the-internet.herokuapp.com/dropdown
     Create selectByIndexTest method - Select Option 1 using index
     Create selectByValueTest method - Select Option 2 by value
    Create selectByVisibleTextTest method - Select Option 1 by visible text
     Create printAllTest method - Print all dropdown values
     Verify dropdown has Option 2 text
     Create printFirstSelectedOptionTest - Print first selected option
     Verify dropdown size equals 3 element
     */

    String URL = "https://the-internet.herokuapp.com/dropdown";

    /**
     * Select Option 1 using index (Index starts from 0)
     */
    @Test
    void selectByIndexTest() {
        driver.get(URL);

        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);

        dropdown.selectByIndex(1); // Index 0 = "Please select an option", Index 1 = "Option 1"

        String selected = dropdown.getFirstSelectedOption().getText();
        System.out.println("Selected by Index: " + selected);

        assertEquals("Option 1", selected, "Option 1 should be selected using index.");
    }

    /**
     * Select Option 2 by value
     */
    @Test
    void selectByValueTest() {
        driver.get(URL);

        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);

        dropdown.selectByValue("2"); // value="2" for Option 2

        String selected = dropdown.getFirstSelectedOption().getText();
        System.out.println("Selected by Value: " + selected);

        assertEquals("Option 2", selected, "Option 2 should be selected using value.");
    }

    /**
     * Select Option 1 by visible text
     */
    @Test
    void selectByVisibleTextTest() {
        driver.get(URL);

        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);

        dropdown.selectByVisibleText("Option 1");

        String selected = dropdown.getFirstSelectedOption().getText();
        System.out.println("Selected by Visible Text: " + selected);

        assertEquals("Option 1", selected, "Option 1 should be selected using visible text.");
    }

    /**
     * Print all dropdown values
     * Verify "Option 2" exists
     */
    @Test
    void printAllTest() {
        driver.get(URL);

        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);

        List<WebElement> allOptions = dropdown.getOptions();

        System.out.println("Dropdown options:");
        for (WebElement option : allOptions) {
            System.out.println("- " + option.getText());
        }

        // Verify "Option 2" is present
        boolean option2Exists = allOptions.stream()
                .anyMatch(option -> option.getText().equals("Option 2"));

        assertTrue(option2Exists, "Dropdown should contain 'Option 2'");
    }

    /**
     * Print first selected option
     * Verify dropdown size equals 3
     */
    @Test
    void printFirstSelectedOptionTest() {
        driver.get(URL);

        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);

        // Print first selected option
        WebElement firstSelected = dropdown.getFirstSelectedOption();
        System.out.println("First selected option: " + firstSelected.getText());

        // Verify dropdown has exactly 3 options
        List<WebElement> allOptions = dropdown.getOptions();
        int size = allOptions.size();

        System.out.println("Dropdown size: " + size);
        assertEquals(3, size, "Dropdown should contain exactly 3 elements (including default).");
}
}


