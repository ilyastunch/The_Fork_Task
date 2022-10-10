package com.theFork.POM.loginPage;

import com.theFork.tests.TestBase;
import org.openqa.selenium.By;

public class LoginPage_Locator extends TestBase {

    public final By LOGIN_BUTTON_LOC = By.cssSelector("[data-testid='user-space']");
    public final By EMAIL_INPUT_LOC = By.id("identification_email");
    public final By CONTINUE_BTN_LOC = By.cssSelector("button[data-testid='checkout-submit-email']");
    public final By PASSWORD_INPUT_LOC = By.id("password");
    public final By SUBMIT_PASSWORD_LOC = By.cssSelector("button[data-testid='submit-password']");
    public final By ACCEPT_COOKIE_BTN_LOC = By.id("_evidon-accept-button");
    public final By CAPTCHA_1ST_FRAME_LOC = By.xpath("//iframe[contains(@src,'https://geo.captcha-delivery.com/')]");
    public final By CAPTCHA_2ND_FRAME_LOC = By.xpath("//iframe[@title='reCAPTCHA']");
    public final By CAPTCHA_CHECKBOX_LOC = By.id("recaptcha-anchor");

}
