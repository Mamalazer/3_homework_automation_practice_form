package pages;

import data.Gender;
import data.Hobby;
import data.Subject;

import java.time.LocalDate;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormPage {

    public StudentRegistrationFormPage() {
        $(".main-header").shouldHave(text("Practice Form"));
    }

    public static StudentRegistrationFormPage openRegistrationForm() {
        open("/automation-practice-form");
        return new StudentRegistrationFormPage();
    }

    public StudentRegistrationFormPage setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
        return this;
    }

    public StudentRegistrationFormPage setLastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;
    }

    public StudentRegistrationFormPage setEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    public StudentRegistrationFormPage setGender(Gender gender) {
        $("#genterWrapper").$(byText(gender.getValue())).click();
        return this;
    }

    public StudentRegistrationFormPage setMobileNumber(String  mobileNumber) {
        $("#userNumber").setValue(mobileNumber);
        return this;
    }

    public StudentRegistrationFormPage setBirthdayDate(LocalDate birthdayDate) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue(String.valueOf(birthdayDate.getMonthValue() - 1));
        $(".react-datepicker__year-select").selectOptionByValue(String.valueOf(birthdayDate.getYear()));
        $x("//*[contains(@class, 'react-datepicker__day') and not(contains(@class, '--outside-month')) and text() = '" +
                birthdayDate.getDayOfMonth() + "']").click();
        return this;
    }

    public StudentRegistrationFormPage setSubjects(List<Subject> subjects) {
        for (Subject subject : subjects) {
            $("#subjectsInput").setValue(subject.getValue()).pressEnter();
        }
        return this;
    }

    public StudentRegistrationFormPage setHobbies(List<Hobby> hobbies) {
        for (Hobby hobby : hobbies) {
            $("#hobbiesWrapper").$(byText(hobby.getValue())).click();
        }
        return this;
    }

    public StudentRegistrationFormPage setAvatar(String fileName) {
        $("#uploadPicture").uploadFromClasspath(fileName);
        return this;
    }

    public StudentRegistrationFormPage setAddress(String address) {
        $("#currentAddress").setValue(address);
        return this;
    }

    public StudentRegistrationFormPage setState(String state) {
        $("#react-select-3-input").setValue(state).pressEnter();
        return this;
    }

    public StudentRegistrationFormPage setCity(String city) {
        $("#react-select-4-input").setValue(city).pressEnter();
        return this;
    }

    public SummaryFormPage submitForm() {
        $("#submit").click();
        return new SummaryFormPage();
    }
}
