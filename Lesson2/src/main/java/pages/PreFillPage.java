package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class PreFillPage {

    private WebDriver driver;

    @FindBy(xpath = "//DIV[@class='b-form-box-title ng-binding'][text()='Минимальная']")
    WebElement minimal;

    @FindBy(xpath = "//*[@ng-click='save()'][text()='Оформить']")
    WebElement issue;

    public PreFillPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void pfpage() {

        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        minimal.click();
        issue.click();
    }
}
