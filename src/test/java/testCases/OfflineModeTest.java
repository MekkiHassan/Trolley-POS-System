package testCases;
import Pages.CartPage;
import Pages.LoginPage;
import Pages.Stashed;
import Pages.TransactionPage;
import base.BaseTest;
import org.testng.annotations.Test;
import java.awt.*;


public class OfflineModeTest extends BaseTest {

    @Test (priority=1)
    public void cashOrderOffline() throws InterruptedException, AWTException {
        new LoginPage(driver)
                .enterUsername("mekki")
                .enterPassword("123456")
                .clickLoginBtn()
                .enterCashIn("150")
                .confirmCashInBtn();
        Thread.sleep(3000);
       new CartPage(driver)
               .addItemsToCart()
               .completeOrder()
               .paymentCashMethod();
    }

    @Test (priority=2)
    public void splitOrderOffline() throws InterruptedException {
        new CartPage(driver)
                .addItemsToCart()
                .completeOrder()
                .splitPayment();
    }

    @Test (priority=3)
    public void voidOrderOffline() throws InterruptedException {

        new CartPage(driver).addItemsToCart().voidSale();
    }

    @Test(priority=4)
    public void suspendOffline() throws InterruptedException {
        new CartPage(driver)
                .addItemsToCart()
                .suspendProcess();
        new Stashed(driver).retrieveOrder();
    }

    @Test (priority=5)
    public void transactionsTableOffline() throws InterruptedException {
       new TransactionPage(driver).openTransPage();
       Thread.sleep(2000);
       new TransactionPage(driver).logout();
    }

    }
