package ru.pflb.blog.uxcrowd.test.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public PostPOM1(WebDriver driver) {

        PageFactory.initElements(driver,this);
    }

    public void closePost () {

        backToBlogButton.click();
    }

    public void sharePostOnVKBySideButton () {
        sideVKShareButton.click();
    }

    public void sharePostOnTwitterBySideButton () {
        sideTwitterShareButton.click();
    }

    public void sharePostOnFBBySideButton () {
        sideFBShareButton.click();
    }
}
