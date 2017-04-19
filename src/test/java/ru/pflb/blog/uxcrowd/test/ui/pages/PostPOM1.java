package ru.pflb.blog.uxcrowd.test.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
//Post one page object model

public class PostPOM1 {

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
        PageFactory.initElements(driver,this);
    }

    public void closePost () {

        backToBlogButton.click();
    }
    public void scrollPageOneTime (Actions actions){
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }
    public void sharePostOnVKBySideButton (WebDriver driver) {
        sideVKShareButton.click();
        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

    public void sharePostOnTwitterBySideButton (WebDriver driver) {
        sideTwitterShareButton.click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

    public void sharePostOnFBBySideButton (WebDriver driver) {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

    public void leaveAnAnonymousComment (String commentText) throws InterruptedException {
        replyBoxTextArea.click();
        replyBoxTextArea.sendKeys(commentText);
        sendCommentButton.click();
    }
}
