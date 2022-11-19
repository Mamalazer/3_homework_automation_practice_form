package pages;

import data.Hobby;
import data.Subject;
import data.models.User;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SummaryFormPage {

    public SummaryFormPage() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    public SummaryFormPage checkSummaryForm(User user) {
        $x("//td[text()='Student Name']/following-sibling::td")
                .shouldHave(text(user.getFirstName()), text(user.getLastName()));
        $x("//td[text()='Student Email']/following-sibling::td")
                .shouldHave(text(user.getEmail()));
        $x("//td[text()='Gender']/following-sibling::td")
                .shouldHave(text(user.getGender().getValue()));
        $x("//td[text()='Mobile']/following-sibling::td")
                .shouldHave(text(user.getMobileNumber()));
        $x("//td[text()='Date of Birth']/following-sibling::td")
                .shouldHave(text(user.getBirthDay().format(DateTimeFormatter.ofPattern("dd MMM,yyyy", Locale.ENGLISH))));

        for (Subject subject : user.getSubjects()) {
            $x("//td[text()='Subjects']/following-sibling::td")
                    .shouldHave(text(subject.getValue()));
        }

        for (Hobby hobby : user.getHobbies()) {
            $x("//td[text()='Hobbies']/following-sibling::td")
                    .shouldHave(text(hobby.getValue()));
        }

        $x("//td[text()='Picture']/following-sibling::td").shouldHave(text(user.getAvatar()));
        $x("//td[text()='Address']/following-sibling::td").shouldHave(text(user.getAddress()));
        $x("//td[text()='State and City']/following-sibling::td")
                .shouldHave(text(user.getState()), text(user.getCity()));
        return this;
    }

    public StudentRegistrationFormPage closeSummaryForm() {
        $("#closeLargeModal").click();
        return new StudentRegistrationFormPage();
    }
}
