package com.example.demo.service;

import org.junit.Before;
import org.junit.Test;

public class ThreadServiceTest {
    ThreadService threadService;

    @Before
    public void init(){
        threadService=new ThreadService();
    }

    @Test
    public void testNewCachedThreadPool(){
        threadService.newCachedThreadPool();
    }

    @Test
    public void testNewFixedThreadPool(){
        threadService.newFixedThreadPool();
    }

    public static void main(String[] args){
        ThreadService threadService = new ThreadService();
        //threadService.newCachedThreadPool();
        //threadService.newFixedThreadPool();
        threadService.newScheduledThreadPool();
        //threadService.newSingleThreadExecutor();
    }
}
