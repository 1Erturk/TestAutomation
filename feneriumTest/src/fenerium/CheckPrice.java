package fenerium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckPrice {
    WebDriver driver;
    final int productCount = 18;
    double[] lowerToUpper = new double[productCount];
    double[] upperToLower = new double[productCount];

    public void initialize() throws InterruptedException {
        setDriver();
        driver.get("https://fenerium.com");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        Thread.sleep(1000);
    }

    public void fillUpper() throws InterruptedException {
        changeCheckboxIncreasingByPrice();

        for (int i = 1; i <= productCount; i++) {
            WebElement price = driver.findElement(By.xpath("//*[@id=\"productListing\"]/div/div[2]/div[2]/div[2]/div/div["+ i +"]/div/div[2]/div/span"));
            String priceText = price.getText();
            lowerToUpper[i-1] = CheckPrice.unorderedPriceToDouble(priceText);
        }


    }

    public void fillLower() throws InterruptedException {
        changeCheckboxDecreasingByPrice();

        for (int i = 1; i <= productCount; i++) {
            WebElement price = driver.findElement(By.xpath("//*[@id=\"productListing\"]/div/div[2]/div[2]/div[2]/div/div["+ i +"]/div/div[2]/div/span"));
            String priceText = price.getText();
            upperToLower[i-1] = CheckPrice.unorderedPriceToDouble(priceText);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public static double unorderedPriceToDouble(String priceText){
        String cleanPrice = priceText.replace("₺", "").replace(".", "").replace(",", ".");
        return Double.parseDouble(cleanPrice);
    }



    public void changeCheckboxIncreasingByPrice() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("//div[@data-type='select-one']"));
        dropdown.click();
        Thread.sleep(1000);
        WebElement option = driver.findElement(By.xpath(".//div[text()='Fiyata göre artan']"));
        option.click();
        Thread.sleep(1000);
    }

    public void changeCheckboxDecreasingByPrice() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("//div[@data-type='select-one']"));
        dropdown.click();
        Thread.sleep(1000);
        WebElement option = driver.findElement(By.xpath(".//div[text()='Fiyata göre azalan']"));
        option.click();
        Thread.sleep(1000);
    }

    public void uploadProductPage() throws InterruptedException {
        driver.get("https://fenerium.com/erkek");
        Thread.sleep(1500);
    }

    public void close(){
        driver.close();
    }
}
