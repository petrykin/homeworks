package lesson19_20.task4;

public class Fork {
    private static int count = 0;
    private int id;
    private boolean isBusy;

    public Fork() {
        id = ++count;
        isBusy = false;
    }

    public synchronized void take() {
        if (isBusy) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " схватил вилку " + id);
        isBusy = true;
    }

    public synchronized void drop() {
        System.out.println(Thread.currentThread().getName() + " бросил вилку " + id);
        isBusy = false;
        notify();
    }
}
