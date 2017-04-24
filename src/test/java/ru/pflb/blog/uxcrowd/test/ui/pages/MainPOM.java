package ru.pflb.blog.uxcrowd.test.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
//Blog main page object model

public class MainPOM {

    private WebDriver driver;
    private Actions actions;
    private WebDriverWait wait;
    private JavascriptExecutor jse;

    @FindBy(how= How.CSS, using="div.btn_next_uxc")
    WebElement backToUXCrowdButton;

    @FindBy(how= How.CSS, using="div.item-0")
    WebElement postButton1;

    @FindBy(how= How.CSS, using="div.item-1")
    WebElement postButton2;

    @FindBy(how= How.CSS, using="div.item-2")
    WebElement postButton3;

    @FindBy(how= How.CSS, using="div.item-3")
    WebElement postButton4;

    @FindBy(how= How.CSS, using="div.item-4")
    WebElement postButton5;

    @FindBy(how= How.CSS, using="div.item-5")
    WebElement postButton6;

    @FindBy(how= How.CSS, using="div.item-6")
    WebElement postButton7;

    @FindBy(how= How.CSS, using="div.item-7")
    WebElement postButton8;

    @FindBy(how= How.CSS, using="div.item-8")
    WebElement postButton9;

    @FindBy(how= How.CSS, using="div.item-9")
    WebElement postButton10;

    public MainPOM (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.actions = actions;
        this.wait = wait;
        this.jse = jse;

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    public String getBlogTitle () {
        return driver.getTitle();
    }

    public void navigateToUXCrowd () {
        backToUXCrowdButton.click();
    }

    public void openPost1 () {
        postButton1.click();
    }

    public void openPost2 () {
        postButton2.click();
    }

    public void openPost3 () {
        postButton3.click();
    }

    public void openPost4 () {
        postButton4.click();
    }

    public void openPost5 () {
        postButton5.click();
    }

    public void openPost6 () {
        postButton6.click();
    }

    public void openPost7 () {
        postButton7.click();
    }

    public void openPost8 () {
        postButton8.click();
    }

    public void openPost9 () {
        postButton9.click();
    }

    public void openPost10 () {
        postButton10.click();
    }
}
