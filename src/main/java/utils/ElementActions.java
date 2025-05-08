package utils;

import org.openqa.selenium.*;

public class ElementActions {

    public static void sendData(WebDriver driver, By locator, String data) {
        Waits.waitForElementPresent(driver, locator);
        finderElement(driver,locator).click();
        // Assuming 'driver' is your WebDriver instance and 'locator' is your By object for the element.
        WebElement input = driver.findElement(locator);
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
        finderElement(driver,locator).sendKeys(data);
    }

    public static void clickElement(WebDriver driver, By locator) {
        Waits.waitForElementClickable(driver, locator);
        driver.findElement(locator).click();
    }
    public static WebElement finderElement(WebDriver driver, By locator){
        Waits.waitForElementPresent(driver, locator);
        return driver.findElement(locator);
    }
}
