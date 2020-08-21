package com.example.demo.model;

/**
 * 资源类
 */
public class Resource {
    /**
     * 资源个数
     */
    private static int resourceCount=0;

    /**
     * 最大资源个数
     */
    private static final int MAX_RESOURCE_COUNT=10;

    /**
     * 最小资源个数
     */
    private static final int MIN_RESOURCE_COUNT=0;



    /**
     * 增加资源
     */
    public synchronized void add(){
        //达到上限不能添加
        if(resourceCount<MAX_RESOURCE_COUNT){
            resourceCount++;
            System.out.println( "producer add resource success, producer:"+
                    Thread.currentThread().getName()+", current resource count:"+resourceCount);
        } else {
            System.out.println( "resource count can not large than 10, producer:"+
                    Thread.currentThread().getName()+", current resource count:"+resourceCount);
        }
    }

    /**
     * 移除资源
     */
    public synchronized void remove(){
        //达到下限不能移除
        if(resourceCount>MIN_RESOURCE_COUNT){
            resourceCount--;
            System.out.println( "consumer remove resource success, consumer:"+
                    Thread.currentThread().getName()+", current resource count:"+resourceCount);
        } else {
            System.out.println( "resource count can not less than 0, consumer:"+
                    Thread.currentThread().getName()+", current resource count:"+resourceCount);
        }
    }

}
