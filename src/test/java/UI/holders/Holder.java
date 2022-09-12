package UI.holders;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Holder {
    protected WebDriver driver;
    private String mainUrl = "https://demowebshop.tricentis.com/";
    private String secondUrl= "https://rozetka.com.ua/";
    Duration timeToWait = Duration.ofSeconds(15);

    public Holder(WebDriver driver) {
        this.driver = driver;
    }
    //getters
    public String getMainUrl() {
        return mainUrl;
    }
    public String getSecondUrl() {
        return secondUrl;
    }
    //
    public void goToMainPage(){
        driver.get(mainUrl);
    }

    //listSave

    public void changeTab(int number){
        try {
            List<String> list = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(list.get(number));
        }
        catch (IndexOutOfBoundsException e){
            System.err.println(e.getMessage());
        }

    }
    //js
    public void openInNewTab(String url){
        ((JavascriptExecutor) driver).executeScript("window.open('"+url+"')");
    }
    //is that 4 task?
    protected Holder waitForPageLoad(){
        new WebDriverWait(driver, timeToWait).until((ExpectedCondition<Boolean>)
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        return null;
    }
}
