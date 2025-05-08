package testCases;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.Stashed;
import base.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class StashedTest extends BaseTest {

    @Test
    @Description("retrieveOrder that is stashed before ")
    public void retrieveOrder() throws InterruptedException {
        Thread.sleep(2000);
            new CartPage(driver)
                    .addItemsToCart()
                    .suspendProcess();
            new Stashed(driver).retrieveOrder();
    }

}

