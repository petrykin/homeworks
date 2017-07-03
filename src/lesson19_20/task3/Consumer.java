package lesson19_20.task3;

import java.util.Collections;

public class Consumer implements Runnable {
    private MyQueue queue;

    public Consumer(MyQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            Object o = queue.get();
            if (o != null && o instanceof Task) {
                Task task = (Task) o;
                Collections.sort(task.getList());
            }
        }
    }
}
