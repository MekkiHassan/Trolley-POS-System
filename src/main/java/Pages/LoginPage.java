package Pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;

public class LoginPage {
    //Variables
    private final WebDriver driver;
    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    //Locators
    private final By username   = By.id("username");
    private final By password   = By.id("password");
    private final By submit     = By.xpath("//form/button[@type='submit']");
    private final By cashField  = By.xpath("//form/div/div/div/div[3]/input");
    private final By confirmCashBtn = By.xpath("//form/button/span[3][text()=\"confirm\"]");
    private final By confirmSyncBtn = By.xpath("//*[@id=\"suspendCard\"]/div[3]/div/div[8]/button[2]");


    //Actions
    public LoginPage  waitSync() {
       driver.findElement(confirmSyncBtn).click();
        return this;
    }
    @Step("Enter user name: {username}")
    public LoginPage enterUsername(String username) {
        ElementActions.sendData(driver, this.username, username);
        return this;
    }
    @Step("Enter  password: {password}")
    public LoginPage enterPassword(String password) {
        ElementActions.sendData(driver, this.password, password);
        return this;
    }
    @Step("Click on Login BTN")
    public LoginPage clickLoginBtn() {
        ElementActions.clickElement(driver, this.submit);
        return this;
    }
    @Step("Enter your cash:{money}")
    public LoginPage enterCashIn(String money) {
        ElementActions.sendData(driver, cashField, money);
        return this;
    }
    @Step("Click on confirm cash Btn")
    public void confirmCashInBtn() {
        ElementActions.clickElement(driver, confirmCashBtn);
    }




}
