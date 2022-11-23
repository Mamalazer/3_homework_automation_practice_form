package utils;

import data.Hobby;
import data.Subject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomHelper {
    public static List<Subject> randomListOfSubjects(int count) {
        List<Subject> list = Arrays.asList(Subject.values());
        Collections.shuffle(list);
        return list.stream()
                .limit(count)
                .collect(Collectors.toList());
    }

    public static List<Hobby> randomListOfHobbies(int count) {
        List<Hobby> list = Arrays.asList(Hobby.values());
        Collections.shuffle(list);
        return list.stream()
                .limit(count)
                .collect(Collectors.toList());
    }
}
