package lesson10.task4.p1;

public class B {
    @Override
    public String toString() {
        return "p1.B{\n" +
                "\tполя класса p1.A доступные из класса p1.B:\n" +
                "\t\tpublic    " + A.s1 +
                "\n\t\tdefault   " + A.s2 +
                "\n\t\tprotected " + A.s3 + "\n" +
                "\tполя класса p1.A не доступные из класса p1.B:\n" +
                "\t\tprivate   p1.A.s4\n" +
                "}\n";
    }
}
