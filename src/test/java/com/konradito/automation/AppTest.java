package com.konradito.automation;

import com.gargoylesoftware.htmlunit.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.xml.transform.Result;

public class AppTest
{
    WebDriver driver;
    IndexPage indexPage;
    ResultPage resultPage;

    @BeforeTest
    public void setup(){
    DesiredCapabilities capability = DesiredCapabilities.firefox();
    System.setProperty("webdriver.gecko.driver", "D:\\Projects\\automation\\geckodriver.exe");
    capability.setCapability("marionette", true);
    driver = new FirefoxDriver();
    driver.get("https://www.wikipedia.org");
    driver.manage().window().maximize();
    //making suite-selenium-page connection
    indexPage = PageFactory.initElements(driver, IndexPage.class);
    resultPage = PageFactory.initElements(driver, ResultPage.class);
    }

    @AfterTest
    public void shutdown(){
        driver.quit();
    }

    @Test
    public void test1(){
        Assert.assertTrue(indexPage.getSourceOfHeadlineLogo().contains("Wikipedia_wordmark.png"),"error kurwa");
    }

    @Test
    public void test2(){
        indexPage.makeSearch("Polska");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("Poland", resultPage.getSourceOfFirstHeading());
    }
//Change the language from enlish to polish
}
