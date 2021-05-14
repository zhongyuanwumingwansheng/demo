package com.example.demo.service;

public class StartAndRun {
    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run() {
                world();
            }
        };

        //t.start();
        t.run();
        System.out.print(" Hello ");
    }

    static void world() {
        System.out.print(" world ");
    }

}
