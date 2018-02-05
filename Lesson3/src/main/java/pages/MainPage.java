package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage{

    WebDriver driver;

    public MainPage (WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//ul[contains(@class,'alt-menu-mid')]/li[5]/a")
    WebElement mainMenuItem;

    @FindBy(xpath = "//li[5]//div[contains(@class,'list__item_level_1')]")
    public WebElement subMenuItem;


    public void selectMainMenu(String menuItem) {
        mainMenuItem.findElement(By.xpath(".//span[@class='multiline']/*[contains(text(),'" + menuItem + "')]")).click();
    }

    public void selectSubMenu(String nameItem2) {
        subMenuItem.findElement(By.xpath("(//a[contains (text(), '"+nameItem2+"')])[1]")).click();
    }
}
