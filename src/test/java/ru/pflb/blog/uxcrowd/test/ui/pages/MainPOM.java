package ru.pflb.blog.uxcrowd.test.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
//Blog main page object model

public class MainPOM {

    @FindBy(how= How.CSS, using="div.btn_next_uxc")
    WebElement backToUXCrowdButton;

    @FindBy(how= How.CSS, using="div.item-0")
    WebElement postButton1;

    public MainPOM (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void closeBlog () {

        backToUXCrowdButton.click();

    }

    public void openPost1 () {

        postButton1.click();

    }
}
