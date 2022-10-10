package com.theFork.utilities;

import com.theFork.tests.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TimeZone;

public class BrowserUtils extends TestBase {

    /**
     * go to url
     * @param url
     */
    public void navigateToURL(String url) {
        Driver.get().get(url);
    }

    /**
     * find element
     * @param by locator
     * @return WebElemenr
     */
    public WebElement findElement(By by) {
        WebElement element = Driver.get().findElement(by);
        return element;
    }

    /**
     * find list of webElement
     * @param by locator
     * @return list of WebElement
     */
    public List<WebElement> findElements(By by) {
        List<WebElement> elements = Driver.get().findElements(by);
        return elements;
    }

    /**
     * find a webElement by its text
     * @param by locator
     * @param text string
     * @return WebElement
     */
    public WebElement findElementByText(By by, String text) {
        List<WebElement> elements = Driver.get().findElements(by);
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                return element;
            }
        }
        throw new NoSuchElementException(
                String.format("Could not found element containing text %s by locator %s", text, by.toString()));
    }

    /**
     * enter a string into an input
     * @param by locator
     * @param text string
     */
    public void enterText(By by, String text) {
        findElement(by).clear();
        findElement(by).sendKeys(text);
    }

    /**
     * click an element
     * @param by locator
     */
    public void click(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }

    /**
     * wait until page load
     */
    public void waitForPageToLoad() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) Driver.get()).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
             wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    /**
     * Explicitly wait until element is clickable
     * @param by locator
     */
    public void waitForElementClickable(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * Get a value of an attribute and convert it string
     * @param by locator
     * @return string
     */
    public String getValue(By by){
        return findElement(by).getAttribute("value").trim();
    }

    /**
     * wait by Thread.sleep
     * @param seconds time
     */
    public void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * click with javaScriptExecutor method
     * @param by Locator
     */
    public void clickWithJS (By by) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", findElement(by));
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", findElement(by));
    }

    /**
     * switch among frames
     * @param by locator
     */
    public void switchToFrame(By by) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }

    /**
     * This method retries cookies (belong to different session) from files and adds new session
     */
    public void addCookiesFromFile(){
        try{
            File file = new File("Cookies.data");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String strline;
            while((strline=bufferedReader.readLine())!=null){
                StringTokenizer token = new StringTokenizer(strline,";");
                while(token.hasMoreTokens()){
                    String name = token.nextToken();
                    String value = token.nextToken();
                    String domain = token.nextToken();
                    String path = token.nextToken();
                    Date expiry = null;

                    String val;
                    if(!(val=token.nextToken()).equals("null"))
                    {
                        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss ZZZ yyyy");
                        formatter.setTimeZone(TimeZone.getTimeZone("EET"));
                        expiry = formatter.parse(val);
                    }
                    boolean isSecure = Boolean.parseBoolean(token.nextToken());
                    Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);
                    try{
                        Driver.get().manage().addCookie(ck);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
