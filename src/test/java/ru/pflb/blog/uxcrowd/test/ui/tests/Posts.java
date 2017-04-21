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
    private JavascriptExecutor jse;
    private String commentText;
    private String name;
    private String email;

    @BeforeMethod
    public void setUp (){
        driver = new ChromeDriver();
        actions = new Actions(driver);
        jse = (JavascriptExecutor)driver;
        softAssert = new SoftAssert();
        wait = new WebDriverWait(driver, 3);
        uxCrowdURL = "https://uxcrowd.ru/";
        uxCrowdBlogURL = "https://uxcrowd.ru/blog";
        postURL1 = "/read/20170222T1834556644prichinypochemuliudinepolzuiutsiavas";
        driver.get(uxCrowdBlogURL + postURL1);
        postPage1 = new PostPOM1(driver, actions, wait, jse);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        commentText = "Just another sample comment";
        name = "AnonymousTestUser";
        email = "sample@email.com";
    }

    @Test
    public void sharePost1OnVKBySideButton() {
        postPage1.maximizeWindow();
        postPage1.scrollPageOneTime();
        postPage1.sharePostOnVKBySideButton();
        MatcherAssert.assertThat(postPage1.getCurrentURL(),containsString("vk.com"));
    }

    @Test
    public void sharePost1OnTwitterBySideButton() {
        postPage1.maximizeWindow();
        postPage1.scrollPageOneTime();
        postPage1.sharePostOnTwitterBySideButton();
        MatcherAssert.assertThat(postPage1.getCurrentURL(),containsString("twitter.com"));
    }

    @Test
    public void sharePost1OnFBBySideButton() {
        postPage1.maximizeWindow();
        postPage1.scrollPageOneTime();
        postPage1.sharePostOnFBBySideButton();
        MatcherAssert.assertThat(postPage1.getCurrentURL(),containsString("facebook.com"));
    }

    @Test
    public void leaveATextComment () throws InterruptedException {
        postPage1.scrollPageToTheCommentSection();
        postPage1.leaveAnAnonymousComment(commentText);
        postPage1.sendCommentWithoutAuth(name, email);
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


