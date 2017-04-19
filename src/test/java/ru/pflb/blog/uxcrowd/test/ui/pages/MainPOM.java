package ru.pflb.blog.uxcrowd.test.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;
//Blog main page object model

public class MainPOM {

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

    public MainPOM (WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    public void closeBlog () {

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
