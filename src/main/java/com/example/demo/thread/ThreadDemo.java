package com.example.demo.thread;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class ThreadDemo extends Thread{
    public void run(){
        System.out.println(Thread.currentThread().getName()+",begin");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+",end");
    }

    public static void main(String[] args){
        System.out.println("test3:begin");
        Thread t1 = new ThreadDemo();
        t1.setDaemon(true);
        t1.start();
        System.out.println("test3:end");
    }
}
