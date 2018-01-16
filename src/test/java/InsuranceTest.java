import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.lang.String;
/**
 * Создано Сокуренко Семёном в рамках обучения Selenium 13.01.2018
 */

public class InsuranceTest {


    private WebDriver driver;

    @Before
    public void testIsurance(){
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testInsurance(){

        //задание параметра ожидания
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);

        //перейти по указанному адресу
        driver.navigate().to("http://www.sberbank.ru/ru/person");


        //вызов action для выполнения mouseover в выпадающем меню
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//SPAN[@class='multiline'])[5]"))));

        WebElement element = driver.findElement(By.xpath("(//SPAN[@class='multiline'])[5]"));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//A[@class='kit-link kit-link_color_black alt-menu-list__link alt-menu-list__link_level_1'])[36]"))));
        WebElement subElement = driver.findElement(By.xpath("(//A[@class='kit-link kit-link_color_black alt-menu-list__link alt-menu-list__link_level_1'])[36]"));
        action.moveToElement(subElement);
        action.click();
        action.perform();

        //проверка наличия заголовка "Страхование путешественников"
        WebElement title = driver.findElement(By.xpath("//H1[text()='Страхование путешественников']"));
        Assert.assertEquals("Страхование путешественников", title.getText());


        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//IMG[@src='/portalserver/content/atom/contentRepository/content/person/travel/banner-zashita-traveler.jpg?id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53']"))));
        driver.findElement(By.xpath("//IMG[@src='/portalserver/content/atom/contentRepository/content/person/travel/banner-zashita-traveler.jpg?id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53']")).click();

        //переключение driver к работе в новой вкладке
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//DIV[@class='b-form-box-title ng-binding'][text()='Минимальная']"))));
        driver.findElement(By.xpath("//DIV[@class='b-form-box-title ng-binding'][text()='Минимальная']")).click();
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//*[@ng-click='save()'][text()='Оформить']"))));
        driver.findElement(By.xpath("//*[@ng-click='save()'][text()='Оформить']")).click();


        //заполнение полей данными
        fillField(By.name("insured0_surname"),"Mitin");
        fillField(By.name("insured0_name"),"Oleg");
        fillField(By.name("insured0_birthDate"),"13032007");
        fillField(By.name("surname"),"Митина");
        fillField(By.name("name"),"Ольга");
        fillField(By.name("middlename"),"Ивановна");
        driver.findElement(By.name("birthDate")).click();
        fillField(By.name("birthDate"),"01012000");
        driver.findElement(By.xpath("(//INPUT[@ng-model='formdata.insurer.GENDER'])[2]")).click();
        fillField(By.xpath("//INPUT[@ng-model='formdata.insurer.documentList[0].DOCSERIES']"),"2312");
        fillField(By.xpath("//INPUT[@ng-model='formdata.insurer.documentList[0].DOCNUMBER']"),"222222");
        fillField(By.name("issueDate"),"13032002");
        fillField(By.name("issuePlace"),"ULISA PUSHKINA DOM KOLOTUSHKINA");

        //проверка на правильность заполнения данных
        Assert.assertEquals("Mitin", driver.findElement(By.name("insured0_surname")).getAttribute("value"));
        Assert.assertEquals("Oleg", driver.findElement(By.name("insured0_name")).getAttribute("value"));
        Assert.assertEquals("13.03.2007", driver.findElement(By.name("insured0_birthDate")).getAttribute("value"));
        Assert.assertEquals("Митина", driver.findElement(By.name("surname")).getAttribute("value"));
        Assert.assertEquals("Ольга", driver.findElement(By.name("name")).getAttribute("value"));
        Assert.assertEquals("Ивановна", driver.findElement(By.name("middlename")).getAttribute("value"));
        Assert.assertEquals("01.01.2000", driver.findElement(By.name("birthDate")).getAttribute("value"));
        Assert.assertEquals("1", driver.findElement(By.name("female")).getAttribute("value"));
        Assert.assertEquals("Mitin", driver.findElement(By.name("insured0_surname")).getAttribute("value"));
        Assert.assertEquals("2312", driver.findElement(By.xpath("//INPUT[@ng-model='formdata.insurer.documentList[0].DOCSERIES']")).getAttribute("value"));
        Assert.assertEquals("222222", driver.findElement(By.xpath("//INPUT[@ng-model='formdata.insurer.documentList[0].DOCNUMBER']")).getAttribute("value"));
        Assert.assertEquals("13.03.2002", driver.findElement(By.name("issueDate")).getAttribute("value"));
        Assert.assertEquals("ULISA PUSHKINA DOM KOLOTUSHKINA", driver.findElement(By.name("issuePlace")).getAttribute("value"));

        driver.findElement(By.xpath("//*[@ng-click='save()'][text()='Продолжить']")).click();

        Assert.assertEquals("Заполнены не все обязательные поля",
                driver.findElement(By.xpath("//DIV[@ng-show='tryNext && myForm.$invalid'][text()='Заполнены не все обязательные поля']")).getText());

    }
    @After
    public void tearDown() {
        driver.quit();
    }

    private void fillField(By locator, String value){
        //driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }
}