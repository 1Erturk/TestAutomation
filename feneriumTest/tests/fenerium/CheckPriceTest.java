package fenerium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.*;

class CheckPriceTest {
    static WebDriver driver;
    final int productCount = 18;
    static CheckPrice checkPrice;
    double[] lowerToUpper = new double[productCount];
    double[] upperToLower = new double[productCount];

    @BeforeAll
    static void setUpBeforeClass(){
        checkPrice = new CheckPrice();
        checkPrice.setDriver();
        WebDriverManager.chromedriver().setup();
        driver = checkPrice.getDriver();
        driver.get("https://fenerium.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"cookieModal\"]/div/div/div[2]/div/div[2]/button[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"cookieModal\"]/div/div/div[3]/button[3]")).click();
        //driver.get("https://fenerium.com/erkek");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div[2]/div/ul/li[2]/a/span")).click();
        driver.manage().deleteAllCookies();
    }

    @Test
    void checkPriceUpperToLower() throws InterruptedException {

        checkPrice.fillLower();

        for (int i = 0; i < productCount; i++) {
            if (i + 1 < productCount){
                assertTrue(upperToLower[i] >= upperToLower[i + 1]);
            }
        }
    }

    @Test
    void checkPriceLowerToUpper() throws InterruptedException {

        checkPrice.fillUpper();

        for (int i = 0; i < productCount; i++) {
            if (i + 1 < productCount){
                assertTrue(lowerToUpper[i] <= lowerToUpper[i + 1]);
            }
        }
    }

    @AfterAll
    static void tearDownAfterClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}