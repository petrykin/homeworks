package lesson10.task4.p2;

import lesson10.task4.p1.A;

public class C {
    @Override
    public String toString() {
        return "p2.C{\n" +
                "\tполя класса p1.A доступные из класса p2.C:\n" +
                "\t\tpublic    " + A.s1 + "\n" +
                "\tполя класса p1.A не доступные из класса p2.C:\n" +
                "\t\tdefault   p1.A.s2\n" +
                "\t\tprotected p1.A.s3\n" +
                "\t\tprivate   p1.A.s4\n" +
                "}\n";
    }
}
