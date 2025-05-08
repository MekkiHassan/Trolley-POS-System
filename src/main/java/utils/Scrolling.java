package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Scrolling {
    private WebDriver driver;
    public Scrolling(WebDriver driver) {
        this.driver = driver;
    }
    public void scrollToElementInContainer(By containerLocator, By elementLocator) {

        WebElement container = driver.findElement(containerLocator);
        WebElement element = driver.findElement(elementLocator);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollTop = arguments[1].offsetTop;",
                container, element);
    }
    // Scroll down by pixels
    public void scrollDownByPixels(int pixels) {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollBy(0," + pixels + ");");
    }

    // Scroll up by pixels
    public void scrollUpByPixels(int pixels) {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollBy(0,-" + pixels + ");");
    }

    // Scroll to the bottom of the page
    public void scrollToBottom() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    // Scroll to the top of the page
    public void scrollToTop() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, 0);");
    }
}
