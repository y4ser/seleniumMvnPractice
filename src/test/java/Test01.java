import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test01 {

    public static void main(String[] args) {

        WebDriver driver =  new ChromeDriver();
        driver.get("");

        driver.close();

    }

}
