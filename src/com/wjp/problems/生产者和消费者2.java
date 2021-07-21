package com.wjp.problems;

import java.util.LinkedList;
import java.util.Queue;

public class 生产者和消费者2 {
    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        consumer.start();
        producer.start();

        Thread.sleep(3000);

    }

    // queue 中 add offer 的区别， 在于前者时Java集合的方法，后者是队列的方法，add按理只会抛未捕获异常而失败，而offer失败可能只是队列满了，
    // 同理出队列，和获取队列头的方法
    //          remove poll
    //          element peek

    private static Queue<Integer> queue = new LinkedList<>();

    private static int capacity = 5;


    static class Producer extends Thread{
        int counter = 0;
        @Override
        public void run() {

            synchronized (queue) {
                while (queue.size() < capacity) {
                    queue.offer(counter++);
                    System.out.println("produce " + (counter - 1));
                    queue.notify();
                }
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class Consumer extends Thread{
        @Override
        public void run() {
            synchronized (queue) {
                while (queue.peek() != null) {
                    int product = queue.poll();
                    System.out.println("consume " + product);
                    queue.notify();
                }

                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
