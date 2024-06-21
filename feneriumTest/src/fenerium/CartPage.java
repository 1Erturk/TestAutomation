package fenerium;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    ProductDetailPage productDetailPage;

    public CartPage(WebDriver driver) {
        super(driver);
    }
    public double irregularStringToDouble(String xpath){
        String priceStr = driver.findElement(By.xpath(xpath)).getText();


        String cleanStr = priceStr.replace("₺","");
        cleanStr=cleanStr.replace(".","");
        cleanStr = cleanStr.replace(",", ".");
        cleanStr = cleanStr.replace(" ","");
        cleanStr = cleanStr.replace("A","");
        cleanStr = cleanStr.replace("d","");
        cleanStr = cleanStr.replace("e","");
        cleanStr = cleanStr.replace("t","");

        double price = Double.parseDouble(cleanStr);

        return price;
    }
    public void increaseItemNumber(String xpath) throws InterruptedException {
        driver.findElement(By.xpath(xpath)).click();
        Thread.sleep(1000);
    }
    public void decreaseItemNumber(String xpath) throws InterruptedException {
        driver.findElement(By.xpath(xpath)).click();
        Thread.sleep(1000);
    }
    public void goToCart(int indexOfTheProduct) throws InterruptedException {
        //productDetailPage = new ProductDetailPage(driver);
        //productDetailPage.addToCart(indexOfTheProduct);
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div[1]/div/div[3]/ul/li[2]/a/div/img")).click();
        driver.findElement(By.xpath("//*[@id=\"basketCollapse\"]/div/div[3]/div[2]/a[1]")).click();
    }
    public void changingNumberOfProducts(int indexOfTheProduct) throws InterruptedException {
        //goToCart(indexOfTheProduct);
        try {
            increaseItemNumber("//*[@id=\"basketPage\"]/div/div/div[1]/div[2]/div/div/div[1]/div/div/div[1]/button[2]");
            increaseItemNumber("//*[@id=\"basketPage\"]/div/div/div[1]/div[2]/div/div/div[1]/div/div/div[1]/button[2]");
            increaseItemNumber("//*[@id=\"basketPage\"]/div/div/div[1]/div[2]/div/div/div[1]/div/div/div[1]/button[2]");
            increaseItemNumber("//*[@id=\"basketPage\"]/div/div/div[1]/div[2]/div/div/div[1]/div/div/div[1]/button[2]");
            decreaseItemNumber("//*[@id=\"basketPage\"]/div/div/div[1]/div[2]/div/div/div[1]/div/div/div[1]/button[1]/i");
            decreaseItemNumber("//*[@id=\"basketPage\"]/div/div/div[1]/div[2]/div/div/div[1]/div/div/div[1]/button[1]/i");
            increaseItemNumber("//*[@id=\"basketPage\"]/div/div/div[1]/div[2]/div/div/div[1]/div/div/div[1]/button[2]");
            increaseItemNumber("//*[@id=\"basketPage\"]/div/div/div[1]/div[2]/div/div/div[1]/div/div/div[1]/button[2]");
            increaseItemNumber("//*[@id=\"basketPage\"]/div/div/div[1]/div[2]/div/div/div[1]/div/div/div[1]/button[2]");
        }
        catch (ElementClickInterceptedException e){
            System.out.println("The maximum number of items in stock has been reached");
        }
    }

}
