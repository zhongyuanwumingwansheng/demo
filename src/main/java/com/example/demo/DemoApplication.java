package com.example.demo;

import com.example.demo.model.Resource;
import com.example.demo.service.Consumer;
import com.example.demo.service.Producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        //SpringApplication.run(DemoApplication.class, args);
        System.out.println("hello world" +
                "");



        Resource resource = new Resource();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);
        producer.start();
        consumer.start();
    }

}
