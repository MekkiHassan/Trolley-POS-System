package testCases;


import Pages.CartPage;
import Pages.LoginPage;
import base.BaseTest;

import org.testng.annotations.Test;


import java.awt.*;


public class CartTest extends BaseTest {


    @Test (priority =1 )
    public void cashOrder() throws InterruptedException, AWTException {

          Thread.sleep(2000 );
                new CartPage(driver)
                .addItemsToCart()
                .completeOrder()
                .paymentCashMethod();

    }

    @Test(priority = 2)
    public void manualK_NetOrder() throws InterruptedException, AWTException {
                new CartPage(driver)
                .addItemsToCart()
                .completeOrder()
                .paymentK_netMethod();
    }

    @Test(priority = 3)
    public void splitPaymentOrder() throws InterruptedException {
        new CartPage(driver)
                .addItemsToCart()
                .completeOrder()
                .splitPayment();
    }

    @Test (priority = 4)
    public void orderWithCoupon() throws InterruptedException, AWTException {
        new CartPage(driver)
                .addItemsToCart()
                .completeOrder()
                .orderUsingCoupon()
                .paymentCashMethod();
    }

    @Test(priority = 5)
    public void orderUsingLoyalty() throws InterruptedException, AWTException {
        new CartPage(driver)
                .addItemsToCart()
                .orderWithLoyalty()
                .completeOrder()
                .paymentCashMethod();

    }

    @Test(priority = 6)
    public void voidSale() throws InterruptedException {
        new CartPage(driver)
                .addItemsToCart()
                .voidSale();
    }

    @Test(priority = 7)
    public void cancelSuspendAndVoidBtn() throws InterruptedException {

        new CartPage(driver)
                .addItemsToCart()
                .cancelSuspendAndVoid();
    }

    @Test (priority = 8)
    public void suspendCart() throws InterruptedException {
        new CartPage(driver)
                .suspendProcess();
    }


}
