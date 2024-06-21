package fenerium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    ProductsPage productsPage;
    //By cartCountLocator=By.xpath("//*[@id=\"header\"]/div[2]/div/div/ul[2]/li[3]/a/div/span");
    //By goCartButton=By.className("basket-collapse-area");
    //By goExactlyCartButton=By.className("btn btn-border bg-dark-navy");
    public HomePage(WebDriver driver) {
        super(driver);
    }



    public void isCountUp() {
        isDisplayed(By.xpath("//*[@id=\"header\"]/div[2]/div/div/ul[2]/li[3]/a/div/span"));
    }

    //    public void goCart() {
//        click(goCartButton);
//        click(goExactlyCartButton);
//    }

    private int getCartCount() {
        String count=driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/ul[2]/li[3]/a/div/span")).getText();
        return Integer.parseInt(count);
    }

    public void searchProduct() throws InterruptedException {

        //driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/ul[2]/li[1]/a/i")).click();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div[1]/div/div[2]/input")).sendKeys("Saat"+ Keys.ENTER+Keys.ENTER);
        //driver.findElement(By.xpath("//*[@id=\"header\"]/div[4]/div/div[2]/div/div[2]/form/div/div[1]/button/i")).click();
        Thread.sleep(2000);
    }

    public void selectMenProducts() throws InterruptedException{
        click(By.xpath("//*[@id=\"header\"]/div[2]/div/div/ul[1]/li[2]/a"));
        Thread.sleep(1000);
    }

    public void selectKidsProducts() throws InterruptedException{
        click(By.xpath("//*[@id=\"header\"]/div[2]/div/div/ul[1]/li[4]/a"));
        Thread.sleep(1000);
    }

}
