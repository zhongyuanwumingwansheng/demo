package com.example.demo.model;

/**
 * 节点定义
 */
public class Node {
    //下一个节点
    Node next;

    //当前节点值
    String data;

    public Node(){

    }

    public Node(String data){
        this.data=data;
        this.next=null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
