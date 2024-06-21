package fenerium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.*;

class CheckProductNameTest {
    static WebDriver driver;

    @BeforeAll
    static void setUpBeforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://fenerium.com/");
        //driver.get("https://fenerium.com/erkek");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"cookieModal\"]/div/div/div[2]/div/div[2]/button[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"cookieModal\"]/div/div/div[3]/button[3]")).click();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div[2]/div/ul/li[2]/a/span")).click();
        //driver.manage().deleteAllCookies();
    }


    @ParameterizedTest
    @CsvSource({"3, 6, kazak", "16, 5, yağmurluk", "9, 4, gömlek", "12, 15, şort", "19, 4, top" })
    void testCheckProductNameKazak(int categoryIndex, int productIndex, String productName) throws InterruptedException {


        driver.findElement(By.xpath("//*[@id=\"filter1\"]/div/label["+ categoryIndex +"]")).click(); // Select Filter
        Thread.sleep(3000);

        for (int j = 1; j <= productIndex; j++) {
            WebElement productTitle = driver.findElement(By.xpath("//*[@id=\"productListing\"]/div/div[2]/div[2]/div[2]/div/div[" +  j + "]/div/a/h5"));
            String titleText = productTitle.getText();
            assertTrue(titleText.toLowerCase().contains(productName));
        }
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"filter1\"]/div/label["+ categoryIndex +"]")).click(); // Remove Filter
        Thread.sleep(3000);

    }

    @AfterAll
    static void tearDownAfterClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}