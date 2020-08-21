package com.example.demo.service;

import com.example.demo.model.Node;
import com.example.demo.model.Resource;
import org.junit.Before;
import org.junit.Test;
//import org.junit.jupiter.api.Test;

public class NodeServiceTest {

    private NodeService nodeService;

    @Before
    public void init(){
        nodeService = new NodeService();
    }

    @Test
    public void testReverseNodeDataList() {
        Node newNode = nodeService.reverseNodeDataList(null);
        nodeService.printNodeDataList(newNode);

        Node node1=new Node("a");
        newNode = nodeService.reverseNodeDataList(node1);
        nodeService.printNodeDataList(newNode);

        Node node2=new Node("b");
        node1.setNext(node2);
        newNode = nodeService.reverseNodeDataList(node1);
        nodeService.printNodeDataList(newNode);

        Node node3=new Node("c");
        node2.setNext(node3);
        newNode = nodeService.reverseNodeDataList(node1);
        nodeService.printNodeDataList(newNode);

        Node node4=new Node("d");
        node3.setNext(node4);
        newNode = nodeService.reverseNodeDataList(node1);
        nodeService.printNodeDataList(newNode);
    }

    @Test
    public void testProducerAndConsumer(){
            Resource resource = new Resource();
            Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);
        producer.start();
        consumer.start();
    }

    public static void main(String[] args){

        Resource resource = new Resource();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource);
        producer.start();
        consumer.start();
    }
}
