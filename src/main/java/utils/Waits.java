package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private WebDriver driver;

    public static WebElement waitForElementPresent(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement waitForElementVisible(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(driver1 -> {
                            WebElement element = waitForElementPresent(driver, locator);
                            return element.isDisplayed() ? element : null;
                        }
                );
    }

    public static WebElement waitForElementClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(50)).
                until(driver1 -> {
                            WebElement element = waitForElementVisible(driver, locator);
                            return element.isEnabled() ? element : null;
                        }
                );

    }
}
