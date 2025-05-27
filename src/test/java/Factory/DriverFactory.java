package Factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v133.network.Network;
import org.openqa.selenium.devtools.v133.network.model.ConnectionType;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.Waits;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DriverFactory {
    private static WebDriver driver;
    static String path= "https://pos-staging.trolley.systems/v-25.4.11/cart?tid=066f8593-dfd3-4b9d-9df6-6892a572b2f8&n=mubarak-alkabeer-oula-82-pos-1";

    public static WebDriver createInstance(String browserName){

        switch(browserName.toLowerCase())
        {
            case "chrome":
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                prefs.put("plugins.always_open_pdf_externally", true);

                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);
                options.addArguments("--disable-save-password-bubble");
                options.addArguments("--disable-pdf-material-ui"); // might help in older versions
                options.addArguments("--disable-extensions");
                options.addArguments("--incognito");

                options.addArguments("--password-store=basic");
                options.addArguments("--no-default-browser-check");

                WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver(options);
                driver.manage().window().maximize();
                driver.get(path);
                final By checkIcon = By.xpath("//*[@id=\"suspendDialog\"]/div[2]/div/div[3]/div/div[3]/span[@class=\"status-icon ready\"]");
                Waits.waitForElementVisible(driver,checkIcon);
                return driver;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver= new FirefoxDriver();
                driver.manage().window().maximize();
                driver.get(path);
                final By checkIcon2 = By.xpath("//*[@id=\"suspendDialog\"]/div[2]/div/div[3]/div/div[3]/span[@class=\"status-icon ready\"]");
                Waits.waitForElementVisible(driver,checkIcon2);
                return driver;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.get(path);
                final By checkIcon3 = By.xpath("//*[@id=\"suspendDialog\"]/div[2]/div/div[3]/div/div[3]/span[@class=\"status-icon ready\"]");
                Waits.waitForElementVisible(driver,checkIcon3);
                return driver;

            default:
                // Preferences map
                Map<String, Object> prefs1 = new HashMap<>();
                prefs1.put("credentials_enable_service", false);
                prefs1.put("profile.password_manager_enabled", false);

                // ChromeOptions
                ChromeOptions options1 = new ChromeOptions();
                options1.setExperimentalOption("prefs1", prefs1);
                options1.addArguments("--disable-save-password-bubble");
                WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver(options1);
                driver.manage().window().maximize();
                driver.get(path);
                final By checkIcon4 = By.xpath("//*[@id=\"suspendDialog\"]/div[2]/div/div[3]/div/div[3]/span[@class=\"status-icon ready\"]");
                Waits.waitForElementVisible(driver,checkIcon4);
                return driver;
        }
    }




}
