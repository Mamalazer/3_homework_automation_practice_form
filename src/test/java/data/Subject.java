package data;

import lombok.Getter;

@Getter
public enum Subject {
    MATH("Math"),
    PHYSICS("Physics"),
    COMPUTER_SCIENCE("Computer science");

    private final String value;

    Subject(String value) {
        this.value = value;
    }
}
