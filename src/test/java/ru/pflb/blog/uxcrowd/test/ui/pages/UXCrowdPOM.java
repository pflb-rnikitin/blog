package ru.pflb.blog.uxcrowd.test.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class UXCrowdPOM {

    @FindBy (how= How.CSS, using="a.footer-link[href='/blog']")
    WebElement blogLink;

    @FindBy (how= How.CSS, using="a.uxc_lk")
    WebElement uxCrowdLoginButton;

    private WebDriver driver;
    private WebDriverWait wait;

    public UXCrowdPOM (WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    public void goToBlog() {
        blogLink.click();
    }

    public String getCurrentURL() {
       return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void waitUntilLoginButtonIsPresent() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.uxc_lk")));
    }
}
