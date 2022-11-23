package data;

import lombok.Getter;

@Getter
public enum Subject {
    MATH("Math"),
    PHYSICS("Physics"),
    COMPUTER_SCIENCE("Computer science"),
    ACCOUNTING("Accounting"),
    ARTS("Arts"),
    BIOLOGY("Biology"),
    ECONOMICS("Economics"),
    HISTORY("History");

    private final String value;

    Subject(String value) {
        this.value = value;
    }
}
