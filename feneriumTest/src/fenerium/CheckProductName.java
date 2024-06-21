package fenerium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class CheckProductName {
    WebDriver driver;

    public void initialize(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://fenerium.com");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public void goProductManPage() throws InterruptedException {
        driver.get("https://fenerium.com/erkek");
        Thread.sleep(1500);
    }

    public void selectCategory(String xpath) throws InterruptedException {
        driver.findElement(By.xpath(xpath)).click();
        Thread.sleep(1500);
    }

    public void selectProduct(String xpath) throws InterruptedException {
        List<WebElement> allProducts = driver.findElements(By.xpath("//*[@id=\"productListing\"]/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div/span"));

        Actions actions = new Actions(driver);
        for(WebElement product : allProducts) {
            actions.moveToElement(product).perform();
            Thread.sleep(500);
        }
    }

    public void selectProduct2(String xpath) throws InterruptedException {

    }

    public void uploadProductPage() throws InterruptedException {
        driver.get("https://fenerium.com/erkek");
        Thread.sleep(1500);
    }

    public void close(){
        driver.quit();
    }

    public void back() throws InterruptedException {
        driver.navigate().back();
        Thread.sleep(1500);
    }
}