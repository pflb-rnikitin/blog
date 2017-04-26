package ru.pflb.blog.uxcrowd.test.ui.tests;

import org.hamcrest.MatcherAssert;
import static org.hamcrest.core.Is.is;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.mashape.unirest.http.HttpResponse;
import ru.pflb.blog.uxcrowd.test.ui.pages.MainPOM;
import ru.pflb.blog.uxcrowd.test.ui.pages.PostPOM1;
import ru.pflb.blog.uxcrowd.test.ui.pages.UXCrowdPOM;

import java.util.concurrent.TimeUnit;


public class Blog {

    private WebDriver driver;
    private SoftAssert softAssert;
    private String uxCrowdURL;
    private String uxCrowdBlogURL;
    private WebDriverWait wait;
    private Actions actions;
    private JavascriptExecutor jse;
    private MainPOM blog;
    private PostPOM1 post1;
    private UXCrowdPOM uxCrowd;

    @BeforeMethod
    public void setUp (){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        actions = new Actions(driver);
        jse = (JavascriptExecutor)driver;
        softAssert = new SoftAssert();
        uxCrowdURL = "https://uxcrowd.ru/";
        uxCrowdBlogURL = "https://uxcrowd.ru/blog";
        driver.get(uxCrowdBlogURL);
        uxCrowd = new UXCrowdPOM(driver, wait);
        blog = new MainPOM (driver, wait);
        post1 = new PostPOM1(driver, actions, wait, jse);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @Test
    public void verifyNavigatingToBlogFromUXCrowd() {
        blog.navigateToUXCrowd();
        uxCrowd.goToBlog();
        MatcherAssert.assertThat(blog.getBlogTitle(), is("Блог о пользовательском юзабилити-тестировании"));
    }

    @Test
    public void verifyBlogTitle() {
        MatcherAssert.assertThat(blog.getBlogTitle(), is("Блог о пользовательском юзабилити-тестировании"));
    }

    @Test
    public void verifyReturnToUXCrowd () {
        blog.navigateToUXCrowd();
        uxCrowd.waitUntilLoginButtonIsPresent();
        softAssert.assertEquals(uxCrowd.getCurrentURL(), uxCrowdURL);
        softAssert.assertEquals(uxCrowd.getTitle(),"Юзабилити-тестирование — первая в России краудосрсинговая площадка.");
        softAssert.assertAll();
    }

    /*
    @Test
    public void openPost2() {
        blogPage.openPost2();
        MatcherAssert.assertThat(driver.findElement(By.cssSelector("div.header_main_block")).getText(), is("ПРЕИМУЩЕСТВА НИЗКОБЮДЖЕТНЫХ ЮЗАБИЛИТИ-ТЕСТИРОВНИЙ"));
    }

    @Test
    public void openPost3() {
        blogPage.openPost3();
        MatcherAssert.assertThat(driver.findElement(By.cssSelector("div.header_main_block")).getText(), is("3 СПОСОБА УПРАВЛЯТЬ ВНИМАНИЕМ ПОСЕТИТЕЛЕЙ С ПОМОЩЬЮ ТОЧЕК ФИКСАЦИИ"));
    }

    @Test
    public void openPost4() {
        blogPage.openPost4();
        MatcherAssert.assertThat(driver.findElement(By.cssSelector("div.header_main_block")).getText(), is("10 ТИПИЧНЫХ ОШИБОК КОММЕРЧЕСКИХ САЙТОВ С ТОЧКИ ЗРЕНИЯ ЮЗАБИЛИТИ"));
    }

    @Test
    public void openPost5() {
        blogPage.openPost5();
        MatcherAssert.assertThat(driver.findElement(By.cssSelector("div.header_main_block")).getText(), is("5 ПОЛЬЗОВАТЕЛЕЙ ДЛЯ ЮЗАБИЛИТИ-ТЕСТИРОВАНИЯ: МНОГО ЭТО ИЛИ МАЛО"));
    }

    @Test
    public void openPost6() {
        blogPage.openPost6();
        MatcherAssert.assertThat(driver.findElement(By.cssSelector("div.header_main_block")).getText(), is("POP-UP СООБЩЕНИЯ: ЭФФЕКТИВНО ДЛЯ БИЗНЕСА И НЕНАВЯЗЧИВО ДЛЯ ПОЛЬЗОВАТЕЛЕЙ"));
    }

    @Test
    public void openPost7() {
        blogPage.openPost7();
        MatcherAssert.assertThat(driver.findElement(By.cssSelector("div.header_main_block")).getText(), is("ОПТИМИЗАЦИЯ ИНТЕРНЕТ-МАГАЗИНА: ПОЧЕМУ ПОКУПАТЕЛИ БРОСАЮТ СВОИ КОРЗИНЫ"));
    }

    @Test
    public void openPost8() {
        blogPage.openPost8();
        MatcherAssert.assertThat(driver.findElement(By.cssSelector("div.header_main_block")).getText(), is("МАРКЕТОЛОГ, А ЕЩЕ НЕ ТЕСТИРУЕШЬ? ВОТ ТРИ СОВЕТА, КАК НАЧАТЬ"));
    }

    @Test
    public void openPost9() {
        blogPage.openPost9();
        MatcherAssert.assertThat(driver.findElement(By.cssSelector("div.header_main_block")).getText(), is("С ЛЮБИМЫМИ НЕ РАССТАВАЙТЕСЬ: КАК НЕ ПОТЕРЯТЬ КЛИЕНТОВ В «ГОРЯЧИЙ» СЕЗОН"));
    }

    @Test
    public void openPost10() {
        blogPage.openPost10();
        MatcherAssert.assertThat(driver.findElement(By.cssSelector("div.header_main_block")).getText(), is("КЕЙС ПО ЮЗАБИЛИТИ: КАК ПОПАСТЬ В ТРЕТЬЯКОВСКУЮ ГАЛЕРЕЮ?"));
    }

*/

    @AfterMethod
    public void tearDown (){

        if (driver != null)
            driver.quit();
    }
}
