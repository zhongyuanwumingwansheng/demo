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

    @Test
    public void testNewScheduledThreadPool(){
        threadService.newScheduledThreadPool();
    }

    @Test
    public void testNewSingleThreadExecutor(){
        threadService.newSingleThreadExecutor();
    }
}
