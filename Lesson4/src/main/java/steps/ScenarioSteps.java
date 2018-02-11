package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    SecondSteps secondSteps = new SecondSteps();
    PreFillSteps preFillSteps = new PreFillSteps();
    FillSteps fillSteps = new FillSteps();

    @When("^выбран пункт меню \"(.*)\"$")
    public void selectMainMenu(String menuItem) {
        mainSteps.selectMainMenu(menuItem);
    }

    @When("^выбран пункт подменю \"(.*)\"$")
    public void selectSubMenu (String nameItem2) {
        mainSteps.selectSubMenu(nameItem2);
    }

    @Then("переход на страницу страхования")
    public void setJumpTo(){
        secondSteps.setJumpTo();
    }

    @When("^выбрана минимальная страховка")
    public void pfpage(){
        preFillSteps.pfpage();
    }

    @Then("^заполняются поля")
    public void fillFields(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> fillFields().fillField(field, value));

    }

    @Then("^значения полей равны:$")
    public void getFillFields(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> getFillFields().checkFillField(field, value));
    }








}
