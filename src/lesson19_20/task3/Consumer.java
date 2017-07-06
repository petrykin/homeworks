package lesson19_20.task3;

public class Consumer<T extends Sortable> implements Runnable {
    private MyQueue<T> queue;

    public Consumer(MyQueue<T> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            T t = queue.get();
            if (t != null) {
                t.sort();
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Consumer<?> consumer = (Consumer<?>) o;

        return queue != null ? queue.equals(consumer.queue) : consumer.queue == null;
    }

    @Override
    public int hashCode() {
        return queue != null ? queue.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "name=\'" + Thread.currentThread().getName() + '\'' +
                ", queue=" + queue +
                '}';
    }
}
