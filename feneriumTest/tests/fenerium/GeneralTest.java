package fenerium;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.*;
import org.junit.jupiter.api.Order;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class GeneralTest extends BaseTest {
    JavascriptExecutor js ;
    final int PRODUCT_INDEX=10;

    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;
    PurchasePage purchasePage;

    @Test
    @Order(2)
    public void searchProduct() throws InterruptedException {
        homePage = new HomePage(driver);
        productsPage=new ProductsPage(driver);
        homePage.searchProduct();
        Assertions.assertTrue(productsPage.isOnProductPage(),"Not on product page");
    }
    @Test
    @Order(3)
    public void selectProduct() throws InterruptedException {
        productDetailPage=new ProductDetailPage(driver);
        homePage = new HomePage(driver);
        productsPage=new ProductsPage(driver);
        productsPage.selectProduct(PRODUCT_INDEX);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),"Not on product detail page !");

    }
    @Test
    @Order(4)
    public void addToCart() throws InterruptedException {
        productDetailPage=new ProductDetailPage(driver);
        Assertions.assertTrue(true);
        productDetailPage.addToCart(PRODUCT_INDEX);
        Assertions.assertTrue(driver.findElement(By.xpath("/html/body/div[16]/div/p")).isDisplayed(),"Product is not added to cart !");
    }
    @Test
    @Order(5)
    public void goToCart() throws InterruptedException {
        cartPage =new CartPage(driver);
        Assertions.assertTrue(true);
        cartPage.goToCart(10);
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"basketPage\"]/div/div/div[2]/div/div[1]/div[2]/button")).isDisplayed(),"Product was not added to cart !");
    }

    @Test
    @Order(6)
    public void changingNumberOfProducts() throws InterruptedException {
        cartPage=new CartPage(driver);
        cartPage.changingNumberOfProducts(PRODUCT_INDEX);
        double price=cartPage.irregularStringToDouble("//*[@id=\"basketPage\"]/div/div/div[1]/div[2]/div/div/div[1]/div/div/div[2]/span");
        double totalPrice= cartPage.irregularStringToDouble("//*[@id=\"basketPage\"]/div/div/div[2]/div/div[1]/div[2]/div[2]/span");
        double numberOfProducts=cartPage.irregularStringToDouble("//*[@id=\"basketPage\"]/div/div/div[2]/div/div[1]/div[1]/div[2]/ul/li/div/div/div[2]/div/span[1]");
        Assertions.assertEquals(totalPrice,price*numberOfProducts);

    }
    // An error was detected in this test.
    // It accepts the entered e-mail address format as correct even if it is invalid.
    // This test was created based on the data at
    // https://www.emailverification.com/?utm_source=emailregex.com&utm_medium=website&utm_term=sidenav.
    @ParameterizedTest
    @CsvSource({"0,deneme@deneme.","1,deneme@-deneme","2,@deneme.com","3,deneme@-deneme.ocm"})
    @Order(1)
    public void invalidMailFormatCheck(int index, String str) throws InterruptedException {
        purchasePage = new PurchasePage(driver);
        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"register\"]/div[1]/form/div/div[3]/div/label/input"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value = '';", emailField);
        purchasePage.validMailFormatCheck(PRODUCT_INDEX,str);
        By invalidMailErrorLabel=By.xpath("//*[@id=\"register\"]/div[1]/form/div/div[3]/div/span");
        try {
            driver.findElement(invalidMailErrorLabel);
            // If element is found, assert will be false
            Assertions.assertTrue(true);
        } catch (NoSuchElementException e) {
            // If the element is not found, assert will be true
            assertFalse(true);

        }
    }
    @Test
    @Order(7)
    public void invalidCardNumberCheck() throws InterruptedException {
        purchasePage = new PurchasePage(driver);
        cartPage=new CartPage(driver);
        //cartPage.goToCart(PRODUCT_INDEX);
        purchasePage.fillTheAddressInfo(10);
        purchasePage.fillThePaymentInfo();
        Thread.sleep(400);
        Assertions.assertTrue(driver.findElement(By.xpath("/html/body/div[8]/div/p")).isDisplayed());
    }
}