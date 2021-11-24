package hotdeals;

import homepage.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotDealsTest extends Utility {
    @Before
    public void setUp() {
        openBrowser();
    }

    @Test
    public void verifySaleProductsArrangeAlphabetically() {
        mHoverAndClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"), By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        verifyPage("Sale", By.xpath("//h1[@id=\"page-title\"]"), "User is not in sale page");
        mHoverAndClick(By.xpath("//span[@class=\"sort-by-label\"]"),By.xpath("//a[@data-sort-by=\"translations.name\" and @data-sort-order=\"asc\"]"));
        productsCompareAndSortList("Name A-Z");
    }
    @Test
    public void verifySaleProductsPriceArrangeLowToHigh(){
        mHoverAndClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"), By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        verifyPage("Sale", By.xpath("//h1[@id=\"page-title\"]"), "User is not in sale page");
        mHoverAndClick(By.xpath("//span[@class=\"sort-by-label\"]"),By.xpath("//a[@data-sort-by=\"p.price\" and @data-sort-order=\"asc\"]"));
        productsCompareAndSortList("Price Low-High");
    }
    @Test
    public void verifySalesProductsArrangedByRates(){
        mHoverAndClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"), By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        verifyPage("Sale", By.xpath("//h1[@id=\"page-title\"]"), "User is not in sale page");
        mHoverAndClick(By.xpath("//span[@class=\"sort-by-label\"]"),By.xpath("//a[@data-sort-by=\"r.rating\" and @data-sort-order=\"asc\" ]"));
        productsCompareAndSortList("Rates");
    }
    @Test
    public void verifyBestSellerProductsArrangeByZToA(){
        mHoverAndClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"),By.xpath("//div[@id='header-area']//span[contains(text(),'Bestsellers')]"));
        verifyPage("Bestsellers",By.xpath("//h1[@id=\"page-title\"]"),"User is not in best seller page");
        mHoverAndClick(By.xpath("//span[@class=\"sort-by-label\"]"),By.xpath("//a[@data-sort-by=\"translations.name\" and @data-sort-order=\"desc\"]"));
        productsCompareAndSortList("Name Z-A");
    }
    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow()
    {
        mHoverAndClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"),By.xpath("//div[@id='header-area']//span[contains(text(),'Bestsellers')]"));
        verifyPage("Bestsellers",By.xpath("//h1[@id=\"page-title\"]"),"User is not in best seller page");
        mHoverAndClick(By.xpath("//span[@class=\"sort-by-label\"]"),By.xpath("//a[@data-sort-by=\"p.price\" and @data-sort-order=\"desc\"]"));
        productsCompareAndSortList("Price High-low");
    }
    @Test
    public void verifyBestSellersProductsArrangeByRates(){
        mHoverAndClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"),By.xpath("//div[@id='header-area']//span[contains(text(),'Bestsellers')]"));
        verifyPage("Bestsellers",By.xpath("//h1[@id=\"page-title\"]"),"User is not in best seller page");
        mHoverAndClick(By.xpath("//span[@class=\"sort-by-label\"]"),By.xpath("//a[@data-sort-by=\"r.rating\" and @data-sort-order=\"asc\"]"));
        productsCompareAndSortList("Rates");
    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
