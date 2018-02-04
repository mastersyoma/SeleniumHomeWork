package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecondPage extends BasePage {

    WebDriver driver;

    public SecondPage (WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//IMG[@src='/portalserver/content/atom/contentRepository/content/person/travel/banner-zashita-traveler.jpg?id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53']")
    WebElement jumpTo;

    public void setJumpTo(WebDriver driver) {
        jumpTo.click();
    }
}


