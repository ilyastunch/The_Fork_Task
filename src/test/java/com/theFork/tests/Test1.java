package com.theFork.tests;

import com.theFork.POM.dashBoardPage.DashBoardPage_Actions;
import com.theFork.POM.loginPage.LoginPage_Actions;
import com.theFork.POM.myProfilePage.MyProfilePage_Actions;
import com.theFork.utilities.ConfigurationReader;
import com.theFork.utilities.Log;

public class Test1 extends TestBase{
    LoginPage_Actions loginPage_actions = new LoginPage_Actions();
    DashBoardPage_Actions dashBoardPage_actions = new DashBoardPage_Actions();
    MyProfilePage_Actions myProfilePage_actions = new MyProfilePage_Actions();


    /**
     * This test method handle reCAPTCHA issue partially
     * When meet image-based captcha, this fails
     */
    @org.testng.annotations.Test(retryAnalyzer = RetryAnalyzer.class)
    public void test() {

        Log.info("I navigate to https://www.thefork.com/");
        loginPage_actions.goToUrl(ConfigurationReader.get("url"));

        Log.info("I handle reCAPTCHA");
        loginPage_actions.handleReCaptcha();

        Log.info("I accept cookies");
        loginPage_actions.acceptCookies();

        Log.info("I login to application");
        loginPage_actions.loginToApplication();

        Log.info("I go to My personal information menu");
        dashBoardPage_actions.navigateToMenus("My personal information");

        Log.info("I verify my information is true");
        myProfilePage_actions.verifyGender();
        myProfilePage_actions.verifyFirstname("TheFork");
        myProfilePage_actions.verifyLastname("Task");
        myProfilePage_actions.verifyPhoneNumber("5538745252");
        myProfilePage_actions.verifyBirthDate("1 January 1990");
    }
}
