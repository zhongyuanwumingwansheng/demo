package com.example.demo.thread;

public class ThreadDemo2 {
    private static boolean T2Run = false; //标识位，用来通知T2线程执行

    private static boolean T3Run = false;

    public static void main(String[] args) {
        ThreadDemo2 threadDemo2 = new ThreadDemo2();
        //threadDemo2.testJoin();
        threadDemo2.testWaitNotify();

    }

    public void testJoin(){
        final Thread T1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("T1 run");
            }
        });
        final Thread T2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("T2 run");
                try{
                    T1.join();
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("T2 run end");
            }
        });
        Thread T3 = new Thread(new Runnable() {
            public void run() {
                System.out.println("T3 run");
                try{
                    T2.join();
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("T3 run end");
            }
        });
        T1.start();
        T2.start();
        T3.start();
    }

    public void testWaitNotify(){
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread T1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1){
                    System.out.println("T1 run");
                    //t1 线程通知t2执行
                    T2Run = true;
                    lock1.notify();
                }
            }
        });
        Thread T2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1){
                    if(!T2Run){
                        System.out.println("T2 wait");
                        try {
                            lock1.wait();
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    System.out.println("T2 run");
                    //t2 线程通知t3执行
                    synchronized (lock2){
                        T3Run = true;
                        lock2.notify();

                    }
                }
            }
        });

        Thread T3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2){
                    if (!T3Run){
                        System.out.println("T3 wait");
                        try {
                            lock2.wait();
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                    System.out.println("T3 run");
                }
            }
        });
        T1.start();
        T2.start();
        T3.start();
    }
}
