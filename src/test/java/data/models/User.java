package data.models;

import data.Gender;
import data.Hobby;
import data.Subject;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class User {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private String mobileNumber;
    private LocalDate birthDay;
    private String address;
    private String state;
    private String city;
    private String avatar;
    private List<Subject> subjects;
    private List<Hobby> hobbies;
}
