package lesson19_20.task3;

public class Producer<T extends Sortable> implements Runnable {
    private MyQueue<T> queue;

    public Producer(MyQueue<T> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            queue.put((T) new Task("Task" + ++i));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Producer<?> producer = (Producer<?>) o;

        return queue != null ? queue.equals(producer.queue) : producer.queue == null;
    }

    @Override
    public int hashCode() {
        return queue != null ? queue.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "name=\'" + Thread.currentThread().getName() + '\'' +
                ", queue=" + queue +
                '}';
    }
}
