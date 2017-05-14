package lesson8.task2;

public class Recursion {
    public static void printA_B(int a, int b) {
        if (a == b) {
            System.out.println(a);
        } else {
            System.out.print(a + " ");
            if (a < b) {
                printA_B(a + 1, b);
            } else {
                printA_B(a - 1, b);
            }
        }
    }
}
