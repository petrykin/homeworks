package lesson14.task3;

import java.util.HashSet;
import java.util.Set;

public class Operations {
    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> resultSet = new HashSet<T>(set1);
        resultSet.addAll(set2);
        return resultSet;
    }

    public static <T> Set<T> intersect(Set<T> set1, Set<T> set2) {
        Set<T> resultSet = new HashSet<T>(set1);
        resultSet.retainAll(set2);
        return resultSet;
    }

    public static void printSet(String name, Set set) {
        System.out.printf("%s: %s\n", name, set);
    }
}