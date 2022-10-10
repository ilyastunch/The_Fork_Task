package com.theFork.POM.myProfilePage;

import com.theFork.utilities.BrowserUtils;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MyProfilePage_Actions extends MyProfilePage_Locators{

    BrowserUtils utils = new BrowserUtils();

    public void verifyGender(){
        Assert.assertTrue(utils.findElement(GENDER_MALE_LOC).isSelected());
    }

    public void verifyFirstname(String firstname){
        Assert.assertEquals(utils.getValue(FIRST_NAME_LOC), firstname);
    }

    public void verifyLastname(String lastname){
        Assert.assertEquals(utils.getValue(LAST_NAME_LOC), lastname);
    }

    public void verifyPhoneNumber(String number){
        Assert.assertEquals(utils.getValue(PHONE_NUMBER_LOC), number);
    }
    public void verifyBirthDate(String date){
        Select select = new Select(utils.findElement(BIRTH_MONTH_LOC));
        String day = utils.getValue(BIRTH_DAY_LOC);
        String year = utils.getValue(BIRTH_YEAR_LOC);
        String month = select.getFirstSelectedOption().getText();
        String fullDate = day +" "+ month +" "+ year;
        Assert.assertEquals(fullDate, date);

    }
}
