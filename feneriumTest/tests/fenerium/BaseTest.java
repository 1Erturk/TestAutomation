package fenerium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://fenerium.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"cookieModal\"]/div/div/div[2]/div/div[2]/button[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"cookieModal\"]/div/div/div[3]/button[3]")).click();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }

    /*
    public static ChromeOptions options;

    public static ChromeDriver driver;

    @BeforeAll
    public static void setUp(){
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://fenerium.com/");
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
     */



}
