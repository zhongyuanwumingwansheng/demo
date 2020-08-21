package com.example.demo.service;

import com.example.demo.model.Resource;

/**
 * 消费者
 */
public class Consumer extends Thread{
    private Resource resource;

    public Consumer(Resource resource){
        this.resource = resource;
    }

    public void run(){
        while(true){
            try{
                Thread.sleep((long) (1000*Math.random()));

            } catch (Exception ex){
                //处理异常，这里先直接打出堆栈，实际不可取
                ex.printStackTrace();
            }
            //资源移除
            resource.remove();
        }
    }

}
