package com.example.demo.core.thread;

import java.util.Vector;

public class ThreadMain implements Runnable {
    private static int count;

    public ThreadMain() {
        count = 0;
    }

    public static void method() {
        synchronized(ThreadMain.class) {
            for (int i = 0; i < 5; i ++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public synchronized void run() {
        method();
    }

    public static void main(String[] args) {
        ThreadMain classThread1 = new ThreadMain();
        ThreadMain classThread2 = new ThreadMain();
        Thread thread1 = new Thread(classThread1, "classThread1");
        Thread thread2 = new Thread(classThread2, "classThread2");
        thread1.start();
        thread2.start();

        Vector vector = new Vector();
        vector.contains(1);
    }
}
