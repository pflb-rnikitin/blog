package ru.pflb.blog.uxcrowd.test.ui.tests;

import org.hamcrest.MatcherAssert;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.pflb.blog.uxcrowd.test.ui.pages.MainPOM;
import ru.pflb.blog.uxcrowd.test.ui.pages.PostPOM1;

import java.util.concurrent.TimeUnit;

public class Posts {

    private WebDriver driver;
    private SoftAssert softAssert;
    private String uxCrowdURL;
    private String postURL1;
    private WebDriverWait wait;
    private MainPOM mainPage;
    private PostPOM1 postPage1;
    private String uxCrowdBlogURL;
    private Actions actions;

    @BeforeMethod
    public void setUp (){
        driver = new ChromeDriver();
        softAssert = new SoftAssert();
        wait = new WebDriverWait(driver, 1000);
        uxCrowdURL = "https://uxcrowd.ru/";
        uxCrowdBlogURL = "https://uxcrowd.ru/blog";
        postURL1 = "/read/20170222T1834556644prichinypochemuliudinepolzuiutsiavas";
        driver.get(uxCrowdBlogURL + postURL1);
        postPage1 = new PostPOM1(driver);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        actions = new Actions(driver);
    }

    @Test
    public void sharePost1OnVKBySideButton() throws InterruptedException {
        //String parentHandle = driver.getWindowHandle();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        postPage1.sharePostOnVKBySideButton();
        for(String winHandle : driver.getWindowHandles()){
                driver.switchTo().window(winHandle);
            }
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector()));
        MatcherAssert.assertThat(driver.getCurrentUrl(),containsString("vk.com"));
    }

    @Test
    public void sharePost1OnTwitterBySideButton() throws InterruptedException {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        postPage1.sharePostOnTwitterBySideButton();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector()));
        MatcherAssert.assertThat(driver.getCurrentUrl(),containsString("twitter.com"));
    }

    @Test
    public void sharePost1OnFBBySideButton() throws InterruptedException {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        postPage1.sharePostOnFBBySideButton();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector()));
        MatcherAssert.assertThat(driver.getCurrentUrl(),containsString("facebook.com"));
    }

    @Test
    public void leaveATextComment () throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,5000)", "");
        String commentText = "Just another sample comment";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea.hcc")));
        postPage1.leaveAnAnonymousComment(commentText);
        driver.findElement(By.cssSelector("input.hcc[el='Nick']")).sendKeys("AnonymousTestUser");
        driver.findElement(By.cssSelector("input.hcc[el='Email']")).sendKeys("sample@email.com");
        driver.findElement(By.cssSelector("div.hc__authorization__send__txt")).click();
    }
    @Test
    public void closePost1() throws InterruptedException {
        postPage1.closePost();
        MatcherAssert.assertThat(driver.getCurrentUrl(),is (uxCrowdBlogURL));

    }
    @AfterMethod
    public void tearDown (){

        if (driver != null)
            driver.quit();
    }
}


