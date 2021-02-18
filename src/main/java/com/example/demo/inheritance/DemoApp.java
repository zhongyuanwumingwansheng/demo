package com.example.demo.inheritance;

import com.example.demo.model.Resource;
import com.example.demo.service.Consumer;
import com.example.demo.service.Producer;
import com.example.demo.util.NumberUtil;

public class DemoApp{
    {
        System.out.println("hello DemoApplication not static");
    }

    static {
        System.out.println("hello DemoApplication static");
    }

    public DemoApp(){
        System.out.println("hello DemoApplication");
    }

    public static void main(String[] args) {

        for(int i=0;i< args.length;i++){
            System.out.println(args[i]);
        }

        System.out.println("hello world" +
                "");
        DemoApp demoApplication = new DemoApp();

        DemoApp demoApp = new DemoApp();

        Base base = new Derived();
        base.f();
        base.g();

/*        Resource resource = new Resource();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);
        producer.start();
        consumer.start();*/

        NumberUtil.testDivision();

    }

}

class DemoAppTwo {
    static {
        System.out.println("hello DemoApp static");
    }
}
