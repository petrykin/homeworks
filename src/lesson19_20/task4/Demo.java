package lesson19_20.task4;

public class Demo {
    public static void main(String[] args) {
        Fork[] forks = new Fork[]{new Fork(), new Fork(), new Fork(), new Fork(), new Fork()};

        Thread t1 = new Thread(new Philosopher(forks[4], forks[0]));
        t1.setName("Сократ");
        Thread t2 = new Thread(new Philosopher(forks[0], forks[1]));
        t2.setName("Аристотель");
        Thread t3 = new Thread(new Philosopher(forks[2], forks[1]));
        t3.setName("Демокрит");
        Thread t4 = new Thread(new Philosopher(forks[2], forks[3]));
        t4.setName("Демосфен");
        Thread t5 = new Thread(new Philosopher(forks[4], forks[3]));
        t5.setName("Пифагор");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
