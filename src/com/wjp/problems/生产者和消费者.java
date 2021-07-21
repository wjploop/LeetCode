package com.wjp.problems;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class 生产者和消费者 {
    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        consumer.start();
        producer.start();

    }

    static BlockingDeque<Integer> deque = new LinkedBlockingDeque<>(3);

    static class Producer extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    deque.putFirst(i);
                    System.out.println("put " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class Consumer extends Thread{
        @Override
        public void run() {
            while (true) {
                int product = 0;
                try {
                    product = deque.takeLast();
                    System.out.println("consume " + product);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
