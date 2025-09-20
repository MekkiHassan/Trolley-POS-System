package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.PropertiesUtils;
import utils.Waits;
import java.time.Duration;

public class test {
    private final By password   = By.id("password");
    private final By confirmSyncBtn = By.xpath("//*[@id=\"suspendCard\"]/div[3]/div/div[8]/button[2]");
   private final By username   = By.xpath("//*/div/div/div/div[2]/div/div[2]/form//input[@id='username']");
   private final By checkIcon = By.xpath("//*[@id=\"suspendDialog\"]/div[2]/div/div[3]/div/div[3]/span[@class=\"status-icon ready\"]");

  @Test
 public void testlog(){
        PropertiesUtils.loadJson("D:\\TrolleyPOS_AutomationTest\\src\\test\\resources\\TestData.json");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PropertiesUtils.getJsonValue("path"));
      Waits.waitForElementClickable(driver,checkIcon);
        driver.findElement(confirmSyncBtn).click();

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(username));
      element.click();
     element.sendKeys("mekki222");

         // أو من locator username بتاعك
        /*   Actions actions = new Actions(driver);
        actions.doubleClick(userField).sendKeys("mekki222").perform();*/
        /*ElementActions.sendData(driver, username,
                        PropertiesUtils
                        .getJsonValue("login-invalid-credentials.username"));
 */
  }

}


