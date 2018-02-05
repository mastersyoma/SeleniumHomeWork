package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FillPage extends BasePage {

    private final WebDriver driver;

    public FillPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//h2[@class='l-header-title ng-binding")
    public WebElement title;

    @FindBy(name = "insured0_surname")
    WebElement insSurname;

    @FindBy(name = "insured0_name")
    WebElement insName;

    @FindBy(name = "insured0_birthDate")
    WebElement insBirthDate;

    @FindBy(name = "surname")
    WebElement surename;

    @FindBy(name = "name")
    WebElement name;

    @FindBy(name = "middlename")
    WebElement middleName;

    @FindBy(name = "birthDate")
    WebElement birthDate;

    @FindBy(xpath = "(//INPUT[@ng-model='formdata.insurer.GENDER'])[2]")
    WebElement gender;

    @FindBy(xpath = "//INPUT[@placeholder='Серия']")
    WebElement docSeries;

    @FindBy(xpath = "//INPUT[@placeholder='Номер']")
    WebElement docNumber;

    @FindBy(name = "issueDate")
    WebElement issueDate;

    @FindBy(name = "issuePlace")
    WebElement issuePlace;

    @FindBy(xpath = "//SPAN[@ng-click='save()'][text()='Продолжить']")
    public WebElement sendButton;

    public void fillField(String fieldName, String value) {


        switch (fieldName) {
            case "Фамилия /Surname":
                fillField(insSurname, value);
                break;
            case "Имя / Given names":
                fillField(insName, value);
                break;
            case "Дата рождения":
                fillField(insBirthDate, value);
                break;
            case "Фамилия":
                fillField(surename, value);
                break;
            case "Имя":
                fillField(name, value);
                break;
            case "Отчество":
                fillField(middleName, value);
                break;
            case "Серия документа":
                fillField(docSeries, value);
                break;
            case "Номер документа":
                fillField(docNumber, value);
                break;
            case "Дата выдачи":
                fillField(issueDate, value);
                break;
            case "Место выдачи":
                fillField(issuePlace, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public String getFillField(String fieldName) {
        switch (fieldName) {
            case "Фамилия /Surname":
                return insSurname.getAttribute("value");
            case "Имя / Given names":
                return insName.getAttribute("value");
            case "Дата рождения":
                return insBirthDate.getAttribute("value");
            case "Фамилия":
                return surename.getAttribute("value");
            case "Имя":
                return name.getAttribute("value");
            case "Отчество":
                return middleName.getAttribute("value");
            case "Серия документа":
                return docSeries.getAttribute("value");
            case "Номер документа":
                return docNumber.getAttribute("value");
            case "Дата выдачи":
                return issueDate.getAttribute("value");
            case "Место выдачи":
                return issuePlace.getAttribute("value");
        }
        throw new AssertionError("Поле не объявлено на странице");
    }
}





