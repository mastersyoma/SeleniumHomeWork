package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps extends BaseSteps {


    @Step("Выбор подменю {0}")
    public void selectMainMenu(String menuItem){new MainPage(getDriver()).selectMainMenu(menuItem);}

    @Step("Выбор подменю {0}")
    public void selectSubMenu(String nameItem2){new MainPage(getDriver()).selectSubMenu(nameItem2);}

}
