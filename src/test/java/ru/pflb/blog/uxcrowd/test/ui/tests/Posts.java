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
    private MainPOM blogPage;
    private PostPOM1 post1;
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
        wait = new WebDriverWait(driver, 10);
        uxCrowdURL = "https://uxcrowd.ru/";
        uxCrowdBlogURL = "https://uxcrowd.ru/blog";
        postURL1 = "/read/20170222T1834556644prichinypochemuliudinepolzuiutsiavas";
        driver.get(uxCrowdBlogURL);
        blogPage = new MainPOM(driver, wait);
        post1 = new PostPOM1(driver, actions, wait, jse);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        commentText = "Just another sample comment";
        name = "AnonymousTestUser";
        email = "sample@email.com";
    }

    @Test
    public void verifyPost1SharingOnVKBySideButton() {
        blogPage.openPost1();
        post1.maximizeWindow();
        post1.scrollPageOneTime();
        post1.sharePostOnVKBySideButton();
        MatcherAssert.assertThat(post1.getCurrentURL(),containsString("vk.com"));
    }

    @Test
    public void verifyPost1SharingOnTwitterBySideButton() {
        blogPage.openPost1();
        post1.maximizeWindow();
        post1.scrollPageOneTime();
        post1.sharePostOnTwitterBySideButton();
        MatcherAssert.assertThat(post1.getCurrentURL(),containsString("twitter.com"));
    }

    @Test
    public void verifyPost1SharingOnFBBySideButton() {
        blogPage.openPost1();
        post1.maximizeWindow();
        post1.scrollPageOneTime();
        post1.sharePostOnFBBySideButton();
        MatcherAssert.assertThat(post1.getCurrentURL(),containsString("facebook.com"));
    }

    @Test
    public void verifyATextCommentLeaving() throws InterruptedException {
        blogPage.openPost1();
        post1.waitUntilHeaderIsPresent();
        post1.scrollPageToTheCommentSection();
        post1.leaveAnAnonymousComment(commentText);
        post1.sendCommentWithoutAuth(name, email);
    }

    @Test
    public void verifyReturnToBlogFromPost1() {
        blogPage.openPost1();
        post1.closePost();
        MatcherAssert.assertThat(driver.getCurrentUrl(),is (uxCrowdBlogURL));
    }

    @AfterMethod
    public void tearDown (){
        if (driver != null)
            driver.quit();
    }
}


