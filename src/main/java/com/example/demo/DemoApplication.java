package com.example.demo;

import com.example.demo.model.Resource;
import com.example.demo.service.Consumer;
import com.example.demo.service.Producer;
import com.example.demo.util.NumberUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    {
        System.out.println("hello DemoApplication not static");
    }

    static {
        System.out.println("hello DemoApplication static");
    }

    public DemoApplication(){
        System.out.println("hello DemoApplication");
    }

    public static void main(String[] args) {

        for(int i=0;i< args.length;i++){
            System.out.println(args[i]);
        }

        //SpringApplication.run(DemoApplication.class, args);
        System.out.println("hello world" +
                "");
        DemoApplication demoApplication = new DemoApplication();

        DemoApp demoApp = new DemoApp();


       /* Resource resource = new Resource();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);
        producer.start();
        consumer.start();

        NumberUtil.testDivision();*/

    }

}

class DemoApp {
    static {
        System.out.println("hello DemoApp static");
    }
}
