package fenerium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PurchasePage extends BasePage{
    JavascriptExecutor js ;
    CartPage cartPage;
    public PurchasePage(WebDriver driver) {
        super(driver);
    }
    public void validMailFormatCheck(int indexOfTheProduct,String mailAddresses) throws InterruptedException {
//        cartPage = new CartPage(driver);
//        cartPage.goToCart(indexOfTheProduct);
        // This code directly goes to register page
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/ul/li[1]/a")).click();
        //driver.findElement(By.xpath("//*[@id=\"userCollapse\"]/div[2]/ul/li[2]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"register\"]/div[1]/form/div/div[3]/div/label/input")).sendKeys(mailAddresses);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"registerModal\"]/div/div/div[1]/div[2]/button/i")).click();
        // This code add a product to cart and while buy it, checks the validation of mail address.
//        driver.findElement(By.xpath("//*[@id=\"basketPage\"]/div/div/div[2]/div/div[1]/div[2]/button")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//*[@id=\"getDeliveryPaymentPage\"]")).click();
//        driver.findElement(By.xpath("//*[@id=\"deliveryPage\"]/form/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[3]/div/label/input")).
//                sendKeys("deneme@-deneme");
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//*[@id=\"deliveryPage\"]/form/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[3]/div/label/input")).
//                sendKeys(".deneme");
//        Thread.sleep(1000);
    }
    public void fillTheAddressInfo(int indexOfTheProduct) throws InterruptedException {
        //cartPage = new CartPage(driver);
        //cartPage.goToCart(indexOfTheProduct);
        driver.findElement(By.xpath("//*[@id=\"basketPage\"]/div/div/div[2]/div/div[1]/div[2]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"getDeliveryPaymentPage\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"deliveryPage\"]/form/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[1]/div/label/input")).
                sendKeys("deneme");
        driver.findElement(By.xpath("//*[@id=\"deliveryPage\"]/form/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[2]/div/label/input")).
                sendKeys("deneme");
        driver.findElement(By.xpath("//*[@id=\"deliveryPage\"]/form/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[3]/div/label/input")).
                sendKeys("deneme@-deneme.deneme");
        driver.findElement(By.xpath("//*[@id=\"addAddressPhoneInput\"]")).sendKeys("5555555555");
        driver.findElement(By.xpath("//*[@id=\"deliveryPage\"]/form/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[5]/div/label/div/div[1]/div/div")).
                click();
        driver.findElement(By.xpath("//*[@id=\"deliveryPage\"]/form/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[5]/div/label/div/div[2]/input")).
                sendKeys("Türkiye");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"deliveryPage\"]/form/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[5]/div/label/div/div[2]/input")).
                sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"vs1__combobox\"]/div[1]/input")).sendKeys("izmir");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"vs1__combobox\"]/div[1]/input")).sendKeys(Keys.ENTER);
        Thread.sleep(300);
        driver.findElement(By.xpath("//*[@id=\"deliveryPage\"]/form/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[7]/div/label/div/div[1]/div/div")).
                click();
        driver.findElement(By.xpath("//*[@id=\"deliveryPage\"]/form/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[7]/div/label/div/div[2]/input")).
                sendKeys("Bornova"+ Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"deliveryPage\"]/form/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[8]/div/label/input")).
                sendKeys("35000");
        Thread.sleep(1700);
        driver.findElement(By.xpath("//*[@id=\"deliveryPage\"]/form/div/div/div[1]/div/div/div[1]/div[2]/div/div[2]/div[9]/div/label/textarea")).
                sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        driver.findElement(By.xpath("//*[@id=\"inPageRegistration\"]/div[1]/label/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"deliveryPage\"]/form/div/div/div[2]/div/div[1]/div[2]/button")).click();
    }
    public void fillThePaymentInfo() throws InterruptedException {
        js = ((JavascriptExecutor) driver);
        driver.findElement(By.xpath("//*[@id=\"cardNumber\"]")).sendKeys("1111111111111111");
        driver.findElement(By.xpath("//*[@id=\"paymentType1\"]/div/div[2]/div[1]/div[2]/label/input")).sendKeys("deneme deneme");
        driver.findElement(By.xpath("//*[@id=\"paymentType1\"]/div/div[2]/div[1]/div[3]/div[1]/div/label/div/div[1]/div/div")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"paymentType1\"]/div/div[2]/div[1]/div[3]/div[1]/div/label/div/div[2]")).
                findElement(By.xpath("./div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"paymentType1\"]/div/div[2]/div[1]/div[3]/div[2]/div/label/div/div[1]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\"paymentType1\"]/div/div[2]/div[1]/div[3]/div[2]/div/label/div/div[2]")).
                findElement(By.xpath("./div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"cardCvv\"]")).sendKeys("111");
        driver.findElement(By.xpath("//*[@id=\"paymentType1\"]/div/div[3]/div[2]/div/label/span[2]")).click();
        js.executeScript("window.scrollBy(0,500);");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"deliveryPage\"]/form/div/div/div[1]/div/div[2]/div[3]/div[1]/label/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"deliveryPage\"]/form/div/div/div[1]/div/div[2]/div[3]/div[2]/label/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"deliveryPage\"]/form/div/div/div[2]/div/div[1]/div[2]/button")).click();
    }
}
