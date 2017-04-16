package ru.pflb.blog.uxcrowd.test.ui.tests;

import org.hamcrest.MatcherAssert;
import static org.hamcrest.core.Is.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

    @BeforeMethod
    public void setUp (){
        driver = new ChromeDriver();
        softAssert = new SoftAssert();
        wait = new WebDriverWait(driver, 1000);
        uxCrowdURL = "https://uxcrowd.ru/";
        uxCrowdBlogURL = "https://uxcrowd.ru/blog";
        postURL1 = "/read/20170222T1834556644prichinypochemuliudinepolzuiutsiavas";
        driver.get(uxCrowdBlogURL);
        mainPage = new MainPOM(driver);
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
    }

    @Test
    public void openPost1() {

        mainPage.openPost1();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.header_main_block")));
        softAssert.assertEquals(driver.getCurrentUrl(),uxCrowdBlogURL + postURL1);
        softAssert.assertEquals(driver.findElement(By.cssSelector("div.header_main_block")).getText(), "4 ПРИЧИНЫ, ПОЧЕМУ ЛЮДИ НЕ ПОЛЬЗУЮТСЯ ВАШИМ МОБИЛЬНЫМ ПРИЛОЖЕНИЕМ");
        softAssert.assertAll();
    }

    @Test
    public void closePost1() throws InterruptedException {

        mainPage.openPost1();
        postPage1 = new PostPOM1(driver);
        postPage1.closePost();
        MatcherAssert.assertThat(driver.getCurrentUrl(),is (uxCrowdBlogURL));

    }
    @AfterMethod
    public void tearDown (){

        if (driver != null)
            driver.quit();
    }
}


