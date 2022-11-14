import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.ENTER;

public class AutomationPracticeFormTest extends GeneralFrontTest {

    @Test()
    public void test_01() {
        open("/automation-practice-form");
        $("#firstName").setValue("Даниил");
        $("#lastName").setValue("Кузнецов");
        $("#userEmail").setValue("auto@test.ru");
        $x("//*[text()='Male']/parent::*").click();
        $("#userNumber").setValue("89645178902");
        Helper.setDate("May", "1993", "14");
        $("#subjectsInput").setValue("Math").sendKeys(ENTER);
        $("#subjectsInput").setValue("Physics").sendKeys(ENTER);
        $("#subjectsInput").setValue("Computer science").sendKeys(ENTER);
        $x("//*[text()='Sports']/parent::*").click();
        $x("//*[text()='Music']/parent::*").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/Picture.jpg"));
        $("#currentAddress").setValue("Ленина 1-17");
        $("#react-select-3-input").setValue("NCR").sendKeys(ENTER);
        $("#react-select-4-input").setValue("Delhi").sendKeys(ENTER);
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']/following-sibling::td").shouldHave(text("Даниил Кузнецов"));
        $x("//td[text()='Student Email']/following-sibling::td").shouldHave(text("auto@test.ru"));
        $x("//td[text()='Gender']/following-sibling::td").shouldHave(text("Male"));
        $x("//td[text()='Mobile']/following-sibling::td").shouldHave(text("8964517890"));
        $x("//td[text()='Date of Birth']/following-sibling::td").shouldHave(text("14 May,1993"));
        $x("//td[text()='Subjects']/following-sibling::td").shouldHave(text("Maths, Physics, Computer Science"));
        $x("//td[text()='Hobbies']/following-sibling::td").shouldHave(text("Sports, Music"));
        $x("//td[text()='Picture']/following-sibling::td").shouldHave(text("Picture.jpg"));
        $x("//td[text()='Address']/following-sibling::td").shouldHave(text("Ленина 1-17"));
        $x("//td[text()='State and City']/following-sibling::td").shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").click();
    }
}
