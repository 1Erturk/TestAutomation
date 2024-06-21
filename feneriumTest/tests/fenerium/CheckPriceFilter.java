package fenerium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CheckPriceFilter extends BaseTest {
    HomePage homePage;
    ProductsPage productsPage;

    @ParameterizedTest
    @CsvSource({
            "'129', '250'",
            "'128', '350'",
            "'0', '650'",
            "'-100', 750,",
    })
    public void lessThanMinimumPrice(String minimumPrice, String maximumPrice) throws InterruptedException {
        // The cheapest product is 129 TL.
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        homePage.selectMenProducts();
        productsPage.changePriceRange(minimumPrice, maximumPrice);
        Assertions.assertEquals("129", productsPage.getMinimumRangePrice());
    }

    @ParameterizedTest
    @CsvSource({
            "'750', '7212'",
            "'750', '7213'",
            "'750', '99999'",
    })
    public void greaterThanMaximumPrice(String minimumPrice, String maximumPrice) throws InterruptedException {
        // The most expensive product is 7212 TL.
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        homePage.selectMenProducts();
        productsPage.changePriceRange(minimumPrice, maximumPrice);
        Assertions.assertEquals("7212", productsPage.getMaximumRangePrice());
    }

    @ParameterizedTest
    @CsvSource({
            "'7212', '129'",
            "'7211', '130'",
            "'750', '500'",
    })
    public void inverseValues(String minimumPrice, String maximumPrice) throws InterruptedException {
        // The most expensive product is 7212 TL.
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        homePage.selectMenProducts();
        productsPage.changePriceRange(minimumPrice, maximumPrice);
        Assertions.assertEquals(minimumPrice, productsPage.getMaximumRangePrice());
    }

    /*
    @ParameterizedTest
    @CsvSource({
            "'a', 'b'",
    })
    public void characterInputs(String minimumPrice, String maximumPrice) throws InterruptedException {
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        homePage.selectMenProducts();
        productsPage.changePriceRange(minimumPrice, maximumPrice);
    }
     */



}
