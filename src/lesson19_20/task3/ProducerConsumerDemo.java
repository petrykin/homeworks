package lesson19_20.task3;

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        MyQueue<Task> queue = new MyQueue<>();
        Producer producer = new Producer(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);

        Thread producerThread = new Thread(producer);
        producerThread.setName("Producer");
        Thread consumer1Thread = new Thread(consumer1);
        consumer1Thread.setName("Consumer1");
        Thread consumer2Thread = new Thread(consumer2);
        consumer2Thread.setName("Consumer2");

        producerThread.start();
        consumer1Thread.start();
        consumer2Thread.start();
    }
}
