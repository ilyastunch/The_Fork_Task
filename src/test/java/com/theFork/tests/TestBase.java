package com.theFork.tests;


import com.theFork.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;


public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(15));

    @BeforeTest
    public void setUpTest(){ }

    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterMethod
    public void tearDown(){
       Driver.closeDriver();
    }

    @AfterTest
    public void tearDownTest(){  }
}
