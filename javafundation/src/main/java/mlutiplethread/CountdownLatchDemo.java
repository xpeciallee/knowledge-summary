package mlutiplethread;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //https://blog.csdn.net/jeffleo/article/details/56678739
        CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(()->{
            System.out.println("hello");
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        },"thread1").start();

        new Thread(()->{
            System.out.println("hello2");
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        },"thread2").start();

        countDownLatch.await();
    }
}
