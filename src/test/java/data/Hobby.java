package data;

import lombok.Getter;

@Getter
public enum Hobby {
    SPORTS("Sports"),
    MUSIC("Music");

    private final String value;

    Hobby(String value) {
        this.value = value;
    }
}
