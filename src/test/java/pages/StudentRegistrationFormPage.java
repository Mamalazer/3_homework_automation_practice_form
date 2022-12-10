package pages;

import data.Gender;
import data.Hobby;
import data.Subject;
import io.qameta.allure.Step;

import java.time.LocalDate;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormPage {

    public StudentRegistrationFormPage() {
        $(".main-header").shouldHave(text("Practice Form"));
    }

    @Step("Открыть страницу регистрационной формы студента")
    public static StudentRegistrationFormPage openRegistrationForm() {
        open("/automation-practice-form");
        return new StudentRegistrationFormPage();
    }

    @Step("Указать имя студента {firstName}")
    public StudentRegistrationFormPage setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
        return this;
    }

    @Step("Указать фамилию студента {lastName}")
    public StudentRegistrationFormPage setLastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;
    }

    @Step("Указать email студента {email}")
    public StudentRegistrationFormPage setEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    @Step("Указать пол студента {gender}")
    public StudentRegistrationFormPage setGender(Gender gender) {
        $("#genterWrapper").$(byText(gender.getValue())).click();
        return this;
    }

    @Step("Указать номер телефона студента {mobileNumber}")
    public StudentRegistrationFormPage setMobileNumber(String  mobileNumber) {
        $("#userNumber").setValue(mobileNumber);
        return this;
    }

    @Step("Указать дату рождения студента")
    public StudentRegistrationFormPage setBirthdayDate(LocalDate birthdayDate) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue(String.valueOf(birthdayDate.getMonthValue() - 1));
        $(".react-datepicker__year-select").selectOptionByValue(String.valueOf(birthdayDate.getYear()));
        $x("//*[contains(@class, 'react-datepicker__day') and not(contains(@class, '--outside-month')) and text() = '" +
                birthdayDate.getDayOfMonth() + "']").click();
        return this;
    }

    @Step("Указать учебные предметы студента")
    public StudentRegistrationFormPage setSubjects(List<Subject> subjects) {
        for (Subject subject : subjects) {
            $("#subjectsInput").setValue(subject.getValue()).pressEnter();
        }
        return this;
    }

    @Step("Указать хобби студента")
    public StudentRegistrationFormPage setHobbies(List<Hobby> hobbies) {
        for (Hobby hobby : hobbies) {
            $("#hobbiesWrapper").$(byText(hobby.getValue())).click();
        }
        return this;
    }

    @Step("Добавить аватар")
    public StudentRegistrationFormPage setAvatar(String fileName) {
        $("#uploadPicture").uploadFromClasspath(fileName);
        return this;
    }

    @Step("Указать адрес студента")
    public StudentRegistrationFormPage setAddress(String address) {
        $("#currentAddress").setValue(address);
        return this;
    }

    @Step("Указать штат")
    public StudentRegistrationFormPage setState(String state) {
        $("#react-select-3-input").setValue(state).pressEnter();
        return this;
    }

    @Step("Указать город")
    public StudentRegistrationFormPage setCity(String city) {
        $("#react-select-4-input").setValue(city).pressEnter();
        return this;
    }

    @Step("Подтвердить заполнение формы")
    public SummaryFormPage submitForm() {
        $("#submit").click();
        return new SummaryFormPage();
    }
}
