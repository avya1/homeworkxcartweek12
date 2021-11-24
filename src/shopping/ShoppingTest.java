package shopping;

import homepage.Utility;
import net.bytebuddy.utility.RandomString;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ShoppingTest extends Utility  {
    @Before
    public void setUp()
    {
        openBrowser();
    }
    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForCupOfMojoBluetoothSpeaker()throws InterruptedException{
        mHoverAndClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"), By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"));
        verifyPage("Sale", By.xpath("//h1[@id='page-title']"), "User is not in sale page");
        mHoverAndClick(By.xpath("//span[@class='sort-by-label']"),By.xpath("//a[contains(text(),'Name A - Z')]"));
        Thread.sleep(3000);
        clickOnElement(By.xpath("(//button[contains(@class,'regular-button add-to-cart product-add2cart productid-16')])[1]"));
        verifyPage("Product has been added to your cart",By.xpath("//li[@class='info']"),"User is not able to verify product is added or not");
        clickOnElement(By.xpath("//a[@class='close']"));
        Thread.sleep(3000);
        clickOnElement(By.xpath("(//div[@title='Your cart'])[1]"));
        clickOnElement(By.xpath("//a[@class='regular-button cart']"));
        verifyPage("Your shopping cart - 1 item",By.xpath("//h1[@id='page-title']")," Shopping cart item is not 1");
        //driver.findElement(By.xpath("//input[@id=\"amount16\"]")).clear();
        Thread.sleep(2000);
        Actions actions=new Actions(driver);
        actions.doubleClick(driver.findElement(By.id("amount16"))).perform();
        sendText(By.xpath("//input[@id=\"amount16\"]"),"2");
        Thread.sleep(4000);
        verifyPage("Your shopping cart - 2 items",By.xpath("//h1[@id='page-title']"),"shopping cart item is not updated by 2");
        verifyPage("Subtotal: $29.98",By.xpath("//li[@class='subtotal']"),"amount not matched");
        Thread.sleep(3000);
        verifyPage("36",By.xpath("//span[normalize-space()='36']"),"amount not matched");
        clickOnElement(By.xpath("//button[@class=\"btn  regular-button regular-main-button checkout\"]"));
        Thread.sleep(3000);
        verifyPage("Log in to your account",By.xpath("//h3[contains(text(),'Log in to your account')]"),"User is not in log in page");
        RandomString email=new RandomString(5);
        String randomEmail=email.nextString();
        sendText(By.xpath("//input[@id=\"email\"]"),randomEmail+"@gmail.com");
        clickOnElement(By.xpath("//span[contains(text(),'Continue')]"));
        verifyPage("Secure Checkout",By.xpath("//h1[contains(text(),'Secure Checkout')]"),"Not to verify secure checkout");
        Thread.sleep(2000);
        sendText(By.xpath("//input[@id=\"shippingaddress-firstname\"]"),"lauren");
        sendText(By.xpath("//input[@id=\"shippingaddress-lastname\"]"),"peterson");
        sendText(By.xpath("//input[@id=\"shippingaddress-street\"]"),"Thoreparch road ");
        driver.findElement(By.xpath("//input[@id=\"shippingaddress-city\"]")).clear();
        Thread.sleep(2000);
        sendText(By.xpath("//input[@id=\"shippingaddress-city\"]"),"London");
        selectFromDropDown(By.xpath("//select[@id=\"shippingaddress-country-code\"]"),"GB");
        Thread.sleep(2000);
        sendText(By.xpath("//input[@id=\"shippingaddress-custom-state\"]"),"uk");
        sendText(By.xpath("//input[@id=\"shippingaddress-zipcode\"]"),"40001");
        clickOnElement(By.xpath("//input[@id=\"create_profile\"]"));
        sendText(By.xpath("//input[@id=\"password\"]"),"qwer1234");
        Thread.sleep(2000);
        //clickOnElement(By.xpath("//parent::label[@title='Local shipping']/span[normalize-space()='up to one week'][1]"));
        actions.doubleClick(driver.findElement(By.id("method128"))).perform();
        //driver.findElement(By.id("method128")).click();
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='pmethod6' and @value='6']"));
        //verifyPage("$37.03",By.xpath("//span[contains(text(),'37')]/ancestor::span[@class=\"surcharge-cell\""),"amount not matched");
        clickOnElement(By.xpath("//button[@class=\"btn regular-button regular-main-button place-order submit\"]"));
        Thread.sleep(3000);
        verifyPage("Thank you for your order",By.xpath("//h1[@id='page-title']"),"User is not able to see any thank you for order text");
    }
    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully()throws InterruptedException{
        mHoverAndClick(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title'][normalize-space()='Hot deals']"),By.xpath("//div[@id='header-area']//span[contains(text(),'Bestsellers')]"));
        verifyPage("Bestsellers",By.xpath("//h1[@id=\"page-title\"]"),"User is not in best seller page");
        mHoverAndClick(By.xpath("//span[@class=\"sort-by-label\"]"),By.xpath("//a[@data-sort-by=\"translations.name\" and @data-sort-order=\"asc\"]"));
        //clickOnElement(By.xpath("//button[@class=\"btn  regular-button add-to-cart product-add2cart productid-13\"]"));
        Actions actions=new Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(By.xpath("//a[contains(@class,'product-thumbnail next-previous-assigned')]//img[contains(@alt,'Vinyl Idolz: Ghostbusters')]"))).build().perform();
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-13']"));
        verifyPage("Product has been added to your cart",By.xpath("//li[@class=\"info\"]"),"product is not added");
        clickOnElement(By.xpath("//a[@class=\"close\"]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@class=\"lc-minicart lc-minicart-horizontal collapsed recently-updated\"]"));
        clickOnElement(By.xpath("//span[contains(text(),'View cart')]"));
        verifyPage("Your shopping cart - 1 item",By.xpath("//h1[@id=\"page-title\"]"),"user is not able to how many item added on cart");
        clickOnElement(By.xpath("//a[@class=\"clear-bag\"]"));
        Thread.sleep(3000);
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals("There are no pop up like Are you sure you want to clear your cart?","Are you sure you want to clear your cart?",driver.switchTo().alert().getText());
        alert.accept();
        Thread.sleep(2000);
        verifyPage("Item(s) deleted from your cart",By.xpath("//li[@class='info' and contains(text(),'Item(s) deleted from your cart')][1]"),"user is not able to see item is deleted or not");
        verifyPage("Your shopping cart - 1 item",By.xpath("//h1[@id=\"page-title\"]"),"card is not empty");



    }
}
