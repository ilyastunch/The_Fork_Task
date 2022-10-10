package com.theFork.POM.basePage;

import com.theFork.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage_Actions extends BasePage_Locators {

    BrowserUtils utils = new BrowserUtils();

    public void navigateToMyAccount(){
        utils.waitForPageToLoad();
        utils.waitForElementClickable(MY_ACCOUNBTN_LOC);
        utils.clickWithJS(MY_ACCOUNBTN_LOC);
    }
    public void navigateToMenus(String menu){
        utils.waitForPageToLoad();
        utils.waitFor(3);
        utils.findElementByText(MENUS_LOC, menu).click();


    }
}
