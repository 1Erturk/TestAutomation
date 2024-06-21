package fenerium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailPage extends BasePage {
    ProductsPage productsPage;
    By findStoreButton=By.xpath("//*[@id=\"productDetailPage\"]/div/form/div[1]/div[2]/div[3]/div[2]/button[2]");
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(findStoreButton);
    }

    public void addToCart(int indexOfTheProduct) throws InterruptedException {
        //productsPage = new ProductsPage(driver);
        //productsPage.selectProduct(indexOfTheProduct);
        driver.findElement(By.xpath("//*[@id=\"productDetailPage\"]/div/form/div[1]/div[2]/div[3]/div[2]/button[1]")).click();
        Thread.sleep(2000);
    }

    public String getActualProductName() throws InterruptedException {
        WebElement webElement = find(By.xpath("//*[@id=\"productDetailPage\"]/div/form/div[1]/div[2]/div[1]/div[1]/h1"));
        return webElement.getText();
    }
}
