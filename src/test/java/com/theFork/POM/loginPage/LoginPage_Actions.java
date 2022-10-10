package com.theFork.POM.loginPage;


import com.theFork.utilities.BrowserUtils;
import com.theFork.utilities.ConfigurationReader;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.List;


public class LoginPage_Actions extends LoginPage_Locator {

    BrowserUtils utils = new BrowserUtils();

    public void goToUrl(String url) {
        utils.navigateToURL(url);
    }

    public void acceptCookies() {
        try {
            utils.click(ACCEPT_COOKIE_BTN_LOC);
        } catch (WebDriverException e) {
            utils.click(ACCEPT_COOKIE_BTN_LOC);
            e.printStackTrace();
        }
    }

    public void loginToApplication() {
        utils.click(LOGIN_BUTTON_LOC);
        utils.waitFor(2);
        utils.enterText(EMAIL_INPUT_LOC, ConfigurationReader.get("email"));
        utils.click(CONTINUE_BTN_LOC);
        utils.waitFor(2);
        utils.enterText(PASSWORD_INPUT_LOC, ConfigurationReader.get("password"));
        utils.click(SUBMIT_PASSWORD_LOC);
    }

    public void handleReCaptcha() {
        List<WebElement> frameElements = utils.findElements(CAPTCHA_1ST_FRAME_LOC);

        if (frameElements.size() == 0) {
            return;
        } else {
            utils.switchToFrame(CAPTCHA_1ST_FRAME_LOC);
            utils.switchToFrame(CAPTCHA_2ND_FRAME_LOC);
            utils.click(CAPTCHA_CHECKBOX_LOC);
        }
    }
}
