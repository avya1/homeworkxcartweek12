package homepage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utility extends BaseUrl{
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }
    public String verifyPage(String expectedResult,By by,String message){
        WebElement compare = driver.findElement(by);
        String actualResult = compare.getText();
        Assert.assertEquals(message, expectedResult, actualResult);
        return message;
    }
    public void selectFromDropDown(By by,String value){
        WebElement dropDown1=driver.findElement(by);
        dropDown1.click();
        Select select1=new Select(dropDown1);
        select1.selectByValue(value);
    }
    public void sendText(By by,String text){
        driver.findElement(by).sendKeys(text);
    }


    public void mHoverAndClick(By mouseHover,By mouseClick){
        Actions actions=new Actions(driver);
        WebElement hover=driver.findElement(mouseHover);
        WebElement click1=driver.findElement(mouseClick);
        actions.moveToElement(hover).moveToElement(click1).click().build().perform();
    }
    public void productsCompareAndSortList(String sortBy) {
        List<WebElement> products = driver.findElements(By.linkText(sortBy));
        List<String> names = new ArrayList<String>();
        for (WebElement e : products) {
            names.add(e.getText());
        }
        List<String> sortedNames = new ArrayList<String>(names);
        Collections.sort(sortedNames);
        System.out.println(sortedNames.equals(names));
        Assert.assertEquals("Sort by failed",names,sortedNames);

    }


}
