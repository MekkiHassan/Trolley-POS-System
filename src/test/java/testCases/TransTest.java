package testCases;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.TransactionPage;
import base.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import java.awt.*;

public class TransTest extends BaseTest {



    @Test (priority = 1)
    @Description("Click on Trans Icon to show all transactions")
    public void showTransaction() throws InterruptedException, AWTException {

        Thread.sleep(3000);
        new CartPage(driver)
                .addItemsToCart()
                .completeOrder()
                .paymentCashMethod();
        new TransactionPage(driver).openTransPage();
    }

    @Test (priority = 2)
    @Description("refund specific transactions")
    public void refundProcess(){
        new TransactionPage(driver)
                .clickOnDetailsBtn()
                .printReceipt()
                .refundOrder();
    }
    @Test (priority = 3)
    @Description("Log out Cashier using End of shift ")
    public void logoutUsingEndOfShift()  {
        new TransactionPage(driver)
                .logout();
    }



}
