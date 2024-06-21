package fenerium;

import org.openqa.selenium.*;

import java.util.List;

public class ProductsPage extends BasePage {
    HomePage homePage;
    JavascriptExecutor js ;
    By result= By.xpath("//*[@id=\"searchResultPage\"]/div/div[2]/div[2]/div[1]/div/div[2]/div/div/div[1]/div/div");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductPage() {
        return isDisplayed(result);
    }

    public void selectProduct(int index) throws InterruptedException {
        //homePage = new HomePage(driver);
        //homePage.searchProduct();
        if (index >3){
            js = (JavascriptExecutor) driver;
            Thread.sleep(1000);
            js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
            js.executeScript("window.scrollBy(0, 1000)");
            Thread.sleep(1000);
            if (index>9){
                js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
                js.executeScript("window.scrollBy(0, 1000)");
                Thread.sleep(1000);
            }
        }
        driver.findElement(By.xpath("//*[@id=\"searchResultPage\"]/div/div[2]/div[2]/div[2]/div/div["+index+"]/div/a/h5")).click();

    }

    public void selectJerseyOtherCategory() throws InterruptedException {
        click(By.xpath("//*[@id=\"filter1\"]/div/label[6]/span[2]"));
        Thread.sleep(2000);
    }

    public String getExpectedProductName() throws InterruptedException {
        return find(By.xpath("//*[@id=\"productListing\"]/div/div[2]/div[2]/div[2]/div/div/div/a/h5")).getText();
    }

    public void selectJersey() throws InterruptedException {
        click(By.xpath("//*[@id=\"productListing\"]/div/div[2]/div[2]/div[2]/div/div/div/a/h5"));
        Thread.sleep(2000);

    }

    public boolean checkPrices(List<Integer> extractedIntegers, String minimum, String maximum) {
        int minimumInt = Integer.parseInt(minimum);
        int maximumInt = Integer.parseInt(maximum);

        for(int price: extractedIntegers) {
            if(price < minimumInt || price > maximumInt) {
                return false;
            }
        }
        return true;
    }


    public void changePriceRange(String minimum, String maximum) throws InterruptedException {
        WebElement secondScrollBar = find(By.xpath("//*[@id=\"productListing\"]/div/div[2]/div[1]"));
                //driver.findElement(By.xpath("//*[@id=\"productListing\"]/div/div[2]/div[1]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollBy(0,2000)", secondScrollBar);
        Thread.sleep(100);
        WebElement minimumPrice = find(By.xpath("//*[@id=\"filter5\"]/div/div[1]/div[1]/label/input"));
                //driver.findElement(By.xpath("//*[@id=\"filter5\"]/div/div[1]/div[1]/label/input"));
        WebElement maximumPrice = find(By.xpath("//*[@id=\"filter5\"]/div/div[1]/div[3]/label/input"));
                //driver.findElement(By.xpath("//*[@id=\"filter5\"]/div/div[1]/div[3]/label/input"));
        minimumPrice.click();
        Thread.sleep(100);
        minimumPrice.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        Thread.sleep(100);
        minimumPrice.sendKeys(Keys.DELETE);
        Thread.sleep(100);
        minimumPrice.sendKeys(minimum);
        Thread.sleep(100);
        maximumPrice.click();
        Thread.sleep(100);
        maximumPrice.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        Thread.sleep(100);
        maximumPrice.sendKeys(Keys.DELETE);
        Thread.sleep(100);
        maximumPrice.sendKeys(maximum);
        Thread.sleep(100);
        minimumPrice.click();
    }

    public String getMinimumRangePrice() {
        WebElement minimumPrice = find(By.xpath("//*[@id=\"filter5\"]/div/div[1]/div[1]/label/input"));
        return minimumPrice.getAttribute("value");
    }

    public String getMaximumRangePrice() {
        WebElement maximumPrice = find(By.xpath("//*[@id=\"filter5\"]/div/div[1]/div[3]/label/input"));
        return maximumPrice.getAttribute("value");
    }



}
