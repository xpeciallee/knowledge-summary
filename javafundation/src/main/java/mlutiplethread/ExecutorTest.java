package mlutiplethread;

import java.util.concurrent.Executors;

public class ExecutorTest {

    public static void main(String[] args) {

        Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(1);
        Executors.newScheduledThreadPool(1);
        Executors.newWorkStealingPool(1);
    }
}
