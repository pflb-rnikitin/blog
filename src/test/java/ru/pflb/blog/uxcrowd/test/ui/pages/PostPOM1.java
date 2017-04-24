package ru.pflb.blog.uxcrowd.test.ui.pages;

import org.openqa.selenium.*;
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
    private Actions actions;
    private WebDriverWait wait;
    private JavascriptExecutor jse;

    @FindBy(how=How.CSS, using="div.header_main_block")
    WebElement postHeader;

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

    @FindBy(how=How.CSS, using="input.hcc[el='Nick']")
    WebElement authFormNameField;

    @FindBy(how=How.CSS, using="input.hcc[el='Email']")
    WebElement authFormEmailField;

    @FindBy(how=How.CSS, using="div.hc__authorization__send__txt")
    WebElement authFormSendButton;

    public PostPOM1(WebDriver driver, Actions actions, WebDriverWait wait, JavascriptExecutor jse) {
        this.driver = driver;
        this.actions = actions;
        this.wait = wait;
        this.jse = jse;
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        PageFactory.initElements(driver,this);
    }

    public void maximizeWindow () {
        driver.manage().window().maximize();
    }

    public void scrollPageToTheCommentSection () {
        jse.executeScript("window.scrollBy(0,5000)", "");
    }

    public void closePost () {
        backToBlogButton.click();
    }

    public String getCurrentURL () {
        return driver.getCurrentUrl();
    }

    public String getHeader() {
        return postHeader.getText();
    }

    public void waitUntilHeaderIsPresent () {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.header_main_block")));
    }

    public void scrollPageOneTime(){
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    public void sharePostOnVKBySideButton() {
        sideVKShareButton.click();
        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("input.oauth_form_input")));
    }

    public void sharePostOnTwitterBySideButton() {
        sideTwitterShareButton.click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#username_or_email")));
    }

    public void sharePostOnFBBySideButton() {
        sideFBShareButton.click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#email")));
    }

    public void leaveAnAnonymousComment(String commentText) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea.hcc")));
        replyBoxTextArea.click();
        replyBoxTextArea.sendKeys(commentText);
        sendCommentButton.click();
    }

    public void sendCommentWithoutAuth(String name, String email){
        authFormNameField.sendKeys(name);
        authFormEmailField.sendKeys(email);
        authFormSendButton.click();
    }
}
