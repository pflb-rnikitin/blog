package ru.pflb.blog.uxcrowd.test.ui.tests;

import com.mashape.unirest.http.exceptions.UnirestException;
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
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.HttpResponse;
import ru.pflb.blog.uxcrowd.test.ui.pages.MainPOM;
import java.util.concurrent.TimeUnit;


public class Blog {

    private HttpResponse<String> response;
    private WebDriver driver;
    private SoftAssert softAssert;
    private String uxCrowdURL;
    private String uxCrowdBlogURL;
    private WebDriverWait wait;
    private MainPOM mainPage;
    private String postURL1;
    private String postURL2;
    private String postURL3;
    private String postURL4;
    private String postURL5;
    private String postURL6;
    private String postURL7;
    private String postURL8;
    private String postURL9;
    private String postURL10;

    @BeforeMethod
    public void setUp (){
        driver = new ChromeDriver();
        softAssert = new SoftAssert();
        wait = new WebDriverWait(driver, 500);
        uxCrowdURL = "https://uxcrowd.ru/";
        uxCrowdBlogURL = "https://uxcrowd.ru/blog";
        postURL1 = "/read/20170222T1834556644prichinypochemuliudinepolzuiutsiavas";
        postURL2 = "/read/20170222T181316286preimushchestvanizkobiudzhetnykhiuzab";
        postURL3 = "/read/20170222T1740407413sposobaupravliatvnimaniemposetitelei";
        postURL4 = "/read/20170328T16281885510tipichnykhoshibokkommercheskikhsait";
        postURL5 = "/read/20170328T1619303055polzovateleidliaiuzabilititestirovan";
        postURL6 = "/read/20170328T154409856popupsoobshcheniiaeffektivnodliabizne";
        postURL7 = "/read/20170328T153935476optimizatsiiainternetmagazinapochemup";
        postURL8 = "/read/20170328T153256397marketologaeshchenetestirueshvottriso";
        postURL9 = "/read/20170328T153220919sliubimyminerasstavaiteskaknepoteriat";
        postURL10 = "/read/20170328T152751081keispoiuzabilitikakpopastvtretiakovsk";

        driver.get(uxCrowdBlogURL);
        mainPage = new MainPOM(driver);
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
    }

