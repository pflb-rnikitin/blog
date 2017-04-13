package ru.pflb.blog.uxcrowd.test.ui.tests;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.core.Is.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.HttpResponse;


public class blog {

    private HttpResponse<String> response;
    private WebDriver driver;

    @BeforeMethod
    public void setUp (){

        String uxCrowdURL = "https://uxcrowd.ru/";
        driver = new ChromeDriver();
    }

    @Test
    public void openBlog() {

        driver.get("uxCrowdURL");
        
    }

    @Test
    public void getBlogStatus () throws UnirestException {

        response = Unirest.get("https://uxcrowd.ru/blog").asString();
        MatcherAssert.assertThat(response.getStatus(), is(200));
    }

    @Test
    public void closeBlog () throws Exception {
        driver.get("https://uxcrowd.ru/blog");
        Thread.sleep(500);
        driver.findElement(By.cssSelector("div.btn_next_uxc")).click();
        MatcherAssert.assertThat(driver.getCurrentUrl(), is("https://uxcrowd.ru/"));
    }

    @AfterMethod
    public void tearDown (){

        driver.quit();
    }
}

