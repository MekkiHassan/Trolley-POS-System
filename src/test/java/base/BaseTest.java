package base;

import Factory.DriverFactory;
import Pages.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.Listener;

public class BaseTest {
    protected static WebDriver driver;
    private  Listener listener;
    private String testClassName;
    @BeforeSuite
    public void setupDriver() {
      driver = DriverFactory.createInstance("chrome");
        new LoginPage(driver).waitSync();

    }

    @BeforeMethod
    @Step("Initialize test environment")
    public void setupTest() {
      testClassName = this.getClass().getSimpleName();
        System.out.println("Initializing Listener for: " + testClassName);
        // Stop existing listener if any
        if (listener != null) {
            listener.stopListener();
        }
        listener = new Listener(driver, testClassName);
        listener.start();
    }

    @AfterMethod
    public void tearDownTest() {
        if (listener != null) {
            listener.stopListener();
            listener = null;
        }
    }

    @AfterSuite
    @Step("close the session after test class")
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);
        driver.close();
    }


}
