package com.example.demo.thread;

public class ThreadImpl implements Runnable{
    public void run(){
        try{
            System.out.println("Begin ThreadImpl");
            Thread.sleep(5000);
            System.out.println("End ThreadImpl");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class JoinTest{
    public static void main(String[] args){
        Thread t = new Thread(new ThreadImpl());
        t.start();
        try{
            t.join(1000);
            if(t.isAlive()){
                System.out.println("t has not finished");
            }else {
                System.out.println("t has finished");
            }
            System.out.println("join finished");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
