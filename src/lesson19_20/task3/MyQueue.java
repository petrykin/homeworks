package lesson19_20.task3;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue<T extends Sortable> {
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
        if (queue.size() >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.offer(t);
        System.out.println(Thread.currentThread().getName() + " добавил " + t);
        notify();
    }

    public synchronized T get() {
        while (queue.isEmpty()) {
            try {
                System.out.println(Thread.currentThread().getName() + " ожидает... ");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T t = queue.poll();
        System.out.println(Thread.currentThread().getName() + " выполняет " + t);
        notify();
        return t;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyQueue<?> myQueue = (MyQueue<?>) o;

        return queue != null ? queue.equals(myQueue.queue) : myQueue.queue == null;
    }

    @Override
    public int hashCode() {
        return queue != null ? queue.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "queue=" + queue +
                '}';
    }
}
