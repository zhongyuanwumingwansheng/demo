package com.example.demo.util;

import com.example.demo.context.ThreadContext;

public class ThreadContextUtil {
    private static ThreadLocal<ThreadContext> threadLocalContext = new ThreadLocal<>();

    public static void setContext(ThreadContext threadContext){
        threadLocalContext.set(threadContext);
    }

    public static ThreadContext getContext(){
        return threadLocalContext.get();
    }

    public static void clearContext(){
        threadLocalContext.remove();
    }
}
