import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Helper {

    static void setDate(String month, String year, String day) {
        $("#dateOfBirthInput").click();
        Select monthList = new Select($(".react-datepicker__month-select"));
        monthList.selectByVisibleText(month);
        Select yearList = new Select($(".react-datepicker__year-select"));
        yearList.selectByVisibleText(year);
        $x("//*[contains(@class, 'react-datepicker__day') and text() = '" + day + "']").click();
    }
}
