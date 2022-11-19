package data;

import data.models.User;

import java.time.LocalDate;
import java.util.List;

import static data.Gender.MALE;
import static data.Hobby.MUSIC;
import static data.Hobby.SPORTS;
import static data.Subject.*;

public class Users {

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
}
