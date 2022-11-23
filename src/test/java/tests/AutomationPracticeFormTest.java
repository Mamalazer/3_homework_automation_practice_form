package tests;

import data.models.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static data.Users.daniil_kuznetsov;
import static data.Users.random_user;
import static pages.StudentRegistrationFormPage.openRegistrationForm;

public class AutomationPracticeFormTest extends GeneralFrontTest {

    static Stream<User> argsProviderFactory() {
        return Stream.of(daniil_kuznetsov, random_user);
    }

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
                .checkSummaryForm(daniil_kuznetsov)
                .closeSummaryForm();
    }

    @ParameterizedTest
    @MethodSource("argsProviderFactory")
    public void test_02(User user) {
        openRegistrationForm()
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setEmail(user.getEmail())
                .setGender(user.getGender())
                .setMobileNumber(user.getMobileNumber())
                .setBirthdayDate(user.getBirthDay())
                .setSubjects(user.getSubjects())
                .setHobbies(user.getHobbies())
                .setAvatar(user.getAvatar())
                .setAddress(user.getAddress())
                .setState(user.getState())
                .setCity(user.getCity())
                .submitForm()
                .checkSummaryForm(user)
                .closeSummaryForm();
    }
}
