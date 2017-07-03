package lesson19_20.task3;

public class Producer implements Runnable {
    private MyQueue queue;

    public Producer(MyQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            if (queue.size() < 5) {
                queue.put(new Task("Task" + ++i));
            }
        }
    }
}
