package lesson10.task4.p1;

public class A1 extends A {
    @Override
    public String toString() {
        return "p1.A1 extends p1.A{\n" +
                "\tполя класса p1.A доступные из класса p1.A1:\n" +
                "\t\tpublic    " + A.s1 +
                "\n\t\tdefault   " + A.s2 +
                "\n\t\tprotected " + A.s3 + "\n" +
                "\tполя класса p1.A не доступные из класса p1.A1:\n" +
                "\t\tprivate   p1.A.s4\n" +
                "}\n";
    }
}
