package steps;

import pages.SecondPage;
import ru.yandex.qatools.allure.annotations.Step;

public class SecondSteps extends BaseSteps {

    @Step("Переход на страницу Страхование путешественников")
    public void setJumpTo() {new SecondPage(getDriver()).setJumpTo();}

}
