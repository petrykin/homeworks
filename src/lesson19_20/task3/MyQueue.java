package lesson19_20.task3;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue<T> {
    private Queue<T> queue;

    public MyQueue() {
        queue = new LinkedList<>();
    }

    public MyQueue(Queue<T> queue) {
        this.queue = queue;
    }

    public synchronized int size() {
        return queue.size();
    }

    public synchronized void put(T t) {
        queue.offer(t);
        System.out.println(Thread.currentThread().getName() + " добавил " + t);
        notifyAll();
    }

    public synchronized T get() {
        if (!queue.isEmpty()) {
            T t = queue.poll();
            System.out.println(Thread.currentThread().getName() + " выполняет " + t);
            return t;
        }
        return null;
    }
}
