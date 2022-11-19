package tests;

import org.junit.jupiter.api.Test;

import static data.Users.daniil_kuznetsov;
import static pages.StudentRegistrationFormPage.openRegistrationForm;

public class AutomationPracticeFormTest extends GeneralFrontTest {

    @Test()
    public void test_01() {
        openRegistrationForm()
                .setFirstName(daniil_kuznetsov.getFirstName())
                .setLastName(daniil_kuznetsov.getLastName())
                .setEmail(daniil_kuznetsov.getEmail())
                .setGender(daniil_kuznetsov.getGender())
                .setMobileNumber(daniil_kuznetsov.getMobileNumber())
                .setBirthdayDate(daniil_kuznetsov.getBirthDay())
                .setSubjects(daniil_kuznetsov.getSubjects())
                .setHobbies(daniil_kuznetsov.getHobbies())
                .setAvatar(daniil_kuznetsov.getAvatar())
                .setAddress(daniil_kuznetsov.getAddress())
                .setState(daniil_kuznetsov.getState())
                .setCity(daniil_kuznetsov.getCity())
                .submitForm()
                .checkSummaryForm(daniil_kuznetsov);
    }
}
