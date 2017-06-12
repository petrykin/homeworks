package lesson14.task3;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Set<Integer> iSet1 = new HashSet<>();
        Collections.addAll(iSet1, 1, 15, 14, 23, 4, 41);
        Operations.printSet("set1", iSet1);

        Set<Integer> iSet2 = new TreeSet<>();
        Collections.addAll(iSet2, 21, 15, 7, 4, 42, 11);
        Operations.printSet("set2", iSet2);

        Set<Integer> iSet3 = new LinkedHashSet<>();
        Collections.addAll(iSet3, 5, 10, 15, 20, 25, 30);
        Operations.printSet("set3", iSet3);

        Set<Integer> iSet4 = Operations.intersect(iSet1, iSet2);

        Operations.printSet("set1 intersect set2", iSet4);
        Operations.printSet("set1 intersect set2 union set3", Operations.union(iSet4, iSet3));
    }
}
