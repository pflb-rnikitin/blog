package ru.pflb.blog.uxcrowd.test.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
//Post one page object model

public class PostPOM1 {

    private WebDriver driver;

    @FindBy(how=How.CSS, using="div.btn_next_uxc")
    WebElement backToUXCrowdButton;

    @FindBy(how=How.CSS, using="a.blog_href")
    WebElement backToBlogButton;

    @FindBy(how=How.CSS, using="div.blog-single-social-share img.vk-share-icon")
    WebElement sideVKShareButton;

    @FindBy(how=How.CSS, using="div.blog-single-social-share img.tw-share-icon")
    WebElement sideTwitterShareButton;

    @FindBy(how=How.CSS, using="div.blog-single-social-share img.fb-share-icon")
    WebElement sideFBShareButton;

    @FindBy(how=How.CSS, using="textarea.hcc")
    WebElement replyBoxTextArea;

    @FindBy(how=How.CSS, using="div.hc__reply__buttons")
    WebElement sendCommentButton;



    public PostPOM1(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        PageFactory.initElements(driver,this);
    }

    public void closePost () {

        backToBlogButton.click();
    }

    public String getCurrentURL () {
        String currentURL =  driver.getCurrentUrl();
        return currentURL;
    }
    public void scrollPageOneTime (Actions actions){
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    public void sharePostOnVKBySideButton (WebDriver driver, WebDriverWait wait) {
        sideVKShareButton.click();
        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("input.oauth_form_input")));
    }

    public void sharePostOnTwitterBySideButton (WebDriver driver, WebDriverWait wait) {
        sideTwitterShareButton.click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#username_or_email")));
    }

    public void sharePostOnFBBySideButton (WebDriver driver, WebDriverWait wait) {
        sideFBShareButton.click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#email")));
    }

    public void leaveAnAnonymousComment (String commentText) throws InterruptedException {
        replyBoxTextArea.click();
        replyBoxTextArea.sendKeys(commentText);
        sendCommentButton.click();
    }
}
