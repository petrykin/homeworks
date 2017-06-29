package lesson10.task4;

import lesson10.task4.p1.A;
import lesson10.task4.p1.A1;
import lesson10.task4.p1.B;
import lesson10.task4.p2.A2;
import lesson10.task4.p2.C;

public class AccessDemo {
    public static void main(String[] args) {
        System.out.println(new A());
        System.out.println(new A1());
        System.out.println(new B());
        System.out.println(new A2());
        System.out.println(new C());
    }
}
