package com.example.demo.job;

import com.example.demo.model.TaskLockDO;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProcessJob implements Runnable{

    @Override
    public void run(){
        //首先进行抢锁，抢到一个可以进行处理的任务
        TaskLockDO taskLockDO = new TaskLockDO();

        //然后，线程池
        ExecutorService pool = Executors.newFixedThreadPool(100);
        ArrayList<Callable<Long>> callers = new ArrayList<>();

        //TODO,加入callers

        try {
            pool.invokeAll(callers);
            pool.shutdown();
        } catch (Exception ex) {
            throw new RuntimeException();
        }

        taskLockDO.setFinisded(Boolean.TRUE);


    }
}
