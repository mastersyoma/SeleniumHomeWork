package steps;

import pages.PreFillPage;
import ru.yandex.qatools.allure.annotations.Step;

public class PreFillSteps extends BaseSteps {
    @Step("Выбор минимальной страховки")
    public void pfpage(){new PreFillPage(getDriver()).pfpage();}
}
