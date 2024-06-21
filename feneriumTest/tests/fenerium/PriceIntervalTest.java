package fenerium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class PriceIntervalTest extends BaseTest{
    HomePage homePage;
    ProductsPage productsPage;

    @Test
    public void testPriceInterval() throws InterruptedException {
        homePage = new HomePage(driver);
        productsPage=new ProductsPage(driver);


        homePage.selectKidsProducts();
        String minimum = "700";
        String maximum = "850";
        productsPage.changePriceRange(minimum, maximum);
        List<WebElement> allProducts = driver.findElements(By.xpath("//*[@id=\"productListing\"]/div/div[2]/div[2]/div[2]/div/div/div/div[2]/div/span"));
        List<Integer> extractedIntegers = new ArrayList<>();

        Actions actions = new Actions(driver);
        for(WebElement product : allProducts) {
            actions.moveToElement(product).perform();
            Thread.sleep(500);
            String priceText = product.getText();
            String priceWithoutTl = priceText.substring(0,3);
            int price = Integer.parseInt(priceWithoutTl);
            extractedIntegers.add(price);
        }

        Assertions.assertTrue(productsPage.checkPrices(extractedIntegers, minimum, maximum));

        /*
        for(int price:extractedIntegers) {
            System.out.println(price);
        }
         */

    }



}
