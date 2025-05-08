package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;

public class Stashed {
    private WebDriver driver;
    public Stashed (WebDriver driver){
        this.driver=driver;
    }
    //Locators
    private  final By stashedIcon=By.xpath("//nav/div/div/div/a[2][@aria-label='stashed']");
    private final By detailsBtn=By.xpath("//main/div/div[3]/div/div[1]/div[7]/button");
    private final By retrieveBtn= By.xpath("//aside/div[3]/button");

    //Actions
    @Step("Select:stashedIcon and click on Details orders and then retrieve it")
    public void retrieveOrder(){
        ElementActions.clickElement(driver,this.stashedIcon);
        ElementActions.clickElement(driver,this.detailsBtn);
        ElementActions.clickElement(driver,this.retrieveBtn);
    }

}
