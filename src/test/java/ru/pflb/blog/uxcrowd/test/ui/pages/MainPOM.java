package ru.pflb.blog.uxcrowd.test.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//Blog main page object model

public class MainPOM {

    WebElement backToUXCrowdButton;
    WebElement openArticleButton1;
    WebElement backToBlogButton;
    WebElement postButton1;

    public MainPOM (WebDriver driver) {
        backToUXCrowdButton = driver.findElement(By.cssSelector("div.btn_next_uxc"));
        postButton1 = driver.findElement(By.cssSelector("div.item-0"));
        backToBlogButton = driver.findElement(By.cssSelector("div.btn_next_uxc"));
    }


    public void closeBlog () {

        backToUXCrowdButton.click();

    }

    public void openPost1 () {

        postButton1.click();

    }
}
