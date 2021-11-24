package homepage;

import net.bytebuddy.build.ToStringPlugin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopTestMenu extends Utility{
    @Before
    public void setUp()
    {
        openBrowser();
    }
    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully(){
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/descendant::span[contains(.,'Shipping')]"));
        verifyPage("Shipping",By.xpath("//h1[@id='page-title']"),"User is not in correct page ");
    }
    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully(){
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/descendant::span[contains(.,'New!')]"));
        verifyPage("New arrivals",By.xpath("//h1[@id=\"page-title\"]"),"User is not in New Page");
    }
    @Test
    public  void  verifyUserShouldNavigateToComingSoonPageSuccessfully()
    {
        clickOnElement(By.linkText("Coming soon"));
        verifyPage("Coming soon",By.xpath("//h1[@id=\"page-title\"]"),"User is not in coming soon page");

    }
    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully(){
        clickOnElement(By.linkText("Contact us"));
        verifyPage("Contact us",By.xpath("//h1[@id=\"page-title\"]"),"User id not in contact us page");
    }
    @After
    public  void tearDown(){
        closeBrowser();

    }


}
