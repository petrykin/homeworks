package lesson19_20.task4;

import java.util.Random;

public class Philosopher implements Runnable {
    private Random random;
    private Fork fork1;
    private Fork fork2;

    public Philosopher(Fork fork1, Fork fork2) {
        random = new Random();
        this.fork1 = fork1;
        this.fork2 = fork2;
    }

    private void eat() {
        fork1.take();
        fork2.take();
        try {
            System.out.println(Thread.currentThread().getName() + " ест свои макароны...");
            Thread.sleep(random.nextInt(1000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void think() {
        fork1.drop();
        fork2.drop();
        try {
            System.out.println(Thread.currentThread().getName() + " размышляет и смотрит с завистью по сторонам");
            Thread.sleep(random.nextInt(1000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            eat();
            think();
        }
    }
}