    @Test
    public void openBlog() throws Exception {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a.footer-link[href='/blog']")));
        driver.findElement(By.cssSelector("a.footer-link[href='/blog']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.blog_logo")));
        String blogURL = driver.getCurrentUrl();
        String blogTitle = driver.getTitle();
        softAssert.assertEquals(blogURL, uxCrowdBlogURL);
        softAssert.assertEquals(blogTitle, "Блог о пользовательском юзабилити-тестировании");
        softAssert.assertAll();
    }


    @Test
    public void getBlogStatus () throws UnirestException {

        response = Unirest.get(uxCrowdURL).asString();
        MatcherAssert.assertThat(response.getStatus(), is(200));
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
    public void openPost2() {

        mainPage.openPost2();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.header_main_block")));
        softAssert.assertEquals(driver.getCurrentUrl(),uxCrowdBlogURL + postURL2);
        softAssert.assertEquals(driver.findElement(By.cssSelector("div.header_main_block")).getText(), "ПРЕИМУЩЕСТВА НИЗКОБЮДЖЕТНЫХ ЮЗАБИЛИТИ-ТЕСТИРОВНИЙ");
        softAssert.assertAll();
    }

    @Test
    public void openPost3() {

        mainPage.openPost3();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.header_main_block")));
        softAssert.assertEquals(driver.getCurrentUrl(),uxCrowdBlogURL + postURL3);
        softAssert.assertEquals(driver.findElement(By.cssSelector("div.header_main_block")).getText(), "3 СПОСОБА УПРАВЛЯТЬ ВНИМАНИЕМ ПОСЕТИТЕЛЕЙ С ПОМОЩЬЮ ТОЧЕК ФИКСАЦИИ");
        softAssert.assertAll();
    }

    @Test
    public void openPost4() {

        mainPage.openPost4();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.header_main_block")));
        softAssert.assertEquals(driver.getCurrentUrl(),uxCrowdBlogURL + postURL4);
        softAssert.assertEquals(driver.findElement(By.cssSelector("div.header_main_block")).getText(), "10 ТИПИЧНЫХ ОШИБОК КОММЕРЧЕСКИХ САЙТОВ С ТОЧКИ ЗРЕНИЯ ЮЗАБИЛИТИ");
        softAssert.assertAll();
    }

    @Test
    public void openPost5() {

        mainPage.openPost5();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.header_main_block")));
        softAssert.assertEquals(driver.getCurrentUrl(),uxCrowdBlogURL + postURL5);
        softAssert.assertEquals(driver.findElement(By.cssSelector("div.header_main_block")).getText(), "5 ПОЛЬЗОВАТЕЛЕЙ ДЛЯ ЮЗАБИЛИТИ-ТЕСТИРОВАНИЯ: МНОГО ЭТО ИЛИ МАЛО");
        softAssert.assertAll();
    }

    @Test
    public void openPost6() {

        mainPage.openPost6();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.header_main_block")));
        softAssert.assertEquals(driver.getCurrentUrl(),uxCrowdBlogURL + postURL6);
        softAssert.assertEquals(driver.findElement(By.cssSelector("div.header_main_block")).getText(), "POP-UP СООБЩЕНИЯ: ЭФФЕКТИВНО ДЛЯ БИЗНЕСА И НЕНАВЯЗЧИВО ДЛЯ ПОЛЬЗОВАТЕЛЕЙ");
        softAssert.assertAll();
    }

    @Test
    public void openPost7() {

        mainPage.openPost7();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.header_main_block")));
        softAssert.assertEquals(driver.getCurrentUrl(),uxCrowdBlogURL + postURL7);
        softAssert.assertEquals(driver.findElement(By.cssSelector("div.header_main_block")).getText(), "ОПТИМИЗАЦИЯ ИНТЕРНЕТ-МАГАЗИНА: ПОЧЕМУ ПОКУПАТЕЛИ БРОСАЮТ СВОИ КОРЗИНЫ");
        softAssert.assertAll();
    }

    @Test
    public void openPost8() {

        mainPage.openPost8();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.header_main_block")));
        softAssert.assertEquals(driver.getCurrentUrl(),uxCrowdBlogURL + postURL8);
        softAssert.assertEquals(driver.findElement(By.cssSelector("div.header_main_block")).getText(), "МАРКЕТОЛОГ, А ЕЩЕ НЕ ТЕСТИРУЕШЬ? ВОТ ТРИ СОВЕТА, КАК НАЧАТЬ");
        softAssert.assertAll();
    }

    @Test
    public void openPost9() {

        mainPage.openPost9();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.header_main_block")));
        softAssert.assertEquals(driver.getCurrentUrl(),uxCrowdBlogURL + postURL9);
        softAssert.assertEquals(driver.findElement(By.cssSelector("div.header_main_block")).getText(), "С ЛЮБИМЫМИ НЕ РАССТАВАЙТЕСЬ: КАК НЕ ПОТЕРЯТЬ КЛИЕНТОВ В «ГОРЯЧИЙ» СЕЗОН");
        softAssert.assertAll();
    }

    @Test
    public void openPost10() {

        mainPage.openPost10();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.header_main_block")));
        softAssert.assertEquals(driver.getCurrentUrl(),uxCrowdBlogURL + postURL10);
        softAssert.assertEquals(driver.findElement(By.cssSelector("div.header_main_block")).getText(), "КЕЙС ПО ЮЗАБИЛИТИ: КАК ПОПАСТЬ В ТРЕТЬЯКОВСКУЮ ГАЛЕРЕЮ?");
        softAssert.assertAll();
    }


    @Test
    public void closeBlog () throws Exception {
        driver.navigate().to(uxCrowdBlogURL);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.btn_next_uxc")));
        mainPage.closeBlog();
        Thread.sleep(590);
        softAssert.assertEquals(driver.getCurrentUrl(), uxCrowdURL);
        softAssert.assertEquals(driver.getTitle(),"Юзабилити-тестирование — первая в России краудосрсинговая площадка.");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown (){

        if (driver != null)
            driver.quit();
    }
}
