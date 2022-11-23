package data;

import com.github.javafaker.Faker;
import data.models.User;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static data.Gender.MALE;
import static data.Hobby.MUSIC;
import static data.Hobby.SPORTS;
import static data.Subject.*;
import static utils.RandomHelper.randomListOfHobbies;
import static utils.RandomHelper.randomListOfSubjects;

public class Users {

    static Faker faker = new Faker(new Locale("en-GB"));

    public static final User daniil_kuznetsov = User.builder()
            .firstName("Даниил")
            .lastName("Кузнецов")
            .gender(MALE)
            .email("auto@test.ru")
            .mobileNumber("9645178902")
            .birthDay(LocalDate.of(1993, 5, 14))
            .avatar("Picture.jpg")
            .address("Ленина 1-17")
            .state("NCR")
            .city("Delhi")
            .subjects(List.of(MATH, PHYSICS, COMPUTER_SCIENCE))
            .hobbies(List.of(SPORTS, MUSIC)).build();

    public static final User random_user = User.builder()
            .firstName(faker.name().firstName())
            .lastName(faker.name().lastName())
            .gender(MALE)
            .email(faker.internet().emailAddress())
            .mobileNumber(faker.regexify("[1-9]{10}"))
            .birthDay(
                    LocalDate.of(faker.number().numberBetween(1980, 2004),
                    faker.number().numberBetween(1, 12),
                    faker.number().numberBetween(1, 28)))
            .avatar("Picture.jpg")
            .address(faker.address().fullAddress())
            .state("Haryana")
            .city("Panipat")
            .subjects(randomListOfSubjects(3))
            .hobbies(randomListOfHobbies(2)).build();
}
