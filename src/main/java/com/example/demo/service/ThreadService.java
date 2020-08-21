package com.example.demo.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadService {
    public void newCachedThreadPool(){
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            try {
                // sleep可明显看到使用的是线程池里面以前的线程，没有创建新的线程
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int k = i;
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    // 打印正在执行的缓存线程信息
                    System.out.println(String.format(Thread.currentThread().getName()
                            + "正在被执行, i=%d", k));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void newFixedThreadPool(){
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        print(fixedThreadPool);
    }

    public void newScheduledThreadPool(){
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 10; i++) {
            int k = i;
            scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
                public void run() {
                    System.out.println("延迟1秒后每3秒执行一次,i="+k);
                }
            }, 3, 10, TimeUnit.SECONDS);
        }

    }

    public void newSingleThreadExecutor(){
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        print(singleThreadExecutor);
    }

    public void print(ExecutorService executorService){
        for (int i = 0; i < 10; i++) {
            int k = i;
            executorService.execute(new Runnable() {
                public void run() {
                    // 打印正在执行的缓存线程信息
                    System.out.println(String.format(Thread.currentThread().getName()
                            + "正在被执行, i=%d", k));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }
}
