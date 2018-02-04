import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.FillPage;
import pages.MainPage;
import pages.PreFillPage;
import pages.SecondPage;

/**
 * Создано Сокуренко Семёном в рамках обучения Selenium 13.01.2018
 */

public class InsuranceTest extends BaseTest {


    @Test
    public void testInsurance() {

        driver.get(baseUrl);

        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Застраховать");
        MainPage subMenu = new MainPage(driver);
        subMenu.selectSubMenu("Страхование путешественников");

        SecondPage secondPage = new SecondPage(driver);
        secondPage.setJumpTo(driver);

        PreFillPage preFillPage = new PreFillPage(driver);
        preFillPage.pfpage();

        FillPage fillPage = new FillPage(driver);
        fillPage.fillField("Фамилия /Surname", "Ivanov");
        fillPage.fillField("Имя / Given names", "Ivan");
        fillPage.fillField("Дата рождения", "10.01.1991");
        fillPage.fillField("Фамилия", "Иванова");
        fillPage.fillField("Имя", "Ольга");
        fillPage.fillField("Отчество", "Ивановна");
        fillPage.fillField("Серия документа", "1233");
        fillPage.fillField("Номер документа", "121212");
        fillPage.fillField("Дата выдачи", "10.01.1998");
        fillPage.fillField("Место выдачи", "Москва");

        fillPage.getFillField("Фамилия /Surname");
        fillPage.getFillField("Имя / Given names");
        fillPage.getFillField("Дата рождения");
        fillPage.getFillField("Фамилия");
        fillPage.getFillField("Имя");
        fillPage.getFillField("Отчество");
        fillPage.getFillField("Серия документа");
        fillPage.getFillField("Номер документа");
        fillPage.getFillField("Дата выдачи");
        fillPage.getFillField("Место выдачи");

        fillPage.sendButton.click();

        Assert.assertEquals("Заполнены не все обязательные поля",
                driver.findElement(By.xpath("//DIV[@ng-show='tryNext && myForm.$invalid'][text()='Заполнены не все обязательные поля']")).getText());
    }
}













        /*//задание параметра ожидания
        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);

        //перейти по указанному адресу
        driver.get(baseUrl);

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

}
*/