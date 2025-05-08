package testCases;

import Factory.DriverFactory;
import Pages.CartPage;
import base.BaseTest;
import Pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.ITestListener;
import org.testng.annotations.Test;
import utils.ElementActions;
import utils.Validation;



public class LoginTest extends BaseTest {
    @Test (priority=1)
    @Description("Login using Invalid password")
    public void unSuccessfulLoginInvalidPass() throws InterruptedException {
            new LoginPage(driver)
                    .enterUsername("mekki")
                    .enterPassword("123")
                    .clickLoginBtn();
           String actualResult=
             ElementActions.finderElement(driver, By.xpath("//*[@data-testid='toast-body'][contains(.,'Invalid Credentials')]")).getText();
        System.out.println(actualResult);
            Validation.validateEquals(actualResult,"Invalid Credentials");

    }

    @Test (priority=2)
    @Description("Login using Empty Field ")
    public void unSuccessfulLoginEmptyField() throws InterruptedException {
        new LoginPage(driver)
                .enterUsername("")
                .enterPassword("")
                .clickLoginBtn();
        String actualResult=
                ElementActions.finderElement(driver, By.xpath("//*[@id=\"username-messages\"]/div/div[text()=\"Username is required\"]")).getText();
        Validation.validateEquals(actualResult,"Username is required");

    }

    @Test (priority = 3)
    @Description ("login with Valid data ")
    public void successfulLogin() throws InterruptedException {
             new LoginPage(driver)
                .enterUsername("mekki")
                .enterPassword("123456")
                .clickLoginBtn()
                .enterCashIn("150")
                .confirmCashInBtn();
             Thread.sleep(2000);
    }
}
