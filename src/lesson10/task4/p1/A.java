package lesson10.task4.p1;

public class A {
    public static String s1 = "p1.A.s1";
    static String s2 = "p1.A.s2";
    protected static String s3 = "p1.A.s3";
    private static String s4 = "p1.A.s4";

    @Override
    public String toString() {
        return "p1.A{\n" +
                "\tполя класса p1.A доступные из класса p1.A:\n" +
                "\t\tpublic    " + A.s1 +
                "\n\t\tdefault   " + A.s2 +
                "\n\t\tprotected " + A.s3 +
                "\n\t\tprivate   " + A.s4 + "\n" +
                "}\n";
    }
}
