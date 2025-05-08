package Pages;

import io.qameta.allure.Step;
import net.bytebuddy.matcher.ElementMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;
import utils.Scrolling;
import utils.Waits;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class TransactionPage {
    private WebDriver driver;
    //Constructor
    public TransactionPage (WebDriver driver){
        this.driver=driver;
    }
    //Locators
    private final By TransIcon = By.xpath("//nav/div/div/div/a[3][@aria-label='trans']");
    private  final By detailsButton = By.xpath("//main/div/div[3]/div/table/tbody/tr[1][contains(.,'Details')]/td[6]/button");
    private final By tabelBody=By.xpath("//main/div/div[3]/div/table/tbody");
    private  final By printBtn = By.xpath("//aside/div[2]/div/div[2]/button[2]");
    private  final By refundBtn = By.xpath("//aside/div[2]/div/div[2]/button[1]");
    private  final By itemsBtn = By.xpath("//*[@id=\"products\"]/div[1]/div/div/button");
    private final By refundBtnProcess=By.xpath("//*[@id=\"app\"]/div/div/aside/div[2]/button");
    private final By confirmRefundBtn = By.xpath("//*[@id=\"app\"]/div/div/aside/div[2]/div[2]/button[2]");
    //Locator LogOut
    private final By existBtn=By.xpath("//*/nav/div/div/div[2]/div[4]");
    private final By endOfShiftBtn=By.xpath("//*/form/div/div[2]/button[1]");
    private final By cashoutInput=By.xpath("//*/form/div/div[2]/div/div/div/div/div/div[4][contains(., 'Cash Out')]/input");
    private final By knetBalanceInput=By.xpath("//*/form/div/div[2]/div/div/div/div/div/div[4][contains(., 'Knet Balance')]/input");
    private final By confirmLogOutBtn=By.xpath("//*/form/div/div[3]/button[1]");
    //Actions
    @Step("click on Trans icon")
    public TransactionPage openTransPage(){
        ElementActions.clickElement(driver,this.TransIcon);
        return this;
    }

    @Step("select specific order")
    public TransactionPage clickOnDetailsBtn(){
        Scrolling scrolling = new Scrolling(driver);
        scrolling.scrollDownByPixels(500);   // Scroll down
        scrolling.scrollUpByPixels(300);     // Scroll up
        scrolling.scrollToTop();             // Go to top
        scrolling.scrollToBottom();// Go to bottom
        Waits.waitForElementPresent(driver,this.detailsButton);
        scrolling.scrollToElementInContainer(tabelBody,detailsButton); // Scroll to a specific element
        ElementActions.clickElement(driver,this.detailsButton);
        return this;
    }

    @Step("click on Print Btn")
    public TransactionPage printReceipt(){
        ElementActions.clickElement(driver,this.printBtn);
        try {
            Thread.sleep(4000);
            Robot robot = new Robot();
            robot.mouseMove(100, 100);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(500);
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
            Thread.sleep(1000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("click on Refund btn and refund some items")
    public void refundOrder(){
        ElementActions.clickElement(driver,this.refundBtn);
            for(int i =0;i<3;i++){
            ElementActions.clickElement(driver,this.itemsBtn);
            }
        ElementActions.clickElement(driver,this.refundBtnProcess);
        ElementActions.clickElement(driver,this.confirmRefundBtn);
        try {
            Thread.sleep(3000);
            Robot robot = new Robot();
            robot.mouseMove(100, 100);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(500);
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Step("click on Exist btn and enter cash out and knetBalance")
    public void logout(){
        ElementActions.clickElement(driver,this.existBtn);
        ElementActions.clickElement(driver,this.endOfShiftBtn);
        ElementActions.sendData(driver,this.cashoutInput,"33");
        ElementActions.sendData(driver,this.knetBalanceInput,"25");
        ElementActions.clickElement(driver,this.confirmLogOutBtn);
        try {
            Thread.sleep(4000);
            Robot robot = new Robot();
            robot.mouseMove(100, 100);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(500);
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
            Thread.sleep(1000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }




}
