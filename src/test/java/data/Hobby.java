package data;

import lombok.Getter;

@Getter
public enum Hobby {
    SPORTS("Sports"),
    MUSIC("Music"),
    READING("Reading");

    private final String value;

    Hobby(String value) {
        this.value = value;
    }
}
