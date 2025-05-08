package Pages;

import io.qameta.allure.Step;
import net.bytebuddy.matcher.ElementMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import utils.ElementActions;
import utils.Listener;
import utils.Waits;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class CartPage {
    //Constructor
    private WebDriver driver;


    public CartPage (WebDriver driver){
        this.driver=driver;

    }
    //Dialog Locator
  private final By dialogVersion = By.xpath("//*[@id=\"suspendCard\"]/div[4]/div[2]/button[2]/span[3][text()=\"Update\"]");
    //Locators for Water Category
    private final By waterCategory = By.xpath("//*[@id='app']/div/div/main/div/div[2]/div[1]/p");
    private  final By wateritem = By.xpath("//*[@id='products']/div[1]/div/div/button");
    private final By wateritem2 = By.xpath("//*[@id='products']/div[2]/div/div/button");
    private final By wateritem3 = By.xpath("//*[@id='products']/div[3]/div/div/button");

    //Locators for Other Category
    private final By otherCategory = By.xpath("//*[@id='app']/div/div/main/div/div[2]/div[2]/p");
    private final By otherItem = By.xpath("//aside/div[2]/div/div/div[1]/div[2]/div/div[1]/div/div/button");

    //locator btn for Process payment and confirm
    private  final By processBtn=By.xpath("//*[@id=\"app\"]/div/div/aside/div[2]/div/div[1]/div[3]/div[3]/button");
    private  final By confirmBtn=By.xpath("//*[@id=\"app\"]/div/div/aside/div[2]/div/div[1]/div[3]/div[3]/div[2]/button[2]/span[3]");

    //Locator for payment method and totalDue
    private  final By cashMethod=By.xpath("//*[@id=\"checkoutBtn\"]/span[3][contains(., 'Cash')]");
    private final By cashField=By.xpath("//aside/div[2]/div/div[3]/div/div[1]/div[2]/div/div[3]/div[2]/div/div/div/div[3]/input[@aria-label=\"Amount\"]");

    private  final By knetMethod=By.xpath("//*[@id=\"checkoutBtn\"][3]/span[3]/div/div[2]/p[text()=\"Manual Card\"]");
    private final By authField=By.xpath("//aside/div[2]/div/div[3]/div/div[1]/div[2]/div/div[3]/div[2]/div/div/div/div[3]/input");
//Suspend locators
    private final By completeBtn=By.xpath("//aside/div[2]/div[1]/div[3]/div[1]/div[2]/button[2]");
    private final By suspendBtn=By.xpath("//aside/div[2]/div/div[1]/div[3]/div[3]/div/button[2]/span[3]/div/p[text()=\"Suspend\"]");
    private final By suspendConfirmBtn=By.xpath("//div/div/div[2]/div/div[4]/div/button[1]/span[3]");
    private final By cancelBtnSuspend=By.xpath("//*[@id=\"suspendCard\"]/div[2]/div/div/div/div/button");
//Void locators
    private final By voidSaleBtn= By.cssSelector("button[aria-label='void_sale']");
    private final By voidSaleConfirm = By.xpath("//*[@id=\"suspendCard\"]/div[4]/div/button[1]");
    private final By cancelVoidBtn=By.xpath("//*[@id=\"suspendCard\"]/div[2]/div/div/div/div/button");
//Membership
    private final  By loyaltyMembership1= By.xpath("//aside/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div/div/div[3]/input");
//Split payment locators
    private final By splitPaymentBtn=By.xpath("//*/aside[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div/div[2]/div/div");
    private final By splitKnetMethod=By.xpath("//*/aside/div[2]/div/div[3]/div/div[1]/div[2]/div/div[3]/div[1]/button[2]");
    private final By splitCashMethod=By.xpath("//*/aside/div[2]/div/div[3]/div/div[1]/div[2]/div/div[3]/div[1]/button[1]");
    private final By addBTN_CashAmount=By.xpath("//*/aside/div[2]/div/div[3]/div/div[1]/div[2]/div/div[3]/div[2]/div/div/div/div[4]/button");
    private final By authIdInSplit= By.xpath("/html/body/div[1]/div/div/aside/div[2]/div/div[3]/div/div[1]/div[2]/div/div[3]/div[2]/div[1]/div/div/div[3]/input");
   private final By addBTN_knetAmount=By.xpath("/html/body/div[1]/div/div/aside/div[2]/div/div[3]/div/div[1]/div[2]/div/div[3]/div[2]/div[2]/div/div/div[4]/button");
   //Locators for coupon
    private final By selectCouponFeature=By.xpath("//*/aside/div[2]/div/div[3]/div/div/div/div[2]/div/div/div/button[contains(., ' Select Coupon ')]");
   private  final By selectCoupon=By.xpath("//*/aside/div[2]/div/div[2]/div/div[2]/div/div/div/div[contains(., 'Aut')]/button");
   private final By selectSpecificApplyBtn=By.xpath("//*/aside/div[2]/div/div[2]/div/div[2]/div/div/div/div[2]/button");
   private final By selectConfirmCoupon=By.xpath("//*/aside/div[2]/div/div[2]/div/div[5]/button");
   // Actions
    @Step("Add some items to cart")
    public  CartPage addItemsToCart() throws InterruptedException {
        Thread.sleep(2000);
        //select  from water category
        Waits.waitForElementClickable(driver,this.waterCategory);
        ElementActions.clickElement(driver,this.waterCategory);
        for(int i = 0;i<4;i++){
                  ElementActions.clickElement(driver,this.wateritem);
                  ElementActions.clickElement(driver,this.wateritem2);
                  ElementActions.clickElement(driver,this.wateritem3);
              }
         //select another category
            ElementActions.clickElement(driver,this.otherCategory);
        //select from another category
            for(int i = 0;i<4;i++){
                ElementActions.clickElement(driver,this.otherItem);
            }
          return this;
    }

    @Step("Click on Proceed payment and Confirm btn")
    public CartPage completeOrder(){
        ElementActions.clickElement(driver,this.processBtn);
        ElementActions.clickElement(driver,this.confirmBtn);
        return this;
    }

    @Step("Select Cash Payment method and pay using it")
    public CartPage paymentCashMethod() throws AWTException, InterruptedException {
        ElementActions.clickElement(driver,this.cashMethod);
        String totalDue=
          driver.findElement( By.xpath("//main/div/div[5]/div/div[5]/p[2]")).getText();
        ElementActions.sendData(driver,this.cashField,totalDue);
        ElementActions.clickElement(driver,this.completeBtn);
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
         return this;// Allow time for dialog to close
    }

    @Step("Select KNET Payment method and pay using it")
    public void paymentK_netMethod() throws AWTException, InterruptedException {
        Thread.sleep(3000);
        //select Manual K-NET method
        ElementActions.clickElement(driver,this.knetMethod);
        //send auth for K-net field
        ElementActions.sendData(driver,this.authField,"123KNET");
        ElementActions.clickElement(driver,this.completeBtn);
        try {
            Thread.sleep(2000);
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

    @Step("Select Split Payment method and pay using it")
    public void splitPayment() throws InterruptedException {
        Thread.sleep(2000);
        //Select Split payment and click on cash and knet method
        ElementActions.clickElement(driver,this.splitPaymentBtn);
        ElementActions.clickElement(driver,this.splitCashMethod);
        ElementActions.sendData(driver,this.cashField,"3.5");
        ElementActions.clickElement(driver,this.addBTN_CashAmount);
        ElementActions.clickElement(driver,this.splitKnetMethod);
        ElementActions.sendData(driver,this.authIdInSplit,"123KNET");
        ElementActions.clickElement(driver,this.addBTN_knetAmount);
        ElementActions.clickElement(driver,this.completeBtn);
        //skip the receipt
        try {
            Thread.sleep(2000);
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

    @Step("Make an order using Coupon and Cash Payment method and pay using it")
    public CartPage orderUsingCoupon() throws InterruptedException {
        ElementActions.clickElement(driver,this.selectCouponFeature);
        WebElement element = ElementActions.finderElement(driver, By.xpath("//*/aside/div[2]/div/div[2]/div/div[2]/div/div/div/div[contains(., 'Aut')]"));
        if (element.isDisplayed()) {
        ElementActions.clickElement(driver, this.selectCoupon);
        ElementActions.clickElement(driver, this.selectSpecificApplyBtn);
        Thread.sleep(2000);
        ElementActions.clickElement(driver, this.selectConfirmCoupon);
            return this;
    }
    return this;
    }

    @Step("Select suspend btn and Confirm  ")
    public CartPage suspendProcess() throws InterruptedException {
        Thread.sleep(3000);
            ElementActions.clickElement(driver,this.suspendBtn);
            ElementActions.clickElement(driver,this.suspendConfirmBtn);
        return this;
    }

    @Step("Click On void btn and Confirm ")
    public void voidSale()throws InterruptedException {
        Thread.sleep(2000);
        ElementActions.clickElement(driver,this.voidSaleBtn);
        ElementActions.clickElement(driver,this.voidSaleConfirm);
        Thread.sleep(2000);
    }

    @Step("Select Suspend and Void btn and Cancel it")
    public void cancelSuspendAndVoid()throws InterruptedException {
        Thread.sleep(3000);
        ElementActions.clickElement(driver,this.suspendBtn);
        ElementActions.clickElement(driver,this.cancelBtnSuspend);
        ElementActions.clickElement(driver,this.voidSaleBtn);
        ElementActions.clickElement(driver,this.cancelVoidBtn);
    }

    @Step("using the Loyalty member ship")
    public CartPage orderWithLoyalty() throws InterruptedException {
        ElementActions.sendData(driver,this.loyaltyMembership1,"50000005");
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        WebElement slider = driver.findElement(By.xpath("//aside/div[2]/div/div/div[2]/div[3]/div/div[4]/div/div/div[2][@role='slider']"));
        actions.clickAndHold(slider).moveByOffset(100, 0).release().perform();
return this;
}







}
