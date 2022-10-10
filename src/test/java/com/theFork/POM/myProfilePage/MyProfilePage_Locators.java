package com.theFork.POM.myProfilePage;

import com.theFork.tests.TestBase;
import org.openqa.selenium.By;

public class MyProfilePage_Locators extends TestBase {
    public final By GENDER_MALE_LOC = By.xpath("(//input[@name='gender'])[1]");
    public final By GENDER_FEMALE_LOC =  By.xpath("(//input[@name='gender'])[2]");
    public final By FIRST_NAME_LOC = By.xpath("//input[@name='firstName']");
    public final By LAST_NAME_LOC = By.xpath("//input[@name='lastName']");
    public final By PHONE_NUMBER_LOC = By.xpath("//input[@name='phoneNumber.nationalNumber']");

    public final  By BIRTH_DAY_LOC = By.xpath("//input[@name='birthDate.day']");
    public final By BIRTH_MONTH_LOC = By.xpath("//select[@name='birthDate.month']");
    public final By BIRTH_YEAR_LOC = By.xpath("//input[@name='birthDate.year']");

}
