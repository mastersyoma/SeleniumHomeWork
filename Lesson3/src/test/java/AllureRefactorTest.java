import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;

public class AllureRefactorTest extends BaseSteps {

    MainSteps mainSteps = new MainSteps();
    SecondSteps secondSteps = new SecondSteps();
    PreFillSteps preFillSteps = new PreFillSteps();
    FillSteps fillSteps = new FillSteps();

    HashMap<String,String> testData = new HashMap<>();

    @Title("Страхование путешественников")
    @Test
    public void Test() {
        testData.put("Фамилия /Surname", "Ivanov");
        testData.put("Имя / Given names", "Ivan");
        testData.put("Дата рождения", "10.01.1991");
        testData.put("Фамилия", "Иванова");
        testData.put("Имя", "Ольга");
        testData.put("Отчество", "Ивановна");
        testData.put("Серия документа", "1233");
        testData.put("Номер документа", "121212");
        testData.put("Дата выдачи", "10.01.1998");
        testData.put("Место выдачи", "Москва");

        mainSteps.selectMainMenu("Застраховать себя");
        mainSteps.selectSubMenu("Страхование путешественников");
        secondSteps.setJumpTo();
        preFillSteps.pfpage();
        //fillSteps.checkPageTitle("Страхование путешественников");
        fillSteps.fillFields(testData);
        fillSteps.checkFillFields(testData);
    }


}
